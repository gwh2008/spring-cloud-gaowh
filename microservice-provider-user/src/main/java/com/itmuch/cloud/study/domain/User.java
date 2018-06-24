package com.itmuch.cloud.study.domain;

import javax.persistence.*;

@Entity
@Table(name = "t_user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "t_id")
  private Long id;

  @Column(name = "t_name")
  private String name;

  @Column(name = "t_age")
  private Integer age;

  @Column(name = "t_address")
  private String address;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return this.name;
  }

  public void setUsername(String username) {
    this.name = username;
  }

  public Integer getAge() {
    return this.age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

}
