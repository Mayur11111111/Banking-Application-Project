package com.BankingApp.BankingApplication.Service;

import java.util.List;

import com.BankingApp.BankingApplication.Dto.AccountDto;

public interface AccountService {

	AccountDto CreateAccount (AccountDto account);

	

	AccountDto getAccountById(Long id);
	
	 AccountDto deposit(Long id,double amount);
	 
	AccountDto withdraw(Long id,double amount);
	
	List<AccountDto> getAllAccounts();
	
	void deleteAccounts(Long id);
}
