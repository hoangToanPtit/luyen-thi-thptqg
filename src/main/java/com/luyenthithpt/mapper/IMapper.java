package com.luyenthithpt.mapper;

import java.sql.ResultSet;

public interface IMapper<T> {
	T map(ResultSet resultSet);
}
