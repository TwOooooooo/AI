package Lab23;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class UniformCostSearchAlgo implements ISearchAlgo {

	public class NodeComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			if (o1.getPathCost() == o2.getPathCost()) {
				return o1.compareTo(o2);
			}
			return Double.compare(o1.getPathCost(), o2.getPathCost());

		}

	}

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		double pathCost = 0;
		root.setPathCost(pathCost);
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		frontier.add(root);
		Set<Node> explored = new HashSet<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal))
				return current;
			explored.add(current);
			List<Edge> children = current.getChildren();
			for (Edge edge : children) {
				Node child = edge.getEnd();
				if (!explored.contains(child)) {
					if (!frontier.contains(child)) {
						frontier.add(child);
						child.setParent(current);
						child.setPathCost(current.getPathCost() + edge.getWeight());
					} else {
						frontier.add(current);
						child.setParent(current);
						double newPathCost = current.getPathCost() + edge.getWeight();
						if (child.getPathCost() > newPathCost)
							child.setPathCost(newPathCost);
					}
				}
			}

		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		boolean started = false;
		double pathCost = 0;
		root.setPathCost(pathCost);
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		frontier.add(root);
		Set<Node> explored = new HashSet<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(start)) {
				started = true;
				current.setParent(null);
				current.setPathCost(0);
				frontier.clear();
				explored.clear();
			}
			if (current.getLabel().equals(goal) && started == true)
				return current;
			explored.add(current);
			List<Edge> children = current.getChildren();
			for (Edge edge : children) {
				Node child = edge.getEnd();
				if (!explored.contains(child)) {
					if (!frontier.contains(child)) {
						frontier.add(child);
						child.setParent(current);
						child.setPathCost(current.getPathCost() + edge.getWeight());
					} else {
						frontier.add(current);
						child.setParent(current);
						double newPathCost = current.getPathCost() + edge.getWeight();
						if (child.getPathCost() > newPathCost)
							child.setPathCost(newPathCost);
					}
				}
			}

		}
		return null;
	}

	@Override
	public Node execute(Node root, String goal, int limitedDepth) {
		Stack<Node> frontier = new Stack<Node>();
		int state = 1;
		frontier.add(root);
		List<Node> explored = new LinkedList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if (current.getLabel().equals(goal))
				return current;
			if (current.getDepth() < limitedDepth) {
				List<Node> children = current.getChildrenNodes();
				Collections.sort(children, new Comparator<Node>() {
					@Override
					public int compare(Node o1, Node o2) {
						// TODO Auto-generated method stub
						return o2.getLabel().compareTo(o1.getLabel());
					}
				});
				for (Node node : children) {
					if (!frontier.contains(node) && !explored.contains(node)) {
						frontier.add(node);
						node.setParent(current);
						node.setDepth(current.getDepth() + 1);
					}
				}
			}
		}
		return null;

	}

}
