/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jFrame;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.swing.JOptionPane;



/**
 *
 * @author Shubh
 */
public class ViewAllRecord extends javax.swing.JFrame {

    /**
     * Creates new form ViewAllRecord
     */
    DefaultTableModel model ;
    public ViewAllRecord() {
        initComponents();
        setIssueBookDetailsToTable();
        
    }
    //to set the book details into the table.
    public void setIssueBookDetailsToTable(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms", "root", "");
        Statement st = con.createStatement();
            ResultSet rs=  st.executeQuery("select * from issue_book_details");
            while (rs.next()) {
                String id = rs.getString("id");
                String bookName = rs.getString("book_name");
                String StudentName = rs.getString("student_name");
                String IssueDate = rs.getString("issue_date");
                String DueDate = rs.getString("due_date");
                String Status = rs.getString("status");

                
                Object[] obj = {id,bookName,StudentName,IssueDate,DueDate,Status};
                model = (DefaultTableModel) tbl_issue_book_details.getModel();
                model.addRow(obj);
                
                
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //method to clear table
    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_issue_book_details.getModel();
        model.setRowCount(0);
    }
    
    //to fetch record
    public void search(){
        Date uFromDate = date_FromDate.getDatoFecha();
        Date uToDate = date_toDate.getDatoFecha();
        
        long l1 = uFromDate.getTime();
        long l2 = uToDate.getTime();
        java.sql.Date fromDate = new java.sql.Date(l1);
        java.sql.Date toDate = new java.sql.Date(l2);
        
        try {
            Connection con  = DBConnection.getConnection();
            String sql = "select * from issue_book_details where issue_date BETWEEN ? and ?";
            PreparedStatement pst  = con.prepareStatement(sql);
            pst.setDate(1, fromDate);
            pst.setDate(2, toDate);
            
            ResultSet rs = pst.executeQuery();
            if (rs.next() == false) {
                JOptionPane.showMessageDialog(this, "No Records Found");
            }else{
                while (rs.next()) {
                String id = rs.getString("id");
                String bookName = rs.getString("book_name");
                String StudentName = rs.getString("student_name");
                String IssueDate = rs.getString("issue_date");
                String DueDate = rs.getString("due_date");
                String Status = rs.getString("status");

                
                Object[] obj = {id,bookName,StudentName,IssueDate,DueDate,Status};
                model = (DefaultTableModel) tbl_issue_book_details.getModel();
                model.addRow(obj);
            }
            
            
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        date_FromDate = new rojeru_san.componentes.RSDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        date_toDate = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonCircle1 = new necesario.RSMaterialButtonCircle();
        jLabel1 = new javax.swing.JLabel();
        panel_table = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_issue_book_details = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("View All Records");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 310, 70));

        date_FromDate.setForeground(new java.awt.Color(255, 255, 255));
        date_FromDate.setColorBackground(new java.awt.Color(51, 51, 51));
        date_FromDate.setColorButtonHover(new java.awt.Color(102, 102, 102));
        date_FromDate.setColorForeground(new java.awt.Color(102, 102, 102));
        date_FromDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        date_FromDate.setPlaceholder("Select Date");
        jPanel1.add(date_FromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, 30));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 0, 51));
        jLabel6.setText("Issue Date  :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, -1, -1));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 0, 51));
        jLabel14.setText("Due Date  :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, -1, -1));

        date_toDate.setForeground(new java.awt.Color(255, 255, 255));
        date_toDate.setColorBackground(new java.awt.Color(51, 51, 51));
        date_toDate.setColorButtonHover(new java.awt.Color(102, 102, 102));
        date_toDate.setColorForeground(new java.awt.Color(102, 102, 102));
        date_toDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        date_toDate.setPlaceholder("Due Date");
        jPanel1.add(date_toDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 170, -1, 30));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(0, 51, 102));
        rSMaterialButtonCircle1.setText("Search");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 160, 110, 50));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Library Project/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1480, 280));

        panel_table.setBackground(new java.awt.Color(255, 255, 255));
        panel_table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_issue_book_details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book Name", "Student Name", "Issue Date", "Due Date", "Status"
            }
        ));
        tbl_issue_book_details.setColorBackgoundHead(new java.awt.Color(102, 153, 255));
        tbl_issue_book_details.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_issue_book_details.setColorFilasForeground1(new java.awt.Color(51, 51, 51));
        tbl_issue_book_details.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        tbl_issue_book_details.setFuenteFilas(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        tbl_issue_book_details.setFuenteFilasSelect(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        tbl_issue_book_details.setFuenteHead(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        tbl_issue_book_details.setRowHeight(40);
        tbl_issue_book_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_issue_book_detailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_issue_book_details);

        panel_table.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 1010, 310));

        getContentPane().add(panel_table, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 1480, 580));

        setSize(new java.awt.Dimension(1498, 864));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_issue_book_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_issue_book_detailsMouseClicked
        
    }//GEN-LAST:event_tbl_issue_book_detailsMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        clearTable();
        search();
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAllRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_FromDate;
    private rojeru_san.componentes.RSDateChooser date_toDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_table;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojeru_san.complementos.RSTableMetro tbl_issue_book_details;
    // End of variables declaration//GEN-END:variables
}
