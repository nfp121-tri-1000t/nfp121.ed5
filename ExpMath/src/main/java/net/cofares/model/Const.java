package net.cofares.model;

import net.cofares.visiteur.eval.Eval;


/**
 * Const ::= entier de java 
 * Redéfinition de equals() pour égalité entre 2 Const
 * //TODO redefinir aussi hashcode()
 * @author Pascal Fares (c) Cnam Liban
 */
public class Const extends Expression {

    public static Const create(Integer i) {
        return new Const(i);
    }
    private Integer i;

    private Const(Integer i){
        this.i=i;
    }

    @Override
    public Expression eval() {
        return e.eval(this); 
    }

    @Override
    public String show() {
        return es.eval(this);
    }

    @Override
    public Integer evalNum() {
        return en.eval(this);
    }

    public static void main(String args[]) {

        Const instance = Const.create(10);
        System.out.println("show = "+instance.eval());
        System.out.println("show = "+instance.show());
        System.out.println("EvalNum = "+instance.evalNum());
    }

    public boolean equals(Object o) {  
        if (o == this) { 
            return true; 
        } 
        if (!(o instanceof Const)) { 
            return false; 
        }
        //Ceci est de la programation deffensive assert permet
        //De verifier que la pré-condition de notre traitement est comme
        //Prévu
        //Pour utiliser assert faire java -ea <pgmJava>
        assert((o != this) && (o instanceof Const));
        //o!=this ET o instanceof Const
        Const autre = (Const) o;
        return (this.getI().intValue() == autre.i.intValue());

    }

    /**
     * @return the i
     */
    public Integer getI() {
        return i;
    }

    //Le plus général
    @Override
    public <T> T evalAccept(Eval<T> e) {
       return e.eval(this);
    }

}