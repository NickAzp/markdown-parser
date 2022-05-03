//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        int linkCount = 0;
        String testString = markdown;
        
        for( int i = 0; i < markdown.length(); i++) {
            if( testString.indexOf("](") != -1) {
                linkCount++;
                testString = testString.substring(testString.indexOf("](")+2, testString.length());
            }
        }

        for(int i = 0; i < linkCount; i++) {
            if (i+1 != linkCount) {
                toReturn.add(markdown.substring(markdown.indexOf("](")+2, markdown.indexOf("[", markdown.indexOf("](")+2)-3));
                markdown = markdown.substring(markdown.indexOf("](")+2, markdown.length());
            } else {
                toReturn.add(markdown.substring(markdown.indexOf("](")+2,markdown.length()-1));
            }
        }
       return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        if (content.contains("!")) {
        } else {
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
        }
    }
}
