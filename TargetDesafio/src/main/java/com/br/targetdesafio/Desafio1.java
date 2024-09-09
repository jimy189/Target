package com.br.targetdesafio;

public class Desafio1 {
    public static void main(String[] args) {
        //1) Cálculo do valor de SOMA
        int INDICE = 13, SOMA = 0, K = 0;

        while (K < INDICE) {
            K = K + 1;
            SOMA = SOMA + K;
        }

        System.out.println("Valor final de SOMA: " + SOMA);
    }
}
