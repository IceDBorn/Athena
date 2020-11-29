import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CoursesPage extends javax.swing.JFrame {
    static Point point = null;
    static JFrame parent;
    DefaultListModel<String> studentsListModel;
    DefaultListModel<CharSequence> coursesListModel;
    String username;
    int lastEditedLength = 1;

    public CoursesPage(Point point, JFrame parent, String username) {
        initComponents();

        CoursesPage.point = point;
        this.setLocation(point);
        CoursesPage.parent = parent;
        studentsListModel = new DefaultListModel<>();
        coursesListModel = new DefaultListModel<>();
        this.username = username;

        try {
            Scanner scanner = new Scanner(new File("grades.txt"));
            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine();
                String[] currentLineArray = currentLine.split(",");

                if (username.equals(currentLineArray[0])) {
                    if (studentsListModel.getSize() > 0) {
                        boolean flag = true;
                        for (int i = 0; i < studentsListModel.getSize(); i++) {
                            if (studentsListModel.getElementAt(i).equals(currentLineArray[2])) {
                                flag = false;
                            }
                        }
                        if (flag) {
                            studentsListModel.addElement(currentLineArray[2]);
                        }
                    } else {
                        studentsListModel.addElement(currentLineArray[2]);
                    }
                }
            }
            studentsList.setModel(studentsListModel);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "User Database Not Found", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        JScrollPane jScrollPane1 = new JScrollPane();
        studentsList = new javax.swing.JList<>();
        // Variables declaration - do not modify                     
        JButton backButton = new JButton();
        JScrollPane jScrollPane2 = new JScrollPane();
        coursesList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(695, 425));

        studentsList.setModel(new javax.swing.AbstractListModel<>() {
            final String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        studentsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentsListMouseClicked();
            }
        });
        jScrollPane1.setViewportView(studentsList);

        backButton.setText("Back");
        backButton.addActionListener(this::backButtonActionPerformed);

        coursesList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                coursesListKeyReleased();
            }
        });
        jScrollPane2.setViewportView(coursesList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backButton)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        parent.setVisible(true);
        parent.setLocation(this.getLocation());
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void studentsListMouseClicked() {//GEN-FIRST:event_studentsListMouseClicked
        studentsListModel = new DefaultListModel<>();
        coursesListModel = new DefaultListModel<>();

        try {
            Scanner scanner = new Scanner(new File("grades.txt"));
            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine();
                String[] currentLineArray = currentLine.split(",");

                try {
                    if (currentLineArray.length > 1) {
                        if (studentsList.getSelectedValue().equals(currentLineArray[2]) && username.equals(currentLineArray[0])) {
                            studentsListModel.addElement(currentLineArray[1] + ": " + currentLineArray[3]);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                coursesList.setModel(studentsListModel);
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "User Database Not Found", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_studentsListMouseClicked

    private void coursesListKeyReleased() {//GEN-FIRST:event_coursesListKeyReleased
        String value = coursesList.getSelectedValue();
        StringBuilder sb = new StringBuilder(value);
        String setGradeText = (String)JOptionPane.showInputDialog(
                this,
                "Set grade:",
                "",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                ""
        );
        try {
            if (setGradeText != null && Integer.parseInt(setGradeText) > -1 && Integer.parseInt(setGradeText) < 11) {
                for (int i = 0; i < 2; i++) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (setGradeText.length() == 1) {
                    studentsListModel.setElementAt(sb + "0" + setGradeText, coursesList.getSelectedIndex());
                } else {
                    studentsListModel.setElementAt(sb + setGradeText, coursesList.getSelectedIndex());
                }
                try {
                    Scanner in = new Scanner(new File("grades.txt"));
                    int count = -1;
                    for (int i = 0; i < lastEditedLength + 1; i++) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    while (in.hasNextLine()) {
                        String s = in.nextLine();
                        String[] sArray = s.split(",");
                        if (sArray.length > 1) {
                            if (sArray[2].equals(studentsList.getSelectedValue()) && sArray[1].equals(sb.toString())) {
                                if (setGradeText.length() == 1) {
                                    sArray[3] = "0" + setGradeText;
                                } else {
                                    sArray[3] = setGradeText;
                                }
                                StringBuffer sArrayBuffer = new StringBuffer(sArray[0]);
                                for (int i = 1; i < sArray.length; i++) {
                                    sArrayBuffer.append(",").append(sArray[i]);
                                }
                                coursesListModel.addElement(sArrayBuffer);
                            } else {
                                coursesListModel.addElement(s);
                            }
                        }
                        count++;
                    }
                    PrintWriter writer = new PrintWriter("grades.txt");
                    writer.println(count);
                    for (int i = 0; i < coursesListModel.getSize(); i++) {
                        writer.println(coursesListModel.getElementAt(i));
                    }
                    writer.close();
                    coursesListModel.removeAllElements();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else if (setGradeText != null){
                JOptionPane.showMessageDialog(rootPane, "You can only type numbers between 0-10...", "Oops..", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "You can only type numbers between 0-10...", "Oops..", JOptionPane.INFORMATION_MESSAGE);
        }
        studentsList.hasFocus();
    }//GEN-LAST:event_coursesListKeyReleased

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
            java.util.logging.Logger.getLogger(CoursesPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new CoursesPage(point, parent, null).setVisible(true));
    }

    private javax.swing.JList<String> coursesList;
    private javax.swing.JList<String> studentsList;
    // End of variables declaration                   
}
