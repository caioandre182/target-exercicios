package edu.target.exericios;
/*
Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores
(exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde, informado um número,
ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o número informado pertence ou não a sequência.

IMPORTANTE:
Esse número pode ser informado através de qualquer entrada de sua preferência ou pode ser previamente definido no código;
 */

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número: ");
        int numeroEscolhido = scanner.nextInt();

        int numero1 = 0;
        int numero2 = 1;

        if(numeroEscolhido == 0)
            System.out.println("O número " + numeroEscolhido + ", pertence a sequência de fibonacci.");
        else {

            while (numero2 != numeroEscolhido) {
                int var = numero2;
                numero2 = numero2 + numero1;
                numero1 = var;

                if (numero2 > numeroEscolhido)
                    break;
            }

            System.out.println("Verificando se o número " + numeroEscolhido + " pertence a sequência de fibonacci...");
            if (numero2 == numeroEscolhido)
                System.out.println("O número " + numeroEscolhido + ", pertence a sequência de fibonacci.");
            else {
                System.out.println("O número " + numeroEscolhido + ", NÃO pertence a sequência de fibonacci.");
            }
        }
    }
}
