package com.example.ds;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {

	   static boolean isAnagram(String a, String b) {
		   
		   if (a.length()!=b.length()) {
			return false;
		}
		   Map<Character, Integer> mapaMap = new HashMap<Character, Integer>();
		   for (char iterable_element : a.toCharArray()) {
			if (mapaMap.containsKey(iterable_element)) {
				mapaMap.put(iterable_element, mapaMap.get(iterable_element)+1);
			}
			else {
				mapaMap.put(iterable_element, 1);
			}
		}
		   for (char iterable_element : b.toCharArray()) {
				if (mapaMap.containsKey(iterable_element)) {
					mapaMap.put(iterable_element, mapaMap.get(iterable_element)+1);
				}
				else {
					return false;
				}
			}
		   if (mapaMap.values().stream().
				   filter((x)->x%2!=0).
				   findAny().
				   isPresent()) {
			   return false;
			
		}
		   return true;
	        
	    }
	   static boolean isaAnagram(String a, String b) {
		   
		   if (a.length()!=b.length()) {
			return false;
		}
		   int[] c = new int [70];
		   int[] d = new int [70];
		  
		   for (int i = 0; i < a.length() && i< b.length(); i++) {
			c[a.toLowerCase().charAt(i)-'a']++;
			d[b.toLowerCase().charAt(i)-'a']++;
		}
		  for (int i = 0; i < 26; i++) {
			if (c[i]!=d[i]) {
				return false;
			}
		}
		   return true;
	        
	    }

	   public static void removeDuplicate(String string) {
		
		   
		   
	}
	  public static void main(String[] args) {
	    
		  int[] count1 = new int[139];
		  
	        Scanner scan = new Scanner(System.in);
	        String a = scan.next();
	        String b = scan.next();
	        scan.close();
	        boolean ret = isaAnagram(a, b);
	        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
	    }

}
