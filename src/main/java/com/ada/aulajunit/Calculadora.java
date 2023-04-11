package com.ada.aulajunit;

import org.springframework.stereotype.Component;

public class Calculadora {

    public int somar(int x, int y){
        return x + y;
    }

    public int subtrair(int x, int y){
        return x - y;
    }

    public float dividir(int x, int y){
        return x / y;
    }
}
