package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.BamUser;
import com.revature.services.BamUserService;

@CrossOrigin
@RestController
@RequestMapping
public class BamUserController {

	@Autowired
	BamUserService bamUserService;

	private static final Logger logger = LogManager.getLogger(BamUserController.class);

	/**
	 * Retrieves a List of all BamUsers from a database.
	 *
	 * @return A List of BamUsers from a database, and a corresponding Http Status
	 *         Code in a ResponseEntity
	 * @author Brandon Scoggins, Batch: 1806-Jun18-Java-USF, Trainer: Wezley
	 *         Singleton
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BamUser>> findAllUsers() {
		logger.info("[DEBUG] - in BamUserController.findAllUsers()");
		List<BamUser> allUsers = bamUserService.findAllUsers();

		return new ResponseEntity<>(allUsers, HttpStatus.OK);
	}

	/**
	 * Retrieves a specific BamUser from a database by their id.
	 * 
	 * @param id
	 *            An id that uniquely identifies a BamUser in the database
	 * @return A BamUser matching the pathVariable id, and a corresponding Http
	 *         Status Code in a ResponseEntity
	 * @author Brandon Scoggins, Batch: 1806-Jun18-Java-USF, Trainer: Wezley
	 *         Singleton
	 */
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BamUser> findUserById(@PathVariable("id") int id) {
		logger.info("[DEBUG] - in BamUserController.findUserById()");

		BamUser user = bamUserService.findUserById(id);

		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
	}

	/**
	 * Takes a BamUser object from a request body, and persist it to a database.
	 * 
	 * @param newUser
	 *            The new BamUser to be added to the database
	 * @return The BamUser that was added to the database with its generated id, and
	 *         a corresponding Http Status Code in a ResponseEntity
	 * @author Brandon Scoggins, Batch: 1806-Jun18-Java-USF, Trainer: Wezley
	 *         Singleton
	 */
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BamUser> addUser(@Valid @RequestBody BamUser newUser) {
		logger.info("[DEBUG] - in BamUserController.addUser()");
		BamUser user = bamUserService.addUser(newUser);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	/**
	 * Uses the email property of a BamUser object from the request body to retrieve
	 * a full BamUser object from a database.
	 *
	 * @param user
	 *            A BamUser object containing at minimum an email field
	 * @return A BamUser from the database that corresponds to the unique email
	 *         found in the request body, and a corresponding Http Status Code in a
	 *         ResponseEntity
	 * @author Brandon Scoggins, Batch: 1806-Jun18-Java-USF, Trainer: Wezley
	 *         Singleton
	 */
	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BamUser> loginUser(@RequestBody BamUser user) {
		logger.info("[DEBUG] - in BamUserController.loginUser()");
		BamUser loggedUser = bamUserService.loginUser(user);

		if (loggedUser == null) {
			return new ResponseEntity<>(loggedUser, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(loggedUser, HttpStatus.OK);
		}
	}

	/**
	 * Takes a BamUser object from a request body, and updates it in a database.
	 * 
	 * @param updatedUser
	 *            An updated BamUser that is to be updated in the database
	 * @return The updated BamUser object as it exist in the database, and a
	 *         corresponding Http Status Code in a ResponseEntity
	 * @author Brandon Scoggins, Batch: 1806-Jun18-Java-USF, Trainer: Wezley
	 *         Singleton
	 */
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BamUser> updateUser(@RequestBody BamUser updatedUser) {
		logger.info("[DEBUG] - in BamUserController.updateUser()");
		BamUser user = bamUserService.updateUser(updatedUser);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
