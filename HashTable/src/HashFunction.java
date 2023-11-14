
//
//Tabela Hash (Open Addressing/Chaining) - Exemplo de implementação em Java
//Copyright (C) 2023 André Kishimoto
//
//This program is free software: you can redistribute it and/or modify
//it under the terms of the GNU General Public License as published by
//the Free Software Foundation, either version 3 of the License, or
//(at your option) any later version.
//
//This program is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU General Public License for more details.
//
//You should have received a copy of the GNU General Public License
//along with this program.  If not, see <https://www.gnu.org/licenses/>.
//


public class HashFunction {
	
	public static int mod(int k, int m) {
		System.out.println(k + " mod " + m);
		return k % m;
	}
	
	public static int extracao(int k) {
		int primeiro_digito = k / 10000;
		int x = k % 10000;
		x = x % 1000;
		int segundo_digito = x/100;
		x = x % 100;
		x = x % 10;
		int terceiro_digito = x/1;
		
		int chave = primeiro_digito * 100+ segundo_digito*10 + terceiro_digito;
		System.out.println("Primeiro, terceiro e quinto digitos extraidos: " + chave);
		return chave;
	}
	
	public static int quadratico(int k) {
		int chave = k*k;
		System.out.println("Chave ao quadrado: " + chave);
		if (chave/100000 >= 1) {
			int x = chave % 100000;
			x = x % 10000;
			int primeiro_digito = x/1000;
			x = x %1000;
			int segundo_digito = x/100;
			chave = primeiro_digito*10+segundo_digito;
			System.out.println("Digitos do meio:" + chave);
			return chave;
		}
		else {
			int x = chave % 10000;
			x = x % 1000;
			chave  = x/100;
			System.out.println("Digito do meio:" + chave);
			return chave;
		}
	}
	
	public static int funcaoHash(int k) {
		return HashFunction.mod(HashFunction.quadratico(HashFunction.extracao(k)),7);
}
	
}