package Mail.Mail;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/mail")//context root path
public class MailOperation {

	@RequestMapping(value="/inbox",method=RequestMethod.GET)
	public String getInbox() {
		return "<H1>hello world<H1>";
		
	}
	@RequestMapping(value="/sent",method=RequestMethod.GET)
	public String getSent() {
		return "<H2>Good Morning<H2>";
		
	}
}
