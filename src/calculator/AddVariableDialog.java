package calculator;

import components.SmartTextField;
import components.VariableTablePane;
import exceptions.InvalidVariableNameException;
import expressions.Expression;
import expressions.Variable;
import expressions.VariableList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A form that allows the addition of variables.
 * @author Egor
 */
class AddVariableDialog extends JFrame implements ActionListener {

    private final JLabel lblVariableName;
    private final JLabel lblVariableValue;
    private final JTextField txtVariableName;
    private final SmartTextField txtVariableValue;
    private final JButton btnAdd;
    private final JButton btnClose;
    private final JPanel topPanel;
    private final JPanel middlePanel;
    private final JPanel bottomPanel;

    /**
     * Constructor. Creates the form.
     */
    public AddVariableDialog() {
        super();
        this.setLayout(new GridLayout(0, 1));
        this.setTitle("Add Variable");

        topPanel = new JPanel(new BorderLayout());
        middlePanel = new JPanel(new BorderLayout());
        bottomPanel = new JPanel(new FlowLayout());

        lblVariableName = new JLabel("Variable Name:");
        txtVariableName = new JTextField(10);
        lblVariableValue = new JLabel("Variable Value:");
        txtVariableValue = new SmartTextField(10);

        btnAdd = new JButton("Add");
        btnClose = new JButton("Close");
        btnAdd.addActionListener(this);
        btnClose.addActionListener(this);

        topPanel.add(lblVariableName, BorderLayout.WEST);
        topPanel.add(txtVariableName, BorderLayout.EAST);

        middlePanel.add(lblVariableValue, BorderLayout.WEST);
        middlePanel.add(txtVariableValue, BorderLayout.EAST);

        bottomPanel.add(btnAdd);
        bottomPanel.add(btnClose);

        this.add(topPanel);
        this.add(middlePanel);
        this.add(bottomPanel);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            //If Add.
            if (e.getSource() == btnAdd) {
                boolean nameExists = false;
                Variable var = new Variable(txtVariableName.getText(), Expression.evaluate(txtVariableValue.getText()));

                if (Double.isInfinite(var.getVariableValue()) || Double.isNaN(var.getVariableValue())) {
                    JOptionPane.showMessageDialog(this, "Variable value is invalid.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                for (Variable curVar : VariableList.getVariables()) {
                    if (var.getVariableName().equals(curVar.getVariableName())) {
                        curVar.setVariableValue(var.getVariableValue());
                        nameExists = true;
                        break;
                    }
                }
                if(!nameExists){
                    VariableList.addVariable(var);
                }
                VariableTablePane.refreshTable();
                txtVariableName.setText("");
                txtVariableValue.setText("");
            }

            //If Close
            if (e.getSource() == btnClose) {
                this.dispose();
            }
        } catch (InvalidVariableNameException | Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
}
