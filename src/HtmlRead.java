import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

// When it works, we should be able to see all three links in this line...
// https://www.milton.edu">Milton Academy</a> | 170 Centre Street, Milton MA 02186 | 617-898-1798 | <a href="https://www.milton.edu/about/privacy-policy">Privacy Policy</a> | <a href="https://www.milton.edu/about/nondiscrimination-policy">Nondiscrimination Policy</a></div>					</div>

public class HtmlRead {

    public static void main(String[] args) {
        HtmlRead html = new HtmlRead();
    }

    public HtmlRead() {

        try {
            System.out.println();
            System.out.print("hello \n");
            URL url = new URL("https://www.milton.edu/");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );
            String line;
            line = reader.readLine();
            int snippet_index = 0;
            while ((line = reader.readLine()) != null) {
                while(line.contains("href")) {
                    int index = line.indexOf("href") + 6;
                    line = line.substring(index);
//                    System.out.println(line);
                    scanSegment(line);
                }
            }
            reader.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }

    }

    public void scanSegment(String segment){
        int end = -1;
//        int end = segment.indexOf(" ");
//        if (end != -1) {
//            segment = segment.substring(0, end);
//        }
        end = segment.indexOf("\"");
        if (end != -1){
            segment = segment.substring(0, end);
        } else {
            end = segment.indexOf("'");
            if (end != -1) {
                segment = segment.substring(0, end);
            } else {

            }
        }
        System.out.println(segment);
    }
}