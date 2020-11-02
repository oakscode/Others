package com.payment.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.model.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	public Account findByMobile(String mobile);

}
