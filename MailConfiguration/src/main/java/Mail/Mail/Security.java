package Mail.Mail;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class Security {
@GetMapping("/login")
public String doLogin() {
	return "<input type=text name=userid/><br><input type=password name=password/><br><input type=submit value=submit name=submit/>";
	
}
}
