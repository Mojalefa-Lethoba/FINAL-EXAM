/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;


public class Product implements IProduct {

   
    private String[] productNames;

    
    private int[][] salesData;

    
    public Product(String[] names, int[][] data) {
        this.productNames = names;
        this.salesData = data;
    }

    
    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        
        for (int row = 0; row < salesData.length; row++) {
         
            for (int col = 0; col < salesData[row].length; col++) {
                total = total + salesData[row][col];
            }
        }
        return total;
    }

    
    @Override
    public double GetAverageProductSold() {
        int total = GetTotalProductsSold();
        
        int numberOfProducts = salesData.length;
        
        
        return (double) total / numberOfProducts;
    }

    
    @Override
    public String GetMostPopularProduct() {
        int topIndex = 0;            
        int highestTotal = 0;        

        
        for (int row = 0; row < salesData.length; row++) {
            int rowTotal = 0;
            
            for (int col = 0; col < salesData[row].length; col++) {
                rowTotal = rowTotal + salesData[row][col];
            }
            
            if (rowTotal > highestTotal) {
                highestTotal = rowTotal;
                topIndex = row;
            }
        }
        
        return productNames[topIndex];
    }
}
