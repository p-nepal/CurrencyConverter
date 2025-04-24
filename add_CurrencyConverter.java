package com.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.Border;

public class CurrencyConverter {
    public static void main(String[] args) {
        // Hash Map (Dictionary) used to store key-value pairs
        Map<String, Double> conversionRates = new HashMap<>();
        conversionRates.put("---Select Currency---", 0.00);
        conversionRates.put("United States Dollar", 1.0); // Base
        conversionRates.put("Euro", 0.91); // Euro
        // Add other currencies as you already have in your original code.

        String[] currencies = conversionRates.keySet().toArray(new String[0]);
        Arrays.sort(currencies);

        // Components
        JComboBox<String> fromCurrency = new JComboBox<>(currencies);
        JComboBox<String> toCurrency = new JComboBox<>(currencies);
        JTextField amountField = new JTextField();
        JButton swapButton = new JButton("Swap");
        JButton clearButton = new JButton("Clear");
        JButton transactionHistory = new JButton("Transactions");
        DefaultListModel<String> historyModel = new DefaultListModel<>();

        // Set custom font for a more futuristic feel
        Font customFont = new Font("Arial", Font.BOLD, 14);
        
        // Create a custom panel with gaming-style background
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(30, 30, 30)); // Dark background to give a gaming vibe
        
        // Add some border effects to buttons
        Border buttonBorder = BorderFactory.createRaisedBevelBorder();
        
        // Set fonts and borders for components
        fromCurrency.setFont(customFont);
        toCurrency.setFont(customFont);
        amountField.setFont(customFont);
        swapButton.setFont(customFont);
        clearButton.setFont(customFont);
        transactionHistory.setFont(customFont);

        // Make buttons look like glowing gaming buttons
        swapButton.setBackground(Color.DARK_GRAY);
        swapButton.setForeground(Color.CYAN);
        swapButton.setBorder(buttonBorder);

        clearButton.setBackground(Color.DARK_GRAY);
        clearButton.setForeground(Color.RED);
        clearButton.setBorder(buttonBorder);

        transactionHistory.setBackground(Color.DARK_GRAY);
        transactionHistory.setForeground(Color.GREEN);
        transactionHistory.setBorder(buttonBorder);

        // Add components to panel
        panel.add(new JLabel("Currency Converter"));
        panel.add(new JLabel("Convert from:"));
        panel.add(fromCurrency);
        panel.add(new JLabel("Convert to:"));
        panel.add(toCurrency);
        panel.add(new JLabel("Switch:"));
        panel.add(swapButton);
        panel.add(new JLabel("Clear:"));
        panel.add(clearButton);
        panel.add(new JLabel("Enter amount:"));
        panel.add(amountField);
        panel.add(new JLabel("Transactions"));
        panel.add(transactionHistory);

        // Set a background image
        try {
            panel.setOpaque(false); // Make the panel transparent
            ImageIcon bgImage = new ImageIcon("path_to_your_background_image.jpg");
            JLabel background = new JLabel(bgImage);
            panel.add(background);
        } catch (Exception e) {
            // If the background image is not found, we skip it
            System.out.println("Error loading background image.");
        }

        // Swap button action listener
        swapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object from = fromCurrency.getSelectedItem();
                Object to = toCurrency.getSelectedItem();
                fromCurrency.setSelectedItem(to);
                toCurrency.setSelectedItem(from);
            }
        });

        // Clear button action listener
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(
                    null, 
                    "Are you sure you want to clear everything?", 
                    "Confirm Action", 
                    JOptionPane.YES_NO_OPTION
                );
                if (result == JOptionPane.YES_OPTION) {
                    fromCurrency.setSelectedItem("---Select Currency---");
                    toCurrency.setSelectedItem("---Select Currency---");
                    amountField.setText("");
                }
            }
        });

        // Transaction History button listener
        transactionHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (historyModel.size() < 1) {
                    JOptionPane.showMessageDialog(null, "You have not completed any transactions yet.", "Transaction History", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    StringBuilder historyText = new StringBuilder();
                    for (int i = 0; i < historyModel.size(); i++) {
                        historyText.append(historyModel.getElementAt(i)).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, historyText.toString(), "Transaction History", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // The menu screen with gaming design
        boolean stop = false;
        while (!stop) {
            int result = JOptionPane.showConfirmDialog(null, panel,
                    "Currency Converter Menu", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.CANCEL_OPTION) {
                int exit = JOptionPane.showConfirmDialog(null, 
                    "Are you sure you want to leave the program?", "Currency Converter", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (exit == JOptionPane.OK_OPTION) {
                    JOptionPane.showMessageDialog(null, "Thank you for using this program!");
                    break;
                }
            }
            if (result == JOptionPane.OK_OPTION) {
                try {
                    String from = (String) fromCurrency.getSelectedItem();
                    String to = (String) toCurrency.getSelectedItem();
                    double amount = Double.parseDouble(amountField.getText());
                    double fromRate = conversionRates.get(from);
                    double toRate = conversionRates.get(to);

                    if (fromRate == 0 || toRate == 0) {
                        JOptionPane.showMessageDialog(null,
                            "You need to select two currencies", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        double converted = amount * (toRate / fromRate);
                        JOptionPane.showMessageDialog(null, 
                            String.format("%.2f %s = %.2f %s", amount, from, converted, to));
                        String logEntry = amount + " " + from + " = " + converted + " " + to;
                        historyModel.addElement(logEntry);

                        int stopChoice = JOptionPane.showConfirmDialog(null, 
                            "Would you like to run the program again?", "Currency Converter", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE);
                        if (stopChoice == JOptionPane.OK_OPTION) {
                            continue;
                        } else {
                            JOptionPane.showMessageDialog(null, "Thank you for using this program!");
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
