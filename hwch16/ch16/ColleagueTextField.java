package hwch16.ch16;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
// 텍스트 필드에서 일어난 일은 implements TextListener가 처리하겠다.
public class ColleagueTextField extends TextField implements TextListener, Colleague {
    private Mediator mediator;

    public ColleagueTextField(String text, int columns) {
        super(text, columns);
    }

    // Mediator를 설정한다 
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // Mediator에서 활성/비활성을 지시한다
    @Override
    public void setColleagueEnabled(boolean enabled) {
        this.setEnabled(enabled);
        // 활성/비활성에 맞게 배경색을 변경한다
        this.setBackground(enabled ? Color.white : Color.lightGray);
        // true이면 전체 문장의 흰색, false이면 회색이다의 의미
    }

    @Override
    public void textValueChanged(TextEvent e) {
        // 문자열이 변화했으면 Mediator에 알린다
        mediator.colleagueChanged();
    }
}
