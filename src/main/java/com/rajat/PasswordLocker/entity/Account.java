package com.rajat.PasswordLocker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data	
@Table(name="account_details")
public class Account {
	@Id
	@Column(name="a_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
	@Column(name="account_name",nullable=false)
  private String accountname;
	@Column(name="user_name",nullable=false)
  private String userName;
	@Column(nullable=false)
  private String password;
	private String review;
	@Column(name="user_id",nullable=false)
	private Integer userID;
  @Override
	public String toString() {
		return "Account [id=" + id + ", accountname=" + accountname + ", userName=" + userName + ", password="
				+ password + ", review=" + review + "]";
	}
}