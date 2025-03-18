package first;

public class BucketsOfWater {
	private int bucketsOfWater;
	public int showTotalWater() {
		return bucketsOfWater;
	}
	BucketsOfWater() {
		bucketsOfWater = 5;
	}
	public void addBucketsOfWater(int num) {
		bucketsOfWater = bucketsOfWater + num;
	}
	
	public void subtractBucketsOfWater(int num) {
		bucketsOfWater = bucketsOfWater - num;
	}
}
