/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;
import DatabaseConnection.ConnectionSetup;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author shawn
 */
public class selectArea extends javax.swing.JFrame {

    /**
     * Creates new form selectArea
     */
    DefaultComboBoxModel state_model = new DefaultComboBoxModel();
    DefaultComboBoxModel city_model = new DefaultComboBoxModel();
    DefaultComboBoxModel pin_model = new DefaultComboBoxModel();
    DefaultListModel model =new DefaultListModel();
    
    public selectArea() {
        initComponents();
        permanent.setSelected(true);
        jComboBox1.setEnabled(false);
                jComboBox2.setEnabled(false);
                        jComboBox3.setEnabled(false);
        fillState();
        fillCity();
        fillPin();
            jComboBox1.setEnabled(true);
                jComboBox2.setEnabled(true);
                        jComboBox3.setEnabled(true);
    }
    SelectPage p;
    
     public selectArea(SelectPage p) {
         this.p=p;
        initComponents();
        permanent.setSelected(true);
        jComboBox1.setEnabled(false);
                jComboBox2.setEnabled(false);
                        jComboBox3.setEnabled(false);
        fillState();
        fillCity();
        fillPin();
            jComboBox1.setEnabled(true);
                jComboBox2.setEnabled(true);
                        jComboBox3.setEnabled(true);
    }
    
    
    
    final void fillState()
    {
        state_model.removeAllElements();
        state_model.addElement("none");
        try {
            Connection cn=ConnectionSetup.getConnection();
            String query="select Distinct State from location";
            Statement st=ConnectionSetup.getStatement(cn);
            ResultSet rs=st.executeQuery(query);
            
            while(rs.next())
            {
                state_model.addElement(rs.getString("State"));
            }
            
            rs.close();
            st.close();
            cn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(selectArea.class.getName()).log(Level.SEVERE, null, ex);
        }
        jComboBox1.setSelectedItem("none");
    }
    
    final void fillCity()
    {
        city_model.removeAllElements();
        city_model.addElement("none");
        try {
            Connection cn=ConnectionSetup.getConnection();
            String query;
            
            String state;
            if(jComboBox1.getSelectedItem()==null)
            {
                  state="none";
            }
            else
            {
                  state=jComboBox1.getSelectedItem().toString();
            }
            
            
            if(state.equals("none"))
            {
                query="Select distinct City from location";
            }
            else
            {
                query="Select distinct City from location where state='" + state +"'";
            }
            Statement st=ConnectionSetup.getStatement(cn);
            
            ResultSet rs=st.executeQuery(query);
            
            while(rs.next())
            {
                city_model.addElement(rs.getString("City"));
            }
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(selectArea.class.getName()).log(Level.SEVERE, null, ex);
        }
        jComboBox2.setSelectedItem("none");
    }
    
    final void fillPin()
    {
        pin_model.removeAllElements();
        pin_model.addElement("none");
        String state=null;
        try {
            Connection cn=ConnectionSetup.getConnection();
            String query=null;
//            state=jComboBox1.getSelectedItem().toString();
            if(jComboBox1.getSelectedItem()==null)
            {
                  state="none";
            }
            else
            {
                  state=jComboBox1.getSelectedItem().toString();
            }
            
            String city;
            if(jComboBox2.getSelectedItem()==null)
            {
                   city="none";
            }
            else
            {
                city=jComboBox2.getSelectedItem().toString();
            }
            
            
            
            if(state.equals("none") && city.equals("none"))
            {
                query="Select distinct Pin from location";
            }
            else if(state.equals("none"))
            {
                query="Select distinct Pin from location where location.City = '" + city + "')";
            }
            else if(city.equals("none"))
            {
               query="Select distinct Pin from location where location.State = '" + state + "')"; 
            }
                
            Statement st=ConnectionSetup.getStatement(cn);
            
            ResultSet rs=st.executeQuery(query);
            
            while(rs.next())
            {
                pin_model.addElement(rs.getString("Pin"));
            }
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(selectArea.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        popupMenu1 = new java.awt.PopupMenu();
        jLabel1 = new javax.swing.JLabel();
        permanent = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        result_lst = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SELECT AREA");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(37, 11, 439, 27);

        buttonGroup1.add(permanent);
        permanent.setText("Permanent");
        getContentPane().add(permanent);
        permanent.setBounds(37, 56, 107, 23);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Temporary");
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(371, 56, 105, 23);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("State :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(37, 97, 70, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("City : ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(37, 128, 62, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Pin : ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(37, 159, 62, 17);

        jButton1.setText("Execute");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(153, 197, 151, 23);

        result_lst.setModel(model);
        result_lst.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                result_lstValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(result_lst);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 245, 525, 130);

        jButton2.setText("Store the result");
        getContentPane().add(jButton2);
        jButton2.setBounds(49, 386, 107, 23);

        jButton3.setText("Proceed for further filters");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(210, 386, 236, 23);

        jComboBox1.setModel(state_model);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(279, 97, 203, 20);

        jComboBox2.setModel(city_model);
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(279, 128, 203, 20);

        jComboBox3.setModel(pin_model);
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox3);
        jComboBox3.setBounds(279, 159, 203, 20);

        jPanel1.setBackground(new java.awt.Color(253, 241, 224));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, -80, 550, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if(jComboBox1.isEnabled())
        {    fillCity();
            fillPin();
        }
        else
        {
            
        }
            
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        
        String sa;
            if(jComboBox2.getSelectedItem()==null)
            {
                   System.out.println(" yeah!!!");
                  sa="none";
  //          try {
    //            Thread.sleep(4000);
      //      } catch (InterruptedException ex) {
        //        Logger.getLogger(selectArea.class.getName()).log(Level.SEVERE, null, ex);
          //  }
                  
            }
           else
            {
                  sa=jComboBox2.getSelectedItem().toString();
                   System.out.println(sa);
           }
//        sa=String.valueOf(jComboBox2.getSelectedItem());
        
        
        if(sa.equals("none"))
        {
       //     System.out.println(sa + "yeah!!");
            jComboBox1.setSelectedItem("none");
            jComboBox1.setEnabled(true);
        }
        else
        {
            Connection cn=ConnectionSetup.getConnection();
/*            String r;
            if(jComboBox2.getSelectedItem()==null)
            {
               r="none";
            }
            else
            {
                r=jComboBox2.getSelectedItem().toString();
            }
            */ 
            String query="select State from location where City='" + sa + "'";
            String s="none";
            Statement st=ConnectionSetup.getStatement(cn);
            try {
                ResultSet rs=st.executeQuery(query);
                
                if(rs.next())
                {
                    s=rs.getString("State");
//                    jComboBox2.setSelectedItem(s);
                    
                }
                rs.close();
                st.close();
                cn.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(selectArea.class.getName()).log(Level.SEVERE, null, ex);
            }
            jComboBox1.setEnabled(false);
            jComboBox1.setSelectedItem(s);
         
        }
        //fillState();
    //    fillPin();
        
        
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
        String q;
        if(jComboBox3.getSelectedItem()==null)
        {
            q="none";
        }
        else
        {
            q=jComboBox3.getSelectedItem().toString();
        }
        
        
        if(!q.equals("none"))
        {
            Connection cn=ConnectionSetup.getConnection();
//            String query="select City,State from location join area on location.Pin_3_digit=area.Pin_3_digit AND area.Pin = '" + jComboBox3.getSelectedItem().toString() + "')";
             String query="select City,State from location where Pin = '" + jComboBox3.getSelectedItem().toString() + "'";
//            String query="select State from location where City='" + jComboBox2.getSelectedItem().toString() + "'";
            String s=null;
            String c=null;
            Statement st=ConnectionSetup.getStatement(cn);
            try {
                ResultSet rs=st.executeQuery(query);
                
                if(rs.next())
                {
                    s=rs.getString("State");
                    c=rs.getString("City");
                }
                rs.close();
                st.close();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(selectArea.class.getName()).log(Level.SEVERE, null, ex);
            }
            jComboBox1.setSelectedItem(s);
            jComboBox1.setEnabled(false);
            jComboBox2.setSelectedItem(c);
            jComboBox2.setEnabled(false);
        }
        else
        {
            jComboBox1.setSelectedIndex(0);
            jComboBox1.setEnabled(true);
            
            jComboBox2.setSelectedIndex(0);
            jComboBox2.setEnabled(true);
        }
        //fillState();
        //fillPin();
        
        
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
            // TODO add your handling code here:
            model.removeAllElements();
            
            Connection cn=ConnectionSetup.getConnection();
            String query=null;
            ResultSet rs;
            if(permanent.isSelected())
            {

                if(!jComboBox3.getSelectedItem().toString().equals("none"))
                {
                    query="Select citizen.UID,F_name,M_name,L_name,Sex from ( citizen join id join family on citizen.UID = id.UID AND family.Ration_id=id.Ration_id) where P_pin='" + jComboBox3.getSelectedItem().toString() + "'";
                }
                else if (!jComboBox2.getSelectedItem().toString().equals("none"))
                {
                    query="Select citizen.UID,F_name,M_name,L_name,Sex from ( citizen join id join family join location on citizen.UID = id.UID AND family.Ration_id=id.Ration_id AND family.P_pin=PIN) where City='" + jComboBox2.getSelectedItem().toString() + "'";
                }
                else if(!jComboBox1.getSelectedItem().toString().equals("none"))
                {
                    query="Select citizen.UID,F_name,M_name,L_name,Sex from ( citizen join id join family join location on citizen.UID = id.UID AND family.Ration_id=id.Ration_id AND family.P_pin=PIN) where State='" + jComboBox1.getSelectedItem().toString() + "'";
                }
                else
                {
                    query="Select citizen.UID,F_name,M_name,L_name,Sex from ( citizen)";
                }
            }
            else
            {
                if(!jComboBox3.getSelectedItem().toString().equals("none"))
                {
                    query="Select citizen.UID,F_name,M_name,L_name,Sex from ( citizen join work_details on citizen.UID = work_details.UID) where T_pin='" + jComboBox3.getSelectedItem().toString() + "'";
                }
                else if (!jComboBox2.getSelectedItem().toString().equals("none"))
                {
                    query="Select citizen.UID,F_name,M_name,L_name,Sex from ( citizen join work_details join location on citizen.UID = work_details.UID AND work_details.T_pin=PIN) where City='" + jComboBox2.getSelectedItem().toString() + "'";
                }
                else if(!jComboBox1.getSelectedItem().toString().equals("none"))
                {
                    query="Select citizen.UID,F_name,M_name,L_name,Sex from ( citizen join work_details join location on citizen.UID = work_details.UID AND work_details.T_pin=PIN) where State='" + jComboBox1.getSelectedItem().toString() + "'";
                }
                else
                {
                    query="Select citizen.UID,F_name,M_name,L_name,Sex from ( citizen )";
                }    
            }
     try{
            Statement st=ConnectionSetup.getStatement(cn);
            
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
            
            
            rs=st.executeQuery(query);
            while(rs.next())
            {
                // add in list model..
                String uid="" +rs.getBigDecimal("UID");
         //       String f_name=rs.getString("F_name");
           //     String m_name=rs.getString("M_name");
             //   String l_name=rs.getString("L_name");
               // String sex=rs.getString("Sex");
             //   model.addElement(uid+"             " + f_name + "       "+ m_name+ "    "+l_name+"    "+sex );
                   model.addElement(uid);
            }
            rs.close();
            st.close();
            cn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(selectArea.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        SelectPage.imp=query;
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        p.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void result_lstValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_result_lstValueChanged
        // TODO add your handling code here:
        if(evt.getSource()==result_lst)
        {
            String id=result_lst.getSelectedValue().toString().trim().substring(0,12);
            System.out.println(id);
              profilePage pp=new profilePage(id.trim());
              pp.setVisible(true);
        }
 //       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    

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
            java.util.logging.Logger.getLogger(selectArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(selectArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(selectArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(selectArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new selectArea().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton permanent;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JList result_lst;
    // End of variables declaration//GEN-END:variables
}
