package com.holumosa.liaofanteller;

import com.holumosa.liaofanteller.core.destiny.config.Config;
import com.holumosa.liaofanteller.core.model.Data;
import com.holumosa.liaofanteller.core.model.Destiny;
import com.holumosa.liaofanteller.core.model.Lunar;
import com.holumosa.liaofanteller.util.LunarUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DestinyTest {

  @Test
  void testCore() {
    Data.GroundTime byIndex = Data.GroundTime.getByHour(15);
    System.out.println(byIndex.getDisplayName());

    Config destinyConfig =
        new Config(Config.ConfigType.SKY, Data.Sex.M, 1991, 6, 6, false, byIndex);

    Destiny destiny = new Destiny(destinyConfig);

    System.out.println(destiny.toJsonString());
  }

  @Test
  void testSolarLunarCore() {

    Lunar lunar = LunarUtil.solar2Lunar(1991, 7, 17).orElseThrow();

    Data.GroundTime byIndex = Data.GroundTime.getByHour(15);

    Assertions.assertEquals(6, lunar.getMonth());
    Assertions.assertEquals(6, lunar.getDay());

    Config destinyConfig =
        new Config(
            Config.ConfigType.SKY,
            Data.Sex.M,
            lunar.getYear(),
            lunar.getMonth(),
            lunar.getDay(),
            false,
            byIndex);

    Destiny destiny = new Destiny(destinyConfig);

    Assertions.assertEquals(Data.FiveElement.WOOD, destiny.getFiveElement());

    System.out.println(destiny.toJsonString());
  }
}
