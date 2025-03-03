package com.bms.bookmyshow.services;

import com.bms.bookmyshow.models.SeatType;
import com.bms.bookmyshow.models.Show;
import com.bms.bookmyshow.models.ShowSeat;
import com.bms.bookmyshow.models.ShowSeatType;
import com.bms.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculator {
    ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculator(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public int calculatePrice(Show show, List<ShowSeat> showSeats) {
        int amount = 0;
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);
        for(ShowSeat showSeat : showSeats) {
            for(ShowSeatType showSeatType : showSeatTypes) {
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())) {
                    amount+= showSeatType.getPrice();
                    break;
                }
            }
        }
        return  amount;
    }

}
