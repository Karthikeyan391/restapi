package com.tavant.restapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="account")
public class Account {
	@Id
	
	private Integer accountid;
	private String accountname;
	private String accounttype;
	
}
