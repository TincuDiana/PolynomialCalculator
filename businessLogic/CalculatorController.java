package businessLogic;

import dataModels.Polynomial;
import graphicalUserInterface.CalculatorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalculatorController {
    private final CalculatorView theView;
    private Polynomial polynomial;

    public CalculatorController(CalculatorView theView, Polynomial polynomial) {
        this.theView = theView;
        this.polynomial = polynomial;
        this.theView.addAdunareListener(new AdunareListener());
        this.theView.addScadereListener(new ScadereListener());
        this.theView.addInmultireListener(new InmultireListener());
        this.theView.addImpartireListener(new ImpartireListener());
        this.theView.addDerivareListener(new DerivareListener());
        this.theView.addIntegrareListener(new IntegrareListener());
        this.theView.addClearListener(new ClearListener());
    }

    class ClearListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Polynomial p= new Polynomial();
            theView.setTextFieldRezultat(p);
            theView.setTextFieldRest(p);
        }
    }
    class AdunareListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Polynomial pol1= new Polynomial();
            Polynomial pol2= new Polynomial();
            Polynomial rez= new Polynomial();
            if(theView.getRadioButtonPolinomReal().isSelected() && !theView.getRadioButtonPolinomIntreg().isSelected()){
                try{
                    pol1=pol1.regexd(theView.getTextFieldPolinom1());
                    pol2=pol2.regexd(theView.getTextFieldPolinom2());
                    rez=polynomial.sumaPolinoamed(pol1,pol2);
                    polynomial.sortareCoefDescr(rez);
                    theView.setTextFieldRezultatd(rez);}
                catch (Exception e){
                    theView.displayErrorMessage("Introduceti doua polinoame cu coeficienti reali");
                }}
            else
            if(theView.getRadioButtonPolinomIntreg().isSelected() && !theView.getRadioButtonPolinomReal().isSelected())
            { try{
            pol1=pol1.regexi(theView.getTextFieldPolinom1());
            pol2=pol2.regexi(theView.getTextFieldPolinom2());
            rez=polynomial.sumaPolinoame(pol1,pol2);
            polynomial.sortareCoefDescr(rez);
            theView.setTextFieldRezultat(rez);}
            catch (Exception e){
                theView.displayErrorMessage("Introduceti doua polinoame cu coeficienti intregi");
            }}
        }
    }
    class ScadereListener implements ActionListener{
        public void actionPerformed(ActionEvent actionEvent) {
            Polynomial pol1= new Polynomial();
            Polynomial pol2= new Polynomial();
            Polynomial rez= new Polynomial();
            if(theView.getRadioButtonPolinomReal().isSelected() && !theView.getRadioButtonPolinomIntreg().isSelected()){
                try{
                    pol1=pol1.regexd(theView.getTextFieldPolinom1());
                    pol2=pol2.regexd(theView.getTextFieldPolinom2());
                    rez=polynomial.diferentaPolinoamed(pol1,pol2);
                    polynomial.sortareCoefDescr(rez);
                    theView.setTextFieldRezultatd(rez);}
                catch (Exception e){
                    theView.displayErrorMessage("Introduceti doua polinoame cu coeficienti reali");
                }}
            else
            if(theView.getRadioButtonPolinomIntreg().isSelected() && !theView.getRadioButtonPolinomReal().isSelected())
            { try{
                pol1=pol1.regexi(theView.getTextFieldPolinom1());
                pol2=pol2.regexi(theView.getTextFieldPolinom2());
                rez=polynomial.diferentaPolinoame(pol1,pol2);
                polynomial.sortareCoefDescr(rez);
                theView.setTextFieldRezultat(rez);}
            catch (Exception e){
                theView.displayErrorMessage("Introduceti doua polinoame cu coeficienti intregi");
            }}
        }
    }
    class InmultireListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Polynomial pol1= new Polynomial();
            Polynomial pol2= new Polynomial();
            Polynomial rez= new Polynomial();
            if(theView.getRadioButtonPolinomReal().isSelected() && !theView.getRadioButtonPolinomIntreg().isSelected()){
                try{
                    pol1=pol1.regexd(theView.getTextFieldPolinom1());
                    pol2=pol2.regexd(theView.getTextFieldPolinom2());
                    rez=polynomial.inmultirePolinoame(pol1,pol2);
                    polynomial.sortareCoefDescr(rez);
                    theView.setTextFieldRezultatd(rez);}
                catch (Exception e){
                    theView.displayErrorMessage("Eroare la inmultirea polinoamelor");
                }}
            else
            if(theView.getRadioButtonPolinomIntreg().isSelected() && !theView.getRadioButtonPolinomReal().isSelected())
            {
                try{
                    pol1=pol1.regexi(theView.getTextFieldPolinom1());
                    pol2=pol2.regexi(theView.getTextFieldPolinom2());
                    rez=polynomial.inmultirePolinoamei(pol1,pol2);
                    polynomial.sortareCoefDescr(rez);
                    theView.setTextFieldRezultat(rez);}
                catch (Exception e){
                    theView.displayErrorMessage("Eroare la inmultirea polinoamelor");
                }
            }
        }
    }
    class ImpartireListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Polynomial pol1= new Polynomial();
            Polynomial pol2= new Polynomial();
            Polynomial cat= new Polynomial();
            Polynomial rest= new Polynomial();
            if(theView.getRadioButtonPolinomReal().isSelected() && !theView.getRadioButtonPolinomIntreg().isSelected()){
                try{
                    pol1=pol1.regexd(theView.getTextFieldPolinom1());
                    pol2=pol2.regexd(theView.getTextFieldPolinom2());
                    polynomial.impartirePolinoame(pol1,pol2,rest,cat);
                    polynomial.sortareCoefDescr(cat);
                    polynomial.sortareCoefDescr(rest);
                    theView.setTextFieldRestd(rest);
                    theView.setTextFieldRezultatd(cat);}
                catch (Exception e){
                    theView.displayErrorMessage("Eroare la impartire");
                }}
            else
            if(theView.getRadioButtonPolinomIntreg().isSelected() && !theView.getRadioButtonPolinomReal().isSelected())
            { theView.displayErrorMessage("Introduceti polinoame cu coeficienti reali\n(Adaugati .0 dupa fiecare coeficient)"); }
        }
    }
    class DerivareListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Polynomial pol1= new Polynomial();
            Polynomial rez= new Polynomial();
            if(theView.getRadioButtonPolinomReal().isSelected() && !theView.getRadioButtonPolinomIntreg().isSelected()){
                try{
                    pol1=pol1.regexd(theView.getTextFieldPolinom1());
                    rez=polynomial.derivarePolinoame(pol1);
                    polynomial.sortareCoefDescr(rez);
                    theView.setTextFieldRezultatd(rez);
                  }
                catch (Exception e){
                    theView.displayErrorMessage("Eroare la derivare");
                }}
            else
            if(theView.getRadioButtonPolinomIntreg().isSelected() && !theView.getRadioButtonPolinomReal().isSelected())
            { try{
                pol1=pol1.regexi(theView.getTextFieldPolinom1());
                rez=polynomial.derivarePolinoamei(pol1);
                polynomial.sortareCoefDescr(rez);
                theView.setTextFieldRezultat(rez);
            }
            catch (Exception e){
                theView.displayErrorMessage("Eroare la derivare");
            } }
        }
    }
    class IntegrareListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Polynomial pol1= new Polynomial();
            Polynomial rez= new Polynomial();
            if(theView.getRadioButtonPolinomReal().isSelected() && !theView.getRadioButtonPolinomIntreg().isSelected()){
                try{
                    pol1=pol1.regexd(theView.getTextFieldPolinom1());
                    rez=polynomial.integrarePolinoame(pol1);
                    polynomial.sortareCoefDescr(rez);
                    theView.setTextFieldRezultatd(rez);
                }
                catch (Exception e){
                    theView.displayErrorMessage("Eroare la integrare");
                }}
            else
            if(theView.getRadioButtonPolinomIntreg().isSelected() && !theView.getRadioButtonPolinomReal().isSelected())
            { try{
                pol1=pol1.regexi(theView.getTextFieldPolinom1());
                rez=polynomial.integrarePolinoamei(pol1);
                polynomial.sortareCoefDescr(rez);
                theView.setTextFieldRezultatd(rez);
            }
            catch (Exception e){
                theView.displayErrorMessage("Eroare la integrare");
            } }
        }
    }
}
