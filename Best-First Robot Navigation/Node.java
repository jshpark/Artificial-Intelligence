public class Node implements Comparable<Node>{
  private boolean visited;
  private int[] coordinate;
  private Double weight;


  public Node(int[] coordinate){
    visited = false;
    this.coordinate = coordinate;
  }

  public void setVisited(boolean visited){
    this.visited = visited;
  }

  public boolean getVisited(){
    return visited;
  }

  public int[] getCoordinate(){
    return coordinate;
  }

  public void setWeight(double weight){
    this.weight = weight;
  }

  public Double getWeight(){
    return weight;
  }

  @Override
  public int compareTo(Node node){
    return this.getWeight().compareTo(node.getWeight());
  }

}
