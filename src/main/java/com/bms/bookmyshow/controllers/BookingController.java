package com.bms.bookmyshow.controllers;

import com.bms.bookmyshow.dto.CreateBookingRequestDto;
import com.bms.bookmyshow.dto.CreateBookingResponseDto;
import com.bms.bookmyshow.dto.ResponsStatus;
import com.bms.bookmyshow.models.Booking;
import com.bms.bookmyshow.services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public CreateBookingResponseDto createBooking(CreateBookingRequestDto requestDto){
       CreateBookingResponseDto responseDto = new CreateBookingResponseDto();

       try{
           Booking booking = bookingService.createBooking(requestDto.getUserId(),requestDto.getShowSeatIds(),requestDto.getShowId());
           responseDto.setBookingId(booking.getId());
           responseDto.setAmount(booking.getAmount());
           responseDto.setResponsStatus(ResponsStatus.SUCCESS);
       }catch (Exception e){
           responseDto.setResponsStatus(ResponsStatus.FAILURE);
       }
       return responseDto;
    }
}
