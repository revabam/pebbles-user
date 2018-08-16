package com.revature.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.gson.JsonObject;
import com.revature.models.BamUser;

import io.restassured.RestAssured;

public class BamUserTest {
	
	static String url = "http://localhost:8765/bam/users";
	
	@Test
	public void canGetAllUsers() {
		RestAssured.get(url).prettyPrint();
	}
	
	@Test
	public void canAddUser() {
		BamUser newUser = new BamUser(5, "Christian", "DeFaria", "cd@gmail.com", 3, 1);
		
		JsonObject json = new JsonObject();
//		json.addProperty("user", newUser.toString());
		json.addProperty("id", 5);
		json.addProperty("firstname", "Christian");
		json.addProperty("lastname", "DeFaria");
		json.addProperty("email", "cd@gmail.com");
		json.addProperty("role_id", 3);
		json.addProperty("status_id", 1);
		
		int status = RestAssured.given()
				.contentType("application/json")
				.body(json.toString())
				.post(url)
				.getStatusCode();
		
		assertEquals(201, status);
	}
	
	@Test
	public void canGetUserByEmail() {
//		BamUser newUser = new BamUser(0, "", "", "wsingleton@revature.com", 0, 0);
		
		JsonObject json = new JsonObject();
//		json.addProperty("user", newUser.toString());
		json.addProperty("id", 0);
		json.addProperty("firstname", "");
		json.addProperty("lastname", "");
		json.addProperty("email", "wsingleton@revature.com");
		json.addProperty("role_id", 0);
		json.addProperty("status_id", 0);
		
		int status = RestAssured.given()
				.contentType("application/json")
				.body(json.toString())
				.post(url+"/login")
				.getStatusCode();
		
		assertEquals(200, status);
		
	}
	
	@Test
	public void canNotGetUserByEmail() {
//		BamUser newUser = new BamUser(0, "", "", "error@gmail.com", 0, 0);
		
		JsonObject json = new JsonObject();
//		json.addProperty("user", newUser.toString());
		json.addProperty("id", 0);
		json.addProperty("firstname", "");
		json.addProperty("lastname", "");
		json.addProperty("email", "error@gmail.com");
		json.addProperty("role_id", 0);
		json.addProperty("status_id", 0);
		
		int status = RestAssured.given()
				.contentType("application/json")
				.body(json.toString())
				.post(url+"/login")
				.getStatusCode();
		
		
		assertEquals(404, status);
		
	}
	
	@Test
	public void canGetUserById() {
		BamUser testUser = new BamUser(1, "Wez", "Singleton", "wsingleton@revature.com", 2, 1);
		BamUser user = RestAssured.get(url+"/1").body().as(BamUser.class);
		
		assertEquals(testUser, user);
	}
	
	@Test
	public void canUpdateUser() {
		BamUser updatedUser = new BamUser(1, "Wez", "Singleton", "wsingleton@revature.com", 2, 1);
		
		JsonObject json = new JsonObject();
//		json.addProperty("user", updatedUser.toString());
		json.addProperty("id", 1);
		json.addProperty("firstname", "Wez");
		json.addProperty("lastname", "Singleton");
		json.addProperty("email", "wsingleton@revature.com");
		json.addProperty("role_id", 2);
		json.addProperty("status_id", 1);

		
		BamUser user = RestAssured.given()
				.contentType("application/json")
				.body(json.toString())
				.put(url)
				.as(BamUser.class);
		
		assertEquals(updatedUser, user);
	}

}
