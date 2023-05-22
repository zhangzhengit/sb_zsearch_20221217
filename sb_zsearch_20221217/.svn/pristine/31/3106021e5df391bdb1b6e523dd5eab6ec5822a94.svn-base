package com.vo.fenci;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

/**
 *
 * IK分词
 *
 * @author zhangzhen
 * @date 2022年12月17日
 *
 */
public class IK {

	private static List<String> getStringList(final String text) {
		// 独立Lucene实现
		final IKSegmenter ik = new IKSegmenter(new StringReader(text), true);
		Lexeme lex;
		final List<String> s = new ArrayList<>();
		try {
			while ((lex = ik.next()) != null) {
				s.add(lex.getLexemeText());
			}
		} catch (final IOException e) {
			e.printStackTrace();
		}
		return s;
	}

	public static List<String> toArray(final String string) {
		final List<String> stringList = getStringList(string);
		return stringList;
	}

}
