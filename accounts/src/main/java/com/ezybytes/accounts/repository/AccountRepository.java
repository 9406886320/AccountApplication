package com.ezybytes.accounts.repository;


import com.ezybytes.accounts.entity.Accounts;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@ReadingConverter
public interface AccountRepository extends JpaRepository<Accounts, Long> {

    Optional<Accounts> findByCustomerId(Long customerId);
}
