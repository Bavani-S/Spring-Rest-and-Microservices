package Mail.Mail;

import java.util.Scanner;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;
@Component
public class CustomServer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
public void customize(ConfigurableWebServerFactory factory) {
	System.out.println("Enter port no:");
	Scanner sc=new Scanner(System.in);
	int port=sc.nextInt();
	factory.setPort(port);
	
}
}
