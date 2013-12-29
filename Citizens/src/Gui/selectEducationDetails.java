/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import DatabaseConnection.ConnectionSetup;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author shawn
 */
public class selectEducationDetails extends javax.swing.JFrame {

    /**
     * Creates new form selectEducationDetails
     */
    String table;
    String where;
    String query;
   DefaultListModel model=new DefaultListModel();
   DefaultComboBoxModel model1=new DefaultComboBoxModel();
    public selectEducationDetails() {
        query=new String("");
        table=new String("");
        where=new String("");
        initComponents();
//        jComboBox1.addItem("radhe");
  //      jComboBox1.addItem("shyam");
        fillCourse();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    final void fillCourse()
    {
        model1.addElement("none");
        Connection cn=ConnectionSetup.getConnection();
        Statement st=ConnectionSetup.getStatement(cn);
        
        ResultSet rs;
        try {
            rs = st.executeQuery("select * from last_degree");
        while(rs.next())
        {
            model1.addElement("" + rs.getString("degree_type"));
            
        }
        
        rs.close();
        st.close();
        cn.close();
        
        } catch (SQLException ex) {
            Logger.getLogger(selectWorkDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        result_lst = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(253, 241, 224));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("SELECT EDUCATION DETAILS");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(135, 11, 264, 22);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton1.setText("Illiterate");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(41, 51, 69, 23);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton2.setText("Literate");
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(41, 92, 67, 23);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Select course");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 130, 74, 15);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(250, 130, 149, 20);

        jButton1.setText("Execute");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(200, 160, 71, 23);

        result_lst.setModel(model);
        result_lst.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                result_lstValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(result_lst);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(41, 211, 414, 130);

        jButton2.setText("Store this result for futher seletion");
        getContentPane().add(jButton2);
        jButton2.setBounds(41, 347, 199, 23);

        jButton3.setText("Proceed for new query");
        getContentPane().add(jButton3);
        jButton3.setBounds(312, 347, 143, 23);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(460, 310, 100, 100);

        jPanel2.setBackground(new java.awt.Color(253, 241, 224));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(-50, -30, 580, 416);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //check if illiterate
        model.removeAllElements();
        if(jRadioButton1.isSelected())
        {
            table="Citizen join work_details on Citizen.UID=work_details.UID";
//            where="status='illiterate'";
            where="degree_id=1" ;
            query="select Citizen.UID from "+table+" where "+where +" ;";
            System.out.println(query);
        }
        else if(jRadioButton2.isSelected())
        {
            table="Citizen join work_details on Citizen.UID=work_details.UID";
            where="workDetails.status='"+jComboBox1.getSelectedItem()+"'";
            query="select Citizen.UID from "+table+" where "+where+" ;";
            System.out.println(query);
        }
        Connection cn=ConnectionSetup.getConnection();
        Statement st=ConnectionSetup.getStatement(cn);
        
        ResultSet rs;
        try {
            rs = st.executeQuery(query);
            while(rs.next())
        {
            model.addElement("" + rs.getBigDecimal("UID"));
        }
        } catch (SQLException ex) {
            Logger.getLogger(selectWorkDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        jComboBox1.getSelectedItem();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void result_lstValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_result_lstValueChanged
        // TODO add your handling code here:
        if(evt.getSource()==result_lst)
        {
            String id=result_lst.getSelectedValue().toString().trim().substring(0,12);
            System.out.println(id);
              profilePage pp=new profilePage(id.trim());
              pp.setVisible(true);
        }
    }//GEN-LAST:event_result_lstValueChanged

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
            java.util.logging.Logger.getLogger(selectEducationDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(selectEducationDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(selectEducationDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(selectEducationDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new selectEducationDetails().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList result_lst;
    // End of variables declaration//GEN-END:variables
}
