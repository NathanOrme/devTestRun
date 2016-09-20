package com.capgemini.devtestrun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.devtestrun.items.Items;
import com.capgemini.devtestrun.items.Order;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args ){
		if(args.length == 0){
			System.out.println("Welcome to Cafe X");
			System.out.println("Can we take your order: ");
			System.out.println("***************************");
			System.out.println("COLA for cola (£0.50)");
			System.out.println("COFFEE for coffee(£1.00)");
			System.out.println("CHEESESW for Cheese Swandwich (£2.00)");
			System.out.println("STEAKSW for Steak Sandwich (£4.50)");
			System.out.println("EXIT for exit");
			System.out.println("***************************");
			Scanner in = new Scanner(System.in);
			System.out.print("Which item would you like?");
			List<String>entries = new ArrayList<String>();;
			String input = in.nextLine();
			boolean exit = false;
			while(!exit){
				if(!input.equalsIgnoreCase("x") || !input.contains("x")){

					entries.add(input);
					System.out.println("Item processed");
					System.out.println("Would you like to add another item? Press x if you wish to exit now");
					input = in.nextLine();
				} else {
					exit = true;
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
		for(String a : arguments){
			if(Items.getById(a) != null){
				Items item = Items.getById(a);
				order = addItem(order,item);
			} else {
				System.out.println("No item was found for following entry: " + a);
			}
		}
		if(orderIsEmpty(order)){
			System.out.println("No items added, no charge");
		} else {
			System.out.println("Items found, calculating total charge");
			double total = order.printTotalCostOfOrder();
		}

	}

	static Order addItem(Order order, Items item) {
		Order obj = new Order();
		obj = order;
		obj.addItem(item);
		return obj;
	}

	private static boolean orderIsEmpty(Order order) {
		Order test = new Order();
		if(test.equals(order)){
			return true;
		}
		return false;
	}
}
