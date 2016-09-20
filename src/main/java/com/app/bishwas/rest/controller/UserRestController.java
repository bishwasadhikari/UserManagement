package com.app.bishwas.rest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.bishwas.domain.User;
import com.app.bishwas.service.IUserService;
import com.app.bishwas.util.ResultMap;

@RestController
public class UserRestController {
	@Autowired
	IUserService userService;


	@RequestMapping(value = "/api/getAllUsers", produces ={
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getAllUsers() {
		Map<String, Object> userJson = new ResultMap();
		
		List<User> listUsers = userService.findAllUser();
		if(listUsers.isEmpty()){
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
		}
		
		userJson.put("users", listUsers);
		return new ResponseEntity<Map<String, Object>>(userJson, HttpStatus.OK);
	}
}
