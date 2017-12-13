package futuramobackend.wordProcessor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WordProcessorImpl implements WordProcessor {

    private final Predicate<String> beginsWithVowel = word -> "AEIOUaeiou".indexOf(word.charAt(0)) != -1;

    @Override
    public List<String> processInMode_1(List<String> words) {
        Comparator<String> wordsComparator = (firstWord, secondWord) -> {
            int diffLength = firstWord.length() - secondWord.length();
            if (diffLength == 0) {
                return firstWord.compareTo(secondWord);
            }
            return diffLength;
        };
        return words.stream().filter(beginsWithVowel).distinct().sorted(wordsComparator).collect(Collectors.toList());
    }

    @Override
    public List<String> processInMode_2(List<String> words) {
        final List<String> result = new ArrayList<>(words.size());
        BigInteger outcomeForFirstWordWithoutX = new BigInteger("0");

        for (String word : words) {
            if (word.contains("x")) {
                result.add(outcomeForFirstWordWithoutX.toString());
            } else {
                Integer sizeOfFile = new Integer(words.size());
                BigInteger outcome = new BigInteger(sizeOfFile.toString()).pow(word.length());

                result.add(outcome.toString());

                if (outcomeForFirstWordWithoutX.toString().equals("0")) {
                    outcomeForFirstWordWithoutX = new BigInteger(sizeOfFile.toString()).pow(word.length());
                }
            }
        }
        return result;
    }
}
