package com.BankingApp.BankingApplication.Controller;

import java.util.List;
import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BankingApp.BankingApplication.Dto.AccountDto;
import com.BankingApp.BankingApplication.Service.AccountService;

@RestController

@RequestMapping("/api/accounts")
public class AccountController {

	private AccountService accountService;
	
	@PostMapping()
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto)
	{
		System.out.println(accountDto.toString());
		return new ResponseEntity<>(accountService.CreateAccount(accountDto),HttpStatus.CREATED);

	}

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id)
	{
       AccountDto accountDto=accountService.getAccountById(id);
      
       return ResponseEntity.ok(accountDto);
	}
	
	
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable Long id,@RequestBody Map<String,Double> request)
	{
		Double amount=request.get("amount");
	  AccountDto accountDto =accountService.deposit(id, amount);
	  
		return ResponseEntity.ok(accountDto);
	}
	
	
	@PutMapping("/{id}/withdraw")

	public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String,Double> request)
	{
		Double amount=request.get("amount");
		  AccountDto accountDto =accountService.withdraw(id, amount);
		  
			return ResponseEntity.ok(accountDto);
	}
	
	
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAllAccounts()
	{
		List<AccountDto> accountDto=accountService.getAllAccounts();
		return ResponseEntity.ok(accountDto);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccounts(@PathVariable Long id)
	{
		accountService.deleteAccounts(id);
		return ResponseEntity.ok("account deleted");
	}
	
}
