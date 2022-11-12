package org.example.model;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Room {
    private List<BookingRange> dates;

    public List<BookingRange> getDates() {
        return dates.stream().sorted(Comparator.comparingInt(a -> a.getStartDay())).collect(Collectors.toList());
    }

    public void setDates(List<BookingRange> dates) {
        this.dates = dates;
    }
}
