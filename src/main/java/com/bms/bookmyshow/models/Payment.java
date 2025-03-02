package com.bms.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    // PROVIDER, MODE, STATUS, LIST PAYMENT, TXN REF ID, TICKET ID, BOOKING ID;
    private String referenceNumber;
    private int amount;
    private PaymentProvider paymentProvider;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;

}
