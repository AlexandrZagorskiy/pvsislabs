package labwork2.model;

public class Works {
	int worksMax;
	int worksMade;
	
	public Works (int worksMax, int worksMade) {
		this.worksMax = worksMax;
		this.worksMade = worksMade;
	}

	public int getWorksMax() {
		return worksMax;
	}

	public void setWorksMax(int worksMax) {
		this.worksMax = worksMax;
	}

	public int getWorksMade() {
		return worksMade;
	}

	public void setWorksMade(int worksMade) {
		this.worksMade = worksMade;
	}
}
