package com.senac.app;

import static java.lang.System.*;
import java.util.Scanner;

import com.senac.estruturas.Stack;

public class ExpressaoInfixa {

    public static String infixa2posfixa(String infixa) {
    	Stack<Character> pilha = new Stack<Character>();
    	String posfixa = "";
    	char chAnterior = ' ';

    	for (Character ch : infixa.toCharArray()){
			if (ch == '(') {
				pilha.push(ch);

			} else if (ch== ')') {
				while(!pilha.isEmpty()) {
					if (pilha.peek() == '(') {
						pilha.pop();
						break;
					}
					posfixa += pilha.pop();
					posfixa += " ";
				}

			} else if ("*/".indexOf(ch) >= 0) {
				if (!pilha.isEmpty()
						&& "(+-".indexOf(pilha.peek()) < 0) {
					posfixa += pilha.pop();
					posfixa += " ";
				}
				pilha.push(ch);

			} else if ("+-".indexOf(ch) >= 0) {
				if (!pilha.isEmpty()
						&& pilha.peek() != '(') {
					posfixa += pilha.pop();
					posfixa += " ";
				}
				pilha.push(ch);

			} else if (Character.isDigit(ch)) {
				if (Character.isDigit(chAnterior)) {
					posfixa = posfixa.trim();
				}
				
				posfixa += ch;
				posfixa += " ";
			}

			chAnterior = ch;
    	}

		while (!pilha.isEmpty()) {
			posfixa += pilha.pop();
			posfixa += " ";
		}

		return posfixa.trim();
    }

    public static double resolveExpInfixa(String infixa) {
    	Stack<Double> pilha = new Stack<Double>();
    	String posfixa = infixa2posfixa(infixa);
    	char chAnterior = ' ';
    	double arg2;

    	for (char ch : posfixa.toCharArray()){
    		if (Character.isDigit(ch)) {
				if (Character.isDigit(chAnterior)) {
					pilha.push(
							Double.parseDouble(
									String.format("%.0f%c", pilha.pop(), ch)
							)
					);
					continue;
				}

				pilha.push(
						Double.parseDouble(
								Character.toString(ch)
						)
				);
			} else if (ch != ' ') {
				arg2 = pilha.pop();
				pilha.push(
						execOperacao(pilha.pop(), arg2, ch)
				);
			}

			chAnterior = ch;
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