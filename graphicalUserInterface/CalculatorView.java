package graphicalUserInterface;

import dataModels.DoubleMonom;
import dataModels.Polynomial;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculatorView extends JFrame {
    private final JPanel contentPane;
    private final JTextField textFieldPolinom1;
    private final JTextField textFieldPolinom2;
    private final JTextField textFieldRezultat;
    private final JTextField textFieldRest;
    JButton btnNewButtonAdunare = new JButton("Adunare");
    JButton btnNewButtonScadere = new JButton("Scadere");
    JButton btnNewButtonInmultire = new JButton("Inmultire");
    JButton btnNewButtonImpartire = new JButton("Impartire");
    JButton btnNewButtonDerivare = new JButton("Derivare");
    JButton btnNewButtonIntegrare = new JButton("Integrare");
    ButtonGroup Group= new ButtonGroup();
    JRadioButton radioButtonPolinomIntreg = new JRadioButton("Polinom intreg");
    JRadioButton radioButtonPolinomReal = new JRadioButton("Polinom real");
    JButton btnNewButtonClear = new JButton("Clear");

    public JRadioButton getRadioButtonPolinomIntreg() {
        return radioButtonPolinomIntreg;
    }
    public JRadioButton getRadioButtonPolinomReal() {
        return radioButtonPolinomReal;
    }
    public String getTextFieldPolinom1(){
        return textFieldPolinom1.getText();
    }
    public String getTextFieldPolinom2(){
        return textFieldPolinom2.getText();
    }

    public  void setTextFieldRezultat(Polynomial p){
        textFieldRezultat.setText(p.polinomToString(p));
    }
    public  void setTextFieldRezultatd(Polynomial<DoubleMonom> p){
        textFieldRezultat.setText(p.polinomToStringd(p));
    }

    public  void setTextFieldRest(Polynomial p){
        textFieldRest.setText(p.polinomToString(p));
    }
    public  void setTextFieldRestd(Polynomial<DoubleMonom> p){
        textFieldRest.setText(p.polinomToStringd(p));
    }


    public CalculatorView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 729, 401);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabelPol1 = new JLabel("Polinomul1: ");
        lblNewLabelPol1.setBounds(29, 106, 94, 23);
        contentPane.add(lblNewLabelPol1);

        textFieldPolinom1 = new JTextField();
        textFieldPolinom1.setBounds(127, 106, 405, 23);
        contentPane.add(textFieldPolinom1);
        textFieldPolinom1.setColumns(10);

        JLabel lblNewLabelPol2 = new JLabel("Polinomul2: ");
        lblNewLabelPol2.setBounds(29, 150, 74, 23);
        contentPane.add(lblNewLabelPol2);

        textFieldPolinom2 = new JTextField();
        textFieldPolinom2.setBounds(127, 150, 405, 23);
        contentPane.add(textFieldPolinom2);
        textFieldPolinom2.setColumns(10);

        btnNewButtonAdunare.setBounds(591, 35, 85, 21);
        contentPane.add(btnNewButtonAdunare);

        btnNewButtonScadere.setBounds(591, 76, 85, 21);
        contentPane.add(btnNewButtonScadere);

        btnNewButtonInmultire.setBounds(591, 119, 85, 21);
        contentPane.add(btnNewButtonInmultire);

        btnNewButtonImpartire.setBounds(591, 164, 85, 21);
        contentPane.add(btnNewButtonImpartire);

        btnNewButtonDerivare.setBounds(591, 206, 85, 21);
        contentPane.add(btnNewButtonDerivare);

        btnNewButtonIntegrare.setBounds(591, 251, 85, 21);
        contentPane.add(btnNewButtonIntegrare);

        btnNewButtonClear.setBounds(591, 333, 85, 21);
        contentPane.add(btnNewButtonClear);

        textFieldRezultat = new JTextField();
        textFieldRezultat.setBounds(127, 230, 405, 23);
        contentPane.add(textFieldRezultat);
        textFieldRezultat.setColumns(10);

        JLabel lblNewLabelRezultat = new JLabel("Rezultat: ");
        lblNewLabelRezultat.setBounds(29, 225, 74, 33);
        contentPane.add(lblNewLabelRezultat);

        radioButtonPolinomIntreg.setBounds(315, 35, 182, 21);
        Group.add(radioButtonPolinomIntreg);
        contentPane.add(radioButtonPolinomIntreg);

        radioButtonPolinomReal.setBounds(190, 35, 103, 21);
        Group.add(radioButtonPolinomReal);
        contentPane.add(radioButtonPolinomReal);

        textFieldRest = new JTextField();
        textFieldRest.setBounds(127, 263, 405, 23);
        contentPane.add(textFieldRest);
        textFieldRest.setColumns(10);

        JLabel lblNewLabelRest = new JLabel("Rest: ");
        lblNewLabelRest.setBounds(29, 263, 74, 23);
        contentPane.add(lblNewLabelRest);

        JLabel lblNewLabelAlegetiTipulPolinomului = new JLabel("Alegeti o singura varianta: ");
        lblNewLabelAlegetiTipulPolinomului.setBounds(29, 26, 304, 38);
        contentPane.add(lblNewLabelAlegetiTipulPolinomului);
    }
    public void addAdunareListener(ActionListener listener){
        btnNewButtonAdunare.addActionListener(listener);
    }
    public void addScadereListener(ActionListener listener){
        btnNewButtonScadere.addActionListener(listener);
    }
    public void addInmultireListener(ActionListener listener){
        btnNewButtonInmultire.addActionListener(listener);
    }
    public void addImpartireListener(ActionListener listener){
        btnNewButtonImpartire.addActionListener(listener);
    }
    public void addDerivareListener(ActionListener listener){
        btnNewButtonDerivare.addActionListener(listener);
    }
    public void addIntegrareListener(ActionListener listener){
        btnNewButtonIntegrare.addActionListener(listener);
    }
    public void addClearListener(ActionListener listener){
        btnNewButtonClear.addActionListener(listener);
    }
    public void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
