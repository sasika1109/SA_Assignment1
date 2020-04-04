package servicepublisher;

public interface ServicePublish {

	public String publishService();

	public boolean checkAvailability(String foodName);
	
	public boolean checkDessertAvailability(String dessertName);

	public int checkReply(int reply, String name);

	public boolean checkReply1(int reply);

	public int generateBill(int count, String food);
	
	public int generateBillDessert(int count, String dessert);
	
	public int generatTotalBill (int foodBill, int dessertBill);

}
