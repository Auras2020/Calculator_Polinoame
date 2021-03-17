package model;

public class Monom {

    private double coeficient;
    private int putere;

    public Monom(double coeficient, int putere){
        this.coeficient=coeficient;
        this.putere=putere;
    }

    public double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }

    public int getPutere() {
        return putere;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }

    public String caseCoeficient1(double coeficient){
        String x="";
        if(coeficient<0){
            x=coeficient + "";
        }
        if(coeficient>0){
            x="+" + coeficient;
        }
        return x;
    }

    public String caseCoeficient2(double coeficient){
        String x="";
        if(coeficient<0){
            if(coeficient==-1){
                x="-x";
            }
            else{
                x=coeficient + "x";
            }
        }
        if(coeficient==1){
            x="+x";
        }
        if(coeficient>0 && coeficient!=1){
            x="+" + coeficient + "x";
        }
        return x;
    }

    public String caseCoeficient3(double coeficient, int putere){
        String x="";
        if(coeficient<0){
            if(coeficient==-1){
                x="-x^" + putere;
            }
            else{
                x=coeficient + "x^" + putere;
            }

        }
        if(coeficient==1){
            x="+x^" + putere;
        }
        if(coeficient>0 && coeficient!=1){
            x="+" + coeficient + "x^" + putere;
        }
        return x;
    }

    public String toString(){
        String x=null;
        if(coeficient==0){
            x="";
        }
        if(putere==0){
            x=caseCoeficient1(coeficient);
        }
        if(putere==1){
           x=caseCoeficient2(coeficient);
        }
        if(putere>1){
            x=caseCoeficient3(coeficient, putere);
        }
        return x;
    }
}
