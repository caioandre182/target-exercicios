package edu.target.exericios;

/*
3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que calcule e retorne:
• O menor valor de faturamento ocorrido em um dia do mês;
• O maior valor de faturamento ocorrido em um dia do mês;
• Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.

IMPORTANTE:
a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser ignorados no cálculo da média;
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class Exercicio3 {
    public static void main(String[] args) {

        String json = "";
        // LENDO O ARQUIVO DADOS.JSON
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Projetos\\Target\\target-exercicios\\target-exec\\src\\edu\\target\\dados\\dados.json"));
            String linha;
            while((linha = br.readLine()) != null) {
                json += linha;
            }

            br.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // TRANSFORMANDO O ARQUIVO DADOS.JSON EM UM OBJETO FATURAMENTO
        Gson gson = new Gson();
        Type collectionType = new TypeToken<Collection<Faturamento>>(){}.getType();
        Collection<Faturamento> enums = gson.fromJson(json, collectionType);

        Map<Integer, Double> faturamento = new LinkedHashMap<>();
        for(Faturamento fat : enums){
            faturamento.put(fat.getDia(), fat.getValor());
        }

        System.out.println("O menor valor de faturamento ocorrido em um dia do mês:");
        Set<Map.Entry<Integer, Double>> entries = faturamento.entrySet();
        Double menorValor = faturamento.get(1);
        Integer diaMenorValor = 0;
        for (Map.Entry<Integer, Double> entry : entries){
            if(entry.getValue() != 0d){
                if(menorValor > entry.getValue()){
                    menorValor = entry.getValue();
                    diaMenorValor = entry.getKey();
                }
            }
        }

        System.out.println("Dia: " + diaMenorValor +  " - Valor: " + menorValor);
        System.out.println("");
        System.out.println("O maior valor de faturamento ocorrido em um dia do mês: ");
        Double maiorValor = 0d;
        Integer diaMaiorValor = 0;
        for (Map.Entry<Integer, Double> entry : entries){
            if(maiorValor < entry.getValue()){
                maiorValor = entry.getValue();
                diaMaiorValor = entry.getKey();
            }
        }
        System.out.println("Dia: " + diaMaiorValor +  " - Valor: " + maiorValor);

        // CALCULANDO A MÉDIA MENSAL
        Integer divisor = 0;
        Double soma = 0d;
        for (Map.Entry<Integer, Double> entry : entries){
            if(entry.getValue() != 0d){
                soma += entry.getValue();
                divisor++;
            }
        }

        Double mediaMensal = soma / divisor;
        Integer numeroDias = 0;
        System.out.println("");
        System.out.println("Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.");
        for (Map.Entry<Integer, Double> entry : entries){
            if (entry.getValue() > mediaMensal){
                System.out.print(entry.getKey() + " - ");
                numeroDias++;
            }
        }
        System.out.println("");
        System.out.println("Total de Dias: " + numeroDias);








    }

}


