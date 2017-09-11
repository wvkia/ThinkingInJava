package UseIO;

import javax.xml.soap.Text;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile extends ArrayList<String> {
    public static String read(String filename) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(filename).getAbsoluteFile()));
            try {
                String s;
                while ((s = reader.readLine()) != null) {
                    stringBuilder.append(s);
                    stringBuilder.append("\n)");

                }
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static void write(String filename, String text) {
        try {
            PrintWriter out = new PrintWriter(new File(filename).getAbsoluteFile());
            try {
                out.print(text);

            } finally {
                out.close();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TextFile(String filename, String spliter) {
        super(Arrays.asList(read(filename).split(spliter)));
        if (get(0).equals("")) {
            remove(0);
        }
    }

    TextFile(String filename) {
        this(filename, "\n");
    }

    public void write(String filename) {
        try {
            PrintWriter out = new PrintWriter(new File(filename).getAbsoluteFile());
            try {
                for (String s : this) {
                    out.println(s);
                }
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    public static void main(String[] args) {
        String file = read(PathUtil.path + "TextFile.java");
        write(PathUtil.path + "text.text", file);
        TextFile file1 = new TextFile(PathUtil.path + "text.text");
        file1.write(PathUtil.path + "text2.text");
        TreeSet<String> words = new TreeSet<>(new TextFile(PathUtil.path + "TextFile.java", "\\W+"));
        System.out.println(words.headSet("a"));
    }
}
