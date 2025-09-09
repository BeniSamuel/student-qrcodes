package com.benisamuel.www.controller;

import com.benisamuel.www.service.EmailService;
import com.benisamuel.www.util.ApiResponse;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/smis/email")
@AllArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @GetMapping("/report-generated")
    public ResponseEntity<ApiResponse<Boolean>> generateReportMails () throws MessagingException {
        emailService.sendReportedGeneratedMails("ishimwebeni544@gmail.com","Report Generated", "Beni Samuel");
        return ApiResponse.ok("Generated Reports!!!", true);

    }
}
