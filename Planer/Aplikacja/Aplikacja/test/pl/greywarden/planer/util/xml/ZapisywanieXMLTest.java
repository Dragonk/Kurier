package pl.greywarden.planer.util.xml;

import java.io.File;
import org.junit.*;
import static org.junit.Assert.*;
import pl.greywarden.planer.util.zadanie.ListaZadan;
import pl.greywarden.planer.util.zadanie.Zadanie;

public class ZapisywanieXMLTest {
    
    private void initTestingDataSet()
    {
        ListaZadan.ZADANIA.clear();
        
        Zadanie z = new Zadanie();
        z.setIdentyfikator(0);
        z.setOpis("opis");
        z.setWykonawca("wykonawca");
        z.setDataRozpoczecia("2016-06-17");
        z.setDataZakonczenia("2016-06-18");
        z.setCzyWykonane(false);
        
        ListaZadan.ZADANIA.add(z);
    }
    
    @Test
    public void zapiszDokumentDoXMLTest()
    {
        initTestingDataSet();
        
        File f = new File("foo.xml");
        
        try{
            ZapisywanieXML.zapiszDoXML.zapiszDokumentDoXML(f);
        }catch(Exception e)
        {
            fail("Nie można zapisać pliku. Błąd: "+e.getLocalizedMessage());
        }
    }
}
