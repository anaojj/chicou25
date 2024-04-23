package br.com;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Atv25{
    public static void main(String[] args) {
        List<Venda> vendas = criarListaDeVendas();

        exportarVendasParaCSV(vendas);
    }

    private static List<Venda> criarListaDeVendas() {
        List<Venda> vendas = new ArrayList<>();
        // Adicione algumas vendas à lista
        vendas.add(new Venda("2024-04-23", 100.0, "Produto A"));
        vendas.add(new Venda("2024-04-24", 150.0, "Produto B"));
        vendas.add(new Venda("2024-04-25", 200.0, "Produto C"));
        return vendas;
    }

    private static void exportarVendasParaCSV(List<Venda> vendas) {
        try (CSVWriter writer = new CSVWriter(new FileWriter("vendas.csv"))) {
            // Escreve o cabeçalho
            writer.writeNext(new String[]{"Data", "Valor", "Produto"});

            // Escreve cada venda na linha do arquivo CSV
            for (Venda venda : vendas) {
                String[] linha = {venda.getData(), String.valueOf(venda.getValor()), venda.getProduto()};
                writer.writeNext(linha);
            }

            System.out.println("Vendas exportadas para vendas.csv com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}