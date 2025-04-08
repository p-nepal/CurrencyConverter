/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package currencyconverter;

/**
 *
 * @author macka2859
 */
import javax.swing.*;
import java.util.HashMap;

public class CurrencyConverter {
    public static void main(String[] args) {
        // Create a HashMap to store conversion rates
        HashMap<String, Double> conversionRates = new HashMap<>();
        // Existing currencies with updated example rates
        conversionRates.put("USD to EUR", 0.91);  // Euro done
        conversionRates.put("EUR to USD", 1.10);  
        conversionRates.put("USD to RUB", 85.83); // Russian Ruble /done-half
        conversionRates.put("RUB to USD", 0.013); 
        conversionRates.put("USD to CHF", 0.85);  // Swiss Franc /done
        conversionRates.put("CHF to USD", 1.17);  
        conversionRates.put("USD to DKK", 6.83);  // Danish Krone /done
        conversionRates.put("DKK to USD", 0.15);  
        conversionRates.put("USD to NOK", 10.95);  // Norwegian Krone /done
        conversionRates.put("NOK to USD", 0.109);  
        conversionRates.put("USD to SEK", 10.04); // Swedish Krona
        conversionRates.put("SEK to USD", 0.10); 
        conversionRates.put("USD to UAH", 41); // Ukrainian Hryvnia // 2diff
        conversionRates.put("UAH to USD", 0.027);
        conversionRates.put("USD to AZN", 1.70);  // Azerbaijani Manat
        conversionRates.put("AZN to USD", 0.59);  
        conversionRates.put("USD to TRY", 23.56);  // Turkish Lira
        conversionRates.put("TRY to USD", 0.042);
        conversionRates.put("USD to CZK", 22.07); // Czech Koruna
        conversionRates.put("CZK to USD", 0.045); 
        conversionRates.put("USD to GEL", 3.14);  // Georgian Lari
        conversionRates.put("GEL to USD", 0.32);  
        conversionRates.put("USD to AMD", 387.49); // Armenian Dram
        conversionRates.put("AMD to USD", 0.0026);
        conversionRates.put("USD to KGS", 89.50);  // Kyrgyz Som
        conversionRates.put("KGS to USD", 0.011);  
        conversionRates.put("USD to MYR", 4.42);  // Malaysian Ringgit
        conversionRates.put("MYR to USD", 0.23);  
        conversionRates.put("USD to HKD", 7.85);  // Hong Kong Dollar
        conversionRates.put("HKD to USD", 0.13);  

        // Currency options
        String[] options = conversionRates.keySet().toArray(new String[0]);

        // Show selection dialog
        String choice = (String) JOptionPane.showInputDialog(null, 
                "Choose a conversion type:", 
                "Currency Converter", 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                options, 
                options[0]);

        if (choice != null) {
            String input = JOptionPane.showInputDialog("Enter the amount to convert:");
            try {
                double amount = Double.parseDouble(input);
                double rate = conversionRates.get(choice); // Get conversion rate from HashMap
                double convertedAmount = amount * rate; // Perform the conversion
                JOptionPane.showMessageDialog(null, "Converted amount: " + convertedAmount);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a numerical value.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No conversion type selected.");
        }
    }
}



