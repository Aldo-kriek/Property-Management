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
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Studio
 */
public class frmResults extends javax.swing.JFrame {


    /**
     * Creates new form frmResults
     */
    public frmResults() {
        initComponents();
        //set Title of JFrame Form
        this.setTitle("Results"); 
        //Load First name Details
        mLoadFirstName();
        //Read details for database
        mReadUserDetails();
          
    }
    
Boolean boolRecordExists=false;
Boolean boolEdit=false;
Boolean boolCreate=false;


//Declarations

    String tenant_first_name;
    String tenant_last_name;
    String tenant_contact_number;
    String tenant_street_name;
    String tenant_street_number;
    String tenant_address_area;
    String tenant_comments;
    int inttenant_id;

    String volunteer_first_name;
    String volunteer_last_name;
    String volunteer_contact_number;
    String volunteer_work_type;
    String volunteer_repair_status;

    String  strTenantFirstName;
    String  strTenantLastName;
    String  strTenantContactNumber;
    String  strTenantStreetNumber;
    String  strTenantStreetName;
    String  strTenantAddressArea;
    String  strTenantComments;
    
    String strVolunteerFirstName;
    String strVolunteerLastName;
    String strVolunteerContactNumber;
    String strVolunteerWorkType;
    String strVolunteerRepairStatus;

    private void mLoadFirstName()
    {
        
        String strDBConnectionString = "jdbc:mysql://localhost:3306/property management";
        String DBUser = "root";
        String DBPassword = ""; 
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement =null;
        ResultSet rs = null;
        
        
        try
        {
             conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, DBUser, DBPassword);
             stStatement = conMySQLConnectionString.createStatement();
             String strQuery = "Select tenant_first_name from service";
             stStatement.execute(strQuery);
             rs = stStatement.getResultSet();
             while (rs.next())
             {
                 cboFirstName.addItem(rs.getString(1));
             }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try
            {
                stStatement.close();
                
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Connection String not Closed" + "" + e);
            }
            
        }
        
        
    }
    
    //Read details from Databse
     private void mReadUserDetails()
    {
        String strDBConnectionString = "jdbc:mysql://localhost:3306/property management";
        String DBUser = "root";
        String DBPassword = ""; 
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement =null;
        ResultSet rs = null;
        
        try
        {
            conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, DBUser, DBPassword);
            stStatement = conMySQLConnectionString.createStatement();
            String strQuery = "Select tenant_id,tenant_first_name,tenant_last_name,tenant_contact_number,tenant_street_number,tenant_street_name,tenant_address_area,tenant_comments,volunteer_first_name,volunteer_last_name,volunteer_contact_number,volunteer_work_type,volunteer_repair_status from service where tenant_first_name='"+cboFirstName.getSelectedItem().toString()+"'";
            stStatement.execute(strQuery);
            rs = stStatement.getResultSet();
            while (rs.next())
            {
                inttenant_id= rs.getInt(1);
                strTenantFirstName = rs.getString(2);
                strTenantLastName = rs.getString(3);
                strTenantContactNumber = rs.getString(4);
                strTenantStreetNumber = rs.getString(5);
                strTenantStreetName = rs.getString(6);
                strTenantAddressArea = rs.getString(7);
                strTenantComments = rs.getString(8);
                strVolunteerFirstName = rs.getString(9);
                strVolunteerLastName = rs.getString(10);
                strVolunteerContactNumber = rs.getString(11);
                strVolunteerWorkType = rs.getString(12);
                strVolunteerRepairStatus = rs.getString(13);
             
                
            }
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
            catch (Exception e)
                    {
                        JOptionPane.showMessageDialog(null, "Connection String not closed" +"" +e);                    
                    }
        }
    }
        // Set values in the GUI screen
     private void mSetValuesInGUI()
    {
        
        txtTenantFirstName.setText(strTenantFirstName);
        txtTenantLastName.setText(strTenantLastName);
        txtTenantContactNumber.setText(strTenantContactNumber);
        txtTenantStreetNumber.setText(strTenantStreetNumber);
        txtTenantStreetName.setText(strTenantStreetName);
        txtTenantAddressArea.setText(strTenantAddressArea);
        txtTenantComments.setText(strTenantComments);
        txtVolunteerFirstName.setText(strVolunteerFirstName);
        txtVolunteerLastName.setText(strVolunteerLastName);
        txtVolunteerContactNumber.setText(strVolunteerContactNumber);
        txtVolunteerWorkType.setText(strVolunteerWorkType);
        txtVolunteerRepairStatus.setText(strVolunteerRepairStatus);
      
    }
    
            
        //Add data from database to JTable 
        private void mAddTable()
    {
        java.sql.Connection conMySQLConnectionString = null;
        String URL = "jdbc:mysql://localhost:3306/property management";
        String User = "root";
        String Password = "";
        Statement stSQLQuery = null;
        ResultSet rs = null;
        String strSQLQuery;
        strSQLQuery = null;
        

        try
        {
            conMySQLConnectionString = DriverManager.getConnection(URL, User, Password);  
            stSQLQuery = conMySQLConnectionString.createStatement();
            
            strSQLQuery = "SELECT * FROM service";  
            rs = stSQLQuery.executeQuery(strSQLQuery);
              
          
                while(rs.next()) {
                inttenant_id = rs.getInt(1);
                tenant_first_name = rs.getString(2);
                tenant_last_name = rs.getString(3);
                tenant_contact_number = rs.getString(4);
                tenant_street_number = rs.getString(5);
                tenant_street_name = rs.getString(6);
                tenant_address_area = rs.getString(7);
                tenant_comments = rs.getString(8);
                volunteer_first_name= rs.getString(9);
                volunteer_last_name= rs.getString(10);
                volunteer_contact_number= rs.getString(11);
                volunteer_work_type= rs.getString(12);
                volunteer_repair_status= rs.getString(13);
            
                
                String tbData[] = {tenant_first_name,tenant_last_name, tenant_contact_number, tenant_street_number, tenant_street_name, tenant_address_area, tenant_comments, volunteer_first_name, volunteer_last_name, volunteer_contact_number, volunteer_work_type, volunteer_repair_status};
                DefaultTableModel tblModel = (DefaultTableModel)tblTable.getModel();
                tblModel.addRow(tbData);
                
                }

        }
        
        
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
        finally
        {
            try
            {
                stSQLQuery.close();
                rs.close();
                conMySQLConnectionString.close();
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog (null, "Error Message");
            }
            
             tblTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
    }
        //Delete entry 
            private void mDelete()
    {
        String strDBConnectionString = "jdbc:mysql://localhost:3306/property management";
        String DBUser = "root";
        String DBPassword = ""; 
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement =null;
        ResultSet rs = null;
        
        try
        {
            conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, DBUser, DBPassword);
            
            String strQuery ="delete from service where tenant_first_name='" + strTenantFirstName + "'and tenant_last_name='" + strTenantLastName + "'and tenant_contact_number='" + strTenantContactNumber + "'and tenant_street_number='" + strTenantStreetNumber + "'and tenant_street_name='" + strTenantStreetName + "'and tenant_address_area='" + strTenantAddressArea + "'and tenant_comments='" + strTenantComments + "'and volunteer_first_name='" + strVolunteerFirstName + "'and volunteer_last_name='" + strVolunteerLastName + "'and volunteer_contact_number='" + strVolunteerContactNumber + "'and volunteer_work_type='" + strVolunteerWorkType + "'and volunteer_repair_status='" + strVolunteerRepairStatus + "' and tenant_id='" + inttenant_id +"'";
            
            stStatement = conMySQLConnectionString.prepareStatement(strQuery);
            stStatement.execute(strQuery);
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
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Connection String not closed" + "" + e);
                
            }
        }
        JOptionPane.showMessageDialog(null, "Successfully deleted");
    }
            


            
        //Clear text from combo box 
        private void mClearComboBox()
    {
        String[] arrArray = new String[0];
        javax.swing.DefaultComboBoxModel model = new javax.swing.DefaultComboBoxModel(arrArray);
        cboFirstName.setModel(model);
    }
              
                   
         //clear text From All Fields
        private void mClearVariables()
    {
        inttenant_id =0;
        
        strTenantFirstName = "";
        strTenantLastName = "";
        strTenantContactNumber = "";
        strTenantStreetNumber = "";
        strTenantStreetName = "";
        strTenantAddressArea = "";
        strTenantComments = "";
        strVolunteerFirstName = "";
        strVolunteerLastName = "";
        strVolunteerContactNumber = "";
        strVolunteerWorkType = "";
        strVolunteerRepairStatus = "";
    }
        
        
        //Update records
             private void mUpdate()
    {
        String strDBConnectionString = "jdbc:mysql://localhost:3306/property management";
        String DBUser = "root";
        String DBPassword = ""; 
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement =null;
        ResultSet rs = null;
        
        try
        {
            conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, DBUser, DBPassword);
             stStatement = conMySQLConnectionString.createStatement();
        
         
             String strQuery ="UPDATE service SET tenant_first_name='"+strTenantFirstName+"',tenant_last_name='"+strTenantLastName+"',tenant_contact_number='"+strTenantContactNumber+"',tenant_street_number='"+strTenantStreetNumber+"',tenant_street_name='"+strTenantStreetName+"',tenant_address_area='"+strTenantAddressArea+"',tenant_comments='"+strTenantComments+"',volunteer_first_name='"+strVolunteerFirstName+"',volunteer_last_name='"+strVolunteerLastName+"',volunteer_contact_number='"+strVolunteerContactNumber+"',volunteer_work_type='"+strVolunteerWorkType+"',volunteer_repair_status='"+strVolunteerRepairStatus+"' WHERE tenant_id="+inttenant_id;   
             stStatement.executeUpdate(strQuery);
            
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
      JOptionPane.showMessageDialog(null, "Successful");
    }
        
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
    
     private void mSetValueInGUI()
    {
        
        txtTenantFirstName.setText(strTenantFirstName);
        txtTenantLastName.setText(strTenantLastName);
        txtTenantContactNumber.setText(strTenantContactNumber);
        txtTenantStreetNumber.setText(strTenantStreetNumber);
        txtTenantStreetName.setText(strTenantStreetName);
        txtTenantAddressArea.setText(strTenantAddressArea);
        txtTenantComments.setText(strTenantComments);
        txtVolunteerFirstName.setText(strVolunteerFirstName);
        txtVolunteerLastName.setText(strVolunteerLastName);
        txtVolunteerContactNumber.setText(strVolunteerContactNumber);
        txtVolunteerWorkType.setText(strVolunteerWorkType);
        txtVolunteerRepairStatus.setText(strVolunteerRepairStatus);
              
    }
     
           private void mClearCombo()
    {
        String[] arrArray = new String[0];
        javax.swing.DefaultComboBoxModel model = new javax.swing.DefaultComboBoxModel(arrArray);
        cboFirstName.setModel(model);
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
    
    private void mClearTextFields()
    {
        
        txtTenantFirstName.setText("");
        txtTenantLastName.setText("");
        txtTenantContactNumber.setText("");
        txtTenantStreetNumber.setText("");
        txtTenantStreetName.setText("");
        txtTenantComments.setText("");
        txtTenantFirstName.setText("");
        txtVolunteerFirstName.setText("");
        txtVolunteerLastName.setText("");
        txtTenantContactNumber.setText("");
        txtVolunteerWorkType.setText("");
        txtVolunteerRepairStatus.setText("");
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
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTenantFirstName = new javax.swing.JTextField();
        txtTenantLastName = new javax.swing.JTextField();
        txtTenantContactNumber = new javax.swing.JTextField();
        txtTenantStreetName = new javax.swing.JTextField();
        txtVolunteerLastName = new javax.swing.JTextField();
        txtVolunteerWorkType = new javax.swing.JTextField();
        txtVolunteerFirstName = new javax.swing.JTextField();
        txtTenantComments = new javax.swing.JTextField();
        txtTenantAddressArea = new javax.swing.JTextField();
        txtVolunteerContactNumber = new javax.swing.JTextField();
        txtTenantStreetNumber = new javax.swing.JTextField();
        txtVolunteerRepairStatus = new javax.swing.JTextField();
        btnCreateNew = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        lblRepairStatus = new javax.swing.JLabel();
        lblVolunteerWorkType = new javax.swing.JLabel();
        lblVolunteerContactNumber = new javax.swing.JLabel();
        lblVolunteerLastName = new javax.swing.JLabel();
        lblTenantComments = new javax.swing.JLabel();
        lblTenantAddressArea = new javax.swing.JLabel();
        lblTenantStreetNumber = new javax.swing.JLabel();
        lblTenantStreetName = new javax.swing.JLabel();
        lblTenantContactNumber = new javax.swing.JLabel();
        lblTenantLastName = new javax.swing.JLabel();
        lblTenantFirstName1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblVolunteerFirstName = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTable = new javax.swing.JTable();
        btnTable = new javax.swing.JButton();
        cboFirstName = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblResultWallpaper = new javax.swing.JLabel();
        mnuMenu = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuHome = new javax.swing.JMenuItem();
        mnuExit = new javax.swing.JMenuItem();
        mnuForms = new javax.swing.JMenu();
        mnuRegistration = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Results");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(882, 882, 882)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(933, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2000, 80));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Results");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(txtTenantFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 740, 440, -1));
        getContentPane().add(txtTenantLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 790, 440, -1));
        getContentPane().add(txtTenantContactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 840, 440, -1));
        getContentPane().add(txtTenantStreetName, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 890, 440, -1));
        getContentPane().add(txtVolunteerLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 790, 450, -1));
        getContentPane().add(txtVolunteerWorkType, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 890, 450, -1));
        getContentPane().add(txtVolunteerFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 740, 450, -1));
        getContentPane().add(txtTenantComments, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 1040, 440, 90));
        getContentPane().add(txtTenantAddressArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 990, 440, -1));
        getContentPane().add(txtVolunteerContactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 840, 450, -1));
        getContentPane().add(txtTenantStreetNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 940, 440, -1));

        txtVolunteerRepairStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVolunteerRepairStatusActionPerformed(evt);
            }
        });
        getContentPane().add(txtVolunteerRepairStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 940, 450, -1));

        btnCreateNew.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCreateNew.setText("CREATE NEW");
        btnCreateNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNewActionPerformed(evt);
            }
        });
        getContentPane().add(btnCreateNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 1170, 130, 40));

        btnHome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnHome.setText("HOME");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        getContentPane().add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 120, 130, 40));

        lblRepairStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRepairStatus.setText("Repair Status:");
        getContentPane().add(lblRepairStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 940, 270, -1));

        lblVolunteerWorkType.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVolunteerWorkType.setText("Work Type:");
        getContentPane().add(lblVolunteerWorkType, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 890, 260, -1));

        lblVolunteerContactNumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVolunteerContactNumber.setText("Contact No:");
        getContentPane().add(lblVolunteerContactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 840, 260, -1));

        lblVolunteerLastName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVolunteerLastName.setText("Last name:");
        getContentPane().add(lblVolunteerLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 790, 250, -1));

        lblTenantComments.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenantComments.setText("Comments :");
        getContentPane().add(lblTenantComments, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1040, -1, -1));

        lblTenantAddressArea.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenantAddressArea.setText("Address Area:");
        getContentPane().add(lblTenantAddressArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 990, -1, -1));

        lblTenantStreetNumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenantStreetNumber.setText("Street Number:");
        getContentPane().add(lblTenantStreetNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 940, -1, -1));

        lblTenantStreetName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenantStreetName.setText("Street Name:");
        getContentPane().add(lblTenantStreetName, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 890, -1, -1));

        lblTenantContactNumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenantContactNumber.setText("Contact No :");
        getContentPane().add(lblTenantContactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 840, -1, -1));

        lblTenantLastName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenantLastName.setText("Last Name:");
        getContentPane().add(lblTenantLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 790, -1, -1));

        lblTenantFirstName1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenantFirstName1.setText("First Name:");
        getContentPane().add(lblTenantFirstName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 740, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Tenant");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(291, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(240, 240, 240))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(408, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 690, 610, 450));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setText("Volunteer");

        lblVolunteerFirstName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVolunteerFirstName.setText("First Name:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(257, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(228, 228, 228))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVolunteerFirstName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVolunteerFirstName)
                .addContainerGap(381, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 690, 610, 450));

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 680, 630, 470));

        jPanel5.setBackground(new java.awt.Color(0, 153, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 680, 630, 470));

        jPanel6.setBackground(new java.awt.Color(0, 153, 255));
        jPanel6.setForeground(new java.awt.Color(0, 204, 255));

        tblTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tenant Name", "tenant_last_name", "tenant_contact_number", "tenant_street_number", "tenant_street_name", "tenant_address_area", "tenant_comments", "volunteer_first_name", "volunteer_last_name", "volunteer_contact", "volunteer_work_type", "volunteer_repair_status"
            }
        ));
        jScrollPane1.setViewportView(tblTable);

        btnTable.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnTable.setText("LOAD TABLE");
        btnTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTable, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(719, 719, 719))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnTable, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 1610, 290));

        cboFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFirstNameActionPerformed(evt);
            }
        });
        getContentPane().add(cboFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 620, 100, 30));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        btnDelete.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 840, 130, 40));

        btnUpdate.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 760, 130, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Please select option ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 580, -1, -1));

        lblResultWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/property/management/Images/handyman (1).png"))); // NOI18N
        getContentPane().add(lblResultWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2000, 1300));

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

        mnuRegistration.setText("Registration");
        mnuRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegistrationActionPerformed(evt);
            }
        });
        mnuForms.add(mnuRegistration);

        mnuMenu.add(mnuForms);

        setJMenuBar(mnuMenu);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnuHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuHomeActionPerformed
        //Go To Home
        
        frmMain frmMain = new frmMain();
        frmMain.show();
        this.dispose();
    }//GEN-LAST:event_mnuHomeActionPerformed

    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed
        // Exit System
        
        System.exit(0);
    }//GEN-LAST:event_mnuExitActionPerformed

    private void mnuRegistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegistrationActionPerformed
        // Go To Registration
        
        frmCreate frmHome = new frmCreate();
        frmHome.show();
        this.dispose();
    }//GEN-LAST:event_mnuRegistrationActionPerformed

    private void btnTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTableActionPerformed
        // TODO add your handling code here:
         mAddTable();
             
        mLoadFirstName();
        
       
        
         
    }//GEN-LAST:event_btnTableActionPerformed

    private void cboFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFirstNameActionPerformed
        // TODO add your handling code here:
        
        mReadUserDetails();
        mSetValuesInGUI();
    }//GEN-LAST:event_cboFirstNameActionPerformed

    private void txtVolunteerRepairStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVolunteerRepairStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVolunteerRepairStatusActionPerformed

    private void btnCreateNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNewActionPerformed
        // Show Form
        
        frmCreate frmCreate=new frmCreate();
        frmCreate.show();
        this.hide();
    }//GEN-LAST:event_btnCreateNewActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // Go Home
        
        frmMain frmMain = new frmMain();
        frmMain.show();
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // Running methods to delete files

        mReadUserDetails();
        mDelete();
        mClearComboBox();

        mClearVariables();
        mClearTextFields();

        mLoadFirstName();
        mGetValuesFromGUI();
        mSetValueInGUI();

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        // Run Methods

        mGetValuesFromGUI();
        mSetValuesToUppercase();
        mUpdate();

        mClearComboBox();
        mClearTextFields();
        mClearVariables();
        mLoadFirstName();

    }//GEN-LAST:event_btnUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(frmResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmResults().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateNew;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnTable;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboFirstName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRepairStatus;
    private javax.swing.JLabel lblResultWallpaper;
    private javax.swing.JLabel lblTenantAddressArea;
    private javax.swing.JLabel lblTenantComments;
    private javax.swing.JLabel lblTenantContactNumber;
    private javax.swing.JLabel lblTenantFirstName1;
    private javax.swing.JLabel lblTenantLastName;
    private javax.swing.JLabel lblTenantStreetName;
    private javax.swing.JLabel lblTenantStreetNumber;
    private javax.swing.JLabel lblVolunteerContactNumber;
    private javax.swing.JLabel lblVolunteerFirstName;
    private javax.swing.JLabel lblVolunteerLastName;
    private javax.swing.JLabel lblVolunteerWorkType;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenu mnuForms;
    private javax.swing.JMenuItem mnuHome;
    private javax.swing.JMenuBar mnuMenu;
    private javax.swing.JMenuItem mnuRegistration;
    private javax.swing.JTable tblTable;
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
