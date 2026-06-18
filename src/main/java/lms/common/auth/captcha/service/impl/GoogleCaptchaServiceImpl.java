package lms.common.auth.captcha.service.impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lms.common.auth.captcha.service.CaptchaService;


@Service("captchaService")
public class GoogleCaptchaServiceImpl implements CaptchaService{
    
    @Value("${google.recaptcha.site}")
    private String siteKey;

    @Value("${google.recaptcha.secret}")
    private String secretKey;

    private static String VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";

    @Override
    public boolean verifyCaptcha(String userResponse) {

        if (userResponse == null || userResponse.isEmpty()) {
            return false;
        }

        try {
            URL url = new URL(VERIFY_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoOutput(true);

            StringBuilder postParams = new StringBuilder();
            postParams.append("secret=").append(secretKey);
            postParams.append("&response=").append(userResponse);

            try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
                wr.writeBytes(postParams.toString());
                wr.flush();
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // reponsecode == 200

                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = br.readLine()) != null) {
                        response.append(inputLine);
                    }

                    String jsonResponse = response.toString();

                    return jsonResponse.contains("\"success\": true");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
