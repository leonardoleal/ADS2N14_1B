package com.senac.polindromo;

import static java.lang.System.*;

import java.text.Normalizer;
import java.util.Scanner;

import com.senac.estruturas.Stack;

public class Polindromo {

    public static boolean isPolindromo(String input) {
		Stack<Character> pilha = new Stack<Character>();
		String stringCleaned = formatString(input).toLowerCase();
		String stringReverse = "";
		int stringLength = stringCleaned.length();

		for (int i = 0; i < stringLength; i++) {
			pilha.push(stringCleaned.charAt(i));
		}

		for (int i = 0; i < stringLength; i++) {
			stringReverse += pilha.pop().toString();
		}

		return stringCleaned.equals(stringReverse);
    }

    private static String formatString(String s) {  
        String temp = Normalizer.normalize(s, java.text.Normalizer.Form.NFD);
        temp = temp.replaceAll("\\W", "");
        return temp.replaceAll("[^\\p{ASCII}]","");  
    }

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(in);
    	
    	out.println("Entre com a palavra ou frase a ser comparada: ");
    	String stringInput = scanner.nextLine();

		if (isPolindromo(stringInput)) {
			out.println("É um polímdromo!");
		} else {
			out.println("Não é um...");
		}

		scanner.close();
	}
}