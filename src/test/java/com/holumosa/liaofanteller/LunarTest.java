package com.holumosa.liaofanteller;

import com.nlf.calendar.Lunar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class LunarTest {

  @Test
  void testLunar() throws ParseException {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    Date date = formatter.parse("1991-07-17");
    Lunar lunar = Lunar.fromDate(date);

    Assertions.assertEquals(1991, lunar.getYear());
    Assertions.assertEquals(6, lunar.getMonth());
    Assertions.assertEquals(6, lunar.getDay());
  }
}
