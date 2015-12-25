import com.chenop.db.DBHelper;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;

/**
 * Created by Chen on 20/12/2015.
 */
public class DBHelperTests {

    @Test
    public void connectionTest() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/Chen/My Projects/DocParser/database/docparser.db");
            Assert.assertNotNull(connection);

            Statement statement = connection.createStatement();
            Assert.assertNotNull(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getKeywordsTest() {
        TreeSet<String> keywords = DBHelper.INSTANCE.getKeywords();

        Assert.assertNotNull(keywords);
        Assert.assertThat(keywords.isEmpty(), is(false));
        Assert.assertThat(keywords.contains("AngularJS"), is(true));
    }
}
