package cake;

public abstract class Cake implements Comparable<Cake>{
	
	public interface IType{};
	
	private String name;
	private String description;
	protected double price;
	protected int pieceCount;
	private String kind;
	
	public Cake(String name, String description, double price, int pieceCount, String kind) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		} 
		if (description != null && !description.isEmpty()) {
			this.name = description;
		}
		if (price > 0) {
			this.price = price;
		}
		if (pieceCount > 0) {
			this.pieceCount = pieceCount;
		}
		if (kind != null && !kind.isEmpty()) {
			this.kind = kind;
		}
	}

	public String getKind() {
		return kind;
	}

	public double getPrice() {
		return price;
	}

	public int getPieceCount() {
		return pieceCount;
	}

	public abstract IType getType();
		
}