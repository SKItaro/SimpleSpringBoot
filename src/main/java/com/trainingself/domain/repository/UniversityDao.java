package com.trainingself.domain.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.trainingself.domain.model.University;

@Repository("UniversityDao")
public class UniversityDao {

	private static final Logger logger = LoggerFactory.getLogger(UniversityDao.class);

	@Autowired
	JdbcTemplate jdbc;

	/**
	 * 全件照会
	 *
	 * @return
	 * @throws DataAccessException
	 */
	public List<University> selectALL() throws DataAccessException {

		// UNIVERSITYテーブルのデータを全件取得
		List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM UNIVERSITY");

		// 結果返却用の変数
		List<University> universities = new ArrayList<>();

		// 取得したデータを結果返却用のListに格納していく
		for (Map<String, Object> map : getList) {

			//logger.info(map.toString());

			University university = new University();
			university.setCategory((String) map.get("category"));
			university.setUniversity((String) map.get("university"));

			//結果返却用のListに追加
			universities.add(university);

		}

		return universities;
	}

	/**
	 * カテゴリーによる照会
	 *
	 * @return
	 * @throws DataAccessException
	 */
	public List<University> selectByCategory(String category) throws Exception {

		String[] categoryArray = { "国立", "私立", "公立" };
		List<String> categoryLst = Arrays.asList(categoryArray);
		if (!categoryLst.contains(category)) {
			logger.error("categoryパラメータが不正です", category);
			throw new Exception("categoryパラメータが不正です" + category);
		}

		// UNIVERSITYテーブルのデータを全件取得
		List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM UNIVERSITY WHERE CATEGORY = ?", category);

		// 結果返却用の変数
		List<University> universities = new ArrayList<>();

		// 取得したデータを結果返却用のListに格納していく
		for (Map<String, Object> map : getList) {

			//logger.info(map.toString());

			University university = new University();
			university.setCategory((String) map.get("category"));
			university.setUniversity((String) map.get("university"));

			//結果返却用のListに追加
			universities.add(university);

		}

		return universities;
	}

}
