package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrplPayeeInfoFacade;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.util.TurnPageUtil;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;

public class UIgetPayeeInfo extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String forward = "success";
		String conditions = "";
		String newAgriFlag = request.getParameter("newAgriFlag");
		String receiverFullName = StringUtils.trimToEmpty(request.getParameter("receiverFullName"));//领款人名称
		String iWhere = request.getParameter("iWhere");
		//每页显示多少条
		int rowsPerPage =Integer.parseInt(AppConfig.get("sysconst.ROWS_PERPAGE"));
        //int rowsPerPage = TurnPageUtil.PERPAGE;
        //页数
        int pageNo = Integer.parseInt(request.getParameter("pageNo")==null?"1":request.getParameter("pageNo")+"");
        
        if(!"".equals(iWhere)&&null!=iWhere){
        	conditions = iWhere;
        }else{
        	if(!"".equals(receiverFullName)&&null!=receiverFullName){
        		conditions = " receiverFullName like '%"+receiverFullName+"%' order by receiverFullName,inputDate";
        	}else{
        		conditions = " 1=1 order by receiverFullName,inputDate";
        	}
        }
        System.out.println("PageNo="+pageNo);
        System.out.println("conditions="+conditions);
		BLPrplPayeeInfoFacade blPrplPayeeInfoFacade = new BLPrplPayeeInfoFacade();
		
		try {
			PageRecord pr = blPrplPayeeInfoFacade.findByConditions(conditions, pageNo, rowsPerPage);
			if(pageNo>pr.getTotalPageCount()){
				pr = blPrplPayeeInfoFacade.findByConditions(conditions, pr.getTotalPageCount(), rowsPerPage);
			}
	        TurnPageDto turnPageDto = new TurnPageDto();// 翻页内容
	        // 查询出来的一页的结构集
			turnPageDto.setResultList((ArrayList)pr.getResult());
			// 当前页号
			turnPageDto.setPageNo(pr.getPageNo());
			// 一页的条数
			turnPageDto.setRecordPerPage(pr.getRowsPerPage());
			// 查询出来的结果的总数
			turnPageDto.setTotalCount(pr.getCount());
			// 返回总的页数
			int a=(pr.getCount())%pr.getRowsPerPage();
			if(a>0){
				turnPageDto.setTotalPage(((pr.getCount())/pr.getRowsPerPage())+1);
			}else{
				turnPageDto.setTotalPage((pr.getCount())/pr.getRowsPerPage());
			}
			
			// 搜索条件
			turnPageDto.setCondition(conditions);
			request.setAttribute("turnPageDto", turnPageDto);
			request.setAttribute("newAgriFlag", newAgriFlag);
			
		} catch (Exception e) {
			response.getWriter().write("false#");
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			// 错误信息处理
			request.setAttribute("errorMessage", stringWriter.toString());
		}
		
		return mapping.findForward(forward);
	}
}
