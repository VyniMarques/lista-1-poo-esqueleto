package br.inatel.cdg.algebra.reta;

public class Reta {

    private Ponto p1,p2;

    //Construtor
    public Reta(Ponto p1, Ponto p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public double coeficienteAngular(){

        double coefAng = 0.0;

        coefAng = (p2.getY()- p1.getY())/(p2.getX() - p1.getX());

        return coefAng;
    }

    public double coeficienteLinear(){

        double coefLin = 0.0;

        coefLin = p1.getY() - coeficienteAngular()*p1.getX();

        return coefLin;
    }
}
