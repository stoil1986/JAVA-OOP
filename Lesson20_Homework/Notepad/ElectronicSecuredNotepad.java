package homework;

public class ElectronicSecuredNotepad extends SecuredNotepad implements IЕlectronicDevice {

	private boolean isTurnedOn;
	
	public ElectronicSecuredNotepad(int maxNumberOfPages,String password) {
		super(maxNumberOfPages,password);
		this.isTurnedOn = false;
	}

	@Override
	public void start() {
		this.isTurnedOn = true;		
	}

	@Override
	public void stop() {
		this.isTurnedOn = false;
		
	}

	@Override
	public boolean isStarted() {
		return this.isTurnedOn;
	}

	@Override
	public void addPages(Page page) {
		if (isTurnedOn) {
			super.addPages(page);
		}else{
			System.out.println("Device is not switched on!");
		}		
	}
	
	@Override
	public void addTextToPage(int pageNum, String text) {
		if (isTurnedOn) {
			super.addTextToPage(pageNum, text);
		}else{
			System.out.println("Device is not switched on!");
		}                       		 
	}

	@Override
	public void addNewTextRemoveOld(int pageNum, String text) {
		if (isTurnedOn) {
			super.addNewTextRemoveOld(pageNum, text);
		}else{
			System.out.println("Device is not switched on!");
		}		 
	}

	@Override
	public void deleteTextFromPage(int pageNum) {
		if (isTurnedOn) {
			super.deleteTextFromPage(pageNum);
		}else{
			System.out.println("Device is not switched on!");
		}		 
	}

	@Override
	public void printAllPages() {
		if (isTurnedOn) {
			super.printAllPages();
		}else{
			System.out.println("Device is not switched on!");
		}		
	}

	@Override
	public boolean searchWord(String word) {
		if (isTurnedOn) {
			return super.searchWord(word);
		}else{
			System.out.println("Device is not switched on!");
			return false;
		}		 
	}

	@Override
	public void printAllPagesWithDigits() {
		if (isTurnedOn) {
			super.printAllPagesWithDigits();
		}else{
			System.out.println("Device is not switched on!");			
		}		
	}	
	
}
