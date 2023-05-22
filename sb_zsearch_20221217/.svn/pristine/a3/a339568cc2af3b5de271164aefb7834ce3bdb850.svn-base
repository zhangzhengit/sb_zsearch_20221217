	package com.vo.repository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.vo.entity.CiEntity;
import com.vo.fenci.Fenci;
import com.votool.ze.AbstractZETask;
import com.votool.ze.ZE;
import com.votool.ze.ZES;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;

/**
 *
 *
 * @author zhangzhen
 * @date 2022年12月17日
 *
 */
@Repository
public class CiRepository {

	private final ZE ZE = ZES.newZE();

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<CiEntity> search(final String k, final int limit) {

		System.out.println("k = "  + k);
		final List<String> ciList = Fenci.fenci(k);
		System.out.println("ciList = "  + ciList);

		final List<AbstractZETask<List<CiEntity>>> taskList = Lists.newArrayList();

		ciList.sort(Comparator.comparing(String::length).reversed());

		final String select = "SELECT * FROM ci WHERE ";
		for (final String ci : ciList) {

			if (ci.length() <= 1) {
				// XXX 待定，单个字符查不查？
				continue;
			}

			final String ci2 = StrUtil.isEmpty(ci) ? "" : ci;
			final String sql = select + "ci @> array['" + ci2.toLowerCase() + "'::varchar(256)] " + " limit " + limit;

			final AbstractZETask<List<CiEntity>> task = new AbstractZETask<List<CiEntity>>() {

				@Override
				public List<CiEntity> call() {
					System.out.println(java.time.LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "\t"
							+ "CiRepository.search-k = " + ci2);

					return CiRepository.this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CiEntity.class));
				}
			};

			taskList.add(task);
		}

		final List<List<CiEntity>> r = this.ZE.submitInQueueAndGet(taskList);
		if (CollUtil.isNotEmpty(r)) {
			final List<CiEntity> rr = r.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
			return rr;
		}

		final List<AbstractZETask<List<CiEntity>>> taskList2 = Lists.newArrayList();
		for (final String ci : ciList) {

			if (ci.length() > 1) {
				continue;
			}

			final String ci2 = StrUtil.isEmpty(ci) ? "" : ci;
			final String sql = select + "ci @> array['" + ci2.toLowerCase() + "'::varchar(256)] " + " limit " + limit;

			final AbstractZETask<List<CiEntity>> task =new AbstractZETask<List<CiEntity>>() {

				@Override
				public List<CiEntity> call() {
					System.out.println(java.time.LocalDateTime.now() + "\t" + Thread.currentThread().getName() + "\t"
							+ "CiRepository.search-k = " + ci2);

					return CiRepository.this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CiEntity.class));
				}
			};

			taskList2.add(task);
		}
		final List<List<CiEntity>> r2 = this.ZE.submitInQueueAndGet(taskList2);
		final List<CiEntity> rr2 = r2.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
		return rr2;

	}

	public Long countByMaxIdAndMinId() {
		final String count = "select (max(id) - min(id)) as count from ci;";

		final List<Map<String, Object>> list = this.jdbcTemplate.queryForList(count);
		final Map<String, Object> m = list.get(0);
		final Object object = m.get("count");
		return Long.valueOf(String.valueOf(object));
	}


	public List<CiEntity> findByIdLimit(final Long id, final int limit) {

		final String sql = "select id, ci from ci where id >  " + id + " order by id asc limit " + limit;

		final List<CiEntity> list = this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CiEntity.class));

		return list;

	}

	public List<CiEntity> findCiPage(final int pageNo ,final int pageSize) {

		final int limit = pageSize;
		final int offset = (pageNo - 1) * pageSize;
		final String sql = "select id,ci from ci limit " + limit + " offset " + offset;

		final List<CiEntity> list = this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CiEntity.class));

		return list;
	}


	public List<CiEntity> findAll() {

		final String sql = "select * from ci";
		final List<CiEntity> list = this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CiEntity.class));

		return list;
	}


	@Transactional(rollbackOn = Exception.class)
	public void add(final String content) {

		final List<String> ciList = Fenci.fenci(content);

		final String a = Fenci.toPgsqlArray(ciList);
		final String sql = "insert into ci(ci,content) values ('%s','%s');";

		final String format = String.format(sql, a.toLowerCase(),content);

		this.jdbcTemplate.execute(format);

	}

}
