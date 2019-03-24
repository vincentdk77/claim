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

public class UISearchBankNumberFacade extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String bankNumber = "";
		//是否为原有银行联行号0：是  1:人工新增数据 2:待新增数据
		String flag = "";
		request.setCharacterEncoding("UTF-8");
		String bankName = request.getParameter("bank1");
		DbPool dbPool = new DbPool();
		ResultSet rs = null;
		try {
			dbPool.open(SysConfig.getProperty("DDCCDATASOURCE"));
			rs = dbPool.query("select bank_number,head_bank_flag from prpdbankbranch where bank_name ='"+bankName+"'");
			if(rs.next()){
				bankNumber = rs.getString("bank_number");
				flag = rs.getString("head_bank_flag");
			}else{
				flag = "2";//待新增数据
			}
			String retMsg = bankNumber+","+flag;
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
