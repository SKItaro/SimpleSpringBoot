package com.trainingself.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.trainingself.domain.model.Reserve;
import com.trainingself.form.gakusei.EntryInputForm;
import com.trainingself.form.gakusei.MendanForm;
import com.trainingself.service.ReserveService;

@Controller
@SessionAttributes(value = { "mendanForm","entryInputForm" })
public class GakuseiController {

	private static final Logger logger = LoggerFactory.getLogger(GakuseiController.class);

	@Autowired
	ReserveService reserveSrv;

	/**
	 * 学生トップ画面を表示
	 * http://localhost:8080/
	 *
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String gakuseiTop(Locale locale, Model model) {
		return "gakusei/gakuseiTop";
	}

	/**
	 * トップ画面の[次へ] => 面談日程伺い画面
	 *
	 */
	@RequestMapping(value = "/topNext", method = RequestMethod.GET)
	public String topNext(Model model) {

		MendanForm form = new MendanForm();
		form.setRequestDate1(new Date());

		model.addAttribute("mendanForm", form);
		return "gakusei/menndanInput";
	}

	/**
	 * 面談日程伺い画面の[次へ] => エントリー画面へ
	 * @throws ParseException
	 *
	 */
	@RequestMapping(value = "/menndanInputNext", method = RequestMethod.POST)
	public String menndanInputNext(MendanForm inputForm, Model model) throws ParseException {


		//入力された日付と時刻を結合してDate型に変換
		inputForm.setRequestDate1(convertToDate(inputForm.getReqdate1(), inputForm.getReqtime1()));
		inputForm.setRequestDate2(convertToDate(inputForm.getReqdate2(), inputForm.getReqtime2()));

		logger.info(inputForm.toString());
		EntryInputForm form = new EntryInputForm();
		model.addAttribute("entryInputForm", form);

		return "gakusei/entryInput";
	}

	/**
	 * エントリー画面入力の[次へ] => 確認画面へ
	 *
	 */
	@RequestMapping(value = "/entryInputNext", method = RequestMethod.POST)
	public String entryInputNext(EntryInputForm inputForm, Model model) {

		logger.info(inputForm.toString());

		return "gakusei/confirm";
	}

	/**
	 * 確認画面の[登録] => 完了画面へ
	 * @throws Exception
	 *
	 */
	@RequestMapping(value = "/confirmNext", method = RequestMethod.POST)
	public String confirmNext(MendanForm mendanForm, EntryInputForm entryInputForm,Model model) throws Exception {
		Reserve reserve = new Reserve();
		//Reserveドメインへの詰め替えが面倒なので同項目名のCopyがされることが期待値なのでBeanUtilで実装
		BeanUtils.copyProperties(mendanForm, reserve);
		BeanUtils.copyProperties(entryInputForm,reserve);

		if(reserveSrv.addReserve(reserve)) {
			return "gakusei/finish";
		}else {
			throw new Exception("予期せぬエラー！");
		}
	}




	/**
	 * 日付けと時刻を結合して 新しいDate型オブジェクトを返却します
	 * (画面からの入力値の型調整)
	 * @param day (yyyy年MM月dd日)
	 * @param time (00:00)
	 * @return
	 * @throws ParseException
	 */
	private Date convertToDate(String day, String time) throws ParseException {
		String strDateTime = day + time;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日hh:mm");
		try {
			return dateFormat.parse(strDateTime);
		} catch (ParseException ex) {
			logger.error("日付けConvertに失敗しました期待 yyyy年MM月dd日,00:00", strDateTime);
			throw ex;
		}
	}



}
