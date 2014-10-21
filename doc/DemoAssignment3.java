import java.io.*;
import java.util.*;

public class DemoAssignment3 {

   private String[] matrix;

   public DemoAssignment3 (String[] m) {
      matrix = m;
   }

   public static void main(String[] args) throws IOException {

      Scanner scanner = new Scanner(new File ("demo.dat"));

      int rows = scanner.nextInt();
      int columns = scanner.nextInt();
      String skip = scanner.nextLine();
      String[] grid = new String[rows];

      for (int r = 0; r < rows; r++)
         grid[r] = scanner.nextLine();

      DemoAssignment3 myDemo = new DemoAssignment3(grid);

      System.out.print(myDemo);
   }

   // String representation of the Demo object
   public String toString() {
      StringBuffer buf = new StringBuffer();

      for (int r = 0; r < matrix.length; r++) {
         buf.append(matrix[r] + '\n');
      }
      return buf.toString();
   }

}

