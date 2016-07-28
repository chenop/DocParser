import com.chenop.models.CaseInsensitiveList;

import java.util.Arrays;

/**
 * Created by Chen on 28/07/2016.
 */
public class KeywordsAnalyzeMockTest {
    public static CaseInsensitiveList getKeywords() {
        return new CaseInsensitiveList(Arrays.asList("AngularJS", "C#", "Java", "GUI", "double word"));
    }
}
