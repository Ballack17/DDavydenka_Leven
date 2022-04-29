package sinteka;

import java.util.List;


        /**
         * Формат данных (2 Листа строк), для удобной обработки
         * */
public class Data {

    private List<String> firstList;
    private List<String> secondList;

    public Data() {
    }

    public Data(List<String> firstList, List<String> secondList) {
        this.firstList = firstList;
        this.secondList = secondList;
    }

    public List<String> getFirstList() {
        return firstList;
    }

    public List<String> getSecondList() {
        return secondList;
    }
}
