package com.ashtarang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashtarang.model.InvoiceDTO;
import com.ashtarang.model.ServerResponse;
import com.ashtarang.service.InvoiceService;

@RestController
@RequestMapping("/invoice/v1")
@CrossOrigin(value = "*")
public class InvoiceController {
	
	@Autowired
	InvoiceService invoiceService;

	@GetMapping("/getInfo")
	public ResponseEntity<String> getInfo(){
		String str  = "Hello World get INVOICE!";
		System.out.println(str);
		return ResponseEntity.status(200).body(str);
	}
	
	@GetMapping("/generateInvoice")
	public ResponseEntity<ServerResponse<InvoiceDTO>> generateInvoice(){
		ServerResponse<InvoiceDTO> res = invoiceService.generateInvoice();
		System.out.println(res);
		return ResponseEntity.status(res.getStatusCode()).body(res);
	}
	
	@PostMapping("/saveInvoice")
	public ResponseEntity<ServerResponse<String>> saveInvoice(@RequestBody InvoiceDTO invoiceDTO){
		ServerResponse<String> res = invoiceService.saveInvoice(invoiceDTO);
		System.out.println(res);
		return ResponseEntity.status(res.getStatusCode()).body(res);
	}
	
	@GetMapping("/amountPaid")
	public ResponseEntity<ServerResponse<String>> amountPaid(){
		ServerResponse<String> res = invoiceService.amountPaid();
		System.out.println(res);
		return ResponseEntity.status(res.getStatusCode()).body(res);
	}
}
