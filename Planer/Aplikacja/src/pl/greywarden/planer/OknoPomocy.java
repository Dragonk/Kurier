package pl.greywarden.planer;

import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.tree.*;

public class OknoPomocy extends javax.swing.JFrame {

    public OknoPomocy() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane2 = new javax.swing.JSplitPane();
        jscp1 = new javax.swing.JScrollPane();
        drzewoPomocy = new javax.swing.JTree();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelHTML1 = new pl.greywarden.planer.PanelHTML();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pomoc do programu");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Pomoc");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Podstawowe informacje");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Tworzenie zadań");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Usuwanie zadań");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Zapis planu do pliku");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Otwieranie planu z pliku");
        treeNode1.add(treeNode2);
        drzewoPomocy.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        drzewoPomocy.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                drzewoPomocyValueChanged(evt);
            }
        });
        jscp1.setViewportView(drzewoPomocy);

        jSplitPane2.setLeftComponent(jscp1);

        panelHTML1.setEditable(false);
        panelHTML1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setViewportView(panelHTML1);

        jSplitPane2.setRightComponent(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void drzewoPomocyValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_drzewoPomocyValueChanged
        Object node = (DefaultMutableTreeNode)drzewoPomocy.getLastSelectedPathComponent();
        try{
            switch(node.toString().toLowerCase())
            {
                case "tworzenie zadań": this.panelHTML1.wyswietlPlik(new File("./pomoc/tworzenie.html")); break;
                case "usuwanie zadań" : this.panelHTML1.wyswietlPlik(new File("./pomoc/usuwanie.html")); break;
                case "zapis planu do pliku": this.panelHTML1.wyswietlPlik(new File("./pomoc/zapis.html")); break;
                case "otwieranie planu z pliku" : this.panelHTML1.wyswietlPlik(new File("./pomoc/otwieranie.html")); break;
                case "podstawowe informacje" : this.panelHTML1.wyswietlPlik(new File("./pomoc/podstawowe.html")); break;
                default: this.panelHTML1.wyswietlPlik(new File("./pomoc/index.html"));
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Wystąpił problem podczas wczytywania pliku pomocy!\nKomunikat błędu: "+e.getLocalizedMessage(),"Błąd",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_drzewoPomocyValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree drzewoPomocy;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JScrollPane jscp1;
    private pl.greywarden.planer.PanelHTML panelHTML1;
    // End of variables declaration//GEN-END:variables
}
