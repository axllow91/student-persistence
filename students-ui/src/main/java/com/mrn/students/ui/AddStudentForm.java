package com.mrn.students.ui;

import com.mrn.students.callbacks.AddStudentCallBack;
import com.mrn.students.model.Student;
import com.mrn.students.service.AddStudentFormService;
import com.mrn.students.service_implem.AddStudentFormImpl;
import com.mrn.utils.NumberConstants;
import com.mrn.utils.StringConstants;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddStudentForm extends JDialog implements ActionListener {

    private JButton cancelButton;
    private JButton saveButton;

    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel countryLabel;
    private JLabel zipCodeLabel;

    private JTextField nameField;
    private JTextField ageField;
    private JTextField countryField;
    private JTextField zipCodeField;

    private AddStudentFormService addStudentFormService;
    private AddStudentCallBack addStudentCallBack;

    public AddStudentForm(JFrame parentFrame) {
        super(parentFrame, StringConstants.STUDENT_FORM_TITLE, false);

        addStudentFormService = new AddStudentFormImpl();
        initializeVariables();
        constructLayout();
        setWindow(parentFrame);
    }

    private void initializeVariables() {
        // buttons
        cancelButton = new JButton(StringConstants.ADD_STUDENT_FORM_CANCEL);
        saveButton = new JButton(StringConstants.ADD_STUDENT_FORM_SAVE);

        // labels
        nameLabel = new JLabel(StringConstants.ADD_STUDENT_FORM_NAME_LABEL);
        ageLabel = new JLabel(StringConstants.ADD_STUDENT_FORM_AGE_LABEL);
        countryLabel = new JLabel(StringConstants.ADD_STUDENT_FORM_COUNTRY_LABEL);
        zipCodeLabel = new JLabel(StringConstants.ADD_STUDENT_FORM_ZIP_LABEL);

        // text fields
        nameField = new JTextField(NumberConstants.STUDENT_FORM_WINDOW_FIELD_LENGTH);
        ageField = new JTextField(NumberConstants.STUDENT_FORM_WINDOW_FIELD_LENGTH);
        countryField = new JTextField(NumberConstants.STUDENT_FORM_WINDOW_FIELD_LENGTH);
        zipCodeField = new JTextField(NumberConstants.STUDENT_FORM_WINDOW_FIELD_LENGTH);

        saveButton.addActionListener(this);
        cancelButton.addActionListener(this);

    }


    private void constructLayout() {
        // panel for info
        JPanel studentInfoPanel = new JPanel();

        // panel for buttons
        JPanel buttonsPanel = new JPanel();

        // borders for student info & title
        Border spaceBorder = BorderFactory.createEmptyBorder(15, 15, 15, 15);
        Border titleBorder = BorderFactory.createTitledBorder(StringConstants.STUDENT_FORM_TITLE);

        studentInfoPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));

        studentInfoPanel.setLayout(new GridBagLayout());
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridy = 0;

        Insets rightPadding = new Insets(0, 0, 0, 15);
        Insets noPadding = new Insets(0, 0, 0, 0);

        // *********** FIRST ROW ************ (name label + name field Name: ______//

        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;

        // Don't resize the display area
        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = rightPadding;
        studentInfoPanel.add(nameLabel, gridBagConstraints);

        gridBagConstraints.gridx++;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = noPadding;
        studentInfoPanel.add(nameField, gridBagConstraints);


        // *********** SECOND ROW ************ //
        // move under
        gridBagConstraints.gridy++;

        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = rightPadding;
        studentInfoPanel.add(ageLabel, gridBagConstraints);

        // moving to the right
        gridBagConstraints.gridx++;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = noPadding;
        studentInfoPanel.add(ageField, gridBagConstraints);

        // *********** THIRD ROW ************ //

        // moving down
        gridBagConstraints.gridy++;

        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = rightPadding;
        studentInfoPanel.add(countryLabel, gridBagConstraints);

        // how is drawn on the screen
        // y |__ x
        // moving on the x axe with on position
        gridBagConstraints.gridx++;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = noPadding;
        studentInfoPanel.add(countryField, gridBagConstraints);

        // *********** FOURTH ROW ************ //

        // moving to the next row - moving down
        gridBagConstraints.gridy++;

        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        // reset to the left side
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = rightPadding;
        studentInfoPanel.add(zipCodeLabel, gridBagConstraints);

        // moving on the right
        gridBagConstraints.gridx++;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = noPadding;
        studentInfoPanel.add(zipCodeField, gridBagConstraints);

        // ******* Buttons panel ******** //

        buttonsPanel.add(saveButton);
        buttonsPanel.add(cancelButton);

        Dimension btnSize = cancelButton.getPreferredSize();
        saveButton.setPreferredSize(btnSize);

        // Add sub panels to dialog
        setLayout(new BorderLayout());
        // setting panels (center  + bottom)
        add(studentInfoPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

    }

    private void setWindow(JFrame parentFrame) {
        setSize(NumberConstants.STUDENT_ADD_FORM_WIDTH_SIZE, NumberConstants.STUDENT_ADD_FORM_HEIGHT_SIZE);
        setLocationRelativeTo(parentFrame);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == cancelButton) {
            setVisible(false);
            System.out.println("Cancel button clicked");
        } else if(e.getSource() == saveButton) {
            // if no information passed
            if (nameField.getText().equals("")) {
                JOptionPane.showMessageDialog(this,StringConstants.ADD_STUDENT_MESSAGE,
                        StringConstants.ADD_STUDENT_TITTLE_MESSAGE, JOptionPane.INFORMATION_MESSAGE);

            } else if(!nameField.getText().equals("")) {

                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String country = countryField.getText();
                int zipCode = Integer.parseInt(zipCodeField.getText());

                // create a new student object
                Student newStudent = new Student(name, age, country, zipCode);

                System.out.println(newStudent);

                addStudentFormService.insertStudent(newStudent);

                addStudentCallBack.saveStudent();

                setVisible(false);
            }

            // empty credentials
            emptyStudentAddForm();
        }
    }

    private void emptyStudentAddForm() {
        // empty dialog
        nameField.setText("");
        ageField.setText("");
        countryField.setText("");
        zipCodeField.setText("");
    }

    void setCallback(AddStudentCallBack addStudentCallBack) {
        this.addStudentCallBack = addStudentCallBack;
    }
}

