package hw.ch15;

import hw.ch15.pagemaker.PageMaker;

public class Main {
    public static void main(String[] args) {
        // maildata에 입력되어있는 메일에 대응하는 이름을 출력해준다.
        // 메일 입력 여부에 따라 이름이 출력 이름과 파일 내용이 바뀜
        PageMaker.makeWelcomePage("bangstation0714@naver.com", "welcome.html");

        PageMaker.makeLinkpage("bangstation0714@naver.com","link-page.html");

        PageMaker.makeUrlPage("urlPage.html");
    }
}