package week2;

public class Human extends Students {
	private int snumber;
	
	public Human(String name, int snumber) {
		super(name);
		setSnumber(snumber);
	}
	
	@Override
	public int compare(Object o) {
		if (this.snumber > ((Human) o).getSnumber())
			return 1;
		else if(this.snumber < ((Human) o).getSnumber())
			return -1;
		return 0;
	}

	public int getSnumber() {
		return snumber;
	}

	public void setSnumber(int snumber) {
		this.snumber = snumber;
	}
}
