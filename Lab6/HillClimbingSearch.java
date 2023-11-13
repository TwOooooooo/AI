package Lab6;

public class HillClimbingSearch {
	public Node execute(Node initialState) {
		// Enter your code here.
		Node current = initialState;
		Node neighbor = null;
		while (true) {
			neighbor = current.getBestCandidate();
			if (neighbor.getH() < current.getH()) {
				current = neighbor;
			} else {
				return current;
			}
		}
	}

	public Node executeHillClimbingWithRandomRestart(Node initialState) {
		Node current = initialState;
		Node next = null;
		int T = 1000;
		while (current.getH() != 0) {
			next = current.selectNextRandomCandidate();
			int deltaE = next.getH() - current.getH();
			if (deltaE < 0) {
				current = next;
			} else {
				if (Math.exp(deltaE / T) > Math.random()) {
					current = next;
				}
				T = 1;
			}
		}
		return current;
	}
}