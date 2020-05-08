package com.trainingself.domain.repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.trainingself.domain.model.Reserve;

@Repository("ReserveDao")
public class ReserveDao {

	private static final Logger logger = LoggerFactory.getLogger(ReserveDao.class);

	@Autowired
	JdbcTemplate jdbc;

	enum cols {
		RECEPTION_NO, REQUEST_DATE1, REQUEST_DATE2, NAME, SCHOOL, DEV, MACHING_POINT, CREATE_DATE, UPDATE_DATE
	}

	/**
	 * 1件登録
	 *
	 * @param Reserve
	 * @return
	 * @throws DataAccessException
	 */
	public int insertOne(Reserve reserve) throws DataAccessException {

		//１件登録
		int rowNumber = jdbc.update("INSERT INTO RESERVE_MEETING("
				+ "REQUEST_DATE1,"
				+ "REQUEST_DATE2,"
				+ "NAME,"
				+ "SCHOOL,"
				+ "DEV,"
				+ "MACHING_POINT,"
				+ "CREATE_DATE,"
				+ "UPDATE_DATE"
				+ ")"
				+ " VALUES(?, ?,?, ?, ?, ?, ?, ?)",
				reserve.getRequestDate1(),
				reserve.getRequestDate2(),
				reserve.getName(),
				reserve.getSchool(),
				reserve.getDev(),
				reserve.getMachingPoint(),
				new Date(),
				new Date());

		return rowNumber;
	}


	/**
	 * 全件照会
	 *
	 * @return
	 * @throws DataAccessException
	 */
	public List<Reserve> selectALL() throws DataAccessException {

		// RESERVE_MEETINGテーブルのデータを全件取得
		List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM RESERVE_MEETING");

		// 結果返却用の変数
		List<Reserve> reserveList = new ArrayList<>();

		// 取得したデータを結果返却用のListに格納していく
		for (Map<String, Object> map : getList) {

			logger.info(map.toString());

			Reserve reserve = this.mapToReserve(map);
			//結果返却用のListに追加
			reserveList.add(reserve);

		}

		return reserveList;
	}

	/**
	 * 1件 照会 (by pk)
	 * @param key (receptionNo)
	 * @return
	 * @throws DataAccessException
	 */

	public Reserve selectByPk(String primaryKey) throws DataAccessException {

		// RESERVE_MEETINGテーブルのデータを全件取得
		Map<String,Object> resultMap = jdbc.queryForMap("SELECT * FROM RESERVE_MEETING where RECEPTION_NO = ? ",
				Integer.valueOf(primaryKey));

		return this.mapToReserve(resultMap);

	}

	/**
	 * 希望日１ 範囲 照会 (REQUEST_DATE1 From-FromTo)
	 * @param from Date REQUEST_DATE1
	 * @param to Date REQUEST_DATE1
	 * @return
	 * @throws DataAccessException
	 */

	public List<Reserve> selectCreateDateFromTo(Date from, Date to) throws DataAccessException {

		// RESERVE_MEETINGテーブルのデータを全件取得
		List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM RESERVE_MEETING where REQUEST_DATE1 BETWEEN  ? and ?",
				from,
				to
				);

		// 結果返却用の変数
		List<Reserve> reserveList = new ArrayList<>();

		// 取得したデータを結果返却用のListに格納していく
		for (Map<String, Object> map : getList) {

			Reserve reserve = this.mapToReserve(map);
			//結果返却用のListに追加
			reserveList.add(reserve);

		}

		return reserveList;
	}


	/**
	 * DB照会結果Map から Reserve を生成して返却する
	 * @param map
	 * @return Reserve
	 */
	private Reserve mapToReserve(Map<String,Object> map) {
		Reserve reserve = new Reserve();
		Integer receptionNo = (Integer) map.get(cols.RECEPTION_NO.toString());
		reserve.setReceptionNo(receptionNo.toString());
		reserve.setRequestDate1((Date) map.get(cols.REQUEST_DATE1.toString()));
		reserve.setRequestDate2((Date) map.get(cols.REQUEST_DATE2.toString()));
		reserve.setName((String) map.get(cols.NAME.toString()));
		reserve.setSchool((String) map.get(cols.SCHOOL.toString()));
		reserve.setDev((boolean) map.get(cols.DEV.toString()));
		reserve.setCreateDate((Timestamp) map.get(cols.CREATE_DATE.toString()));
		reserve.setUpdateDate((Timestamp) map.get(cols.UPDATE_DATE.toString()));
		reserve.setMachingPoint((String) map.get(cols.MACHING_POINT.toString()));

		return reserve;

	}
}
