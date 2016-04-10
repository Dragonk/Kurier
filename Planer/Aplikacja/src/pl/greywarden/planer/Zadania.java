package pl.greywarden.planer;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Zadania {

    private final ListaZadan zadania;

    public ListaZadan pobierzListeZadan() {
        return this.zadania;
    }

    public Zadania() {
        this.zadania = new ListaZadan();
    }
}

class ListaZadan extends LinkedList<Zadanie> {

    private Document doc;
    private Element rootElement;
    private Element zadanie;

    public Document stworzDokumentXMLzListyZadan() throws ParserConfigurationException {
        createNewDocument();
        createRootElement();

        this.stream().forEach((z) -> {
            dodajElementDoDokumentu(z);
        });

        return doc;
    }

    public int znajdzIndeksZadaniaPoIdentyfikatorze(int identyfikator) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId() == identyfikator) {
                return i;
            }
        }
        return -1;
    }

    public void wczytajListeZadanZplikuXML(File plikZrodlowy) throws Exception {
        ObslugaWczytywaniaXML obsluga = new ObslugaWczytywaniaXML(plikZrodlowy);
        this.clear();
        this.addAll(obsluga.getListaZadan());
    }

    //<editor-fold desc="Tworzenie dokumentu">
    private DocumentBuilder createBuilder() throws ParserConfigurationException {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder();
    }

    private void createNewDocument() throws ParserConfigurationException {
        this.doc = createBuilder().newDocument();
    }
    //</editor-fold>

    //<editor-fold desc="Zapis dokumentu do pliku">
    public void zapiszDoPliku(File plikDocelowy) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(stworzDokumentXMLzListyZadan());
        StreamResult result = new StreamResult(plikDocelowy);
        transformer.transform(source, result);
    }
    //</editor-fold>

    //<editor-fold desc="Tworzenie korzenia dokumentu">
    private void createRootElement() {
        this.rootElement = this.doc.createElement("zadania");
        this.doc.appendChild(this.rootElement);
    }
    //</editor-fold>

    //<editor-fold desc="Dodawanie elementów do dokumentu">
    private void dodajElementDoDokumentu(Zadanie z) {
        this.zadanie = this.doc.createElement("zadanie");
        this.zadanie.setAttribute("id", z.getId() + "");
        this.rootElement.appendChild(zadanie);

        this.dodajElementDoZadania("opis", z.getOpis());
        this.dodajElementDoZadania("wykonawca", z.getWykonawca());
        this.dodajElementDoZadania("data-rozpoczecia", z.getDataRozpoczecia());
        this.dodajElementDoZadania("data-zakonczenia", z.getDataZakonczenia());
        this.dodajElementDoZadania("czy-wykonane", z.isCzyWykonane());
    }

    private void dodajElementDoZadania(String nazwa, Object argument) {
        Element element = this.doc.createElement(nazwa);
        element.appendChild(doc.createTextNode(argument.toString()));
        this.zadanie.appendChild(element);
    }
    //</editor-fold>
}

class ObslugaWczytywaniaXML {

    private final ListaZadan lista = new ListaZadan();
    private final File plikZrodlowy;

    public ObslugaWczytywaniaXML(File plikZrodlowy) {
        this.plikZrodlowy = plikZrodlowy;
    }

    private Document stworzDokumentZpliku() throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory dbFactory
                = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(plikZrodlowy);
        doc.getDocumentElement().normalize();

        return doc;
    }

    private Zadanie stworzZadanie(Node zadanie) throws Exception {
        Zadanie z = new Zadanie();
        Element element = (Element) zadanie;

        Object id = element.getAttribute("id");
        Object opis = element.getElementsByTagName("opis").item(0);
        Object wykonawca = element.getElementsByTagName("wykonawca").item(0);
        Object dataRozpoczecia = element.getElementsByTagName("data-rozpoczecia").item(0);
        Object dataZakonczenia = element.getElementsByTagName("data-zakonczenia").item(0);
        Object czyWykonano = element.getElementsByTagName("czy-wykonane").item(0);

        z.setId(Integer.parseInt(id.toString()));
        z.setOpis(opis.toString());
        z.setWykonawca(wykonawca.toString());
        z.setDataRozpoczecia(dataRozpoczecia.toString());
        z.setDataZakonczenia(dataZakonczenia.toString());
        z.setCzyWykonane(czyWykonano.toString().equalsIgnoreCase("true"));

        return z;
    }
    
    private void dodajZadaniaDoListy() throws Exception{
        this.lista.clear();
        
        Document doc = stworzDokumentZpliku();
        
        NodeList listaZadan = doc.getElementsByTagName("zadanie");
        for(int i=0; i<listaZadan.getLength(); i++)
        {
            Node n = listaZadan.item(i);
            this.lista.add(stworzZadanie(n));
        }
    }
    
    public ListaZadan getListaZadan() throws Exception{
        dodajZadaniaDoListy();
        return this.lista;
    }

}
