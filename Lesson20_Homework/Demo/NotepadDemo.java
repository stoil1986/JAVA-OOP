package homework;

public class NotepadDemo {

	public static void main(String[] args){
				
		SimpleNotepad notepad = new SimpleNotepad(10);
		
		notepad.addPages( new Page("Title 1","some text 1"));
		notepad.addPages( new Page("Title 2","some text without digits"));
		notepad.addPages( new Page("Title 3","some text + apple"));
		notepad.addPages( new Page("Title 4","some text 55"));
		
	    notepad.searchWord("digits");
		notepad.printAllPagesWithDigits();			  		
		notepad.printAllPages();
		notepad.addTextToPage(3, "more text");		
		notepad.addNewTextRemoveOld(2, "new text");		
		notepad.deleteTextFromPage(4);
		notepad.printAllPages();		 
		
		SecuredNotepad securedpad = new SecuredNotepad(10,"da11D");		
		securedpad.addPages(new Page("Title 1","some text"));
		securedpad.addTextToPage(0, "33");
		securedpad.searchWord("some");
		
		ElectronicSecuredNotepad elpad = new ElectronicSecuredNotepad(13, "a234");
		elpad.start();
		elpad.addPages(new Page("Title 1","first text"));
		elpad.addPages(new Page("Title 2","second text"));
		elpad.addPages(new Page("Title 3","Play the"));
		elpad.addTextToPage(2, "game");
		elpad.deleteTextFromPage(0);
		elpad.printAllPages();
		
	}
}
