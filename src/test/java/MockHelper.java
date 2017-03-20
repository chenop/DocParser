import com.chenop.models.CaseInsensitiveList;

import java.util.Arrays;

/**
 * Created by Chen on 28/07/2016.
 */
public class MockHelper {
    public static CaseInsensitiveList getKeywords() {
        return new CaseInsensitiveList(Arrays.asList("AngularJS", "C#", "Java", "GUI", "double word"));
    }

	public static String getTextContainingEmail1() {
		return "aaasdasdasd hsfsdfd chenop@gmail.com aaaaa web angular";
	}

	public static String getTextContainingEmail2() {
		return "aaasdasdasd hsfsdfd chenop.trash@gmail.com aaaaa web angular";
	}

	public static String getTextNotContainingEmail() {
		return "aaasdasdasd hsfsdfd aaaaa web angular";
	}
}
