package cake;

import java.util.Random;

import cake.SpecialCake.SpecialType;

public class StandartCake extends Cake {

	public enum StandartType implements IType {
		BISCUIT, FRUIT, CHOCOLADE
	}

	private StandartType type;
	private boolean hasSyrup;

	public StandartCake(String name, String description, double price, int pieceCount) {

		super(name, description, price, pieceCount, "Standart");
		StandartType[] types = StandartType.values();
		this.type = types[new Random().nextInt(types.length)];		 
		if (new Random().nextBoolean()) {
			this.hasSyrup = true;
		} else{
			this.hasSyrup = false;
		}
	}

	@Override
	public IType getType() {
		return this.type;
	}

	@Override
	public int compareTo(Cake cake) {
		StandartCake other = (StandartCake) cake;
		if (this.price - other.price > 0) {
			return 1;
		}
		if (this.price - other.price < 0) {
			return -1;
		}
		return 0;
	}

}
