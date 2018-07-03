package com.mrn.students.ui;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Timer extends Thread {
    private boolean isRunning;
    private JLabel timeLabel;
    private SimpleDateFormat dateFormat;

    public Timer(JLabel timeLabel) {
        initializeVariables(timeLabel);
    }

    private void initializeVariables(JLabel timeLabel) {
        this.timeLabel = timeLabel;
        dateFormat = new SimpleDateFormat("YYYY-HH:mm:ss aa");
        isRunning = true;
    }


    @Override
    public void run() {
        // while app is running
        //
        while(isRunning) {
            Calendar calendar = Calendar.getInstance();
            Date currentTime = calendar.getTime();
            timeLabel.setText(dateFormat.format(currentTime));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }
}
