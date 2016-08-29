package pl.greywarden.planer.util.zadanie;

import lombok.*;

@Getter
@Setter
public class Zadanie{
    
    private int identyfikator;
    private String opis;
    private String wykonawca;
    private String dataRozpoczecia;
    private String dataZakonczenia;
    private boolean czyWykonane;
    
}