import java.util.*;

public class Tree{
  private TreeNode root;

  public Tree(TreeNode root){
    this.root = root;
  }

  

  public void postOrderTraversal(TreeNode node){
    for (TreeNode each : node.getChildren()){
      postOrderTraversal(each);
    }
    node.printData();
  }
}
