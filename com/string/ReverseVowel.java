package com.string;
public class ReverseVowel {
    // ********String is immutable
	
    // public String reverseVowels(String s) {    
    //     int i =0;
    //     int j = s.length() - 1;
    //     while(i<=j){
    //         if( isVowel(s.charAt(i)) && isVowel(s.charAt(j))){
              
    //             char ch = s.charAt(i);      //swaping not works
    //             s.charAt(i) = s.charAt(j);
    //             s.charAt(j) = ch;
    //             i++;
    //             j++;
    //         }else if( isVowel(s.charAt(i))){
    //             j++;
    //         }else{
    //             i++;
    //         }   
    //     }
    // }
	
    public String reverseVowels(String s) {  
        char arr[] = s.toCharArray();  
        int i =0;
        int j = s.length() - 1;
        while(i<=j){
            if( isVowel(arr[i]) && isVowel(arr[j])){
              
                char ch = arr[i];
                arr[i] = arr[j];
                arr[j] = ch;
                i++;
                j--;
            }else if( isVowel(arr[i])){
                j--;
            }else{
                i++;
            }   
        }
        return new String(arr);
    }
    public boolean isVowel(char ch){
        if(ch == 'a' || ch=='e' || ch == 'i' || ch=='o' || ch=='u'){
            return true;
        }
         else if(ch == 'A' || ch=='E' || ch == 'I' || ch=='O' || ch=='U'){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String args[]) {
    	
    }
}