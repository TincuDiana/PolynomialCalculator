package dataModels;

public class DoubleMonom extends Monom{
    private double coeficientd;

    public DoubleMonom() {
        super();
        this.coeficientd = 1;
    }

    public DoubleMonom(int grad, double coeficient, boolean adaugat) {
        super(grad, adaugat);
        this.coeficientd = coeficient;

    }

    public DoubleMonom(int grad, double coeficient) {
        super(grad);
        this.coeficientd = coeficient;
    }
    @Override
    public double getCoeficientd() { return this.coeficientd; }
    @Override
    public void setCoeficientd(double coeficient) { this.coeficientd = coeficient; }
}
