package com.senac.jogos.cartas;

public class Baralho {

	private Carta[] cartas = new Carta[52];
	private int numCartas;
	
	public Baralho()
	{
		numCartas = 0;
		
		char[] naipes = new char[4];
		naipes[0] = 'C';
		naipes[1] = 'O';
		naipes[2] = 'P';
		naipes[3] = 'E';
		
		for (char naipe: naipes)
		{
			for (int valor = 1; valor <= 13; valor++)
			{
				cartas[numCartas] = new Carta(naipe,valor);
				numCartas++;
			}
		}
	}
	
	public Carta getCarta()
	{
		int carta = (int)(Math.random() * numCartas);
		Carta sorteada = cartas[carta];

		numCartas--;
		
		cartas[carta] = cartas[numCartas]; 
		
		return sorteada;
	}
	
	public static void main(String[] args)
	{
		Baralho baralho = new Baralho();
		for (int i = 1; i < 10; ++i) {
			Carta c = baralho.getCarta();
			System.out.println("Carta: " + c.getValor() + c.getNaipe());
		}
			
	}
	
}
