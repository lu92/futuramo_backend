package futuramobackend;


import futuramobackend.wordProcessor.WordProcessor;
import futuramobackend.wordProcessor.WordProcessorImpl;
import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class Mode_1_Test {

    private WordProcessor wordProcessor = new WordProcessorImpl();

    @Test
    public void emptyListTest() {
        // given
        List<String> words = new ArrayList<>();

        // when
        List<String> result = wordProcessor.processInMode_1(words);

        // then
        Assertions.assertThat(result).isEmpty();
    }


    @Test
    public void shouldSortWordsAlphabeticallyTest() {
        // given
        List<String> words = Arrays.asList("Anna", "Alan", "Alax");

        // when
        List<String> result = wordProcessor.processInMode_1(words);

        // then
        Assertions.assertThat(result).containsExactly("Alan", "Alax", "Anna");
    }

    @Test
    public void shouldSortByLengthTest() {
        // given
        List<String> words = Arrays.asList("Alicja", "Alina", "Anna", "Alan", "Alax");

        // when
        List<String> result = wordProcessor.processInMode_1(words);

        // then
        Assertions.assertThat(result).containsExactly("Alan", "Alax", "Anna", "Alina", "Alicja");
    }

    @Test
    public void shouldDiscardDuplicatesTest() {
        // given
        List<String> words = Arrays.asList("Anna", "Alan", "Anna", "Alan", "Alan");

        // when
        List<String> result = wordProcessor.processInMode_1(words);

        // then
        Assertions.assertThat(result).containsExactly("Alan", "Anna");
    }

    @Test
    public void shouldContainWordsBeginningWithNovelTest() {
        // given
        List<String> words = Arrays.asList("Anna", "Elan", "Inna", "Olan", "Ulan", "B", "D");

        // when
        List<String> result = wordProcessor.processInMode_1(words);

        // then
        Assertions.assertThat(result).containsExactly("Anna", "Elan", "Inna", "Olan", "Ulan");
    }


    @Test
    public void shouldTest() {
        // given
        List<String> words = Arrays.asList("Lucjan", "Marcin", "Anna", "Beata", "Alan", "Agata", "Agata");

        // when
        List<String> result = wordProcessor.processInMode_1(words);

        // then
        Assertions.assertThat(result).containsExactly("Alan", "Anna", "Agata");
    }

}
