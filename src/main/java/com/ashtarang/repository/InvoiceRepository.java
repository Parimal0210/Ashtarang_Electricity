package com.ashtarang.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ashtarang.model.Invoice;

@Repository
public interface InvoiceRepository extends MongoRepository<Invoice, String>{

	Optional<Invoice> findByMonth(String month);
}
