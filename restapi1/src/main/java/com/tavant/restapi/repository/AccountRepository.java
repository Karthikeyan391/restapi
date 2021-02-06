package com.tavant.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tavant.restapi.model.Account;

@Repository

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
