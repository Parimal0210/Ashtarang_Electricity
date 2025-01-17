package com.ashtarang.model;


import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "Invoice")
@Getter
@Setter
@ToString
public class Invoice {
	private Date lastDate;
    private String lastDateUnit;
    private Double prevAmt;
    private boolean amtPaid;
    private String month;
}
