package com.hackerrank.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
//import lombok.Getter;
import lombok.NoArgsConstructor;
//import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Covid implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String country;
  private Integer active;
  private Integer death;
  private Integer recovered;
  
  
  public Covid(Long id, String country, Integer active, Integer death, Integer recovered) {
	super();
	this.id = id;
	this.country = country;
	this.active = active;
	this.death = death;
	this.recovered = recovered;
}
public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getCountry() {
    return country;
  }
  public void setCountry(String country) {
    this.country = country;
  }
  public Integer getActive() {
    return active;
  }
  public void setActive(Integer active) {
    this.active = active;
  }
  public Integer getDeath() {
    return death;
  }
  public void setDeath(Integer death) {
    this.death = death;
  }
  public Integer getRecovered() {
    return recovered;
  }
  public void setRecovered(Integer recovered) {
    this.recovered = recovered;
  }
@Override
public String toString() {
	return "Covid [id=" + id + ", country=" + country + ", active=" + active + ", death=" + death + ", recovered="
			+ recovered + "]";
}
  
  
  
}
