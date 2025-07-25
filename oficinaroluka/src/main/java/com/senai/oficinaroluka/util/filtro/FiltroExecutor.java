package com.senai.oficinaroluka.util.filtro;

import java.util.List;
import java.util.stream.Collectors;

import com.senai.oficinaroluka.model.OrdemServico;

public class FiltroExecutor {

    public static List<OrdemServico> filtrar(List<OrdemServico> ordens, String comando) {
        Lexer lexer = new Lexer();
        List<Lexer.TokenObj> tokens = lexer.tokenize(comando);

        Parser parser = new Parser(tokens);
        if (!parser.parse()) {
            throw new IllegalArgumentException("Comando inválido");
        }

               // simplificado: só lida com status por enquanto
             // status "em aberto"
        return ordens.stream()
                .filter(ordem -> {
                    if (comando.contains("status") && comando.contains("\"em aberto\"")) {
                        return ordem.getStatus().equalsIgnoreCase("em aberto");
                    }
                    return true;
                })
                .collect(Collectors.toList());
    }
}

