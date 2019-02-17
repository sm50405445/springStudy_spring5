package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.AuthInfo;
import spring.ChangePasswordService;
import spring.ChangePwdCommend;
import spring.ChangePwdValidator;
import spring.WrongIdPasswordException;

@Controller
@RequestMapping("edit")
public class ChangePwdController {

	
	@Autowired
	private ChangePasswordService changePasswordService;
	
	@GetMapping("changePassword")
	public void form(@ModelAttribute("command") ChangePwdCommend pwdCmd) {}
	
	@PostMapping("changePassword")
	public String submit(@ModelAttribute("command") ChangePwdCommend pwdCmd,Errors errors,HttpSession session) {
		
		new ChangePwdValidator().validate(pwdCmd, errors);
		if(errors.hasErrors()) {
			return "edit/changePwd";
		}
		AuthInfo authinfo = (AuthInfo) session.getAttribute("authInfo");
		try {
			changePasswordService.changePassword(authinfo.getEmail(), pwdCmd.getCurrentPassword(),pwdCmd.getNewPassword());
			return "edit/changedPwd";
		}catch(WrongIdPasswordException e) {
			//notmatching.currentPassword
			errors.rejectValue("currentPassword", "notMatching");
			return "edit/changePassword";
		}
		
	}
}
