import com.chenop.KeywordsAnalyzer;
import org.junit.Assert;
import org.junit.Test;

import java.util.TreeSet;

import static org.hamcrest.core.Is.is;

/**
 * Created by Chen.Oppenhaim on 12/20/2015.
 */
public class KeywordsAnalyzerTests {

    @Test
    public void keywordsAnalyzerIgnoreCaseTest() {
        String text = "angularjs, C#, java, GUI, more unrelated stuff";

        TreeSet<String> keywords = KeywordsAnalyzer.extractKeywords(text);
        Assert.assertThat(keywords.contains("AngularJS"), is(true));
        Assert.assertThat(keywords.contains("C#"), is(true));
        Assert.assertThat(keywords.contains("Java"), is(true));
        Assert.assertThat(keywords.contains("GUI"), is(true));
        Assert.assertThat(keywords.contains("stuff"), is(false));
    }
}
