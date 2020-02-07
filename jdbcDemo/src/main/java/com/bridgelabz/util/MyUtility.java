package com.bridgelabz.util;

//Putting commonly used functions in a single file

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MyUtility 
    {

	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static Scanner sc = new Scanner(System.in);

	//used to input a String
	public static String inputWords(){ 
	
	return sc.nextLine();
	}

	public static String inputWord(){ 
		
		return sc.next();
	}

	// used to input an integer values
	public static int inputInteger(){

		
		return sc.nextInt();


	}
	// used to input a float value
	public static float inputFloat() {
	
		return sc.nextFloat();
	}

	// used input an double value
	public static double inputDouble(){

		return 	sc.nextDouble();
	}

	// used to input an long values
	public static long inputLong(){
		return sc.nextLong();

	}

	




}
