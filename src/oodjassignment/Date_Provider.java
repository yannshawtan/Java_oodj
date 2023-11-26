package oodjassignment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/* using abstract class / interfaces to retrieve time */
/* part of assignment requirements to implement interfaces */

public interface Date_Provider {
    String getCurrentDate();
    String getCurrentTime();
    
    default String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        return date.format(formatter);
    }
    
    default String formatTime(LocalTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return time.format(formatter);
    }
}
