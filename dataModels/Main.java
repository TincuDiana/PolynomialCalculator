package dataModels;

import businessLogic.CalculatorController;
import graphicalUserInterface.CalculatorView;

import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CalculatorView frame = new CalculatorView();
                    Polynomial polynomial=new Polynomial();
                    CalculatorController controller= new CalculatorController(frame, polynomial);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}