package sinteka;

import java.util.ArrayList;
import java.util.List;

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

    public void setFirstList(ArrayList<String> firstList) {
        this.firstList = firstList;
    }

    public List<String> getSecondList() {
        return secondList;
    }

    public void setSecondList(ArrayList<String> secondList) {
        this.secondList = secondList;
    }
}
