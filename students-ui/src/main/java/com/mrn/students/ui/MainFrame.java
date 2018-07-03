package com.mrn.students.ui;

import com.mrn.students.callbacks.AddStudentCallBack;
import com.mrn.students.callbacks.RemoveStudentCallBack;
import com.mrn.students.model.Student;
import com.mrn.students.service.MainFrameService;
import com.mrn.students.service_implem.MainFrameServiceImpl;
import com.mrn.utils.NumberConstants;
import com.mrn.utils.StringConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class MainFrame extends JFrame implements AddStudentCallBack, RemoveStudentCallBack {
    
    private MainFrameService mainFrameService;
    private TablePanel tablePanel;
    private StatusPanel statusPanel;
    private AddStudentForm addStudentForm;
    private RemoveStudentForm removeStudentForm;
    
    public MainFrame() {
        super(StringConstants.APP_NAME);

        constructMainFrame();
        setJMenuBar(createMainMenuBar());
        initializeVariables();
        constructLayout();
        refreshTable();
        setCallbacks();
    }


    // get all the information from the db
    private void refreshTable() {
        // this will return information from db
        List<Student> students = mainFrameService.getAllStudents();
        // after reading the information from the db
        // set the information to table
        tablePanel.setTableModel(students);
        tablePanel.updateTable();
    }

    private void constructLayout() {
        setLayout(new BorderLayout());
        add(tablePanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);
    }

    private void initializeVariables() {
        mainFrameService = new MainFrameServiceImpl();
        tablePanel = new TablePanel();
        statusPanel = new StatusPanel();
        addStudentForm = new AddStudentForm(this);
        removeStudentForm = new RemoveStudentForm(this);
    }

    private void constructMainFrame() {
        setSize(NumberConstants.APP_WINDOW_SIZE_WIDTH, NumberConstants.APP_WINDOW_SIZE_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // set to center of the screen
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private JMenuBar createMainMenuBar() {
        // Menu bar is whole bar of the top
        final JMenuBar menuBar = new JMenuBar();

        // file
        JMenu fileMenu = new JMenu(StringConstants.MAIN_MENU_FILE);
        JMenuItem openItem = new JMenuItem(StringConstants.MAIN_OPEN_FILE);
        JMenuItem exitItem = new JMenuItem(StringConstants.MAIN_EXIT_FILE);

        fileMenu.add(openItem);
        fileMenu.add(exitItem);

        // window
        JMenu windowMenu = new JMenu(StringConstants.MAIN_WINDOW_MENU);
        JMenuItem addItem = new JMenuItem(StringConstants.MAIN_WINDOW_ADD_STUDENT);
        JMenuItem removeItem = new JMenuItem(StringConstants.MAIN_WINDOW_REMOVE_STUDENT);

        windowMenu.add(addItem);
        windowMenu.add(removeItem);

        // help
        JMenu helpMenu = new JMenu(StringConstants.MAIN_HELP_MENU);
        JMenuItem aboutItem = new JMenuItem(StringConstants.MAIN_HELP_ABOUT);

        helpMenu.add(aboutItem);


        menuBar.add(fileMenu);
        menuBar.add(windowMenu);
        menuBar.add(helpMenu);

        addItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               addStudentForm.setVisible(true);
            }
        });

        removeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeStudentForm.setVisible(true);
            }
        });

        // Action listener for exiting the app
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int action = JOptionPane.showConfirmDialog(MainFrame.this,
                        StringConstants.MAIN_MENU_EXIT_TEXT, StringConstants.MAIN_MENU_EXIT_TITLE,
                        JOptionPane.OK_CANCEL_OPTION);

                if(action == JOptionPane.OK_OPTION) {
                    // shutdown
                    mainFrameService.shutdown();
                    statusPanel.stopTimer();
                    System.gc();
                    System.exit(0);
                }
            }
        });
        return menuBar;
    }

    // getting callback
    public void saveStudent() {
        refreshTable();
        removeStudentForm.loadData();
    }

    private void setCallbacks() {
        addStudentForm.setCallback(this);
        removeStudentForm.setCallBack(this);
    }

    public void studentRemoved() {
        // refresh table first
        refreshTable();
        // update data again on the remove student form (drop down combo box)
        removeStudentForm.loadData();
    }
}
