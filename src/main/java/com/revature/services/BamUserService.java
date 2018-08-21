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

	/**
	* Retrieves a List of all BamUsers from a database.
	* 
	*@return A List of all BamUsers from the database.
	*@author Brandon Scoggins, Batch: 1806-Jun18-Java-USF, Trainer: Wezley Singleton
	*/
	public List<BamUser> findAllUsers() {
		return bamUserRepo.findAll();
	}

	/**
	* Retrieves a BamUser from a database by their id.
	* 
	*@param id An Integer that identifies a BamUser
	*@return A BamUser from a database with a matching id.
	*@author Brandon Scoggins, Batch: 1806-Jun18-Java-USF, Trainer: Wezley Singleton
	*/
	public BamUser findUserById(Integer id) {
		return bamUserRepo.findBamUserById(id);
	}

	/**
	* Adds a new BamUser to a database and generates a unique id.
	* 
	*@param newUser The new BamUser that will be added to the database.
	*@return The BamUser that was added to the database with the generated id.
	*@author Brandon Scoggins, Batch: 1806-Jun18-Java-USF, Trainer: Wezley Singleton
	*/
	public BamUser addUser(BamUser newUser) {
		return bamUserRepo.save(newUser);
	}

	/**
	* Retrieves a BamUser from a database by their email.
	* 
	*@param user A BamUser object that at minimum contains an email field.
	*@return A complete BamUser from a database with the matching email.
	*@author Brandon Scoggins, Batch: 1806-Jun18-Java-USF, Trainer: Wezley Singleton
	*/
	public BamUser loginUser(BamUser user) {
		return bamUserRepo.findBamUserByEmail(user.getEmail());
	}

	/**
	* Updates a BamUser in a database.
	* 
	*@param updatedUser A BamUser object that contains updated information.
	*@return The updated BamUser object as it exist in the database.
	*@author Brandon Scoggins, Batch: 1806-Jun18-Java-USF, Trainer: Wezley Singleton
	*/
	public BamUser updateUser(BamUser updatedUser) {
		BamUser user = bamUserRepo.findBamUserById(updatedUser.getId());
		
		if(user == null) {
			return user;
		} else {
			return bamUserRepo.save(updatedUser);
		}
	}
}
