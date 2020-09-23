package com.bserkan.controller;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bserkan.entity.User;
import com.bserkan.repository.UserRepository;

@RestController
public class SaveUser {

	private static final Logger log = LoggerFactory.getLogger(SaveUser.class);

	@Autowired
	private UserRepository repository;

	@RequestMapping("/bserkan/saveuser")
	public String save() {
		log.info("Save Users Staring...");
		String status="";
		try {
			repository.save(new User("BSerkan"));
			repository.save(new User("Bahadır"));
			repository.save(new User("Serkan"));
			status="Success";
			log.info("Save Success...");
		} catch (Exception e) {
			status="fail";
			log.info("Save fail...");
		}
		log.info("Save Users Done...");
		return status;
	}
	
	@RequestMapping("/bserkan/listuser")
	public List<String> list() {
		log.info("Listing Users...");
		List<String> list = new ArrayList<>();
			repository.findAll().forEach(x -> list.add(x.toString()));
		return list;
	}
}