package hw.ch15.pagemaker;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Database {
    private Database() {
    }

    // 데이터베이스 이름에서 Properties를 얻는다 
    public static Properties getProperties(String dbname) throws IOException {
        //throws IOException: 항상 파일에 접근할때는 오류를 고려해야하므로 

        String filename = dbname + ".txt";

        Properties prop = new Properties();
        
        // throws IOException을 여기 try catch구문으로 생성도 가능: 시험출제 다분
        prop.load(new FileReader(filename));

        return prop;
    }
}
