package shop.mtcoding.loginapp.user;
import org.springframework.util.MultiValueMap;

public abstract class Provider {
    public abstract String getProviderName();
    public abstract MultiValueMap<String, String> getTokenBody(String code);
    public abstract String getTokenURL();
    public abstract String getUserURL();
}
