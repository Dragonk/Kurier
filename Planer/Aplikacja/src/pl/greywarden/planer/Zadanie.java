package pl.greywarden.planer;

import lombok.*;

@Getter
@Setter
public class Zadanie {
    private int id;
    private String wykonawca;
    private String opis;
    private String dataRozpoczecia;
    private String dataZakonczenia;
    private boolean czyWykonane;
}
