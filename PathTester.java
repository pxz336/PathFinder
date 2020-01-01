package lab11;

public class PathTester {

	public static void main (String[] args) {
		//String placeholder = "";
		
		createSolutions();
		System.out.println("\n=====================\n\nAre paths identical?\n");
		testSolutions();
		//debugDifferences();
		
	}
		private static void createSolutions() { //Creates output files for all mazes
		
		PathFinder test1 = new PathFinder();
		
		test1.solveMaze("C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\tinyMaze.txt","C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\Converted\\tinyMazeConverted.txt");
		test1.solveMaze("C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\bigMaze.txt","C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\Converted\\bigMaze.txt");
		test1.solveMaze("C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\classic.txt","C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\Converted\\classic.txt");
		test1.solveMaze("C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\demoMaze.txt","C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\Converted\\demoMaze.txt");
		test1.solveMaze("C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\mediumMaze.txt","C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\Converted\\mediumMaze.txt");
		test1.solveMaze("C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\randomMaze.txt","C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\Converted\\randomMaze.txt");
		test1.solveMaze("C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\straight.txt","C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\Converted\\straight.txt");
		test1.solveMaze("C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\tinyMaze.txt","C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\Converted\\tinyMaze.txt");
		test1.solveMaze("C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\tinyOpen.txt","C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\Converted\\tinyOpen.txt");
		test1.solveMaze("C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\turn.txt","C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\Converted\\turn.txt");
		test1.solveMaze("C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\unsolvable.txt","C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\Converted\\unsolvable.txt");
		
	}
	
		
		private static void testSolutions() { //Tests if all String are identical for provided output and computed output
			PathFinder test2 = new PathFinder();
			
			System.out.println("tinyMaze: " + test2.checkEqual("C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\tinyMazeSol.txt","C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\Converted\\tinyMazeConverted.txt"));
			System.out.println("BigMaze: " + test2.checkEqual("C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\bigMazeSol.txt","C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\Converted\\bigMaze.txt"));
			System.out.println("classicSol: " + test2.checkEqual("C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\classicSol.txt","C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\Converted\\classic.txt"));
			System.out.println("demoMaze: " + test2.checkEqual("C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\demoMazeSol.txt","C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\Converted\\demoMaze.txt"));
			System.out.println("mediumMaze: " + test2.checkEqual("C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\mediumMazeSol.txt","C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\Converted\\mediumMaze.txt"));
			System.out.println("randomMaze: " + test2.checkEqual("C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\randomMazeSol.txt","C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\Converted\\randomMaze.txt"));
			System.out.println("straightSol: " + test2.checkEqual("C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\straightSol.txt","C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\Converted\\straight.txt"));
			System.out.println("tinyMaze: " + test2.checkEqual("C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\tinyMazeSol.txt","C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\Converted\\tinyMaze.txt"));
			System.out.println("tinyOpen: " + test2.checkEqual("C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\tinyOpenSol.txt","C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\Converted\\tinyOpen.txt"));
			System.out.println("turn: " + test2.checkEqual("C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\turnSol.txt","C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\Converted\\turn.txt"));
			System.out.println("unsolvable: " + test2.checkEqual("C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\unsolvableSol.txt","C:\\Users\\thema\\eclipse-workspace\\Lab11\\src\\lab11\\Converted\\unsolvable.txt"));
			
		}
		
		
		
		/*private static void debugDifferences() { //Can't be fucked to implement this...
			String demoMazeProv,demoMazeCalc,randomMazeProv,randomMazeCalc,tinyOpenProv,tinyOpenCalc;
		}
		
		private static String debugString() {
			
			PathFinder test3 = new PathFinder();
			
			return "";
		}*/
}
