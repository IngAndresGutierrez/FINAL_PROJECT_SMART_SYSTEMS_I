/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project_smart_systems_i;

import agents.UserAgent;
import jade.gui.GuiEvent;
import java.awt.FileDialog;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author andres
 */
public class BoardGame extends javax.swing.JFrame {

    UserAgent userAgent;

    private FileDialog dialog;
    private FileClass fileClass;
    private TextManagement textManagement;
    private Matrix matrix;
    private ResolveIndirectVariant indirectVariant;

    /**
     * Creates new form Main
     *
     * @param userAgent
     * @param name
     */
    public BoardGame(UserAgent userAgent, String name) {

        initComponents();
        matrix = new Matrix();
        textManagement = new TextManagement();
        this.userAgent = userAgent;
        this.jLabelNameAgent.setText("Agent: " + name);
        this.setTitle("Nonogram - Japan puzzle");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaBoard = new javax.swing.JTextArea();
        jButtonIndirect = new javax.swing.JButton();
        jButtonDirect = new javax.swing.JButton();
        jLabelNameAgent = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemChooseFile = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextAreaBoard.setColumns(20);
        jTextAreaBoard.setRows(5);
        jScrollPane1.setViewportView(jTextAreaBoard);

        jButtonIndirect.setText("Indirect");
        jButtonIndirect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIndirectActionPerformed(evt);
            }
        });

        jButtonDirect.setText("Direct");
        jButtonDirect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDirectActionPerformed(evt);
            }
        });

        jLabelNameAgent.setText("jLabel1");

        jMenu1.setText("File");

        jMenuItemChooseFile.setText("Choose file");
        jMenuItemChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemChooseFileActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemChooseFile);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonIndirect, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDirect, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelNameAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabelNameAgent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIndirect)
                    .addComponent(jButtonDirect))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemChooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemChooseFileActionPerformed

        dialog = new FileDialog(this, "Select file to open", FileDialog.LOAD);
        dialog.setVisible(true);
        File file = new File(dialog.getFiles()[0].getAbsolutePath());

        fileClass = new FileClass();
        fileClass.readFile(file);

        jTextAreaBoard.setText(fileClass.getOutputRead());


    }//GEN-LAST:event_jMenuItemChooseFileActionPerformed

    private void jButtonIndirectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIndirectActionPerformed

        String clearText = textManagement.clearTextIndirectVariant(jTextAreaBoard.getText());

        GuiEvent event = new GuiEvent(this, 0);
        event.addParameter("ag2");
        event.addParameter(clearText);
        userAgent.postGuiEvent(event);
                
        
    }//GEN-LAST:event_jButtonIndirectActionPerformed

    private void jButtonDirectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDirectActionPerformed

        ArrayList<String> clearConstrains = textManagement.clearTextDirectVariant(jTextAreaBoard.getText());
                
        String m = "";

        for (String clearConstrain : clearConstrains) {

            m += clearConstrain + "\n";

        }
        
        GuiEvent event = new GuiEvent(this, 1);
        event.addParameter("ag3");
        event.addParameter(m);
        userAgent.postGuiEvent(event);

        jTextAreaBoard.setText(m);

    }//GEN-LAST:event_jButtonDirectActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDirect;
    private javax.swing.JButton jButtonIndirect;
    private javax.swing.JLabel jLabelNameAgent;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemChooseFile;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea jTextAreaBoard;
    // End of variables declaration//GEN-END:variables

}
