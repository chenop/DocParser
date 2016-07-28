import com.chenop.DocAnalyzer;
import com.chenop.models.CaseInsensitiveList;
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
        String text = "angularjs, C#, java, GUI, more unrelated stuff double word";
        CaseInsensitiveList keywords = KeywordsAnalyzeMockTest.getKeywords();

        List<String> extractKeywords = DocAnalyzer.extractKeywords(text, keywords);
        Assert.assertThat(extractKeywords.contains("AngularJS"), is(true));
        Assert.assertThat(extractKeywords.contains("C#"), is(true));
        Assert.assertThat(extractKeywords.contains("Java"), is(true));
        Assert.assertThat(extractKeywords.contains("GUI"), is(true));
        Assert.assertThat(extractKeywords.contains("stuff"), is(false));
        Assert.assertThat(extractKeywords.contains("double word"), is(true));
    }
}
