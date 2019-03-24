package com.sinosoft.claim.zdyApp;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;


import com.sinosoft.assistant.services.PushCaseWsImpl;
import com.sinosoft.assistant.services.PushCaseWsImplServiceLocator;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class ZdyAutoCaseTrans {
	/**
	 * 驻点员App案件推送定时任务补推
	 * @return
	 * @throws Exception 
	 */
	public String autoCaseTransInfo() throws Exception{
		String msg = "";
		String registNo = null;
		String data = null;
		TransData transData = null;
		String transFlag = "0";
		DBManager dbManager = new DBManager();
		try{
			//防止并发的操作
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			String sql =" insert into prplhandletask(registno,nodetype,lossitemcode) values('1','ZDYAPP','1')";
			dbManager.beginTransaction();
			dbManager.executeUpdate(sql);
			dbManager.commitTransaction();
			
			ArrayList<TransData> dataCellections = new ArrayList<TransData>();
			dataCellections = findCaseTransData();
			for (Iterator iter = dataCellections.iterator(); iter.hasNext();){
				transData = (TransData) iter.next();
				registNo = transData.getRegistNo();
				data = transData.getData();
				PushCaseWsImplServiceLocator service = new PushCaseWsImplServiceLocator();
	           	PushCaseWsImpl impl = service.getacceptPushCaseService();
	           	String result = impl.accept(data);
	           	System.err.print("result=="+result);
	           	if("SUCCESS".equals(result)){
	           		  msg = "案件信息补推成功！";
	           		  transFlag = "1";
	           		  DateTime transDate = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND);//案件推送时间（驻点员App）
	             	  ZdyAppCaseDto zdyAppCaseDto = new ZdyAppCaseDto();
	             	  zdyAppCaseDto.setRegistNo(registNo);
	             	  zdyAppCaseDto.setData(data);

	             	  zdyAppCaseDto.setTransFlag(transFlag);
	             	  zdyAppCaseDto.setTransDate(transDate);
	             	  ZdyAppCaseTransFacade zdyAppCaseTransFacade = new ZdyAppCaseTransFacade();
	             	  try{
	             		 zdyAppCaseTransFacade.update(zdyAppCaseDto);
	             	  }catch(Exception ee){
	             		  ee.printStackTrace();
	             	  }
	           	}else{
	           		msg = "案件信息补推失败！";
	           	}
			}
			//删除防止并发的数据
			String sqlDel =" delete from prplhandletask where registno='1' and nodetype='ZDYAPP' and lossitemcode='1'";
			dbManager.beginTransaction();
			dbManager.executeUpdate(sqlDel);
			dbManager.commitTransaction();
		}catch(Exception e){
			e.printStackTrace();
			//删除防止并发的数据
			String sqlDel =" delete from prplhandletask where registno='1' and nodetype='ZDYAPP' and lossitemcode='1'";
			dbManager.beginTransaction();
			dbManager.executeUpdate(sqlDel);
			dbManager.commitTransaction();
		}finally{
			dbManager.close();
		}
		return msg;
		
	}
	
	
	/**
	 * 查询需要补推得案件信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<TransData> findCaseTransData() throws Exception{
		String strWhere = "";
		StringBuffer buffer = new StringBuffer(200);
		buffer.append("Select registno,data ");
		buffer.append("From ZDYCLAIMDEMAND ");
		buffer.append("Where transflag='0' ");
		strWhere = buffer.toString();
		DBManager dbManager = new DBManager();
		ResultSet resultSet = null;
		ArrayList resultList = new ArrayList();
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			resultSet = dbManager.executeQuery(strWhere);
			while (resultSet.next()) {
				TransData transData = new TransData();
				transData.setRegistNo(dbManager.getString(resultSet, 1));
				transData.setData(dbManager.getString(resultSet, 2));
				resultList.add(transData);
			}
		} catch (Exception exception) {
			throw exception;
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			dbManager.close();
		}
		return resultList;
		
	}
}
