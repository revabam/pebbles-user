package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.BamUser;

@Repository
public interface BamUserRepository extends JpaRepository<BamUser, Integer> {

	/**
	* Retrieve a BamUser from a database by their id.
	* 
	*@param  id The BamUser id to be searched for.
	*@return The BamUser with the given Id.
	*@author Brandon Scoggins, Batch: 1806-Jun18-Java-USF, Trainer: Wezley Singleton
	*/
	BamUser findBamUserById(int id);

	/**
	* Retrieve a BamUser from a database by their email.
	* 
	*@param  email The BamUser email to be searched for.
	*@return The BamUser with the given email.
	*@author Brandon Scoggins, Batch: 1806-Jun18-Java-USF, Trainer: Wezley Singleton
	*/
	BamUser findBamUserByEmail(String email);
}
