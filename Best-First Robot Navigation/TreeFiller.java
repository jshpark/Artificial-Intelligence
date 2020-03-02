import java.util.*;

public class TreeFiller{
  private Tree tree;
  private int choice;
  private char[][] grid;
  

  //constructor
  public TreeFiller(Grid grid){

    this.grid = grid.getGrid();
    initializeStates(grid);
    initializeTree();
  }

  public void initializeTree(){
    tree = new Tree(initialState, calculateWeight());
  }








  public Tree getTree(){
    return tree;
  }
}
