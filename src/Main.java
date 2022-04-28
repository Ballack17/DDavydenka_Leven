import sinteka.Algorithm;
import sinteka.Data;
import sinteka.InputDataParser;

import java.io.IOException;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {

        InputDataParser inputDataParser = new InputDataParser();
        Data data = inputDataParser.dataParse("C://Users//User/Desktop//DDavydenka_Levenshtein//DDavydenka_Levenshtein//input.txt");

        System.out.println(data.getFirstList());
        System.out.println(data.getSecondList());

        Algorithm algorithm = new Algorithm();
        int i = algorithm.compare("dantil", "danil");
        System.out.println(algorithm.compare("dantil", "danil"));
        System.out.println(algorithm.compare("danil", "manila)"));
    }

}
