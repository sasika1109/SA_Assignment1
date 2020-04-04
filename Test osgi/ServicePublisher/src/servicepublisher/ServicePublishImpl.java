package servicepublisher;

public class ServicePublishImpl implements ServicePublish {

	String[] Stock = { "koththu", "rice", "parata", "hoppers", "string hoppers" };
	String[] Dessert = { "ice cream", "pudding", "watalappan" };

	@Override
	public String publishService() {
		return "Execute the publish service of SericePublisher";
	}

	// check availability of food
	public boolean checkAvailability(String foodName) {

		foodName = foodName.toLowerCase();

		for (int i = 0; i < Stock.length; i++) {
			if (Stock[i].equals(foodName)) {
				return true;
			}
		}

		return false;
	}
	
	public boolean checkDessertAvailability(String dessertName) {
		dessertName = dessertName.toLowerCase();

		for (int i = 0; i < Dessert.length; i++) {
			if (Dessert[i].equals(dessertName)) {
				return true;
			}
		}
		
		return false;

	}

	// set price for each product
	public int checkReply(int reply, String food) {

		if (reply == 1 && food.equals("koththu")) {
			int price = 250;
			return price;
		} else if (reply == 1 && food.equals("rice")) {
			int price = 180;
			return price;
		} else if (reply == 1 && food.equals("parata")) {
			int price = 60;
			return price;
		} else if (reply == 1 && food.equals("hoppers")) {
			int price = 25;
			return price;
		} else if (reply == 1 && food.equals("string hoppers")) {
			int price = 10;
			return price;
		} else {
			return 0;
		}
	}

	// check reply if yes or no and return true or false accordingly
	public boolean checkReply1(int reply) {
		if (reply == 1) {
			return true;
		} else {
			return false;
		}
	}

	// generate bill food
	public int generateBill(int count, String food) {

		if (food.equals("koththu")) {
			int total = 250 * count;
			return total;
		} else if (food.equals("rice")) {
			int total = 180 * count;
			return total;
		} else if (food.equals("parata")) {
			int total = 60 * count;
			return total;
		} else if (food.equals("hoppers")) {
			int total = 25 * count;
			return total;
		} else if (food.equals("string hoppers")) {
			int total = 10 * count;
			return total;
		} else {
			return 0;
		}
	}
	
	// generate bill for dessert
	public int generateBillDessert(int count, String dessert) {

		if (dessert.equals("ice cream")) {
			int total = 150 * count;
			return total;
		} else if (dessert.equals("pudding")) {
			int total = 80 * count;
			return total;
		} else if (dessert.equals("watalappan")) {
			int total = 60 * count;
			return total;
		} else {
			return 0;
		}
	}
	
	// generate total bill
	public int generatTotalBill (int foodBill, int dessertBill) {
		return (foodBill + dessertBill);
	}

}
