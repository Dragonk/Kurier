package pl.greywarden.planer.util.xml;

import java.io.File;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import pl.greywarden.planer.util.zadanie.*;
import java.util.*;

public class WczytywanieXML {
    
    public static WczytywanieXML wczytywanie = new WczytywanieXML();
    
    private WczytywanieXML(){}
    
    private Document stworzDokument(File plikZrodlowy) throws Exception
    {
        SAXBuilder builder = new SAXBuilder();
        return builder.build(plikZrodlowy);
    }
    
    public void wczytajListeZpliku(File plikZrodlowy) throws Exception
    {   
        ListaZadan.ZADANIA.clear();
        
        Document doc = stworzDokument(plikZrodlowy);
        
        Element korzen = doc.getRootElement();
        
        List<Element> zadania = korzen.getChildren();
        
        for(Element e:zadania)
        {
            Zadanie z = new Zadanie();
            z.setIdentyfikator(e.getAttribute("id").getIntValue());
            z.setOpis(e.getChildText("opis"));
            z.setWykonawca(e.getChildText("wykonawca"));
            z.setDataRozpoczecia(e.getChildText("data-rozpoczecia"));
            z.setDataZakonczenia(e.getChildText("data-zakonczenia"));
            z.setCzyWykonane(e.getChildText("czy-wykonane").equals("true"));
            ListaZadan.ZADANIA.add(z);
        }
    }
}
