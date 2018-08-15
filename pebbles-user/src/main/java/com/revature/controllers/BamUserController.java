package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

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
@RequestMapping(value="/users")
public class BamUserController {
	
	@Autowired
	BamUserService bamUserService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BamUser>> findAllUsers() {
		System.out.println("[DEBUG] - in BamUserController.findAllUsers()");
		List<BamUser> allUsers =  bamUserService.findAllUsers();
		return new ResponseEntity<List<BamUser>>(allUsers, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BamUser> findUserById(@PathVariable("id") int id) {
		System.out.println("[DEBUG] - in BamUserController.findUserById()");
		
		BamUser user = bamUserService.findUserById(id);
		
		if(user == null) {
			return new ResponseEntity<BamUser>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<BamUser>(user, HttpStatus.OK);
		}
	}

	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BamUser> addUser(@Valid @RequestBody BamUser newUser) {
		System.out.println("[DEBUG] - in BamUserController.addUser()");
		BamUser user = bamUserService.addUser(newUser);
		return new ResponseEntity<BamUser>(user, HttpStatus.CREATED);
	}

	@PostMapping(value="/login", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BamUser> loginUser(@RequestBody BamUser user) {
		System.out.println("[DEBUG] - in BamUserController.loginUser()");
		BamUser loggedUser = bamUserService.loginUser(user);

		if(loggedUser == null) {
			return new ResponseEntity<BamUser>(loggedUser, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<BamUser>(loggedUser, HttpStatus.OK);
		}
	}
	
	@PutMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BamUser> updateUser(@Valid @RequestBody BamUser updatedUser) {
		System.out.println("[DEBUG] - in BamUserController.updateUser()");
		BamUser user = bamUserService.updateUser(updatedUser);
		return new ResponseEntity<BamUser>(user, HttpStatus.OK);
	}
}
