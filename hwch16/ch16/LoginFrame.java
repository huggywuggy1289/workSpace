package hwch16.ch16;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class LoginFrame extends Frame implements ActionListener, Mediator {
    
    // 이 변수들을 사용하겠다고 선언한 것이다.
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueCheckbox checkMember; //+
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueTextField textnum; //+
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    // Colleague를 생성하고 배치한 후에 표시한다
    public LoginFrame(String title) {
        super(title);

        // 배경색을 설정한다
        setBackground(Color.lightGray);

        // 레이아웃 매니저를 사용해 4×2 그리드를 만든다
        setLayout(new GridLayout(5, 3));

        // Colleague를 생성한다 
        createColleagues();

        // 배치한다 
        add(checkGuest);
        add(checkLogin);
        add(checkMember); //+
        add(new Label("Username:"));
        add(textUser);
        add(new Label("")); //빈라벨
        add(new Label("Password:"));
        add(textPass);
        add(new Label("")); //빈라벨
        add(new Label("주민등록번호:"));//+
        add(textnum); //+ >> 문제가 생김
        add(new Label("")); //빈라벨
        add(buttonOk);
        add(buttonCancel);
        add(new Label("")); //빈라벨

        // 활성/비활성 초기 설정을 한다
        colleagueChanged();

        // 내부컴포넌트를 정리시키는 역할을 한다.
        pack();
        // 그리고 보여주는 과정까지 해야 gui가 완성된다.
        setVisible(true);
    }

    // Colleague를 생성한다
    @Override
    public void createColleagues() {
        // CheckBox 그룹선택
        CheckboxGroup g = new CheckboxGroup();
        //처음 선택할때 guest가 활성화 되도록 true함. login은 비활상태로.
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);
        //추가
        checkMember = new ColleagueCheckbox("Member", g, false);

        // TextField
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*'); //비번 가리기!!

        // 추가
        textnum = new ColleagueTextField("", 13);
        textnum.setEchoChar('*'); //주민등록번호가리기 추가

        // Button
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        // Mediator를 설정한다 
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        checkMember.setMediator(this); //추가
        textUser.setMediator(this);
        textPass.setMediator(this);
        textnum.setMediator(this); //추가
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        // Listener 설정(checkbox.class에 존재하는 메서드들이다.)
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        checkMember.addItemListener(checkMember);//추가
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        textnum.addTextListener(textnum);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    // Colleage의 상태가 바뀌면 통지받는 메소드인 colleagueChanged가 호출된다
    @Override
    public void colleagueChanged() {
        if (checkGuest.getState()) { // Guest 체크박스가 선택되었다면(명시적으로 설명안해도 디폴트 값이 true)
            // 게스트 로그인 
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            textnum.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
        }
        else { // Login 체크박스랑 멤버 체크박스가 선택되었다면
            // 사용자 로그인 
            textUser.setColleagueEnabled(true);
            userpassChanged();
        }
    }

    // textUser 또는 textPass의 변경이 있다 
    // 각 Colleage의 활성/비활성을 판정한다
    private void userpassChanged() {
        if (textUser.getText().length() > 0) { // textUser가 입력되어야
            textPass.setColleagueEnabled(true);// // userpassChanged()를 비로소 활성화시킴
            if (textPass.getText().length() > 10) { // 비밀번호까지 입력되는 순간
                textnum.setColleagueEnabled(true); // 주민등록번호 활성화됨
                // 주민등록번호가 숫자로만 이뤄져야 함
                String numText = textnum.getText();
                boolean isNumeric = true;
                for (int i = 0; i < numText.length(); i++) {
                    if (!Character.isDigit(numText.charAt(i))) {
                        isNumeric = false;
                        break;
                    }
                }
                if (isNumeric && numText.length() >= 13) { // 숫자로만 이뤄져 있고 13자리 이상인 경우
                    buttonOk.setColleagueEnabled(true); // 버튼 활성화
                } else{
                    buttonOk.setColleagueEnabled(false); //아니면 비활성화 +
                    if(!isNumeric){
                        //경고창 생성
                        JOptionPane.showMessageDialog(this, "주민등록번호에는 숫자만 입력할 수 있습니다.", "경고", JOptionPane.WARNING_MESSAGE);
                        // 문자열의 마지막 문자를 제외하고 다시 설정
                        textnum.setText(numText.substring(0, numText.length() - 1));
                        //커서 위치를 마지막으로 이동
                        textnum.setCaretPosition(numText.length() - 1);
                    }
                }
            }
        } 
        else { // textUser가 입력되지않으면 비번, 주민등록번호 ok버튼 싹다 비활성화
            textPass.setColleagueEnabled(false);
            textnum.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) { // 버튼이 눌려지면 액션리스너 발생
        System.out.println(e.toString());
        System.exit(0);
    }
}
