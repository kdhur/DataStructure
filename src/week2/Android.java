package week2;

public class Android extends Students{
	private String model, serial;

	public Android(String name, String model, String serial) {
		super(name);
		setModel(model);
		setSerial(serial);
	}

	@Override
	public int compare(Object o) {
		if(this.model.compareTo(((Android)o).model) == 0)
			return this.serial.compareTo(((Android)o).getSerial());	

		else
			return this.model.compareTo(((Android)o).getModel());
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}
}
