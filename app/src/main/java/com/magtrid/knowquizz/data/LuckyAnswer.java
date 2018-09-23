package com.magtrid.knowquizz.data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LuckyAnswer {
    private boolean happy,luckyDay;

    public LuckyAnswer(boolean happy) {
        this.happy = happy;
        luckyDay = new LuckyDay().day();
    }

    public boolean isHappy() {
        return happy;
    }

    public boolean isLuckyDay() {
        return luckyDay;
    }

    private class LuckyDay
    {
        public boolean day()
        {
            Date today = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
            String auxDay = simpleDateFormat.format(today);
            int day = Integer.parseInt(auxDay);
            if (day%2 == 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
