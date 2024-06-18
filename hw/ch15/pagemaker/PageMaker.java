package hw.ch15.pagemaker;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PageMaker {
    private PageMaker() {
    }

    public static void makeWelcomePage(String mailaddr, String filename) {
        try {
            // 속성 파일에서 정보(사용자 이름)를 얻어와야한다.
            Properties mailprop = Database.getProperties("maildata");

            String username = mailprop.getProperty(mailaddr);

            // 웰컴파일에 내용을 완성
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));

            writer.title(username + "'s web page");

            writer.paragraph("Welcome to " + username + "'s web page!");
            writer.paragraph("Nice to meet you!");

            writer.mailto(mailaddr, username);

            writer.close();

            System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");
        } catch (IOException e) {
            // 어떤 경로로 오류가 발생했는지 출력
            e.printStackTrace();
        }
    }
    // 연습문제 15-2
    public static void makeLinkpage(String mailaddr, String filename){
        // 이메일 주소, 사용자 이름 이용해서 링크 만들기
        try{

            // 속성 파일에서 정보(사용자 이름)를 얻어와야한다.
            Properties mailprop = Database.getProperties("maildata");

            // String username = mailprop.getProperty(mailaddr);
            
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));

            writer.title("LinkPage");

            Set<String> mailaddresses = mailprop.stringPropertyNames();

            for( String addresses :  mailaddresses){
                writer.mailto(addresses, mailprop.getProperty(mailaddr));
            }

            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    // 과제
    public static void makeUrlPage(String filename) {
        try {
            Properties urlprop = new Properties();
            urlprop.load(new FileReader("urldata.txt"));

            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title("손재윤의 URL Page");

            Set<String> urls = urlprop.stringPropertyNames();
            for (String name : urls) {
                String url = urlprop.getProperty(name);
                writer.link(url, name);
            }
            writer.close();
            System.out.println(filename + " is created with URLs from urls.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
