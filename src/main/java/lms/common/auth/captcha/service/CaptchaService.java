package lms.common.captcha.service;

public interface CaptchaService {
    
    boolean verifyCaptcha(String userResponse);
}
