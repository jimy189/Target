package com.br.targetdesafio;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Desafio3 {
    public static void main(String[] args) {
        try {
            // Lendo o arquivo dados.json
            BufferedReader br = new BufferedReader(new FileReader("dados.json"));
            StringBuilder jsonBuilder = new StringBuilder();
            String linha;
            while ((linha = br.readLine()) != null) {
                jsonBuilder.append(linha);
            }
            br.close();

            // Convertendo o conteúdo para JSONArray
            JSONArray faturamento = new JSONArray(jsonBuilder.toString());

            double menorValor = Double.MAX_VALUE;
            double maiorValor = Double.MIN_VALUE;
            double somaFaturamento = 0;
            int diasComFaturamento = 0;

            // Iterar pelos dados de faturamento
            for (int i = 0; i < faturamento.length(); i++) {
                JSONObject dia = faturamento.getJSONObject(i);
                double valor = dia.getDouble("valor");

                // Ignorar dias com faturamento 0
                if (valor > 0) {
                    if (valor < menorValor) menorValor = valor;
                    if (valor > maiorValor) maiorValor = valor;
                    somaFaturamento += valor;
                    diasComFaturamento++;
                }
            }

            // Calcular a média mensal
            double mediaMensal = somaFaturamento / diasComFaturamento;
            int diasAcimaDaMedia = 0;

            // Verificar os dias com faturamento acima da média
            for (int i = 0; i < faturamento.length(); i++) {
                JSONObject dia = faturamento.getJSONObject(i);
                double valor = dia.getDouble("valor");

                if (valor > mediaMensal) {
                    diasAcimaDaMedia++;
                }
            }

            // Exibir os resultados
            System.out.println("Menor valor de faturamento: " + menorValor);
            System.out.println("Maior valor de faturamento: " + maiorValor);
            System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}
