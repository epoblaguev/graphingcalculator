/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultEditorKit;

/**
 *
 * @author Egor
 */
public class EquationInput extends JPanel implements ActionListener, MouseListener {

    private JButton btnName;
    private JPanel labelPanel;
    private JTextField input;
    private JPopupMenu mnuRightClick;
    private Color color;

    public EquationInput(String name, Color color) {
        super();
        this.setLayout(new FlowLayout());
        this.btnName = new JButton(name);
        this.input = new JTextField(20);
        this.labelPanel = new JPanel();
        this.color = color;

        this.btnName.setForeground(color);
        this.btnName.setBorderPainted(true);
        this.btnName.setContentAreaFilled(false);
        this.btnName.setHorizontalAlignment(SwingConstants.RIGHT);
        this.btnName.setPreferredSize(new Dimension(60, 20));
        this.labelPanel.setBackground(Color.lightGray);

        mnuRightClick = new JPopupMenu();

        this.btnName.addActionListener(this);
        this.input.addMouseListener(this);

        this.add(labelPanel);
        labelPanel.add(this.btnName);
        labelPanel.add(input);
    }

    public JTextField getInput() {
        return input;
    }

    public void setInput(JTextField input) {
        this.input = input;
    }

    public JButton getBtnName() {
        return btnName;
    }

    public void setBtnName(JButton name) {
        this.btnName = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnName) {
            Random r = new Random();
            this.color = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));

            this.btnName.setForeground(color);
            this.revalidate();
        }
    }

    public void mouseClicked(MouseEvent e) {
        //
    }

    public void mousePressed(MouseEvent e) {
        //
    }

    public void mouseReleased(MouseEvent e) {
        input.requestFocus();
        JMenuItem mnuItem;
        mnuRightClick.removeAll();

        mnuItem = new JMenuItem(new DefaultEditorKit.CutAction());
        mnuItem.setText("Cut");
        mnuRightClick.add(mnuItem);
        mnuItem = new JMenuItem(new DefaultEditorKit.CopyAction());
        mnuItem.setText("Copy");
        mnuRightClick.add(mnuItem);
        mnuItem = new JMenuItem(new DefaultEditorKit.PasteAction());
        mnuItem.setText("Paste");
        mnuRightClick.add(mnuItem);


        mnuRightClick.show(input, e.getX() + 10, e.getY());
    }

    public void mouseEntered(MouseEvent e) {
        //
    }

    public void mouseExited(MouseEvent e) {
        //
    }
}
