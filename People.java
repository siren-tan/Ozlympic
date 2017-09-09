import java.util.Random;

/**
 * Athlete class represent a athlete.
 * @author s3647462 Jingjing Tan
 *
 */
public abstract class People {
	private String id;
	private String name;
	private int age;
	private String state;
	private String type;
	private int point;
	private double time;
	
	/**
	 * To string method.
	 */
	public String toString(){
		return "ID: " + id + "\tName: " + name + "\tType: " + type; 
	}
	
	/**
	 * Constructor
	 * @param id
	 * @param name
	 * @param age
	 * @param state
	 * @param type
	 * @param point
	 */
	public People(String id, String name, int age, String state, String type, int point){
		this.id = id;
		this.name = name;
		this.age = age;
		this.state = state;
		this.type = type;
		this.point = point;
	}
	
	/**
	 * Generate a random time according type.
	 * @param type
	 * 
	 */
	public void compete(int type){
		Random random = new Random();
		double ret = 0;
		switch (type) {
		case 0:
			ret = 10*random.nextDouble()+10;
			break;
		case 1:
			ret = 100*random.nextDouble()+100;
			break;
		case 2:
			ret = 300*random.nextDouble()+500;
			break;
		default:
			break;
		}
		time = ret;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the point
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * @param point the point to set
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	/**
	 * @return the time
	 */
	public double getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(double time) {
		this.time = time;
	}
	
	
}
