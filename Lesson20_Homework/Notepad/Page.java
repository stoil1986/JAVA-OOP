package homework;

public class Page {
	
	private String title;
	private String text;
				
	public Page(String title, String text) {
		if (title != null && !title.isEmpty()) {
			this.title = title;
		}
		if (text != null && !text.isEmpty()) {
			this.text = text;
		} 		 
	}

	public void addText(String text){
		this.text += " " + text;
	}
	    
	public void deleteText(){
		this.text = "";
	}
    
    public void printPage(){
    	System.out.println("Title = " + title + "\nText = " + text);
    }
    
    public boolean searchWord(String word){
    	
    	return this.text.contains(word);
    }
    
    public boolean containsDigits(){
    	    
    	for (int i = 0; i < this.text.length(); i++) {
			if (Character.isDigit(this.text.charAt(i))) {
				return true;
			}
		}
    	return false;
    }
}
