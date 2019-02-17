package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.AuthInfo;
import spring.AuthService;
import spring.LoginCommand;
import spring.LoginCommandValidator;
import spring.WrongIdPasswordException;

@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
	private AuthService authService;
	
	@GetMapping
	public String form(LoginCommand loginCommend, @CookieValue(value="REMEMBER",required=false)Cookie rCookie) {
		if(rCookie != null) {
			loginCommend.setEmail(rCookie.getValue());
			loginCommend.setRememberEmail(true);
		}
		return "login/loginForm";
	}
	
	@PostMapping
	public String submit(LoginCommand loginCommend,Errors errors,HttpSession session,HttpServletResponse response){
		new LoginCommandValidator().validate(loginCommend, errors);
		if(errors.hasErrors()) {
			return "login/loginForm";
		}
		try {
			AuthInfo authInfo = authService.authenticate(loginCommend.getEmail(),loginCommend.getPassword());
			session.setAttribute("authInfo", authInfo);
			
			Cookie rememberCookie = new Cookie("REMEMBER", loginCommend.getEmail());
			rememberCookie.setPath("/");
			if(loginCommend.isRememberEmail()) {
				rememberCookie.setMaxAge(60*60*24*30);
			}
			else {
				rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie);
			
			return "login/loginSuccess";
		}catch(WrongIdPasswordException e) {
			errors.reject("idPasswordNotMatching");
			return "login/loginForm";
		}
	}
	
	
}
