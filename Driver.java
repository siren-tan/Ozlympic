import java.util.Scanner;

/**
 * Driver class start the problem.
 * @author s3630040 hanwei Li
 *
 */
public class Driver {
	
	/**
	 * Show menu before every step.
	 */
	public static void showMenu(){
		System.out.print("Ozlympic Game\n" +
				"===================================\n" +
				"1.	Select a game to run\n" +
				"2.	Predict the winner of the game\n" +
				"3.	Start the game\n" +
				"4.	Display the final results of all games\n"+
				"5.	Display the points of all athletes\n"+
				"6.	Exit\n" +
				"Enter an option: ");
	}
	
	
	/**
	 * Main function.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Ozlympic ozlympic = new Ozlympic();
		Game game = null;
		String sp = "\n--------------------------------\n";
		while(true){
			showMenu();
			String in = input.nextLine();
			int sel = 0;
			try {
				sel = Integer.parseInt(in);
			} catch (Exception e) {
				// TODO: handle exception
				sel = 7;
			}
			switch (sel) {
			case 1:
				game = ozlympic.select();
				if (game == null) {
					System.out.println("No such game!");
				}
				break;
			case 2:
				ozlympic.predict(game);
				break;
			case 3:
				ozlympic.start(game);
				break;
			case 4:
				ozlympic.result(game);
				break;
			case 5:
				ozlympic.points();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("Please enter a num from 1 to 6");
				break;
			}
			System.out.println(sp);
		}
	}
}
