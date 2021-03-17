package view;

import model.Polinom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ViewCalculator extends JFrame implements MouseListener {

    private JLabel title;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;

    private JTextField text1;
    private JTextField text2;
    private JTextField text3;

    private JButton add;
    private JButton substract;
    private JButton multiplicate;
    private JButton divide;
    private JButton derivate;
    private JButton integrate;

    public ViewCalculator(){
        this.setTitle("Polynomial Calculator");

        setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        title=new JLabel("Polynomial Calculator");

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        panel1.add(title);

        label1=new JLabel("First Polynomial = ");
        label2=new JLabel("Second Polynomial = ");
        label3=new JLabel("Result = ");
        text1=new JTextField();
        text2=new JTextField();
        text3=new JTextField();

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3, 2, 10, 10));
        panel2.add(label1);
        panel2.add(text1);
        panel2.add(label2);
        panel2.add(text2);
        panel2.add(label3);
        panel2.add(text3);

        add=new JButton("Add");
        substract=new JButton("Substract");
        multiplicate=new JButton("Multiplicate");
        divide=new JButton("Divide");
        derivate=new JButton("Derivate");
        integrate=new JButton("Integrate");

        JPanel panel3=new JPanel();
        panel3.setLayout(new GridLayout(3, 2, 5, 5));
        panel3.add(add);
        panel3.add(substract);
        panel3.add(multiplicate);
        panel3.add(divide);
        panel3.add(derivate);
        panel3.add(integrate);

        JPanel panel4 = new JPanel();
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
        panel4.add(panel1);
        panel4.add( Box.createRigidArea(new Dimension(0,10)) );
        panel4.add(panel2);
        panel4.add( Box.createRigidArea(new Dimension(0,10)) );
        panel4.add(panel3);

        this.add(panel4);

        this.add.addMouseListener(this);
        this.substract.addMouseListener(this);
        this.multiplicate.addMouseListener(this);
        this.divide.addMouseListener(this);
        this.derivate.addMouseListener(this);
        this.integrate.addMouseListener(this);
        this.pack();
    }

    public String getPolinom1(){
        return this.text1.getText();
    }

    public String getPolinom2(){
        return this.text2.getText();
    }

    public JTextField getText3() {
        return text3;
    }

    public void setResult(String text){
        this.text3.setText(text);
    }

    public void addAddActionListener(ActionListener addBut) {
        this.add.addActionListener(addBut);
    }

    public void addSubstractActionListener(ActionListener substractBut) {
        this.substract.addActionListener(substractBut);
    }

    public void addMultiplicateActionListener(ActionListener multiplicateBut) {
        this.multiplicate.addActionListener(multiplicateBut);
    }

    public void addDerivateActionListener(ActionListener derivateBut) {
        this.derivate.addActionListener(derivateBut);
    }

    public void addIntegrateActionListener(ActionListener integrateBut) {
        this.integrate.addActionListener(integrateBut);
    }

    public void addDivideActionListener(ActionListener divideBut) {
        this.divide.addActionListener(divideBut);
    }

    public void afisarePolinom(Polinom polinom, String constanta){
        if (polinom.toString().startsWith("+")) {
            text3.setText(polinom.toString().substring(1) + constanta);
        } else {
            text3.setText(polinom.toString() + constanta);
        }
    }

    public void showErrorMessage(String message){
        text3.setText(message);
        text3.setForeground(Color.RED);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==add){
            this.add.setBackground(Color.green);
        }
        else if(e.getSource()==substract){
            this.substract.setBackground(Color.GREEN);
        }
        else if(e.getSource()==multiplicate){
            this.multiplicate.setBackground(Color.GREEN);
        }
        else if(e.getSource()==divide){
            this.divide.setBackground(Color.GREEN);
        }
        else if(e.getSource()==derivate){
            this.derivate.setBackground(Color.GREEN);
        }
        else if(e.getSource()==integrate){
            this.integrate.setBackground(Color.GREEN);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.add.setBackground(null);
        this.substract.setBackground(null);
        this.multiplicate.setBackground(null);
        this.divide.setBackground(null);
        this.derivate.setBackground(null);
        this.integrate.setBackground(null);
    }
}
