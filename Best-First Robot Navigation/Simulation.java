import java.util.*;

public class Simulation{
  private Tree tree;
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
      euclidean.printGrid();
      break;
      case 2:

      break;
      case 3:

      break;
      case 4:

      break;
      default:
      System.out.println("Invalid choice entered. System will break.");
      break;
    }
  }

















}
