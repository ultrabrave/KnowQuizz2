package com.magtrid.knowquizz.data;

public class LuckyResult extends LuckyAnswer {
    public LuckyResult(boolean happy) {
        super(happy);
    }

    private String processingHappy()
    {
        if(isHappy())
        {
            return "Que bueno, mantente positivo! ";
        }
        else
        {
            return "Animo perro! ";
        }
    }

    private String processingDate()
    {
        if(isLuckyDay())
        {
            return "Hoy tendrás un gran día ";
        }
        else
        {
            return "Cuida tu espaldas hoy ";
        }
    }

    public String result()
    {
        return processingHappy() + processingDate();
    }
}

