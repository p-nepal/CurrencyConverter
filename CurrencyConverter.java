/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package currencyconverter;

/**
 *
 * @author macka2859
 */
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class CurrencyConverter {
    public static void main(String[] args) {
        Map<String, Double> conversionRates = new HashMap<>();
        conversionRates.put("---Select Currency---", 0.00);
        conversionRates.put("Albanian Lek", 89.24);
        conversionRates.put("United States Dollar", 1.0);
        conversionRates.put("Euro", 0.91);
        conversionRates.put("Russian Ruble", 85.8);
        conversionRates.put("Swiss Franc", 0.85);
        conversionRates.put("Danish Krone", 6.83);
        conversionRates.put("Norwegian Kron", 10.95);
        conversionRates.put("Swedish Krona", 9.9);
        conversionRates.put("Ukrainian Hryvnia", 41.0);
        conversionRates.put("Azerbaijani Manat", 1.7);
        conversionRates.put("Turkish Lir", 38.01);
        conversionRates.put("Czech Koruna", 23.00);
        conversionRates.put("Georgian Lari", 2.75);
        conversionRates.put("Armenian Dram", 391.40);
        conversionRates.put("Malaysian Ringgit", 4.49);
        conversionRates.put("Hong Kong Dollar", 7.77);
        conversionRates.put("British Pound", 0.78);
        conversionRates.put("Australian Dollar", 1.67);
        conversionRates.put("Fijian Dollar", 2.34);
        conversionRates.put("Papua New Guinea Kina", 4.10);
        conversionRates.put("Samoan Tala", 2.84);
        conversionRates.put("Solomon Islands Dollar", 8.32);
        conversionRates.put("Tongan Paʻanga", 2.37);
        conversionRates.put("Vanuatu Vatu", 126.0);
        conversionRates.put("Bhutanese Ngultrum", 86.09);
        conversionRates.put("Maldives Rufiyaa", 15.4);
        conversionRates.put("Sri Lankan Rupee", 295.0);
        conversionRates.put("Nepali Rupee", 130.0);
        conversionRates.put("Bangladeshi Taka", 108.0);
        conversionRates.put("Myanmar Kyat", 2100.0);
        conversionRates.put("Vietnamese Dong", 23500.0);
        conversionRates.put("Thai Baht", 34.0);
        conversionRates.put("Indonesian Rupiah", 15000.0);
        conversionRates.put("Singapore Dollar", 1.3);
        conversionRates.put("Philippine Peso", 56.0);
        conversionRates.put("Chinese Yuan", 6.9);
        conversionRates.put("Japanese Yen", 144.57);
        conversionRates.put("South Korean Won", 1350.0);
        conversionRates.put("Aruban Florin", 1.8025);
        conversionRates.put("Belarusian Ruble", 3.2740);
        conversionRates.put("Bosnia-Herzegovina Convertible Mark", 1.7660);
        conversionRates.put("Brunei Dollar", 1.3365);
        conversionRates.put("Bulgarian Lev", 1.7449);
        conversionRates.put("CFP Franc", 107.6859);
        conversionRates.put("Cambodian Riel", 4006.357);
        conversionRates.put("Serbian Dinar", 104.39);
        conversionRates.put("Romanian Leu", 4.44);
        conversionRates.put("Polish Złoty", 3.79);
        conversionRates.put("New Zealand Dollar", 1.74);
        conversionRates.put("New Taiwan dollar", 32.79);
        conversionRates.put("Moldovan Leu", 16.97);
        conversionRates.put("Macedonian Denar", 53.81);
        conversionRates.put("Macanese Pataca", 7.99);
        conversionRates.put("Laotain Kip", 21589.93);
        conversionRates.put("Kazakhstani Tenge", 21589.93);
        conversionRates.put("Indian Rupee", 85.19);
        conversionRates.put("Hungarian Forint", 355.40);
        conversionRates.put("Georgian Lari", 2.74);

        String[] currencies = conversionRates.keySet().toArray(new String[0]);
        Arrays.sort(currencies);

        JComboBox<String> fromCurrency = new JComboBox<>(currencies);
        JComboBox<String> toCurrency = new JComboBox<>(currencies);
        JTextField amountField = new JTextField();
        JButton swapButton = new JButton("Swap");
        JButton clearButton = new JButton("Clear");
        JButton transactionHistory = new JButton("Transactions");
        DefaultListModel<String> historyModel = new DefaultListModel<>();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(40, 40, 40));
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.CYAN, 2),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        Font labelFont = new Font("Consolas", Font.BOLD, 16);
        Color textColor = Color.WHITE;

        JLabel titleLabel = new JLabel("\uD83D\uDCB1 Currency Converter");
        titleLabel.setFont(new Font("Consolas", Font.BOLD, 22));
        titleLabel.setForeground(Color.CYAN);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(15));

        String[] labels = {"Convert from:", "Convert to:", "Enter amount:", "Switch:", "Clear:", "Transactions:"};
        JComponent[] components = {fromCurrency, toCurrency, amountField, swapButton, clearButton, transactionHistory};

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            label.setFont(labelFont);
            label.setForeground(textColor);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(label);

            JComponent comp = components[i];
            comp.setAlignmentX(Component.CENTER_ALIGNMENT);
            if (comp instanceof JTextField) {
                comp.setMaximumSize(new Dimension(200, 25));
                comp.setBackground(new Color(30, 30, 30));
                comp.setForeground(Color.GREEN);
            } else if (comp instanceof JButton) {
                comp.setBackground(new Color(60, 60, 60));
                comp.setForeground(Color.WHITE);
                ((JButton) comp).setFocusPainted(false);
            }
            panel.add(comp);
            panel.add(Box.createVerticalStrut(10));
        }

        swapButton.addActionListener(e -> {
            Object from = fromCurrency.getSelectedItem();
            Object to = toCurrency.getSelectedItem();
            fromCurrency.setSelectedItem(to);
            toCurrency.setSelectedItem(from);
        });

        clearButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear everything?", "Confirm Action", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                fromCurrency.setSelectedItem("---Select Currency---");
                toCurrency.setSelectedItem("---Select Currency---");
                amountField.setText("");
            }
        });

        transactionHistory.addActionListener(e -> {
            if (historyModel.isEmpty()) {
                JOptionPane.showMessageDialog(null, "You have not completed any transactions yet.", "Transaction History", JOptionPane.INFORMATION_MESSAGE);
            } else {
                StringBuilder historyText = new StringBuilder();
                for (int i = 0; i < historyModel.size(); i++) {
                    historyText.append(historyModel.getElementAt(i)).append("\n");
                }
                JOptionPane.showMessageDialog(null, historyText.toString(), "Transaction History", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        boolean stop = false;
        while (!stop) {
            int result = JOptionPane.showConfirmDialog(null, panel, "Currency Converter Menu", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.CANCEL_OPTION) {
                int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to leave the program?", "Currency Converter", JOptionPane.OK_OPTION);
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
                        JOptionPane.showMessageDialog(null, "You need to select two currencies", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        double converted = amount * (toRate / fromRate);
                        String logEntry = amount + " " + from + " = " + converted + " " + to;
                        historyModel.addElement(logEntry);
                        JOptionPane.showMessageDialog(null, String.format("%.2f %s = %.2f %s", amount, from, converted, to));
                        int stopChoice = JOptionPane.showConfirmDialog(null, "Would you like to run the program again?", "Currency Converter", JOptionPane.OK_OPTION);
                        if (stopChoice != JOptionPane.OK_OPTION) {
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
