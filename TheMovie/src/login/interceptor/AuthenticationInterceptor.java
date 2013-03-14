package login.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthenticationInterceptor extends AbstractInterceptor {
	
	public String intercept(ActionInvocation invocation) throws Exception {

		 // 從ActionInvocation取得ActionContext
		ActionContext ctx = invocation.getInvocationContext();
		// 從ActionContext取得session
		Map<String, Object> session = ctx.getSession();
		// 從 session內取出 (key) account的值 , 以判斷此user是否登入過
		String account = (String) session.get("account"); 

		 // 如為 null, 代表此user未登入過, 才做以下工作
		if (account == null) { 
			 // 取得HttpServletRequest
			HttpServletRequest request = ServletActionContext.getRequest();
			 // 記下目前location(來源網頁)
			//  以便於login.jsp登入成功後 , 能夠直接導至此location來源網頁(須配合LoginHandler.java)
			String location = request.getRequestURI();
			session.put("location", location);
			// 在HttpServletRequest 設置【尚未登入】的提示警告
			ctx.put("prompt", "您尚未登入 ,  請登入"); 
			return "login";
		} else {
			return invocation.invoke(); // 繼續下一個攔截器或下一個Action的execute()方法
		}
	}
}
