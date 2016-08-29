package pl.greywarden.planer.util.xml;

import java.io.File;
import org.junit.*;
import static org.junit.Assert.*;
import pl.greywarden.planer.util.zadanie.ListaZadan;
import pl.greywarden.planer.util.zadanie.Zadanie;

public class WczytywanieXMLTest {

    @Test
    public void wczytajListeZPlikuTest() {
        File f = new File("foo.xml");

        try {
            WczytywanieXML.wczytywanie.wczytajListeZpliku(f);
        } catch (Exception e) {
            fail("Wczytywanie z pliku się nie powiodło. Błąd: " + e.getLocalizedMessage());
        }

        assertNotNull(ListaZadan.ZADANIA);
        for (int i = 0; i < ListaZadan.ZADANIA.size(); i++) {
            Zadanie z = ListaZadan.ZADANIA.get(i);
            System.err.println("Id: " + z.getIdentyfikator());
            System.err.println("Opis: " + z.getOpis());
            System.err.println("Wykonawca: " + z.getWykonawca());
            System.err.println("Data rozpoczęcia: " + z.getDataRozpoczecia());
            System.err.println("Data zakończenia: " + z.getDataZakonczenia());
            System.err.println("Czy wykonane: " + z.isCzyWykonane());
        }
    }
}
