import java.util.*;

public class Simulation{
  private int choice;
  private Grid grid;

  public Simulation(Grid grid){
    this.grid = grid;
    initializeChoice();
  }

  public void initializeChoice(){
    Scanner scanner = new Scanner(System.in);
    printChoices();
    this.choice = scanner.nextInt();
  }

  public void printChoices(){
    System.out.println("Which evaluation function would you like to use?");
    System.out.println("Please enter the number corresponding to the choice.");
    System.out.println("Input '1' for choice 1) Euclidean Distance.");
    System.out.println("1) Euclidean Distance");
    System.out.println("2) Manhattan Distance");
    System.out.println("3) g(N) + h(N) using Euclidean Distance");
    System.out.println("4) g(N) + h(N) using Manhattan Distance");
  }

  public void Simulate(){
    switch (choice) {
      case 1:
      EuclideanFringe euclidean = new EuclideanFringe(grid);
      euclidean.traverse();
      euclidean.getOptimalPath();
      euclidean.printGrid();
      euclidean.printWeight();
      break;
      case 2:
      ManhattanFringe manhattan = new ManhattanFringe(grid);
      manhattan.traverse();
      manhattan.getOptimalPath();
      manhattan.printGrid();
      manhattan.printWeight();
      break;
      case 3:
      AStarEucDistan aStarEuclidean = new AStarEucDistan(grid);
      aStarEuclidean.traverse();
      aStarEuclidean.getOptimalPath();
      aStarEuclidean.printGrid();
      aStarEuclidean.printWeight();
      break;
      case 4:
      AStarManDistan aStarManhattan = new AStarManDistan(grid);
      aStarManhattan.traverse();
      aStarManhattan.getOptimalPath();
      aStarManhattan.printGrid();
      aStarManhattan.printWeight();
      break;
      default:
      System.out.println("Invalid choice entered. System will break.");
      break;
    }
  }

















}
