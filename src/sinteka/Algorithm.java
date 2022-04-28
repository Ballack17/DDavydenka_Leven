package sinteka;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Algorithm {

    public int getMin(int... neighbours) {
        return Arrays.stream(neighbours).min().orElse(1000);
    }

    public int isEqualChars (char left, char right) {
        return left == right ? 0 : 1;
    }

    public int compare(String stringLeft, String stringRight) {
        int[][] matrix = new int[stringLeft.length()+1][stringRight.length()+1];
        int difference = 0;
        for (int i = 0; i < stringLeft.length(); i++) {
            for (int j = 0; j < stringRight.length(); j++) {
                if (i == 0) {matrix[i][j]  = j;}
                else if (j==0) {matrix[i][j] = i;}
                else { matrix[i][j] = getMin(
                        matrix[i-1][j] + 1,
                        matrix[i][j-1] + 1,
                        matrix[i][j] + isEqualChars(stringLeft.charAt(i), stringRight.charAt(j))
                );
                    }
                }
            }
        return matrix[stringLeft.length()][stringRight.length()];
        }
        //        int[][] dp = new int[x.length() + 1][y.length() + 1];
//
//        for (int i = 0; i <= x.length(); i++) {
//            for (int j = 0; j <= y.length(); j++) {
//                if (i == 0) { // Первые строка и столбец
//                    dp[i][j] = j;
//                } else if (j == 0) {
//                    dp[i][j] = i;
//                } else {
//                    dp[i][j] = min( // Минимум по диагонали, слева и справа
//                            dp[i - 1][j - 1] + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)),
//                            dp[i - 1][j] + 1,
//                            dp[i][j - 1] + 1
//                    );
//                }
//            }
//        }
//
//        return dp[x.length()][y.length()];
//    }
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

    public Map<Integer, Integer> finalResult(int[][] compareListResult, Data data) {
        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < data.getFirstList().size(); i++) {
            for (int j = 0; j < data.getSecondList().size(); j++) {

            }
        }


        return null;
    }


}
