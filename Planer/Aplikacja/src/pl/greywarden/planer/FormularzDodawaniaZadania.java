package pl.greywarden.planer;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormularzDodawaniaZadania extends javax.swing.JFrame {

    public FormularzDodawaniaZadania() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        wykonawca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        opis = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        data_rozpoczecia = new com.toedter.calendar.JDateChooser();
        data_zakonczenia = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        numerZadania = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dodawanie zadania");

        jLabel1.setText("Wykonawca");

        jLabel2.setText("Opis zadania");

        opis.setColumns(20);
        opis.setRows(5);
        jScrollPane1.setViewportView(opis);

        jLabel3.setText("Data rozpoczęcia");

        jLabel4.setText("Data zakończenia");

        jButton3.setText("Dodaj zadanie");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Anuluj");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        data_rozpoczecia.setDateFormatString("dd-MM-yyyy");

        data_zakonczenia.setDateFormatString("dd-MM-yyyy");

        jLabel5.setText("Numer zadania");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(wykonawca)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(36, 36, 36))
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(data_rozpoczecia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(data_zakonczenia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(numerZadania)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numerZadania, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wykonawca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(data_rozpoczecia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(data_zakonczenia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            if (walidujFormularz()) {
                OknoGlowne.getTableModel().addRow(stworzWierszTabeli());
                wstawDaneDoListy();
                this.dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.rootPane, e.getMessage(), "Błąd!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void wstawDaneDoListy() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        Zadanie z = new Zadanie();
        z.setId(Integer.parseInt(numerZadania.getText()));
        z.setOpis(opis.getText());
        z.setWykonawca(wykonawca.getText());
        z.setDataRozpoczecia(format.format(data_rozpoczecia.getDate()));
        z.setDataZakonczenia(format.format(data_zakonczenia.getDate()));
        
        OknoGlowne.getListaZadan().add(z);
    }

    private Object[] stworzWierszTabeli() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        List<Object> dane = new LinkedList<>();
        dane.add(numerZadania.getText());
        dane.add(wykonawca.getText());
        dane.add(format.format(data_rozpoczecia.getDate()));
        dane.add(format.format(data_zakonczenia.getDate()));
        dane.add(false);
        return dane.toArray();
    }

    private boolean walidujFormularz() throws Exception {
        if (numerZadania.getText().length() == 0 || numerZadania.getText() == null) {
            throw new Exception("Zadanie musi posiadać numer!");
        }
        try {
            Integer.parseInt(numerZadania.getText());
        } catch (NumberFormatException e) {
            throw new Exception("Podany numer zadania jest nieprawidłowy!");
        }
        if (wykonawca.getText().length() == 0 || wykonawca.getText() == null) {
            throw new Exception("Pole wykonawcy zadania nie może być puste!");
        }
        if (opis.getText().length() == 0 || opis.getText() == null) {
            throw new Exception("Pole opisu nie może być puste!");
        }
        if (data_rozpoczecia.getDate() == null) {
            throw new Exception("Podaj datę rozpoczęcia!");
        }
        if (data_zakonczenia.getDate() == null) {
            throw new Exception("Podaj datę zakończenia!");
        }
        if (data_rozpoczecia.getDate().after(data_zakonczenia.getDate())) {
            throw new Exception("Data rozpoczęcia musi być przed datą zakończenia!");
        }
        return true;
    }

    //<editor-fold desc="Wygenerowane pola">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser data_rozpoczecia;
    private com.toedter.calendar.JDateChooser data_zakonczenia;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField numerZadania;
    private javax.swing.JTextArea opis;
    private javax.swing.JTextField wykonawca;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}
