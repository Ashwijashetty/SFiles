package com.capgemini.takehome.ui;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.takehome.bean.ProductBean;
import com.capgemini.takehome.exceptions.BSAException;
import com.capgemini.takehome.service.IProductService;
import com.capgemini.takehome.service.ProductService;

public class Client {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws BSAException {

		IProductService service = new ProductService(); 
		System.out.println("Welcome to Capgemini TakeHome\n");
		System.out.println("**MENU**\n");
		System.out
				.println("1) Generate Bill by entering Product code and quantity\n");
		System.out.println("2) Exit");
		int option = 0;
		try {
			option = scanner.nextInt();
		} catch (InputMismatchException e) {

			System.err.println("Enter only (1 - 2) digits");

		}
		switch (option) {
		case 1:
			System.out.println("\nEnter the product code: ");
			int productCode = 0;
			try {
				productCode = scanner.nextInt();
			} catch (InputMismatchException e) {

				System.err.println("Enter only digits");

			}
			boolean flag = service.isValidproductCode(productCode);//Validation Check
			//&&((productCode <= 1004) && (productCode >= 1001))
			if (flag ) {
				System.out.println("\nEnter the quantity: ");
				int quantity = 0;
				try {
					quantity = scanner.nextInt();
				} catch (InputMismatchException e) {
					System.err.println("Enter only digits");

				}
				if (quantity >= 1) {
					List<ProductBean> list = service
							.getProductDetails(productCode);
					for (ProductBean product : list) {
						System.out.println("The details are "
								+ "\nProduct Name : "
								+ product.getProductName()
								+ "\nProduct Category : "
								+ product.getProductCategory()
								+ "\nProduct Description : " + ""
								+ product.getProductDescription()
								+ "\nProduct Price : "
								+ product.getProductPrice() + "\nQuantity : "
								+ quantity + "\nLine Total (Rs) :"
								+ (quantity * product.getProductPrice()));
					}
				} else {
					System.out.println("Quantity cannot be less than 0\n");
				}

			} else {
				System.out
						.println("Sorry!The ProductCode "+productCode+" is not available in DataBase\n");
			}

			break;
		case 2:
			System.out.println("** Succesfully Exited **");
			System.exit(0);
			break;
		default:
			System.out.println("Option which doesn't exist is chosen");
			break;
		}

	}
}
