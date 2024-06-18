package hw.ch07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        XMLbuilder xmlBuilder = new XMLbuilder();
        Director director = new Director(xmlBuilder);
        director.construct();
        // XMLBuilder 객체에서 생성된 XML 문자열을 출력합니다.
        System.out.println(xmlBuilder.getXMLResult());
    }

    // 사용 방법을 표시한다 
    public static void usage() {
        System.out.println("Usage: java Main xml      XML 파일로 문서 작성");
    }
}

// if (args.length != 1) {
//     usage();
//     System.exit(0);
// }
// if (args[0].equals("text")) {
//     TextBuilder textbuilder = new TextBuilder();
//     Director director = new Director(textbuilder);
//     director.construct();
//     String result = textbuilder.getTextResult();
//     System.out.println(result);
// } else if (args[0].equals("html")) {
//     HTMLBuilder htmlbuilder = new HTMLBuilder();
//     Director director = new Director(htmlbuilder);
//     director.construct();
//     String filename = htmlbuilder.getHTMLResult();
//     System.out.println("HTML파일 " + filename + "이 작성되었습니다.");
// } else if (args[0].equals("xml")) { // XML 옵션 추가
//     XMLbuilder xmlBuilder = new XMLbuilder();
//     Director director = new Director(xmlBuilder);
//     director.construct();
    
//     // XMLBuilder 객체에서 생성된 XML 문자열을 출력합니다.
//     System.out.println(xmlBuilder.getXMLResult());
// } 
// else {
//     usage();
//     System.exit(0);
// }
