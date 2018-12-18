package com.cg.TDS.dao;

import com.cg.TDS.entity.TdsDetail;

public interface TDSDao {

	TdsDetail fetchTdsDetail(int uniqueId);

}
