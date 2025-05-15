package com.ezybytes.accounts.service.impl;

import com.ezybytes.accounts.constants.AccountsConstants;
import com.ezybytes.accounts.dto.CustomerDto;
import com.ezybytes.accounts.entity.Accounts;
import com.ezybytes.accounts.entity.Customer;
import com.ezybytes.accounts.exception.CustomerAlreadyExistsException;
import com.ezybytes.accounts.mapper.CustomerMapper;
import com.ezybytes.accounts.repository.AccountRepository;
import com.ezybytes.accounts.repository.CustomerRepository;
import com.ezybytes.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountsService {

    private AccountRepository accountsRepository;
    private CustomerRepository customerRepository;


    /**
     * @param customerDto
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());

        Optional<Customer> optionalCustomer= customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        //CustomException
        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("Customer Already registered with given mobile");
        }


        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));

    }


    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;

    }
}