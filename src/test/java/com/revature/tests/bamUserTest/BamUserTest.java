package com.revature.tests.bamUserTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.JsonObject;
import com.revature.Application;
import com.revature.models.BamUser;
import com.revature.tests.TestDriver;

import io.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=TestDriver.class, properties="/pebbles-user/src/test/resources/application.properties", webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes=Application.class)
public class BamUserTest extends TestDriver {

	static String url = "http://localhost:9998";

	@Test
	public void canGetAllUsers() {
		RestAssured.get(url).prettyPrint();
	}

	@Test
	public void canAddUser() {
		BamUser newUser = new BamUser(0, "Christian", "DeFaria", "cd@gmail.com", 1, 1);

		JsonObject json = new JsonObject();
		json.addProperty("user", newUser.toString());

		int status = RestAssured.given().contentType("application/json").body(newUser).post(url).getStatusCode();

		assertEquals(201, status);
	}

	@Test
	public void canGetUserByEmail() {
		BamUser newUser = new BamUser(0, "Dillon", "Qsee", "dillonq@revature.com", 2, 1);

		JsonObject json = new JsonObject();
		json.addProperty("user", newUser.toString());

		int status = RestAssured.given().contentType("application/json").body(newUser).post(url + "/login")
				.getStatusCode();

		assertEquals(200, status);

	}

	@Test
	public void canNotGetUserByEmail() {
		BamUser newUser = new BamUser(1, "Brandon", "Scoggins", "bs@gmail.com", 1, 1);

		JsonObject json = new JsonObject();
		json.addProperty("user", newUser.toString());

		int status = RestAssured.given().contentType("application/json").body(newUser).post(url + "/login")
				.getStatusCode();

		assertEquals(404, status);

	}

	@Test
	public void canGetUserById() {
		BamUser testUser = new BamUser(4, "Dillon", "Qsee", "dillonq@revature.com", 2, 1);
		BamUser user = RestAssured.get(url + "/4").body().as(BamUser.class);

		assertEquals(testUser, user);

	}

	@Test
	public void canUpdateUser() {
		BamUser updatedUser = new BamUser(4, "Dillon", "Qsee", "dillonq@revature.com", 2, 1);

		JsonObject json = new JsonObject();
		json.addProperty("user", updatedUser.toString());

		BamUser user = RestAssured.given().contentType("application/json").body(updatedUser).put(url).as(BamUser.class);

		assertEquals(updatedUser, user);
	}

}
