package oodjassignment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/* using abstract class / interfaces to retrieve time */
/* part of assignment requirements to implement interfaces */

public interface Date_Provider {
    String getCurrentDate();
    
    default String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        return date.format(formatter);
    }
}
