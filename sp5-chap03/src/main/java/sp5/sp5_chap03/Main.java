package sp5.sp5_chap03;

public class Main {

	public static void main(String[] args) {
		
		MemberDao memberDao = new MemberDao();
		MemberRegisterService regSvc = new MemberRegisterService(memberDao);
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
	}
}
