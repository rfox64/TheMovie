package misc;

import hibernate.util.HibernateUtil;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

@WebFilter(filterName = "OpenSessionInViewFilter", urlPatterns = { "/*" })
public class OpenSessionInViewFilter implements Filter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			chain.doFilter(request, response);
			
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
		}
	}

	private FilterConfig config = null;
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}
	@Override
	public void destroy() {

	}
}
