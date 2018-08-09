package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.BamUser;
import com.revature.repositories.BamUserRepository;

@Service
@Transactional
public class BamUserService {

	@Autowired
	BamUserRepository bamUserRepo;
	
	public List<BamUser> findAllUsers() {
		return bamUserRepo.findAll();
	}
}
