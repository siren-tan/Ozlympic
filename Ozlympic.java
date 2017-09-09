import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

/**
 * Ozlympic class represent all game.
 * @author s3630040 hanwei Li
 *
 */
public class Ozlympic {
	ArrayList<Game> games;
	ArrayList<People> athletes;
	ArrayList<Official> officials;
	
	/**
	 * Construct prepare data for test.
	 */
	public Ozlympic(){
		games = new ArrayList<>();
		officials = new ArrayList<>();
		Random random = new Random();
		int num = 0;
		String gameNames[] = {"S01", "C02", "R03", "C04", "R05"};
		String names[] = {"Alice", "Bob", "CC", "David", "Egma", "Fred", "Green", "High", "Ivern", 
				"Jack", "Kray", "LBJ", "Mike", "Nick", "Olim", "Peter", "Queen", "Root", "Steven", "Tim",
				"Unix", "Vim", "West", "Xing"};
		String states[] = {"AK", "VIC", "BK","AK", "VIC", "BK","AK", "VIC", "BK","VIC",
				"AK", "VIC", "BK","AK", "VIC", "BK","AK", "VIC", "BK","VIC","AK", "VIC", "BK","VIC"};
		String types[] = {"swimmers", "cyclists", "sprinters","swimmers", "cyclists", "sprinters","swimmers", "cyclists", "sprinters","superAthletes",
				"swimmers", "cyclists", "sprinters","swimmers", "cyclists", "sprinters","swimmers", "cyclists", "sprinters","superAthletes","swimmers", "cyclists", "sprinters","superAthletes"};
		String gametypes[] = {"swimming", "cycling", "running", "cycling", "running"};
		athletes = new ArrayList<>();
		for (int i = 0; i < names.length; i++) {
			People athlete;
			if(types[i] == "swimmers"){
				athlete = new Swimmer(i+"", names[i], 18+i, states[i], 0);
			} else if(types[i] == "cyclists"){
				athlete = new Cyclist(i+"", names[i], 18+i, states[i], 0);
			} else if(types[i] == "sprinters"){
				athlete = new Sprinter(i+"", names[i], 18+i, states[i], 0);
			} else {
				athlete = new SuperAthletes(i+"", names[i], 18+i, states[i], 0);
			}
//			Athletes athlete = new Athletes(i+"", names[i], 18+i, states[i], types[i], 0);
			athletes.add(athlete);
		}
		for (int i = 0; i < 5; i++) {
			Game game = new Game(gameNames[i], gametypes[i]);
			if(game.getType() == "swimming"){
				for(People athlete : athletes){
					if(athlete.getType() == "swimmers" || athlete.getType() == "superAthletes"){
						game.getAthletes().add(athlete);
					}
				}
			} else if(game.getType() == "cycling"){
				for(People athlete : athletes){
					if(athlete.getType() == "cyclists" || athlete.getType() == "superAthletes"){
						game.getAthletes().add(athlete);
					}
				}
			} else {
				for(People athlete : athletes){
					if(athlete.getType() == "sprinters" || athlete.getType() == "superAthletes"){
						game.getAthletes().add(athlete);
					}
				}
			}
			games.add(game);
			Official official = new Official(i+100+"", "Offical"+i, game);
			officials.add(official);
		}
		
		
	}
	
	/**
	 * Select a game to compete.
	 * @return Game 
	 */
	public Game select(){
		for(Game game: games){
			System.out.println(game.toString());
		}
		System.out.print("Please select a game by id: ");
		Scanner input = new Scanner(System.in);
		String id = input.nextLine();
		for(Game game: games){
			if(game.getId().equals(id)){
				System.out.println("Select game "+id);
				return game;
			}
		}
		return null;
	}
	
	public void predict(Game game){
		System.out.print("Please input the id of the athlete: ");
		Scanner input = new Scanner(System.in);
		String pred = input.nextLine();
		for(People athlete : game.getAthletes()){
			if(athlete.getId().equals(pred)){
				game.setPred(pred);
				System.out.println("Successfuly predict.");
				return;
			}
		}
		System.out.println("No such athletes!");
	}
	
	/**
	 * Start a game
	 * @param game
	 */
	public void start(Game game){
		int type = 0;
		if(game.getType() == "running"){
			type = 0;
		} else if(game.getType() == "swimming"){
			type = 1;
		} else if(game.getType() == "cycling"){
			type = 2;
		}
		for(People athlete : game.getAthletes()){
			athlete.compete(type);
		}
		Comparator<People> comparator = new Comparator<People>() {

			@Override
			public int compare(People o1, People o2) {
				// TODO Auto-generated method stub
				if(o1.getTime() > o2.getTime()){
					return 1;
				}
				return -1;
			}
		};
		Collections.sort(game.getAthletes(), comparator);
		int point = game.getAthletes().get(0).getPoint();
		game.getAthletes().get(0).setPoint(point+5);
		point = game.getAthletes().get(0).getPoint();
		game.getAthletes().get(1).setPoint(point+2);
		point = game.getAthletes().get(0).getPoint();
		game.getAthletes().get(2).setPoint(point+1);
		System.out.println("Game complete.");
		for(int i=0;i<3;++i){
			People athlete = game.getAthletes().get(i);
			System.out.printf("No. %d  %s\tTime: %.2f\n", i+1, athlete.toString(), athlete.getTime());
//			System.out.println(i+ ". "+athlete.toString()+"\t"+"Time: "+athlete.getTime());
		}
	}
	
	/**
	 * Show game result.
	 * @param game
	 */
	public void result(Game g){
		Game game = null;
		for(Official official: officials){
			if(official.getGame().getId() == g.getId()){
				game = official.getGame();
				break;
			}
		}
		if(game.getAthletes().get(0).getId().equals(game.getPred())){
			System.out.println("Congratulation you predict right!");
		}
		int i = 1;
		System.out.println("Game "+game.getId()+" results: ");
		for(People athlete : game.getAthletes()){
			System.out.printf("No. %d  %s\tTime: %.2f\tScore: %d\n", i, athlete.toString(), athlete.getTime(), athlete.getPoint());
//			System.out.println(i+". "+ athlete.toString()+"\t"+"Time: "+athlete.getTime()+"\t"+"Score: "+athlete.getPoint());
			i++;
		}
	}
	
	/**
	 * Show points of all athletes.
	 */
	public void points(){
		for(People athlete : athletes){
			System.out.println(athlete.toString()+"\tScore: "+athlete.getPoint());
		}
	}
}
