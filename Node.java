package lab11;

public class Node {

	Node previous;
	int nodeWidth,nodeHeight;
	char data;
	boolean visited,isWall,isStart,isGoal;
	
	public Node() {
				
		previous = null;		
		visited = false;
		isStart = false;
		isGoal = false;
		isWall = false;
	}
	
	public Node(int xVal, int yVal, char nodeData) {
		this();
		
		this.nodeWidth = xVal;
		this.nodeHeight = yVal;
		
		this.data = nodeData;
		
		if (data == 'X')
			isWall = true;
		if(data == 'S')
			isStart = true;
		if(data == 'G')
			isGoal = true;
			
	}

	
}
