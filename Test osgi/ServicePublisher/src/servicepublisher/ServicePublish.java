package servicepublisher;

public interface ServicePublish {
	
	public String publishService();
	
	public boolean checkAvailability(String foodName);
	

	public int checkReply(int reply , String name);
	
	public boolean checkReply1(int reply);
	
	public int generateBill(int count , String food);

}
