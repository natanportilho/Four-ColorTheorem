package portilho.natan;

/*STUDENT: NATAN PORTILHO DA SILVA*/

import java.util.ArrayList;

/*Class that represents the USA states. Each state has some neighbors */
public class State {
	String name;
	int color;

	ArrayList<State> neighbors = new ArrayList<State>();

	public State(String name) {
		this.name = name;
		this.color = 0;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public ArrayList<State> getNeighbors() {
		return neighbors;
	}

	public int getNumberOfNeighbors() {
		return neighbors.size();
	}

	public void setNeighbors(ArrayList<State> neighbors) {
		this.neighbors = neighbors;
	}

	public void setNeighbors(State neighbor1) {
		this.neighbors.add(neighbor1);
	}

	public void setNeighbors(State neighbor1, State neighbor2) {
		neighbors.add(neighbor1);
		neighbors.add(neighbor2);
	}

	public void setNeighbors(State neighbor1, State neighbor2, State neighbor3) {
		this.neighbors.add(neighbor1);
		this.neighbors.add(neighbor2);
		this.neighbors.add(neighbor3);
	}

	public void setNeighbors(State neighbor1, State neighbor2, State neighbor3, State neighbor4) {
		this.neighbors.add(neighbor1);
		this.neighbors.add(neighbor2);
		this.neighbors.add(neighbor3);
		this.neighbors.add(neighbor4);
	}

	public void setNeighbors(State neighbor1, State neighbor2, State neighbor3, State neighbor4, State neighbor5) {
		this.neighbors.add(neighbor1);
		this.neighbors.add(neighbor2);
		this.neighbors.add(neighbor3);
		this.neighbors.add(neighbor4);
		this.neighbors.add(neighbor5);

	}

	public void setNeighbors(State neighbor1, State neighbor2, State neighbor3, State neighbor4, State neighbor5,
			State neighbor6) {
		this.neighbors.add(neighbor1);
		this.neighbors.add(neighbor2);
		this.neighbors.add(neighbor3);
		this.neighbors.add(neighbor4);
		this.neighbors.add(neighbor5);
		this.neighbors.add(neighbor6);
	}
	
	public void setNeighbors(State neighbor1, State neighbor2, State neighbor3, State neighbor4, State neighbor5,
			State neighbor6, State neighbor7) {
		this.neighbors.add(neighbor1);
		this.neighbors.add(neighbor2);
		this.neighbors.add(neighbor3);
		this.neighbors.add(neighbor4);
		this.neighbors.add(neighbor5);
		this.neighbors.add(neighbor6);
		this.neighbors.add(neighbor7);
	}
	
	public void setNeighbors(State neighbor1, State neighbor2, State neighbor3, State neighbor4, State neighbor5,
			State neighbor6, State neighbor7, State neighbor8) {
		this.neighbors.add(neighbor1);
		this.neighbors.add(neighbor2);
		this.neighbors.add(neighbor3);
		this.neighbors.add(neighbor4);
		this.neighbors.add(neighbor5);
		this.neighbors.add(neighbor6);
		this.neighbors.add(neighbor7);
		this.neighbors.add(neighbor8);
	}

}
