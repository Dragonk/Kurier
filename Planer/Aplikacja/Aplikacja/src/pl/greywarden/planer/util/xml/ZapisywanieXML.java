package pl.greywarden.planer.util.xml;

import java.io.*;
import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import pl.greywarden.planer.util.zadanie.ListaZadan;
import pl.greywarden.planer.util.zadanie.Zadanie;

public class ZapisywanieXML {
    
    private ZapisywanieXML() {
    }
    public static ZapisywanieXML zapiszDoXML = new ZapisywanieXML();
    private Document doc;
    
    private Document stworzDokument() {
        Element korzen = new Element("zadania");
        return new Document(korzen);
    }
    
    private void wypelnijDokumentDanymi() throws Exception {
        this.doc = stworzDokument();
        ListaZadan.ZADANIA.forEach((Zadanie z) -> {
            Element zadanie = new Element("zadanie");
            zadanie.setAttribute("id", z.getIdentyfikator() + "");
            
            Element opis = new Element("opis");
            opis.setText(z.getOpis());
            
            Element wykonawca = new Element("wykonawca");
            wykonawca.setText(z.getWykonawca());
            
            Element dataRozpoczecia = new Element("data-rozpoczecia");
            dataRozpoczecia.setText(z.getDataRozpoczecia());
            
            Element dataZakonczenia = new Element("data-zakonczenia");
            dataZakonczenia.setText(z.getDataZakonczenia());
            
            Element czyWykonane = new Element("czy-wykonane");
            czyWykonane.setText(z.isCzyWykonane() + "");
            
            zadanie.addContent(opis);
            zadanie.addContent(wykonawca);
            zadanie.addContent(dataRozpoczecia);
            zadanie.addContent(dataZakonczenia);
            zadanie.addContent(czyWykonane);
            
            this.doc.getRootElement().addContent(zadanie);
        });
    }
    
    public void zapiszDokumentDoXML(File plikDocelowy) throws Exception {
        wypelnijDokumentDanymi();
        XMLOutputter output = new XMLOutputter();
        output.setFormat(Format.getPrettyFormat());
        
        output.output(this.doc, new FileOutputStream(plikDocelowy));
    }
}
