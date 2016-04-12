package pl.greywarden.planer.app.gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import pl.greywarden.planer.util.zadanie.ListaZadan;
import pl.greywarden.planer.util.zadanie.Zadanie;

public class FormularzEdycjiZadania extends javax.swing.JFrame {

    private final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    private final Zadanie zadanie;
    
    public FormularzEdycjiZadania() {
        zadanie = pobierzZaznaczoneZadanie();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        identyfikator_opis = new javax.swing.JLabel();
        identyfikator = new javax.swing.JTextField();
        wykonawca_opis = new javax.swing.JLabel();
        wykonawca = new javax.swing.JTextField();
        dataZakonczenia = new com.toedter.calendar.JDateChooser();
        dataRozpoczecia = new com.toedter.calendar.JDateChooser();
        dataRozpoczecia_opis = new javax.swing.JLabel();
        dataZakonczenia_opis = new javax.swing.JLabel();
        opis_opis = new javax.swing.JLabel();
        panelPrzewijalny = new javax.swing.JScrollPane();
        opis = new javax.swing.JTextArea();
        dodaj = new javax.swing.JButton();
        anuluj = new javax.swing.JButton();
        czyWykonane = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        identyfikator_opis.setText("Identyfikator zadania");

        wykonawca_opis.setText("Wykonawca");

        dataZakonczenia.setDateFormatString("dd-MM-yyyy");

        dataRozpoczecia.setDateFormatString("dd-MM-yyyy");

        dataRozpoczecia_opis.setText("Data rozpoczęcia");

        dataZakonczenia_opis.setText("Data zakończenia");

        opis_opis.setText("Opis");

        opis.setColumns(20);
        opis.setLineWrap(true);
        opis.setRows(5);
        opis.setTabSize(3);
        opis.setWrapStyleWord(true);
        panelPrzewijalny.setViewportView(opis);

        dodaj.setText("Edytuj zadanie");
        dodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajActionPerformed(evt);
            }
        });

        anuluj.setText("Anuluj");
        anuluj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anulujActionPerformed(evt);
            }
        });

        czyWykonane.setText("Czy wykonane?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(identyfikator)
                    .addComponent(wykonawca)
                    .addComponent(dataRozpoczecia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dataZakonczenia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPrzewijalny, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(dodaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(anuluj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(identyfikator_opis)
                            .addComponent(wykonawca_opis)
                            .addComponent(dataZakonczenia_opis)
                            .addComponent(dataRozpoczecia_opis)
                            .addComponent(opis_opis)
                            .addComponent(czyWykonane))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(identyfikator_opis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(identyfikator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wykonawca_opis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wykonawca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataRozpoczecia_opis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataRozpoczecia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataZakonczenia_opis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataZakonczenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opis_opis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPrzewijalny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(czyWykonane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dodaj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(anuluj)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajActionPerformed
        if (walidujFormularz()) {
            try {
                edytujZadanieNaLiscie();
                OknoGlowne.tabelaZadan.odswiezTabele();
                OknoGlowne.czyZapisano = false;
                this.dispose();
            } catch (Exception e) {
                wyswietlKomunikatBledu(e.getMessage(), "Błąd");
            }
        } else {
            wyswietlKomunikatBledu("Sprawdź pola formularza!", "Błąd");
        }
    }//GEN-LAST:event_dodajActionPerformed

    private void anulujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anulujActionPerformed
        this.dispose();
    }//GEN-LAST:event_anulujActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        identyfikator.setText(zadanie.getIdentyfikator()+"");
        wykonawca.setText(zadanie.getWykonawca());
        dataRozpoczecia.setDate(parsujDate(zadanie.getDataRozpoczecia()));
        dataZakonczenia.setDate(parsujDate(zadanie.getDataZakonczenia())); 
        czyWykonane.setSelected(zadanie.isCzyWykonane());
        opis.setText(zadanie.getOpis());
    }//GEN-LAST:event_formWindowOpened

    private Zadanie pobierzZaznaczoneZadanie()
    {
        int zaznaczonyWiersz = OknoGlowne.tabelaZadan.getTabelaZadan().getSelectedRow();
        int identyfikator = Integer.parseInt(OknoGlowne.tabelaZadan.getModelTabeli().getValueAt(zaznaczonyWiersz, 0).toString());
        int indeksZadania = ListaZadan.ZADANIA.znajdzIndeksZadaniaPoID(identyfikator);
        
        return ListaZadan.ZADANIA.get(indeksZadania);
    }
    
    private void wyswietlKomunikatBledu(String komunikat, String naglowek) {
        JOptionPane.showMessageDialog(this.rootPane,
                komunikat,
                naglowek,
                JOptionPane.ERROR_MESSAGE);
    }

    private void edytujZadanieNaLiscie() throws Exception {
        this.zadanie.setIdentyfikator(Integer.parseInt(identyfikator.getText()));
        this.zadanie.setWykonawca(wykonawca.getText());
        this.zadanie.setDataRozpoczecia(format.format(dataRozpoczecia.getDate()));
        this.zadanie.setDataZakonczenia(format.format(dataZakonczenia.getDate()));
        this.zadanie.setOpis(opis.getText());
        this.zadanie.setCzyWykonane(czyWykonane.isSelected());
    }

    private Date parsujDate(String data)
    {
        int day = Integer.parseInt(data.substring(0,2));
        int month = Integer.parseInt(data.substring(3,5));
        int year = Integer.parseInt(data.substring(6,10));
        
        Calendar cal = Calendar.getInstance();
        cal.set(year, month-1, day);
        return cal.getTime();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anuluj;
    private javax.swing.JCheckBox czyWykonane;
    private com.toedter.calendar.JDateChooser dataRozpoczecia;
    private javax.swing.JLabel dataRozpoczecia_opis;
    private com.toedter.calendar.JDateChooser dataZakonczenia;
    private javax.swing.JLabel dataZakonczenia_opis;
    private javax.swing.JButton dodaj;
    private javax.swing.JTextField identyfikator;
    private javax.swing.JLabel identyfikator_opis;
    private javax.swing.JTextArea opis;
    private javax.swing.JLabel opis_opis;
    private javax.swing.JScrollPane panelPrzewijalny;
    private javax.swing.JTextField wykonawca;
    private javax.swing.JLabel wykonawca_opis;
    // End of variables declaration//GEN-END:variables

    private boolean walidujFormularz() {
        return czyIdentyfikatorPrawidlowy()
                && !czyStringPusty(wykonawca.getText())
                && czyDataPrawidlowa(dataRozpoczecia.getDate())
                && czyDataPrawidlowa(dataZakonczenia.getDate())
                && czyDataRozpoczeciaPrawidlowa()
                && !czyStringPusty(opis.getText());
    }

    private boolean czyStringPusty(String string) {
        return string.length() == 0 || string == null;
    }

    private boolean czyIdentyfikatorPrawidlowy() {
        try {
            Integer.parseInt(identyfikator.getText());
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean czyDataPrawidlowa(Date d) {
        try {
            format.format(d);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private boolean czyDataRozpoczeciaPrawidlowa() {
        return dataRozpoczecia.getDate().before(dataZakonczenia.getDate());
    }

}
