package com.stackroute.rabbitproducer.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Employee.class)
@Component
public class Employee {
  private String EName;
  private String EId;

  public String getEName() {
    return EName;
  }

  public void setEName(String EName) {
    this.EName = EName;
  }

  public String getEId() {
    return EId;
  }

  public void setEId(String EId) {
    this.EId = EId;
  }

  @Override
  public String toString() {
    return "Employee{" +
      "EName='" + EName + '\'' +
      ", EId='" + EId + '\'' +
      '}';
  }
}
