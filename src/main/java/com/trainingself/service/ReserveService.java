package com.trainingself.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainingself.domain.model.Reserve;
import com.trainingself.domain.repository.ReserveDao;

@Service
public class ReserveService {

	@Autowired
	ReserveDao reserveDao;

	/**
	 * 予約可能な日程かチェックする
	 * @return true:予約OK fale:予約NG
	 */
	public boolean checkRequestDate(Date reqDate1,Date reqDate2) {

		//TODO : 下記のような相関チェックを行う処理を追加してみると良い

		//同一希望日の登録がすでに５件以上ある場合はエラーにする。

		//同一氏名の登録がある場合にエラーにする。


		return true;

	}

	/**
	 * 予約を追加する
	 * @param reserve
	 * @return
	 */
	public boolean addReserve(Reserve reserve) {

		int count = reserveDao.insertOne(reserve);

		if (count == 1) {
			return true;
		} else {
			return false;
		}
	}

}
