
/**
 * Official
 * @author s3647462 Jingjing Tan
 *
 */
public class Official extends People{

	private Game game;
	
	public Official(String id, String name, Game game) {
		super(id, name, 0, "", "official", 0);
		// TODO Auto-generated constructor stub
		this.game = game;
	}

	/**
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * @param game the game to set
	 */
	public void setGame(Game game) {
		this.game = game;
	}
	
	
}
