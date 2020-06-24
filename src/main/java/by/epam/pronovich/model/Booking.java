package by.epam.pronovich.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Booking {

    private Integer id;
    private LocalDate date;
    private BookingStatus bookingStatus;
    private Customer customer;
}
