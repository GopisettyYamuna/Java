package com.hackerrank.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerrank.api.model.Covid;

import com.hackerrank.api.repository.CovidRepository;
import com.hackerrank.api.service.CovidService;

import com.hackerrank.api.service.impl.DefaultCovidService;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ContextConfiguration
@ComponentScan("com.hackerrank.api")
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:data.sql")
@SpringBootTest(classes ={CovidControllerTest.class})
class CovidControllerTest {
  ObjectMapper om = new ObjectMapper();
  
  @Mock
  private DefaultCovidService covidService;

  @InjectMocks
  private CovidController covidController;
  
 @Test
  public void get_getAllEvent(){
    List<Covid> event = new ArrayList<>();
    event.add(new Covid(1L,"Country1", 100, 10, 90));
    event.add(new Covid(2L,"Country2", 100, 10, 90));
    when(covidService.getAllCovid()).thenReturn(event);
    assertEquals(2,covidController.getAllCovid().size());

  }
  @Test
  public void test_getEventById() throws Exception{
	  Covid event1 = new Covid(1L,"Country1", 100, 10, 90);

    Long id =1L;
    when(covidService.getCovidById(id)).thenReturn(event1);
    assertEquals(id,covidController.getCovidById(id).getId());
   
  }
}
