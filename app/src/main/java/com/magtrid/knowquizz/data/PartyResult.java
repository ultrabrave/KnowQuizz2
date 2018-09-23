package com.magtrid.knowquizz.data;

public class PartyResult extends PartyAnswer {
    public PartyResult(String answer) {
        super(answer);
    }

    private String processing()
    {
        String answer = getAnswer();
        if (answer.contains("5"))
        {
            return "Polluelo";
        }
        else if (answer.contains("10"))
        {
            return "Normalito";
        }
        else
        {
            return "Espartano!";
        }
    }

    public String getResult()
    {
        return processing();
    }
}
