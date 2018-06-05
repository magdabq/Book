package se.lexicon.model;

public class Member {
	
	private Long memberId;
	private String firstName;
	private String lastName;
	private String email;
	private Loan loan;
	
	public Member () {
		
	}
	
	public Member(String firstName, String lastName, String email, Loan loan) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		
	}
	

}
