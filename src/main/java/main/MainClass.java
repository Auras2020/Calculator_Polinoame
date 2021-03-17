package main;

import controller.ControllerCalculator;
import model.Operatii;
import view.ViewCalculator;

public class MainClass {

    public static void main(String[] args) {

        Operatii model=new Operatii();
        ViewCalculator view=new ViewCalculator();
        ControllerCalculator controller = new ControllerCalculator(view, model);
        view.setVisible(true);
    }
}
