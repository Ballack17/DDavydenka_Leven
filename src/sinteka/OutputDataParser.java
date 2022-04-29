package sinteka;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OutputDataParser {

    /**
     * Обработчик исходящих данных, используя данные сравнения сохраняет информацию в файл заданным способом
     * */
    public void saveToFile(FileWriter fileWriter, Map<Integer, Integer> result, Data data) {

        try (PrintWriter printWriter = new PrintWriter(fileWriter);) {
            Set<Integer> usedLeft = new HashSet<>();
            for (int i = 0; i < data.getFirstList().size(); i++) {
                Integer value = result.get(i);
                String x = data.getFirstList().get(i);
                String y = "?";
                if (value != null) {
                    usedLeft.add(value);
                    y = data.getSecondList().get(value);
                }
                printWriter.printf("%s:%s\n", x, y);
            }
            for (int j = 0; j < data.getSecondList().size(); j++) {
                if (!usedLeft.contains(j)) {
                    printWriter.printf("%s:?\n", data.getSecondList().get(j));
                }
            }
        }
    }
}
