/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphing;

import expressions.Expression;
import expressions.MathEvaluator;
import expressions.Variable;
import expressions.VariableList;
import java.awt.Color;

/**
 *
 * @author Egor
 */
public class Equation {

    private String expression;
    private Color color;

    public Equation(String expression, Color color) {
        this.expression = expression;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public static double evaluate(String expression, double x) {
        expression = (new Expression(expression)).getExpression();
        MathEvaluator m = new MathEvaluator(expression);

        for (Variable var : VariableList.getVariables()) {
            m.addVariable(var.getVariableName(), var.getVariableValue());
        }

        m.addVariable("x", x);

        return m.getValue();
    }
}
