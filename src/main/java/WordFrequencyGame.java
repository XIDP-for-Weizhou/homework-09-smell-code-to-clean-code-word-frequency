import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Created by jxzhong on 2018/5/22.
 */
public class WordFrequencyGame {
    public String getResult(String inputStr) {
        try {
            List<Input> inputList = getInputList(inputStr);
            sortInputList(inputList);
            return getResultString(inputList);
        } catch (
                Exception e) {
            return "Calculate Error";
        }
    }

    private static String getResultString(List<Input> inputList) {
        StringJoiner joiner = new StringJoiner("\n");
        for (Input w : inputList) {
            String s = w.getValue() + " " + w.getWordCount();
            joiner.add(s);
        }
        return joiner.toString();
    }

    private static List<Input> getInputList(String inputStr) {
        List<String> allSingleWord = Arrays.stream(inputStr.split("\\s+")).distinct().collect(Collectors.toList());
        List<Input> inputList = new ArrayList<>();

        for (String word : allSingleWord) {
            int count = (int) Arrays.stream(inputStr.split("\\s+")).filter(n -> n.equals(word)).count();
            Input input = new Input(word, count);
            inputList.add(input);
        }
        return inputList;
    }

    private static void sortInputList(List<Input> inputList) {
        inputList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());
    }
}
