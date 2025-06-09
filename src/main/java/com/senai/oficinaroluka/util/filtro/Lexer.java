package com.senai.oficinaroluka.util.filtro;

import java.util.ArrayList;
import java.util.List;

public class Lexer {

    public static class TokenObj {
        public Token tipo;
        public String valor;

        public TokenObj(Token tipo, String valor) {
            this.tipo = tipo;
            this.valor = valor;
        }

        @Override
        public String toString() {
            return tipo + "('" + valor + "')";
        }
    }

    public List<TokenObj> tokenize(String comando) {
        List<TokenObj> tokens = new ArrayList<>();

        String[] partes = comando.split(" ");
        for (String parte : partes) {
            if (parte.equalsIgnoreCase("AND")) {
                tokens.add(new TokenObj(Token.AND, "AND"));
            } else if (parte.equals("=")) {
                tokens.add(new TokenObj(Token.OPERADOR, "="));
            } else if (parte.contains(".")) {
                tokens.add(new TokenObj(Token.CAMPO, parte));
            } else if (parte.startsWith("\"") && parte.endsWith("\"")) {
                tokens.add(new TokenObj(Token.VALOR, parte.replace("\"", "")));
            }
        }

        tokens.add(new TokenObj(Token.EOF, ""));
        return tokens;
    }
}

