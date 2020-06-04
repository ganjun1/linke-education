package cn.service;

public interface MailService {
    public void sendHtmlMail(String from, String to, String subject, String content);
}
