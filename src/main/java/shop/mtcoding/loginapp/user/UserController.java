package shop.mtcoding.loginapp.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class UserController {
    
    private final UserService userService;
    private final HttpSession session; // IoC 등록되어 있음 (스프링 실행 되면)

    // http://localhost:8080/oauth/callback?code=3u9fk
    @GetMapping("/oauth/{providerName}/callback")
    public String oauthCallback(@PathVariable String providerName, String code){
        System.out.println(providerName+" call back code : "+code);
        Provider provider = null;
        if (providerName.equals("naver")){
            provider = new Naver();
        } else if (providerName.equals("kakao")) {
            provider = new Naver();
        }else {
            throw new RuntimeException("");
        }
        User sessionUser = userService.다른로그인(code, provider);
        session.setAttribute("sessionUser", sessionUser);
        return "redirect:/shop";
    }

    @GetMapping("/join-form")
    public String joinForm(){
        return "join-form";
    }
    
    @GetMapping("/login-form")
    public String loginForm(){
        return "login-form";
    }
    
    @PostMapping("/join")
    public String join(String username, String password, String email){
        userService.회원가입(username, password, email);
        return "redirect:/login-form";
    }

    @PostMapping("/login")
    public String login(String username, String password){
        User sessionUser = userService.로그인(username, password);
        session.setAttribute("sessionUser", sessionUser); // 로그인 되면 세션 저장
        return "redirect:/shop";
    }
}











