package com.team4.saleslead.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.team4.saleslead.model.dao.TargetDao;
import com.team4.saleslead.model.dto.Target;

@Service("targetService")
public class TargetServiceImpl implements TargetService {

	@Autowired
	@Qualifier("mysqlTargetDao")
	private TargetDao targetDao;


	@Override
	public List<Target> selectAllId() {
		
		return targetDao.selectAllId();
	}

	



}
