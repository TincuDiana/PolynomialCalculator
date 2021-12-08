package dataModels;

public class IntMonom extends Monom{
    private int coeficient;

    public IntMonom() {
        super();
        this.coeficient = 1;
    }

    public IntMonom(int grad, int coeficient, boolean adaugat) {
        super(grad, adaugat);
        this.coeficient = coeficient;

    }

    public IntMonom(int grad, int coeficient) {
       super(grad);
        this.coeficient = coeficient;
    }
    @Override
    public int getCoeficient() { return coeficient; }
    @Override
    public void setCoeficient(int coeficient) { this.coeficient = coeficient; }
}
