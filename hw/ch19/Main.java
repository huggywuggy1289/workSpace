package hw.ch19;

public class Main {
    public static void main(String[] args) {
        SafeFrame frame = new SafeFrame("State Sample");
        while (true) {
            for (int hour = 10; hour < 25; hour++) {
                frame.setClock(hour);   // 시간 설정 
                try {
                    Thread.sleep(2000); // 수정사항
                    // 1초에 한번 시간 알려주고 브레이크,
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
