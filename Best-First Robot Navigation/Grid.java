import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Grid{
  private char[][] grid;
  private Scanner scanner;
  private File file;
  private int size;

  //constructor
  public Grid(String file){
    try{
      this.file = new File(file);
      scanner = new Scanner(this.file);
      createGrid(this.file);
    }
    catch(FileNotFoundException e){
      System.out.println("File not found. Please enter a valid text file.");
    }
  }

  //two functions to create the grid
  public void createGrid(File file){
    size = Integer.parseInt(scanner.nextLine());
    grid = new char[size][size];
    fillGrid(grid, scanner);
  }

  public void fillGrid(char[][] grid, Scanner scanner){
    int row = 0;
    int column = 0;
    while (scanner.hasNextLine()) {
      String lineData = scanner.nextLine();
      for (char cell : lineData.toCharArray()){
        grid[row][column++] = cell;
      }
      row++;
      column = 0;
    }
  }

  //accessors
  public char[][] getGrid(){
    return this.grid;
  }

  public int getSize(){
    return size;
  }






  public void testGrid(){
    for (int i = 0; i < size; ++i){
      for (int j = 0; j < size; ++j){
        System.out.print(grid[i][j]);
      }
      System.out.println();
    }
  }


}
