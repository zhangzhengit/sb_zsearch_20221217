package com.vo.pachong;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 *
 * @author zhangzhen
 * @date 2022年12月17日
 *
 */
public class Pa1 {


	public static void p() {
		final String url = "https://www.zhihu.com/";
		final Document document = connect(url);

	}


	public static Document connect(final String url) {
		Document document = null;
		try {
			document = Jsoup.connect(url).get();
		} catch (final IOException e1) {
			e1.printStackTrace();
		}
		return document;
	}
}
