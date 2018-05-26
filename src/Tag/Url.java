package Tag;

import javax.servlet.jsp.tagext.*;
import java.io.*;

public class Url extends SimpleTagSupport {

    private Integer id;

    /**
     * Set url id
     * @param id Integer
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Process tag method
     * @throws IOException
     */
    public void doTag()
        throws IOException
    {
        Model.Url url = new Model.Url();
        url.find(this.id);
        getJspContext().getOut().println(this.getHtml(url));
    }

    /**
     * Get tag html
     * @param url Model.Url
     * @return String
     */
    private String getHtml(Model.Url url)
    {
        String html = "<div>Url de base : " + url.getBaseUrl() + "</div>";
        html += "<div>Url raccourcie : " + url.getShortcutUrl() + "</div>";

        return html;
    }
}
