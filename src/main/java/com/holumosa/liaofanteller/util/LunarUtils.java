package com.holumosa.liaofanteller.util;

import com.nlf.calendar.Lunar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LunarUtils {
    public static Lunar convertToLunar(int year, int month, int day) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date date;
        try {
            date = formatter.parse(year + "-" + month + "-" + day);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return Lunar.fromDate(date);
    }
}
