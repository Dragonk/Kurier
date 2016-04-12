package pl.greywarden.planer.app.gui;

import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import pl.greywarden.planer.util.xml.WczytywanieXML;
import pl.greywarden.planer.util.xml.ZapisywanieXML;

public class OknoGlowne extends javax.swing.JFrame {

    public static boolean czyZapisano = true;
    public static boolean czyOtwartoPlik = false;
    private File plikZadan;
    private final JFileChooser oknoWyboruPliku = new JFileChooser();

    public OknoGlowne() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabelaZadan = new pl.greywarden.planer.app.gui.TabelaZadan();
        panelZarzadzania = new pl.greywarden.planer.app.gui.PanelZarzadzaniaZadaniami();
        panelOpisuZadania = new pl.greywarden.planer.app.gui.PanelOpisuZadania();
        pasekMenu = new javax.swing.JMenuBar();
        plik = new javax.swing.JMenu();
        nowy = new javax.swing.JMenuItem();
        zapisz = new javax.swing.JMenuItem();
        zapiszJako = new javax.swing.JMenuItem();
        otworz = new javax.swing.JMenuItem();
        separator = new javax.swing.JPopupMenu.Separator();
        zakoncz = new javax.swing.JMenuItem();
        edycja = new javax.swing.JMenu();
        dodaj = new javax.swing.JMenuItem();
        usun = new javax.swing.JMenuItem();
        modyfikuj = new javax.swing.JMenuItem();
        oznacz = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Planer");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        plik.setText("Plik");

        nowy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        nowy.setText("Nowy");
        nowy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nowyActionPerformed(evt);
            }
        });
        plik.add(nowy);

        zapisz.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        zapisz.setText("Zapisz");
        zapisz.setEnabled(false);
        zapisz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zapiszActionPerformed(evt);
            }
        });
        plik.add(zapisz);

        zapiszJako.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        zapiszJako.setText("Zapisz jako...");
        zapiszJako.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zapiszJakoActionPerformed(evt);
            }
        });
        plik.add(zapiszJako);

        otworz.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        otworz.setText("Otwórz");
        otworz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otworzActionPerformed(evt);
            }
        });
        plik.add(otworz);
        plik.add(separator);

        zakoncz.setText("Zakończ");
        zakoncz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zakonczActionPerformed(evt);
            }
        });
        plik.add(zakoncz);

        pasekMenu.add(plik);

        edycja.setText("Edycja");

        dodaj.setText("Dodaj zadanie");
        dodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajActionPerformed(evt);
            }
        });
        edycja.add(dodaj);

        usun.setText("Usuń zadanie");
        usun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usunActionPerformed(evt);
            }
        });
        edycja.add(usun);

        modyfikuj.setText("Modyfikuj zadanie");
        modyfikuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modyfikujActionPerformed(evt);
            }
        });
        edycja.add(modyfikuj);

        oznacz.setText("Oznacz jako wykonane/niewykonane");
        oznacz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oznaczActionPerformed(evt);
            }
        });
        edycja.add(oznacz);

        pasekMenu.add(edycja);

        setJMenuBar(pasekMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabelaZadan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelZarzadzania, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelOpisuZadania, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabelaZadan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelZarzadzania, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelOpisuZadania, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void zapiszActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zapiszActionPerformed
        try {
            ZapisywanieXML.zapiszDoXML.zapiszDokumentDoXML(plikZadan);
            czyZapisano = true;
        } catch (Exception e) {
            wyswietlKomunikatBledu("Zapis się nie powiódł!\n" + e.getMessage());
        }
    }//GEN-LAST:event_zapiszActionPerformed

    private void nowyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nowyActionPerformed
        if (czyStworzycNowyPlik()) {
            tabelaZadan.getModelTabeli().setRowCount(0);
            czyOtwartoPlik = false;
            czyZapisano = true;
            zapisz.setEnabled(false);
            this.plikZadan = null;
        }
    }//GEN-LAST:event_nowyActionPerformed

    private void otworzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otworzActionPerformed
        if (czyOtworzycPlik()) {
            if (oknoWyboruPliku.showOpenDialog(this.rootPane) == JFileChooser.APPROVE_OPTION) {
                this.plikZadan = oknoWyboruPliku.getSelectedFile();
                try {
                    WczytywanieXML.wczytywanie.wczytajListeZpliku(plikZadan);
                    czyZapisano = true;
                    czyOtwartoPlik = true;
                    zapisz.setEnabled(true);
                    tabelaZadan.odswiezTabele();
                } catch (Exception e) {
                    wyswietlKomunikatBledu("Nie można odczytać wskazanego pliku!\n" + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_otworzActionPerformed

    private void zakonczActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zakonczActionPerformed
        if (czyWyjsc()) {
            formWindowClosing(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }//GEN-LAST:event_zakonczActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (czyWyjsc()) {
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void zapiszJakoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zapiszJakoActionPerformed
        if (oknoWyboruPliku.showSaveDialog(this.rootPane) == JFileChooser.APPROVE_OPTION) {
            if (czyPlikIstnieje()) {
                if (!czyZastapicPlik()) {
                    zapiszJakoActionPerformed(null);
                }
            }
            try {
                plikZadan = oknoWyboruPliku.getSelectedFile();
                ZapisywanieXML.zapiszDoXML.zapiszDokumentDoXML(plikZadan);
                czyZapisano = true;
                czyOtwartoPlik = true;
            } catch (Exception e) {
                wyswietlKomunikatBledu("Zapis do pliku się nie powiódł!\n" + e.getMessage());
            }

        }
    }//GEN-LAST:event_zapiszJakoActionPerformed

    private void dodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajActionPerformed
        panelZarzadzania.dodaj();
    }//GEN-LAST:event_dodajActionPerformed

    private void usunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usunActionPerformed
        panelZarzadzania.usun();
    }//GEN-LAST:event_usunActionPerformed

    private void modyfikujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modyfikujActionPerformed
        panelZarzadzania.modyfikuj();
    }//GEN-LAST:event_modyfikujActionPerformed

    private void oznaczActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oznaczActionPerformed
        panelZarzadzania.oznacz();
    }//GEN-LAST:event_oznaczActionPerformed

    private boolean czyZastapicPlik() {
        return wyswietlProsbeOPotwierdzenie("Podany plik istnieje. Czy chcesz go zastąpić?") == JOptionPane.YES_OPTION;
    }

    private boolean czyPlikIstnieje() {
        return oknoWyboruPliku.getSelectedFile().exists();
    }

    private boolean czyWyjsc() {
        return czyZapisano || wyswietlProsbeOPotwierdzenie("Nie zapisano. Czy na pewno chcesz wyjść?") == JOptionPane.YES_OPTION;
    }

    private void wyswietlKomunikatBledu(String komunikat) {
        JOptionPane.showMessageDialog(this.rootPane,
                komunikat,
                "Błąd",
                JOptionPane.ERROR_MESSAGE);
    }

    private boolean czyOtworzycPlik() {
        return czyZapisano || wyswietlProsbeOPotwierdzenie("Nie zapisano. Czy otworzyć plik?") == JOptionPane.YES_OPTION;
    }

    private boolean czyStworzycNowyPlik() {
        return czyZapisano || wyswietlProsbeOPotwierdzenie("Nie zapisano. Czy chcesz stworzyć nowy plik?") == JOptionPane.YES_OPTION;
    }

    private int wyswietlProsbeOPotwierdzenie(String pytanie) {
        return JOptionPane.showOptionDialog(this.rootPane,
                pytanie,
                "Prośba o potwierdzenie",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Tak", "Nie"},
                null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem dodaj;
    private javax.swing.JMenu edycja;
    public static javax.swing.JMenuItem modyfikuj;
    private javax.swing.JMenuItem nowy;
    private javax.swing.JMenuItem otworz;
    public static javax.swing.JMenuItem oznacz;
    public static pl.greywarden.planer.app.gui.PanelOpisuZadania panelOpisuZadania;
    private pl.greywarden.planer.app.gui.PanelZarzadzaniaZadaniami panelZarzadzania;
    private javax.swing.JMenuBar pasekMenu;
    private javax.swing.JMenu plik;
    private javax.swing.JPopupMenu.Separator separator;
    public static pl.greywarden.planer.app.gui.TabelaZadan tabelaZadan;
    public static javax.swing.JMenuItem usun;
    private javax.swing.JMenuItem zakoncz;
    private javax.swing.JMenuItem zapisz;
    private javax.swing.JMenuItem zapiszJako;
    // End of variables declaration//GEN-END:variables
}
