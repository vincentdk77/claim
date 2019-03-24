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
		String receiverFullName = StringUtils.trimToEmpty(request.getParameter("receiverFullName"));//���������
		String iWhere = request.getParameter("iWhere");
		//ÿҳ��ʾ������
		int rowsPerPage =Integer.parseInt(AppConfig.get("sysconst.ROWS_PERPAGE"));
        //int rowsPerPage = TurnPageUtil.PERPAGE;
        //ҳ��
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
	        TurnPageDto turnPageDto = new TurnPageDto();// ��ҳ����
	        // ��ѯ������һҳ�Ľṹ��
			turnPageDto.setResultList((ArrayList)pr.getResult());
			// ��ǰҳ��
			turnPageDto.setPageNo(pr.getPageNo());
			// һҳ������
			turnPageDto.setRecordPerPage(pr.getRowsPerPage());
			// ��ѯ�����Ľ��������
			turnPageDto.setTotalCount(pr.getCount());
			// �����ܵ�ҳ��
			int a=(pr.getCount())%pr.getRowsPerPage();
			if(a>0){
				turnPageDto.setTotalPage(((pr.getCount())/pr.getRowsPerPage())+1);
			}else{
				turnPageDto.setTotalPage((pr.getCount())/pr.getRowsPerPage());
			}
			
			// ��������
			turnPageDto.setCondition(conditions);
			request.setAttribute("turnPageDto", turnPageDto);
			request.setAttribute("newAgriFlag", newAgriFlag);
			
		} catch (Exception e) {
			response.getWriter().write("false#");
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			// ������Ϣ����
			request.setAttribute("errorMessage", stringWriter.toString());
		}
		
		return mapping.findForward(forward);
	}
}
