package com.ezybytes.accounts.repository;


import com.ezybytes.accounts.entity.Accounts;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;

@ReadingConverter
public interface AccountRepository extends JpaRepository<Accounts,Long> {




}
