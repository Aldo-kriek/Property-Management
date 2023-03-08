/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package property.management;

import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;


/**
 *
 * @author Studio
 */
public class frmCreate extends javax.swing.JFrame {

    /**
     * Creates new form frmHome
     */
    public frmCreate() {
        initComponents();
        this.setTitle("Registration");
    }
    
    Boolean boolRecordExists=false;
    
    //Values used to store Tenant info
    String strTenantFirstName=null;
    String strTenantLastName=null;
    String strTenantContactNumber=null;
    String strTenantStreetName=null;
    String strTenantStreetNumber=null;
    String strTenantAddressArea=null;
    String strTenantComments=null;
    
     //Values used to store Volunteer info
    String strVolunteerFirstName=null;
    String strVolunteerLastName=null;
    String strVolunteerContactNumber=null;
    String strVolunteerWorkType=null;
    String strVolunteerRepairStatus=null;
    
    
    
    
    //Get values from Text Fields 
    private void mGetValuesFromGUI()
    {
    strTenantFirstName = txtTenantFirstName.getText();
    strTenantLastName= txtTenantLastName.getText();
    strTenantContactNumber= txtTenantContactNumber.getText();
    strTenantStreetName= txtTenantStreetName.getText();
    strTenantStreetNumber= txtTenantStreetNumber.getText();
    strTenantAddressArea= txtTenantAddressArea.getText();
    strTenantComments= txtTenantComments.getText();
    
    strVolunteerFirstName= txtVolunteerFirstName.getText();
    strVolunteerLastName= txtVolunteerLastName.getText();
    strVolunteerContactNumber= txtVolunteerContactNumber.getText();
    strVolunteerWorkType= txtVolunteerWorkType.getText();
    strVolunteerRepairStatus= txtVolunteerRepairStatus.getText();
    
    }
    
    //Set values to uppercase
    private void mSetValuesToUppercase()
    {
    strTenantFirstName = strTenantFirstName.toUpperCase();
    strTenantLastName= strTenantLastName.toUpperCase();
    strTenantContactNumber= strTenantContactNumber.toUpperCase();
    strTenantStreetName= strTenantStreetName.toUpperCase();
    strTenantStreetNumber= strTenantStreetNumber.toUpperCase();
    strTenantAddressArea= strTenantAddressArea.toUpperCase();
    strTenantComments= strTenantComments.toUpperCase();
    
    strVolunteerFirstName= strVolunteerFirstName.toUpperCase();
    strVolunteerLastName= strVolunteerLastName.toUpperCase();
    strVolunteerContactNumber= strVolunteerContactNumber.toUpperCase();
    strVolunteerWorkType= strVolunteerWorkType.toUpperCase();
    strVolunteerRepairStatus= strVolunteerRepairStatus.toUpperCase();
        
    }
        //Check if item exists in database
          private void mCheckIfItemsExistInTable()
    {
        String strDBConnectionString = "jdbc:mysql://localhost:3306/property management";
        String strDBUser = "root";
        String strDBPassword = "";
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement = null;
        ResultSet rs = null;
        
        try
        {
            conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
            stStatement = conMySQLConnectionString.createStatement();
            String strQuery = "Select * from service WHERE tenant_first_name='" + strTenantFirstName + "'and tenant_last_name='" + strTenantLastName+ "'and tenant_contact_number='" + strTenantContactNumber + "'and tenant_street_name='" + strTenantStreetName + "' and tenant_street_number='" + strTenantStreetNumber + "'and tenant_address_area='" + strTenantAddressArea + "'and tenant_comments='" + strTenantComments + "'and volunteer_first_name='" + strVolunteerFirstName + "'and volunteer_last_name='" + strVolunteerLastName + "'and volunteer_contact_number='" + strVolunteerContactNumber + "'and volunteer_work_type='" + strVolunteerWorkType + "'and volunteer_repair_status ='" + strVolunteerRepairStatus+"'";
                                                          
            stStatement.execute(strQuery);
            rs=stStatement.getResultSet();
            
            boolRecordExists = rs.next();
        }
       catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try
            {
                stStatement.close();
            }
            catch (SQLException e)
                    {
                        JOptionPane.showMessageDialog(null, "Connection String not Closed" + "" + e);
                        
                    }
        }
        
    }
          
              private void mCreate()
    {
        java.sql.Connection conMySQLConnectionString = null;
        String URL = "jdbc:mysql://localhost:3306/property management";
        String User = "root";
        String Password = "";
         
        try
        {
            conMySQLConnectionString = DriverManager.getConnection(URL, User, Password);
            try (Statement myStatement = conMySQLConnectionString.createStatement()) {
               
                String sqlinsert = "insert into service"+"(tenant_first_name,tenant_last_name,tenant_contact_number,tenant_street_name,tenant_street_number,tenant_address_area,tenant_comments,volunteer_first_name,volunteer_last_name,volunteer_contact_number,volunteer_work_type,volunteer_repair_status)"+"values('"+strTenantFirstName+"','"+strTenantLastName+"','"+strTenantContactNumber+"','"+strTenantStreetName+"','"+strTenantStreetNumber+"','"+strTenantAddressArea+"','"+strTenantComments+"','"+strVolunteerFirstName+"','"+strVolunteerLastName+"','"+strVolunteerContactNumber+"','"+strVolunteerWorkType+"','"+strVolunteerRepairStatus+"')";
                
                myStatement.executeUpdate(sqlinsert);
            }
            
            JOptionPane.showMessageDialog(null, "Successfully Saved");
            }
        
       

        catch (Exception  e)
        {
            JOptionPane.showMessageDialog(null, "Details Already Exist");
        }

    }
              
              

    
        //Clear contents from text fields
        private void mClearFields()
    {
        txtTenantFirstName.setText("");
        txtTenantLastName.setText("");
        txtTenantContactNumber.setText("");
        txtTenantStreetNumber.setText("");
        txtTenantStreetName.setText("");
        txtTenantAddressArea.setText("");
        txtTenantComments.setText("");
        txtVolunteerFirstName.setText("");
        txtVolunteerLastName.setText("");
        txtVolunteerContactNumber.setText("");
        txtVolunteerWorkType.setText("");
        txtVolunteerRepairStatus.setText("");

    }
    

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSubmit = new javax.swing.JButton();
        txtTenantFirstName = new javax.swing.JTextField();
        txtTenantLastName = new javax.swing.JTextField();
        txtTenantStreetNumber = new javax.swing.JTextField();
        txtTenantContactNumber = new javax.swing.JTextField();
        txtTenantStreetName = new javax.swing.JTextField();
        lblTenantHeading = new javax.swing.JLabel();
        lblTenantFirstName = new javax.swing.JLabel();
        lblTenantLastName = new javax.swing.JLabel();
        lblTenantContactNumber = new javax.swing.JLabel();
        lblTenantStreetNumber = new javax.swing.JLabel();
        lblTenantStreetName = new javax.swing.JLabel();
        lblTenantAddressArea = new javax.swing.JLabel();
        txtTenantAddressArea = new javax.swing.JTextField();
        lblTenantComments = new javax.swing.JLabel();
        txtTenantComments = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtVolunteerFirstName = new javax.swing.JTextField();
        txtVolunteerLastName = new javax.swing.JTextField();
        txtVolunteerContactNumber = new javax.swing.JTextField();
        txtVolunteerWorkType = new javax.swing.JTextField();
        txtVolunteerRepairStatus = new javax.swing.JTextField();
        lblVolunteerFirstName = new javax.swing.JLabel();
        lblRepairStatus = new javax.swing.JLabel();
        lblVolunteerContactNumber = new javax.swing.JLabel();
        lblVolunteerWorkType = new javax.swing.JLabel();
        lblVolunteerLastName = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnResults = new javax.swing.JButton();
        lblWallpaperHome = new javax.swing.JLabel();
        mnuMenu = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuHome = new javax.swing.JMenuItem();
        mnuExit = new javax.swing.JMenuItem();
        mnuForms = new javax.swing.JMenu();
        mnuResults = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSubmit.setBackground(new java.awt.Color(0, 255, 153));
        btnSubmit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSubmit.setText("SUBMIT");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        getContentPane().add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 600, 100, 40));
        getContentPane().add(txtTenantFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 470, -1));
        getContentPane().add(txtTenantLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 470, -1));
        getContentPane().add(txtTenantStreetNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 470, -1));
        getContentPane().add(txtTenantContactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 470, -1));
        getContentPane().add(txtTenantStreetName, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 470, -1));

        lblTenantHeading.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblTenantHeading.setText("Tenant Details");
        getContentPane().add(lblTenantHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, -1, -1));

        lblTenantFirstName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenantFirstName.setText("First Name:");
        getContentPane().add(lblTenantFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, -1));

        lblTenantLastName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenantLastName.setText("Last Name:");
        getContentPane().add(lblTenantLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, -1));

        lblTenantContactNumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenantContactNumber.setText("Contact No :");
        getContentPane().add(lblTenantContactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, -1, -1));

        lblTenantStreetNumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenantStreetNumber.setText("Street Number:");
        getContentPane().add(lblTenantStreetNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, -1, -1));

        lblTenantStreetName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenantStreetName.setText("Street Name:");
        getContentPane().add(lblTenantStreetName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, -1, -1));

        lblTenantAddressArea.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenantAddressArea.setText("Address Area:");
        getContentPane().add(lblTenantAddressArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, -1, -1));
        getContentPane().add(txtTenantAddressArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 470, -1));

        lblTenantComments.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenantComments.setText("Comments :");
        getContentPane().add(lblTenantComments, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, -1, -1));
        getContentPane().add(txtTenantComments, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 470, 20));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Volunteer Details");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, -1, -1));
        getContentPane().add(txtVolunteerFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 470, -1));
        getContentPane().add(txtVolunteerLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, 470, -1));
        getContentPane().add(txtVolunteerContactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 480, 470, -1));
        getContentPane().add(txtVolunteerWorkType, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 510, 470, -1));
        getContentPane().add(txtVolunteerRepairStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 540, 470, -1));

        lblVolunteerFirstName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVolunteerFirstName.setText("First Name:");
        getContentPane().add(lblVolunteerFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, -1, -1));

        lblRepairStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRepairStatus.setText("Repair Status:");
        getContentPane().add(lblRepairStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 540, -1, -1));

        lblVolunteerContactNumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVolunteerContactNumber.setText("Contact No:");
        getContentPane().add(lblVolunteerContactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 480, 80, -1));

        lblVolunteerWorkType.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVolunteerWorkType.setText("Work Type:");
        getContentPane().add(lblVolunteerWorkType, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, -1, -1));

        lblVolunteerLastName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVolunteerLastName.setText("Last name:");
        getContentPane().add(lblVolunteerLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Registration");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(472, 472, 472)
                .addComponent(jLabel7)
                .addContainerGap(498, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addComponent(jLabel7))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 60));

        btnResults.setBackground(new java.awt.Color(153, 153, 255));
        btnResults.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnResults.setText("VIEW  RESULTS");
        btnResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResultsActionPerformed(evt);
            }
        });
        getContentPane().add(btnResults, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 680, 310, 40));

        lblWallpaperHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/property/management/Images/handyman.jpg"))); // NOI18N
        getContentPane().add(lblWallpaperHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, -1));

        mnuFile.setText("File");

        mnuHome.setText("Home");
        mnuHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuHomeActionPerformed(evt);
            }
        });
        mnuFile.add(mnuHome);

        mnuExit.setText("Exit");
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        mnuFile.add(mnuExit);

        mnuMenu.add(mnuFile);

        mnuForms.setText("Forms");

        mnuResults.setText("Results");
        mnuResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuResultsActionPerformed(evt);
            }
        });
        mnuForms.add(mnuResults);

        mnuMenu.add(mnuForms);

        setJMenuBar(mnuMenu);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
       
        // Field cannot be empty and Request Focus in Window
       
         if (txtTenantFirstName.getText().equals(""))

        {
            JOptionPane.showMessageDialog(null, "The field can not be left empty");
            txtTenantFirstName.requestFocusInWindow();
        }

        else if (txtTenantLastName.getText().equals(""))

        {
            JOptionPane.showMessageDialog(null, "The field can not be left empty");
            txtTenantLastName.requestFocusInWindow();
        }

        else if (txtTenantContactNumber.getText().equals(""))

        {
            JOptionPane.showMessageDialog(null, "The field can not be left empty");
            txtTenantContactNumber.requestFocusInWindow();
        }

        else if (txtTenantStreetName.getText().equals(""))

        {
            JOptionPane.showMessageDialog(null, "The field can not be left empty");
            txtTenantStreetName.requestFocusInWindow();
        }

        else if (txtTenantStreetNumber.getText().equals(""))

        {
            JOptionPane.showMessageDialog(null, "The field can not be left empty");
            txtTenantStreetNumber.requestFocusInWindow();
        }

        else if (txtTenantAddressArea.getText().equals(""))

        {
            JOptionPane.showMessageDialog(null, "The field can not be left empty");
            txtTenantAddressArea.requestFocusInWindow();
        }

        else if (txtTenantComments.getText().equals(""))

        {
            JOptionPane.showMessageDialog(null, "The field can not be left empty");
            txtTenantComments.requestFocusInWindow();
        }
        
         else if (txtVolunteerFirstName.getText().equals(""))

        {
            JOptionPane.showMessageDialog(null, "The field can not be left empty");
            txtVolunteerFirstName.requestFocusInWindow();
        }

        else if (txtVolunteerLastName.getText().equals(""))

        {
            JOptionPane.showMessageDialog(null, "The field can not be left empty");
            txtVolunteerLastName.requestFocusInWindow();
        }

        else if (txtVolunteerContactNumber.getText().equals(""))

        {
            JOptionPane.showMessageDialog(null, "The field can not be left empty");
            txtVolunteerContactNumber.requestFocusInWindow();
        }

        else if ( txtVolunteerWorkType.getText().equals(""))

        {
            JOptionPane.showMessageDialog(null, "The field can not be left empty");
             txtVolunteerWorkType.requestFocusInWindow();
        }

        else if (txtVolunteerRepairStatus.getText().equals(""))

        {
            JOptionPane.showMessageDialog(null, "The field can not be left empty");
            txtVolunteerRepairStatus.requestFocusInWindow();
        }

        else
        {
            mGetValuesFromGUI();
            mSetValuesToUppercase();
            mCheckIfItemsExistInTable();
            
            if(boolRecordExists==true)
            {
                boolRecordExists=false;
                JOptionPane.showMessageDialog(null, "Entry Already Exists");
            }
            else if (boolRecordExists==false)
            {
                mCreate();
                mClearFields();
            }
           
             
        }
         
     
 
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResultsActionPerformed
        
        // Go to Results
        frmResults frmResults = new frmResults();
        frmResults.show();
        this.dispose();
  
        
    }//GEN-LAST:event_btnResultsActionPerformed

    private void mnuHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuHomeActionPerformed
        // got to Home
        
        frmMain frmMain = new frmMain();
        frmMain.show();
        this.hide();
    }//GEN-LAST:event_mnuHomeActionPerformed

    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed
        // Exit System
        
        System.exit(0);
    }//GEN-LAST:event_mnuExitActionPerformed

    private void mnuResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuResultsActionPerformed
        // Go to results
        
        frmResults frmResults = new frmResults();
        frmResults.show();
        this.hide();
        
    }//GEN-LAST:event_mnuResultsActionPerformed

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
            java.util.logging.Logger.getLogger(frmCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frmCreate().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnResults;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblRepairStatus;
    private javax.swing.JLabel lblTenantAddressArea;
    private javax.swing.JLabel lblTenantComments;
    private javax.swing.JLabel lblTenantContactNumber;
    private javax.swing.JLabel lblTenantFirstName;
    private javax.swing.JLabel lblTenantHeading;
    private javax.swing.JLabel lblTenantLastName;
    private javax.swing.JLabel lblTenantStreetName;
    private javax.swing.JLabel lblTenantStreetNumber;
    private javax.swing.JLabel lblVolunteerContactNumber;
    private javax.swing.JLabel lblVolunteerFirstName;
    private javax.swing.JLabel lblVolunteerLastName;
    private javax.swing.JLabel lblVolunteerWorkType;
    private javax.swing.JLabel lblWallpaperHome;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenu mnuForms;
    private javax.swing.JMenuItem mnuHome;
    private javax.swing.JMenuBar mnuMenu;
    private javax.swing.JMenuItem mnuResults;
    private javax.swing.JTextField txtTenantAddressArea;
    private javax.swing.JTextField txtTenantComments;
    private javax.swing.JTextField txtTenantContactNumber;
    private javax.swing.JTextField txtTenantFirstName;
    private javax.swing.JTextField txtTenantLastName;
    private javax.swing.JTextField txtTenantStreetName;
    private javax.swing.JTextField txtTenantStreetNumber;
    private javax.swing.JTextField txtVolunteerContactNumber;
    private javax.swing.JTextField txtVolunteerFirstName;
    private javax.swing.JTextField txtVolunteerLastName;
    private javax.swing.JTextField txtVolunteerRepairStatus;
    private javax.swing.JTextField txtVolunteerWorkType;
    // End of variables declaration//GEN-END:variables
}
