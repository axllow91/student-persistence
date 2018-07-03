package com.mrn.students.ui;

import com.mrn.utils.StringConstants;

import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel {
    private JLabel statusLabel;
    private JLabel timeLabel;
    private Timer timer;
    
    public StatusPanel() {
        initializeVariables();
        constructLayout();
        startTimer();
    }

    private void initializeVariables() {
        statusLabel = new JLabel();
        statusLabel.setText(StringConstants.STATUS_PANEL_TEXT);

        timeLabel = new JLabel();
        timer = new Timer(timeLabel);
    }

    private void constructLayout() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(statusLabel);
        add(timeLabel);
    }

    private void startTimer() {
        timer.start();
    }

    public void stopTimer() {
        timer.setRunning(false);
    }

    
}
