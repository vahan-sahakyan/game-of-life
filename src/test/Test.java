package test;

public class Test {
  public static void main(String[] args) {
    int row = 0;
    int col = 0;

    int rows = 10;
    int columns = 10;

    for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
      for (int colOffset = -1; colOffset <= 1; colOffset++) {
        if (rowOffset == 0 && colOffset == 0) {
          continue;
        }

        int gridRow = row + rowOffset;
        int gridCol = col + colOffset;

        if (gridRow < 0) {
          continue;
        } else if (gridRow == rows) {
          continue;
        }
        if (gridCol < 0) {
          continue;
        } else if (gridCol == columns) {
          continue;
        }

        System.out.println(gridRow + ", " + gridCol);

      }
    }
  }
}
