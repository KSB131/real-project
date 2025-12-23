package com.quadcore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * ============================================
 * 메인 페이지 컨트롤러
 * ============================================
 * 각 화면의 라우팅을 담당합니다.
 * 실제 개발 시 Service 클래스와 연동하세요.
 */
@Controller
public class MainController {

    // ------------------------------------------
    // 로그인 관련
    // ------------------------------------------
    
    /**
     * 로그인 페이지
     * GET /login
     */
    @GetMapping("/login")
    public String loginPage() {
        return "login";  // templates/login.html
    }

    /**
     * 로그인 처리 (Spring Security 사용 권장)
     * POST /login
     */
    @PostMapping("/login")
    public String loginProcess(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {
        // TODO: 실제 로그인 로직 구현
        // Spring Security 사용 시 이 메서드 불필요
        
        // 임시: 무조건 대시보드로 이동
        return "redirect:/dashboard";
    }

    /**
     * 회원가입 페이지
     * GET /register
     */
    @GetMapping("/register")
    public String registerPage() {
        return "register";  // templates/register.html
    }

    /**
     * 회원가입 처리
     * POST /register
     */
    @PostMapping("/register")
    public String registerProcess(@RequestParam String username,
                                  @RequestParam String email,
                                  @RequestParam String password,
                                  @RequestParam String passwordConfirm,
                                  @RequestParam String role,
                                  Model model) {
        // TODO: 회원가입 로직 구현
        // 1. 비밀번호 확인
        // 2. 중복 체크
        // 3. DB 저장
        
        return "redirect:/login";
    }

    /**
     * 로그아웃
     * GET /logout
     */
    @GetMapping("/logout")
    public String logout() {
        // TODO: 세션 종료 처리
        return "redirect:/login";
    }


    // ------------------------------------------
    // 대시보드
    // ------------------------------------------
    
    /**
     * 대시보드 페이지
     * GET /dashboard
     */
    @GetMapping({"/", "/dashboard"})
    public String dashboardPage(Model model) {
        // 현재 페이지 표시 (사이드바 메뉴 활성화용)
        model.addAttribute("currentPage", "dashboard");
        
        // TODO: 실제 데이터 조회
        // model.addAttribute("totalPatients", patientService.count());
        // model.addAttribute("rooms", roomService.findAllWithBeds());
        // model.addAttribute("recentAlerts", alertService.findRecent(5));
        
        // 샘플 데이터
        model.addAttribute("totalPatients", 24);
        model.addAttribute("normalCount", 18);
        model.addAttribute("warningCount", 4);
        model.addAttribute("dangerCount", 2);
        model.addAttribute("alertCount", 3);
        
        return "dashboard";  // templates/dashboard.html
    }


    // ------------------------------------------
    // 침상 관리
    // ------------------------------------------
    
    /**
     * 침상 관리 페이지
     * GET /patients
     */
    @GetMapping("/patients")
    public String patientsPage(@RequestParam(required = false) String keyword,
                               @RequestParam(required = false) Long roomFilter,
                               @RequestParam(defaultValue = "0") int page,
                               Model model) {
        model.addAttribute("currentPage", "patients");
        model.addAttribute("keyword", keyword);
        model.addAttribute("roomFilter", roomFilter);
        
        // TODO: 실제 데이터 조회
        // Page<Patient> patients = patientService.findAll(keyword, roomFilter, page);
        // model.addAttribute("patients", patients.getContent());
        // model.addAttribute("totalPages", patients.getTotalPages());
        // model.addAttribute("currentPage", page);
        
        return "patients";
    }

    /**
     * 환자 등록
     * POST /patients
     */
    @PostMapping("/patients")
    public String createPatient(@RequestParam String bedId,
                                @RequestParam String name,
                                @RequestParam Integer pressureUlcerStage,
                                @RequestParam(required = false) String pressureUlcerArea) {
        // TODO: 환자 등록 로직
        // patientService.create(bedId, name, pressureUlcerStage, pressureUlcerArea);
        
        return "redirect:/patients";
    }


    // ------------------------------------------
    // 실시간 모니터링
    // ------------------------------------------
    
    /**
     * 실시간 모니터링 페이지
     * GET /monitoring
     */
    @GetMapping("/monitoring")
    public String monitoringPage(Model model) {
        model.addAttribute("currentPage", "monitoring");
        
        // TODO: 카메라 목록 조회
        // model.addAttribute("cameras", cameraService.findAll());
        
        return "monitoring";
    }


    // ------------------------------------------
    // 알림 센터
    // ------------------------------------------
    
    /**
     * 알림 센터 페이지
     * GET /alerts
     */
    @GetMapping("/alerts")
    public String alertsPage(@RequestParam(required = false) String status,
                             Model model) {
        model.addAttribute("currentPage", "alerts");
        model.addAttribute("statusFilter", status);
        
        // TODO: 알림 목록 조회
        // model.addAttribute("alerts", alertService.findAll(status));
        
        return "alerts";
    }


    // ------------------------------------------
    // 체위 가이드
    // ------------------------------------------
    
    /**
     * 체위 가이드 페이지
     * GET /guide
     */
    @GetMapping("/guide")
    public String guidePage(@RequestParam(required = false) Long patientId,
                            Model model) {
        model.addAttribute("currentPage", "guide");
        
        // TODO: 현재 알림 환자 정보 조회
        // if (patientId != null) {
        //     model.addAttribute("patient", patientService.findById(patientId));
        // } else {
        //     model.addAttribute("patient", alertService.findMostUrgent());
        // }
        
        return "guide";
    }

    /**
     * 체위 변경 완료 처리
     * POST /guide/complete
     */
    @PostMapping("/guide/complete")
    public String completePositionChange(@RequestParam Long patientId) {
        // TODO: 체위 변경 완료 처리
        // positionService.complete(patientId);
        // alertService.resolve(patientId);
        
        return "redirect:/dashboard";
    }


    // ------------------------------------------
    // 보고서
    // ------------------------------------------
    
    /**
     * 보고서 페이지
     * GET /reports
     */
    @GetMapping("/reports")
    public String reportsPage(Model model) {
        model.addAttribute("currentPage", "reports");
        return "reports";
    }

    /**
     * 보고서 생성
     * POST /reports/generate
     */
    @PostMapping("/reports/generate")
    public String generateReport(@RequestParam(required = false) Long patientId,
                                 @RequestParam String period,
                                 @RequestParam String format,
                                 Model model) {
        // TODO: 보고서 생성 로직
        // Report report = reportService.generate(patientId, period, format);
        
        return "redirect:/reports";
    }


    // ------------------------------------------
    // 설정
    // ------------------------------------------
    
    /**
     * 설정 페이지
     * GET /settings
     */
    @GetMapping("/settings")
    public String settingsPage(Model model) {
        model.addAttribute("currentPage", "settings");
        
        // TODO: 현재 설정값 조회
        // model.addAttribute("settings", settingsService.findAll());
        
        return "settings";
    }

    /**
     * 설정 저장
     * POST /settings
     */
    @PostMapping("/settings")
    public String saveSettings(@RequestParam Integer warningThreshold,
                               @RequestParam Integer dangerThreshold,
                               @RequestParam Integer escalationTime) {
        // TODO: 설정 저장
        // settingsService.save(warningThreshold, dangerThreshold, escalationTime);
        
        return "redirect:/settings";
    }
}
