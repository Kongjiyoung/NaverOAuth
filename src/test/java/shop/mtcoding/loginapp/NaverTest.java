package shop.mtcoding.loginapp;

import org.springframework.util.MultiValueMap;
import shop.mtcoding.loginapp.user.Naver;

public class NaverTest {

    public static void main(String[] args) {
        Naver naver = new Naver();
        MultiValueMap<String, String> tokenBody = naver.tokenBody;
        System.out.println(tokenBody);
    }
}
