package com.BankingApp.BankingApplication.Service.imple;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.BankingApp.BankingApplication.Dto.AccountDto;
import com.BankingApp.BankingApplication.Entity.Account;
import com.BankingApp.BankingApplication.Repository.AccountRepository;
import com.BankingApp.BankingApplication.Service.AccountService;
import com.BankingApp.BankingApplication.mapper.AccountMapper;

@Service
public class AccountServiceImpl implements  AccountService {

	
	private AccountRepository accountRepository;
	
	
	
	
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}



 

	@Override
	public AccountDto CreateAccount(AccountDto accountDto) {

		Account account=AccountMapper.mapToAccount(accountDto);
		 Account savedAccount=accountRepository.save(account); 
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}





	@Override
	public AccountDto getAccountById(Long id) {

		Account account=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
		
		return AccountMapper.mapToAccountDto(account);
		
	}





	@Override
	public AccountDto deposit(Long id, double amount) {

		Account account=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));

		double totalbalance=account.getBalance()+amount;
		account.setBalance(totalbalance);
		
		Account savedaccount=accountRepository.save(account);
		
		
		return AccountMapper.mapToAccountDto(savedaccount);
	}





	@Override
	public AccountDto withdraw(Long id, double amount) {

		Account account=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));

		if(account.getBalance()<amount)
		{
			throw new RuntimeException("insufficient balance");
		}
		
		double totalbalance=account.getBalance()-amount;
		account.setBalance(totalbalance);
		
	   Account	savedaccount =accountRepository.save(account);
		
		
		return AccountMapper.mapToAccountDto(savedaccount);
	}





	@Override
	public List<AccountDto> getAllAccounts() {

		return accountRepository.findAll().stream().map((account)-> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
		
		 
	}





	@Override
	public void deleteAccounts(Long id) {
		Account account=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
        
		accountRepository.delete(account);
	} 

}
