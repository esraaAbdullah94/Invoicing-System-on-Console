package shopPackege;

import java.io.BufferedWriter;

import java.io.FileWriter;

import java.io.IOException;

import java.util.Scanner;

public class GroceriesShop {

	public static void main(String[] args) {

		Menu menu = new Menu();
		menu.show("settings");
		
		ManageShopItems manageShopItems = new ManageShopItems();
		manageShopItems.displayMenu();
		
		
		

	

	}

}