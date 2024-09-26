import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

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
            while ( (line = reader.readLine()) != null ) {
                if(line.contains("https")) {
                    int index = line.indexOf("https");
                    String link = line.substring(index);
                    int end = link.indexOf(" ");
                    link = link.substring(0, end);
                    end = link.indexOf("\"");
                    if (end != -1){
                        link = link.substring(0, end);
                    }
                    end = link.indexOf("'");
                    if(end != -1){
                        link = link.substring(0, end);
                    }
                    System.out.println(link);
                }
            }
            reader.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }

    }

}
