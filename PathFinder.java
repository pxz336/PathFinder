package lab11;

import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

public class PathFinder {
	
	static Node[][] convertedGrid,finalPath;
	static int width, height; //size of grid
	static int sHeight,sWidth,gHeight,gWidth; //indexes for start & goal
	static boolean sFound,gFound; //used to test if start & goal found
	
	
	public PathFinder() {
		convertedGrid = null;
		width = 0;
		height = 0;
		sFound = false;
		gFound = false;
	}
	
	public static void solveMaze(String inputFile, String outputFile) {
		
		convertedGrid = convertFile(inputFile); //Converts input file to a Node grid
		if (convertedGrid == null) {
			System.out.println("Error reading file");
			return;
		}
		
		System.out.println(toString(convertedGrid)); // Prints maze for debugging
		finalPath = findPath(convertedGrid); //Finds optimal path through maze
			
		if (finalPath == null) { //If maze unsolvable
				convertToOutput(convertedGrid,outputFile);
				return;
		}
			
		System.out.println(toString(finalPath)); //Prints final maze to make sure path is found
		convertToOutput(finalPath,outputFile); //Outputs solution to maze in a .txt file
		
	}
	
	private static Node[][] convertFile(String inputFile){ //Takes input file and makes an array of apropriate size. Uses FillGrid to fill in data fields.

		int index = 0;
		String currentLine;
		String valueConvert = "";
		
		try {	
		BufferedReader input = new BufferedReader (new FileReader(inputFile));
		currentLine = input.readLine();
		
		while (currentLine.charAt(index) != ' ') { //Gets Height in beginning of file
			valueConvert += currentLine.charAt(index);
			index++;
		}
		
		height = Integer.parseInt(valueConvert);
		//System.out.println(height);
		index++;
		valueConvert = "";
		
		
		while (index < currentLine.length()) { //Gets Width in beginning of file
			valueConvert += currentLine.charAt(index);
			index++;
		}		
		width = Integer.parseInt(valueConvert);
		//System.out.println(width);
				
		Node[][] nodeGrid = new Node[height][width]; //Creates Node array using X & Y values
		
		//System.out.println(nodeGrid.length + " " + nodeGrid[0].length);		
		
		nodeGrid = fillGrid(input, nodeGrid); //Fills in data 		
		
		input.close();
		
		return nodeGrid;
		
		} catch (IOException e){
			System.out.println("Error reading line 52");
		}	
				
		//If reading fails, sends up null
		
		return null;
	}
	
	
	private static Node[][] fillGrid(BufferedReader input, Node[][] grid) { //Fills out array Grid
		
		int width = 0; //Column
		int height = 0; //Row
		String currentLine = "";
		
		//System.out.println(grid.length + " " + grid[0].length);
		
		try {
			currentLine = input.readLine();
		} catch (IOException e) {
			System.out.println("Error reading second line of file");
		}
		
		while (currentLine != null) {			
				while (height < grid[0].length) {
					grid[width][height] = new Node (width,height,currentLine.charAt(height));
					
					if (currentLine.charAt(height) == 'S') { //Sets start values when found
						sHeight = height;
						sWidth = width;	
						sFound = true;
						grid[width][height].isStart = true;
					}
					
					if (currentLine.charAt(height) == 'G') { //Sets goal values when found
						gHeight = height;
						gWidth = width;
						gFound = true;
						grid[width][height].isGoal = true;
					}					
					
					//System.out.print(/*"width: " + width + ", height: " + height + ", data: " + */currentLine.charAt(height) /*+ " "*/);
					
					height++;
				}
						
				//System.out.println();
			
				height = 0;
				width++;
				
				try {
					currentLine = input.readLine();
				} catch (IOException e) {
					System.out.println("Error in conversion");
				}
		}		
		
		return grid;
	}
	
	private static Node[][] findPath(Node[][] puzzle){ //Uses Breadth-First Search to find optimal path
		
		if (sFound == false || gFound == false) {
			System.out.println("Error finding start or goal in initial file");
			return null;
		}
			
		Node current;
		
		Queue<Node> bFS = new LinkedList<Node>();
		
		//System.out.println(sWidth + " " + sHeight);
		//System.out.println(puzzle[sWidth][sHeight].data);
		
		bFS.add(puzzle[sWidth][sHeight]);
		puzzle[sWidth][sHeight].visited = true;
		
		while (bFS.isEmpty() != true) {
			current = bFS.poll();
			if (current.isGoal == true)
				break;
			
			if (puzzle[current.nodeWidth + 1][current.nodeHeight].isWall == false && puzzle[current.nodeWidth + 1][current.nodeHeight].visited == false) { // Adds Right
				bFS.add(puzzle[current.nodeWidth + 1][current.nodeHeight]);
				puzzle[current.nodeWidth + 1][current.nodeHeight].visited = true;
				puzzle[current.nodeWidth + 1][current.nodeHeight].previous = puzzle[current.nodeWidth][current.nodeHeight];
			}
			
			if (puzzle[current.nodeWidth - 1][current.nodeHeight].isWall == false && puzzle[current.nodeWidth - 1][current.nodeHeight].visited == false) { // Adds Left
				bFS.add(puzzle[current.nodeWidth - 1][current.nodeHeight]);
				puzzle[current.nodeWidth - 1][current.nodeHeight].visited = true;
				puzzle[current.nodeWidth - 1][current.nodeHeight].previous = puzzle[current.nodeWidth][current.nodeHeight];
			}
			
			if (puzzle[current.nodeWidth][current.nodeHeight + 1].isWall == false && puzzle[current.nodeWidth][current.nodeHeight + 1].visited == false) { // Adds Up
				bFS.add(puzzle[current.nodeWidth][current.nodeHeight + 1]);
				puzzle[current.nodeWidth][current.nodeHeight + 1].visited = true;
				puzzle[current.nodeWidth][current.nodeHeight + 1].previous = puzzle[current.nodeWidth][current.nodeHeight];
			}
			
			if (puzzle[current.nodeWidth][current.nodeHeight - 1].isWall == false && puzzle[current.nodeWidth][current.nodeHeight - 1].visited == false) { // Adds Down
				bFS.add(puzzle[current.nodeWidth][current.nodeHeight - 1]);	
				puzzle[current.nodeWidth][current.nodeHeight - 1].visited = true;
				puzzle[current.nodeWidth][current.nodeHeight - 1].previous = puzzle[current.nodeWidth][current.nodeHeight];
			}
			
			//System.out.println("===================\n");
		}
		
		
		//printMaze(puzzle);
		return tracePath(puzzle);
	}
	
	
	private static Node[][] tracePath(Node [][] completedPuzzle){ // Retraces path created by the BFS by addind "." to data field of optimal path
		
		Node endOfPath = completedPuzzle[gWidth][gHeight];
		
		if (endOfPath.previous == null) {
			System.out.println("Maze is unsolvable");
			return null;
		}
		
		while (endOfPath.previous.isStart == false) {
			
			//System.out.println(endOfPath.previous.data + " " + endOfPath.previous.nodeWidth + " " + endOfPath.previous.nodeHeight + " " + endOfPath.previous.isStart);
			
			endOfPath.previous.data = '.';
			endOfPath = endOfPath.previous;
		}
		
		
		return completedPuzzle;
	}
	
	
	
	private static void convertToOutput(Node[][] finalMap, String outputFileName) { //Takes converted data fields of graph and packs it into a .txt file
		
		String outputString = height + " " + width + "\n";
		outputString += toString(finalMap);
		
		try {
			PrintWriter out = new PrintWriter(outputFileName);
			out.print(outputString);
			out.close();
		} catch (IOException e) {
			System.out.println("Error outputting file");
		}
		
	}
	
	private static String toString(Node[][] gridToString) { //Converts data fields of graph to a string
		
		String result = "";
		
		for (int i = 0; i < gridToString.length; i++) {
			for (int j = 0; j < gridToString[i].length; j++) {
				result += (gridToString[i][j].data);
			}
			
			result += "\n";
			
		}
		
		return result;
		
	}
	
	public static boolean checkEqual(String providedOutput, String computedOutput) {
		
		String providedSol = "";
		String computedSol = "";
		
		try {		
			BufferedReader inputProvided = new BufferedReader (new FileReader(providedOutput));
			BufferedReader inputComputed = new BufferedReader (new FileReader(computedOutput));
			
			String currentLineProvided = inputProvided.readLine();
			String currentLineComputed = inputComputed.readLine();	
			
			//System.out.println(currentLineProvided);
				
			while (currentLineProvided != null && currentLineComputed != null) {			
				//System.out.println(currentLineProvided);
				
				providedSol += currentLineProvided;
				computedSol += currentLineComputed;
				
				currentLineProvided = inputProvided.readLine();
				currentLineComputed = inputComputed.readLine();
			}
			
			inputProvided.close();
			inputComputed.close();
			
		} catch (IOException e) {
			System.out.println("Error comparing files");
		}
		
		if (providedSol == "" || computedSol == "") {
			System.out.println("Error compiling strings to compare");
			return false;
		}
		
		if (providedSol.equals(computedSol))
			return true;
		else return false;
	}
	
}
