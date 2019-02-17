package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthCheckInterceptor implements HandlerInterceptor{

	//선행처리
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession(false);
		if(session != null) {
			Object authInfo = session.getAttribute("authInfo");
			if(authInfo!=null) {
				return true;
			}
		}
		response.sendRedirect(request.getContextPath()+"/login");
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	
}
