import java.util.ArrayList;

/**
 * Game class represent a game.
 * @author s3630040 hanwei Li
 *
 */
public class Game {
	private String id;
	private int athleteNum;
	private ArrayList<People> athletes;
	private String type;
	private String pred;
	
	/**
	 * Construct
	 * @param id
	 * @param type
	 */
	public Game(String id, String type){
		athletes = new ArrayList<>();
		this.id = id;
		athleteNum = 0;
		this.type = type;
	}
	
	/**
	 * add an athlete to the game.
	 * @param athlete
	 */
	public void addAthlete(People athlete){
		this.athletes.add(athlete);
		athleteNum = this.athletes.size();
	}
	
	/**
	 * toString method
	 */
	public String toString(){
		String ret = "Game " + id + "\n" + "Type: "+ type +"\n";
		for(People athlete : athletes){
			ret += athlete.toString() + "\n";
		}
		return ret;
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
	 * @return the athleteNum
	 */
	public int getAthleteNum() {
		return athleteNum;
	}

	/**
	 * @param athleteNum the athleteNum to set
	 */
	public void setAthleteNum(int athleteNum) {
		this.athleteNum = athleteNum;
	}

	/**
	 * @return the athletes
	 */
	public ArrayList<People> getAthletes() {
		return athletes;
	}

	/**
	 * @param athletes the athletes to set
	 */
	public void setAthletes(ArrayList<People> athletes) {
		this.athletes = athletes;
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
	 * @return the pred
	 */
	public String getPred() {
		return pred;
	}

	/**
	 * @param pred the pred to set
	 */
	public void setPred(String pred) {
		this.pred = pred;
	}

	
	
	
}
