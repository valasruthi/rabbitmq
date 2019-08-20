package com.stackroute.rabbitmqconsumer.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

//@JsonIdentityInfo is used to handle circular reference of an object by serializing the back-reference's identifier rather than serializing the complete reference.
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Employee.class)
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
