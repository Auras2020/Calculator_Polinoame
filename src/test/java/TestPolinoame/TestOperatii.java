package TestPolinoame;

import model.Operatii;
import model.Polinom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestOperatii {

    @Test
    public void addTest(){
        Operatii operatii=new Operatii();
        Polinom polinom1=operatii.extractPolinom("x^3+x+2");
        Polinom polinom2=operatii.extractPolinom("3x-2");
        assertEquals(operatii.adunare(polinom1, polinom2).getList().get(0).getCoeficient(), 1, 0.01);
        assertEquals(operatii.adunare(polinom1, polinom2).getList().get(1).getCoeficient(), 0, 0.01);
        assertEquals(operatii.adunare(polinom1, polinom2).getList().get(2).getCoeficient(), 4, 0.01);
        assertEquals(operatii.adunare(polinom1, polinom2).getList().get(3).getCoeficient(), 0, 0.01);

        polinom1=operatii.extractPolinom("-x+2");
        polinom2=operatii.extractPolinom("x-2");
        assertEquals(operatii.adunare(polinom1, polinom2).getList().get(0).getCoeficient(), 0, 0.01);
        assertEquals(operatii.adunare(polinom1, polinom2).getList().get(1).getCoeficient(), 0, 0.01);

        polinom1=operatii.extractPolinom("-x+2");
        polinom2=operatii.extractPolinom("0");
        assertEquals(operatii.adunare(polinom1, polinom2).getList().get(0).getCoeficient(), -1, 0.01);
        assertEquals(operatii.adunare(polinom1, polinom2).getList().get(1).getCoeficient(), 2, 0.01);
    }

    @Test
    public void substractTest(){
        Operatii operatii=new Operatii();
        Polinom polinom1=operatii.extractPolinom("x^3+x+2");
        Polinom polinom2=operatii.extractPolinom("3x+2");
        assertEquals(operatii.scadere(polinom1, polinom2).getList().get(0).getCoeficient(), 1, 0.01);
        assertEquals(operatii.scadere(polinom1, polinom2).getList().get(1).getCoeficient(), 0, 0.01);
        assertEquals(operatii.scadere(polinom1, polinom2).getList().get(2).getCoeficient(), -2, 0.01);
        assertEquals(operatii.scadere(polinom1, polinom2).getList().get(3).getCoeficient(), 0, 0.01);

        polinom1=operatii.extractPolinom("x-2");
        polinom2=operatii.extractPolinom("x-2");
        assertEquals(operatii.scadere(polinom1, polinom2).getList().get(0).getCoeficient(), 0, 0.01);
        assertEquals(operatii.scadere(polinom1, polinom2).getList().get(1).getCoeficient(), 0, 0.01);

        polinom1=operatii.extractPolinom("0");
        polinom2=operatii.extractPolinom("x-2");
        assertEquals(operatii.scadere(polinom1, polinom2).getList().get(0).getCoeficient(), -1, 0.01);
        assertEquals(operatii.scadere(polinom1, polinom2).getList().get(1).getCoeficient(), 2, 0.01);

        polinom1=operatii.extractPolinom("x^3-2");
        polinom2=operatii.extractPolinom("2.2x^2-2x");
        assertEquals(operatii.scadere(polinom1, polinom2).getList().get(0).getCoeficient(), 1, 0.01);
        assertEquals(operatii.scadere(polinom1, polinom2).getList().get(1).getCoeficient(), -2.2, 0.01);
        assertEquals(operatii.scadere(polinom1, polinom2).getList().get(2).getCoeficient(), 2, 0.01);
        assertEquals(operatii.scadere(polinom1, polinom2).getList().get(3).getCoeficient(), -2, 0.01);
    }

    @Test
    public void multiplyTest(){
        Operatii operatii=new Operatii();
        Polinom polinom1=operatii.extractPolinom("2x^2+3");
        Polinom polinom2=operatii.extractPolinom("3x-2");
        assertEquals(operatii.inmultire(polinom1, polinom2).getList().get(0).getCoeficient(), 6, 0.01);
        assertEquals(operatii.inmultire(polinom1, polinom2).getList().get(1).getCoeficient(), -4, 0.01);
        assertEquals(operatii.inmultire(polinom1, polinom2).getList().get(2).getCoeficient(), 9, 0.01);
        assertEquals(operatii.inmultire(polinom1, polinom2).getList().get(3).getCoeficient(), -6, 0.01);
        assertEquals(operatii.inmultire(polinom1, polinom2).getList().get(0).getPutere(), 3, 0.01);
        assertEquals(operatii.inmultire(polinom1, polinom2).getList().get(1).getPutere(), 2, 0.01);
        assertEquals(operatii.inmultire(polinom1, polinom2).getList().get(2).getPutere(), 1, 0.01);
        assertEquals(operatii.inmultire(polinom1, polinom2).getList().get(3).getPutere(), 0, 0.01);

        polinom1=operatii.extractPolinom("0");
        polinom2=operatii.extractPolinom("3x-2");
        assertEquals(operatii.inmultire(polinom1, polinom2).getList().get(0).getCoeficient(), 0, 0.01);
        assertEquals(operatii.inmultire(polinom1, polinom2).getList().get(1).getCoeficient(), 0, 0.01);
        assertEquals(operatii.inmultire(polinom1, polinom2).getList().get(0).getPutere(), 1, 0.01);
        assertEquals(operatii.inmultire(polinom1, polinom2).getList().get(1).getPutere(), 0, 0.01);

        polinom1=operatii.extractPolinom("x+1");
        polinom2=operatii.extractPolinom("x-1");
        assertEquals(operatii.inmultire(polinom1, polinom2).getList().get(0).getCoeficient(), 1, 0.01);
        assertEquals(operatii.inmultire(polinom1, polinom2).getList().get(1).getCoeficient(), 0, 0.01);
        assertEquals(operatii.inmultire(polinom1, polinom2).getList().get(2).getCoeficient(), -1, 0.01);
        assertEquals(operatii.inmultire(polinom1, polinom2).getList().get(0).getPutere(), 2, 0.01);
        assertEquals(operatii.inmultire(polinom1, polinom2).getList().get(1).getPutere(), 1, 0.01);
        assertEquals(operatii.inmultire(polinom1, polinom2).getList().get(2).getPutere(), 0, 0.01);
    }

    @Test
    public void derivateTest(){
        Operatii operatii=new Operatii();
        Polinom polinom1=operatii.extractPolinom("2.5x^4+3x^3-3.5x+9.7");
        assertEquals(operatii.derivare(polinom1).getList().get(0).getCoeficient(), 10, 0.01);
        assertEquals(operatii.derivare(polinom1).getList().get(1).getCoeficient(), 9, 0.01);
        assertEquals(operatii.derivare(polinom1).getList().get(2).getCoeficient(), 0, 0.01);
        assertEquals(operatii.derivare(polinom1).getList().get(3).getCoeficient(), -3.5, 0.01);
        assertEquals(operatii.derivare(polinom1).getList().get(4).getPutere(), 0, 0.01);
        assertEquals(operatii.derivare(polinom1).getList().get(0).getPutere(), 3, 0.01);
        assertEquals(operatii.derivare(polinom1).getList().get(1).getPutere(), 2, 0.01);
        assertEquals(operatii.derivare(polinom1).getList().get(2).getPutere(), 1, 0.01);
        assertEquals(operatii.derivare(polinom1).getList().get(3).getPutere(), 0, 0.01);
        assertEquals(operatii.derivare(polinom1).getList().get(4).getPutere(), 0, 0.01);

        polinom1=operatii.extractPolinom("2.3x-4.56");
        assertEquals(operatii.derivare(polinom1).getList().get(0).getCoeficient(), 2.3, 0.01);
        assertEquals(operatii.derivare(polinom1).getList().get(1).getCoeficient(), 0, 0.01);
        assertEquals(operatii.derivare(polinom1).getList().get(0).getPutere(), 0, 0.01);
        assertEquals(operatii.derivare(polinom1).getList().get(1).getPutere(), 0, 0.01);

        polinom1=operatii.extractPolinom("4.56");
        assertEquals(operatii.derivare(polinom1).getList().get(0).getCoeficient(), 0, 0.01);
        assertEquals(operatii.derivare(polinom1).getList().get(0).getPutere(), 0, 0.01);
    }

    @Test
    public void integrateTest(){
        Operatii operatii=new Operatii();
        Polinom polinom1=operatii.extractPolinom("2.5x^4+3x^3-3.5x+9.7");
        assertEquals(operatii.integrare(polinom1).getList().get(0).getCoeficient(), 0.5, 0.01);
        assertEquals(operatii.integrare(polinom1).getList().get(1).getCoeficient(), 0.75, 0.01);
        assertEquals(operatii.integrare(polinom1).getList().get(2).getCoeficient(), -1.75, 0.01);
        assertEquals(operatii.integrare(polinom1).getList().get(3).getCoeficient(), 9.7, 0.01);
        assertEquals(operatii.integrare(polinom1).getList().get(0).getPutere(), 5, 0.01);
        assertEquals(operatii.integrare(polinom1).getList().get(1).getPutere(), 4, 0.01);
        assertEquals(operatii.integrare(polinom1).getList().get(2).getPutere(), 2, 0.01);
        assertEquals(operatii.integrare(polinom1).getList().get(3).getPutere(), 1, 0.01);

        polinom1=operatii.extractPolinom("2.5");
        assertEquals(operatii.integrare(polinom1).getList().get(0).getCoeficient(), 2.5, 0.01);
        assertEquals(operatii.integrare(polinom1).getList().get(0).getPutere(), 1, 0.01);
    }

    @Test
    public void divideTest(){
        Operatii operatii=new Operatii();
        Polinom polinom1=operatii.extractPolinom("x^3-7");
        Polinom polinom2=operatii.extractPolinom("x-1");
        try {
            assertEquals(operatii.impartire(polinom1, polinom2).getList().get(0).getCoeficient(), 1, 0.01);
            assertEquals(operatii.impartire(polinom1, polinom2).getList().get(1).getCoeficient(), 1, 0.01);
            assertEquals(operatii.impartire(polinom1, polinom2).getList().get(2).getCoeficient(), 1, 0.01);
            assertEquals(operatii.impartire(polinom1, polinom2).getList().get(0).getPutere(), 2, 0.01);
            assertEquals(operatii.impartire(polinom1, polinom2).getList().get(1).getPutere(), 1, 0.01);
            assertEquals(operatii.impartire(polinom1, polinom2).getList().get(2).getPutere(), 0, 0.01);
        }
        catch (Exception exc) {
            System.out.println(exc.getMessage());
        }

        polinom1=operatii.extractPolinom("x-1");
        polinom2=operatii.extractPolinom("0");
        try {
            assertEquals(operatii.impartire(polinom1, polinom2).getList().get(0).getCoeficient(), 1, 0.01);
            assertEquals(operatii.impartire(polinom1, polinom2).getList().get(1).getCoeficient(), -1, 0.01);
            assertEquals(operatii.impartire(polinom1, polinom2).getList().get(0).getPutere(), 1, 0.01);
            assertEquals(operatii.impartire(polinom1, polinom2).getList().get(1).getPutere(), 0, 0.01);
        }
        catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
}
