package Model;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.Arrays;

public class Url extends ModelAbstract
{
    private String baseUrl;
    private String shortcutUrl;
    private String password;

    public Url() {
        this.tableName = "urls";
        this.fields = new ArrayList<String>(Arrays.asList("id", "baseUrl", "shortcutUrl", "password"));
    }

    public ArrayList getValues() {
        return new ArrayList<String>(Arrays.asList("'" + this.baseUrl + "'", "'" + this.shortcutUrl + "'", "'" + this.password + "'"));
    }

    public Url shortUrl() {
        this.shortcutUrl = Helper.Url.shortUrl();

        return this;
    }

    public Url setId(Integer id) {
        this.id = id;

        return this;
    }

    public Url setBaseUrl(String url) {
        this.baseUrl = url;

        return this;
    }

    public Url setShortcutUrl(String url) {
        this.shortcutUrl = url;

        return this;
    }

    public Url setPassword(String password) {
        this.password = password;

        return this;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getShortcutUrl() throws NamingException
    {
        InitialContext ic = new InitialContext();
        String baseDomain = (String) ic.lookup("java:comp/env/app/domain");

        return baseDomain + this.shortcutUrl;
    }
}
