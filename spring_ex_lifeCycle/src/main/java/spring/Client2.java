package spring;


public class Client2 {

	private String host;

	public void setHost(String host) {
		this.host = host;
	}
	
	public void connect() {
		System.out.println("client2.connect() 실행");
	}
	
	public void close() {
		System.out.println("client2.close() 실행");
	}
	
	public void send() {
		System.out.println("client2.send()"+host);
	}
}
