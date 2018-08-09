package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	public ResponseEntity<List<BamUser>> findAllUsers() {
		System.out.println("[DEBUG] - in BamUserController.findAllUsers()");
		List<BamUser> allUsers =  bamUserService.findAllUsers();
		return new ResponseEntity<List<BamUser>>(allUsers, HttpStatus.OK);
	}

}
