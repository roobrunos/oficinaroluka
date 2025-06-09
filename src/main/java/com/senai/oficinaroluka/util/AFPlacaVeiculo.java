package com.senai.oficinaroluka.util;

public class AFPlacaVeiculo {

    public static boolean validar(String placa) {
        if (placa == null || placa.length() != 7) return false;

        char[] chars = placa.toCharArray();

        for (int i = 0; i < 3; i++) {
            if (!Character.isUpperCase(chars[i])) return false;
        }
        if (!Character.isDigit(chars[3])) return false;

        if (!Character.isLetterOrDigit(chars[4])) return false;

        return Character.isDigit(chars[5]) && Character.isDigit(chars[6]);
    }
}

