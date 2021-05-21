package week2;

public class MyTemperature implements Temperature{
	private double celsius;
	private char scale;

	public MyTemperature(double value, char scale) {
		if (scale == 'C') {
			setCelsius(value);
			setScale('C');
		}
		else {
			setFahrenheit(value);
			setScale('F');
		}
	}

	public double getCelsius() {
		return celsius;
	}

	public double getFahrenheit() {
		return 9 * celsius / 5 + 32.0;
	}

	public void setCelsius(double celsius) {
		this.celsius = celsius;
	}

	public void setFahrenheit(double fahrenheit) {
		this.celsius = 5 * (fahrenheit - 32) / 9;
	}

	public String toString() {
		if(getScale() == 'C')
			return round(getFahrenheit())+ "";
		else
			return round(getCelsius()) + "";
	}

	private double round(double x) {
		return Math.round(100 * x) / 100.0;
	}

	public char getScale() {
		return scale;
	}

	public void setScale(char scale) {
		this.scale = scale;
	}
}
