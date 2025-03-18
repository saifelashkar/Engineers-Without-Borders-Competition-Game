package first;

public class Scraps {
	private int scraps;
	public int showTotalScrap() {
		return scraps;
	}
	Scraps() {
		scraps = 20;
	}
	public void addScraps(int num) {
		scraps = scraps + num;
	}
	
	public void subtractScraps(int num) {
		scraps = scraps - num;
	}
	

}
