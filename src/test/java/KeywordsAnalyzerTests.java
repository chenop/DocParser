import com.chenop.DocAnalyzer;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;

/**
 * Created by Chen.Oppenhaim on 12/20/2015.
 */
public class KeywordsAnalyzerTests {

    @Test
    public void keywordsAnalyzerIgnoreCaseTest() {
        String text = "angularjs, C#, java, GUI, more unrelated stuff";

        List<String> keywords = DocAnalyzer.extractKeywords(text);
        Assert.assertThat(keywords.contains("AngularJS"), is(true));
        Assert.assertThat(keywords.contains("C#"), is(true));
        Assert.assertThat(keywords.contains("Java"), is(true));
        Assert.assertThat(keywords.contains("GUI"), is(true));
        Assert.assertThat(keywords.contains("stuff"), is(false));
    }
}
