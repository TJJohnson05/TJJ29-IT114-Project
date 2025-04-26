// Tyler Johnson
// April 11th, 2025
// Tjj29@njit.edu
// IT114 - 004
// Phase 4 Assignment: GUI Trivia Game Flow
package application.trivia.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Timer;
import javax.swing.SwingUtilities;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import application.trivia.Cartoon2000sTriviaGameState;

public class Cartoon2000sTriviaGameScoreBoardPanel extends JPanel {

  private static final Color GOLD = Color.decode("#f1dfa9");
  private static final Color DARK_GOLD = Color.decode("#d2b172");

  private DefaultTableModel tableModel; 
  private JTable table;
  private JLabel southLabel;
  private Timer timer;
  private int timeLeftInSeconds = Cartoon2000sTriviaGameState.QUESTION_TIMER_SECONDS;
  private boolean timerStarted = false;

  public Cartoon2000sTriviaGameScoreBoardPanel() {
    super();
    initialize();
  }

  private void initialize() {
    this.setBackground(Color.BLACK);
    this.setLayout(new BorderLayout());
    this.setPreferredSize(new Dimension(207, 300));
    this.setBorder(BorderFactory.createLineBorder(DARK_GOLD, 3));

    tableModel = new DefaultTableModel(new Object[] { "Player", "Score" }, 0);
    table = new JTable(tableModel);
    table.setEnabled(false);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    table.setBackground(Color.BLACK);
    table.setForeground(GOLD);
    table.setGridColor(Color.GRAY);
    table.setSelectionBackground(Color.DARK_GRAY);
    table.setFont(new Font("Arial", Font.BOLD, 14));

    // Set up table header
    JTableHeader header = table.getTableHeader();
    header.setBackground(Color.DARK_GRAY);
    header.setForeground(GOLD);
    header.setFont(new Font("Arial", Font.BOLD, 16));
    ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

    TableColumnModel columnModel = table.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(100);
    columnModel.getColumn(0).setMaxWidth(100);
    columnModel.getColumn(1).setPreferredWidth(100);
    columnModel.getColumn(1).setMaxWidth(100);

    // Add table header to the NORTH region
    this.add(header, BorderLayout.NORTH);

    // Add table to the CENTER region
    this.add(table, BorderLayout.CENTER);

    // Create JLabel for the SOUTH region with the same font size as the table header
    southLabel = new JLabel("", SwingConstants.CENTER);
    southLabel.setFont(new Font("Arial", Font.BOLD, 18));
    southLabel.setForeground(GOLD);
    southLabel.setBackground(Color.BLACK);
    southLabel.setOpaque(true);

    // Add the JLabel to the SOUTH region
    this.add(southLabel, BorderLayout.SOUTH);
  }
  public void startQuestionTimer() {
      System.out.println("startQuestionTimer() called");
    if(timerStarted == false) {
      timerStarted = true;
      timeLeftInSeconds = Cartoon2000sTriviaGameState.QUESTION_TIMER_SECONDS;;
      // Initialize the timer to update every second (1000 ms)
      timer = new Timer(1000, this::updateTimer);
      timer.start();
    }
  }

  // Method to update the countdown timer
  private void updateTimer(ActionEvent event) {
    if (timeLeftInSeconds > 0 && timerStarted == true) {
        timeLeftInSeconds--;
        int minutes = timeLeftInSeconds / 60;
        int seconds = timeLeftInSeconds % 60;
        String time = String.format("%02d:%02d", minutes, seconds);
        southLabel.setText(time);
        // Ensure the update happens on the Event Dispatch Thread
    } else {
        // Stop the timer once it reaches 00:00
        timerStarted = false;
        timeLeftInSeconds = 0;
        timer.stop();
        // Ensure the update happens on the Event Dispatch Thread
    }
}
  // Method to stop the timer and clear the label
  public void stopTimer() {
    if (timer != null) {
      timerStarted = false;
      timeLeftInSeconds = 0;
      timer.stop(); // Stop the timer
    }
    southLabel.setText(""); // Clear the label text
  }

  public void resetPlayers(HashMap<Integer, Integer> players) {
    tableModel.setRowCount(0); // Clear existing data
    if (players != null && !players.isEmpty()) {
      for (var entry : players.entrySet()) {
      tableModel.addRow(new Object[] { entry.getKey(), entry.getValue() });
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    JFrame frame = new JFrame("Cartoon2000s Score Board - Tjj29@njit.edu");


    Cartoon2000sTriviaGameScoreBoardPanel panel = new Cartoon2000sTriviaGameScoreBoardPanel();
    frame.add(panel);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    // Simulate starting the question timer after 5 seconds
    Thread.sleep(5000);
    panel.startQuestionTimer();

    // Simulate stopping the timer after 5 more seconds
    Thread.sleep(20000);
    panel.stopTimer(); // Stop and clear the timer text

    Thread.sleep(5000);
    panel.resetPlayers(new HashMap<>(Map.of(1, 1, 2, 2, 3, 3)));
    Thread.sleep(5000);
    panel.resetPlayers(new HashMap<>());
    Thread.sleep(5000);
    panel.resetPlayers(new HashMap<>(Map.of(1, 0, 2, 0)));
    Thread.sleep(5000);
    panel.resetPlayers(new HashMap<>(Map.of(1, 1, 2, 1)));
  }
}