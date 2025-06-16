package com.senai.oficinaroluka.util;

public class ValidadorUtil {

    public static boolean validarPlaca(String placa) {
        return placa != null && placa.matches("^[A-Z]{3}[0-9][A-Z0-9][0-9]{2}$");
    }

    public static boolean validarCodigoPeca(String codigo) {
        return codigo != null && codigo.matches("^P[A-Z]{2}[0-9]{4}$");
    }

    public static boolean validarCodigoOrdem(String codigo) {
        return codigo != null && codigo.matches("^OS-[0-9]{6}$");
    }

    public static boolean validarCPF(String cpf) {
        if (cpf == null) return false;
        cpf = cpf.replaceAll("\\D", ""); 
        if (!cpf.matches("\\d{11}")) return false;

        int soma = 0, peso = 10;
        for (int i = 0; i < 9; i++) soma += (cpf.charAt(i) - '0') * peso--;
        int dig1 = 11 - (soma % 11); dig1 = (dig1 > 9) ? 0 : dig1;

        soma = 0; peso = 11;
        for (int i = 0; i < 9; i++) soma += (cpf.charAt(i) - '0') * peso--;
        soma += dig1 * 2;
        int dig2 = 11 - (soma % 11); dig2 = (dig2 > 9) ? 0 : dig2;

        return dig1 == (cpf.charAt(9) - '0') && dig2 == (cpf.charAt(10) - '0');
    }

    public static boolean validarCNPJ(String cnpj) {
        if (cnpj == null) return false;
        cnpj = cnpj.replaceAll("\\D", ""); 
        if (!cnpj.matches("\\d{14}")) return false;

        int[] pesos1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] pesos2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        int soma = 0;
        for (int i = 0; i < 12; i++) soma += (cnpj.charAt(i) - '0') * pesos1[i];
        int dig1 = soma % 11; dig1 = (dig1 < 2) ? 0 : 11 - dig1;

        soma = 0;
        for (int i = 0; i < 13; i++) soma += (cnpj.charAt(i) - '0') * pesos2[i];
        int dig2 = soma % 11; dig2 = (dig2 < 2) ? 0 : 11 - dig2;

        return dig1 == (cnpj.charAt(12) - '0') && dig2 == (cnpj.charAt(13) - '0');
    }
}


