package com.mrn.students.ui;

import com.mrn.students.model.Student;
import com.mrn.utils.NumberConstants;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModel extends AbstractTableModel {

    private List<Student> studentsList;
    private String[] colNames = {"ID", "NAME", "AGE", "COUNTRY", "ZIP"};

    public TableModel() {
        this.studentsList = new ArrayList<Student>();
    }

    public int getColumnCount() {
        return NumberConstants.NUM_OF_COLUMNS;
    }

    @Override
    public String getColumnName(int column) {
        return this.colNames[column];
    }

    public int getRowCount() {
        return this.studentsList.size();
    }

    public Object getValueAt(int row, int col) {

        Student student = this.studentsList.get(row);


        switch (col) {
            case 0:
                return student.getId();
            case 1:
                return student.getName();
            case 2:
                return student.getAge();
            case 3:
                return student.getCountry();
            case 4:
                return student.getZipCode();
            default:
                return null;
        }
    }

    public void setStudents(List<Student> studentsList){
        this.studentsList = studentsList;
    }

    public void updateTable(){
        fireTableDataChanged();
    }
}
