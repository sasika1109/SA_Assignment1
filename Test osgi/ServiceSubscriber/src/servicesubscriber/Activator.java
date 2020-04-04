package servicesubscriber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import servicepublisher.ServicePublish;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;

	public void start(BundleContext context) throws Exception {
		System.out.println("start Subcriber Service");
		serviceReference = context.getServiceReference(ServicePublish.class.getName());
		ServicePublish servicePublish = (ServicePublish) context.getService(serviceReference);
		System.out.println(servicePublish.publishService());

		try {
			System.out.println("Enter a blank line to exit.");
			String foodName = "";
			String dessertName = "";
			int reply;
			int answer;
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			Scanner sc = new Scanner(System.in);

			while (true) {
				// Ask the user to enter a food.
				System.out.println("....................................................................... \n");
				System.out.print("Enter food name: ");
				foodName = in.readLine();

				if (foodName.length() == 0) {
					break;
				} else if (servicePublish == null) {
					System.out.println("No service avalable");
				} else if (servicePublish.checkAvailability(foodName)) {
					
					System.out.println("\n" + foodName.toUpperCase() + " is available. \n");
					System.out.println("Would you like to order?\n" + "1 : YES \n" + "2 : NO \n");
					System.out.println("Type 1 if YES or type 2 if NO : ");
					
					reply = sc.nextInt();
					answer = servicePublish.checkReply(reply, foodName);
					
					if (answer == 0) {
						System.out.println("Thanks you. Do you want anything else\n");
						System.out.println("1 : yes \n" + "2 : No \n");
						System.out.println("Choose one of them: ");
						reply = sc.nextInt();

						if (servicePublish.checkReply1(reply)) {

						} else {
							System.out.println("Thanks you. Good Bye! \n");
							break;
						}
					} else {
						System.out.println(foodName.toUpperCase() + " price is : " + "LKR " + answer + ".00");
						System.out.println("\nHow many would you like to order? ");
						reply = sc.nextInt();

						int bill = servicePublish.generateBill(reply, foodName);
						int billDessert = 0;

						System.out.println("Your total bill is : " + "LKR " + bill + ".00 \n");
						
						System.out.println("Would you like to add dessert to your order?\n" + "1 : YES \n" + "2 : NO \n");
						System.out.println("Type 1 if YES or type 2 if NO : ");
						
						reply = sc.nextInt();
						
						while(true) {
							if (servicePublish.checkReply1(reply)) {
								System.out.print("Enter dessert name: ");
								
								dessertName = in.readLine();
								
								if (dessertName.length() == 0) {
									break;
								}
								
								if (servicePublish.checkDessertAvailability(dessertName)) {
									System.out.println("\n" + dessertName.toUpperCase() + " is available. \n");
									System.out.println("How many would you like to order? ");
									reply = sc.nextInt();

									billDessert = servicePublish.generateBillDessert(reply, dessertName);
									System.out.println("\nYOUR BILLS: \n" 
											+ "For food : LKR " + bill + ".00 \n"
											+ "For dessert : LKR " + billDessert + ".00 \n");
									break;
								} else {
									System.out.println(dessertName.toUpperCase() + " is not a aviable right now");
								}
								
							} 
						}
						
						int totalBill = servicePublish.generatTotalBill(bill, billDessert);
						
						System.out.println("YOUR TOTAL BILL IS : " + totalBill + ".00" + "\n");
						System.out.println("Thank you for ordering food with us! Your food will be delivered in 45 minutes. \nGood Bye coming! \n\n\n");
						break;
					}
				} else {
					System.out.println(foodName.toUpperCase() + " is not a aviable right now");
				}
			}
		} catch (Exception ex) {
		}
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye!\n\n");
		context.ungetService(serviceReference);
	}

}
