package pl.greywarden.planer;

import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;

public class OknoGlowne extends javax.swing.JFrame {
    
    private boolean czyZapisano = false;
    private static final ListaZadan LISTA_ZADAN = new ListaZadan();

    public OknoGlowne() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        dodaj_zadanie = new javax.swing.JButton();
        usun_zadanie = new javax.swing.JButton();
        modyfikuj_zadanie = new javax.swing.JButton();
        oznacz_zadanie = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        opisZadania = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        plik_menu = new javax.swing.JMenu();
        nowy_plan = new javax.swing.JMenuItem();
        otworz_plan = new javax.swing.JMenuItem();
        zapisz_plan = new javax.swing.JMenuItem();
        zapisz_plan_jako = new javax.swing.JMenuItem();
        separator_plik = new javax.swing.JPopupMenu.Separator();
        zakoncz = new javax.swing.JMenuItem();
        edycja_menu = new javax.swing.JMenu();
        pomoc_menu = new javax.swing.JMenu();
        pomoc_programu = new javax.swing.JMenuItem();
        o_autorze = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Planer");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numer zadania", "Wykonawca", "Data rozpoczęcia", "Data zakończenia", "Czy wykonane?"
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
        tabela.getTableHeader().setReorderingAllowed(false);
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        tabela.getColumnModel().getColumn(0).setCellRenderer(center);

        jScrollPane1.setViewportView(tabela);
        ((ListSelectionModel)(tabela.getSelectionModel())).addListSelectionListener(
            new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    if(czyZaznaczonoZadanie())
                    ustawOpisZadania();
                }
            });

            jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder("Zarządzanie zadaniami"), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));

            dodaj_zadanie.setText("Dodaj zadanie");
            dodaj_zadanie.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    dodaj_zadanieActionPerformed(evt);
                }
            });

            usun_zadanie.setText("Usuń zadanie");
            usun_zadanie.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    usun_zadanieActionPerformed(evt);
                }
            });

            modyfikuj_zadanie.setText("Modyfikuj zadanie");

            oznacz_zadanie.setText("Oznacz jako wykonane/niewykonane");
            oznacz_zadanie.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    oznacz_zadanieActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dodaj_zadanie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(usun_zadanie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(modyfikuj_zadanie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(oznacz_zadanie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(dodaj_zadanie)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(usun_zadanie)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(modyfikuj_zadanie)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(oznacz_zadanie))
            );

            jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder("Opis zadania"), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));

            opisZadania.setEditable(false);
            opisZadania.setColumns(20);
            opisZadania.setRows(5);
            jScrollPane2.setViewportView(opisZadania);

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2)
            );

            plik_menu.setText("Plik");

            nowy_plan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
            nowy_plan.setText("Nowy plan...");
            plik_menu.add(nowy_plan);

            otworz_plan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
            otworz_plan.setText("Otwórz");
            plik_menu.add(otworz_plan);

            zapisz_plan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
            zapisz_plan.setText("Zapisz");
            plik_menu.add(zapisz_plan);

            zapisz_plan_jako.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
            zapisz_plan_jako.setText("Zapisz jako...");
            zapisz_plan_jako.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    zapisz_plan_jakoActionPerformed(evt);
                }
            });
            plik_menu.add(zapisz_plan_jako);
            plik_menu.add(separator_plik);

            zakoncz.setText("Zakończ");
            zakoncz.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    zakonczActionPerformed(evt);
                }
            });
            plik_menu.add(zakoncz);

            jMenuBar1.add(plik_menu);

            edycja_menu.setText("Edycja");
            jMenuBar1.add(edycja_menu);

            pomoc_menu.setText("Pomoc");

            pomoc_programu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
            pomoc_programu.setText("Pomoc programu");
            pomoc_programu.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    pomoc_programuActionPerformed(evt);
                }
            });
            pomoc_menu.add(pomoc_programu);

            o_autorze.setText("O autorze");
            pomoc_menu.add(o_autorze);

            jMenuBar1.add(pomoc_menu);

            setJMenuBar(jMenuBar1);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(18, 18, 18))
            );

            pack();
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

    private void zapisz_plan_jakoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zapisz_plan_jakoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zapisz_plan_jakoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(czyWyjsc())
            this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void ustawOpisZadania()
    {
        int zaznaczonyWiersz = tabela.getSelectedRow();
        int idetyfikator = Integer.parseInt(tabela.getValueAt(zaznaczonyWiersz, 0).toString());
        int indeksNaLiscie = LISTA_ZADAN.znajdzIndeksZadaniaPoIdentyfikatorze(idetyfikator);
        
        this.opisZadania.setText(LISTA_ZADAN.get(indeksNaLiscie).getOpis());
    }
    
    private void zakonczActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zakonczActionPerformed
        formWindowClosing(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_zakonczActionPerformed

    private void pomoc_programuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pomoc_programuActionPerformed
        SwingUtilities.invokeLater(()->{new OknoPomocy().setVisible(true);});
    }//GEN-LAST:event_pomoc_programuActionPerformed

    private void dodaj_zadanieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodaj_zadanieActionPerformed
        SwingUtilities.invokeLater(()->{new FormularzDodawaniaZadania().setVisible(true);});
    }//GEN-LAST:event_dodaj_zadanieActionPerformed

    private void usun_zadanieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usun_zadanieActionPerformed
        if(czyZaznaczonoZadanie())
            usunZaznaczoneZadanie();
    }//GEN-LAST:event_usun_zadanieActionPerformed

    private void oznacz_zadanieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oznacz_zadanieActionPerformed
        if(czyZaznaczonoZadanie())
            oznaczZadanie();
    }//GEN-LAST:event_oznacz_zadanieActionPerformed

    private void oznaczZadanie()
    {
        int zaznaczonyWiersz = tabela.getSelectedRow();
        int idetyfikator = Integer.parseInt(tabela.getValueAt(zaznaczonyWiersz, 0).toString());
        int indeksNaLiscie = LISTA_ZADAN.znajdzIndeksZadaniaPoIdentyfikatorze(idetyfikator);
        
        boolean aktualnyStan = LISTA_ZADAN.get(indeksNaLiscie).isCzyWykonane();
        LISTA_ZADAN.get(indeksNaLiscie).setCzyWykonane(!aktualnyStan);
        tabela.setValueAt(!(boolean)tabela.getValueAt(zaznaczonyWiersz,4), zaznaczonyWiersz, 4);
    }
    
    private boolean czyZaznaczonoZadanie()
    {
        return tabela.getSelectedRow() != -1;
    }
    
    private void usunZaznaczoneZadanie()
    {
        if(czyUsunac()){
            int zaznaczonyWiersz = tabela.getSelectedRow();
            int idetyfikator = Integer.parseInt(tabela.getValueAt(zaznaczonyWiersz, 0).toString());
            int indeksNaLiscie = LISTA_ZADAN.znajdzIndeksZadaniaPoIdentyfikatorze(idetyfikator);
            LISTA_ZADAN.remove(indeksNaLiscie);
            getTableModel().removeRow(zaznaczonyWiersz);
            opisZadania.setText(null);
        }
    }
    
    private boolean czyUsunac()
    {
        return JOptionPane.showOptionDialog(this.rootPane,
                "Czy na pewno chcesz usunąć zaznaczone zadanie?",
                "Prośba o potwierdzenie",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Tak","Nie"},
                null)==JOptionPane.YES_OPTION;
    }
    
    private boolean czyWyjsc()
    {
        return czyZapisano || JOptionPane.showOptionDialog(this.rootPane,
                "Nie zapisano. Czy na pewno chcesz wyjść?",
                "Kończenie pracy",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Tak","Nie"},
                null)==JOptionPane.YES_OPTION;
    }
    
    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.err.println("Problem z wczytaniem L&F. Komunikat błędu: " + e.getMessage());
            System.err.println("Używanie domyślnego L&F");
        } finally {
            java.awt.EventQueue.invokeLater(() -> {
                new OknoGlowne().setVisible(true);
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dodaj_zadanie;
    private javax.swing.JMenu edycja_menu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton modyfikuj_zadanie;
    private javax.swing.JMenuItem nowy_plan;
    private javax.swing.JMenuItem o_autorze;
    private javax.swing.JTextArea opisZadania;
    private javax.swing.JMenuItem otworz_plan;
    private javax.swing.JButton oznacz_zadanie;
    private javax.swing.JMenu plik_menu;
    private javax.swing.JMenu pomoc_menu;
    private javax.swing.JMenuItem pomoc_programu;
    private javax.swing.JPopupMenu.Separator separator_plik;
    private static javax.swing.JTable tabela;
    private javax.swing.JButton usun_zadanie;
    private javax.swing.JMenuItem zakoncz;
    private javax.swing.JMenuItem zapisz_plan;
    private javax.swing.JMenuItem zapisz_plan_jako;
    // End of variables declaration//GEN-END:variables

    public static DefaultTableModel getTableModel()
    {
        return (DefaultTableModel)tabela.getModel();
    }
    
    public static ListaZadan getListaZadan()
    {
        return LISTA_ZADAN;
    }
}