package misc;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName = "ChineseEncode", urlPatterns = { "/*" }, initParams = { @WebInitParam(name = "encoding", value = "UTF-8") })
public class ChineseEncode implements Filter {
	private FilterConfig config = null;

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		String encoding = config.getInitParameter("encoding");
		req.setCharacterEncoding(encoding);
		chain.doFilter(req, resp);

	}

	public void destroy() {

	}

}
