package com.ashtarang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
public class HomeController {

	@GetMapping("/")
	public ResponseEntity<String> getInfo(){
		String str  = "Hello Babdeee! I am here to cheer you up! Hurray!!!";
		System.out.println(str);
		return ResponseEntity.status(200).body(str);
	}
}
