package mySchedule;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Schedule {
    private JFrame frame;
    private DefaultTableModel model;

    public Schedule() {
        initializeUI();
    }

    private void initializeUI() {
        // Create and configure the main frame
        frame = new JFrame("Schedule");
        frame.setLayout(new BorderLayout());
        
        // Initialize and configure the task table
        initializeTable();
        
        // Create a panel for task addition and configure it
        JPanel addTaskPanel = createAddTaskPanel();
        
        // Add the table and task addition panel to the main frame
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(addTaskPanel, BorderLayout.SOUTH);

        // Final frame setup
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void initializeTable() {
        String[] columns = {"Date", "Task"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
    }

    private JPanel createAddTaskPanel() {
        JPanel addTaskPanel = new JPanel(new GridLayout(3, 4, 10, 10));
        JTextField taskField = new JTextField();
        JComboBox<String> dayComboBox = new JComboBox<>(generateDayArray());
        JComboBox<String> monthComboBox = new JComboBox<>(generateMonthArray());
        JComboBox<String> yearComboBox = new JComboBox<>(generateYearArray());

        JButton addTaskButton = new JButton("Add Task");
        JButton backToMenuButton = new JButton("Back to Menu");
        
        addTaskButton.addActionListener(e -> addTask(dayComboBox, monthComboBox, yearComboBox, taskField));
        backToMenuButton.addActionListener(e -> backToMenu());

        addComponentsToPanel(addTaskPanel, dayComboBox, monthComboBox, yearComboBox, taskField, addTaskButton, backToMenuButton);
        
        return addTaskPanel;
    }

    private String[] generateDayArray() {
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = Integer.toString(i);
        }
        return days;
    }

    private String[] generateMonthArray() {
        return new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    }

    private String[] generateYearArray() {
        String[] years = new String[50];
        for (int i = 0; i < 50; i++) {
            years[i] = Integer.toString(2023 + i);
        }
        return years;
    }

    private void addTask(JComboBox<String> day, JComboBox<String> month, JComboBox<String> year, JTextField taskField) {
        String task = taskField.getText();
        String date = month.getSelectedItem() + " " + day.getSelectedItem() + ", " + year.getSelectedItem();
        if (!task.isEmpty()) {
            model.addRow(new Object[]{date, task});
        }
    }

    private void backToMenu() {
        frame.dispose();
        new Menu();
    }

    private void addComponentsToPanel(JPanel panel, JComboBox<String> day, JComboBox<String> month, JComboBox<String> year, JTextField taskField, JButton addTaskButton, JButton backToMenuButton) {
        panel.add(new JLabel("Day: "));
        panel.add(day);
        panel.add(new JLabel("Month: "));
        panel.add(month);
        panel.add(new JLabel("Year: "));
        panel.add(year);
        panel.add(new JLabel("Task: "));
        panel.add(taskField);
        panel.add(addTaskButton);
        panel.add(backToMenuButton);
    }

    public static void main(String[] args) {
        new Schedule();
    }

    private JTable table;
}
