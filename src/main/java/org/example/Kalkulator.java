package org.example;

public class Kalkulator {
    public int a;
    public int b;

    public Kalkulator(int a, int b){
        this.a = a;
        this.b = b;
    }
    public int tambah(){
        return a + b;
    }
    public int kurang(){
        return a - b;
    }
    public int kali(){
        return a * b;
    }
    public int bagi(){
        return a / b;
    }
}
