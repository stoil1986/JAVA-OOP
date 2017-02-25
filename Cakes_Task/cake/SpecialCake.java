package cake;

import java.util.Random;

import cake.KidsCake.KidsType;

public class SpecialCake extends Cake {

	public enum SpecialType implements IType {
		ANNIVERSARY, FIRM, ADVERTEISING
	}

	private SpecialType type;
	private String eventName;

	public SpecialCake(String name, String description, double price, int pieceCount, String eventName) {
		super(name, description, price, pieceCount, "Special");
		SpecialType[] types = SpecialType.values();
		this.type = types[new Random().nextInt(types.length)];
		if (eventName != null && !eventName.isEmpty()) {
			this.eventName = eventName;
		}
	}

	@Override
	public IType getType() {
		return this.type;
	}

	@Override
	public int compareTo(Cake cake) {
		SpecialCake other = (SpecialCake) cake;
		if (this.price - other.price > 0) {
			return 1;
		}
		if (this.price - other.price < 0) {
			return -1;
		}
		return 0;
	}
}
