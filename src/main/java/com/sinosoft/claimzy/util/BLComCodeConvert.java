package com.sinosoft.claimzy.util;

import java.sql.ResultSet;

import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLComCodeConvert {
    public String getNewComCode(String comCode) throws Exception{
    	DBManager dbManager = new DBManager();
    	String newComCode = "";
        try{
        	StringBuffer buffer = new StringBuffer(100);
        	buffer.append(" SELECT newcomcode from gynxcomcodemapping  " );
        	buffer.append(	"WHERE oldcomcode = '"+comCode.substring(0,6)+"0000' ");
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.prepareStatement(buffer.toString());
	        ResultSet resultSet = dbManager.executePreparedQuery();
	        if(resultSet.next()){
	        	newComCode =dbManager.getString(resultSet, 1);
	        }
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return newComCode;
    }
}
