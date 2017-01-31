package homework;

import java.util.Scanner;

public class SecuredNotepad extends SimpleNotepad {

	private String password;

	public String getPassword() {
		return password;
	}
	public SecuredNotepad(int maxNumberOfPages, String password) {
		 
		super(maxNumberOfPages);
		while(true){
						 
			if (checkForStrongPassword(password)) {
				this.password = password;
				System.out.println("Password accepted");
				break;
			}else{			
				System.out.println("This password is not strong! Try again");
				Scanner sc = new Scanner(System.in);
				password = sc.nextLine();
			}
		}
		 		 
	}
	public boolean checkForStrongPassword(String password) {
		boolean hasLowerLetter = false;
		boolean hasUpperLetter = false;
		boolean hasDigit = false;
		if (password.length() >= 5) {
			for (int i = 0; i < password.length(); i++) {
				if (Character.isLowerCase(password.charAt(i))) {
					hasLowerLetter = true;
				}
				if (Character.isUpperCase(password.charAt(i))) {
					hasUpperLetter = true;
				}
				if (Character.isDigit(password.charAt(i))) {
					hasDigit = true;
				}
				if (hasLowerLetter && hasUpperLetter && hasDigit) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean validatePassword(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter password!");
		String newPass = sc.nextLine();
		return newPass.equals(this.password);
	}
	
	@Override
	public void addPages(Page page) {
		if (validatePassword()){
			super.addPages(page);			
		}else{
			System.out.println("Incorrect password!");
		}		
	}
	
	@Override
	public void addTextToPage(int pageNum, String text) {
		if (validatePassword()){
			super.addTextToPage(pageNum, text);
			System.out.println("Correct password, text added!");
		}else{
			System.out.println("Incorrect password!");
		}				
	}
	
	@Override
	public void addNewTextRemoveOld(int pageNum, String text) {
		if (validatePassword()){
			super.addNewTextRemoveOld(pageNum, text);
			System.out.println("Correct password,old text removed, new text added!");
		}else{
			System.out.println("Incorrect password!");
		}		 
	}
	
	@Override
	public void deleteTextFromPage(int pageNum) {
		if (validatePassword()){
			super.deleteTextFromPage(pageNum);
			System.out.println("Correct password, text deleted!");
		}else{
			System.out.println("Incorrect password!");
		}		 
	}
	
	@Override
	public void printAllPages() {
		if (validatePassword()){
			System.out.println("Correct password!");
			super.printAllPages();			 
		}else{
			System.out.println("Incorrect password!");
		}		 
	}
	@Override
	public boolean searchWord(String word) {
		if (validatePassword()){
			System.out.println("Correct password!");
			return super.searchWord(word);			
		}else{
			System.out.println("Incorrect password!");
			return false;
		}		 
	}
	
	@Override
	public void printAllPagesWithDigits() {
		if (validatePassword()){
			System.out.println("Correct password!");
			super.printAllPagesWithDigits();			 
		}else{
			System.out.println("Incorrect password!");
		}		 
	}
}
