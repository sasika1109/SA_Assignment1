package servicepublisher;

public class ServicePublishImpl implements ServicePublish{

<<<<<<< HEAD
	String[] Stock = { "koththu", "rice", "parata", "hoppers", "string hoppers" };
=======
	 String[] Stock =
         { "koththu", "rice", "parata", "hoppers", "string hoppers" };
>>>>>>> 14e9ba2ce6b25c72fd3560b46c0fe015e1be53cc
	 
	@Override
	public String publishService() {
		return "Execute the publish service of SericePublisher";
	}

	
	public boolean checkAvailability(String foodName) {
		
		foodName = foodName.toLowerCase();
			// This is very inefficient
			for (int i = 0; i < Stock.length; i++) {
	                if (Stock[i].equals(foodName)) {
	                    return true;
	                }
	            }
		return false;
	}
	
	public int  checkReply(int reply , String food) {
		
		if (reply == 1 && food.equals("koththu")) {
			int price = 250;
			return price;
		} else if(reply == 1 && food.equals("rice")) {
			int price = 180;
			return price;
		} else if(reply == 1 && food.equals("parata")) {
			int price = 60;
			return price;
<<<<<<< HEAD
		} else {
=======
		}
		else if(reply == 1 && food.equals("hoppers")) {
			int price = 25;
			return price;
		}
		else if(reply == 1 && food.equals("string hoppers")) {
			int price = 10;
			return price;
		}
		else {
>>>>>>> 14e9ba2ce6b25c72fd3560b46c0fe015e1be53cc
			return 0;
		}
	}
	
	public boolean checkReply1(int reply) {
		if(reply == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public int generateBill(int count , String food) {
		
		if(food.equals("koththu")) {
			int total = 250 * count;
			return total;
		} else if(food.equals("rice")) {
			int total = 180 * count;
			return total;
		} else if(food.equals("parata")) {
			int total = 60 * count;
			return total;
<<<<<<< HEAD
		} else {
=======
		}
		else if(food.equals("hoppers"))
		{
			int total = 25 * count;
			return total;
		}
		else if(food.equals("string hoppers"))
		{
			int total = 10 * count;
			return total;
		}
		else {
>>>>>>> 14e9ba2ce6b25c72fd3560b46c0fe015e1be53cc
			return 0;
		}
	}

}
