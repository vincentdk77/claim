package com.sinosoft.claim.util;

import java.sql.ResultSet;

import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class CheckInputUtil {
	public boolean checkCityOrPro(String codecname) throws Exception{
		DBManager dbManager = new DBManager();
		ResultSet rs = null;
		boolean isOk = false;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            String checkSql = "select codecode from prpdcode where codecname ='"+codecname+"' and codetype in('CityCode','ProvinceCode') and validstatus = '1'";
            rs = dbManager.executeQuery(checkSql);
            if(rs.next()){
            	isOk = true;
            }
        }catch(Exception exception){
        	exception.printStackTrace();
        }finally{
            dbManager.close();
            rs.close();
        }
		return isOk;
	}
}
