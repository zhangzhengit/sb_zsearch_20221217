package com.vo.fenci;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.filters.CsrfPreventionFilter;

import com.google.common.collect.Lists;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.tag.Nature;
import com.hankcs.hanlp.seg.common.Term;

/**
 *	Hanlp分词
 *
 * @author zhangzhen
 * @date 2022年12月17日
 *
 */
public class Hanlp {

	public static List<String> toArray(final String string) {

		final List<Term> segment = HanLP.segment(string);
//		System.out.println("segment.size = " + segment.size());

		final ArrayList<String> rr = Lists.newArrayListWithCapacity(segment.size());
		for (final Term term : segment) {
//			System.out.println(term);

			final String s2 = term.toString();
			final String v = s2.substring(0,s2.lastIndexOf("/"));
//			System.out.println(term);
			rr.add(v);
		}
//		System.out.println("segment.size = " + segment.size());
//		final List<String> stringList = getStringList(string);
		return rr;
	}

}
