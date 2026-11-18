/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;


public class PrintProduct {

    
    private Product product;

    
    public PrintProduct(Product product) {
        this.product = product;
    }

    
    public void PrintTotalSales() {
        System.out.println("Total products sold: " + product.GetTotalProductsSold());
    }

    
    public void PrintAverageSales() {
        
        System.out.println("Average products sold per product: " + String.format("%.2f", product.GetAverageProductSold()));
    }

    
    public void PrintMostPopularProduct() {
        System.out.println("Most popular product: " + product.GetMostPopularProduct());
    }
}