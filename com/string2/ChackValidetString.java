package com.string2;

import javax.print.attribute.standard.Chromaticity;

public class ChackValidetString {

	public static boolean chekValidation(String str) {
		String spletDecimple[] = str.split("\\.");
		if(spletDecimple.length > 2) {
			System.out.println("condition one false");
			return false;
		}
		String intPart = spletDecimple[0];
		String chunkInt[] = intPart.split(",");
		
		if(chunkInt[0].length()<1 || chunkInt[0].length()>3) {
			System.out.println("condition Two false");
			return false;
		}

			for(int i =0; i<chunkInt.length; i++) {
				
				for(char ch : chunkInt[i].toCharArray()) {
					if(!Character.isDigit(ch)) {
						System.out.println("condition Three false");
						return false;
					}
					if(i != 0 && chunkInt[i].length() != 3) {
						System.out.println("condition Four false");
						return false;
					}
				}
				
			}
			
		if(spletDecimple[1] != null) {
			for(char ch : spletDecimple[1].toCharArray()) {
				if(!Character.isDigit(ch)) {
					System.out.println("condition five false");
					return false;
				}
					
			}
		}
		
		
		return true;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "2,344,224.7883";
		System.out.println(chekValidation(input));
		
		String input1 = "2,34,224.7883";
		System.out.println(chekValidation(input1));
		
		String input2 = ",344,224.7883";
		System.out.println(chekValidation(input2));
		
		String input3 = "2362,344,224.7883";
		System.out.println(chekValidation(input3));
		
		String input4 = "362,344,224.7883";
		System.out.println(chekValidation(input4));
		
		String input5 = "362,344,224.78,83";
		System.out.println(chekValidation(input5));




	}

}
