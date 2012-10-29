public class Bill {
	private String concept;
	private int amount;
	private Bill next;
	
	public Bill(String concept, int amount) {
		this.concept = concept;
		this.amount = amount;
		this.next = null;
	}
	
	public String getConcept() {
		return concept;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setNextBill(Bill bill) {
		next = bill;
	}
	
	public Bill getNextBill() {
		return next;
	}
}