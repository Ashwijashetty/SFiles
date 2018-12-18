package com.cg.dms.dao;

import com.cg.dms.beans.DataInfo;

public interface IDao {

	DataInfo addDetails(DataInfo dataInfo);

	DataInfo viewDetails(Integer id);

}
