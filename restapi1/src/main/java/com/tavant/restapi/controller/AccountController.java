package com.tavant.restapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tavant.restapi.exceptions.AccountNotFoundException;
import com.tavant.restapi.model.Account;

import com.tavant.restapi.repository.AccountRepository;


@RestController
@RequestMapping("/api/account")

public class AccountController {

	@Autowired 
	AccountRepository accountRepository;
	@GetMapping
	public String getAccount() {
		return "Welcome";
	}
	@GetMapping("/all") 
	public  List<Account> getAllAccount(){
		return accountRepository.findAll();
}
	@PostMapping
	public Account addAccount(@RequestBody @Valid Account account) {
		return accountRepository.save(account);
	}


	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable("id") Integer id) throws AccountNotFoundException{
		Optional<Account> optional=accountRepository.findById(id);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else
		{
			throw new AccountNotFoundException("record not found");

		}
	}
	@DeleteMapping("/{id}")
    public Map<String, Boolean> deleteOrders(@PathVariable(value = "id") Integer Id)
         throws AccountNotFoundException {
       Account account = accountRepository.findById(Id)
       .orElseThrow(() -> new AccountNotFoundException("Account not found for this id :: " + Id));
        accountRepository .delete(account);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
}
	
	
	 @PutMapping("/{id}")
	    public ResponseEntity<Account> updateOrders(@PathVariable(value = "id") Integer Id,
	         @Valid @RequestBody Account account) throws AccountNotFoundException {
	        Account account1 = accountRepository.findById(Id)
	        .orElseThrow(() -> new AccountNotFoundException("Employee not found for this id :: " +Id));
account1.setAccountname(account1.getAccountname());
account1.setAccounttype(account1.getAccounttype());
	        final Account updatedAccount= accountRepository.save(account1);
	        return ResponseEntity.ok(updatedAccount);
	    }
	
	
	
}
