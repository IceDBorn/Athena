import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.DefaultListModel;

public class GradesApprovalPage extends javax.swing.JFrame {
    static Point point;
    DefaultListModel<String> pendingListModel;
    DefaultListModel<String> approvedListModel;
    boolean flag;
    static JFrame parent;
    
    public GradesApprovalPage(Point point, JFrame parent) {
        initComponents();
        GradesApprovalPage.point = point;
        this.setLocation(point);
        GradesApprovalPage.parent = parent;

        pendingListModel = new DefaultListModel<>();
        approvedListModel = new DefaultListModel<>();
        flag = true;
        pendingList.setModel(pendingListModel);

        if (flag){
            BufferedReader br = null;
            try{
                br = new BufferedReader(new FileReader("grades.txt"));
                int count = Integer.parseInt(br.readLine());

                for(int i = 0; i < count; i++) {
                    String currentLine = br.readLine();
                    if(currentLine.contains("pending")) {
                    pendingListModel.addElement(currentLine);
                    pendingList.setModel(pendingListModel);
                    }
                    else {
                    approvedListModel.addElement(currentLine);
                    approvedList.setModel(approvedListModel);
                    }
                }
                flag = false;
            }catch(Exception e) {
                System.out.println("\nException: "+e);
            }finally{
                try{
                    assert br != null;
                    br.close();
                }catch(Exception e){
                    System.out.println("\nException: "+e);
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JScrollPane jScrollPane3 = new JScrollPane();
        JList<String> finaljList = new JList<>();
        JScrollPane jScrollPane1 = new JScrollPane();
        pendingList = new javax.swing.JList<>();
        JScrollPane jScrollPane2 = new JScrollPane();
        approvedList = new javax.swing.JList<>();
        JButton toLeftButton = new JButton();
        JButton toRightButton = new JButton();
        JButton backButton = new JButton();
        JButton saveButton = new JButton();

        finaljList.setModel(new javax.swing.AbstractListModel<>() {
            final String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane3.setViewportView(finaljList);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened();
            }
        });

        jScrollPane1.setViewportView(pendingList);

        jScrollPane2.setViewportView(approvedList);

        toLeftButton.setText(">");
        toLeftButton.addActionListener(this::toLeftActionPerformed);

        toRightButton.setText("<");
        toRightButton.addActionListener(this::toRightActionPerformed);

        backButton.setText("Back");
        backButton.addActionListener(this::backButtonActionPerformed);

        saveButton.setText("Save");
        saveButton.addActionListener(this::saveButtonActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(toRightButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(toLeftButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addGap(231, 231, 231)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(284, 284, 284)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(toLeftButton)
                        .addGap(27, 27, 27)
                        .addComponent(toRightButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton)
                    .addComponent(saveButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened() {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        int pending = pendingList.getModel().getSize(); 
        int approved = approvedList.getModel().getSize();

        try (PrintWriter writer = new PrintWriter("grades.txt")) {
            writer.println(pending + approved);

            for (int i = 0; i < pending; i++) {
                writer.println(pendingList.getModel().getElementAt(i));
            }
            for (int i = 0; i < approved; i++) {
                writer.println(approvedList.getModel().getElementAt(i));
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        
    }//GEN-LAST:event_saveButtonActionPerformed

    private void toLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toLeftActionPerformed
        String str2 = pendingList.getSelectedValue();
        
        if(pendingList.getSelectedIndex()==-1){
            JOptionPane.showMessageDialog(rootPane, "No Course Selected...", "Oops..", JOptionPane.INFORMATION_MESSAGE);
        }else{
            int value = pendingList.getSelectedIndex();
            approvedListModel.addElement(str2.replaceAll("pending", "approved"));
            approvedList.setModel(approvedListModel);

            if(pendingListModel.getSize()!=0){
                pendingListModel.removeElementAt(value);
            }
            pendingList.setModel(pendingListModel);
        }
    }//GEN-LAST:event_toLeftActionPerformed

    private void toRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toRightActionPerformed
        String str2 = approvedList.getSelectedValue();
        
        if(approvedList.getSelectedIndex()==-1){
            JOptionPane.showMessageDialog(rootPane, "No Course Selected...", "Oops..", JOptionPane.INFORMATION_MESSAGE);
        }else{
            int value = approvedList.getSelectedIndex();
            pendingListModel.addElement(str2.replaceAll("approved", "pending"));
            pendingList.setModel(pendingListModel);

            if(approvedListModel.getSize()!=0){
                approvedListModel.removeElementAt(value);
            }
            approvedList.setModel(approvedListModel);
        }
    }//GEN-LAST:event_toRightActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
        parent.setLocation(this.getLocation());
        parent.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

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
            java.util.logging.Logger.getLogger(GradesApprovalPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new GradesApprovalPage(point, parent).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> approvedList;
    private javax.swing.JList<String> pendingList;
    // End of variables declaration//GEN-END:variables
}
