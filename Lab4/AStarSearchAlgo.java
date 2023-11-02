package Lab4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import Lab4.GreedyBestFirstSearch.NodeComparatorByGn;

public class AStarSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByGn());
		List<Node> explored = new ArrayList<Node>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal))
				return current;
			explored.add(current);
			List<Edge> children = current.getChildren();
			for (Edge edge : children) {
				Node child = edge.getEnd();
				if (!frontier.contains(child) && !explored.contains(child)) {
					child.setParent(current);
					child.setG(current.getG() + edge.getWeight());
					frontier.add(child);
				} else {
					if (frontier.contains(child) && child.getG() > current.getG() + edge.getWeight()) {
						frontier.remove(child);
						child.setParent(current);
						child.setG(current.getG() + edge.getWeight());
						frontier.add(current);
					}
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		boolean started = false;
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByGn());
		List<Node> explored = new ArrayList<>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node currentent = frontier.poll();
			if (currentent.getLabel().equals(start)) {
				started = true;
				frontier.clear();
				explored.clear();
				currentent.setParent(null);
			}
			if (currentent.getLabel().equals(goal) && started == true)
				return currentent;
			explored.add(currentent);
			List<Edge> children = currentent.getChildren();
			for (Edge edge : children) {
				Node child = edge.getEnd();
				if (!explored.contains(child) && !frontier.contains(child)) {
					child.setParent(currentent);
					child.setG(currentent.getG() + edge.getWeight());
					frontier.add(child);
				} else {
					double newG = currentent.getG() + edge.getWeight();
					if (child.getG() > newG)
						frontier.remove(child);
					child.setParent(currentent);
					child.setG(newG);
					frontier.add(child);
				}
			}
		}
		return null;
	}

	public boolean isAdmissibleH(Node tree, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		Set<Node> explored = new HashSet<Node>();
		boolean result = true;

		frontier.offer(tree);

		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			explored.add(current);
			Node nodeRe = execute(current, goal);
			if (nodeRe == null) {
				return false;
			}
			System.out.println(nodeRe.getG());

			if (current.getH() > nodeRe.getG())
				return false;

			for (Node child : current.getChildrenNodes())
				if (!explored.contains(child) && !frontier.contains(child)) {
					child.setParent(null);
					child.setG(0);
					result = result && isAdmissibleH(child, goal);
					if (result == false)
						return result;
				}
		}
		return true;
	}

	class NodeComparatorByGn implements Comparator<Node> {
		@Override
		public int compare(Node o1, Node o2) {
			Double h1 = o1.getH() + o1.getG();
			Double h2 = o2.getH() + o2.getG();
			int result = h1.compareTo(h2);
			if (result == 0)
				return o1.getLabel().compareTo(o2.getLabel());
			else
				return result;
		}
	}
}
