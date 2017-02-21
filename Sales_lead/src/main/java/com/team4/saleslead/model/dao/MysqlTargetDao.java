package com.team4.saleslead.model.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.team4.saleslead.model.dto.Target;
import com.team4.saleslead.model.mapper.TargetMapper;

@Repository("mysqlTargetDao")
public class MysqlTargetDao implements TargetDao {

	@Autowired
	@Qualifier("targetMapper")
	private TargetMapper targetMapper;
	
	
	@Override
	public List<Target> selectAllId() {

		return targetMapper.selectAllId();
	}

	
}
