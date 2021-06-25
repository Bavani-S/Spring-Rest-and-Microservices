package Mail.Mail;

import java.util.HashMap;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailApplication {

	public static void main(String[] args) {
		//SpringApplication.run(MailApplication.class, args);
		//Configuration for existing Tomcat Server
		SpringApplication mailapp=new SpringApplication(MailApplication.class);
		System.out.println("Enter port no");
		Scanner sc=new Scanner(System.in);
		int port=sc.nextInt();
		HashMap confPort=new HashMap<>();
		confPort.put("server.port", port);
		confPort.put("loggong.level", "debug");
		confPort.put("logging.file.name","Mail.log");
		confPort.put("logging.file.max-size", "1MB");
		mailapp.setDefaultProperties(confPort);
		mailapp.run(args);
	}

}
