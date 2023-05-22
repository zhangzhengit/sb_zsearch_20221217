package com.vo.fenci;

import java.nio.file.Paths;
import java.util.List;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.WordDictionary;

/**
 * 结巴分词
 *
 *
 * @author zhangzhen
 * @date 2022年12月17日
 *
 */
public class Jieba {

	private static final JiebaSegmenter segmenter = new JiebaSegmenter();
	static {
		WordDictionary.getInstance().init(Paths.get("conf"));
	}

	public static List<String> toArray(final String string) {
		final List<String> sentenceProcess = segmenter.sentenceProcess(string);
		return sentenceProcess;
	}

}
