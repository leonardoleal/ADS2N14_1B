package com.senac.app;

import static java.lang.System.*;
import java.util.Scanner;

import com.senac.estruturas.Stack;

public class ConversosBinario {

	public static int dec2bin(int decimal) {
		Stack<String> pilha = new Stack<String>();

        while (decimal != 0) {
            if (decimal % 2 == 1)
                pilha.push("1");

            else
                pilha.push("0");

            decimal /= 2;
        }

        String binary = "0";
        while (!pilha.isEmpty()) {
			binary += pilha.pop();
			
		}

		return Integer.parseInt(binary);
    }

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(in);
    	
    	out.println("Entre com o valor decimal: ");
    	int input = scanner.nextInt();

		out.println("Valor em binário: " + dec2bin(input));

		scanner.close();
	}
}