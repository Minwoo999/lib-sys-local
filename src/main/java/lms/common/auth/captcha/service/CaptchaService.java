package lms.common.auth.captcha.service;

public interface CaptchaService {
    
    boolean verifyCaptcha(String userResponse);
}
