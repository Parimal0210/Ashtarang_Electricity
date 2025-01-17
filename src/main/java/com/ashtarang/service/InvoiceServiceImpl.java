package com.ashtarang.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashtarang.model.Invoice;
import com.ashtarang.model.InvoiceDTO;
import com.ashtarang.model.ServerResponse;
import com.ashtarang.repository.InvoiceRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InvoiceServiceImpl implements InvoiceService {
	
	@Autowired
	InvoiceRepository invoiceRepository;

	@Override
	public ServerResponse<InvoiceDTO> generateInvoice() {
		ServerResponse<InvoiceDTO> res = new ServerResponse<>();
		try {
			log.info("Generating Invoice");
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("MMMM");
			String month = sdf.format(calendar.getTime());
	        calendar.add(Calendar.MONTH, -1);
	        String prevMonth = sdf.format(calendar.getTime());
	        
	        Optional<Invoice> invOp = invoiceRepository.findByMonth(prevMonth);
	        
	        if(invOp.isPresent()) {
	        	InvoiceDTO invoiceDTO = generateInvoiceDTO(month, invOp);
	   
	        	res.setStatusCode(200);
				res.setResponse(invoiceDTO);
				res.setStatusMessage("Invoice of "+month+" generated successfully.");
	        } else {
	        	log.info("Invoice of "+prevMonth+" Not found.");
				res.setStatusCode(400);
				res.setStatusMessage("Invoice of "+prevMonth+" Not found.");
				return res;
	        }
			
		} catch (Exception e) {
			log.error("Exception while generating invoice : ",e);
		}
		return res;
	}

	private InvoiceDTO generateInvoiceDTO(String month, Optional<Invoice> invOp) {
		Invoice inv = invOp.get();
		InvoiceDTO invoiceDTO = new InvoiceDTO();
		
		invoiceDTO.setLastDate(inv.getLastDate());
		invoiceDTO.setLastDateUnit(inv.getLastDateUnit());
		invoiceDTO.setPrevAmt(inv.getPrevAmt());
		invoiceDTO.setAmtPaid(inv.isAmtPaid());
		invoiceDTO.setMonth(month);	        	
		invoiceDTO.setNewDate(new Date());
		return invoiceDTO;
	}

	@Override
	public ServerResponse<String> saveInvoice(InvoiceDTO invoiceDTO) {
		ServerResponse<String> res = new ServerResponse<>();
		try {
			log.info("Saving Invoice : {}",invoiceDTO);
			SimpleDateFormat sdf = new SimpleDateFormat("MMMM"); // "MMMM" for full month name
		    String month = sdf.format(invoiceDTO.getNewDate());
		     
			Optional<Invoice> invOp = invoiceRepository.findByMonth(month);
			
			if(invOp.isPresent()) {
				log.info("Invoice of "+month+" is already present.");
				res.setStatusCode(400);
				res.setResponse("Invoice of "+month+" is already present.");
				res.setStatusMessage("Invoice of "+month+" is already present.");
				return res;
			}
			
			//new invoice
			Invoice invoice = new Invoice();
			invoice.setLastDate(invoiceDTO.getNewDate());
			invoice.setLastDateUnit(invoiceDTO.getNewDateUnit());
			invoice.setPrevAmt(invoiceDTO.getTotalAmount());
			invoice.setMonth(month);
			invoice.setAmtPaid(true);
			
			
			invoiceRepository.save(invoice);
			log.info("Saved Invoice : {}",invoice);
			
			res.setStatusCode(200);
			res.setResponse("Invoice of "+month+" saved successfully.");
			res.setStatusMessage("Invoice of "+month+" saved successfully.");
			
		} catch (Exception e) {
			log.error("Exception while saving invoice : ",e);
		}
		return res;
	}

}
