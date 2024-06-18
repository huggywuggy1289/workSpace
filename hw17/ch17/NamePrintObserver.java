package hw17.ch17;

public class NamePrintObserver implements Observer {
    private String name; // 이름 저장 변수

    public NamePrintObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(NumberGenerator generator) {
        // 관찰자가 통지받아서 하는 일
        int number = generator.getNumber(); // 생성된 숫자 얻기
        for (int i = 0; i < number; i++) {
            System.out.print(name + " "); // 이름 출력, 띄어쓰기
        }
        System.out.println(); // 줄바꿈

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

