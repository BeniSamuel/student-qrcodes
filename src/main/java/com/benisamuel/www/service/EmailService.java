package com.benisamuel.www.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;

    public void sendReportedGeneratedMails (String to, String subject, String name) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setFrom("benisamuel566@gmail.com");

        // Email body with HTML
        String content = "<h2>Hello, " + name + "</h2>"
                + "<p>We are happy to inform you that: </p>"
                + "<p>That reports are now generated!!!</p>";

        helper.setText(content, true);
        javaMailSender.send(mimeMessage);
    }

}
