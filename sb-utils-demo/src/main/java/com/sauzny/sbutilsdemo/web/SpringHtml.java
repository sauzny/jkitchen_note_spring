package com.sauzny.sbutilsdemo.web;

import org.springframework.stereotype.Component;
import org.springframework.web.util.HtmlUtils;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SpringHtml {

	public void demo() {

		// html 转义
		
		String specialStr = "<div id=\"testDiv\">test1;test2</div>";

		log.info("原字符串 {}", specialStr);
		
		String str1 = HtmlUtils.htmlEscape(specialStr);// ①转换为HTML转义字符表示
		log.info("①转换为HTML转义字符表示 {}", str1);

		String str2 = HtmlUtils.htmlEscapeDecimal(specialStr);// ②转换为数据转义表示
		log.info("②转换为数据转义表示 {}", str2);

		String str3 = HtmlUtils.htmlEscapeHex(specialStr); // ③转换为十六进制数据转义表示
		log.info("③转换为十六进制数据转义表示 {}", str3);

		// ④下面对转义后字符串进行反向操作
		log.info("反转 {}", HtmlUtils.htmlUnescape(str1));
		log.info("反转 {}", HtmlUtils.htmlUnescape(str2));
		log.info("反转 {}", HtmlUtils.htmlUnescape(str3));

	}
}
