/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.mattressapp.ProductCalculations;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductCalculationsTest {

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
      
        ProductCalculations calc = new ProductCalculations(1000.0);
        
       
        assertEquals(150.0, calc.GetVat(), 0.01);
    }

 
    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(1000.0);
        
      
        assertEquals(1200.0, calc.GetTotal(), 0.01);
    }
}