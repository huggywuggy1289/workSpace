package hw17.ch17;

import java.util.ArrayList;
import java.util.List;

public abstract class NumberGenerator {
    // Observer를 저장한다 (관찰자를 모아두는 곳)
    protected List<Observer> observers = new ArrayList<>(); //순서상관x
    // 만약 순서를 이용한다면 배열에 인덱스를 사용한다.

    // Observer를 추가한다 
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Observer를 제거한다 
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    // Observer에 통지한다★
    public void notifyObservers() {
        for (Observer o: observers) { //왼쪽: 오른쪽에 있는 컬럼 하나씩 꺼내오는 객체
            // 오른쪽: 관찰자 저장하는 거
            o.update(this);
        }
    }

    // 수를 취득한다 
    public abstract int getNumber();

    // 수를 생성한다 
    public abstract void execute();
}
