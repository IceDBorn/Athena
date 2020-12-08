import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;
import javax.swing.*;

public class LoginPage extends javax.swing.JFrame {

    public LoginPage() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Login Page");
        URL url = ClassLoader.getSystemResource( "icon.png" );
        Image icon = new ImageIcon(url).getImage();
        this.setIconImage(icon);  
        WrongCredentials.setVisible(false);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        usernameLabel = new javax.swing.JLabel();
        WrongCredentials = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        passwordLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(695, 425));

        usernameField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        usernameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        passwordField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        passwordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        usernameLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        usernameLabel.setText("Username:");

        WrongCredentials.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        WrongCredentials.setForeground(new java.awt.Color(252, 0, 0));
        WrongCredentials.setText("Wrong Credentials!");

        loginButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        passwordLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        passwordLabel.setText("Password:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(237, 237, 237)
                            .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(WrongCredentials))
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(usernameLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(passwordLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(263, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(usernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(WrongCredentials)
                .addGap(18, 18, 18)
                .addComponent(loginButton)
                .addGap(97, 97, 97))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        int j = 0;
     int count = 0;
     String userNameInput = usernameField.getText();
     String passwordInput = passwordField.getText();
     
     try {
      File file = new File("USERDATA.txt");
      Scanner scanner = new Scanner(file);
      while(scanner.hasNextLine()) {
        scanner.nextLine();
        count++;
      }
      scanner.close();
    } catch (Exception e) {
      e.getStackTrace();
    }
     
     try {
            Scanner scanner = new Scanner(new File("USERDATA.txt"));
            while (scanner.hasNextLine())
            {
              WrongCredentials.setVisible(false);
              j++;
              String currentLine = scanner.nextLine();
              String[] currentLineArray = currentLine.split(",");
              

              if (userNameInput.equals(currentLineArray[0]) && passwordInput.equals(currentLineArray[1]))
              {
                      this.dispose();
                      MainPage mainPage = new MainPage(this.getLocation(),currentLineArray[2], currentLineArray[3],currentLineArray[4],currentLineArray[5], userNameInput);
                      mainPage.setVisible(true);
              }else
              {
                  if (j>=count){WrongCredentials.setVisible(true);}
              }
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "User Database Not Found", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new LoginPage().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel WrongCredentials;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
