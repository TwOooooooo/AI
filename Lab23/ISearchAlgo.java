package Lab23;


public interface ISearchAlgo {
	public Node execute(Node root, String goal);
		
	public Node execute(Node root, String start, String goal); // find the path from start node to the goal node

	Node execute(Node root, String goal, int limitedDepth);
}
