package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.BamUser;

@Repository
public interface BamUserRepository extends JpaRepository<BamUser, Integer> {

	BamUser findBamUserById(int id);
	BamUser findBamUserByEmail(String email);
}
