package homework;

    public interface INotepad {
		
	public void addTextToPage(int pageNumber, String text);
	
	public void addNewTextRemoveOld(int pageNumber, String text);
	
	public void deleteTextFromPage(int pageNumber);
	
	public void printAllPages();
	
	public boolean searchWord(String word);
	
	public void printAllPagesWithDigits();
}
