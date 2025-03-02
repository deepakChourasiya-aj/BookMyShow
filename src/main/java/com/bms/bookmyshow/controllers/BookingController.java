package com.bms.bookmyshow.controllers;

import com.bms.bookmyshow.dto.CreateBookingRequestDto;
import com.bms.bookmyshow.dto.CreateBookingResponseDto;
import com.bms.bookmyshow.services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public CreateBookingResponseDto createBooking(CreateBookingRequestDto request){
        return null;
    }
}
