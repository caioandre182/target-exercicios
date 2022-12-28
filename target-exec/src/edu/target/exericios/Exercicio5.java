package edu.target.exericios;

/*
5) Escreva um programa que inverta os caracteres de um string.

IMPORTANTE:
a) Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser previamente definida no código;
b) Evite usar funções prontas, como, por exemplo, reverse;
 */

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha a palavra: ");
        String palavra = scanner.next();
        String reverse = "";

        for(int i = palavra.length() - 1; i >= 0; i--){
            char c = palavra.charAt(i);
            reverse += c;
        }

        System.out.println("Palavra escolhida: " + palavra);
        System.out.println("------------------------------");
        System.out.println("Palavra invertida: " + reverse);
    }
}
