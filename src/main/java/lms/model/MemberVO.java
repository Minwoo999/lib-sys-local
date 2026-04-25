package lms.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {

    private int memberId;
    private boolean isAdmin;
    private int memberStatus; // 1: 정상, 0: 정지
    private int currentLoanCnt;
    private LocalDateTime memberRegDate;

    // 입력 및 출력 공용 필드
    @NotBlank(message = "아이디를 입력해주세요.")
    @Size(min = 4, max = 50)
    private String loginId;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    @NotBlank(message = "이메일을 입력해주세요.")
    private String email;

    @NotBlank(message = "전화번호를 입력해주세요.")
    private String phone;

    private int loginType = 0;

    private String snsId;
}