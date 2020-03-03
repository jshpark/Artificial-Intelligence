import java.util.*;

public class main
{
  public static void main(String[] args) {
    Grid grid = new Grid(args[0]);

    Simulation simulation = new Simulation(grid);
    simulation.Simulate();
  }
}
