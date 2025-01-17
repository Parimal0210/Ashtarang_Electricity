package com.ashtarang.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InvoiceDTO {

	private Date lastDate;
    private String lastDateUnit;
    private Double prevAmt;
    private Date newDate;
    private String newDateUnit;
    private Integer unitsUsedThisMonth;
    private Double amt;
    private Double discountedAmount;
    private Double totalAmount;
    private Boolean amtPaid;
    private String month;
}
