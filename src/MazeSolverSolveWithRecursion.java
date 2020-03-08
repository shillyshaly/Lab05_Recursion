import static javafx.scene.input.KeyCode.M;

/**
 * Maze Game - finds the path using recursive implementation
 *
 * @author Jamie Hernandez
 * @version 2/25/2020
 */
public class MazeSolverSolveWithRecursion extends MazeSolver
{
    public MazeSolverSolveWithRecursion(int[][] maze)
    {
        super(maze);
    } // end constructor


    public boolean solveMaze(int r, int c)
    {
        // TODO Project #4B - DONE
        boolean move = false;
        if (!isLegal(r,c)){
            move = false;
        }else if (isGoal(r,c)){
            move = true;
        }else if (!isOpen(r,c)){
            move = false;
        }else {
            this.squares[r][c] = VISITED;

            if (solveMaze(r - 1, c)){ //up
                move = true;
            }else if (solveMaze(r, c + 1)){ //right
                move = true;
            }else if (solveMaze(r + 1, c)){ //down
                move = true;
            }else if (solveMaze(r, c - 1)){ //left
                move = true;
            }
        }
        return move;
    }
} // end MazeSolverSolveWithRecursion