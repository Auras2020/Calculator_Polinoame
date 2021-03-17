package controller;

import model.Monom;
import model.Operatii;
import model.Polinom;
import view.ViewCalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerCalculator {

    private Operatii operatii;
    private ViewCalculator view;
    private Polinom polinom1=new Polinom();
    private Polinom polinom2=new Polinom();
    private Polinom polinom=new Polinom();

    public ControllerCalculator(ViewCalculator view, Operatii operatii){
        this.view=view;
        this.operatii=operatii;

        this.view.addAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getText3().setForeground(null);
                try{
                    polinom1=operatii.extractPolinom(view.getPolinom1());
                    polinom2=operatii.extractPolinom(view.getPolinom2());
                    if(!polinom1.checkOrder() || !polinom2.checkOrder()){
                        view.showErrorMessage("wrong order..rearrange monomials decreasingly!!!");
                        return;
                    }
                    polinom= operatii.adunare(polinom1, polinom2);
                    view.afisarePolinom(polinom, "");
                    int checkNull=0;
                    for(Monom m: polinom.getList()){
                        if(m.getCoeficient()!=0){
                            checkNull=1;
                            break;
                        }
                    }
                    if(checkNull==0){
                        view.setResult("0");
                    }
                } catch(NumberFormatException ex1){
                    view.showErrorMessage("syntax error!!!");
                } catch(ArrayIndexOutOfBoundsException ex2){
                    view.showErrorMessage("wrong order..rearrange monomials decreasingly!!!");
                }
            }
        });

        this.view.addSubstractActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getText3().setForeground(null);
                try {
                    polinom1 = operatii.extractPolinom(view.getPolinom1());
                    polinom2 = operatii.extractPolinom(view.getPolinom2());
                    if(!polinom1.checkOrder() || !polinom2.checkOrder()){
                        view.showErrorMessage("wrong order..rearrange monomials decreasingly!!!");
                        return;
                    }
                    polinom = operatii.scadere(polinom1, polinom2);
                    view.afisarePolinom(polinom, "");
                    int checkNull = 0;
                    for (Monom m : polinom.getList()) {
                        if (m.getCoeficient() != 0) {
                            checkNull = 1;
                            break;
                        }
                    }
                    if (checkNull == 0) {
                        view.setResult("0");
                    }
                } catch(NumberFormatException ex1){
                    view.showErrorMessage("syntax error!!!");
                } catch(ArrayIndexOutOfBoundsException ex2){
                    view.showErrorMessage("wrong order..rearrange monomials decreasingly!!!");
                }
            }
        });

        this.view.addMultiplicateActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getText3().setForeground(null);
                try {
                    polinom1 = operatii.extractPolinom(view.getPolinom1());
                    polinom2 = operatii.extractPolinom(view.getPolinom2());
                    if(!polinom1.checkOrder() || !polinom2.checkOrder()){
                        view.showErrorMessage("wrong order..rearrange monomials decreasingly!!!");
                        return;
                    }
                    polinom = operatii.inmultire(polinom1, polinom2);
                    view.afisarePolinom(polinom, "");
                    if (polinom1.getList().get(0).getPutere() == 0 && polinom1.getList().get(0).getCoeficient() == 0 ||
                            polinom2.getList().get(0).getPutere() == 0 && polinom2.getList().get(0).getCoeficient() == 0) {
                        view.setResult("0");
                    }
                } catch(NumberFormatException ex1){
                    view.showErrorMessage("syntax error!!!");
                } catch(ArrayIndexOutOfBoundsException ex2){
                    view.showErrorMessage("wrong order..rearrange monomials decreasingly!!!");
                }
            }
        });

        this.view.addDerivateActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getText3().setForeground(null);
                try {
                    polinom1 = operatii.extractPolinom(view.getPolinom1());
                    polinom2 = operatii.extractPolinom(view.getPolinom2());
                    if(!polinom1.checkOrder() || !polinom2.checkOrder()){
                        view.showErrorMessage("wrong order..rearrange monomials decreasingly!!!");
                        return;
                    }
                    polinom = operatii.derivare(polinom1);
                    view.afisarePolinom(polinom, "");
                    if (polinom1.getList().get(0).getPutere() == 0) {
                        view.setResult("0");
                    }
                } catch(NumberFormatException ex1){
                    view.showErrorMessage("syntax error!!!");
                } catch(ArrayIndexOutOfBoundsException ex2){
                    view.showErrorMessage("wrong order..rearrange monomials decreasingly!!!");
                }
            }
        });

        this.view.addIntegrateActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getText3().setForeground(null);
                try {
                    polinom1 = operatii.extractPolinom(view.getPolinom1());
                    polinom2 = operatii.extractPolinom(view.getPolinom2());
                    if(!polinom1.checkOrder() || !polinom2.checkOrder()){
                        view.showErrorMessage("wrong order..rearrange monomials decreasingly!!!");
                        return;
                    }
                    polinom = operatii.integrare(polinom1);
                    if (polinom1.getList().get(0).getPutere() == 0 && polinom1.getList().get(0).getCoeficient() == 0) {
                        view.setResult("c");
                    } else {
                        view.afisarePolinom(polinom, "+c");
                    }
                } catch(NumberFormatException ex1){
                    view.showErrorMessage("syntax error!!!");
                } catch(ArrayIndexOutOfBoundsException ex2){
                    view.showErrorMessage("wrong order..rearrange monomials decreasingly!!!");
                }
            }
        });

        this.view.addDivideActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getText3().setForeground(null);
                try {
                    polinom1 = operatii.extractPolinom(view.getPolinom1());
                    polinom2 = operatii.extractPolinom(view.getPolinom2());
                    if(!polinom1.checkOrder() || !polinom2.checkOrder()){
                        view.showErrorMessage("wrong order..rearrange monomials decreasingly!!!");
                        return;
                    }
                    try {
                        polinom = operatii.impartire(polinom1, polinom2);
                        {
                            view.afisarePolinom(polinom, "");
                            if (polinom.getList().size() == 0) {
                                view.setResult("0");
                            }
                        }
                    } catch (Exception exc) {
                        view.showErrorMessage("nu putem imparti cu polinomul nul!!!");
                        System.out.println(exc.getMessage());
                    }
                } catch(NumberFormatException ex1){
                    view.showErrorMessage("syntax error!!!");
                } catch(ArrayIndexOutOfBoundsException ex2){
                    view.showErrorMessage("wrong order..rearrange monomials decreasingly!!!");
                }
            }
        });
    }
}
