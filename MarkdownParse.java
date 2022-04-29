//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        int currentIndex = 0;
        int PreviousIndex = 0;
        int iteration = 1;
        for(int i = 0; i < markdown.length()-1; i++) {
            if((markdown.charAt(i)+""+markdown.charAt(i+1)).equals("](")) {
                PreviousIndex = i+2;
                for(int j = PreviousIndex; j < markdown.length()-3; j++) {
                    int condition = 1;
                    if((condition == -1) && (markdown.charAt(j)+""+markdown.charAt(j+3)).equals(")[") || ((markdown.charAt(j+3) == (')')) && (j+4 == markdown.length()))) {
                        condition = -1;
                        currentIndex = j+3;
                        System.out.println(PreviousIndex);
                        System.out.println(currentIndex);
                        toReturn.add(markdown.substring(PreviousIndex, currentIndex));
                    }
                }
            }
        }
        /*
        // find the next [, then find the ], then find the (, then read link upto next )
        while(currentIndex < markdown.indexOf(")",markdown.length()-2)) {
            PreviousIndex = markdown.indexOf("](", currentIndex);
            if(markdown.indexOf(")", currentIndex) - markdown.indexOf("[", currentIndex) == -3) {
                currentIndex = markdown.indexOf("[", PreviousIndex);
                toReturn.add(markdown.substring(PreviousIndex, currentIndex));
                
            } else {
                currentIndex = markdown.indexOf(")")+iteration;
                iteration++;
            }
            
            
            currentIndex = markdown.indexOf(")", openParen);
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
        }
            */
        
        // toReturn.add(markdown.substring(markdown.indexOf("]("), markdown.length()));
       //  return toReturn; // markdown.substring(markdown.indexOf("]("), markdown.length));
       return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
