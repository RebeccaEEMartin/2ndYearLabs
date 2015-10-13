public class CreditCard {
    
    // instance fields (specific attributes of objects)
    private int cardNumber;				//number associated with card/account
    private String cardHolder;			//name of the person associated with card/account
    private double currentBalance;		//holds the current balance of the account (to be paid)
    private double creditLimit;			//holds the credit limit of the account (balance cannot exceed this)

    
    // static fields (attributes of class, i.e. not specific to an object)
    static int nextCardNumber = 0;

    
    // accessor methods - gives other objects access to private fields
    public int getCardNumber() {
        return this.cardNumber;
    }
    public String getCardHolder(){
    	return this.cardHolder;
    }
    public double getCurrentBalance(){
    	return this.currentBalance;
    }
    public double getCreditLimit(){
    	return this.creditLimit;
    }
    
    
    //setter methods - set the field values
    public void setCardHolder(String accountHolder){
    	this.cardHolder = accountHolder;
    }
    
    public boolean setCreditLimit(double creditLimit){
    	//return true if the credit limit is okay,
    	//i.e. non-negative & greater than or equal to the current balance,
    	//should also change credit limit
    	//else return false
    	if (creditLimit>0 && creditLimit>=this.currentBalance){
    		this.creditLimit = creditLimit;
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    
    // constructors - used to initialise objects & their instance fields
    public CreditCard(){
    	//initialises field values to their default values in the case
    	//no values have been specified for them
    	this.currentBalance = 0.0;
    	this.creditLimit = 500.0;
    	
    	//gives each new object a unique number by adding one to the account number of
    	//the last defined credit card object
    	this.cardNumber = CreditCard.nextCardNumber++;
    }
    
    public CreditCard(String accountHolder, double creditLimit){
    	//initialise variable values
    	this.cardHolder = accountHolder;
    	this.creditLimit = creditLimit;
    	this.currentBalance = 0.0;
    	this.cardNumber = CreditCard.nextCardNumber++;
    }
    
    
    // other methods
    
    //charge an amount to the credit card (i.e. add it to the balance)
    public boolean charge(double amount){
    	//if charge successful (balance + charge <= limit)
    	//return true & update balance, else return false
    	if (this.currentBalance + amount <= this.creditLimit && amount >0){
    		this.currentBalance = this.currentBalance + amount;
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    //pay an amount to the credit card (i.e. deduct it from the balance)
    public boolean makePayment(double amount){
    	//if payment successful (amount>0 and amount<=balance)
    	//return true and update balance, else return false
    	if (amount>0 && amount<=this.currentBalance){
    		this.currentBalance = this.currentBalance - amount;
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    
    //override methods
    
    //returns string with all of the card details formatted
    public String toString(){
    	//get correct java GBP sign:
    	String poundSign = java.util.Currency.getInstance("GBP").getSymbol(java.util.Locale.UK);
    	
    	//format creditLimit and currentBalance to be of the format "---.--"
    	//i.e. 456.9700000 --> 456.97
    	String credLim = String.format("%.2f", this.creditLimit);
    	String currBal = String.format("%.2f", this.currentBalance);
    	
    	//concatenate & return all of the information
    	return "Account Holder: "+this.cardHolder+" , "
    			+"Acoount Number: "+this.cardNumber+" , "
    			+"Limit: "+poundSign+credLim+" , "
    			+"Balance: "+poundSign+currBal+" .";
    }
    
    //checks if two accounts are the same
    public boolean equals(int accountNumber){
    	//two accounts are the same if and only if the account numbers (cardNumbers)
    	//are equal. If so return true, else return false
    	if (accountNumber == this.cardNumber){
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
}
