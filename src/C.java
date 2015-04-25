import java.io.*;
import java.util.*;



public class C {
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(
			System.in));
	static StringTokenizer st = new StringTokenizer("");
    
	public static void main(String[] args) throws Exception {
		int cases = readInt();
		for (int i = 0; i < cases; i++) {
			 work();
		}
	}

	private static void work() throws Exception {
		int numberOfNodes = readInt();
		ArrayList<Footprint> nodes = new ArrayList<Footprint>();
		Footprint root = new Footprint(0, 0);
		root.reachable = true;
		nodes.add(root);
		getSortedNodes(numberOfNodes, nodes);
		setNeighbourNodes(nodes);
		
		int distance = root.explore(0);
		System.out.println((int)(Math.sqrt(distance)));
	}

	private static void setNeighbourNodes(ArrayList<Footprint> nodes) {
		for (int i = 0; i < nodes.size(); i++) {
			Footprint node = nodes.get(i);
			for(int j = i+1; j < nodes.size(); j++) {
				Footprint neighbour = nodes.get(j);
				if (Math.abs(neighbour.x - node.x) > 100)
					break;
				if (node.isNeighbourTo(neighbour)) {
					node.neighbours.add(neighbour);
					neighbour.neighbours.add(node);
				}
			}
		}
	}

	private static void getSortedNodes(int numberOfNodes,
			ArrayList<Footprint> nodes) throws Exception {
		for (int i = 0; i < numberOfNodes; i++) {
			nodes.add(new Footprint(readInt(), readInt()));
		}
		nodes.sort(new Comparator<Footprint>() {
			@Override
			public int compare(Footprint o1, Footprint o2) {
				return o1.x - o2.x;
			}
		});
	}

	// Read next input-token as string.
	static String readString() throws Exception {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(stdin.readLine());
		}
		return st.nextToken();
	}

	// Read next input-token as integer.
	static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}

	// Read next input-token as double.
	static double readDouble() throws Exception {
		return Double.parseDouble(readString());
	}
	
	
}

class Footprint {
	public Footprint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int x;
	public int y;
	
	public boolean reachable = false;
	public boolean searched = false;
	
	public HashSet<Footprint> neighbours = new HashSet<Footprint>();
	
	public boolean isNeighbourTo(Footprint n) {
		int dx = n.x - x;
		int dy = n.y - y;
		return dx*dx + dy*dy <= 100*100;
	}
	
	public int sqaredRadius() {
		return this.x*this.x + this.y* this.y;
	}

	public int explore(int currentMaxSquaredDistance) {
		if (this.searched)
			return currentMaxSquaredDistance;
		
		currentMaxSquaredDistance = Math.max(this.sqaredRadius(), currentMaxSquaredDistance);
		this.reachable = true;
		this.searched = true;
		
		for (Footprint f : neighbours)
			currentMaxSquaredDistance = f.explore(currentMaxSquaredDistance);
		
		return currentMaxSquaredDistance;
	}
}