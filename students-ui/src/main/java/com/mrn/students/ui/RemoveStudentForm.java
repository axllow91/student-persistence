package com.mrn.students.ui;

import com.mrn.students.callbacks.RemoveStudentCallBack;
import com.mrn.students.model.Student;
import com.mrn.students.service.RemoveStudentFormService;
import com.mrn.students.service_implem.RemoveStudentFormServiceImpl;
import com.mrn.utils.NumberConstants;
import com.mrn.utils.StringConstants;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RemoveStudentForm extends JDialog implements ActionListener {
    private JButton cancelButton;
    private JButton removeButton;
    private JLabel studentName;
    private JComboBox<Student> studentsComboBox;

    private RemoveStudentFormService removeStudentFormService;
    private RemoveStudentCallBack removeStudentCallBack;

    public RemoveStudentForm(JFrame parentFrame) {
        super(parentFrame, StringConstants.STUDENT_REMOVE_TITLE, false);

        initializeVariables();
        // load data from db so we ca have something to remove
        loadData();
        constructLayout();
        setWindow(parentFrame);
    }

    public void loadData() {
        // avoid duplicates -
        studentsComboBox.removeAllItems();

        // getting all students from db
        List<Student> students = removeStudentFormService.getAllStudents();
        for(Student s: students) {
            // add it to the combo box
            studentsComboBox.addItem(s);
        }
    }

    private void constructLayout() {
        JPanel studentInfo = new JPanel();
        JPanel buttonsPanel = new JPanel();

        int space = 15;
        Border spaceBorder = BorderFactory.createEmptyBorder(space,space,space,space);
        Border titleBorder = BorderFactory.createTitledBorder(StringConstants.STUDENT_REMOVE_TITLE);

        studentInfo.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));

        studentInfo.setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridy = 0;

        Insets rightPadding = new Insets(0, 0,0, 15);
        Insets noPadding = new Insets(0,0,0,0);

        // First Row
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.insets = rightPadding;
        studentInfo.add(studentName, gridBagConstraints);

        gridBagConstraints.gridx++;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = noPadding;
        studentInfo.add(studentsComboBox, gridBagConstraints);

        //
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.add(removeButton);
        buttonsPanel.add(cancelButton);

        Dimension btnSize = removeButton.getPreferredSize();
        cancelButton.setPreferredSize(btnSize);

        setLayout(new BorderLayout());
        add(studentInfo, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

    }

    private void initializeVariables() {
        studentsComboBox = new JComboBox<Student>();
        cancelButton = new JButton(StringConstants.STUDENT_REMOVE_CANCELB);
        removeButton = new JButton(StringConstants.STUDENT_REMOVE_REMOVEB);
        studentName = new JLabel(StringConstants.STUDENT_REMOVE_NAME_LABEL);

        removeStudentFormService = new RemoveStudentFormServiceImpl();

        cancelButton.addActionListener(this);
        removeButton.addActionListener(this);
    }

    private void setWindow(JFrame frame) {
        setSize(NumberConstants.STUDENT_REMOVE_FORM_WIDTH_SIZE, NumberConstants.STUDENT_REMOVE_FOR_WINDOW_SIZE_HEIGHT);
        setLocationRelativeTo(frame);
    }

    public void setCallBack(RemoveStudentCallBack removeStudentCallBack) {
        this.removeStudentCallBack = removeStudentCallBack;
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancelButton) {
            setVisible(false);
        } else if(e.getSource() == removeButton) {
            // get the selected student in the combo box
            Student student = (Student)studentsComboBox.getSelectedItem();

            // remove student from db
            removeStudentFormService.removeStudent(student);
            removeStudentCallBack.studentRemoved();
            System.out.println("removing");

            setVisible(false);
        }
    }
}
