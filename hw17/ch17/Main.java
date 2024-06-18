package hw17.ch17;

public class Main {
    public static void main(String[] args) {
        // 관찰대상 생성
        NumberGenerator ng1 = new RandomNumberGenerator();
        NumberGenerator png = new PrimeNumberGenerator();

        //관찰자 생성
        Observer ob1 = new NamePrintObserver("손재윤"); // "손재윤"을 전달
        Observer ob2 = new GraphObserver();
        Observer ob3 = new DigitObserver();

        //관찰자 등록(생성만하면 연결이 안됨)
        ng1.addObserver(ob1);
        ng1.addObserver(ob2);
        ng1.addObserver(ob3);
        
        png.addObserver(ob1);
        png.addObserver(ob2);
        png.addObserver(ob3);
        

        // 관찰 대상에게 숫자 생성 실행
        ng1.execute();
        png.execute();
    }
}

