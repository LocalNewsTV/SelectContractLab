/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package selectcontract;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Rawrg
 */
public class AddContract extends javax.swing.JDialog {
    private String[] destList;
    private String[] origList;
    final private String fileName = "./contracts.txt";
    //AddContractListener contractCreate = new AddContractListener();
    /**
     * Creates new form AddContract
     */
    //public AddContract(JFrame f, boolean m, ContractModel theModel) {
    public AddContract(JFrame f, boolean m){
        super(f, m);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jContractID = new javax.swing.JTextField();
        jGoods = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jOriginCity = new javax.swing.JComboBox<>();
        jDestinationCity = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCancel = new javax.swing.JButton();
        jSave = new javax.swing.JButton();
        jReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jContractID.setToolTipText("ID must be in format of [N][L][L][L]");
        jContractID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jContractIDActionPerformed(evt);
            }
        });

        jGoods.setToolTipText("Goods cannot be entirely numbers but may contain them.. They can also not have numbers");

        jLabel1.setText("Contract ID:");

        jOriginCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Victoria", "Vancouver", "Seattle", "Nanaimo", "Prince George" }));

        jDestinationCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Victoria", "Vancouver", "Seattle", "Nanaimo", "Prince George" }));

        jLabel2.setText("Origin City:");

        jLabel3.setText("Destination City:");

        jLabel4.setText("Goods:");

        jLabel5.setText("Add a New Contract");

        jCancel.setText("Cancel");
        jCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelActionPerformed(evt);
            }
        });

        jSave.setText("Save");
        jSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveActionPerformed(evt);
            }
        });

        jReset.setText("Reset");
        jReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jReset)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jContractID)
                                    .addComponent(jGoods)
                                    .addComponent(jOriginCity, 0, 159, Short.MAX_VALUE)
                                    .addComponent(jDestinationCity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jSave, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel5)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jContractID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jOriginCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDestinationCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGoods, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCancel)
                    .addComponent(jSave)
                    .addComponent(jReset))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jContractIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jContractIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jContractIDActionPerformed
    void setOriginCityList(String[]origList){
        DefaultComboBoxModel model = new DefaultComboBoxModel(origList);
        this.jOriginCity.setModel(model);
    }
    void setDestinationCityList(String[]destList){
        final DefaultComboBoxModel model = new DefaultComboBoxModel(destList);
        this.jDestinationCity.setModel(model);
    }
        
    private void jCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelActionPerformed
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jCancelActionPerformed

    private boolean checkContracts(String contractID) throws FileNotFoundException{
            FileReader fr;
            BufferedReader br;
        //to do, make something read file to compare contractID's to file for duplicates
        try{
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                if(line.contains(contractID))
                    return false;
            }
            return true;
        }catch(IOException ex){
            Logger.getLogger(AddContract.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    private void jSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaveActionPerformed
        // TODO add your handling code here:
            String fileName = "C:\\Users\\Rawrg\\OneDrive\\School\\SelectContractLab08\\contracts.txt";
            FileWriter fw;
            String contractID, destCity,origCity, goods;
            try{
                if(jContractID.getText().equals("") || !jContractID.getText().matches("[0-9][a-zA-Z][a-zA-Z][a-zA-Z]") || (jContractID.getText()).length() != 4){
                     throw new IOException("Invalid Contract ID");
                }

                    if(!jGoods.getText().equals("") && jGoods.getText().matches("(.*)[a-zA-Z](.*)")){
                        if(jGoods.getText().contains(",")){
                            throw new IOException("No commas allowed in Goods declaration");
                        }
                    }
                    else{
                        throw new IOException("Please enter a valid commerce item.");
                    }
                        if(jDestinationCity.getSelectedItem().toString().equals(jOriginCity.getSelectedItem().toString())){
                            throw new IOException("Origin and Destination cannot be the same.");
                        }
                        contractID = jContractID.getText().toUpperCase();
                    if(checkContracts(contractID)){
                        goods = jGoods.getText();
                        origCity = jOriginCity.getSelectedItem().toString();
                        destCity = jDestinationCity.getSelectedItem().toString();
                        fw = new FileWriter(fileName, true);
                        String bigString = "\n" + contractID + "," + origCity + "," + destCity + "," + goods; 
                        fw.write(bigString);
                        fw.flush();
                        fw.close();
                        JOptionPane.showMessageDialog(null, "Your contract has been added!", "Contract Added!", 1);
                        jContractID.setText("");
                        jGoods.setText("");
                        Contract newCon = new Contract(contractID, origCity, destCity, goods);
                        //theModel.addContract(newCon);
                        //theModel.originCityList.add(origCity);
                        
                        
                    }
                    else{
                        throw new IOException("Contract ID has been used, please enter a new one.");
                    }
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Invalid Input while making Contract", 2);
                Logger.getLogger(AddContract.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jSaveActionPerformed

    private void jResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jResetActionPerformed
        jGoods.setText("");
        jContractID.setText("");
    }//GEN-LAST:event_jResetActionPerformed
    void addOriginCityListener(ItemListener listenForComboBox){
        jOriginCity.addItemListener(listenForComboBox);
    }
    void addDestinationCityListener(ItemListener listenForComboBox){
        jDestinationCity.addItemListener(listenForComboBox);
    }
    private void addSaveButtonListener(ActionListener listforSaveButton){
        jSave.addActionListener(listforSaveButton);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jCancel;
    private javax.swing.JTextField jContractID;
    private javax.swing.JComboBox<String> jDestinationCity;
    private javax.swing.JTextField jGoods;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox<String> jOriginCity;
    private javax.swing.JButton jReset;
    private javax.swing.JButton jSave;
    // End of variables declaration//GEN-END:variables
}
