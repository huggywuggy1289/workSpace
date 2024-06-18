package hw17.ch17;

import java.util.Random;

public class PrimeNumberGenerator extends NumberGenerator {
    private Random random = new Random(); 	// 난수 생성기 
    private int number;                   		// 현재 수 

    // 수를 취득한다 
    @Override
    public int getNumber() {
        return number;
    }

        // 소수 확인 메소드
    private boolean isPrimeNumber(int num) {
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }


    // 수를 생성하고 소수이면 관찰자에게 알린다
    @Override
    public void execute() {
        for (int i = 0; i < 20; i++) {
            number = random.nextInt(100)+1; // 0~100 사이의 정수 생성
            if (isPrimeNumber(number)) { // 생성된 수가 소수인 경우
                System.out.println("NamePrintObserver: " + number); // 소수 출력
                notifyNamePrintObserver(); // 관찰자에게 통지
                // 관찰자에게 통지할 때마다 관찰자가 
                // 자신의 update() 메서드를 호출하게 되므로, 관찰자가 통지를 받게 됩니다.
            }
        }
    }
    // NamePrintObserver에게만 소수를 통지한다
    private void notifyNamePrintObserver() {
        for (Observer o : observers) {
            if (o instanceof NamePrintObserver) { // NamePrintObserver인 경우에만 통지
                o.update(this);
            }
        }
}
}