/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

public class Main {
    public static void main(String[] args) {

       
        String[] productNames = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        
        int[][] salesData = {
            {50, 60, 45},  // Cozy Nights Monarch
            {70, 55, 65},  // Restonic Barbados
            {40, 50, 55}   // Sealy Phuket
        };

       
        Product product = new Product(productNames, salesData);

      
        PrintProduct printer = new PrintProduct(product);

     
        System.out.println("=========================================");
        System.out.println("MATTRESS SALES REPORT");
        System.out.println("=========================================");

        // Show the raw grid data
        System.out.println("JAN\tFEB\tMAR");
        for (int i = 0; i < salesData.length; i++) {
            System.out.println(salesData[i][0] + "\t" + salesData[i][1] + "\t" + salesData[i][2]);
        }
        System.out.println("-----------------------------------------");

        
        printer.PrintTotalSales();
        printer.PrintAverageSales();
        printer.PrintMostPopularProduct();
    }
}
