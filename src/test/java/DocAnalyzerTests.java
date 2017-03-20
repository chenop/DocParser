import com.chenop.DocAnalyzer;
import com.chenop.models.CaseInsensitiveList;
import org.junit.Assert;
import org.junit.Test;

import java.io.Console;
import java.util.List;

import static org.hamcrest.core.Is.is;

/**
 * Created by Chen.Oppenhaim on 12/20/2015.
 */
public class DocAnalyzerTests {

    @Test
    public void keywordsAnalyzerIgnoreCaseTest() {
        String text = "angularjs, C#, java, GUI, more unrelated stuff double word";
        CaseInsensitiveList keywords = MockHelper.getKeywords();

        List<String> extractKeywords = DocAnalyzer.extractKeywords(text, keywords);
        Assert.assertThat(extractKeywords.contains("AngularJS"), is(true));
        Assert.assertThat(extractKeywords.contains("C#"), is(true));
        Assert.assertThat(extractKeywords.contains("Java"), is(true));
        Assert.assertThat(extractKeywords.contains("GUI"), is(true));
        Assert.assertThat(extractKeywords.contains("stuff"), is(false));
        Assert.assertThat(extractKeywords.contains("double word"), is(true));
    }

	@Test
	public void emailAnalyzeTest1() {
		String text = MockHelper.getTextContainingEmail1();
		String result = DocAnalyzer.extractEmail(text);

		Assert.assertNotNull(result);
		System.out.println(result);
	}

	@Test
	public void emailAnalyzeTest2() {
		String text = MockHelper.getTextContainingEmail2();
		String result = DocAnalyzer.extractEmail(text);

		Assert.assertNotNull(result);
		System.out.println(result);
	}

	@Test
	public void emailAnalyzeTest3() {
		String text = MockHelper.getTextNotContainingEmail();
		String result = DocAnalyzer.extractEmail(text);

		Assert.assertNull(result);
		System.out.println(result);
	}
}
