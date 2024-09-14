package com.holumosa.liaofanteller;

import com.holumosa.liaofanteller.util.JsonUtils;
import com.holumosa.liaofanteller.util.LunarUtil;
import com.nlf.calendar.Lunar;
import com.nlf.calendar.LunarTime;
import com.nlf.calendar.Solar;
import org.junit.jupiter.api.Test;

class LunarTest {

    @Test
    void testFourPillars() {
        Lunar date = new Lunar(new Solar(1991, 7, 17));

        // 時
        LunarTime lunarTime = new LunarTime(date.getYear(), date.getMonth(), date.getDay(), 15, 53, 0);
        System.out.println(lunarTime.getGanZhi());

        System.out.println(date.toFullString());
        System.out.println(date.getSolar().toFullString());

        System.out.println(JsonUtils.toJsonString(LunarUtil.getFourPillar(1991, 7, 17, 15, 53)));
    }

}
