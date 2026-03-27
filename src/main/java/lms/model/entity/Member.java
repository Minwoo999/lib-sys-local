package lms.model.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private int memberId;
    private boolean isAdmin;

    private String loginId;
    private String password;

    private String name;
    private String email;
    private String phone;

    private int currentLoanCnt;
    private int memberStatus;
    private LocalDateTime memberRegDate;
}