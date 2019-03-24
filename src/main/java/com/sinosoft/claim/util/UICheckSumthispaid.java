package com.sinosoft.claim.util;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.utility.SysConfig;
import com.sinosoft.utility.database.DbPool;

public class UICheckSumthispaid extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String sumthispaid = "";
		String flag = "";
		request.setCharacterEncoding("UTF-8");
		String compensateNo = request.getParameter("compensateNo");
		DbPool dbPool = new DbPool();
		ResultSet rs = null;
		try {
			dbPool.open(SysConfig.getProperty("DDCCDATASOURCE"));
			rs = dbPool.query("select * from Prplcompensate where Compensateno ='"+compensateNo+"'");
			if(rs.next()){
				sumthispaid = rs.getString("sumthispaid");
				flag="true";
			}else{
				flag="false";
			}
			String retMsg = flag+","+sumthispaid;
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(retMsg);
		} catch (Exception e) {
			response.getWriter().write("false");
			e.printStackTrace();
		}finally{
			dbPool.close();
			try{
				rs.close();
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		return null;
	}
}
