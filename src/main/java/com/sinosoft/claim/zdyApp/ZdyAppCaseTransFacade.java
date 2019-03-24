package com.sinosoft.claim.zdyApp;

import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class ZdyAppCaseTransFacade {
	/**
	 * �������ݵķ���
	 * @param zdyAppCaseDto
	 * @throws Exception
	 */
	public void insert(ZdyAppCaseDto zdyAppCaseDto) throws Exception{
		DBManager dbManager = new DBManager();
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //��ʼ����־
            StringBuffer buffer = new StringBuffer(200);
            buffer.append("INSERT INTO ZDYCLAIMDEMAND (");
            buffer.append("registno,");
            buffer.append("data,");
            buffer.append("transflag,");
            buffer.append("transdate");
            buffer.append(") ");
            buffer.append("VALUES(?,?,?,?)");
            dbManager.prepareStatement(buffer.toString());
            dbManager.setString(1, zdyAppCaseDto.getRegistNo());
            dbManager.setString(2, zdyAppCaseDto.getData());
            dbManager.setString(3, zdyAppCaseDto.getTransFlag());
            dbManager.setDateTime(4, zdyAppCaseDto.getTransDate());
            dbManager.executePreparedUpdate();
            //�ύ����
            dbManager.commitTransaction();
		}catch(Exception e){
			dbManager.rollbackTransaction();
            throw e;
		}finally{
			dbManager.close();
		}
	}
	
	/**
	 * �������ݵķ���
	 * @param registNo
	 * @throws Exception 
	 */
	public void update(ZdyAppCaseDto zdyAppCaseDto) throws Exception{
		DBManager dbManager = new DBManager();
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //��ʼ����־
            StringBuffer buffer = new StringBuffer(200);
            buffer.append("UPDATE  ZDYCLAIMDEMAND SET ");
            buffer.append("TRANSFLAG = ?,");
            buffer.append("TRANSDATE = ? ");
            buffer.append("WHERE ");
            buffer.append("registNo = ?");
            dbManager.prepareStatement(buffer.toString());
            //���ø����ֶ�;
            dbManager.setString(1, zdyAppCaseDto.getTransFlag());
            dbManager.setDateTime(2, zdyAppCaseDto.getTransDate());
            //���������ֶ�;
            dbManager.setString(3, zdyAppCaseDto.getRegistNo());

            dbManager.executePreparedUpdate();
            //�ύ����
            dbManager.commitTransaction();
		}catch(Exception e){
			dbManager.rollbackTransaction();
            throw e;
		}finally{
			dbManager.close();
		}
	}
}
