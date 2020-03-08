import java.util.Scanner;

/**
 * MazeGame driver
 *
 * @author atb
 * @version 2/25/2020
 */
public class MazeGame
{
	public static void main(String[] args)
	{
		int[][] aSolvableMaze = { {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				{0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
				{1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1},
				{1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1},
				{1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
				{1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

		Scanner keyboard = new Scanner(System.in);
		System.out.println("P: play the maze");
		System.out.println("R: get the solution to the maze with recursion");
		System.out.println("S: get the solution to the maze with stack");
		System.out.println("Q: exit\n");

		boolean quit = false;
		String selection = keyboard.nextLine();
		MazeSolver mazeSolver = null;

		switch(Character.toLowerCase(selection.charAt(0)))
		{
			case 'p':
				mazeSolver = new MazeSolverPlay(aSolvableMaze);
				break;
			case 'r':
				mazeSolver = new MazeSolverSolveWithRecursion(aSolvableMaze);
				break;
			case 's':
				mazeSolver = new MazeSolverSolveWithStack(aSolvableMaze);
				break;
			default:
				quit = true;
				break;
		}

		if (!quit && mazeSolver.gameOn)
		{
			mazeSolver.display();
			System.out.println("Searching the maze: ");
			boolean result = mazeSolver.solveMaze(mazeSolver.startRow, mazeSolver.startCol);
			System.out.println("\n---> The GOAL [" + mazeSolver.goalRow + "," + mazeSolver.goalCol + "] was " + (result ? "found!" : "not reached!"));
			System.out.println("\nThe Search result: ");
			mazeSolver.display();
		}
	} // end main
} // end MazeGame