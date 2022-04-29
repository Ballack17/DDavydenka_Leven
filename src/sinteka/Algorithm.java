package sinteka;

import java.util.*;


    /**В основе своей используем алгоритм Левенштейна*/
public class Algorithm {

    /**для удобства выбора минимально значения*/
    public int getMin(int... neighbours) {
        return Arrays.stream(neighbours).min().orElse(Integer.MAX_VALUE);
    }

    /**
     * стоимость замены Буквы
     * */
    public int isEqualChars (char left, char right) {
        return left == right ? 0 : 2;
    }

    /**
     * Сравниваем два слова, либо слово со строкой, возвращаем "стоимость разницы", чем меньше - тем более похожи данные
     * */
    public int compare(String stringLeft, String stringRight) {
        int[][] matrix = new int[stringLeft.length()+1][stringRight.length()+1];
        for (int i = 0; i <= stringLeft.length(); i++) {
            for (int j = 0; j <= stringRight.length(); j++) {
                if (i == 0) {matrix[i][j]  = j;}
                else if (j == 0) {matrix[i][j] = i;}
                else {
                    matrix[i][j] = getMin(
                        matrix[i-1][j] + 1,
                        matrix[i][j-1] + 1,
                        matrix[i-1][j-1] + isEqualChars(stringLeft.charAt(i-1), stringRight.charAt(j-1))
                );
                    }
                }
            }
        return matrix[stringLeft.length()][stringRight.length()];
        }

    /**
     * строим матрицу "стоимостей разницы"
     * */
    public int[][] compareLists(Data data) {
            int[][] compareMatrixResult = new int[data.getFirstList().size()][data.getSecondList().size()];
            for (int i = 0; i < data.getFirstList().size(); i++) {
                for (int j = 0; j < data.getSecondList().size(); j++) {
                    /**
                     * важный момент, если в обеих строках больше одого слова, то нам надо их разбить на 2 List<String>
                     * и уже для них ещё раз вызвать ментод подсчета "стоимости разницы"
                     * */
                    if (data.getFirstList().get(i).split(" ").length < 2 || data.getSecondList().get(j).split(" ").length <2) {
                        compareMatrixResult[i][j] = compare(data.getFirstList().get(i), data.getSecondList().get(j));
                    } else compareMatrixResult[i][j] = sumCompare(data.getFirstList().get(i), data.getSecondList().get(j));
                }
            }
            return compareMatrixResult;
    }
    /**
     * Так как фразы "Дом из кирпича" и "Кирпичный Дом" похожи, но обычное сравнение строк покажет очень сильную "стоимость разницы"
     * Нам надо сделать отдельную матрицы подсчета для Фраз, и затем сложить все минимальные разницы по каждой строке,
     * То есть по итогу мы возьмём "стоимость разницы" от пар: Дом и Дом, Кирпича и Кирпичный, что гораздо меньше, если бы мы считали разницу целых строк
     * Есть зависимость - если первая фраза короче, то и разница будет короче, нивелируем это -
     * Подсчитали первый вариант, затем, если Размеры листов разные, то транспонируем матрицу, считаем сумму и общий результат делим пополам.
     * */
    public int sumCompare(String stringLeft, String stringRight) {
        int sumByPhrase = 0;
        List<String> stringsLeftList = Arrays.stream(stringLeft.split(" ")).toList();
        List<String> stringsRightList = Arrays.stream(stringRight.split(" ")).toList();
        int[][] subResult = compareLists(new Data(stringsLeftList, stringsRightList));
        for (int[] ints : subResult) {
            sumByPhrase += Arrays.stream(ints).min().orElse(Integer.MAX_VALUE);
        }
        if (stringsLeftList.size() != stringsRightList.size()) {
            int[][] subResultTransparent = new int[stringsRightList.size()][stringsLeftList.size()];
            for (int i = 0; i < stringsRightList.size(); i++) {
                for (int j = 0; j < stringsLeftList.size(); j++) {
                    subResultTransparent[i][j] = subResult[j][i];
                }
            }
            for (int[] ints : subResultTransparent) {
                sumByPhrase += Arrays.stream(ints).min().orElse(Integer.MAX_VALUE);
            }
            return sumByPhrase / 2;
        } else return sumByPhrase;
    }

    /**Ищем координаты пар с минимальной стоимостью*/
    public int[] findMinForResult(int[][] compareMatrixResult, List<Integer> usedLeft, List<Integer> usedRight) {
        int minVal = Integer.MAX_VALUE;
        int minLeft = -1;
        int minRight = -1;
        for (int i = 0; i < compareMatrixResult.length; i++) {
            for (int j = 0; j < compareMatrixResult[i].length; j++) {
                if (!usedLeft.contains(i) && !usedRight.contains(j) && compareMatrixResult[i][j] < minVal) {
                    minVal = compareMatrixResult[i][j];
                    minLeft = i;
                    minRight = j;
                }
            }
        }
        return new int[]{minLeft, minRight};
    }

    /** итоговый метод, который создаёт карту соответствий по индексам */
    public Map<Integer, Integer> finalResult(int[][] compareMatrixResult) {
        List<Integer> usedLeft = new ArrayList<>();
        List<Integer> usedRight = new ArrayList<>();
        while (usedLeft.size() < compareMatrixResult.length && usedRight.size() < compareMatrixResult[0].length) {
            int[] coords = findMinForResult(compareMatrixResult, usedLeft, usedRight);
            usedLeft.add(coords[0]);
            usedRight.add(coords[1]);
        }
                Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < usedLeft.size(); i++) {
            result.put(usedLeft.get(i), usedRight.get(i));
        }
        return result;
    }

    /**упрощение цепочки, чтобы в мейне вызывать только 1 метод*/
    public Map<Integer, Integer> allInOne(Data data) {
        return finalResult(compareLists(data));
    }
}
