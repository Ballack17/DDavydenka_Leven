import sinteka.Algorithm;
import sinteka.Data;
import sinteka.InputDataParser;
import sinteka.OutputDataParser;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {

        /**Класс обработки входящих данных*/
        InputDataParser inputDataParser = new InputDataParser();

        /**Класс обработки исходящих данных*/
        OutputDataParser outputDataParser = new OutputDataParser();

        /**Алгоритм сравнения*/
        Algorithm algorithm = new Algorithm();

        /**сохранение в папку с проектом*/
        FileWriter fileWriter = new FileWriter("output.txt");

        /**
         * Распарсивание входящих данных для обработчика
         * Введите свойпуть к файлу с данными
         * */
        Data data = inputDataParser.dataParse("ВАШ ПУТЬ ДО ФАЙЛА - input.txt");

        /**В исходящий парсер передаём результат работы алгоритма и исходник*/
        outputDataParser.saveToFile(fileWriter, algorithm.allInOne(data), data);
    }

}
