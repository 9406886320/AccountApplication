package com.ezybytes.accounts.mapper;

import com.ezybytes.accounts.dto.AccountsDto;
import com.ezybytes.accounts.entity.Accounts;

public class AccountMapper {

    // Convert entity to dto
    public static AccountsDto mapToAccountsDto(Accounts accounts, AccountsDto accountsDto) {

        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }

    // convert dto to entity
    public static Accounts mapToAccount(AccountsDto accountDto, Accounts account) {

        account.setAccountNumber(accountDto.getAccountNumber());
        account.setAccountType(accountDto.getAccountType());
        account.setBranchAddress(accountDto.getBranchAddress());
        return account;

    }

}
