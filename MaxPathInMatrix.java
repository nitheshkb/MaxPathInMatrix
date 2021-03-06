import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: nbeeri
 * Date: 06/03/21
 */

public class MaxPathInMatrix {
    static int mat[][] = {{1, 2, 9},
            {5, 3, 8},
            {4, 6, 7}
    };
    static int N = mat[0].length;

//123
//23
//9
//5
//3
//89
//45
//6789
//789
    public static void main(String[] args) {
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ArrayList trackPath = new ArrayList<Integer>();
                recursiveLogic(i, j, trackPath);
                //find max length of track path
                if (maxLength < trackPath.size())
                    maxLength = trackPath.size();
            }
        }
        System.out.println("Output :" + maxLength);
    }

    private static void recursiveLogic(int i, int j, List trackPath) {
        //base , bound check
        if (i > N - 1 || j > N - 1 || i < 0 || j < 0) {
            return;
        }
        int currentElement = mat[i][j];
        trackPath.add(currentElement);
        //Increment column
        if (j + 1 < N) {
            int nextElement = mat[i][j + 1];
            if (currentElement + 1 == nextElement)
                recursiveLogic(i, j + 1, trackPath);
        }
        //decrement column
        if (j - 1 >= 0) {
            int nextElement = mat[i][j - 1];
            if (currentElement + 1 == nextElement)
                recursiveLogic(i, j - 1, trackPath);
        }
        //Increment row
        if (i + 1 < N) {
            int nextElement = mat[i + 1][j];
            if (currentElement + 1 == nextElement)
                recursiveLogic(i + 1, j, trackPath);
        }

        //decrement row
        if (i - 1 >= 0) {
            int nextElement = mat[i - 1][j];
            if (currentElement + 1 == nextElement)
                recursiveLogic(i - 1, j, trackPath);
        }
    }
}
