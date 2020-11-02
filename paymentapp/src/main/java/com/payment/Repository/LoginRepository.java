package com.payment.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{
	
	public List<Login> findByEmailAndPassword(String email,String password);


}
