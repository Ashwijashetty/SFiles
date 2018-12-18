package com.cg.TDS.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.TDS.Exception.TDSException;
import com.cg.TDS.entity.TdsDetail;
import com.cg.TDS.service.TDSService;

@RestController
@RequestMapping(value = "/tds")
public class TDSController {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	TDSService tdsService;
/*
 * uri : localhost:8102/user/tds/1
 */	
	@RequestMapping(value = "/{uniqueId}", method = RequestMethod.GET)
	public TdsDetail fetchTdsDetail(@PathVariable int uniqueId) {
		log.info("Getting tds user with ID: {}.", uniqueId);
		TdsDetail tdsDetail = tdsService.fetchTdsDetail(uniqueId);
		log.info("Details fetched Successfully");
		return tdsDetail;

	}
}
