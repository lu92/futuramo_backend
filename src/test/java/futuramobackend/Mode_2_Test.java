package futuramobackend;

import futuramobackend.wordProcessor.WordProcessor;
import futuramobackend.wordProcessor.WordProcessorImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class Mode_2_Test {

    private WordProcessor wordProcessor = new WordProcessorImpl();

    @Test
    public void emptyListTest() {
        // given
        List<String> emptyList = new ArrayList<>();

        // when
        List<String> result = wordProcessor.processInMode_2(emptyList);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void containsOnlyXTest() {
        // given
        List<String> words = Collections.singletonList("x");

        // when
        List<String> result = wordProcessor.processInMode_2(words);

        // then
        assertThat(result).containsExactly("0");
    }

    @Test
    public void containsSingleWordWithoutXTest() {
        // given
        List<String> words = Collections.singletonList("Agata");

        // when
        List<String> result = wordProcessor.processInMode_2(words);

        // then
        assertThat(result).containsExactly("1");
    }

    @Test
    public void containsFourWordWithoutXTest() {
        // given
        List<String> words = Arrays.asList("Agata", "Ala", "Adam", "Ala");

        // when
        List<String> result = wordProcessor.processInMode_2(words);

        // then
        assertThat(result).containsExactly("1024", "64", "256", "64");
    }

    @Test
    public void OnlyFirstWordIsWithoutX() {
        // given
        List<String> words = Arrays.asList("Agata", "ax", "bx", "x");

        // when
        List<String> result = wordProcessor.processInMode_2(words);

        // then
        assertThat(result).containsExactly("1024", "1024", "1024", "1024");
    }
}