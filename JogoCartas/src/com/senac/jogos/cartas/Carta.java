package com.senac.jogos.cartas;


public class Carta
{
    private char naipe;
    private int  valor;
    
    public Carta(char naipe, int valor)
    {
        switch (naipe) {
            case 'C':
            case 'O':
            case 'P':
            case 'E':
                this.naipe = naipe;
                break;
            default:
                this.naipe = 'J';
        }
        
        if (valor > 0 || valor <= 13)
            this.valor = valor;
        else {
            this.valor = '0';
            this.naipe = 'J';
        }
    }
    
    public char getNaipe()
    {
    	return this.naipe;
    }

    public int getValor()
    {
        return this.valor;
    }

    public String getValorLegenda() {
    	String legenda;

		switch (this.valor) {
			case 1:
				legenda = "A";
				break;
			case 11:
				legenda = "J";
				break;
			case 12:
				legenda = "Q";
				break;
			case 13:
				legenda = "K";
				break;
				
			default:
				legenda = Integer.toString(valor);
				break;
		}

		return legenda;
	}
}
