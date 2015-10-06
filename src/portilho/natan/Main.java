package portilho.natan;

/*STUDENT: NATAN PORTILHO DA SILVA*/

import java.util.ArrayList;

public class Main {

	static ArrayList<State> map = new ArrayList<State>();

	public static void main(String[] args) {
		// Creating states (South-Eastern states of the USA)
		State florida = new State("Florida");
		State georgia = new State("Georgia");
		State alabama = new State("Alabama");
		State southCarolina = new State("South Carolina");
		State northCarolina = new State("North Carolina");
		State tennessee = new State("Tennessee");
		State mississippi = new State("Mississippi");
		State virginia = new State("Virginia");
		State westVirginia = new State("West Virginia");
		State kentucky = new State("Kentucky");
		// Other states
//		State arkansas = new State("Arkansas");
//		State louisiana = new State("Louisiana");
//		State oklahoma = new State("Oklahoma");
//		State texas = new State("Texas");
//		State newMexico = new State("New Mexico");
//		State Arizona = new State("Arizona");
//		State california = new State("California");
//		State nevada = new State("Nevada");
//		State utah = new State("Utah");
//		State colorado = new State("Colorado");
//		State kansas = new State("Kansas");
//		State missouri = new State("Missouri");
//		State illinois = new State("Illinois");
//		State indiana = new State("Indiana");
//		State Ohio = new State("ohio");
//		State pennsylvania = new State("Pennsylvania");
//		State newJersey = new State("New Jersey");
//		State delaware = new State("Delaware");
//		State maryland = new State("Maryland");
//		State iowa = new State("Iowa");
//		State nebraska = new State("Nebraska");
//		State wyoming = new State("Wyoming");
//		State idaho = new State("Idaho");
//		State oregon = new State("Oregon");
//		State washington = new State("Washington");
//		State montana = new State("Montana");
//		State southDakota = new State("South Dakota");
//		State northDakota = new State("North Dakota");
//		State minnesota = new State("Minnesota");
//		State wisconsin = new State("Wisconsin");
//		State michigan = new State("Michigan");
//		State newYork = new State("New York");
//		State connecticut = new State("Connecticut");
//		State rhodeIsland = new State("Rhode Island");
//		State massachusetts = new State("Massachusetts");
//		State newHampshire = new State("New Hampshire");
//		State vermont = new State("Vermont");
//		State maine = new State("Maine");
//		State alaska = new State("Alaska");
//		State hawaii = new State("Hawaii");

		// Adding states into the map (South-Eastern states of the USA)
		map.add(florida);
		map.add(georgia);
		map.add(alabama);
		map.add(southCarolina);
		map.add(northCarolina);
		map.add(tennessee);
		map.add(mississippi);
		map.add(virginia);
		map.add(westVirginia);
		map.add(kentucky);
//		
//		//Other states
//		map.add(arkansas);
//		map.add(louisiana);
//		map.add(oklahoma);
//		map.add(texas);
//		map.add(newMexico);
//		map.add(Arizona);
//		map.add(california); 
//		map.add(nevada); 
//		map.add(utah); 
//		map.add(colorado); 
//		map.add(kansas); 
//		map.add(missouri); 
//		map.add(illinois); 
//		map.add(indiana); 
//		map.add(Ohio); 
//		map.add(pennsylvania);
//		map.add(newJersey);
//		map.add(delaware); 
//		map.add(maryland); 
//		map.add(iowa);
//		map.add(nebraska); 
//		map.add(wyoming);
//		map.add(idaho); 
//		map.add(oregon);
//		map.add(washington); 
//		map.add(montana);
//		map.add(southDakota); 
//		map.add(northDakota); 
//		map.add(minnesota); 
//		map.add(wisconsin);
//		map.add(michigan); 
//		map.add(newYork);
//		map.add(connecticut); 
//		map.add(rhodeIsland); 
//		map.add(massachusetts); 
//		map.add(newHampshire); 
//		map.add(vermont);
//		map.add(maine); 
//		map.add(alaska); 
//		map.add(hawaii); 
		// Setting states' neighbors (South-Eastern states of the USA)
		florida.setNeighbors(georgia, alabama);
		georgia.setNeighbors(florida, alabama, mississippi, southCarolina, northCarolina);
		alabama.setNeighbors(florida, mississippi, georgia, tennessee);
		mississippi.setNeighbors(alabama, tennessee);
		southCarolina.setNeighbors(georgia, northCarolina);
		northCarolina.setNeighbors(southCarolina, tennessee, virginia, georgia);
		tennessee.setNeighbors(mississippi, alabama, georgia, northCarolina, virginia, kentucky);
		virginia.setNeighbors(northCarolina, tennessee, kentucky, westVirginia);
		westVirginia.setNeighbors(virginia, kentucky);
		kentucky.setNeighbors(tennessee, virginia, westVirginia);
		
		// Other states
		
		

		solve();

		printResult();

	}


	private static void printResult() {
		for (State state : map) {
			String color = null;
			switch (state.color) {
			case 1:
				color = "red";
				break;
			case 2:
				color = "yellow";
				break;
			case 3:
				color = "green";
				break;
			case 4:
				color = "black";
				break;

			default:
				break;
			}
			System.out.println(state.name + " : " + color);
		}

	}

	// Goal is when all states are colored
	public static boolean isGoal() {
		for (int i = 0; i < map.size(); i++) {

			if (map.get(i).color == 0) {
				return false;
			}
		}
		return true;
	}

	public static void solve() {
		while (!isGoal()) {
			for (State state : map) {
				paint(state);
			}
		}
	}

	/*
	 * There is a switch to get how many neighbors each state has. The algorithm
	 * will be in this order: - IF there is no neighbor RED, will color the
	 * actual state with RED. - ELSE if there is no neighbor YELLOW, will color
	 * the actual state with YELLOW - ELSE if there is no neighbor GREEN, will
	 * color the actual state with GREEN - ELSE if there is no neighbor BLACK,
	 * will color the actual state with BLACK
	 */
	public static void paint(State state) {
		int neighborOneColor, neighborTwoColor, neighborThreeColor, neighborFourColor, neighborFiveColor,
				neighborSixColor;

		switch (state.getNumberOfNeighbors()) {

		case 0:
			state.setColor(1);
			break;
		case 1:
			neighborOneColor = state.neighbors.get(0).getColor(); // Getting
																	// neighbor
																	// colors
			break;
		case 2:
			neighborOneColor = state.neighbors.get(0).getColor();
			neighborTwoColor = state.neighbors.get(1).getColor();

			if (state.getColor() == 0 && neighborOneColor != 1 && neighborTwoColor != 1) {
				state.setColor(1);
			} else if (state.getColor() == 0 && neighborOneColor != 2 && neighborTwoColor != 2) {
				state.setColor(2);
			}
			break;

		case 3:
			neighborOneColor = state.neighbors.get(0).getColor();
			neighborTwoColor = state.neighbors.get(1).getColor();
			neighborThreeColor = state.neighbors.get(2).getColor();

			if (state.getColor() == 0 && neighborOneColor != 1 && neighborTwoColor != 1 && neighborThreeColor != 1) {
				state.setColor(1);
			} else if (state.getColor() == 0 && neighborOneColor != 2 && neighborTwoColor != 2
					&& neighborThreeColor != 2) {
				state.setColor(2);
			} else if (state.getColor() == 0 && neighborOneColor != 3 && neighborTwoColor != 3
					&& neighborThreeColor != 3) {
				state.setColor(3);
			}
			break;

		case 4:
			neighborOneColor = state.neighbors.get(0).getColor();
			neighborTwoColor = state.neighbors.get(1).getColor();
			neighborThreeColor = state.neighbors.get(2).getColor();
			neighborFourColor = state.neighbors.get(3).getColor();

			if (state.getColor() == 0 && neighborOneColor != 1 && neighborTwoColor != 1 && neighborThreeColor != 1
					&& neighborFourColor != 1) {
				state.setColor(1);
			} else if (state.getColor() == 0 && neighborOneColor != 2 && neighborTwoColor != 2
					&& neighborThreeColor != 2 && neighborFourColor != 2) {
				state.setColor(2);
			} else if (state.getColor() == 0 && neighborOneColor != 3 && neighborTwoColor != 3
					&& neighborThreeColor != 3 && neighborFourColor != 3) {
				state.setColor(3);
			} else if (state.getColor() == 0 && neighborOneColor != 4 && neighborTwoColor != 4
					&& neighborThreeColor != 4 && neighborFourColor != 4) {
				state.setColor(4);
			}
			break;
		case 5:
			neighborOneColor = state.neighbors.get(0).getColor();
			neighborTwoColor = state.neighbors.get(1).getColor();
			neighborThreeColor = state.neighbors.get(2).getColor();
			neighborFourColor = state.neighbors.get(3).getColor();
			neighborFiveColor = state.neighbors.get(4).getColor();

			if (state.getColor() == 0 && neighborOneColor != 1 && neighborTwoColor != 1 && neighborThreeColor != 1
					&& neighborFourColor != 1 && neighborFiveColor != 1) {
				state.setColor(1);
			} else if (state.getColor() == 0 && neighborOneColor != 2 && neighborTwoColor != 2
					&& neighborThreeColor != 2 && neighborFourColor != 2 && neighborFiveColor != 2) {
				state.setColor(2);
			} else if (state.getColor() == 0 && neighborOneColor != 3 && neighborTwoColor != 3
					&& neighborThreeColor != 3 && neighborFourColor != 3 && neighborFiveColor != 3) {
				state.setColor(3);
			} else if (state.getColor() == 0 && neighborOneColor != 4 && neighborTwoColor != 4
					&& neighborThreeColor != 4 && neighborFourColor != 4 && neighborFiveColor != 4) {
				state.setColor(4);
			}
			break;
		case 6:
			neighborOneColor = state.neighbors.get(0).getColor();
			neighborTwoColor = state.neighbors.get(1).getColor();
			neighborThreeColor = state.neighbors.get(2).getColor();
			neighborFourColor = state.neighbors.get(3).getColor();
			neighborFiveColor = state.neighbors.get(4).getColor();
			neighborSixColor = state.neighbors.get(5).getColor();

			if (state.getColor() == 0 && neighborOneColor != 1 && neighborTwoColor != 1 && neighborThreeColor != 1
					&& neighborFourColor != 1 && neighborFiveColor != 1 && neighborSixColor != 1) {
				state.setColor(1);
			} else
				if (state.getColor() == 0 && neighborOneColor != 2 && neighborTwoColor != 2 && neighborThreeColor != 2
						&& neighborFourColor != 2 && neighborFiveColor != 2 && neighborSixColor != 2) {
				state.setColor(2);
			} else if (state.getColor() == 0 && neighborOneColor != 3 && neighborTwoColor != 3
					&& neighborThreeColor != 3 && neighborFourColor != 3 && neighborFiveColor != 3
					&& neighborSixColor != 3) {
				state.setColor(3);
			} else
				if (state.getColor() == 0 && neighborOneColor != 4 && neighborTwoColor != 4 && neighborThreeColor != 4
						&& neighborFourColor != 4 && neighborFiveColor != 4 && neighborSixColor != 4) {
				state.setColor(4);
			}
			break;
		default:
			break;
		}
	}
}
