import com.chenop.DocAnalyzer;
import com.chenop.ParserManager;
import com.chenop.models.CVData;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.core.Is.is;

/**
 * Created by Chen.Oppenhaim on 12/19/2015.
 */
public class ParserTests {

	public static final String DOCX_FILE_PATH = "netali.docx";
	public static final String DOC_FILE_PATH = "word97.doc";

	@Test
	public void parsingDocxShouldGetTextTest() throws IOException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(DOCX_FILE_PATH);

		String text = ParserManager.parse(inputStream);

		System.out.println(text);
		Assert.assertThat(text.isEmpty(), is(false));
	}

	@Test
	public void parsingDocShouldGetTextTest() throws IOException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(DOC_FILE_PATH);

		String text = ParserManager.parse(inputStream);

		System.out.println(text);
		Assert.assertThat(text.isEmpty(), is(false));
	}

	@Test
	public void extractCVDataTest() throws IOException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(DOCX_FILE_PATH);

		String text = ParserManager.parse(inputStream);
		CVData cvData = DocAnalyzer.extractCVData(text);

		Assert.assertTrue(cvData.getKeywords().contains("מזכירה"));
	}


}
