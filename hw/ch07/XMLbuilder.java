package hw.ch07;
import java.io.*;

public class XMLbuilder extends Builder{
    private String filename ="20220625 손재윤";
    private StringBuilder sb = new StringBuilder();

    @Override
    public void makeTitle(String title) {
        filename = title + ".html";
        sb.append("<document>\n");
        sb.append("<title>");
        sb.append(title);
        sb.append("</title>\n");
    }

    @Override
    public void makeString(String str) {
        sb.append("<string>");
        sb.append(str);
        sb.append("</string>\n\n");
    }

    @Override
    public void makeItems(String[] items) {
        sb.append("<items>\n");
        for (String s: items) {
            sb.append("<items>");
            sb.append(s);
            sb.append("</items>\n");
        }
        sb.append("</items>\n\n");
    }

    @Override
    public void close() {
        sb.append("</document>");
        try{
            Writer writer = new FileWriter(filename);
            writer.write(toString());
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    public String getXMLResult() {
        return sb.toString();
    }

}