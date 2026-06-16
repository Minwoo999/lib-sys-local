package lms.reservation.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lms.model.ReservationVO;
import lms.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    // 1. 예약 목록 조회
    @GetMapping("/list.do")
    public String list(Model model) {
        // TODO: 목록 조회 비즈니스 로직 구현 필요 - 필터 조건(상태별 등) 결정 필요
        List<ReservationVO> reservations = null;
        model.addAttribute("reservations", reservations);
        return "reservation/list";
    }

    // 2. 예약 상세 조회
    @GetMapping("/detail.do")
    public String detail(@RequestParam("reservationId") int reservationId, Model model) {
        // TODO: 상세 조회 비즈니스 로직 구현 필요
        ReservationVO reservation = null;
        model.addAttribute("reservation", reservation);
        return "reservation/detail";
    }

    // 3. 예약 등록 폼
    @GetMapping("/register.do")
    public String registerForm() {
        return "reservation/register";
    }

    // 4. 예약 등록 처리
    @PostMapping("/register.do")
    public String register(ReservationVO vo) {
        reservationService.register(vo);
        return "redirect:/reservation/list.do";
    }

    // 5. 예약 취소
    @PostMapping("/cancel.do")
    public String cancel(@RequestParam("reservationId") int reservationId) {
        reservationService.cancel(reservationId);
        return "redirect:/reservation/list.do";
    }
}
