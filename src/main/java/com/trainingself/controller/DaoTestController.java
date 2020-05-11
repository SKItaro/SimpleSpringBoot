package com.trainingself.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trainingself.domain.model.Reserve;
import com.trainingself.domain.model.University;
import com.trainingself.domain.repository.ReserveDao;
import com.trainingself.domain.repository.UniversityDao;

@Controller
public class DaoTestController {


	private static final Logger logger = LoggerFactory.getLogger(DaoTestController.class);

	@Autowired
	ReserveDao reserveDao;

	@Autowired
	UniversityDao universityDao;

	//----------------------------Daoをテストするためのドライバー----------------------

	/**
	 * 予約を登録する
	 */
	@RequestMapping(value = "/ReserveRegist", method = RequestMethod.POST)
	public String reserveRegist(Locale locale, Model model) {

		logger.debug("ReserveRegist.start");

		Reserve reserveDto = new Reserve();
		reserveDto.setRequestDate1(new Date());
		reserveDto.setRequestDate2(new Date());
		reserveDto.setName("fuga tarou");
		reserveDto.setSchool("hoge university 情報学科");
		reserveDto.setDev(true);
		reserveDto.setMachingPoint("マッチングポイント");

		int resultCount = reserveDao.insertOne(reserveDto);

		logger.debug("resultCount:" + resultCount);

		logger.debug("ReserveRegist.end");

		return "home";
	}

	/**
	 * 予約を照会する
	 */
	@RequestMapping(value = "/ReserveQuery", method = RequestMethod.GET)
	public String reserveQuery(Locale locale, Model model) {

		logger.info("ReserveQuery.start");

		List<Reserve> resultLst = reserveDao.selectALL();

		for (Reserve reserve : resultLst) {
			logger.info(reserve.toString());
		}

		logger.info("ReserveQuery.end");

		return "home";
	}

	/**
	 * 予約を照会する
	 */
	@RequestMapping(value = "/ReserveQueryOne", method = RequestMethod.GET)
	public String reserveQueryOne(Locale locale, Model model) {

		logger.info("ReserveQuery.start");

		Reserve reserve = reserveDao.selectByPk("1");

		logger.info(reserve.toString());

		logger.info("ReserveQuery.end");

		return "home";
	}

	/**
	 * 予約を照会する
	 */
	@RequestMapping(value = "/ReserveQueryFromTo", method = RequestMethod.GET)
	public String reserveQueryFromTo(Locale locale, Model model) {

		logger.info("ReserveQuery.start");

		Date fromDate = new Date();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fromDate);
		calendar.add(Calendar.DATE, 7);
		Date toDate = calendar.getTime();

		List<Reserve> resultLst = reserveDao.selectCreateDateFromTo(fromDate, toDate);

		for (Reserve reserve : resultLst) {
			logger.info(reserve.toString());
		}

		logger.info("ReserveQuery.end");

		return "home";
	}
	/**
	 * 予約内容を一覧表示する(登録内容確認用)
	 * http://localhost:8080/ReserveAll
	 *
	 */
	@RequestMapping(value = "/dumpReserve", method = RequestMethod.GET)
	public String dumpReserve(Locale locale, Model model) {

		List<Reserve> reslut = reserveDao.selectALL();

		model.addAttribute("queryResult", reslut);


		return "gakusei/queryReserve";
	}

	//------------------------------------------------------------------------

	@RequestMapping(value = "/dumpUniversity", method = RequestMethod.GET)
	public String dumpUniversity(Locale locale, Model model) {

		List<University> reslut = universityDao.selectALL();

		model.addAttribute("queryResult", reslut);


		return "./gakusei/gakuseiTop";
	}

}
