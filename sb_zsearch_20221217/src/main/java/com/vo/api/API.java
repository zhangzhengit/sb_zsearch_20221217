package com.vo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.vo.entity.AddBody;
import com.vo.entity.CiEntity;
import com.vo.repository.CiRepository;
import com.votool.common.CR;

import cn.hutool.core.collection.CollUtil;

/**
 *
 *
 * @author zhangzhen
 * @date 2022年12月17日
 *
 */
@RestController
public class API {

	@Autowired
	private CiRepository ciRepository;

	@PostMapping
	public void add(@RequestBody final AddBody addBody) {
		System.out
				.println(java.time.LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "\t" + "API.add()");

		this.ciRepository.add(addBody.getContent());
	}

	@GetMapping(value = "/search")
	public CR<List<String>> search(@RequestParam final String k) {
		System.out.println(
				java.time.LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "\t" + "API.search()");

		final int limit = 200;

		return this.query(k, limit);
	}

	private CR<List<String>> query(final String k, final int limit) {
		final List<CiEntity> list = this.ciRepository.search(k, limit);

		System.out.println("list.size = " + list.size());
		if (CollUtil.isEmpty(list)) {
			return CR.ok();
		}

		final List<String> s = Lists.newArrayList();
		for (final CiEntity e : list) {
			s.add(e.getContent());
		}

		return CR.ok(s);
	}

	@GetMapping
	public String index() {
		System.out.println(
				java.time.LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "\t" + "API.index()");


		return "OK";
	}
}
