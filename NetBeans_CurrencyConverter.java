package currencyconverter;

/**
 *
 * @author macka2859
 */
import javax.swing.*;
import java.util.HashMap;

public class CurrencyConverter {
    public static void main(String[] args) {
        // Create a HashMap to store conversion rates relative to USD
        HashMap<String, Double> conversionRates = new HashMap<>();
        conversionRates.put("USD", 1.0);     // Base
        conversionRates.put("EUR", 0.91);   // Euro /done
        conversionRates.put("RUB", 85.8);   // Russian Ruble /done
        conversionRates.put("CHF", 0.85);   // Swiss Franc /done
        conversionRates.put("DKK", 6.83);   // Danish Krone /done
        conversionRates.put("NOK", 10.95);  // Norwegian Krone /done
        conversionRates.put("SEK", 10.04);  // Swedish Krona /done
        conversionRates.put("UAH", 41.0);   // Ukrainian Hryvnia /done
        conversionRates.put("AZN", 1.7);    // Azerbaijani Manat /done
        conversionRates.put("TRY", 38.01);  // Turkish Lira /done
        conversionRates.put("CZK", 23.00);  // Czech Koruna /done
        conversionRates.put("GEL", 2.75);   // Georgian Lari /done
        conversionRates.put("AMD", 391.40); // Armenian Dram /2diff
        conversionRates.put("KGS", 87.03);   // Kyrgyz Som /2diff
        conversionRates.put("MYR", 4.49);   // Malaysian Ringgit / done
        conversionRates.put("HKD", 7.77);   // Hong Kong Dollar /done
         // Newly added currencies and their rates
        conversionRates.put("GBP", 0.78);   // British Pound /done
        conversionRates.put("AUD", 1.67);    // Australian Dollar /done
        conversionRates.put("FJD", 2.34);    // Fijian Dollar 2/diff
        conversionRates.put("PGK", 4.10);    // Papua New Guinea Kina 2/diff
        conversionRates.put("WST", 2.84);    // Samoan Tala 2/diff
        conversionRates.put("SBD", 8.32);    // Solomon Islands Dollar 2/diff
        conversionRates.put("TOP", 2.37);    // Tongan Paʻanga /done
        conversionRates.put("VUV", 126.0);  // Vanuatu Vatu
        conversionRates.put("BTN", 86.09);   // Bhutanese Ngultrum
        conversionRates.put("MVR", 15.4);   // Maldives Rufiyaa
        conversionRates.put("LKR", 290.0);  // Sri Lankan Rupee
        conversionRates.put("NPR", 130.0);  // Nepali Rupee
        conversionRates.put("BDT", 108.0);  // Bangladeshi Taka
        conversionRates.put("MMK", 2100.0); // Myanmar Kyat
        conversionRates.put("VND", 23500.0);// Vietnamese Dong
        conversionRates.put("THB", 34.0);   // Thai Baht
        conversionRates.put("IDR", 15000.0);// Indonesian Rupiah
        conversionRates.put("UZS", 11500.0);// Uzbek Som
        conversionRates.put("TMT", 3.5);    // Turkmenistan Manat
        conversionRates.put("SGD", 1.3);    // Singapore Dollar
        conversionRates.put("PHP", 56.0);   // Philippine Peso
        conversionRates.put("CNY", 6.9);    // Chinese Yuan
        conversionRates.put("JPY", 130.0);  // Japanese Yen
        conversionRates.put("KRW", 1350.0); // South Korean Won
        
        // Currency options for dropdown selection
        String[] currencies = conversionRates.keySet().toArray(new String[0]);

        // Show dropdown to select "From" currency
        String fromCurrency = (String) JOptionPane.showInputDialog(null,
                "Select the currency you want to convert from:",
                "Currency Converter - From Currency",
                JOptionPane.QUESTION_MESSAGE,
                null,
                currencies,
                "USD");

        // Show dropdown to select "To" currency
        String toCurrency = (String) JOptionPane.showInputDialog(null,
                "Select the currency you want to convert to:",
                "Currency Converter - To Currency",
                JOptionPane.QUESTION_MESSAGE,
                null,
                currencies,
                "EUR");

        if (fromCurrency != null && toCurrency != null) {
            String input = JOptionPane.showInputDialog("Enter the amount in " + fromCurrency + ":");
            try {
                double amount = Double.parseDouble(input);
                // Calculate conversion
                double rateFrom = conversionRates.get(fromCurrency);
                double rateTo = conversionRates.get(toCurrency);
                double convertedAmount = (amount / rateFrom) * rateTo;

                // Show result
                JOptionPane.showMessageDialog(null, String.format("%.2f %s is equivalent to %.2f %s", 
                        amount, fromCurrency, convertedAmount, toCurrency));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid numerical value.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Currency conversion canceled.");
        }
    }
}


