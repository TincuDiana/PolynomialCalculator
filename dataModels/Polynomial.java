package dataModels;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial <T extends Monom>{
    public List<T> pol= new ArrayList<>();

    public void sortareCoefDescr(Polynomial<T> p){
        Collections.sort(p.pol);
        Collections.reverse(p.pol);
    }

    public String polinomToStringd(Polynomial<DoubleMonom> p){
        String str= "";
        DecimalFormat df=new DecimalFormat();
        df.setMaximumFractionDigits(2);
        for (DoubleMonom im: p.pol) {
            if(im.getCoeficientd() == 0)
                str.concat("");
            else
            if(im.getCoeficientd() > 0)
            {   str=str + "+" + df.format(im.getCoeficientd())+ "x^"+im.getGrad();}
            else
            { str=str + "" + df.format(im.getCoeficientd())+"x^"+im.getGrad();}
        }
        return str;
    }
    public String polinomToString(Polynomial<IntMonom> p){
        String str= new String();
        for (IntMonom im: p.pol) {
            if(im.getCoeficient() == 0)
                str.concat("");
            else
            if(im.getCoeficient() > 0)
            { str=str+"+" + im.getCoeficient()+ "x^"+im.getGrad();}
            else
            { str=str+ ""+ im.getCoeficient()+"x^"+im.getGrad();}
        }
        return str;
    }

    public void printPolinom(Polynomial<T> p){
        Collections.sort(this.pol);
        Collections.reverse(this.pol);
        for (T im: p.pol) {
            if(im.getCoeficient() == 0)
                System.out.print("");
            else
            if(im.getCoeficient() > 0)
            System.out.print(" + " + im.getCoeficient() + "*x^"+ im.getGrad());
            else
                System.out.print(" " + im.getCoeficient() + "*x^"+ im.getGrad());
        }
    }
    public void printPolinomd(Polynomial<T> p){
        Collections.sort(this.pol);
        Collections.reverse(this.pol);
        for (T im: p.pol) {
            if(im.getCoeficientd() == 0)
                System.out.print("");
            else
            if(im.getCoeficientd() > 0)
                System.out.print(" + " + im.getCoeficientd() + "*x^"+ im.getGrad());
            else
                System.out.print(" " + im.getCoeficientd() + "*x^"+ im.getGrad());
        }
    }

    public Polynomial sumaPolinoame(Polynomial<IntMonom> p1, Polynomial<IntMonom> p2){
        Polynomial<IntMonom> p3= new Polynomial<IntMonom>();
        for (IntMonom m1 : p1.pol)
            for (IntMonom m2 : p2.pol)
                if (m1.getGrad() == m2.getGrad() && !m1.isAdaugatLaSuma() && !m2.isAdaugatLaSuma()) {
                    IntMonom m3=new IntMonom(0,0);
                    m3.setCoeficient(m1.getCoeficient() + m2.getCoeficient());
                    m3.setGrad(m1.getGrad());
                    p3.pol.add(m3);
                    p1.pol.get(p1.pol.indexOf(m1)).setAdaugatLaSuma(true);
                    p2.pol.get(p2.pol.indexOf(m2)).setAdaugatLaSuma(true);
                }
        for (IntMonom m1 : p1.pol) {
            for (IntMonom m2 : p2.pol) {
                if (!m1.isAdaugatLaSuma()) { p3.pol.add(m1);  p1.pol.get(p1.pol.indexOf(m1)).setAdaugatLaSuma(true);}
                if (!m2.isAdaugatLaSuma()) { p3.pol.add(m2); p2.pol.get(p2.pol.indexOf(m2)).setAdaugatLaSuma(true);}
            }
        }
        return p3;
    }

    public Polynomial diferentaPolinoame(Polynomial<IntMonom> p1, Polynomial<IntMonom> p2){
        Polynomial<IntMonom> p4= new Polynomial<IntMonom>();
        for (IntMonom m1 : p1.pol)
            for (IntMonom m2 : p2.pol)
                if (m1.getGrad() == m2.getGrad() && !m1.isAdaugatLaDiferenta() && !m2.isAdaugatLaDiferenta()) {
                    IntMonom m3= new IntMonom(0,0);
                    m3.setCoeficient(m1.getCoeficient() - m2.getCoeficient());
                    m3.setGrad(m1.getGrad());
                    p4.pol.add(m3);
                    p1.pol.get(p1.pol.indexOf(m1)).setAdaugatLaDiferenta(true);
                    p2.pol.get(p2.pol.indexOf(m2)).setAdaugatLaDiferenta(true);
                }
        for (IntMonom m1 : p1.pol) {
            for (IntMonom m2 : p2.pol) {
                if (!m1.isAdaugatLaDiferenta()) {
                    p4.pol.add(m1);
                    p1.pol.get(p1.pol.indexOf(m1)).setAdaugatLaDiferenta(true);}
                if (!m2.isAdaugatLaDiferenta()) {
                    m2.setCoeficient(m2.getCoeficient()*(-1));
                    p4.pol.add(m2); p2.pol.get(p2.pol.indexOf(m2)).setAdaugatLaDiferenta(true);}
            }
        }
        return p4;
    }
    public Polynomial inmultirePolinoamei(Polynomial<IntMonom> p1, Polynomial<IntMonom> p2){
        Polynomial<IntMonom> p= new Polynomial<IntMonom>();
        for (IntMonom i: p1.pol) {
            for (IntMonom j: p2.pol){
                int ok=0;
                IntMonom dm = new IntMonom(0,0);
                dm.setCoeficient(i.getCoeficient()*j.getCoeficient());
                dm.setGrad(i.getGrad()+j.getGrad());
                for (IntMonom k: p.pol)
                    if(k.getGrad()== dm.getGrad()){
                        k.setCoeficient(k.getCoeficient()+ dm.getCoeficient());
                        ok=1;
                    }
                if(ok==0)   { p.pol.add(dm); }
            }
        }
        return p;
    }

    public Polynomial inmultirePolinoame(Polynomial<DoubleMonom> p1, Polynomial<DoubleMonom> p2){
       Polynomial<DoubleMonom> p= new Polynomial<DoubleMonom>();
        for (DoubleMonom i: p1.pol) {
            for (DoubleMonom j: p2.pol){
                int ok=0;
                DoubleMonom dm = new DoubleMonom(0,0);
                dm.setCoeficientd(i.getCoeficientd()*j.getCoeficientd());
                dm.setGrad(i.getGrad()+j.getGrad());
                for (DoubleMonom k: p.pol)
                    if(k.getGrad()== dm.getGrad()){
                        k.setCoeficientd(k.getCoeficientd()+ dm.getCoeficientd());
                        ok=1;
                    }
                if(ok==0)   { p.pol.add(dm); }
            }
        }
        return p;
    }

    public Polynomial derivarePolinoame(Polynomial<DoubleMonom> p){
        Polynomial<DoubleMonom> res = new Polynomial<DoubleMonom>();
        for (DoubleMonom i: p.pol) {
            i.setCoeficientd(i.getGrad() * i.getCoeficientd());
            i.setGrad(i.getGrad() - 1);
        }
       return p;
    }
    public Polynomial derivarePolinoamei(Polynomial<IntMonom> p){
        Polynomial<IntMonom> res = new Polynomial<IntMonom>();
        for (IntMonom i: p.pol) {
            i.setCoeficient(i.getGrad() * i.getCoeficient());
            i.setGrad(i.getGrad() - 1);
        }
        return p;
    }

    public Polynomial integrarePolinoame(Polynomial<DoubleMonom> p){
        Polynomial<DoubleMonom> res = new Polynomial<DoubleMonom>();
        for (DoubleMonom i: p.pol) {
            i.setGrad(i.getGrad() + 1);
            i.setCoeficientd(i.getCoeficientd() / i.getGrad());
        }
        return p;
    }
    public Polynomial integrarePolinoamei(Polynomial<IntMonom> p){
        Polynomial<DoubleMonom> res = new Polynomial<DoubleMonom>();
        for (IntMonom i: p.pol) {
            DoubleMonom dm= new DoubleMonom(0,0);
            dm.setGrad(i.getGrad() + 1);
            dm.setCoeficientd((double)(i.getCoeficient()) / (i.getGrad()+1));
            res.pol.add(dm);
        }
        return res;
    }

    public int gradPolinom(Polynomial<T> p){
        int max=-1;
        for (T i: p.pol) {
            if(i.getGrad() >max)
                max=i.getGrad();
        }
        return max;
    }
    public Polynomial<DoubleMonom> sumaPolinoamed(Polynomial<DoubleMonom> p1, Polynomial<DoubleMonom> p2){
        Polynomial<DoubleMonom> p3= new Polynomial<DoubleMonom>();
        for (DoubleMonom m1 : p1.pol)
            for (DoubleMonom m2 : p2.pol)
                if (m1.getGrad() == m2.getGrad() && !m1.isAdaugatLaSuma() && !m2.isAdaugatLaSuma()) {
                    DoubleMonom m3=new DoubleMonom(0,0);
                    m3.setCoeficientd(m1.getCoeficientd() + m2.getCoeficientd());
                    m3.setGrad(m1.getGrad());
                    p3.pol.add(m3);
                    p1.pol.get(p1.pol.indexOf(m1)).setAdaugatLaSuma(true);
                    p2.pol.get(p2.pol.indexOf(m2)).setAdaugatLaSuma(true);
                }
        for (DoubleMonom m1 : p1.pol) {
            for (DoubleMonom m2 : p2.pol) {
                if (!m1.isAdaugatLaSuma()) { p3.pol.add(m1);  p1.pol.get(p1.pol.indexOf(m1)).setAdaugatLaSuma(true);}
                if (!m2.isAdaugatLaSuma()) { p3.pol.add(m2); p2.pol.get(p2.pol.indexOf(m2)).setAdaugatLaSuma(true);}
            }
        }
        return p3;
    }

    public Polynomial diferentaPolinoamed(Polynomial<DoubleMonom> p1, Polynomial<DoubleMonom> p2){
        Polynomial<DoubleMonom> p4= new Polynomial<DoubleMonom>();
        for (DoubleMonom m1 : p1.pol)
            for (DoubleMonom m2 : p2.pol)
                if (m1.getGrad() == m2.getGrad() && !m1.isAdaugatLaDiferenta() && !m2.isAdaugatLaDiferenta()) {
                    DoubleMonom m3= new DoubleMonom(0,0);
                    m3.setCoeficientd(m1.getCoeficientd() - m2.getCoeficientd());
                    m3.setGrad(m1.getGrad());
                    if(m3.getCoeficientd()!=0) { p4.pol.add(m3); }
                    p1.pol.get(p1.pol.indexOf(m1)).setAdaugatLaDiferenta(true);
                    p2.pol.get(p2.pol.indexOf(m2)).setAdaugatLaDiferenta(true);
                }
        for (DoubleMonom m1 : p1.pol) {
            for (DoubleMonom m2 : p2.pol) {
                if (!m1.isAdaugatLaDiferenta()) {
                    if(m1.getCoeficientd()!=0 ) {  p4.pol.add(m1);  }
                    p1.pol.get(p1.pol.indexOf(m1)).setAdaugatLaDiferenta(true); }
                if (!m2.isAdaugatLaDiferenta()) {
                    if(m2.getCoeficientd()!=0 ) { m2.setCoeficientd(m2.getCoeficientd()*(-1)); p4.pol.add(m2); }
                    p2.pol.get(p2.pol.indexOf(m2)).setAdaugatLaDiferenta(true); }
            }
        }
        for (DoubleMonom m: p4.pol) {
            m.setAdaugatLaDiferenta(false); }
        return p4;
    }

    public  void impartirePolinoame(Polynomial<DoubleMonom> p1, Polynomial<DoubleMonom> p2 , Polynomial<DoubleMonom> rest , Polynomial<DoubleMonom> cat) throws Exception {
        Collections.sort(p1.pol);Collections.reverse(p1.pol);
        Collections.sort(p2.pol);Collections.reverse(p2.pol);
        if(p1.gradPolinom(p1) < p2.gradPolinom(p2)){
            rest=p1;
            cat.pol.add(new DoubleMonom(0,0));
            throw new RuntimeException("Impartitorul are gradul prea mare");
        }
        else {
            while (p1.gradPolinom(p1) >= p2.gradPolinom(p2)) {
                DoubleMonom m = new DoubleMonom(0, 0);
                Polynomial<DoubleMonom> scazator = new Polynomial<DoubleMonom>();
                m.setGrad(p1.gradPolinom(p1) - p2.gradPolinom(p2));
                m.setCoeficientd(p1.pol.get(0).getCoeficientd() / p2.pol.get(0).getCoeficientd());
                cat.pol.add(m);
                for (DoubleMonom i : p2.pol) {
                    DoubleMonom monomScazator = new DoubleMonom(0, 0);
                    monomScazator.setGrad(m.getGrad() + i.getGrad());
                    monomScazator.setCoeficientd(i.getCoeficientd() * m.getCoeficientd());
                    scazator.pol.add(monomScazator);
                }
                p1 = p1.diferentaPolinoamed(p1, scazator);
            }
            rest.pol=p1.pol;
        }
    }

    public Polynomial<DoubleMonom> regexd(String s){
        Pattern pd= Pattern.compile("(-?\\b\\d+\\.\\d+)[xX]\\^(-?\\d+\\b)");
        Matcher md=pd.matcher(s);
        Polynomial<DoubleMonom> p=new Polynomial<DoubleMonom>();
        while(md.find() ){
            DoubleMonom dm= new DoubleMonom(0,0);
            DecimalFormat df= new DecimalFormat();
            dm.setCoeficientd(Double.parseDouble(md.group(1)));
            dm.setGrad(Integer.parseInt(md.group(2)));
            p.pol.add(dm);
        }
        return p;
    }

    public Polynomial<IntMonom> regexi(String s){
        Pattern pd= Pattern.compile("(-?\\b\\d+)[xX]\\^(-?\\d+\\b)");
        Matcher md=pd.matcher(s);
        Polynomial<IntMonom> p=new Polynomial<IntMonom>();
        while(md.find() ){
            IntMonom dm= new IntMonom(0,0);
            dm.setCoeficient(Integer.parseInt(md.group(1)));
            dm.setGrad(Integer.parseInt(md.group(2)));
            p.pol.add(dm);
        }
        return p;
    }
}

