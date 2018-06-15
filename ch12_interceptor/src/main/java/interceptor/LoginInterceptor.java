package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("vo") == null) {
			//로그인x
			request.setAttribute("msg", "로그인 후 이용 가능합니다.");
			request.setAttribute("url", "/main");
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
			//컨트롤러에게 요청 전달하지 않음
			return false;
		}
		//컨트롤러에게 요청 전달
		return true;
	}

	
	
}
