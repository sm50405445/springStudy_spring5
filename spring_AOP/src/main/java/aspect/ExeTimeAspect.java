package aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class ExeTimeAspect {

	@Pointcut("execution(public * chap07..*(..))")
	private void publicTarget() {
		
	}
	@Around("publicTarget()")
	public Object measure(ProceedingJoinPoint joinpoint) throws Throwable{
		long start = System.nanoTime();
		try {
			Object result = joinpoint.proceed();
			return result;
		} finally {
			long finish = System.nanoTime();
			Signature sig = joinpoint.getSignature();
			System.out.printf("%s.%s(%s) 실행 시간 : %d ns\n",
					joinpoint.getTarget().getClass().getSimpleName(),
					sig.getName(), Arrays.toString(joinpoint.getArgs()),
					(finish - start));
		}
		
	}
}
