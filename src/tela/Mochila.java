/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import personagens.Heroi;
import world_of_zuul.Luta;

/**
 *
 * @author Usuário
 */
public class Mochila extends javax.swing.JFrame {
    
    
    private DefaultTableModel model;
    private static Heroi h;
    private Luta porrada;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private Map<Integer, ResultSet> i = new HashMap<>();
    private List<Integer> ids;
    
    /**
     * Creates new form Mochila
     */
    
    public Mochila(Heroi h) {
        
        initComponents();
        
        this.h = h;
        
        ids = new ArrayList<>();
        model = (DefaultTableModel)itens.getModel();
        try{
            Object[] rowData = new Object[5];
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jogo", "username", "password");
            st = con.createStatement();
            
            if(itens.getRowCount() == 0){
                rs = st.executeQuery("SELECT id, nome, ataque, defesa, agilidade, equipado FROM public.arma;");
                rs.next();

                do{
                    
                    rowData[0] = rs.getString("nome");
                    rowData[1] = rs.getInt("ataque");
                    rowData[2] = rs.getInt("defesa");
                    rowData[3] = rs.getInt("agilidade");   
                    rowData[4] = rs.getBoolean("equipado");
                    model.addRow(rowData);
                    
                    ids.add(rs.getInt("id"));
//                    if(rs.getBoolean("equipado")){
//                        h.setArmaIndice(itens.getRowCount());
//                    }
    
                    rs.next();
                }while(!rs.isAfterLast());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        itens = new javax.swing.JTable();
        btnEquipa = new javax.swing.JButton();
        btnDesequipa = new javax.swing.JButton();

        setTitle("Mochila");

        itens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Ataque", "Defesa", "Agilidade", "Equipado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class
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
        itens.setColumnSelectionAllowed(true);
        itens.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(itens);
        itens.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        btnEquipa.setText("Equipar");
        btnEquipa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquipaActionPerformed(evt);
            }
        });

        btnDesequipa.setText("Desequipar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDesequipa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEquipa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnEquipa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDesequipa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEquipaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquipaActionPerformed
//        if(h.isArmaEquipada()){
//            model.setValueAt(false, h.getArmaIndice() - 1, 4);
//            try {
//                st.executeQuery("UPDATE public.arma "
//                        +       "SET equipado = FALSE WHERE id = " + h.getArmaId() + ";");
//            } catch (SQLException ex) {
//                Logger.getLogger(Mochila.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        int l = itens.getSelectedRow();
//        
//        int a = (int) itens.getValueAt(l, 1);
//        int ag = (int) itens.getValueAt(l, 3);
//        
//        h.equipaArma(a, ag);
//        h.setArmaIndice(l);
//        
//        model.setValueAt(true, l, 4);
//        try {
//            st.executeQuery("UPDATE public.arma "
//                    +       "SET equipado = TRUE WHERE id = " + ids.get(l) + ";");
//        } catch (SQLException ex) {
//            Logger.getLogger(Mochila.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        porrada.setHeroi(h);
    }//GEN-LAST:event_btnEquipaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mochila.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mochila.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mochila.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mochila.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mochila(h).setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDesequipa;
    private javax.swing.JButton btnEquipa;
    private javax.swing.JTable itens;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    public Heroi getH() {
        return h;
    }

    public void setH(Heroi h) {
        this.h = h;
    }

    public void setPorrada(Luta porrada) {
        this.porrada = porrada;
    }
    
}
