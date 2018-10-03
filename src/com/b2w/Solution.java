package com.b2w;

import java.util.ArrayList;

public class Solution {
	
	public static void main(String[] args) {
		
		String num = args[0];
		
		char[] nn = num.toCharArray();
	
		ArrayList list = new ArrayList();
		
		for (int i = 0; i < nn.length; i++) {
			
			list.add(String.valueOf(nn[i]));
			
			
		}
		
		ArrayList lexchangeda =exchange(list);
		
		System.out.println("Total permutation: " + lexchangeda.size());
		
		for (int i=0;i<lexchangeda.size();i++){
			String[]teste=(String[])lexchangeda.get(i);
			System.out.print("\n");
			
			for(int j=0;j<teste.length;j++){
				System.out.print(teste[j]);
			}
		}
		System.exit(0);
	}
	private static int factorial(int num){
		int valor=1;
		for (int i=1;i<=num;i++){
			valor=valor*i;
		}
		return valor;
	}
	
	private static ArrayList exchange(ArrayList list){
		ArrayList lperm = new ArrayList();
		ArrayList exchangecoes = new ArrayList();
		int n=list.size();
		int nrPerm=factorial(n);	
		int vaux[]=new int[n-1];
		int posBco[]=new int[n-1];
		for(int i=0;i<n-1;i++){
			vaux[i]=factorial(n-1-i);
		}
		for(int k=0;k<nrPerm;k++){
			for(int i=0;i<n-1;i++){
				posBco[i]=0;
			}
			int soma_k=k;			
			int multiplicando=n-1;
			int index=0;
			while(soma_k>0){
				int multiplication=vaux[index]*multiplicando;
				if(multiplication<=soma_k){
					soma_k=soma_k-multiplication;
					posBco[index]=multiplicando;
					multiplicando=n-1;
					index++;
				}else{
					multiplicando--;
					if(multiplicando==0){
						index++;
						multiplicando=n-1;
					}
				}
			}
			lperm.add(posBco.clone());
		}
		
		for(int k=0;k<lperm.size();k++){
			int index=n-1;
			int[]posicoes=(int[])lperm.get(k);
			String [] individuo = new String[n];
			for(int i=0;i<n;i++){
				individuo[i]="";
			}
			int id=0;
			for(int i=0;i<posicoes.length;i++){
				int position=posicoes[i];
				int vazio=0;
				while(vazio<position){
					if(individuo[id].equals("")){
						vazio++;
					}
					id++;
				}
				while(individuo[id].equals("")==false){
					id++;
				}
				individuo[id]=(String)list.get(index);
				id=0;
				while(individuo[id].equals("")==false){
					id++;
				}
				index--;
			}
			
			for(int i=0;i<individuo.length;i++){
				if(individuo[i].equals("")){
					individuo[i]=(String)list.get(0);
				}
			}
			exchangecoes.add(individuo.clone());
		}
		return exchangecoes;
	

	}
	
}
