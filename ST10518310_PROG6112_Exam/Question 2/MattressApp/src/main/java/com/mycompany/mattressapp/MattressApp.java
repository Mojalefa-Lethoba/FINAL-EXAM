/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mattressapp;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.io.*; 


public class MattressApp extends JFrame implements ActionListener {

    
    JTextField txtCustomerName, txtPrice;
    JComboBox<String> cmbProduct;
    JTextArea textArea;
    JButton btnProcess;
    JMenuItem menuExit, menuProcess, menuClear;

    
    public MattressApp() {
        setTitle("Mattress Sales Application");
        setSize(450, 500);
        setLayout(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        JMenuBar menuBar = new JMenuBar();
        
        
        JMenu fileMenu = new JMenu("File");
        menuExit = new JMenuItem("Exit");
        menuExit.addActionListener(this); 
        fileMenu.add(menuExit);
        
        
        JMenu toolsMenu = new JMenu("Tools");
        menuProcess = new JMenuItem("Process");
        menuClear = new JMenuItem("Clear");
        menuProcess.addActionListener(this);
        menuClear.addActionListener(this);
        toolsMenu.add(menuProcess);
        toolsMenu.add(menuClear);
        
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

       
        JLabel lblName = new JLabel("Customer Name:");
        lblName.setBounds(30, 30, 120, 25); 
        add(lblName);
        
        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(160, 30, 200, 25);
        add(txtCustomerName);

        JLabel lblProduct = new JLabel("Product Name:");
        lblProduct.setBounds(30, 80, 120, 25);
        add(lblProduct);
        
        
        String[] mattresses = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        cmbProduct = new JComboBox<>(mattresses);
        cmbProduct.setBounds(160, 80, 200, 25);
        add(cmbProduct);

        JLabel lblPrice = new JLabel("Product Price (R):");
        lblPrice.setBounds(30, 130, 120, 25);
        add(lblPrice);
        
        txtPrice = new JTextField();
        txtPrice.setBounds(160, 130, 200, 25);
        add(txtPrice);

      
        btnProcess = new JButton("PROCESS");
        btnProcess.setBounds(160, 180, 200, 30);
        btnProcess.addActionListener(this);
        add(btnProcess);

        
        textArea = new JTextArea();
        textArea.setBounds(30, 230, 380, 200);
        textArea.setEditable(false);
        textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(textArea);
    }

    
    public void processSale() {
        try {
            
            String customerName = txtCustomerName.getText();
            String productName = (String) cmbProduct.getSelectedItem();
            
            double productPrice = Double.parseDouble(txtPrice.getText());

            
            ProductCalculations calc = new ProductCalculations(productPrice);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            
            
            String report = "CUSTOMER: " + customerName + "\n" +
                            "PRODUCT: " + productName + "\n" +
                            "PRICE: R " + productPrice + "\n" +
                            "VAT (15%): R " + vat + "\n" +
                            "COMMISSION (5%): R " + commission + "\n" +
                            "TOTAL SALES: R " + total;

           
            textArea.setText(report);

            FileWriter fw = new FileWriter("data.txt", true); 
            fw.write("--- NEW SALE ---\n");
            fw.write(report + "\n\n");
            fw.close(); 
            
            JOptionPane.showMessageDialog(this, "Sale processed and saved to data.txt!");

        } catch (NumberFormatException ex) {
            
            JOptionPane.showMessageDialog(this, "Please enter a valid number for the price.");
        } catch (IOException ex) {
            
            JOptionPane.showMessageDialog(this, "Error saving to file.");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
     
        if (e.getSource() == btnProcess || e.getSource() == menuProcess) {
            processSale();
        }
        
        
        if (e.getSource() == menuClear) {
            txtCustomerName.setText(""); 
            txtPrice.setText("");        
            cmbProduct.setSelectedIndex(0); 
            textArea.setText("");        
        }
        
        
        if (e.getSource() == menuExit) {
            System.exit(0); 
        }
    }

    
    public static void main(String[] args) {
        new MattressApp().setVisible(true);
    }
}