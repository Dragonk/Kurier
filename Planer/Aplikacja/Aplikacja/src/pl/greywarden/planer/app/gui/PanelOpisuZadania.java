package pl.greywarden.planer.app.gui;

public class PanelOpisuZadania extends javax.swing.JPanel {

    
    public PanelOpisuZadania() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrzewijania = new javax.swing.JScrollPane();
        opisZadania = new javax.swing.JTextArea();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder("Opis zadania"), javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        opisZadania.setEditable(false);
        opisZadania.setColumns(20);
        opisZadania.setLineWrap(true);
        opisZadania.setRows(5);
        opisZadania.setWrapStyleWord(true);
        opisZadania.setMargin(new java.awt.Insets(10, 10, 10, 10));
        panelPrzewijania.setViewportView(opisZadania);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrzewijania, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrzewijania, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void ustawTekstNaPaneluOpisu(String tekst)
    {
        opisZadania.setText(tekst);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea opisZadania;
    private javax.swing.JScrollPane panelPrzewijania;
    // End of variables declaration//GEN-END:variables
}
