package Lab5;

import java.util.Arrays;
import java.util.List;

public class TestNode {

	public static void main(String[] args) {
		Puzzle p = new Puzzle();
		p.readInput("D:\\study\\AI\\Lab 5\\txt\\PuzzleMap.txt",
				"D:\\study\\AI\\Lab 5\\txt\\PuzzleGoalState.txt");

		Node initialState = p.getInitialState();
		Node tmp = new Node(initialState);
		System.out.println(initialState.equals(tmp));
		Node goalState = p.getGoalState();
		System.out.println(p.getInitialState());
		System.out.println("H: " + initialState.getH());
		System.out.println(p.getGoalState());
		Node re = p.moveWhiteTile(initialState, 'r');

		System.out.println(re);
		System.out.println(re.getH());
		System.out.println(initialState);

		System.out.println("------------------------");
		p.getInitialState().setH(p.computeH2(p.getInitialState()));
		Node res1 = new AStarSearch().execute(p);
		System.out.println(res1);

	}

}
