package com.senai.oficinaroluka.util.filtro;

import java.util.List;

public class Parser {

    private List<Lexer.TokenObj> tokens;
    private int pos = 0;

    public Parser(List<Lexer.TokenObj> tokens) {
        this.tokens = tokens;
    }

    public boolean parse() {
        // Simples verificação de estrutura: CAMPO = VALOR AND CAMPO = VALOR ...
        while (pos < tokens.size()) {
            if (!match(Token.CAMPO)) return false;
            if (!match(Token.OPERADOR)) return false;
            if (!match(Token.VALOR)) return false;

            if (current().tipo == Token.AND) {
                match(Token.AND);
            } else if (current().tipo == Token.EOF) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean match(Token esperado) {
        if (current().tipo == esperado) {
            pos++;
            return true;
        }
        return false;
    }

    private Lexer.TokenObj current() {
        if (pos >= tokens.size()) {
            return new Lexer.TokenObj(Token.EOF, "");
        }
        return tokens.get(pos);
    }
}

