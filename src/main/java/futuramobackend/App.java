package futuramobackend;

import futuramobackend.wordProcessor.WordProcessor;
import futuramobackend.wordProcessor.WordProcessorImpl;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;

public class App {


    static WordProcessor wordProcessor = new WordProcessorImpl();

    public static void main(String[] args) throws Exception {
        File file = new File(App.class.getClassLoader().getResource("words.txt").getFile());
        List<String> words = FileUtils.readLines(file);

        System.out.println("Mode 1");
        wordProcessor.processInMode_1(words).forEach(System.out::println);
        System.out.println("\nMode 2");
        wordProcessor.processInMode_2(words).forEach(System.out::println);
    }
}
