package com.vo.fenci;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import cn.hutool.core.util.StrUtil;

/**
 * 分为单个字符
 *
 * @author zhangzhen
 * @date 2022年12月17日
 *
 */
public class Single {

	public static List<String> toArray(final String string) {
		if (StrUtil.isEmpty(string)) {
			return Collections.emptyList();
		}

		final char[] charArray = string.toCharArray();

		final HashSet<Character> newHashSet = Sets.newHashSet();
		for (final char c : charArray) {
			newHashSet.add(c);
		}

		final ArrayList<String> newArrayListWithCapacity = Lists.newArrayListWithCapacity(string.length());
		for (final Character character : newHashSet) {
			newArrayListWithCapacity.add(String.valueOf(character));
		}

		return newArrayListWithCapacity;
	}
}
