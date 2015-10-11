import java.io.*;
import java.util.*;

class Aleatorio
{	
	static int numero(int max, int min){
		Random rand = new Random();
		return rand.nextInt((max-min)+1) + min;
	}

	static String binario(){
		String res="";
		int tam = numero(20,4);
		while(tam-->0){
			if(Math.random()<0.5)
				res+='0';
			else
				res+='1';
		}
		return res;
	}

	static String si_no()	{
		if(Math.random()<0.5)
			return "N";
		return "S";
	}

	static String ajedrez(){
		String res = "";
		int tam = numero(20,2);
		while(tam-->0){
			switch(numero(1,2)){
				case 1:
					res += "R";
					break;

				case 2:
					res += "B";
					break;
			}
		}
		return res;
	}

	static String webay(){
		String res="";
		int tam = numero(20,4);
		while(tam-->0){
			switch(numero(6,1)){
				case 1:
					res += "w";
					break;

				case 2:
					res += "e";
					break;

				case 3:
					res += "b";
					break;

				case 4:
					res += "a";
					break;

				case 5:
					res += "y";
					break;

				case 6:
					res += " ";
			}
		}
		return res;
	}

	static String alfabeto(){
		String res = "";
		int tam = numero(17,5);
		while(tam-->0){
			res += "0" + numero(48,1);
		}
		return res;
	}

	static String parentesis(){
		String res = "";
		int tam = numero(28,5);
		while(tam-->0){
			res += "(" + numero(1,0);
		}
		return res;
	}	
}