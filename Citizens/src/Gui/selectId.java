/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import DatabaseConnection.ConnectionSetup;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
/**
 *
 * @author shawn
 */
public class selectId extends javax.swing.JFrame {

    /**
     * Creates new form selectId
     */
    String select;
    String table;
    String where;
    String query;
    
    DefaultListModel model=new DefaultListModel();
    public selectId() {
        query=new String("");
        table=new String("");
        where=new String("");
        select=new String("");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        result_lst = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("SELECT ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(247, 11, 94, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Choose ID:-");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(34, 51, 84, 17);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "UID", "Ration ID", "PAN ID", "Passport No.", "Driving license No.", "Vehicle No." }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(226, 51, 150, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Enter Value:-");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(34, 89, 91, 17);

        jButton1.setText("Execute");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(230, 190, 71, 23);

        result_lst.setModel(model);
        result_lst.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                result_lstValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(result_lst);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(34, 267, 513, 130);

        jButton2.setText("Store this result for more queries");
        getContentPane().add(jButton2);
        jButton2.setBounds(34, 403, 191, 23);

        jButton3.setText("Proceed for new query");
        getContentPane().add(jButton3);
        jButton3.setBounds(396, 403, 143, 23);

        jLabel4.setText("MAX");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(226, 92, 21, 14);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(260, 89, 116, 20);

        jLabel5.setText("MIN");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(226, 130, 19, 14);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(260, 127, 116, 20);

        jRadioButton1.setText("include");
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(416, 106, 59, 23);

        jPanel1.setBackground(new java.awt.Color(253, 241, 224));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-20, -50, 660, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        table="";
        select="";
        where="";
        
        model.removeAllElements();
        
        if(!jComboBox1.getSelectedItem().equals("None"))
        {
            if(jComboBox1.getSelectedItem().equals("UID"))
            {
                if((!jTextField1.getText().equals(""))&&(!jTextField2.getText().equals(""))&&jRadioButton1.isSelected())
                {
                    where+="Citizen.UID<="+jTextField1.getText()+" AND Citizen.UID>="+jTextField2.getText();
                }
                else if((!jTextField1.getText().equals(""))&&(!jTextField2.getText().equals(""))&&!jRadioButton1.isSelected())
                {
                    where+="Citizen.UID<"+jTextField2.getText()+" OR Citizen.UID>"+jTextField1.getText();
                }
                table="Citizen";
                select="Citizen.UID";
            }
            else if(jComboBox1.getSelectedItem().equals("Ration ID"))
            {
                if((!jTextField1.getText().equals(""))&&(!jTextField2.getText().equals(""))&&jRadioButton1.isSelected())
                {
                    where+="ID.Ration_ID<="+jTextField1.getText()+" AND ID.Ration_ID>="+jTextField2.getText();
                }
                else if((!jTextField1.getText().equals(""))&&(!jTextField2.getText().equals(""))&&!jRadioButton1.isSelected())
                {
                    where+="ID.Ration_ID<"+jTextField2.getText()+" OR ID.Ration_ID>"+jTextField1.getText();
                }
                table="ID";
                select="ID.UID";
            }
            else if(jComboBox1.getSelectedItem().equals("PAN ID"))
            {
                if((!jTextField1.getText().equals(""))&&(!jTextField2.getText().equals(""))&&jRadioButton1.isSelected())
                {
                    where+="ID.PAN_ID<='"+jTextField1.getText()+"' AND ID.PAN_ID>='"+jTextField2.getText() +"'";
                }
                else if((!jTextField1.getText().equals(""))&&(!jTextField2.getText().equals(""))&&!jRadioButton1.isSelected())
                {
                    where+="ID.PAN_ID<'"+jTextField2.getText()+"' OR ID.PAN_ID>'"+jTextField1.getText()+ "'";
                }
                table="ID";
                select="ID.UID";
            }
            else if(jComboBox1.getSelectedItem().equals("Passport Number"))
            {
                if((!jTextField1.getText().equals(""))&&(!jTextField2.getText().equals(""))&&jRadioButton1.isSelected())
                {
                    where+="ID.Passport_NO<='"+jTextField1.getText()+"' AND ID.Passport_NO>='"+jTextField2.getText()+"'";
                }
                else if((!jTextField1.getText().equals(""))&&(!jTextField2.getText().equals(""))&&!jRadioButton1.isSelected())
                {
                    where+="ID.Passport_NO<'"+jTextField2.getText()+"' OR ID.Passport_NO>'"+jTextField1.getText()+"'";
                }
                table="ID";
                select="ID.UID";
            }
            else if(jComboBox1.getSelectedItem().equals("Vehicle No."))
            {
                if((!jTextField1.getText().equals(""))&&(!jTextField2.getText().equals(""))&&jRadioButton1.isSelected())
                {
                    where+="vehicle.vehicle_ID<='"+jTextField1.getText()+"' AND vehicle.vehicle_ID>='"+jTextField2.getText() +"'";
                }
                else if((!jTextField1.getText().equals(""))&&(!jTextField2.getText().equals(""))&&!jRadioButton1.isSelected())
                {
                    where+="vehicle.Passport_NO<'"+jTextField2.getText()+"' OR vehicle.Passport_NO>'"+jTextField1.getText() + "'";
                }
                table="ID join vehicle on ID.UID=vehicle.Owner_UID";
                select="ID.UID";
            }
            else if(jComboBox1.getSelectedItem().equals("Driving license No."))
            {
                if((!jTextField1.getText().equals(""))&&(!jTextField2.getText().equals(""))&&jRadioButton1.isSelected())
                {
                    where+="DL_NOS.DL_NO<='"+jTextField1.getText()+"' AND DL_NOS.DL_NO>='"+jTextField2.getText()+ "'";
                }
                else if((!jTextField1.getText().equals(""))&&(!jTextField2.getText().equals(""))&&!jRadioButton1.isSelected())
                {
                    where+="DL_NOS.DL_NO<'"+jTextField2.getText()+"' OR DL_NOS.DL_NO>'"+jTextField1.getText()+ "'";
                }
                table="ID join DL_NOS on ID.UID=DL_NOS.UID";
                select="ID.UID";
            }
           
        }
        query="select "+select +" from "+table+" where "+where+" ;";
         if(jComboBox1.getSelectedItem().equals("None"))
            {
                query="select distinct UID from id";
            }
        
        Connection cn=ConnectionSetup.getConnection();
        Statement st=ConnectionSetup.getStatement(cn);
        try {
            
            if(SelectPage.state==1)
            {
                String q1=SelectPage.imp;
                query=query + " UNION " + q1;
            }
            else if(SelectPage.state==2)
            {
                String q1=SelectPage.imp;
                query=query + " INTERSECT " + q1;
            }
            else if(SelectPage.state==3)
            {
                String q1=SelectPage.imp;
                query=query + " EXCEPT " + q1;
            }
            
            
            ResultSet rs=st.executeQuery(query);
            while(rs.next())
            {
                rs.getBigDecimal("UID");
                model.addElement(rs.getBigDecimal("UID").toString());
            }
                 
            
            
        } catch (SQLException ex) {
            Logger.getLogger(selectId.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(query);
        SelectPage.imp=query;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(selectId.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(selectId.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(selectId.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(selectId.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new selectId().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JList result_lst;
    // End of variables declaration//GEN-END:variables
}
