package shop.mtcoding.loginapp.user;

import lombok.Data;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class Naver extends Provider{
    public String providerName="naver";
    public MultiValueMap<String, String> tokenBody;
    public String tokenURL="https://nid.naver.com/oauth2.0/token";
    public String userURL="https://openapi.naver.com/v1/nid/me";


    @Override
    public String getProviderName() {
        return providerName;
    }

    @Override
    public MultiValueMap<String, String> getTokenBody(String code) {
        tokenBody = new LinkedMultiValueMap<>();
        tokenBody.add("grant_type", "authorization_code");
        tokenBody.add("client_id", "1ANnuWXMUrk2jhISinA3");
        tokenBody.add("client_secret", "2pwN0D2_5t");
        tokenBody.add("state", "STATE_STRING");
        tokenBody.add("redirect_uri", "http://localhost:8080/oauth/callback");
        tokenBody.add("code", code);
        return tokenBody;
    }

    @Override
    public String getTokenURL() {
        return tokenURL;
    }

    @Override
    public String getUserURL() {
        return userURL;
    }

}
