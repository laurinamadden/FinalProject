// Java Mail Sender
@Configuration
public class MailConfig {
    // Copied in by Laurina Madden from https://docs.spring.io/spring-framework/reference/integration/email.html
    @Bean
    JavaMailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("mail.mycompany.example");
        return mailSender;
    }

    @Bean // this is a template message that we can pre-load with default state
    SimpleMailMessage templateMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("customerservice@mycompany.example");
        message.setSubject("Your order");
        return message;
    }

    @Bean
    SimpleOrderManager orderManager(JavaMailSender mailSender, SimpleMailMessage templateMessage) {
        SimpleOrderManager orderManager = new SimpleOrderManager();
        orderManager.setMailSender(mailSender);
        orderManager.setTemplateMessage(templateMessage);
        return orderManager;
    }    
}
