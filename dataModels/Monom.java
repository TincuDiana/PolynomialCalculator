package dataModels;

import java.util.Comparator;

abstract public class Monom  implements Comparable<Monom> {
    private int grad;
    private boolean adaugatLaSuma;
    private boolean adaugatLaDiferenta;

    public Monom() {
        this.grad = 0;
        this.adaugatLaSuma=false;
        this.adaugatLaDiferenta=false;
    }

    public Monom(int grad,  boolean adaugat) {
        this.grad = grad;
        this.adaugatLaSuma=adaugat;
        this.adaugatLaDiferenta=false;
    }

    public Monom(int grad) {
        this.grad = grad;
        this.adaugatLaSuma=false;
        this.adaugatLaDiferenta=false;
    }
    public int getCoeficient() {  return 0;}
    public void setCoeficient(int coeficient) {  }
    public double getCoeficientd() {  return 0;}
    public void setCoeficientd(double coeficient) {  }
    public int getGrad() {return grad; }
    public void setGrad(int grad) { this.grad = grad; }
    public boolean isAdaugatLaSuma() { return adaugatLaSuma; }
    public void setAdaugatLaSuma(boolean adaugatLaSuma) { this.adaugatLaSuma = adaugatLaSuma; }
    public boolean isAdaugatLaDiferenta() { return adaugatLaDiferenta; }
    public void setAdaugatLaDiferenta(boolean adaugatLaDiferenta) { this.adaugatLaDiferenta = adaugatLaDiferenta; }

    @Override
    public int compareTo(Monom m){
        if(this.getGrad()<m.getGrad())
            return -1;
        else if(this.getGrad()<m.getGrad())
            return 1;
        return 0;
    }


}
