package mySchedule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private JFrame frame;
    
    public Menu() {
        frame = new JFrame("Main Menu");
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(3, 1)); // Updated to 3 rows for the additional button
        
        JButton scheduleButton = new JButton("Go to Schedule");
        JButton calendarButton = new JButton("View Calendar"); // New button for calendar
        JButton signOutButton = new JButton("Sign Out");

        scheduleButton.addActionListener(e -> new Schedule());
        
        // New ActionListener to open the calendar
        calendarButton.addActionListener(e -> new CalendarView()); // Replace 'null' with the tasks list if available

        signOutButton.addActionListener(e -> frame.dispose());

        panel.add(scheduleButton);
        panel.add(calendarButton);  // Added the new button here
        panel.add(signOutButton);

        frame.add(panel, BorderLayout.CENTER);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);  // Increased size to accommodate the new button
        frame.setVisible(true);
    }
}
