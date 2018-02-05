package com.jgc.salt.service;

import com.jgc.salt.dao.IdMapper;
import com.jgc.salt.entity.Id;
import com.jgc.salt.entity.IdCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class IdService {

	private static final Logger logger = LoggerFactory.getLogger(IdService.class);

	private AtomicLong currentVal = new AtomicLong(0L);

	private AtomicLong maxVal = new AtomicLong(0L);

	/**
	 *  每次生成50个id
	 */
	private static final long FETCH_SIZE = 50;

	@Resource
	private IdMapper idMapper;

	@PostConstruct
	public void init() {
		fecth();
	}

	/**
	 * 获取自增ID序列
	 * 
	 * @return
	 */
	public Long nextId() {

		if (currentVal.get() >= maxVal.get()) {

			synchronized (this) {

				if (currentVal.get() >= maxVal.get()) {
					fecth();
				}
			}

		}

		return currentVal.incrementAndGet();
	}

	private void fecth() {

		int retry = 0;

		while (retry < 10) {

			IdCriteria idCriteria = new IdCriteria();
			idCriteria.setLimitEnd(1);

			final List<Id> ids = idMapper.selectByExample(idCriteria);

			int row = idMapper.inc(FETCH_SIZE, ids.get(0).getLastId());

			if (row > 0) {

				currentVal.set(ids.get(0).getLastId());

				maxVal.set(ids.get(0).getLastId() + FETCH_SIZE);

				break;
			}

			retry++;
		}

		if (retry >= 10) {
			logger.error("update id failed after 10 times.");
			throw new RuntimeException("update id failed after 10 times.");
		}
	}
}
