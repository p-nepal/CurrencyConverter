package com.example;

import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CurrencyConverter {
    public static void main(String[] args) {
        // Currency options
        Map<String, Double> currencyRates = new HashMap<>();
        currencyRates.put("United States Dollar - USD", 1.0000);
        currencyRates.put("Euro - EUR", 1.0931);
        currencyRates.put("Great British Pound - GBP", 1.2779);
        currencyRates.put("Japanese Yen - JPY", 0.0068);
        currencyRates.put("Russian Ruble - RUB", 0.0120);
        
        String[] currencies = currencyRates.keySet().toArray(new String[0]);

        // Components
        JComboBox<String> fromCurrency = new JComboBox<>(currencies);
        JComboBox<String> toCurrency = new JComboBox<>(currencies);
        JTextField amountField = new JTextField();

        // Panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Welcome to the Currency Converter!"));
        panel.add(new JLabel("Convert from:"));
        panel.add(fromCurrency);
        panel.add(new JLabel("Convert to:"));
        panel.add(toCurrency);
        panel.add(new JLabel("Enter amount:"));
        panel.add(amountField);

        int result = JOptionPane.showConfirmDialog(null, panel, 
                 "Currency Converter Menu", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String from = (String) fromCurrency.getSelectedItem();
                String to = (String) toCurrency.getSelectedItem();
                double amount = Double.parseDouble(amountField.getText());

                double fromRate = currencyRates.get(from);
                double toRate = currencyRates.get(to);

                // Formula: amount * (toRate / fromRate)
                double converted = amount * (fromRate / toRate);

                JOptionPane.showMessageDialog(null,
                        String.format("%.2f %s = %.2f %s", amount, from, converted, to));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
    }
}