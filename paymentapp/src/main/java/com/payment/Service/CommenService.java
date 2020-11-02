package com.payment.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.Repository.AccountRepository;
import com.payment.Repository.LoginRepository;
import com.payment.Repository.PayeeRepository;
import com.payment.model.Account;
import com.payment.model.Login;
import com.payment.model.Payee;

@Service
public class CommenService {
	
	@Autowired
	LoginRepository lrepo;
	@Autowired
	AccountRepository arepo;
	@Autowired
	PayeeRepository prepo;
	
	public void newaccount(Account a, Login l) {
		
		a.setAmount(5000);
		a=arepo.save(a);
		l.setAid(a.getId());
		l.setPassword("tutorcomp");
		
	    lrepo.save(l);
	}
	public Login authenticate(Login l) throws Exception{
		
		List<Login> li = lrepo.findByEmailAndPassword(l.getEmail(),l.getPassword());
		if(li.size()==1) 
		{
			for(Login lo : li) {
				
				System.out.println(lo.toString());
				return lo;
			}
		}
		return null;
	}
public Account findByid(long id) {
		
	
	Optional<Account> a = arepo.findById(id);
	
	Account aa = a.get();
	
		return aa;
	}

public Account findBymobile(String mobile)throws Exception {
		
	Account a = arepo.findByMobile(mobile);
		return a;
	}

public Payee addPayee(Payee p) {
	return prepo.save(p);
}

public List<Payee> ListPayee(long id) {
	
	List<Payee> p = prepo.findByFromid(id);
	
	for(Payee pp : p) {
		System.out.println(pp.toString()+"-------");
	}
	
	return p;
}

public void MoneyProcess(int amt,long fromid,long toid) {
	
	
	System.out.println(fromid+"from----");
	System.out.println(toid +"toid----");
	System.out.println(amt +"amt----");
	
	Account ac = arepo.findById(fromid).get();
	Account ab = arepo.findById(toid).get();
	
	long a = ac.getAmount();
	ac.setAmount(a-amt);
	arepo.save(ac);
	
	
	long a1 = ab.getAmount();
	ab.setAmount(a1+amt);
	arepo.save(ab);
	
	
	
	
	
}
	
	

}
