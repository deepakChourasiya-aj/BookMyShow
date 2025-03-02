package com.bms.bookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookingResponseDto {
     private Long bookingId;
     private ResponsStatus responsStatus;
     private int amount;
}
