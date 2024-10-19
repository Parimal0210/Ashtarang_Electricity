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
@RequestMapping("/invoice/v1")
@CrossOrigin(value = "*")
public class InvoiceController {

	@GetMapping("/getInfo")
	public ResponseEntity<String> getInfo(){
		String str  = "Hello World get INVOICE!";
		System.out.println(str);
		return ResponseEntity.status(200).body(str);
	}
}
