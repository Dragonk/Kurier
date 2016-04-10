/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.greywarden.planer;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;

public class ListaZadanTest {

    private final Zadania zadania = new Zadania();

    private final int idZadania1 = 1;
    private final int idZadania2 = 2;

    private void initTestingSet() {
        List<Zadanie> lista = new LinkedList<>();

        Zadanie z = new Zadanie();
        Zadanie z2 = new Zadanie();

        z.setId(idZadania1);
        z.setWykonawca("Jan Kowalski");
        z.setDataRozpoczecia("2015-06-15");
        z.setDataZakonczenia("2017-07-21");
        z.setCzyWykonane(true);
        z.setOpis("Foo");

        lista.add(z);

        z2.setId(idZadania2);
        z2.setWykonawca("Jan Banan");
        z2.setDataRozpoczecia("2013-02-15");
        z2.setDataZakonczenia("2014-02-17");
        z2.setCzyWykonane(false);
        z2.setOpis("Bar");

        lista.add(z2);

        this.zadania.pobierzListeZadan().clear();
        this.zadania.pobierzListeZadan().addAll(lista);
    }

    @Test
    public void testZapiszDoPliku() throws Exception {

        initTestingSet();

        try {
            zadania.pobierzListeZadan().zapiszDoPliku(new File("foo.xml"));
        } catch (Exception e) {
            fail("Zapis do pliku się nie powiódł. Komunikat błędu: " + e.getMessage());
        }
    }

    @Test
    public void testRozmiaru() {
        initTestingSet();

        int ileElementow = zadania.pobierzListeZadan().size();
        assertTrue(ileElementow != 0);
    }

    @Test
    public void testWyszukiwaniaIstniejacegoElementu() {
        initTestingSet();

        int indeks = zadania.pobierzListeZadan().znajdzIndeksZadaniaPoIdentyfikatorze(idZadania1);
        assertEquals(0, indeks);
    }

    @Test
    public void testWyszukiwaniaNieistniejacegoElementu() {
        initTestingSet();

        int indeks = zadania.pobierzListeZadan().znajdzIndeksZadaniaPoIdentyfikatorze(idZadania2 + 75);
        assertEquals(-1, indeks);
    }

    @Test
    public void testUsuwaniaIstniejacegoElementu() {
        initTestingSet();
        int indeks = zadania.pobierzListeZadan().znajdzIndeksZadaniaPoIdentyfikatorze(idZadania1);
        try {
            this.zadania.pobierzListeZadan().remove(indeks);
        } catch (Exception e) {
            fail("Usuwanie elementu się nie powiodło. Komunikat błędu: " + e.getMessage());
        }
    }

    @Test
    public void testUsuwaniaNieistniejacegoElementu() {
        initTestingSet();
        int indeks = zadania.pobierzListeZadan().znajdzIndeksZadaniaPoIdentyfikatorze(idZadania1 + 75);
        try {
            this.zadania.pobierzListeZadan().remove(indeks);
        } catch (Exception e) {
            assertNotNull(e);
        }
    }

    @Test
    public void testWczytywaniaZPliku() {
        try {
            zadania.pobierzListeZadan().wczytajListeZadanZplikuXML(new File("./foo.xml"));
        } catch (Exception e) {
            fail("Wczytywanie pliku się nie powiodło. Komunikat błędu: " + e.getLocalizedMessage());
        }
    }
}
