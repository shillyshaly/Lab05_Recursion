import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * MazeSolver
 *
 * @author Jamie Hernandez
 * @version 2/25/2020
 */
public abstract class MazeSolver
{
    protected static final int EMPTY = 0;
    protected static final int WALL = 1;
    protected static final int VISITED = 2;
    protected static final int PLAYER = 4;
    protected static final int GOAL = 5;

    protected int squares[][];

    protected int startRow;
    protected int startCol;
    protected int goalRow;
    protected int goalCol;
    protected boolean gameOn;


    public MazeSolver(int[][] matrix)
    {
        this.squares = new int[matrix.length][];
        for (int r = 0; r < matrix.length; r++)
        {
            this.squares[r] = new int[matrix[r].length];
            for (int c = 0; c < matrix[r].length; c++)
                this.squares[r][c] = matrix[r][c];
        }

        display();
        this.gameOn = setStartAndGoal();
    } // end constructor

    private boolean setStartAndGoal()
    {
        int rGoal;
        int cGoal;
        int rStart;
        int cStart;
        boolean inputOK;
        Scanner keyboard = new Scanner(System.in);

        try
        {
            do
            {
                inputOK = true;
                System.out.println("Enter the START row");
                rStart = keyboard.nextInt();
                System.out.println("Enter the START column");
                cStart = keyboard.nextInt();
                if (!setStart(rStart, cStart))
                {
                    System.out.println("Incorrect START coordinates, please try again.");
                    inputOK = false;
                }

            } while (!inputOK);

            do
            {
                inputOK = true;
                System.out.println("Enter the GOAL row");
                rGoal = keyboard.nextInt();
                System.out.println("Enter the GOAL column");
                cGoal = keyboard.nextInt();
                if (rGoal == rStart && cGoal == cStart)
                {
                    System.out.println("GOAL is the same as START, try different coordinates.");
                    inputOK = false;
                }
                else if (!setGoal(rGoal, cGoal))
                {
                    System.out.println("Incorrect GOAL coordinates, please try again.");
                    inputOK = false;
                }

            } while (!inputOK);
        } catch (InputMismatchException ime)
        {
            System.out.println("Quiting...");
            inputOK = false;
        }
        return inputOK;
    }

    /**
     * Sets the start square.
     *
     * @param r The row coordinate of the square.
     * @param c The column coordinate of the square.
     */
    public boolean setStart(int r, int c)
    {
        boolean startOK = false;
        if (isLegal(r, c) && isOpen(r, c))
        {
            this.startRow = r;
            this.startCol = c;
            this.squares[r][c] = PLAYER; // Starting spot of the player
            startOK = true;
        }
        return startOK;
    } // end setStart

    /**
     * Sets the goal square.
     *
     * @param r The row coordinate of the square.
     * @param c The column coordinate of the square.
     */
    public boolean setGoal(int r, int c)
    {
        boolean goalOK = false;
       // TODO Project #4 - DONE
        if (isLegal(r,c) && isOpen(r,c)){
            goalOK = true;
            this.goalRow = r;
            this.goalCol = c;
            this.squares[r][c] = GOAL;
        }

        return goalOK;
    } // end setGoal

    /**
     * Tests whether a square is a legal square.
     *
     * @param r The row coordinate of the square.
     * @param c The column coordinate of the square.
     * @return True if the square coordinates are within the array for the maze.
     */
    public boolean isLegal(int r, int c)
    {
        // TODO Project #4 - DONE
        boolean legal;
        legal = r >= 0 && c >= 0 && r < this.squares.length && c < this.squares[0].length;

        return legal; // THIS IS A STUB
    } // end isLegal

    /**
     * Tests whether the square is the goal.
     *
     * @param r The row coordinate of the square.
     * @param c The column coordinate of the square.
     * @return True if the square is the goal.
     */
    public boolean isGoal(int r, int c)
    {
        return (r == this.goalRow && c == this.goalCol);
    } // end isGoal

    /**
     * Tests whether the square is free to be visited.
     *
     * @param r The row coordinate of the square.
     * @param c The column coordinate of the square.
     * @return True if the square is empty.
     */
    public boolean isOpen(int r, int c)
    {
        // TODO Project #4 - DONE
        //     any of the following states should be considered open: EMPTY, GOAL, PLAYER
        boolean open = false;
        if (isLegal(r,c)){
            open = ((this.squares[r][c] == EMPTY) || (this.squares[r][c] == GOAL) || (this.squares[r][c] == PLAYER));
        }

        return open; // THIS IS A STUB
    } // end isOpen

    /**
     * Tests whether the square is the wall.
     *
     * @param r The row coordinate of the square.
     * @param c The column coordinate of the square.
     * @return True if the square is the wall.
     */
    public boolean isWall(int r, int c)
    {
        // TODO Project #4 - DONE
        boolean wall = false;
        if (!isLegal(r,c)){
            wall = true;
        }

        return wall; // THIS IS A STUB
    } // end isWall

    /**
     * Displays this maze.
     */
    public void display()
    {
        System.out.printf("      ");
        for (int c = 0; c < this.squares[0].length; c++)
        {
            System.out.printf("[%1$2s] ", c);
        }
        System.out.println();
        String mark;
        for (int r = 0; r < this.squares.length; r++)
        {
            System.out.printf("[%1$2s]", r);
            for (int c = 0; c < this.squares[0].length; c++)
            {
                switch (squares[r][c])
                {
                    case WALL:
                        mark = "|";
                        break;
                    case PLAYER:
                        mark = "P";
                        break;
                    case VISITED:
                        mark = "+";
                        break;
                    case GOAL:
                        mark = "G";
                        break;
                    case EMPTY:
                        mark = ".";
                        break;
                    default:
                        mark = "?"; // should not happen
                        break;
                }
                System.out.printf("%1$5s", mark);
            }
            System.out.println();
        }
        System.out.println();
    }

    public abstract boolean solveMaze(int startRow, int startColumn);
} // end MazeSolver