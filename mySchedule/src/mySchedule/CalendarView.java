package mySchedule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarView {
    private JFrame frame;
    private JPanel calendarPanel;
    private JComboBox<String> monthComboBox;
    private JComboBox<String> yearComboBox;

    public CalendarView() {
        frame = new JFrame("Simple Calendar View");
        frame.setLayout(new BorderLayout());

        monthComboBox = new JComboBox<>(new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"});
        yearComboBox = new JComboBox<>(new String[]{"2021", "2022", "2023"});
        monthComboBox.addActionListener(e -> updateCalendar());
        yearComboBox.addActionListener(e -> updateCalendar());
        JButton backToMenuButton = new JButton("Back to Menu");
        calendarPanel = new JPanel(new GridLayout(5, 7));
        updateCalendar();

        JPanel controls = new JPanel();
        controls.add(new JLabel("Month:"));
        controls.add(monthComboBox);
        controls.add(new JLabel("Year:"));
        controls.add(yearComboBox);
        backToMenuButton.addActionListener(e -> backToMenu());
        frame.add(controls, BorderLayout.NORTH);
        frame.add(calendarPanel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    private void updateCalendar() {
        calendarPanel.removeAll();
        String selectedMonth = (String) monthComboBox.getSelectedItem();
        String selectedYear = (String) yearComboBox.getSelectedItem();
        Calendar cal = new GregorianCalendar(Integer.parseInt(selectedYear), monthComboBox.getSelectedIndex(), 1);
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int day = 1; day <= daysInMonth; day++) {
            JButton dateButton = new JButton(String.valueOf(day));
            dateButton.addActionListener(new DateButtonListener(day, selectedMonth, selectedYear));
            calendarPanel.add(dateButton);
        }

        calendarPanel.revalidate();
        calendarPanel.repaint();
    }
    private void backToMenu() {
        frame.dispose();
        new Menu();
    }
    
    private void addComponentsToPanel(JButton backToMenuButton) {
        panel.add(backToMenuButton);
    }

    private class DateButtonListener implements ActionListener {
        private final int day;
        private final String month;
        private final String year;

        public DateButtonListener(int day, String month, String year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Selected date: " + day + "-" + month + "-" + year);
        }
    }

    public static void main(String[] args) {
        new CalendarView();
    }
}
