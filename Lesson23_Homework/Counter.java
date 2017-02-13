package homework_Lesson22;

public class Counter implements Comparable<Counter> {

	private int counter;
	private char letter;

	public Counter(int counter, char letter) {
		if (counter > 0) {
			this.counter = counter;
		}
		if (letter != ' ') {
			this.letter = letter;
		}		 
	}

	public char getLetter() {
		return letter;
	}

	public int getCounter() {
		return counter;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + counter;
		result = prime * result + letter;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Counter other = (Counter) obj;
		if (counter != other.counter)
			return false;
		if (letter != other.letter)
			return false;
		return true;
	}

	@Override
	public int compareTo(Counter o) {

		if (this.counter == o.counter) {			
			return (this.letter - o.letter);
		}
		return (this.counter - o.counter) * -1;
	}

	public String printSymbol(int maxCounter) {
		
		StringBuilder sb = new StringBuilder();
		int symbolsForAppend = (int)Math.round(20.0/maxCounter);
		
		for (int i = 0; i < this.counter*symbolsForAppend; i++) {			
			sb.append("#");						 
		}
		return sb.toString();  
	}
}
