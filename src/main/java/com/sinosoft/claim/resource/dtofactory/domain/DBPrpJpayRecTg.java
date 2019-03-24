package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjpayrec收费登记表的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpJpayRecTg extends DBPrpJpayRecTGBase {
	/**
	 * 构造函数
	 * 
	 * @param dbManager
	 *            资源管理类
	 */
	public DBPrpJpayRecTg(DBManager dbManager) {
		super(dbManager);
	}

	/**
	 * 检查缴费情况
	 * 
	 * @param conditions
	 *            String
	 * @throws Exception
	 * @return Collection
	 */
	public int checkPay(String conditions) throws Exception {
		// 20161216 当3220的自缴为0时,都算交费了
		// 从conditions中提取出险种号判断是否是3220
		String copy = conditions;
		String riskcode = copy.split("'")[1];
		ResultSet resultSet;
		if(riskcode.trim().startsWith("23220")) {
			String check3220 = "select count(*) from prpcplantg where " + conditions +" and payreason='R10' and planfee=0";
			resultSet = dbManager.executeQuery(check3220);
			if (resultSet.next()) {
				if(dbManager.getInt(resultSet, 1) > 0) {
					resultSet.close();
					return -2;
				}
			}
		}
	
		conditions = "(endorseno is null or endorseno='' ) and (" + conditions + ")";
		// 检查缴费情况时排除政府补贴部分 Modif By yehuiquan GuoYuan
	    //conditions = conditions + "AND PayReason NOT LIKE 'RS%'";部分缴费也可以进行理算
		String statement = "SELECT sum(planfee),sum(delinquentfee) FROM prpcplantg where "
				+ conditions;
		resultSet = dbManager.executeQuery(statement);

		double sumPlanfee = 0.0; // 应缴
		double sumDelinquentfee = 0.0; // 欠缴

		// -1,表示根本没有交费 -2表示交了部分，1表示全交了
		// reason:默认为-1，根本没有交费,不能用0，因为0是初始化的值，以后会有问题的
		int intRet = -1;
		if (resultSet.next()) {
			sumPlanfee = dbManager.getDouble(resultSet, 1);
			sumDelinquentfee = dbManager.getDouble(resultSet, 2);
			/**
			 * 检查缴费情况的算法是: 应缴费总和-欠缴费总和==0 则未缴; 欠缴费总和==0 则全缴; 欠缴费总和>0 则缴部分费用;
			 */
			if(sumPlanfee<0){
				throw new Exception("计算所得的应缴费用总和小于零了!!!!!!");
			}
			if(sumPlanfee==0){
				intRet = 0;
			}else{
				if (sumPlanfee - sumDelinquentfee == 0) {
					// 未缴
					intRet = -1;
				} else if (sumDelinquentfee == 0) {
					// 全缴
					intRet = 1;
				} else if (sumDelinquentfee > 0) {
					// 缴部分
					intRet = -2;
				}
			}
		}else{
			// 在prpcPlan表中无满足条件的缴费情况记录,视作已缴费
			intRet = 1;
		}
		resultSet.close();
		return intRet;
	}

	/**
	 * 获得未缴费的期数
	 * 
	 * @param conditions
	 *            String
	 * @throws Exception
	 * @return Collection
	 */
	public int[] getDelinquentfeeTime(String conditions) throws Exception {
		String statement = "SELECT serialno FROM prpcplantg where payno > 0 and delinquentfee >0 and ("
				+ conditions + ")";
		ResultSet resultSet = dbManager.executeQuery(statement);
		List qishuList = new ArrayList();
		int qishu;
		while (resultSet.next()) {
			qishu = dbManager.getInt(resultSet, 1);
			qishuList.add(new Integer(qishu));
		}
		resultSet.close();
		int[] qishuArray = new int[qishuList.size()];
		for (int i = 0; i < qishuList.size(); i++) {
			qishuArray[i] = ((Integer) qishuList.get(i)).intValue();
		}
		return qishuArray;
	}

}
