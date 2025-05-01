/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class CurrencyConverterOrganized {
    public static void main(String[] args) {
        // Hash Map (Dictionary) used to store key-value pairs for currency conversion rates
        Map<String, Double> conversionRates = new HashMap<>();
        conversionRates.put("---Select Currency---", 0.00); // Default option for currency selection
        conversionRates.put("Albanian Lek", 89.24); // Albania
        conversionRates.put("United States Dollar", 1.0); // USA (Base currency)
        conversionRates.put("Euro", 0.91); // Eurozone (Multiple countries)
        conversionRates.put("Russian Ruble", 85.8); // Russia
        conversionRates.put("Swiss Franc", 0.85); // Switzerland
        conversionRates.put("Danish Krone", 6.83); // Denmark
        conversionRates.put("Norwegian Kron", 10.95); // Norway
        conversionRates.put("Swedish Krona", 9.9); // Sweden
        conversionRates.put("Ukrainian Hryvnia", 41.0); // Ukraine
        conversionRates.put("Azerbaijani Manat", 1.7); // Azerbaijan
        conversionRates.put("Turkish Lira", 38.01); // Turkey
        conversionRates.put("Czech Koruna", 23.00); // Czech Republic
        conversionRates.put("Georgian Lari", 2.75); // Georgia
        conversionRates.put("Armenian Dram", 391.40); // Armenia
        conversionRates.put("Malaysian Ringgit", 4.49); // Malaysia
        conversionRates.put("Hong Kong Dollar", 7.77); // Hong Kong
        conversionRates.put("British Pound", 0.78); // United Kingdom
        conversionRates.put("Australian Dollar", 1.67); // Australia
        conversionRates.put("Fijian Dollar", 2.34); // Fiji
        conversionRates.put("Papua New Guinea Kina", 4.10); // Papua New Guinea
        conversionRates.put("Samoan Tala", 2.84); // Samoa
        conversionRates.put("Solomon Islands Dollar", 8.32); // Solomon Islands
        conversionRates.put("Tongan Paʻanga", 2.37); // Tonga
        conversionRates.put("Vanuatu Vatu", 126.0); // Vanuatu
        conversionRates.put("Bhutanese Ngultrum", 86.09); // Bhutan
        conversionRates.put("Maldives Rufiyaa", 15.4); // Maldives
        conversionRates.put("Sri Lankan Rupee", 295.0); // Sri Lanka
        conversionRates.put("Nepali Rupee", 130.0); // Nepal
        conversionRates.put("Bangladeshi Taka", 108.0); // Bangladesh
        conversionRates.put("Myanmar Kyat", 2100.0); // Myanmar
        conversionRates.put("Vietnamese Dong", 23500.0); // Vietnam
        conversionRates.put("Thai Baht", 34.0); // Thailand
        conversionRates.put("Indonesian Rupiah", 15000.0); // Indonesia
        conversionRates.put("Singapore Dollar", 1.3); // Singapore
        conversionRates.put("Philippine Peso", 56.0); // Philippines
        conversionRates.put("Chinese Yuan", 6.9); // China
        conversionRates.put("Japanese Yen", 144.57); // Japan
        conversionRates.put("South Korean Won", 1350.0); // South Korea
        conversionRates.put("Aruban Florin", 1.8025); // Aruba
        conversionRates.put("Belarusian Ruble", 3.2740); // Belarus
        conversionRates.put("Bosnia-Herzegovina Convertible Mark", 1.7660); // Bosnia and Herzegovina
        conversionRates.put("Brunei Dollar", 1.3365); // Brunei
        conversionRates.put("Bulgarian Lev", 1.7449); // Bulgaria
        conversionRates.put("CFP Franc", 107.6859); // French Polynesia
        conversionRates.put("Cambodian Riel", 4006.357); // Cambodia
        conversionRates.put("Serbian Dinar", 104.39); // Serbia
        conversionRates.put("Romanian Leu", 4.44); // Romania
        conversionRates.put("Polish Złoty", 3.79); // Poland
        conversionRates.put("New Zealand Dollar", 1.74); // New Zealand
        conversionRates.put("New Taiwan dollar", 32.79); // Taiwan
        conversionRates.put("Moldovan Leu", 16.97); // Moldova
        conversionRates.put("Macedonian Denar", 53.81); // North Macedonia
        conversionRates.put("Macanese Pataca", 7.99); // Macau
        conversionRates.put("Laotian Kip", 21589.93); // Laos
        conversionRates.put("Kazakhstani Tenge", 21589.93); // Kazakhstan
        conversionRates.put("Indian Rupee", 85.19 ); // India, Bhutan
        conversionRates.put("Hungarian Forint", 355.40); // Hungary
        conversionRates.put("Georgian Lari", 2.74); // Georgia
        
        // Create a list of currency names, sorted alphabetically
        String[] currencies = conversionRates.keySet().toArray(new String[0]);
        Arrays.sort(currencies);

        // Creating the components for the GUI
        JComboBox<String> fromCurrency = new JComboBox<>(currencies); // Dropdown menu for "from" currency
        JComboBox<String> toCurrency = new JComboBox<>(currencies); // Dropdown menu for "to" currency
        JTextField amountField = new JTextField(); // Input field for the amount
        JButton swapButton = new JButton("Swap"); // Button to swap currencies
        JButton clearButton = new JButton("Clear "); // Button to clear selections
        JButton transactionHistory = new JButton("Transactions"); // Button to view transaction history
        DefaultListModel<String> historyModel = new DefaultListModel<>(); // List model for transaction history

        // Panel to hold components and set layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Set layout to vertical

        // ActionListener for Swap button
        swapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get selected currencies
                Object from = fromCurrency.getSelectedItem();
                Object to = toCurrency.getSelectedItem();
                
                // Swap the selected currencies
                fromCurrency.setSelectedItem(to);
                toCurrency.setSelectedItem(from);
            }
        });

        // ActionListener for Clear button
        clearButton.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                // Confirm with the user if they want to clear everything, double check
                int result = JOptionPane.showConfirmDialog(
                    null, 
                    "Are you sure you want to clear everything?", 
                    "Confirm Action", 
                    JOptionPane.YES_NO_OPTION
                );
                
                // Clear selections if the user confirms
                if (result == JOptionPane.YES_OPTION) {
                    fromCurrency.setSelectedItem("---Select Currency---");
                    toCurrency.setSelectedItem("---Select Currency---");
                }
            }
        });

        // ActionListener for Transaction History button
        transactionHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if there are any transactions to display
                if (historyModel.size() < 1) {
                    JOptionPane.showMessageDialog(null, "You have not completed any transactions yet.", "Transaction History", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Display transaction history
                    // Only if there is at least one
                    StringBuilder historyText = new StringBuilder();
                    for (int i = 0; i < historyModel.size(); i++) {
                        historyText.append(historyModel.getElementAt(i)).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, historyText.toString(), "Transaction History", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Adding components to the main menu panel with Jlabels
        panel.add(new JLabel("Currency Converter"));
        panel.add(new JLabel("Convert from:"));
        panel.add(fromCurrency); // JComboBox for "from" currency
        panel.add(new JLabel("Convert to:"));
        panel.add(toCurrency); // JComboBox for "to" currency
        panel.add(new JLabel("Switch: "));
        panel.add(swapButton); // JButton for swapping currencies
        panel.add(new JLabel("Clear: "));
        panel.add(clearButton); // JButton for clearing selections
        panel.add(new JLabel("Enter amount:"));
        panel.add(amountField); // JTextField for entering amount
        panel.add(new JLabel("Transactions"));
        panel.add(transactionHistory); // JButton for viewing transaction history

        // Main loop for displaying the menu and handling user actions
        boolean stop = false;
        while (!stop) {
            // Display the main menu dialog box
            int result = JOptionPane.showConfirmDialog(null, panel, 
                    "Currency Converter Menu", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            // Handle "Cancel" action (exit program)
            if (result == JOptionPane.CANCEL_OPTION) {
                int exit = JOptionPane.showConfirmDialog(null, 
                    "Are you sure you want to leave the program?", "Currency Converter", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (exit == JOptionPane.OK_OPTION) {
                    JOptionPane.showMessageDialog(null,"Thank you for using this program!");
                    break;
                }
            }
            
            // Handle "OK" action to perform conversion
            if (result == JOptionPane.OK_OPTION) {
                try {
                    String from = (String) fromCurrency.getSelectedItem();
                    String to = (String) toCurrency.getSelectedItem();
                    double amount = Double.parseDouble(amountField.getText());

                    // Get conversion rates for selected currencies
                    double fromRate = conversionRates.get(from);
                    double toRate = conversionRates.get(to);

                    // If a currency are not selected, an error will occur
                    if (fromRate == 0 || toRate == 0) {
                        JOptionPane.showMessageDialog(
                                    null,
                                    "You need to select two currencies",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    } else {
                        // Convert the amount using the formula: amount * (toRate / fromRate)
                        double converted = amount * (toRate / fromRate);

                        // Display the conversion result
                        JOptionPane.showMessageDialog(null,
                            String.format("%.2f %s = %.2f %s", amount, from, converted, to));
                            
                        // Log the transaction in the history
                        String logEntry = String.format("%.2f %s = %.2f %s", amount, from, converted, to);
                        historyModel.addElement(logEntry);

                        // Ask if the user wants to perform another conversion
                        int stopChoice = JOptionPane.showConfirmDialog(null, 
                        "Would you like to run the program again?", "Currency Converter", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE);
                        if (stopChoice == JOptionPane.OK_OPTION) {
                            continue;
                        }
                        else {
                            JOptionPane.showMessageDialog(null,"Thank you for using this program!");
                            break;
                        } 
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                }
            }
        }
    }
}
