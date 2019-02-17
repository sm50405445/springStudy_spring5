package sp5.sp5_chap03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainForAssembler {

	public static void main(String[] args) throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("명령어를 입력");
			String command = reader.readLine();
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다");
				break;
			}
			
			if(command.startsWith("new ")) {
				processNewCommand(command.split(" "));
				System.out.println(command);
				continue;
			}else if(command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
				System.out.println(command);
				continue;
			}
			printHelp();
		}
	}
	
	private static Assembler assembler = new Assembler();
	
	private static void processNewCommand(String[] arg) {
		System.out.println(arg.length);
		if(arg.length!=5) {
			printHelp();
			return;			
		}
		
		MemberRegisterService regSvc = assembler.getRegSvc();
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		System.out.println(req.getEmail());
		System.out.println(req.getName());
		System.out.println(req.getPassword());
		System.out.println(req.getConfirmPassword());
		
		
		
		if(!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호와 확인이 일치하지 않습니다");
			return;
		}
		
		try {
			regSvc.regist(req);
			System.out.println("등록");
		}catch(DuplicateMemberException e) {
			System.out.println("존재하는 아이디");
		}
	}
	
	private static void processChangeCommand(String[] arg) {
		if(arg.length!=4) {
			printHelp();
			return;
		}
		
		ChangePasswordService changePwdSvc = assembler.getPwdSvc();
		
		try {
			changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호변경");
		}catch(MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일");
		}catch(wrongIdPasswordException e) {
			System.out.println("비밀번호가 일치 x");
		}
	}
	
	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령");
		System.out.println("명령어 사용법");
		System.out.println("email 이름 암호 암호확인");
		System.out.println("change 이메일 현재 비번 변경 비번");
		System.out.println();
	}
}
