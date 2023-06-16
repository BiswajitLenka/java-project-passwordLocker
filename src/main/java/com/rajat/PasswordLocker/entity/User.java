package com.rajat.PasswordLocker.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name= "user_details")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(nullable=false)
  private String name;
  private String gender;
  @Column(nullable=false)
  private Date dob;
  @Column(name= "phone_number",nullable=false,unique=true)
  private String phoneNumber;
  @Column(nullable=false,unique=true)
  private String email;
  @Column(nullable=false)
  private String password;
//  @OneToMany
//  @JoinColumn(name="user_id")
//  private List<Account> accounts;

}