package com.bms.bookmyshow.services;

import com.bms.bookmyshow.exceptions.ShowNotFoundException;
import com.bms.bookmyshow.exceptions.UserNotFoundException;
import com.bms.bookmyshow.models.Booking;
import com.bms.bookmyshow.models.Show;
import com.bms.bookmyshow.models.User;
import com.bms.bookmyshow.repositories.ShowRepository;
import com.bms.bookmyshow.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowRepository showRepository;

    public BookingService(UserRepository userRepository, ShowRepository showRepository) {
              this.userRepository = userRepository;
              this.showRepository = showRepository;
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
//        2. GET THE SHOW WITH THE GIVEN SHOWID;
            Optional<Show> optionalShow = showRepository.findById(showId);
            if(optionalShow.isEmpty()) {
                throw new ShowNotFoundException("Show with id " + showId + " not found");
            }

        return null;
    }
}
