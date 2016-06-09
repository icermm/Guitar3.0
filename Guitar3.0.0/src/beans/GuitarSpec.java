package beans;

public class GuitarSpec {

	private String builder;           //Allen,Rosen,Sayan,LANGSHENG
	private String model;             //M40
	private String type;              //ClassicalG,FlamencoG,PickG,FolkG,ElectricG
	private String topWood;              //spruce,cedar,Sitka,Engelmann
	private String backWood;
	
	public GuitarSpec(String builder, String model, String type, String topWood, String backWood) {
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.topWood = topWood;
		this.backWood = backWood;
	}

	public void setBuilder(String builder) {
		this.builder = builder;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setTopWood(String topWood) {
		this.topWood = topWood;
	}
	
	public void setBackWood(String backWood) {
		this.backWood = backWood;
	}
	
	public String getBuilder() {
		return builder;
	}

	public String getModel() {
		return model;
	}

	public String getType() {
		return type;
	}

	public String getTopWood() {
		return topWood;
	}

	public String getBackWood() {
		return backWood;
	}
	
	//²éÕÒ¼ªËû
	public boolean matches(GuitarSpec otherSpec) {

		if (!builder.equals(otherSpec.builder)&&!otherSpec.builder.equals(""))
			return false;
		
		if (!model.equals(otherSpec.model)&&!otherSpec.model.equals(""))
			return false;

		if (!type.equals(otherSpec.type)&&!otherSpec.type.equals(""))
			return false;

		if (!topWood.equals(otherSpec.topWood)&&!otherSpec.topWood.equals(""))
			return false;
		
		if (!backWood.equals(otherSpec.backWood)&&!otherSpec.backWood.equals(""))
			return false;
		
		System.out.println("equal");
		return true;
	}
}