import java.util.*;
import java.lang.Math;

public class EuclideanFringe{
  private boolean nextNode;
  private int previousX;
  private int previousY;
  private Grid grid;
  private Node[][] nodeGrid;
  private char[][] newGrid;
  private Parser parser;
  private PriorityQueue<Node> nodeQueue = new PriorityQueue<>();
  private ArrayList<Node> nodePath = new ArrayList<>();
  private ArrayList<Node> backNodes = new ArrayList<>();
  private ArrayList<Node> currNeighbors = new ArrayList<>();


  public EuclideanFringe(Grid grid){
    nextNode = true;
    this.grid = grid;
    newGrid = grid.getGrid();
    parser = new Parser(this.grid);
    nodeGrid = parser.getNodeGrid();
  }

  public void traverse(){
    Node currentNode = nodeGrid[parser.getInitial()[0]][parser.getInitial()[1]];
    currentNode.setVisited(true);
    while(currentNode != nodeGrid[parser.getGoal()[0]][parser.getGoal()[1]]){
      previousX = currentNode.getCoordinate()[0];
      previousY = currentNode.getCoordinate()[1];
      currentNode = findPath(currentNode);
      if (nextNode){
        newGrid[previousX][previousY] = '.';
      }
      newGrid[currentNode.getCoordinate()[0]][currentNode.getCoordinate()[1]] = 'o';
      currentNode.setVisited(true);
      nodeQueue.remove();
    }
    newGrid[parser.getGoal()[0]][parser.getGoal()[1]] = 'g';
  }

  public Node findPath(Node node){
    int xGoal = parser.getGoal()[0];
    int yGoal = parser.getGoal()[1];
    Node temp = null;

    ArrayList<Node> neighbors = new ArrayList<Node>();
    neighbors = parser.getNeighbors(node);
    for (Node neighbor : neighbors){
      if (!neighbor.getVisited()){
        int xCurr = neighbor.getCoordinate()[0];
        int yCurr = neighbor.getCoordinate()[1];
        neighbor.setWeight(Math.sqrt(Math.pow(xGoal - xCurr, 2) + Math.pow(yGoal - yCurr, 2)));
        nodeQueue.add(neighbor);

        currNeighbors.add(neighbor);
      }
    }

    if (!neighbors.contains(nodeQueue.peek())){
      nextNode = true;
    }else{
      nextNode = false;
    }

    return nodeQueue.peek();
  }

  public void printGrid(){
    for (int i = 0; i < grid.getSize(); ++i){
      for (int j = 0; j < grid.getSize(); ++j){
        System.out.print(newGrid[i][j]);
      }
      System.out.println();
    }
  }
}
