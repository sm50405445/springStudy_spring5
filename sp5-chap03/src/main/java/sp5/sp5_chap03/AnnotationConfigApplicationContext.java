package sp5.sp5_chap03;

import org.springframework.context.ApplicationContext;

public class AnnotationConfigApplicationContext {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
	}
}
