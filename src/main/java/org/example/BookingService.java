package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BookingService {

    public boolean book(String userId, String stringfrom, String stringTo) throws CantBookException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime from = LocalDateTime.parse(stringfrom, formatter);
        LocalDateTime to = LocalDateTime.parse(stringTo, formatter);

        if(checkTimeInBD(from, to)) {
            return createBook(userId,from, to);
        }
        throw new CantBookException();
    }

    public boolean checkTimeInBD(LocalDateTime from, LocalDateTime to) {
        return false;
    }

    public boolean createBook(String userId, LocalDateTime from, LocalDateTime to) {
        return false;
    }
}
