import java.util.*;

public class TreeNode{
  private int[] state;
  private double weight;
  private List<TreeNode> children = null;

  public TreeNode(int[] state, double weight){
    this.state = state;
    this.weight = weight;
    children = new ArrayList<TreeNode>();
  }

  public void addChild(TreeNode node){
    children.add(node);
  }



//accessors
  public int[] getState(){
    return state;
  }

  public double getWeight(){
    return weight;
  }

  public List<TreeNode> getChildren(){
    return children;
  }

  public void printData(){
    System.out.println("X Value: " + state[0] + " Y Value: " + state[1] + " Weight: " + weight);
  }
}
