import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.codecs.Codec;
import org.owasp.esapi.codecs.HTMLEntityCodec;
import org.owasp.esapi.codecs.MySQLCodec;
import org.owasp.esapi.codecs.PercentCodec;
import org.owasp.esapi.reference.DefaultEncoder;

import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.Part;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;


@Slf4j
public class GlobalSecurityRequestWrapper extends HttpServletRequestWrapper {

	private final String body;

	//定义Pattern数组，用于正则匹配，可添加其他pattern规则至此
	private static Pattern[] patterns = new Pattern[]{
			// Script fragments
			Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE),
			// src='...'
			Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
			// lonely script tags
			Pattern.compile("</script>", Pattern.CASE_INSENSITIVE),
			Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
			// eval(...)
			Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
			// expression(...)
			Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
			// javascript:...
			Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE),
			// vbscript:...
			Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE),
			// onload(...)=...
			Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

			Pattern.compile("<iframe>(.*?)</iframe>", Pattern.CASE_INSENSITIVE),

			Pattern.compile("</iframe>", Pattern.CASE_INSENSITIVE),

			Pattern.compile("<iframe(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.DOTALL),
			Pattern.compile("oninput(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile("onerror(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile("onclick(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile("confirm(.*?)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile("onfocus(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile("alert(.*?)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile("onabort(.*?)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile("onblur(.*?)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

			Pattern.compile("onchange(.*?)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

			Pattern.compile("ondblclick(.*?)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

			Pattern.compile("onkeydown(.*?)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

			Pattern.compile("onkeypress(.*?)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

			Pattern.compile("onkeyup(.*?)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

			Pattern.compile("onmousedown(.*?)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

			Pattern.compile("onmousemove(.*?)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

			Pattern.compile("onmouseout(.*?)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

			Pattern.compile("onmouseover(.*?)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

			Pattern.compile("onmouseup(.*?)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

			Pattern.compile("onreset(.*?)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

			Pattern.compile("onresize(.*?)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

			Pattern.compile("onselect(.*?)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

			Pattern.compile("onsubmit(.*?)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

			Pattern.compile("onunload(.*?)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),

			// add other patterns here
	};


	public GlobalSecurityRequestWrapper(HttpServletRequest servletRequest) throws IOException {
		super(servletRequest);

		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;
		try {
			InputStream inputStream = servletRequest.getInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					throw ex;
				}
			}
		}
		//将requestBody内容以字符串形式存储在变量body中
		body = stringBuilder.toString();
		log.info("Before ESAPI encode and Pattern replace，requestBody is: 【{}】", body);
	}


	/**
	 * 获取多个请求参数，多个参数返回 String[] 数组
	 *
	 * @param parameter
	 * @return
	 */
	@Override
	public String[] getParameterValues(String parameter) {
		String[] values = super.getParameterValues(parameter);

		if (values == null) {
			return null;
		}

		int count = values.length;
		String[] encodedValues = new String[count];
		for (int i = 0; i < count; i++) {
			encodedValues[i] = stripXSS(values[i]);
		}

		return encodedValues;
	}

	/**
	 * 获取单个请求参数
	 *
	 * @param parameter
	 * @return
	 */
	@Override
	public String getParameter(String parameter) {
		String value = super.getParameter(parameter);

		return stripXSS(value);
	}

	/**
	 * 获取请求头信息
	 *
	 * @param name
	 * @return
	 */
	@Override
	public String getHeader(String name) {
		String value = super.getHeader(name);
		return stripXSS(value);
	}

	/**
	 * 防Sql注入，多用于带参数查询
	 *
	 * @param value
	 * @return
	 */
	private String stripXSSSql(String value) {
		Codec MYSQL_CODEC = new MySQLCodec(MySQLCodec.Mode.STANDARD);
		if (value != null) {
			// 使用 ESAPI 避免 encoded 的代码攻击
			value = ESAPI.encoder().canonicalize(value, false, false);

			value = ESAPI.encoder().encodeForSQL(MYSQL_CODEC, value);
		}
		return value;
	}

	/**
	 * 应用默认encoder，默认行为，解析带有转义字符的json数据会出异常
	 *
	 * @param value
	 * @return
	 */
	private String stripXSS(String value) {
		if (value != null) {
			// 使用 ESAPI 避免 encoded 的代码攻击
			value = ESAPI.encoder().canonicalize(value, false, false);
			value = patternReplace(value);
		}
		return value;
	}

	/**
	 * 请求体处理，多用于json数据，自定义encoder，排除掉javascriptcodec
	 *
	 * @param value
	 * @return
	 */
	private String stripXSSRequestBody(String value) {
		if (value != null) {
			List codecs = new ArrayList(4);
			codecs.add(new HTMLEntityCodec());
			codecs.add(new PercentCodec());
			DefaultEncoder defaultEncoder = new DefaultEncoder(Arrays.asList("HTMLEntityCodec", "PercentCodec"));
			// 使用 ESAPI 避免 encoded 的代码攻击
			value = defaultEncoder.canonicalize(value, false, false);
			value = patternReplace(value);
		}
		return value;
	}

	private String patternReplace(String value) {
		if (StringUtils.isNotBlank(value)) {
			// 避免空字符
			value = value.replaceAll("\0", "");

			// 根据Pattern匹配到的字符，做""替换
			for (Pattern scriptPattern : patterns) {
				value = scriptPattern.matcher(value).replaceAll("");
			}
		}
		return value;

	}


	/**
	 * 将body重新转换为ServletInputStream,用于获取inputStream数据
	 *
	 * @return
	 * @throws IOException
	 */
	@Override
	public ServletInputStream getInputStream() throws IOException {
		String encodedBody = stripXSSRequestBody(body);
		log.info("After ESAPI encode and Pattern replace，requestBody is: 【{}】", encodedBody);

		final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(encodedBody.getBytes());
		ServletInputStream servletInputStream = new ServletInputStream() {
			@Override
			public int read() throws IOException {
				return byteArrayInputStream.read();
			}

			@Override
			public boolean isFinished() {
				return byteArrayInputStream.available() == 0;
			}

			@Override
			public boolean isReady() {
				return true;
			}

			@Override
			public void setReadListener(ReadListener readListener) {

			}
		};
		return servletInputStream;
	}

	@Override
	public Part getPart(String name) throws IOException, ServletException {
		return super.getPart(name);
	}

	@Override
	public Collection<Part> getParts() throws IOException, ServletException {
		return super.getParts();
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(this.getInputStream()));
	}

	/**
	 * 调用该方法，可以多次requestBody内容
	 *
	 * @return
	 */
	public String getBody() {
		return this.body;
	}

}
