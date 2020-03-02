import java.util.*;
import java.lang.Math;

public class EuclideanFringe{
  private Grid grid;
  private Node[][] nodeGrid;
  private char[][] newGrid;
  private Parser parser;
  private PriorityQueue<Node> nodeQueue = new PriorityQueue<>();
  private ArrayList<Node> nodePath = new ArrayList<>();
  private ArrayList<Node> actualPath = new ArrayList<>();


  public EuclideanFringe(Grid grid){
    this.grid = grid;
    newGrid = grid.getGrid();
    parser = new Parser(this.grid);
    nodeGrid = parser.getNodeGrid();
  }

//uses best-first saerch algorithm. FInds all possible nodes
  public void traverse(){
    Node currentNode = nodeGrid[parser.getInitial()[0]][parser.getInitial()[1]];
    currentNode.setVisited(true);
    currentNode.setParent();
    nodeQueue.add(currentNode);
    while(!nodeQueue.isEmpty()){
      currentNode = nodeQueue.remove();
      if ((currentNode.getCoordinate()[0] == parser.getGoal()[0]) && (currentNode.getCoordinate()[1] == parser.getGoal()[1])){
        break;
      }
      else{
        for (Node neighbor : findPath(currentNode)){
          if (!neighbor.getVisited()){
            neighbor.setVisited(true);
            neighbor.setParent(currentNode);
            nodeQueue.add(neighbor);
          }
        }
      }
    }
  }

//grabs the shortest path by backtracking from goal node
  public void getOptimalPath(){
    Node current = nodeGrid[parser.getGoal()[0]][parser.getGoal()[1]];
    actualPath.add(current);
    while (current.getParent() != null){
      current = current.getParent().remove(0);
      actualPath.add(current);
    }

    for (Node node : actualPath){
      newGrid[node.getCoordinate()[0]][node.getCoordinate()[1]] = 'o';
    }
    newGrid[parser.getGoal()[0]][parser.getGoal()[1]] = 'g';
    newGrid[parser.getInitial()[0]][parser.getInitial()[1]] = 'i';
  }

//grab neighbors of node
  public ArrayList<Node> findPath(Node node){
    int xGoal = parser.getGoal()[0];
    int yGoal = parser.getGoal()[1];

    ArrayList<Node> neighbors = new ArrayList<Node>();
    neighbors = parser.getNeighbors(node);
    for (Node neighbor : parser.getNeighbors(node)){
      int xCurr = neighbor.getCoordinate()[0];
      int yCurr = neighbor.getCoordinate()[1];
      neighbor.setWeight(Math.sqrt(Math.pow(xGoal - xCurr, 2) + Math.pow(yGoal - yCurr, 2)));

      neighbors.add(neighbor);
    }
    return neighbors;
  }

//print path
  public void printGrid(){
    for (int i = 0; i < grid.getSize(); ++i){
      for (int j = 0; j < grid.getSize(); ++j){
        System.out.print(newGrid[i][j]);
      }
      System.out.println();
    }
  }

  public void printWeight(){
    double pathCost = 0.0;
    for (Node node : actualPath){
      pathCost += node.getWeight();
    }
    System.out.println("Total path cost for Manhattan Distance: " + pathCost);
  }
}
