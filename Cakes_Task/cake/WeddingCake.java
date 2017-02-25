package cake;

import java.util.Random;

import cake.Cake.IType;
import cake.StandartCake.StandartType;

public class WeddingCake extends Cake {

	public enum WeddingType implements IType {
		BIG, SMALL, AVERAGE
	}

	private WeddingType type;
	private int levelInfo;

	public WeddingCake(String name, String description, double price, int pieceCount, int levelInfo) {
		super(name, description, price, pieceCount, "Wedding");
		WeddingType[] types = WeddingType.values();
		this.type = types[new Random().nextInt(types.length)];	
		if (levelInfo > 0) {
			this.levelInfo = levelInfo;
		}
	}

	@Override
	public IType getType() {
		return this.type;
	}

	@Override
	public int compareTo(Cake cake) {
		WeddingCake other = (WeddingCake) cake;
		return this.pieceCount - cake.pieceCount;
	}
}
