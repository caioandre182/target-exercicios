package edu.target.exericios;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/*
4) Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:

SP – R$67.836,43
RJ – R$36.678,66
MG – R$29.229,88
ES – R$27.165,48
Outros – R$19.849,53

Escreva um programa na linguagem que desejar onde calcule o percentual de representação
que cada estado teve dentro do valor total mensal da distribuidora.
 */
public class Exercicio4 {
    public static void main(String[] args) {
        Map<String, Double> faturamentoMensal = new LinkedHashMap<>(){{
            put("SP", 67836.43);
            put("RJ", 36678.66);
            put("MG", 29229.88);
            put("ES", 27165.48);
            put("Outros", 19849.53);
        }};

        Double valorTotal = 0d;
        Set<Map.Entry<String, Double>> entries = faturamentoMensal.entrySet();
        for (Map.Entry<String, Double> entry : entries){
            valorTotal += entry.getValue();
        }

        System.out.println("Percentual de representação que cada estado teve dentro do valor total mensal da distribuidora.");
        for (Map.Entry<String, Double> entry : entries){
            Double porcentagem = entry.getValue() / valorTotal;
            String string = String.format("Estado: %s - Percentual: %.2f", entry.getKey(), porcentagem);
            System.out.println(string + "%.");
        }
    }
}
