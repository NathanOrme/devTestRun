package com.capgemini.devtestrun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.devtestrun.items.Order;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args ){
		if(args.length != 0){
			System.out.println("Menu:");
			System.out.println("1.Cola: 50p");
			System.out.println("2.Coffee: £1");
			System.out.println("3.Cheese Sandwich: £2");
			System.out.println("4.Steak Sandwich: £4.50");
			Scanner in = new Scanner(System.in);
			System.out.print("Which item would you like?");
			List<String>entries = new ArrayList<String>();;
			String input = in.nextLine();
			while(!input.equalsIgnoreCase("x") || !input.contains("x")){
				boolean exit = false;
				entries.add(input);
				System.out.println("Item processed");
				System.out.println("Would you like to add another item? Press x if you wish to exit now");
				if(exit){
					System.out.println("Exiting system");
				}
			} 
			if(input.equalsIgnoreCase("x")){
				System.out.println("Processing items added");
				if(!entries.isEmpty()){
					processOrder(entries);
				}
				System.out.println("Exiting system");
				in.close();
			}
		} else {
			System.out.println("Arguments passed through, test run activated");
			List<String> arguments = new ArrayList<String>();
			for(String a : args){
				arguments.add(a);
			}
			processOrder(arguments);
		}
	}

	private static void processOrder(List<String> arguments) {
		Order order = new Order();
		
	}
}
