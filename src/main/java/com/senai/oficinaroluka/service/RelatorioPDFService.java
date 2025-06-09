package com.senai.oficinaroluka.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.senai.oficinaroluka.model.OrdemServico;
import com.senai.oficinaroluka.model.Peca;
import com.senai.oficinaroluka.model.ServicoExecutado;

@Service
public class RelatorioPDFService {

    public ByteArrayInputStream gerarRelatorioOrdens(List<OrdemServico> ordens) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font fonteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Font fonteTexto = FontFactory.getFont(FontFactory.HELVETICA, 12);

            document.add(new Paragraph("Relatório de Ordens de Serviço", fonteTitulo));
            document.add(new Paragraph(" ")); // Espaço

            for (OrdemServico os : ordens) {
                document.add(new Paragraph("Código: " + os.getCodigo(), fonteTexto));
                document.add(new Paragraph("Status: " + os.getStatus(), fonteTexto));
                document.add(new Paragraph("Cliente: " + os.getCliente().getNome(), fonteTexto));
                document.add(new Paragraph("Veículo: " + os.getVeiculo().getModelo() + " (" + os.getVeiculo().getPlaca() + ")", fonteTexto));

                document.add(new Paragraph("Serviços Executados:", fonteTexto));
                for (ServicoExecutado serv : os.getServicos()) {
                    document.add(new Paragraph(" - " + serv.getDescricao() + " | Profissional: " + serv.getProfissional() + " | R$ " + serv.getValor(), fonteTexto));
                }

                document.add(new Paragraph("Peças Utilizadas:", fonteTexto));
                for (Peca p : os.getPecas()) {
                    document.add(new Paragraph(" - " + p.getNome() + " | Código: " + p.getCodigo() + " | R$ " + p.getPreco(), fonteTexto));
                }

                document.add(new Paragraph("---------------------------------------------------------------------"));
            }

            document.close();
        } catch (DocumentException e) {
            throw new RuntimeException("Erro ao gerar PDF", e);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}

