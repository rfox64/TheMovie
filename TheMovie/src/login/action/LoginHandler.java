package login.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
//import com.member.model.MemberVO;

import com.member.model.MemberService;
import com.member.model.MemberVO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

public class LoginHandler extends LoginHandlerSupport {
	private String account;
	private String password;
	private String prompt; //登入失敗或尚未登入的提示警告

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	
	
	
	private boolean allowUser(String account, String password) {
		MemberService mbs = new MemberService();
		MemberVO memberVO = mbs.getOneMember(account);
		
		if (memberVO!=null && memberVO.getPassword().equals(password)) //將使用者輸入的資料丟到
			return true;
		else
			return false;
	}

	public String execute() {

		if (!allowUser(account, password)) { // 帳號密碼無效時
			this.setPrompt("您的帳號,密碼無效!");
			return "login";
		} else {
			HttpServletRequest request = ServletActionContext.getRequest(); // 取得HttpServletRequest
			HttpSession session = request.getSession(); //取得HttpSession
			session.setAttribute("account", account);     // *工作1:在session內作已經登入過的標籤
			
//			HttpServletResponse  response = ServletActionContext.getResponse(); 
//			try {
//				String location = (String) session.getAttribute("location");
//				System.out.println("location(LoginHandler)="+location);
//				response.sendRedirect(location);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			try {                                      //*工作2:看有沒有來源網頁                
		         String location = (String) session.getAttribute("location");
		         System.out.println("location(LoginHandler)="+location);
		         if (location != null) {
		           session.removeAttribute("location");
		           HttpServletResponse  response = ServletActionContext.getResponse(); 
		           response.sendRedirect(location);
		           return null;
		         }
		       }catch (IOException e) { e.printStackTrace();}
			
			return "success";
		}
	}
}
