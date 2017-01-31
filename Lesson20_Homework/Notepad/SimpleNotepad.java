package homework;

public class SimpleNotepad implements INotepad {

	private Page[] pages;
	private int pageNumber;
	private int maxNumberOfPages;
			
	public SimpleNotepad(int maxNumberOfPages) {
		if (maxNumberOfPages > 0) {
			this.maxNumberOfPages = maxNumberOfPages;
		}
		this.pages = new Page[this.maxNumberOfPages];
		this.pageNumber = 0;
	}
		
	public void addPages(Page page){
		if (this.pageNumber < pages.length) {
			this.pages[pageNumber++] = page;
			System.out.println("Page added!");
		}		
	}
	
	public Page[] getPages() {
		return pages;
	}
	
	@Override
	public void addTextToPage(int pageNum, String text) {
		if (this.pages[pageNum] != null && pageNum > 0 && pageNum < this.pages.length) {
			this.pages[pageNum].addText(text);
		}		
	}
	 
	@Override
	public void addNewTextRemoveOld(int pageNum, String text) {
		if (this.pages[pageNum] != null && pageNum > 0 && pageNum < this.pages.length) {
			this.pages[pageNum].deleteText();
			this.pages[pageNum].addText(text);
		}		
	}

	@Override
	public void deleteTextFromPage(int pageNum) {
		if (this.pages[pageNum] != null && pageNum >= 0 && pageNum < this.pages.length) {
			this.pages[pageNum].deleteText();			
		}		
	}

	@Override
	public void printAllPages() {		
		for (int i = 0; i < pages.length; i++) {
			if (this.pages[i] != null) {
				this.pages[i].printPage();
			}			 
		}	
		System.out.println();
	}

	@Override
	public boolean searchWord(String word) {
		for (int i = 0; i < pages.length; i++) {
			if (this.pages[i] != null) {
				if(this.pages[i].searchWord(word)){
					System.out.println("Word found!");
					return true;
				}
			}			 
		}
		return false;
	}

	@Override
	public void printAllPagesWithDigits() {
		for (int i = 0; i < pages.length; i++) {
			if (this.pages[i] != null && this.pages[i].containsDigits()) {
				this.pages[i].printPage();
			}			 
		}	
		System.out.println();		
	}	
}
