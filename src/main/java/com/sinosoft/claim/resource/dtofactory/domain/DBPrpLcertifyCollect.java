package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcertifyCollectDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcertifyCollect的数据访问对象类<br>
 * 创建于 2004-07-05 17:16:00.029<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLcertifyCollect extends DBPrpLcertifyCollectBase {
	private static Log log = LogFactory.getLog(DBPrpLcertifyCollect.class);

	/**
	 * 构造函数
	 * @param dbManager 资源管理类
	 */
	public DBPrpLcertifyCollect(DBManager dbManager) {
		super(dbManager);
	}

	/**
	 * 按条件从prplcertifyCollect表,prplregist表和prplclaimstatus表中查询多条数据
	 * @param conditions String
	 * @param pageNo int
	 * @param rowsPerPage int
	 * @throws Exception
	 * @return Collection
	 * Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件，在查询结果中增加案件状态
	 */
	public Collection findByQueryConditions(String conditions, int pageNo,
			int rowsPerPage) throws Exception {
		String statement = "Select DISTINCT a.BusinessNo,"
				+ "a.StartDate, "
				+ "a.OperatorCode, "
				+ "a.CollectFlag, "
				+ "b.OperateDate, "
				+ "b.Status, "
				+ "b.RiskCode, "
				+ "c.LicenseNo From (select * from PrpLClaimStatus where NodeType='certi') b Right JOIN PrpLcertifyCollect a ON a.BusinessNo = b.BusinessNo LEFT JOIN prplregist c ON b.BusinessNo = c.registNo where"
				+ conditions;
		//"b.Status,c.LicenseNo  From (select * from PrpLClaimStatus where NodeType='check') b LEFT JOIN PrpLcheck a ON a.RegistNo = b.BusinessNo left join prplregist c on c.registno=b.BusinessNo where"+conditions ;
		log.debug(statement);


		Collection collection = new ArrayList();
		PrpLcertifyCollectDto prpLcertifyCollectDto = null;
		ResultSet resultSet = dbManager.executeQuery(statement);
		int count = 0;
		if (pageNo > 1) {
			dbManager.locate(resultSet, rowsPerPage * (pageNo - 1));
		}

		while (resultSet.next()) {
			count++;
			if (pageNo > 0) {
				if (count > rowsPerPage) {
					break;
				}
			}
			prpLcertifyCollectDto = new PrpLcertifyCollectDto();
			prpLcertifyCollectDto.setBusinessNo(dbManager.getString(resultSet,
					1));
			prpLcertifyCollectDto.setStartDate(dbManager.getDateTime(resultSet,
					DateTime.YEAR_TO_DAY, 2));
			prpLcertifyCollectDto.setOperatorCode(dbManager.getString(
					resultSet, 3));
			prpLcertifyCollectDto.setCollectFlag(dbManager.getString(resultSet,
					4));
			prpLcertifyCollectDto.setOperateDate(dbManager.getDateTime(
					resultSet, DateTime.YEAR_TO_DAY, 5));
			prpLcertifyCollectDto.setStatus(dbManager.getString(resultSet, 6));
			prpLcertifyCollectDto
					.setRiskCode(dbManager.getString(resultSet, 7));
			collection.add(prpLcertifyCollectDto);
		}
		resultSet.close();
		log.info("DBPrpLcertifyCollect.findByConditions() success!");
		return collection;
	}

	//add by zhaolu 20060803 start
	public int getCount1(String conditions) throws Exception {
		int count = -1;
		String statement = "select count(DISTINCT a.BusinessNo) From (select * from PrpLClaimStatus where NodeType='certi') b Right JOIN PrpLcertifyCollect a ON a.BusinessNo = b.BusinessNo LEFT JOIN prplregist c ON b.BusinessNo = c.registNo where"
				+ conditions;
				 statement = SqlUtils.getWherePartForGetCount(statement);
		log.debug(statement);
		ResultSet resultSet = dbManager.executeQuery(statement);
		resultSet.next();
		count = dbManager.getInt(resultSet, 1);
		resultSet.close();
		log.info("DBPrpLcertifyCollect.getCount1() success!");
		return count;
	}
	//add by zhaolu 20060803 end

}
