package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjpayrec�շѵǼǱ�����ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpJpayRecTg extends DBPrpJpayRecTGBase {
	/**
	 * ���캯��
	 * 
	 * @param dbManager
	 *            ��Դ������
	 */
	public DBPrpJpayRecTg(DBManager dbManager) {
		super(dbManager);
	}

	/**
	 * ���ɷ����
	 * 
	 * @param conditions
	 *            String
	 * @throws Exception
	 * @return Collection
	 */
	public int checkPay(String conditions) throws Exception {
		// 20161216 ��3220���Խ�Ϊ0ʱ,���㽻����
		// ��conditions����ȡ�����ֺ��ж��Ƿ���3220
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
		// ���ɷ����ʱ�ų������������� Modif By yehuiquan GuoYuan
	    //conditions = conditions + "AND PayReason NOT LIKE 'RS%'";���ֽɷ�Ҳ���Խ�������
		String statement = "SELECT sum(planfee),sum(delinquentfee) FROM prpcplantg where "
				+ conditions;
		resultSet = dbManager.executeQuery(statement);

		double sumPlanfee = 0.0; // Ӧ��
		double sumDelinquentfee = 0.0; // Ƿ��

		// -1,��ʾ����û�н��� -2��ʾ���˲��֣�1��ʾȫ����
		// reason:Ĭ��Ϊ-1������û�н���,������0����Ϊ0�ǳ�ʼ����ֵ���Ժ���������
		int intRet = -1;
		if (resultSet.next()) {
			sumPlanfee = dbManager.getDouble(resultSet, 1);
			sumDelinquentfee = dbManager.getDouble(resultSet, 2);
			/**
			 * ���ɷ�������㷨��: Ӧ�ɷ��ܺ�-Ƿ�ɷ��ܺ�==0 ��δ��; Ƿ�ɷ��ܺ�==0 ��ȫ��; Ƿ�ɷ��ܺ�>0 ��ɲ��ַ���;
			 */
			if(sumPlanfee<0){
				throw new Exception("�������õ�Ӧ�ɷ����ܺ�С������!!!!!!");
			}
			if(sumPlanfee==0){
				intRet = 0;
			}else{
				if (sumPlanfee - sumDelinquentfee == 0) {
					// δ��
					intRet = -1;
				} else if (sumDelinquentfee == 0) {
					// ȫ��
					intRet = 1;
				} else if (sumDelinquentfee > 0) {
					// �ɲ���
					intRet = -2;
				}
			}
		}else{
			// ��prpcPlan���������������Ľɷ������¼,�����ѽɷ�
			intRet = 1;
		}
		resultSet.close();
		return intRet;
	}

	/**
	 * ���δ�ɷѵ�����
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
