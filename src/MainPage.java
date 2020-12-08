import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MainPage extends javax.swing.JFrame {
    static Point point;
    String username;

    public MainPage(Point point, String firstName, String lastName, String email, String role, String username) {
        initComponents();
        this.setTitle("Main Page");
        URL url = ClassLoader.getSystemResource( "icon.png" );
        Image icon = new ImageIcon(url).getImage();
        this.setIconImage(icon);  
        MainPage.point = point;
        this.setLocation(point);
        this.userFirstNameLabel.setText(firstName);
        this.userRoleLabel.setText(role);
        this.userLastNameLabel.setText(lastName);
        this.userEmailLabel.setText(email);
        this.username = username;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        JButton logoutButton = new JButton();
        JButton coursesButton = new JButton();
        JLabel headerLabel = new JLabel();
        JLabel firstNameLabel = new JLabel();
        JLabel lastNameLabel = new JLabel();
        JLabel emailLabel = new JLabel();
        // Variables declaration - do not modify                     
        JLabel roleLabel = new JLabel();
        userFirstNameLabel = new javax.swing.JLabel();
        userLastNameLabel = new javax.swing.JLabel();
        userEmailLabel = new javax.swing.JLabel();
        userRoleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(695, 425));

        logoutButton.setText("Logout");
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutButtonMouseClicked();
            }
        });

        coursesButton.setText("Courses");
        coursesButton.addActionListener(this::coursesButtonActionPerformed);

        headerLabel.setFont(new java.awt.Font("Dialog", Font.PLAIN, 36)); // NOI18N
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("International Hellenic University");

        firstNameLabel.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18)); // NOI18N
        firstNameLabel.setText("First name:");

        lastNameLabel.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18)); // NOI18N
        lastNameLabel.setText("Last name:");

        emailLabel.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18)); // NOI18N
        emailLabel.setText("Email:");

        roleLabel.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18)); // NOI18N
        roleLabel.setText("Role:");

        userFirstNameLabel.setText("");

        userLastNameLabel.setText("");

        userEmailLabel.setText("");

        userRoleLabel.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(242, 242, 242)
                                .addComponent(logoutButton)
                                .addGap(59, 59, 59)
                                .addComponent(coursesButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lastNameLabel)
                                    .addComponent(firstNameLabel)
                                    .addComponent(emailLabel)
                                    .addComponent(roleLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(userFirstNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(userLastNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(userEmailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(userRoleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(headerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(userFirstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(userLastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(userEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roleLabel)
                    .addComponent(userRoleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutButton)
                    .addComponent(coursesButton))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>                        

    private void logoutButtonMouseClicked() {//GEN-FIRST:event_logoutButtonMouseClicked
        this.dispose();
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
    }//GEN-LAST:event_logoutButtonMouseClicked

    private void coursesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coursesButtonActionPerformed
        if (userRoleLabel.getText().equals("Professor")) {
            this.setVisible(false);
            CoursesPage coursesPage = new CoursesPage(this.getLocation(), this, username);
            coursesPage.setTitle("Courses");
            coursesPage.setVisible(true);
        }
        else if (userRoleLabel.getText().equals("Secretary")){
            this.setVisible(false);
            GradesApprovalPage gradeApprovalPage = new GradesApprovalPage(this.getLocation(), this);
            gradeApprovalPage.setTitle("Grade Approvals");
            gradeApprovalPage.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "You don't have access to this page...", "Oops..", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_coursesButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MainPage(point,null,null,null,null, null).setVisible(true));
    }

    private javax.swing.JLabel userLastNameLabel;
    private javax.swing.JLabel userEmailLabel;
    private javax.swing.JLabel userFirstNameLabel;
    private javax.swing.JLabel userRoleLabel;
    // End of variables declaration                   
}
