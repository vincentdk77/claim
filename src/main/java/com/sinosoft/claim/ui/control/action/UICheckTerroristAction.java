package com.sinosoft.claim.ui.control.action;

import java.sql.ResultSet;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.sysframework.reference.DBManager;

public class UICheckTerroristAction extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String AppliInsuredInsuredName=request.getParameter("AppliInsuredInsuredName");
		String AppliInsuredIdentifyNumber=request.getParameter("AppliInsuredIdentifyNumber");
		ServletOutputStream os = response.getOutputStream();
		String flag="0";
		if(AppliInsuredInsuredName==null || "".equals(AppliInsuredInsuredName)||AppliInsuredIdentifyNumber==null || "".equals(AppliInsuredIdentifyNumber)){
		}else{
			DBManager dbManager = new DBManager();
			ResultSet resultSet = null;
			try{
				dbManager.open("ddccDataSource");
				String strSql = "select " 
				+"terroristcode ,"
				+"terroristcname,"
				+"terroristename,"
				+"terroristtype ,"
				+"shortname     ,"
				+"sex           ,"
				+"nationality   ,"
				+"birthdate     ,"
				+"address       ,"
				+"relegation    ,"
				+"purpose       ,"
				+"identifynumber,"
				+"stafflist     ,"
				+"remark        ,"
				+"validstatus   "
	
					+	" from  fxqdb.cc_terrorist where terroristCName='"+AppliInsuredInsuredName+"' and identifyNumber='"+AppliInsuredIdentifyNumber+"'";
				System.out.println(strSql);
				resultSet=dbManager.executeQuery(strSql);
				if(resultSet.next()){
					//不需要返回信息，所以不取值
					flag="1";
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				if(resultSet!=null){
					resultSet.close();
				}
				if(dbManager!=null){
					dbManager.close();
				}
				if(os!=null){
					os.close();
				}
			}
		}
		os.write(flag.getBytes("utf-8"));
		return null;
	}
}
