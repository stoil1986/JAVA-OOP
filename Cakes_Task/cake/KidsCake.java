package cake;

import java.util.Random;

public class KidsCake extends Cake {

	public enum KidsType implements IType {
		BIRTDAY, CHRISTENING
	}

	private KidsType type;
	private String kidName;

	public KidsCake(String name, String description, double price, int pieceCount, String kidName) {
		super(name, description, price, pieceCount, "Kids");
		KidsType[] types = KidsType.values();
		this.type = types[new Random().nextInt(types.length)];
		if (kidName != null && !kidName.isEmpty()) {
			this.kidName = kidName;
		}
	}

	@Override
	public IType getType() {
		return this.type;
	}

	@Override
	public int compareTo(Cake cake) {
		KidsCake other = (KidsCake) cake;
		return this.pieceCount - cake.pieceCount;
	}

}