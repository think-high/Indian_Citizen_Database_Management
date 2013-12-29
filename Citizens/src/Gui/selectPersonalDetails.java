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
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
//import java.sql.Date;

/**
 *
 * @author shawn
 */
public class selectPersonalDetails extends javax.swing.JFrame {

    /**
     * Creates new form selectPersonalDetails
     */
    String table;
    String where;
    String query;
    DefaultComboBoxModel model1=new DefaultComboBoxModel();
    DefaultListModel model=new DefaultListModel();
    
    
    
    public selectPersonalDetails() {
        query=new String("");
        table=new String("");
        where=new String("");
        initComponents();
        fillDisable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    final void fillDisable()
    {
        model1.addElement("none");
        Connection cn=ConnectionSetup.getConnection();
        Statement st=ConnectionSetup.getStatement(cn);
        
        ResultSet rs;
        try {
            rs = st.executeQuery("select * from ph_details");
        while(rs.next())
        {
            model1.addElement("" + rs.getString("Name"));
            
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        result_lst = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(551, 674));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("SELECT PERSONAL DETAILS");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 10, 251, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("NAME:-");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(43, 51, 53, 17);

        jLabel3.setText("First name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(200, 54, 50, 14);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(317, 51, 177, 20);

        jLabel4.setText("Middle name");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(200, 82, 59, 14);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(317, 82, 177, 20);

        jLabel5.setText("Last name");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(200, 120, 49, 14);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(317, 120, 177, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("AGE:-");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(43, 158, 40, 17);

        jLabel7.setText("Min");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(200, 161, 16, 14);

        jLabel8.setText("Max");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(200, 199, 20, 14);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(317, 158, 77, 20);
        getContentPane().add(jTextField5);
        jTextField5.setBounds(317, 196, 77, 20);

        jRadioButton1.setText("include");
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(423, 175, 59, 23);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Disability:-");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(43, 231, 71, 17);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(200, 234, 165, 20);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Phone no.:-");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(43, 275, 81, 17);

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField6);
        jTextField6.setBounds(200, 272, 165, 20);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Gender:-");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(43, 323, 61, 17);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Male");
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(200, 322, 47, 23);

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Female");
        getContentPane().add(jRadioButton3);
        jRadioButton3.setBounds(285, 322, 59, 23);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Category:-");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(43, 364, 75, 17);

        jCheckBox1.setText("General");
        getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(200, 363, 63, 23);

        jCheckBox2.setText("OBC");
        getContentPane().add(jCheckBox2);
        jCheckBox2.setBounds(285, 363, 47, 23);

        jCheckBox3.setText("SC");
        getContentPane().add(jCheckBox3);
        jCheckBox3.setBounds(200, 404, 39, 23);

        jCheckBox4.setText("ST");
        getContentPane().add(jCheckBox4);
        jCheckBox4.setBounds(285, 404, 37, 23);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Marital status:-");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(43, 442, 104, 17);

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Married");
        getContentPane().add(jRadioButton4);
        jRadioButton4.setBounds(200, 441, 61, 23);

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("Unmarried");
        getContentPane().add(jRadioButton5);
        jRadioButton5.setBounds(285, 441, 75, 23);

        jButton1.setText("Execute");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(230, 470, 71, 23);

        result_lst.setModel(model);
        result_lst.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                result_lstValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(result_lst);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(33, 510, 461, 130);

        jButton2.setText("Store this result for further query");
        getContentPane().add(jButton2);
        jButton2.setBounds(33, 646, 193, 23);

        jButton3.setText("Proceed for new selection");
        getContentPane().add(jButton3);
        jButton3.setBounds(337, 646, 157, 23);

        jPanel1.setBackground(new java.awt.Color(253, 241, 224));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-150, 0, 690, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //select from name textfields
        int minage=0,maxage=0;
        Date d=new Date();
        Date d1=new Date();
        table="";
        where="";
        model.removeAllElements();
        
        //System.out.println(d.getYear()+" "+d.getMonth()+" "+d.getDate());
        String da=new String("");
        
        
        if(!jTextField4.getText().equals("")||!jTextField5.getText().equals(""))
        {
            if(!jTextField4.getText().equals(""))
            {
                d.setYear(d.getYear()+1900-Integer.parseInt(jTextField4.getText()));
            }
            if(!jTextField4.getText().equals(""))
            {
                d1.setYear(d1.getYear()+1900-Integer.parseInt(jTextField5.getText()));
            }
            if(jRadioButton1.isSelected())
            {
                if(!where.equals(""))
                {
                    where+=" AND ";
                }
                where+="Citizen.DOB<'"+d.getYear()+"-"+d.getMonth()+1+"-"+d.getDate()+"' AND Citizen.DOB>'"+d1.getYear()+"-"+d1.getMonth()+"-"+d1.getDate()+"'";
            }
            else
            {
                if(!where.equals(""))
                {
                    where+=" AND ";
                }
                where+="Citizen.DOB>'"+d.getYear()+"-"+d.getMonth()+1+"-"+d.getDay()+"' AND Citizen.DOB<'"+d1.getYear()+"-"+d1.getMonth()+"-"+d1.getDay()+"'";
            }
        }
        if(!jTextField1.getText().equals(""))
        {
            if(!where.equals(""))
            {
                where+=" AND ";
            }
            where+="Citizen.F_name='"+jTextField1.getText()+"'";
        }
        if(!jTextField2.getText().equals(""))
        {
            if(!where.equals(""))
            {
                where+=" AND ";
            }
            where+="Citizen.M_name='"+jTextField2.getText()+"'";
        }
        if(!jTextField3.getText().equals(""))
        {
            if(!where.equals(""))
            {
                where+=" AND ";
            }
            where+="Citizen.L_name='"+jTextField3.getText()+"'";
        }
        //select from phone number
        if(!jTextField6.getText().equals(""))
        {
            if(!where.equals(""))
            {
                where+=" AND ";
            }
            where+="Phone_NO="+jTextField6.getText();
            table="Citizen join Phone_NO on Citizen.UID=Phone_NO.UID";
        }
        //select gender
        if(jRadioButton2.isSelected())
        {
            if(!where.equals(""))
            {
                where+=" AND ";
            }
            where+="Citizen.Sex='M'";
        }
        if(jRadioButton3.isSelected())
        {
            if(!where.equals(""))
            {
                where+=" AND ";
            }
            where+="Citizen.Sex='F'";
        }
        if(table.equals(""))
        {
            table="Citizen";
        }
        //select Category
        if(jCheckBox1.isSelected()||jCheckBox2.isSelected()||jCheckBox3.isSelected()||jCheckBox4.isSelected())
        {
            int i=0;
            if(!where.equals(""))
            {
                where+=" AND ";
            }
            where+="(";
            if(jCheckBox1.isSelected())
            {
                i=1;
                where+="Citizen.Category='GEN'";
            }
            if(jCheckBox2.isSelected())
            {
                if(i==1)
                {
                    where+=" OR ";
                }
                i=1;
                where+="Citizen.Category='OBC'";
            }
            if(jCheckBox3.isSelected())
            {
                if(i==1)
                {
                    where+=" OR ";
                }
                i=1;
                where+="Citizen.Category='SC'";
            }
            if(jCheckBox4.isSelected())
            {
                if(i==1)
                {
                    where+=" OR ";
                }
                i=1;
                where+="Citizen.Category='ST'";
            }
            where+=")";
        }
        //select marital status
        if(jRadioButton4.isSelected())
        {
            if(!where.equals(""))
            {
                where+=" AND ";
            }
            where+="S_UID IS NOT NULL";
        }
        if(jRadioButton5.isSelected())
        {
            if(!where.equals(""))
            {
                where+=" AND ";
            }
            where+="S_UID IS NULL";
        }
        //get disability
/*        if(!jComboBox1.getSelectedItem().equals("none"))
        {
            table="Citizen join PH_details on Citizen.PH_NO=PH_details.PH_ID";
            if(!where.equals(""))
            {
                where+=" AND ";
            }
            where+="PH_details.name='"+jComboBox1.getSelectedItem()+"'";
        }
        */ 
        query="select Citizen.UID from "+table+" where "+where+" ;";
        
        Connection cn=ConnectionSetup.getConnection();
        Statement st=ConnectionSetup.getStatement(cn);
        
        ResultSet rs;
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
            
            
            
            rs = st.executeQuery(query);
        while(rs.next())
        {
            model.addElement("" + rs.getBigDecimal("UID"));
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(selectWorkDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(query);
        SelectPage.imp=query;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        
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
            java.util.logging.Logger.getLogger(selectPersonalDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(selectPersonalDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(selectPersonalDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(selectPersonalDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new selectPersonalDetails().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JList result_lst;
    // End of variables declaration//GEN-END:variables
}
