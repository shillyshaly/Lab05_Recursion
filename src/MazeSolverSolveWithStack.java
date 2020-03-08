import java.util.Stack;
/**
 * Maze Game - finds the path using stack
 *
 * @author Jamie Hernandez
 * @version 2/25/2020
 */
public class MazeSolverSolveWithStack extends MazeSolver
{
    public MazeSolverSolveWithStack(int[][] maze)
    {
        super(maze);
    } // end constructor


    public boolean solveMaze(int r, int c)
    {
        // TODO Project #4C - in progress/debugging

        boolean result = false;
        Stack<MazeCoordinates> stack = new Stack<>();
        stack.push(new MazeCoordinates(r, c));

        MazeCoordinates current = null;


        // when you pop from the stack check for the goal first
        while (!stack.isEmpty()){
            current = stack.pop();
            if (!isLegal(r,c)){
                result = false;
            }else if (isGoal(r,c)){
                result = true;
            }else if (isOpen(r,c)){
                result = false;
            }else {
                if (isOpen(r - 1, c)){
                    stack.push(current);
                }else if (isOpen(r, c + 1)){
                    stack.push(current);
                }else if (isOpen(r + 1, c)){
                    stack.push(current);
                }else if (isOpen(r,c - 1)){
                    stack.push(current);
                }
            }
        }

        // if not the goal:
        //   try moving up (NORTH), next try moving right (EAST),
        //   next try moving down (SOUTH), and finally try moving left (WEST)
        //   !! push only valid moves on the stack !!


        return result;
    }
    private class MazeCoordinates
    {
        private int row;
        private int col;

        public MazeCoordinates(int r, int c)
        {
            this.row = r;
            this.col = c;
        }

        public String toString()
        {
            return "[" + row + "," + col + "]";
        }
    }
} // end MazeSolverSolveWithStack
