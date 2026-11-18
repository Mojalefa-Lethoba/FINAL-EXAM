/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import com.mycompany.main.Product;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ProductTest {

    
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        
        String[] testNames = {"A", "B", "C"};
        int[][] testData = {
            {50, 60, 45},
            {70, 55, 65},
            {40, 50, 55}
        };
        Product p = new Product(testNames, testData);

        
        assertEquals(490, p.GetTotalProductsSold());
    }

    
    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        String[] testNames = {"A", "B", "C"};
        int[][] testData = {
            {50, 60, 45},
            {70, 55, 65},
            {40, 50, 55}
        };
        Product p = new Product(testNames, testData);

        
        assertEquals(163.33, p.GetAverageProductSold(), 0.01);
    }
}