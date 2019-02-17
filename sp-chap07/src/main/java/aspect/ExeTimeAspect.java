package aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//aop 구현한다!
@Aspect
@Component
public class ExeTimeAspect {

	//pointcut 할 대상찾기 public 모든것 chap07 모든 하위 패키지포함해서 인자가 몇개가 됐든
	@Pointcut("execution(public * chap07..*(..))")
	private void publicTarget() {}
	
	@Around("publicTarget()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable{
		long start = System.nanoTime();
		try {
			Object result = joinPoint.proceed();
			return result;
		}
		finally {
			//after advice
			long end = System.nanoTime();
			Signature sig = joinPoint.getSignature();
			System.out.printf("%s.%s(%s) 실행시간 : %d ns\n", joinPoint.getTarget().getClass().getSimpleName(),sig.getName(),Arrays.toString(joinPoint.getArgs()),end-start);
			
			
		}
	}
	
}
