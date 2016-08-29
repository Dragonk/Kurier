/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.greywarden.planer.app.gui;

import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import pl.greywarden.planer.util.zadanie.ListaZadan;

/**
 *
 * @author marcin
 */
public class PanelZarzadzaniaZadaniami extends javax.swing.JPanel {

    public PanelZarzadzaniaZadaniami() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dodaj = new javax.swing.JButton();
        usun = new javax.swing.JButton();
        modyfikuj = new javax.swing.JButton();
        oznacz = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder("Zarządzanie zadaniami"), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        setLayout(new java.awt.GridLayout(4, 1, 5, 5));

        dodaj.setText("Dodaj zadanie");
        dodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajActionPerformed(evt);
            }
        });
        add(dodaj);

        usun.setText("Usuń zadanie");
        usun.setEnabled(false);
        usun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usunActionPerformed(evt);
            }
        });
        add(usun);

        modyfikuj.setText("Modyfikuj zadanie");
        modyfikuj.setEnabled(false);
        modyfikuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modyfikujActionPerformed(evt);
            }
        });
        add(modyfikuj);

        oznacz.setText("Oznacz jako wykonane/niewykonane");
        oznacz.setEnabled(false);
        oznacz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oznaczActionPerformed(evt);
            }
        });
        add(oznacz);
    }// </editor-fold>//GEN-END:initComponents

    private void dodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajActionPerformed
        SwingUtilities.invokeLater(()->{
            new FormularzDodawaniaZadania().setVisible(true);
        });
    }//GEN-LAST:event_dodajActionPerformed

    public void dodaj()
    {
        dodajActionPerformed(null);
    }
    public void usun()
    {
        usunActionPerformed(null);
    }
    public void oznacz()
    {
        oznaczActionPerformed(null);
    }
    
    public void modyfikuj()
    {
        modyfikujActionPerformed(null);
    }
    
    private void usunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usunActionPerformed
        if(czyUsunac())
            usunWiersz();
    }//GEN-LAST:event_usunActionPerformed

    private void modyfikujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modyfikujActionPerformed
        SwingUtilities.invokeLater(()->{
            new FormularzEdycjiZadania().setVisible(true);
        });
    }//GEN-LAST:event_modyfikujActionPerformed

    private void oznaczActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oznaczActionPerformed
        int zaznaczonyWiersz = OknoGlowne.tabelaZadan.getTabelaZadan().getSelectedRow();
        int identyfikator = Integer.parseInt(OknoGlowne.tabelaZadan.getTabelaZadan().getValueAt(zaznaczonyWiersz, 0).toString());
        int indeksZadania = ListaZadan.ZADANIA.znajdzIndeksZadaniaPoID(identyfikator);
        
        boolean aktualnyStan = ListaZadan.ZADANIA.get(indeksZadania).isCzyWykonane();
        ListaZadan.ZADANIA.get(indeksZadania).setCzyWykonane(!aktualnyStan);
        OknoGlowne.tabelaZadan.odswiezTabele();
        OknoGlowne.czyZapisano = false;
    }//GEN-LAST:event_oznaczActionPerformed

    private boolean czyUsunac()
    {
        return wyswietlProsbeOpotwierdzenie("Czy na pewno chcesz usunąć zaznaczone zadanie?") == JOptionPane.YES_OPTION;
    }
    
    private void usunWiersz()
    {
        int zaznaczonyWiersz = OknoGlowne.tabelaZadan.getTabelaZadan().getSelectedRow();
        int identyfikator = Integer.parseInt(OknoGlowne.tabelaZadan.getTabelaZadan().getValueAt(zaznaczonyWiersz, 0).toString());
        int indeksZadania = ListaZadan.ZADANIA.znajdzIndeksZadaniaPoID(identyfikator);
        
        ListaZadan.ZADANIA.remove(indeksZadania);
        OknoGlowne.tabelaZadan.odswiezTabele();
        OknoGlowne.czyZapisano = false;
    }
    
    private int wyswietlProsbeOpotwierdzenie(String pytanie)
    {
        return JOptionPane.showOptionDialog(this.getParent(),
                pytanie,
                "Prośba o potwierdzenie",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Tak","Nie"},
                null);
    }
    
    public static JButton getUsun()
    {
        return usun;
    }
    public static JButton getModyfikuj()
    {
        return modyfikuj;
    }
    public static JButton getOznacz()
    {
        return oznacz;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dodaj;
    private static javax.swing.JButton modyfikuj;
    private static javax.swing.JButton oznacz;
    private static javax.swing.JButton usun;
    // End of variables declaration//GEN-END:variables
}
