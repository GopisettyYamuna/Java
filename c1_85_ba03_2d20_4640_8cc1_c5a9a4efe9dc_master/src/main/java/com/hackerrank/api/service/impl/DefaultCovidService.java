package com.hackerrank.api.service.impl;

import com.hackerrank.api.exception.BadRequestException;
import com.hackerrank.api.exception.ElementNotFoundException;
import com.hackerrank.api.model.Covid;
import com.hackerrank.api.repository.CovidRepository;
import com.hackerrank.api.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DefaultCovidService implements CovidService {
  private final CovidRepository covidRepository;

  @Autowired
  DefaultCovidService(CovidRepository covidRepository) {
    this.covidRepository = covidRepository;
  }

  @Override
  public List<Covid> getAllCovid() {
    return covidRepository.findAll();
  }


  @Override
  public Covid createNewCovid(Covid covid) {
      if (covid.getId() != null) {
      throw new BadRequestException("The ID must not be provided when creating a new Covid");
    }

    return covidRepository.save(covid);
  }

  @Override
  public Covid getCovidById(Long id) {
   // return covidRepository.findById(id);
    return covidRepository.findById(id).orElseThrow(()->new ElementNotFoundException("scan Not found  " + id));
  }

  @Override
  public List<Covid> top5By(String by) {
	  List<Covid> allCovidData = covidRepository.findAll();

      Comparator<Covid> comparator;
      switch (by) {
          case "active":
              comparator = Comparator.comparingInt(Covid::getActive).reversed();
              break;
          case "death":
              comparator = Comparator.comparingInt(Covid::getDeath).reversed();
              break;
          case "recovered":
              comparator = Comparator.comparingInt(Covid::getRecovered).reversed();
              break;
          default:
              throw new IllegalArgumentException("Invalid attribute: " + by);
      }

      return allCovidData.stream()
              .sorted(comparator)
              .limit(5)
              .collect(Collectors.toList());
  
  }

  @Override
  public Integer totalBy(String by) {
	  List<Covid> allCovidData = covidRepository.findAll();

      int total = 0;
      for (Covid data : allCovidData) {
          switch (by) {
              case "active":
                  total += data.getActive();
                  break;
              case "death":
                  total += data.getDeath();
                  break;
              case "recovered":
                  total += data.getRecovered();
                  break;
              default:
                  throw new IllegalArgumentException("Invalid attribute: " + by);
          }
      }
      return total;
  }
  
}
