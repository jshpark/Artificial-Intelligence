import java.util.*;

public class Parser{
  private int[] initialState;
  private int[] goalState;
  private Grid grid;
  private Node[][] nodeGrid;
  private int size;


  public Parser(Grid grid){
    this.grid = grid;
    size = grid.getSize();
    initializeStates();
    parseGrid();
  }

  public ArrayList<Node> getAllNeighbors(Node node){
    ArrayList<Node> list = new ArrayList<Node>();
    int x = node.getCoordinate()[0];
    int y = node.getCoordinate()[1];

    for (int i = x - 1; i <= x + 1; ++i){
      for (int j = y - 1; j <= y + 1; ++j){
        if (i >= 0 && j >= 0 && i < size && j < grid.getGrid()[i].length){
          if (i != x && j != y){
            list.add(nodeGrid[i][j]);
          }
        }
      }
    }
    return list;
  }


  public ArrayList<Node> getNeighbors(Node node){
    ArrayList<Node> list = new ArrayList<Node>();
    int x = node.getCoordinate()[0];
    int y = node.getCoordinate()[1];

    if (x == 0){ //top row
      if (y == 0){ // top left corner
        if (nodeGrid[x + 1][y] != null){ //south
          list.add(nodeGrid[x + 1][y]);
        }
        if (nodeGrid[x][y + 1] != null){ //east
          list.add(nodeGrid[x][y + 1]);
        }
      }
      else if (y == size - 1){ //top right corner
        if (nodeGrid[x + 1][y] != null){
          list.add(nodeGrid[x + 1][y]);
        }
        if (nodeGrid[x][y - 1] != null){
          list.add(nodeGrid[x][y - 1]);
        }
      }
      else{ //top row
        if (nodeGrid[x + 1][y] != null){ //south
          list.add(nodeGrid[x + 1][y]);
        }
        if (nodeGrid[x][y + 1] != null){ //east
          list.add(nodeGrid[x][y + 1]);
        }
        if (nodeGrid[x][y - 1] != null){
          list.add(nodeGrid[x][y - 1]);
        }
      }
    }
    else if (x == size - 1){ //bottom row
      if (y == 0){ // bottom left corner
        if (nodeGrid[x - 1][y] != null){ //north
          list.add(nodeGrid[x - 1][y]);
        }
        if (nodeGrid[x][y + 1] != null){ //east
          list.add(nodeGrid[x][y + 1]);
        }
      }
      else if (y == size - 1){ //bottom right corner
        if (nodeGrid[x - 1][y] != null){ //north
          list.add(nodeGrid[x - 1][y]);
        }
        if (nodeGrid[x][y - 1] != null){ //west
          list.add(nodeGrid[x][y - 1]);
        }
      }
      else{ //bottom row
        if (nodeGrid[x - 1][y] != null){ //north
          list.add(nodeGrid[x - 1][y]);
        }
        if (nodeGrid[x][y + 1] != null){ //east
          list.add(nodeGrid[x][y + 1]);
        }
        if (nodeGrid[x][y - 1] != null){ //west
          list.add(nodeGrid[x][y - 1]);
        }
      }
    }
    else if (y == 0){ //left column
      if (nodeGrid[x + 1][y] != null){ //south
        list.add(nodeGrid[x + 1][y]);
      }
      if (nodeGrid[x - 1][y] != null){ //north
        list.add(nodeGrid[x - 1][y]);
      }
      if (nodeGrid[x][y + 1] != null){ //east
        list.add(nodeGrid[x][y + 1]);
      }
    }
    else if (y == size - 1){ //right column
      if (nodeGrid[x + 1][y] != null){ //south
        list.add(nodeGrid[x + 1][y]);
      }
      if (nodeGrid[x - 1][y] != null){ //north
        list.add(nodeGrid[x - 1][y]);
      }
      if (nodeGrid[x][y - 1] != null){ //west
        list.add(nodeGrid[x][y - 1]);
      }
    }
    else{ //in the middle
      if (nodeGrid[x + 1][y] != null){ //south
        list.add(nodeGrid[x + 1][y]);
      }
      if (nodeGrid[x - 1][y] != null){ //north
        list.add(nodeGrid[x - 1][y]);
      }
      if (nodeGrid[x][y - 1] != null){ //west
        list.add(nodeGrid[x][y - 1]);
      }
      if (nodeGrid[x][y + 1] != null){ //east
        list.add(nodeGrid[x][y + 1]);
      }
    }
    return list;
  }




  public void parseGrid(){
    nodeGrid = new Node[size][size];
    for (int i = 0; i < size; ++i){
      for (int j = 0; j < size; ++j){
        if (grid.getGrid()[i][j] == '+'){
          nodeGrid[i][j] = null;
        }
        else{
          nodeGrid[i][j] = new Node(new int[]{i, j});
        }
      }
    }
  }

  public Node[][] getNodeGrid(){
    return nodeGrid;
  }


  public void initializeStates(){
    char[][] temp = grid.getGrid();
    for (int i = 0; i < size; ++i){
      for (int j = 0; j < size; ++j){
        if (temp[i][j] == 'i'){
          initialState = new int[]{i, j};
        }
        if (temp[i][j] == 'g'){
          goalState = new int[]{i, j};
        }
      }
    }
  }

  public int[] getInitial(){
    return initialState;
  }

  public int[] getGoal(){
    return goalState;
  }
}
