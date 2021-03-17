package model;

import java.util.ArrayList;
import java.util.List;

public class Operatii {

    public String replaceString(String polinom){
        String polinom1=polinom.replace("x+", "x^1+");
        polinom1=polinom1.replace("x-", "x^1-");
        if(polinom1.startsWith("x")){
            polinom1="1"+polinom1;
        }
        if(polinom1.endsWith("x")){
            polinom1=polinom1+"^1";
        }
        polinom1=polinom1.replace("+x^", "+1x^");
        polinom1=polinom1.replace("-x^", "-1x^");
        if(polinom1.lastIndexOf("+")>polinom1.lastIndexOf("^")
                || polinom1.lastIndexOf("-")>polinom1.lastIndexOf("^")){
            polinom1+="x^0";
        }
        else{
            if(!polinom1.contains("x")){
                polinom1+="x^0";
            }
            else{
                polinom1+="+0x^0";
            }
        }
        return polinom1;
    }

    public void checkEqualDegrees(Polinom pol){
        int ind=0;
        for(;;){
            if(ind>=pol.getList().size()-1)
                break;
            if(pol.getList().get(ind).getPutere()==pol.getList().get(ind+1).getPutere()){
                pol.getList().get(ind).setCoeficient(pol.getList().get(ind).getCoeficient()+pol.getList().get(ind+1).getCoeficient());
                if(pol.getList().get(ind).getCoeficient()==0){
                    pol.getList().get(ind).setPutere(0);
                }
                pol.getList().remove(ind+1);
            }
            ind++;
        }
    }

    public Polinom extractPolinom(String polinom){
        Polinom pol=new Polinom();
        String polinom1=replaceString(polinom);
        String[] numbers=polinom1.replace("^", "").split("((?=\\+)|(?=\\-)|x)");
        List<Double> coef=new ArrayList<>();
        List<Integer> exp=new ArrayList<>();
        for(int i=0; i<numbers.length; i+=2){
            numbers[i].replace("+", "");
            coef.add(Double.parseDouble(numbers[i]));
            exp.add(Integer.parseInt(numbers[i+1]));
        }
        int k=0;
        while(k<coef.size()-1){
            if(exp.get(k)-exp.get(k+1)>1){
                coef.add(k+1, 0.0);
                exp.add(k+1, exp.get(k)-1);
            }
            Monom monom=new Monom(coef.get(k), exp.get(k));
            pol.addMonom(monom);
            k++;
        }
        pol.addMonom(new Monom(coef.get(coef.size()-1), exp.get(exp.size()-1)));
        checkEqualDegrees(pol);
        return pol;
    }

    public Polinom adunare(Polinom polinom1, Polinom polinom2){

        Polinom rezultat=new Polinom();
        Monom monom;
        Polinom polMax=(polinom1.getList().size()>=polinom2.getList().size() ? polinom1 : polinom2);
        Polinom polMin=(polinom1.getList().size()<polinom2.getList().size() ? polinom1 : polinom2);
        for(Monom m: polMax.getList()){
            monom=new Monom(m.getCoeficient(), m.getPutere());
            rezultat.addMonom(monom);
        }
        int i=0, poz=polMax.getList().size()-polMin.getList().size();
        for(Monom m: polMin.getList()){
            rezultat.getList().get(poz+i).setCoeficient(rezultat.getList().get(poz+i).getCoeficient()
                    +m.getCoeficient());
            i++;
        }
        return rezultat;
    }

    public Polinom scadere(Polinom polinom1, Polinom polinom2){
        Polinom rezultat=new Polinom();
        Monom monom;
        Polinom polMax=(polinom1.getList().size()>=polinom2.getList().size() ? polinom1 : polinom2);
        Polinom polMin=(polinom1.getList().size()<polinom2.getList().size() ? polinom1 : polinom2);
        int sign=(polinom1.getList().size()>=polinom2.getList().size() ? 1 : -1);
        int poz=polMax.getList().size()-polMin.getList().size();
        for(Monom m: polMax.getList()){
            monom=new Monom(sign*m.getCoeficient(), m.getPutere());
            rezultat.addMonom(monom);
        }
        int i=0;
        for(Monom m: polMin.getList()){
            rezultat.getList().get(poz+i).setCoeficient(rezultat.getList().get(poz+i).getCoeficient()
                    -sign*m.getCoeficient());
            i++;
        }
        return rezultat;
    }

    public Polinom inmultire(Polinom polinom1, Polinom polinom2){
        Polinom rezultat=new Polinom();
        int k=0;
        for(Monom m1: polinom1.getList()){
            for(Monom m2: polinom2.getList()){
                Monom m=new Monom(0, polinom1.getList().size()+polinom2.getList().size()-2-k);
                rezultat.addMonom(m);
                k++;
            }
        }
        int i=0;
        for(Monom m1: polinom1.getList()){
            int j=0;
            for(Monom m2: polinom2.getList()){
                rezultat.getList().get(i+j).setCoeficient(rezultat.getList().get(i+j).getCoeficient()+
                        m1.getCoeficient()*m2.getCoeficient());
                j++;
            }
            i++;
        }
        return rezultat;
    }

    public Polinom derivare(Polinom polinom1){
        Polinom rezultat=new Polinom();
        for(Monom m: polinom1.getList()){
            Monom monom=new Monom(m.getCoeficient()*m.getPutere(), m.getPutere()==0 ? 0 : m.getPutere()-1);
            rezultat.addMonom(monom);
        }
        return rezultat;
    }

    public Polinom integrare(Polinom polinom1){
        Polinom rezultat=new Polinom();
        for(Monom m: polinom1.getList()){
            if(m.getCoeficient()!=0){
                Monom monom=new Monom(m.getCoeficient()/(m.getPutere()+1), m.getPutere()+1);
                rezultat.addMonom(monom);
            }
        }
        return rezultat;
    }

    public void scadereCoeficienti(Polinom polinom1, Polinom polinom2){
        int ind1=0;
        for(Monom mo: polinom1.getList()){
            if(ind1<polinom2.getList().size()){
                if(mo.getPutere()==polinom2.getList().get(ind1).getPutere()){
                    polinom1.getList().get(polinom1.getList().size()-1-mo.getPutere()).setCoeficient(
                            polinom1.getList().get(polinom1.getList().size()-1-mo.getPutere()).getCoeficient()
                                    -polinom2.getList().get(ind1).getCoeficient());
                    ind1++;
                }
            }
        }
    }

    public void inmultireMonom(Polinom polinom, Monom monom, Polinom rezultat){
        Monom monom1;
        for(Monom m: polinom.getList()){
            monom1=new Monom(m.getCoeficient()* monom.getCoeficient(), m.getPutere()+ monom.getPutere());
            rezultat.addMonom(monom1);
        }
    }

    public Polinom impartire(Polinom polinom1, Polinom polinom2) throws Exception{
        Polinom rezultat=new Polinom();
        if(polinom2.getList().get(0).getCoeficient()==0 && polinom2.getList().get(0).getPutere()==0){
            throw new Exception("nu putem imparti cu polinomul nul");
        }
        else{
            Polinom polinom=new Polinom();
            for(Monom m: polinom1.getList()){
                polinom.addMonom(new Monom(m.getCoeficient(), m.getPutere()));
            }
            for(;;){
                Monom monom=new Monom(polinom.getList().get(0).getCoeficient()/polinom2.getList().get(0).getCoeficient(),
                        polinom.getList().get(0).getPutere()-polinom2.getList().get(0).getPutere());
                if(monom.getPutere()<0 || monom.getPutere()==0 && monom.getCoeficient()==0){
                    break;
                }
                rezultat.addMonom(monom);
                Polinom rezultat1=new Polinom();
                inmultireMonom(polinom2, monom, rezultat1);
                scadereCoeficienti(polinom, rezultat1);
                while(polinom.getList().get(0).getCoeficient()==0 && polinom.getList().get(0).getPutere()>0){
                    polinom.getList().remove(0);
                }
                if(polinom.getList().get(0).getPutere()<polinom2.getList().get(0).getPutere() ||
                        polinom.getList().get(0).getCoeficient()==0 && polinom2.getList().get(0).getPutere()==0){
                    break;
                }
            }
        }
        return rezultat;
    }
}
