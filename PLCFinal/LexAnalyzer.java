import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexAnalyzer {
    public static void main(String[] args) {
        try {
        File f = new File("C:\\Users\\kirta\\IdeaProjects\\LexAnalyzer\\src\\inputFile.txt");
        Scanner scnr = new Scanner(f);
        System.out.println("This is my Lexical Analyzer");
        System.out.println("User has selected the following directory path: "+f.getAbsolutePath());
        System.out.println("*****************************************************************");
            while(scnr.hasNext()) {
                String str = scnr.nextLine();
                //System.out.println(str);

                //Statically-type indentifiers Identification
                if(str.startsWith("int") ||str.contains("return") || str.startsWith("char") ||str.startsWith("String") ||
                        str.startsWith("double") || str.startsWith("float") ||str.startsWith("boolean")) {
                    System.out.println("Statically-typed indentifiers found in: " +str);
                }
                //class definitons Identification
                if(str.contains("class")) {
                    System.out.println("class definition found in: " + str);
                }

                //void keyword Identification
                if(str.contains("void")) {
                    System.out.println("void found in: " + str);
                }

                //integer Identification
                if(str.startsWith("int") && str.contains("=")){
                    System.out.println("Int Datatype found in: "+ str);
                }
                //String Identification
                Pattern p3 = Pattern.compile("\\\"(.*?)\\\"");
                Matcher m3 = p3.matcher(str);
                while(m3.find()){
                    System.out.println("String Datatype found in: "+ str + "\n"+ "string datatype value: "+ m3.group());
                }
                //floating-point number Identification
                Pattern p2 = Pattern.compile("[+-]?\\d+(\\.\\d+)?([Ee][+-]?\\d+)?f");
                Matcher m2 = p2.matcher(str);
                while(m2.find()){
                    System.out.println("Floating Point Datatype found in: "+ str+ "\n"+ "floating datatype value: "+m2.group());
                }

                //boolean datatype Identification
                if((str.contains("true") || str.contains("false")) && str.startsWith("boolean")){
                    System.out.println("Boolean expression: "+str);
                    //print the line containing boolean
                    if(str.contains("true") || str.contains("false")) {
                        System.out.println("The following line contains a boolean datatype: "+str);
                    }
                }
                //assignment statement Identification
                if(str.contains("=")) {
                    System.out.println("Assignment statement found in: " + str);
                }
                //expression Identification

                if(str.contains("+") || str.contains("=") || str.contains("-") || str.contains("*") || str.contains("/")){
                    System.out.println("Expression found in: "+str);
                }

                //dereferencing Identification
                if(str.contains(".") && str.contains("()") && str.contains(";")) {
                    System.out.println("dereferencing found in: " + str);
                }
            }

       } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
