import java.util.*;

public class main
{
  public static void main(String[] args) {
    Grid grid = new Grid(args[0]); //creates grid
    // TreeFiller treeFiller = new TreeFiller(grid); //creates tree
    // Simulation simulation = new Simulation(treeFiller.getTree()); //creates simulation functions



    // Parser parser = new Parser(grid);
    // parser.parseGrid();
    // Node initial = new Node(new int[]{4, 3});
    // List<Node> list = parser.getNeighbors(initial);
    // for (Node node : list){
    //   System.out.println(node.getCoordinate()[0] + ", " + node.getCoordinate()[1]);
    // }


    Simulation simulation = new Simulation(grid);
    simulation.Simulate();















    // TreeNode node = new TreeNode(0, 0, 1);
    // node.addChild(new TreeNode(1, 1, 2));
    // node.addChild(new TreeNode(2, 2, 3));
    // Tree tree = new Tree(node);
    //
    //
    // tree.testTree(node);
  }
}
