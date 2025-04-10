package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CurrencyConverter {
    public static void main(String[] args) {
        // Currency options
        Map<String, Double> conversionRates = new HashMap<>();
        conversionRates.put("United States Dollar", 1.0);    // Base
        conversionRates.put("Euro", 0.91);   // Euro /done
        conversionRates.put("Russian Ruble", 85.8);   // Russian Ruble /done
        conversionRates.put("Swiss Franc", 0.85);   // Swiss Franc /done
        conversionRates.put("Danish Krone", 6.83);   // Danish Krone /done
        conversionRates.put("Norwegian Kron", 10.95);  // Norwegian Krone /done
        conversionRates.put("Swedish Krona", 9.9);  // Swedish Krona /done
        conversionRates.put("Ukrainian Hryvnia", 41.0);   // Ukrainian Hryvnia /done
        conversionRates.put("Azerbaijani Manat", 1.7);    // Azerbaijani Manat /done
        conversionRates.put("Turkish Lir", 38.01);  // Turkish Lira /done
        conversionRates.put("Czech Koruna", 23.00);  // Czech Koruna /done
        conversionRates.put("Georgian Lari", 2.75);   // Georgian Lari /done
        conversionRates.put("Armenian Dram", 391.40); // Armenian Dram /2diff
        conversionRates.put("Malaysian Ringgit", 4.49);   // Malaysian Ringgit / done
        conversionRates.put("Hong Kong Dollar", 7.77);   // Hong Kong Dollar /done
        conversionRates.put("British Pound", 0.78);   // British Pound /done
        conversionRates.put("Australian Dollar", 1.67);   // Australian Dollar /done
        conversionRates.put("Fijian Dollar", 2.34);   // Fijian Dollar 2/diff
        conversionRates.put("Papua New Guinea Kina", 4.10);   // Papua New Guinea Kina 2/diff
        conversionRates.put("Samoan Tala", 2.84);   // Samoan Tala 2/diff
        conversionRates.put("Solomon Islands Dollar", 8.32);   // Solomon Islands Dollar 2/diff
        conversionRates.put("Tongan Paʻanga", 2.37);   // Tongan Paʻanga /done
        conversionRates.put("Vanuatu Vatu", 126.0);  // Vanuatu Vatu
        conversionRates.put("Bhutanese Ngultrum", 86.09);  // Bhutanese Ngultrum
        conversionRates.put("Maldives Rufiyaa", 15.4);   // Maldives Rufiyaa
        conversionRates.put("Sri Lankan Rupee", 295.0);  // Sri Lankan Rupee
        conversionRates.put("Nepali Rupee", 130.0);  // Nepali Rupee
        conversionRates.put("Bangladeshi Taka", 108.0);  // Bangladeshi Taka
        conversionRates.put("Myanmar Kyat", 2100.0); // Myanmar Kyat
        conversionRates.put("Vietnamese Dong", 23500.0);// Vietnamese Dong
        conversionRates.put("Thai Baht", 34.0);   // Thai Baht
        conversionRates.put("Indonesian Rupiah", 15000.0);// Indonesian Rupiah
        conversionRates.put("Singapore Dollar", 1.3);    // Singapore Dollar
        conversionRates.put("Philippine Peso", 56.0);   // Philippine Peso
        conversionRates.put("Chinese Yuan", 6.9);    // Chinese Yuan
        conversionRates.put("Japanese Yen", 144.57);  // Japanese Yen
        conversionRates.put("South Korean Won", 1350.0); // South Korean Won
        conversionRates.put("Albanian Lek", 89.24); // Albanian Lek
        conversionRates.put("Aruban Florin", 1.8025); // Aruban Florin
        conversionRates.put("Belarusian Ruble", 3.2740); // Belarusian Ruble
        conversionRates.put("Bosnia-Herzegovina Convertible Mark", 1.7660); // Bosnia-Herzegovina Convertible Mark
        conversionRates.put("Brunei Dollar", 1.3365); // Brunei Dollar
        conversionRates.put("Bulgarian Lev", 1.7449); // Bulgarian Lev
        conversionRates.put("CFP Franc", 107.6859); // CFP Franc - French Polynesia's Currency
        conversionRates.put("Cambodian Riel", 4006.357); // Cambodian Riel
        conversionRates.put("Serbian Dinar", 104.39); // Serbia Dinar
        conversionRates.put("Romanian Leu", 4.44); // Romanian Leu
        conversionRates.put("Polish Złoty", 3.79); // Polish Złoty
        conversionRates.put("New Zealand Dollar", 1.74); // New Zealand Dollar
        conversionRates.put("New Taiwan dollar", 32.79); // Polish Złoty

        
        String[] currencies = conversionRates.keySet().toArray(new String[0]);

        Arrays.sort(currencies); // This sorts all the values by alphabetical order

        // Components
        JComboBox<String> fromCurrency = new JComboBox<>(currencies);
        JComboBox<String> toCurrency = new JComboBox<>(currencies);
        JTextField amountField = new JTextField();
        JButton button = new JButton("Click Me!");

        // Panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Welcome to the Currency Converter!"));
        panel.add(new JLabel("Convert from:"));
        panel.add(fromCurrency);
        panel.add(new JLabel("Convert to:"));
        panel.add(toCurrency);
        panel.add(new JLabel("Switch: "));
        panel.add(button);
        panel.add(new JLabel("Enter amount:"));
        panel.add(amountField);

        int result = JOptionPane.showConfirmDialog(null, panel, 
                 "Currency Converter Menu", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String from = (String) fromCurrency.getSelectedItem();
                String to = (String) toCurrency.getSelectedItem();
                double amount = Double.parseDouble(amountField.getText());

                double fromRate = conversionRates.get(from);
                double toRate = conversionRates.get(to);

                // Formula: amount * (toRate / fromRate)
                double converted = amount * (toRate / fromRate);

                JOptionPane.showMessageDialog(null,
                        String.format("%.2f %s = %.2f %s", amount, from, converted, to));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
    }
}