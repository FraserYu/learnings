import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
public class GlobalSecurityFilter extends OncePerRequestFilter {


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String contentType = request.getContentType();
		if (StringUtils.isNotBlank(contentType) && contentType.contains("multipart/form-data")) {
			filterChain.doFilter(request, response);
		} else {
			GlobalSecurityRequestWrapper xssHttpServletRequestWrapper = new GlobalSecurityRequestWrapper((HttpServletRequest) request);
			filterChain.doFilter(xssHttpServletRequestWrapper, response);
		}
	}
}
