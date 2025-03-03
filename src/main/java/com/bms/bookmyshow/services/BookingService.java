package com.bms.bookmyshow.services;

import com.bms.bookmyshow.exceptions.SeatNotAvailableException;
import com.bms.bookmyshow.exceptions.ShowNotFoundException;
import com.bms.bookmyshow.exceptions.UserNotFoundException;
import com.bms.bookmyshow.models.*;
import com.bms.bookmyshow.repositories.ShowRepository;
import com.bms.bookmyshow.repositories.ShowSeatRepository;
import com.bms.bookmyshow.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;

    public BookingService(UserRepository userRepository, ShowRepository showRepository) {
              this.userRepository = userRepository;
              this.showRepository = showRepository;
              this.showSeatRepository  = showSeatRepository;
    }

//    @Transactional(isolation = Isolation.SERIALIZABLE) // getting error because of this but we need it to work with
    // transactional manner research. it..
    public Booking createBooking(Long userId, List<Long> showSeatIds, Long showId) throws UserNotFoundException, ShowNotFoundException {
        /*
            1. GET THE USER WITH GIVEN USERID;
            2. GET THE SHOW WITH THE GIVEN SHOWID;
            3. GET THE LIST OF SHOWSEATS WITH THE GIVEN IDS
            ------------ TAKE THE LOCK --------------
            4. CHECK IF THE ALL THE SEATS ARE AVAILABLE OR NOT.
            5. IF NOT THROW AN EXCEPTION.
            6. IF YES MAKR THE STATUS OF ALL THE SEATS AS BLOCKED REQ BY THE USER.
            ------------ RELEASE THE LOCK -----------
            7. SAVE THE CHANGES IN THE DB OBVIOUS THING.
            8. CREATE THE BOOKING WITH PENDING STATUS. [SAVE THE BOOKING OBJ TO DB.]
            9. RETURN THE BOOKING OBJECTS.
        */
//        1. GET THE USER WITH GIVEN USERID;
            Optional<User> userOptional = userRepository.findById(userId);
            if(userOptional.isEmpty()) {
                throw new UserNotFoundException("User with id " + userId + " not found");
            }
            User user = userOptional.get();
//        2. GET THE SHOW WITH THE GIVEN SHOWID;
            Optional<Show> optionalShow = showRepository.findById(showId);

            if(optionalShow.isEmpty()) {
                throw new ShowNotFoundException("Show with id " + showId + " not found");
            }
            Show show = optionalShow.get();

//        3. GET THE LIST OF SHOWSEATS WITH THE GIVEN IDS
            List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds); // new repository need to create.. for this.

//        4. CHECK IF THE ALL THE SEATS ARE AVAILABLE OR NOT.
            for(ShowSeat showSeat : showSeats) {
                if(!showSeat.getShow().equals(ShowSeatStatus.AVAILABLE)) {
//                    5. IF NOT THROW AN EXCEPTION.
                    throw new SeatNotAvailableException("Show with seat id : " + showSeat.getId() + " is not available");
                }
            }
//        6. IF YES MAKR THE STATUS OF ALL THE SEATS AS BLOCKED REQ BY THE USER AND SAVE IT.

            for(ShowSeat showSeat : showSeats) {
//                7. SAVE THE CHANGES IN THE DB.
                    // REASON BEHIND BLOCKING THE SEAT IS SO THAT NO 2 PERSON CAN ACCESS IT
                   // TO BOOK IT IS RESERVED FOR SOME PERIOD OF TIME FOR THE CURRENT USER.
                showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
                showSeatRepository.save(showSeat);
            }
//        8. CREATE THE BOOKING WITH PENDING STATUS. [SAVE THE BOOKING OBJ TO DB.]

           Booking booking = new Booking();
           booking.setBookingStatus(BookingStatus.PENDING);
           booking.setCreatedAt(new Date());
           booking.setUser(user);
           booking.setShow(show);
           booking.setShowSeats(showSeats);
           booking.setAmount();// calculate the price using prize calculator.. class
    }
}
