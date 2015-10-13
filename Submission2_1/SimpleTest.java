
public class SimpleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double m = 432.5676;
		String poundSign = java.util.Currency.getInstance("GBP").getSymbol(java.util.Locale.UK);
		String mForm = String.format("%.2f", m);
		System.out.println(poundSign + mForm);
		
		double limit = 500.0;
		double bal = 344.86;
		int accNum = 5;
		String name = "Hello";
		
		String limitF = String.format("%.2f", limit);
		String balF = String.format("%.2f",bal);
		
		
		System.out.println("Account Holder: "+name+" "
				+"Account Number: "+accNum+" "
				+"Credit Limit: "+poundSign+limitF+" "
				+"Balance: "+poundSign+balF+"");
	}

}
