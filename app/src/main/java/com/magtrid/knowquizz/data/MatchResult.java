package com.magtrid.knowquizz.data;


public class MatchResult extends MatchAnswer {

    public MatchResult(int edad, int lover) {
        super(edad, lover);
    }

    private String processing()
    {
        int year = getEdad();
        int lover = getLover();
        int diferencia = year - lover;
        if (diferencia < 0)
        {
            diferencia = diferencia * -1;
        }

        if (diferencia > 5 && diferencia < 9)
        {
            return "Puede que funcione";
        }
        else if (diferencia >= 0 && diferencia < 5)
        {
            return "Pareja ideal";
        }
        else
        {
            return "¿Quién tiene plata?";
        }
    }

    public String getResult()
    {
        return processing();
    }

}
