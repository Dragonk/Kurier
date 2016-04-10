package pl.greywarden.planer;

import javax.swing.JTextPane;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class PanelHTML extends JTextPane{
    
    public PanelHTML()
    {
        this.setEditorKit(new HTMLEditorKit());
        ustawArkuszStylow();
    }
    
    private void ustawArkuszStylow()
    {
        StyleSheet css = ((HTMLEditorKit)(this.getEditorKit())).getStyleSheet();
        css.addRule("body{background-color: rgb(255, 255, 153);}");
    }
    
    private String wczytajZawartosc(File plik) throws IOException
    {
        List<String> lines = Files.readAllLines(plik.toPath());
        StringBuilder builder = new StringBuilder();
        lines.stream().forEach(builder::append);
        return builder.toString();
    }
    
    public void wyswietlPlik(File plik) throws IOException
    {
        this.setText(wczytajZawartosc(plik));
    }
    
}
