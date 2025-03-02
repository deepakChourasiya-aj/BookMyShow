package com.bms.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel {
    // WHAT SHOULD IN SHOWSEAT,
    // THAT WILL HAVE > LIST OF SEATS, NO OF ROW, WE HAVE NOS OF SEATS IN EACH ROW,
    // TOTAL SEATS, TYPE OF SEATS ACCORDINGLY, PRICE VARIES BASED ON DIFF SEATS,
    // AVAILABLE SEATS..
    @ManyToOne
    private Show show;

    @ManyToOne
    private Seat seat;

    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
}

/*
   1              1
ShowSeat ------- Show => M:1
   M              1


Show - X, Y, Z
Seat - A1, A2, A3, .....


XA1 YA1 ZA1
XA2
XA3
XA4
XA5


    1             1
ShowSeat ------- Seat -> M:1
    M              1

 */