package com.cg.dms.service;

import com.cg.dms.beans.DataInfo;

public interface IService {

	DataInfo addDetails(DataInfo dataInfo);

	DataInfo viewDetails(Integer id);

}
