package com.projeto.atribuicaoreferencia;

public class Main {
    public static void main(String[] args) {
        int intA = 1;
        int intB = intA;

        MeuObjeto objA = new MeuObjeto(1);
        MeuObjeto objB = objA;

        System.out.println("Obj A :"+ objA+ " Obj B :"+objB);
        objA.setNum(2);
        System.out.println("Obj A :"+ objA+ " Obj B :"+objB);
    }
}
