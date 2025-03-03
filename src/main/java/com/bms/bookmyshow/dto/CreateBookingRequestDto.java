package com.bms.bookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateBookingRequestDto {
    private Long userId;
    private Long showId; // can we skipped if we have show seat id;
    private List<Long> showSeatIds;
}
