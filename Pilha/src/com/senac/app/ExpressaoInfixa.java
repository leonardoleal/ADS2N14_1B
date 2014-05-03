package com.senac.app;

import static java.lang.System.*;
import java.util.Scanner;

import com.senac.estruturas.Stack;

public class ExpressaoInfixa {

    public static String infixa2posfixa(String infixa) {
    	Stack<Character> pilha = new Stack<Character>();
    	String posfixa = "";

    	for (char ch : infixa.toCharArray()){
			if (ch == '(') {
				pilha.push(ch);

			} else if (ch== ')') {
				while(!pilha.isEmpty()) {
					if (pilha.peek() == '(') {
						pilha.pop();
						break;
					}
					posfixa += pilha.pop();
				}

			} else if ("*/".indexOf(ch) >= 0) {
				if (!pilha.isEmpty()
						&& "(+-".indexOf(pilha.peek()) < 0)
					posfixa += pilha.pop();
				pilha.push(ch);

			} else if ("+-".indexOf(ch) >= 0) {
				if (!pilha.isEmpty()
						&& pilha.peek() != '(')
					posfixa += pilha.pop();
				pilha.push(ch);

			} else if (Character.isDigit(ch)) {
				posfixa += ch;
			}
    	}

		while (!pilha.isEmpty()) {
			posfixa += pilha.pop();
		}

		return posfixa;
    }

    public static double resolveExpInfixa(String infixa) {
    	Stack<Double> pilha = new Stack<Double>();
    	String posfixa = infixa2posfixa(infixa);
    	double arg2;

    	for (char ch : posfixa.toCharArray()){
    		if (Character.isDigit(ch)) {
				pilha.push(
						Double.parseDouble(
								Character.toString(ch)
						)
				);
			} else {
				arg2 = pilha.pop();
				pilha.push(
						execOperacao(pilha.pop(), arg2, ch)
				);
			}
    	}

    	return Double.parseDouble(
    			pilha.pop().toString()
    	);
	}

    private static double execOperacao(double val, double val2, char ch) {
    	double result = 0;

    	switch (ch) {
			case '/':
				result = val / val2;
				break;

			case '*':
				result = val * val2;
				break;

			case '+':
				result = val + val2;
				break;

			case '-':
				result = val - val2;
				break;
		}

		return result;
	}

	public static void main(String[] args) {
    	Scanner scanner = new Scanner(in);
    	
    	out.println("Entre com a expressão infixa: ");
    	String infixa = scanner.nextLine();

    	out.println(resolveExpInfixa(infixa));

		scanner.close();
	}
}