package sinteka;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InputDataParser {

    AtomicInteger counter = new AtomicInteger(0);

    public Data dataParse(String filePath) throws IOException {

        List<String> listFirst = new ArrayList<>();
        List<String> listSecond = new ArrayList<>();

        try {
            int splitter = Integer.parseInt(Files.readAllLines(Paths.get(filePath)).get(0));
            Files.readAllLines(Paths.get(filePath)).stream()
                    .forEach(s -> {
                        if (counter.get() <= splitter) {
                            listFirst.add(s.toLowerCase());
                            counter.incrementAndGet();
                        } else listSecond.add(s.toLowerCase());
                    });
        } catch (FileNotFoundException e) {
            System.out.println("is it really there?");
            e.printStackTrace();
        }

        return new Data(listFirst.subList(1, listFirst.size()),listSecond.subList(1, listSecond.size()));
    }


}
