package sinteka;

public class Algorithm {

    public static int compare(String stringLeft, String stringRight) {
        int[][] matrix = new int[stringLeft.length()][stringRight.length()];
        int difference = 0;
        for (int i = 0; i < stringLeft.length(); i++) {
            for (int j = 0; j < stringRight.length(); j++) {
                if (stringLeft.charAt(i) == stringRight.charAt(j)) {
                    if (i != 0 && j != 0)
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    else
                        matrix[i][j] = 1;
                    if (matrix[i][j] > difference) {
                        difference = matrix[i][j];
                    }
                }
            }
        }
        return difference;
    }

    public int[][] compareLists(Data data) {
        int[][] result = new int [data.getFirstList().size()][data.getSecondList().size()];
        for (int i = 0; i < data.getFirstList().size(); i++) {
            for (int j = 0; j < data.getSecondList().size(); j++) {
                result[i][j] = compare(data.getFirstList().get(i), data.getSecondList().get(j));
            }
        }
        return result;
    }



}
