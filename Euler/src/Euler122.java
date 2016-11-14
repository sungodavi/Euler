import java.util.*;

class Node
{
	int value;
	int level;
	Node parent;
	ArrayList<Node> children;
	public Node(int num, int level, Node p)
	{
		value = num;
		children = new ArrayList<Node>();
		parent = p;
	}
	public String toString()
	{
		String s;
		if(parent != null)
			s = parent.value + "->" + value + "->";
		else
			s = value + "->";
		for(Node n: children)
		{
			s += n.value + ", ";
		}
		return s.substring(0,s.length() -2);
	}
}

class Tree
{
	Node tree;
	public Tree()
	{
		tree = new Node(1, 1, null);
	}
	public void create(int limit)
	{
		create(tree, limit);
	}
	private void create(Node n, int limit)
	{
		//System.out.println("recurse: " + limit);
		if(limit == 0)
			return;
		Node p = n;
		while(p != null)
		{
			Node node = new Node(p.value + n.value,n);
			System.out.println(node);
			n.children.add(node);
			p = p.parent;
		}
		for(Node node: n.children)
			create(node,limit - 1);
	}
	
	public void levelOrderTraversal()
	{
		Queue<Node> q = new LinkedList<Node>();
		q.add(tree);
		while(!q.isEmpty())
		{
			Node n = q.poll();
			System.out.println(n.value);
			for(Node child: n.children)
				q.add(child);
		}
	}
}
public class Euler122 
{
	public static void main(String[] args)
	{
		Tree t = new Tree();
		t.create(3);
		t.levelOrderTraversal();
	}
}
