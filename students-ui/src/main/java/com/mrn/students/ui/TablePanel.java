package com.mrn.students.ui;

import com.mrn.students.model.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.List;

public class TablePanel extends JPanel {
    private JTable studentsTable;
    private TableModel studentTableModel;

    public TablePanel(){

        this.studentTableModel = new TableModel();
        this.studentsTable = new JTable(studentTableModel);

        initializeHeaderAlignment();
        initializeTableAlignment();

        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 30, 10, 30));
        add(new JScrollPane(studentsTable), BorderLayout.CENTER);
    }

    private void initializeTableAlignment() {
        DefaultTableCellRenderer tableCellRenderer = new DefaultTableCellRenderer();
        tableCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        this.studentsTable.getColumnModel().getColumn(0).setCellRenderer(tableCellRenderer);
        this.studentsTable.getColumnModel().getColumn(1).setCellRenderer(tableCellRenderer);
        this.studentsTable.getColumnModel().getColumn(2).setCellRenderer(tableCellRenderer);
        this.studentsTable.getColumnModel().getColumn(3).setCellRenderer(tableCellRenderer);
        this.studentsTable.getColumnModel().getColumn(4).setCellRenderer(tableCellRenderer);
    }

    private void initializeHeaderAlignment() {
        DefaultTableCellRenderer headerCellRenderer = new DefaultTableCellRenderer();
        headerCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        this.studentsTable.getTableHeader().setDefaultRenderer(headerCellRenderer);
    }

    public void setTableModel(List<Student> studentList){
        this.studentTableModel.setStudents(studentList);
    }

    public void updateTable(){
        this.studentTableModel.updateTable();
    }



}
