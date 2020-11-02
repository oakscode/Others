package com.payment.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.model.Login;
import com.payment.model.Payee;

@Repository
public interface PayeeRepository extends JpaRepository<Payee, Long> {
	
	public List<Payee> findByFromid(long id);

}
