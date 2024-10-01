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
            while ((line = reader.readLine()) != null) {
                while(line.contains("href")) {
                    int index = line.indexOf("href") + 6;
                    line = line.substring(index);
//                    System.out.println(line);
                    keywordChecker(line, "edu");
                }
            }
            reader.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }

    }

    public String scanSegment(String segment){
        int end;
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
            }
        }
        return segment;
    }

    public void keywordChecker(String segment, String keyword){
        String currentLink = scanSegment(segment);
        if(currentLink.contains(keyword)){
            System.out.println(currentLink);
        }
    }
}