package com.bms.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    private String bookingNumber;

    @ManyToOne
    private User user;

    @ManyToOne
    private Show show;

    @ManyToMany
    private List<ShowSeat> showSeats;

    private int amount;

    @OneToMany
    private List<Payment> payments;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

}

/**
 *
 * CARDINALITIES OKK
 *     1      --->    1
 *   BOOKING ------ USER => M : 1 MANY TO ONE RELATION. LEFT SIDE WOULD THE MAIN CLASS THEN RIGHT SIDE WOULD BE RELATIONAL CLASS .
 *     m      <----  1
 *
 *
 *     1           1
 *   BOOKING   SHOW => M : 1 ONE SHOW CAN HAVE MANY BOOKINGS.
 *     M           1
 *
 *      1          M
 *   BOOKING     SHOWSEAT => M : M
 *      M          1
 *
 *      1          M
 *    BOOKINGS  PAYMENT =>  1 : M
 *      1          1
 */