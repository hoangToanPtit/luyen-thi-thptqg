package com.luyenthithpt.dao;

import java.util.List;

import com.luyenthithpt.mapper.IMapper;



public interface IGenericDAO<T> {
	List<T> query(String sql, IMapper<T> mapper, Object...parameters); //get data
	T findOne(String sql, IMapper<T> mapper, Object...parameters);
	void update(String sql, Object...parameters); // update, delete data
	Integer insert(String sql, Object... parameters); // add data
	Object getAttribute(String sql, Object... parameters); //get attribute
}
