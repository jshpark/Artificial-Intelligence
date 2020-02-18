public class Simulation{
  private int[] initialState;
  private int[] goalState;

  public Simulation(Grid grid){
    initializeStates(grid);
  }

  public void initializeStates(Grid grid){
    char[][] temp = grid.getGrid();
    for (int i = 0; i < grid.getSize(); ++i){
      for (int j = 0; j < grid.getSize(); ++j){
        if (temp[i][j] == 'i'){
          initialState = new int[]{i, j};
        }
        if (temp[i][j] == 'g'){
          goalState = new int[]{i, j};
        }
      }
    }
  }

  










  public void testStates(){
    for (int i = 0; i < 2; ++i){
      System.out.println(initialState[i]);
    }
    for (int i = 0; i < 2; ++i){
      System.out.println(goalState[i]);
    }
  }
}
