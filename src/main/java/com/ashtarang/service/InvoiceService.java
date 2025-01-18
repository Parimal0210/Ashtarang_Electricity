package com.ashtarang.service;

import org.springframework.stereotype.Service;

import com.ashtarang.model.InvoiceDTO;
import com.ashtarang.model.ServerResponse;

@Service
public interface InvoiceService {

	ServerResponse<InvoiceDTO> generateInvoice();

	ServerResponse<String> saveInvoice(InvoiceDTO invoiceDTO);

	ServerResponse<String> amountPaid();

}
