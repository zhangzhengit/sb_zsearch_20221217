package com.vo.fenci;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.votool.ze.AbstractZETask;
import com.votool.ze.ZE;
import com.votool.ze.ZES;

import ch.qos.logback.classic.sift.SiftingJoranConfigurator;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;

/**
 *
 *
 * @author zhangzhen
 * @date 2022年12月17日
 *
 */
public class Fenci {

	private static final String PGSQL_ARRAY_SEPARATORCHAR = ",";
	private static final Set<String> FUHAO_SET = Sets.newHashSet(
				",",".","<",">",
				"-","+","!","@","~","$","#","%","^",
				"&","*","(",")","=",
				"/","\\","'","\"",
				",",".","?","`","~",
				"|","\\","[","{","《","<",
				"]","}","》",">",";",":",
				"，","。",",","：",
				"】","【","{","“","”",
				"{","【","}","！","|",
				"","","","","、",
				"。","","","","、",
				"《","》","：","；","‘",

				// 多个
				"\"。","：\"","\"，"
			);

	private final static ZE ZE = ZES.newZE(200, "fenci-Group",
			"fenci-Thread-");

	public static List<String> fenci(final String string) {
		System.out.println(
				java.time.LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "\t" + "Fenci.fenci()");

		final AbstractZETask<List<String>> taskIK = new AbstractZETask<List<String>>() {

			@Override
			public List<String> call() {
				System.out.println(java.time.LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "\t"
						+ "IK分词开始");
				return IK.toArray(string);
			}
		};

		final AbstractZETask<List<String>> taskJieba = new AbstractZETask<List<String>>() {

			@Override
			public List<String> call() {
				System.out.println(java.time.LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "\t"
						+ "Jieba分词开始");

				return Jieba.toArray(string);
			}
		};

		final AbstractZETask<List<String>> taskHanlp= new AbstractZETask<List<String>>() {

			@Override
			public List<String> call() {
				System.out.println(java.time.LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "\t"
						+ "Hanlp分词开始");

				return Hanlp.toArray(string);
			}
		};

		final AbstractZETask<List<String>> taskSingle = new AbstractZETask<List<String>>() {

			@Override
			public List<String> call() {
				System.out.println(java.time.LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "\t"
						+ "Single分词开始");
				return Single.toArray(string);
			}
		};

		final List<List<String>> list = ZE
				// FIXME 2022年12月17日 上午10:35:02 zhanghen: 不用single
//				.submitInQueueAndGet(Lists.newArrayList(taskIK));
				.submitInQueueAndGet(Lists.newArrayList(taskIK, taskJieba, taskHanlp, taskSingle));

		final HashSet<String> newHashSet = Sets.newHashSet();
		for (final List<String> list2 : list) {
			newHashSet.addAll(list2);
		}

		return Lists.newArrayList(newHashSet);
	}

	public static String toPgsqlArray(final List<String> list) {
		if (CollUtil.isEmpty(list)) {
			return "{}";
		}

		final StringJoiner joiner = new StringJoiner(PGSQL_ARRAY_SEPARATORCHAR, "{", "}");

		for (final String c : list) {

			final String trim = c.trim();

			if (StrUtil.isBlank(trim)) {
				continue;
			}

			if (PGSQL_ARRAY_SEPARATORCHAR.equals(trim)) {
				continue;
			}

			if (FUHAO_SET.contains(trim)) {
				continue;
			}

			joiner.add(trim);
		}

		return joiner.toString();

//		final StringBuilder builder = new StringBuilder("{");
//
//		for (int i = 0;i<list.size();i++) {
//			final String string = list.get(i);
//			builder.append('"').append(string);
//			if(i == list.size() - 1) {
//				builder.append('"');
//			}else {
//				builder.append("\",");
//			}
//		}
//
//		final StringBuilder append = builder.append("}");
//
//		return append.toString();
	}
}
