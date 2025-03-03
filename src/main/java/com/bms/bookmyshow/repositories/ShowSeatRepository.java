package com.bms.bookmyshow.repositories;

import com.bms.bookmyshow.models.ShowSeat;
import com.bms.bookmyshow.models.ShowSeatType;
import org.hibernate.query.criteria.JpaFetchParent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {
//    findAllById     // select * from show_seats where id IN (1, 2, 3, 4, 5)
//    List<ShowSeat> findAllById(List <Long> showSeatIds);

    List<ShowSeat> findAllById(Iterable<Long> showSeatIds);
//    save the seatll
    ShowSeat save(ShowSeat showSeat);
}

