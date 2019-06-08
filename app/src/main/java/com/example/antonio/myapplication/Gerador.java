package com.example.antonio.myapplication;

import java.util.Arrays;
import java.util.Random;

public class Gerador {

    public static int[] gerarNumerosDaLoteria(int quantidade, int total) {
        int[] lista = new int[quantidade];
        for (int i = 0; i < quantidade; i++) {
            lista[i] = new Random().nextInt((total)) + 1;
            for (int j = 0; j < i; j++)
                if (lista[j] == lista[i]) {
                    i--;
                    break;
                }
        }
        Arrays.sort(lista);
        return lista;
    }
}
