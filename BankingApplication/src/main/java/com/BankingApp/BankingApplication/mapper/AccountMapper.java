package com.BankingApp.BankingApplication.mapper;

import com.BankingApp.BankingApplication.Dto.AccountDto;
import com.BankingApp.BankingApplication.Entity.Account;

public class AccountMapper {
    
	public static Account mapToAccount(AccountDto accountDto)
	{
		Account account=new Account(
				
				
			accountDto.getAccountHoldername(),
			accountDto.getId(),
			accountDto.getBalance()
				
				
					
				);
		return account;
	}
	
	public static AccountDto mapToAccountDto(Account account)
	{
		AccountDto accountDto=new AccountDto(
				
				account.getId(), 
			    account.getAccountHoldername(),
			    account.getBalance()
				
	
				
				);
		return accountDto;
		
		
		
	}
	
	
}
