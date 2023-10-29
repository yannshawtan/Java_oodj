/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodjassignment;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultFormatter;
/**
 *
 * @author myste
 */
public class CellEditor extends DefaultCellEditor {
    
    private JSpinner input;
    
    public CellEditor() {
        super(new JCheckBox());
        input = new JSpinner();
        SpinnerNumberModel numberModel= (SpinnerNumberModel) input.getModel();
        numberModel.setMinimum(0);
        JSpinner.NumberEditor editor =(JSpinner.NumberEditor)input.getEditor();
        DefaultFormatter formatter=(DefaultFormatter)editor.getTextField().getFormatter();
        formatter.setCommitsOnValidEdit(true);
        editor.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable jTable1, Object value, boolean isSelected, int row, int column){
        super.getTableCellEditorComponent(jTable1, value, isSelected, row, column);
        int qty = Integer.parseInt(value.toString());
        input.setValue(qty);
        return input;
    }
    
    @Override
    public Object getCellEditorValue() {
        return input.getValue();
    }
    
}
