package shop.customers.DTOAdapter;

import shop.customers.DTODomain.AccountDTO;
import shop.customers.domain.Account;

public class AccountAdapter {

	public static Account getAccount(AccountDTO accountDTO) {
		Account account = new Account(
				accountDTO.getAccountNumber(),
				accountDTO.getUsername(),
				accountDTO.getPassword()
				);		
		return account;
	}
	
	public static AccountDTO getAccountDTO(Account account) {
		AccountDTO accountDTO = new AccountDTO(
				account.getAccountNumber(),
				account.getUsername(),
				account.getPassword()
				);		
		return accountDTO;				
	}
}
