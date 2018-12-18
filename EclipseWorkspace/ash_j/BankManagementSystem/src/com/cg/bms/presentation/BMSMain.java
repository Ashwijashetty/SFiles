package com.cg.bms.presentation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.bms.model.Account;
import com.cg.bms.model.exceptions.BMSException;
import com.cg.bms.service.AccountServiceImpl;
import com.cg.bms.service.IAccountService;

public class BMSMain {
	static Logger logger = Logger.getLogger(BMSMain.class);
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		PropertyConfigurator.configure("resources/log4j.properties");

		logger.info("log4j configured");
		IAccountService service = new AccountServiceImpl();

		System.out.println("**************************");
		System.out.println("         WELCOME");
		System.out.println("**************************");
		System.out
				.println("Enter your choice\n1.Create Account\n2.Get Account Info\n3.Display all Accounts\n4.Exit\t");

		int option = 0;
		try {
			option = scanner.nextInt();
			logger.info("Selected option is : " + option);
		} catch (InputMismatchException e) {
			System.err.println("Enter only (1 - 4) digits");
			logger.error("User entered invalid option");

			System.exit(0);
		}
		switch (option) {

		case 1:
			Account account = openAccount();
			logger.debug("Data in Accont class is : " + account);

			try {
				boolean result = service.validateAccount(account);
				logger.debug("Validation of account is " + result);

				if (result) {
					boolean resultflag = service.createAccount(account);
					if (resultflag) {
						int id=service.getMaxId();
						System.out.println("Account created with id"+id);
					} else {
						System.out.println("Account not created");
					}
				}

			} catch (BMSException e) {
				System.err.println(e.getMessage());
			}

			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		default:
			System.out.println("Invalid option chosen");
			logger.info("Invalid number is chosen");
			break;
		}

	}

	public static Account openAccount() {
		scanner.nextLine();
		System.out.println("Enter account type to create: ");
		String accountType = scanner.nextLine();
		System.out.println("Customer name");
		String customerName = scanner.nextLine();
		System.out.println("Enter minimum deposit Amount");
		double amount = 0;
		try {
			amount = scanner.nextDouble();
		} catch (InputMismatchException e) {
			System.err.println("Incorrect amount ");
			logger.error("Entered amount isn't correct ");
			System.exit(0);
		}
		Date date = new Date();
		System.out.println("date:"+date);
		/*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String newdate = format.format(date);
		try {
			Date date3 = format.parse(newdate);
		} catch (ParseException e) {

		}*/
		Account account = new Account(accountType, customerName, amount, date);
		logger.info("Account object created" + account);
		return account;

	}
}
