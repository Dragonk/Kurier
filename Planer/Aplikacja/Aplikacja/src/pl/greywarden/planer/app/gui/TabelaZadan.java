package pl.greywarden.planer.app.gui;

import java.util.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import pl.greywarden.planer.util.zadanie.ListaZadan;
import pl.greywarden.planer.util.zadanie.Zadanie;

public class TabelaZadan extends javax.swing.JPanel {
    
    public TabelaZadan() {
        initComponents();
        dodajListeneraDoTabeli();
        wysrodkujZawartoscKolumn();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrzewijalny = new javax.swing.JScrollPane();
        tabelaZadan = new javax.swing.JTable();

        tabelaZadan.setAutoCreateRowSorter(true);
        tabelaZadan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identyfikator", "Wykonawca", "Data rozpoczęcia", "Data zakończenia", "Czy wykonane?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaZadan.setRowHeight(25);
        panelPrzewijalny.setViewportView(tabelaZadan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrzewijalny, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrzewijalny, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void odswiezTabele() {
        czyscTabele();
        wstawDaneDoTabeli();
    }
    
    private void wysrodkujZawartoscKolumn()
    {
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        for(int i=0; i<tabelaZadan.getColumnCount()-1; i++)
            tabelaZadan.getColumnModel().getColumn(i).setCellRenderer(center);
    }
    
    private void czyscTabele() {
        getModelTabeli().setRowCount(0);
    }
    
    private void wstawDaneDoTabeli() {
        ListaZadan.ZADANIA.stream().forEach((z) -> {
            getModelTabeli().addRow(stworzWiersz(z));
        });
    }
    
    public DefaultTableModel getModelTabeli() {
        return (DefaultTableModel) tabelaZadan.getModel();
    }
    
    public JTable getTabelaZadan() {
        return this.tabelaZadan;
    }
    
    private void dodajListeneraDoTabeli() {
        tabelaZadan.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (czyZaznaczonoWiersz()) {
                aktywujPrzyciski();
                ustawOpisNaPanelu();
            } else {
                deaktywujPrzyciski();
                OknoGlowne.panelOpisuZadania.ustawTekstNaPaneluOpisu(null);
            }
            
        });
    }
    
    private void aktywujPrzyciski() {
        PanelZarzadzaniaZadaniami.getUsun().setEnabled(true);
        PanelZarzadzaniaZadaniami.getModyfikuj().setEnabled(true);
        PanelZarzadzaniaZadaniami.getOznacz().setEnabled(true);
        
        OknoGlowne.usun.setEnabled(true);
        OknoGlowne.modyfikuj.setEnabled(true);
        OknoGlowne.oznacz.setEnabled(true);
    }
    
    private void deaktywujPrzyciski() {
        PanelZarzadzaniaZadaniami.getUsun().setEnabled(false);
        PanelZarzadzaniaZadaniami.getModyfikuj().setEnabled(false);
        PanelZarzadzaniaZadaniami.getOznacz().setEnabled(false);
        
        OknoGlowne.usun.setEnabled(false);
        OknoGlowne.modyfikuj.setEnabled(false);
        OknoGlowne.oznacz.setEnabled(false);
    }
    
    private boolean czyZaznaczonoWiersz() {
        return tabelaZadan.getSelectedRow() != -1;
    }
    
    private Object[] stworzWiersz(Zadanie z) {
        List<Object> dane = new LinkedList<>();
        dane.add(z.getIdentyfikator());
        dane.add(z.getWykonawca());
        dane.add(z.getDataRozpoczecia());
        dane.add(z.getDataZakonczenia());
        dane.add(z.isCzyWykonane());
        return dane.toArray();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane panelPrzewijalny;
    private javax.swing.JTable tabelaZadan;
    // End of variables declaration//GEN-END:variables

    private void ustawOpisNaPanelu() {
        int zaznaczonyWiersz = OknoGlowne.tabelaZadan.getTabelaZadan().getSelectedRow();
        int identyfikator = Integer.parseInt(OknoGlowne.tabelaZadan.getTabelaZadan().getValueAt(zaznaczonyWiersz, 0).toString());
        int indeksZadania = ListaZadan.ZADANIA.znajdzIndeksZadaniaPoID(identyfikator);
        
        Zadanie z = ListaZadan.ZADANIA.get(indeksZadania);
        OknoGlowne.panelOpisuZadania.ustawTekstNaPaneluOpisu(z.getOpis());
    }
}
