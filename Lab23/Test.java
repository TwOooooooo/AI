package Lab23;

public class Test {
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");
		nodeS.addEdge(nodeA, 5);
		nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4);
		nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4);
		nodeB.addEdge(nodeG, 6);
		nodeC.addEdge(nodeF, 2);
		nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6);
		nodeF.addEdge(nodeG, 1);
		
		ISearchAlgo algo11 = new BreadthFirstSearchAlgo();
		Node result1 = algo11.execute(nodeS, "G");
		for (String temp : NodeUtils.printPath(result1)) {
			System.out.println(temp);
		}
		System.out.println(result1);
		System.out.println("---------");
		
		ISearchAlgo algo2 = new DepthFirstSearchAlgo();
		Node result2 = algo2.execute(nodeS, "A", "G");
		for (String temp : NodeUtils.printPath(result2)) {
			System.out.println(temp);
		}
		System.out.println("---------");
		
		ISearchAlgo algo3 = new BFSGraphAlgo();
		Node result3 = algo3.execute(nodeS,"A", "G");
		for (String temp : NodeUtils.printPath(result3)) {
			System.out.println(temp);
		}
		System.out.println(result3 );
		System.out.println(result3.getPathCost());
		System.out.println("---------");
		
		ISearchAlgo algo4 = new UniformCostSearchAlgo();
		Node result4 = algo4.execute( nodeA,"G", 3);
		for (String temp : NodeUtils.printPath(result4)) {
			System.out.println(temp);
		}
		System.out.println(result4 );
		System.out.println(result4.getPathCost());
	}
}
