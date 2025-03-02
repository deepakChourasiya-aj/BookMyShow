package com.bms.bookmyshow.models;

import jakarta.persistence.Entity;
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
    private Show show;
    private Seat seat;
    private ShowSeatStatus showSeatStatus;
}
