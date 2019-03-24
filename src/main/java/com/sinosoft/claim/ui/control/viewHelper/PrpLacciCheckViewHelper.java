package com.sinosoft.claim.ui.control.viewHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.ui.model.PrpLacciCheckFindByConditionsCommand;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.ParamUtils;
/**
 * 说明：原来的文件丢失，用于显示历次调查信息
 * @author qinyongli 
 *  created 2005-9-1 
 */
public class PrpLacciCheckViewHelper{
	 /**
	  * 默认构造函数
	  */
	 public PrpLacciCheckViewHelper(){}
     /**
      * 返回历次调查信息列表
      * @param request
      * @param pageNo
      * @param recordPerPage
      * @throws Exception
      */
	 public void policyListToView(HttpServletRequest request,String registNo,String pageNo,String recordPerPage) throws Exception{

	 	    String conditions = " registNo = '"+registNo+"' ";
	 	    PrpLregistDto prpLregistDto = null;    
            this.query(request,pageNo,recordPerPage,conditions);
	 }	 
	 /**
	  * 
	  * @param request
	  * @param response
	  * @throws Exception
	  */
	 public void query(HttpServletRequest request,String pageNo,String recordPerPage,String conditions) throws Exception {
        ParamUtils paramUtils = new ParamUtils(request);  
        HttpSession session = request.getSession();
        UserDto user = (UserDto) (session.getAttribute("user"));
        System.out.println(conditions);
        user.setQueryCondition("prpLacciCheck", conditions, Integer.parseInt(pageNo), Integer.parseInt(recordPerPage));
        PrpLacciCheckFindByConditionsCommand command = new PrpLacciCheckFindByConditionsCommand(conditions, Integer.parseInt(pageNo),
        		Integer.parseInt(recordPerPage));
        PageRecord pageRecord = (PageRecord) command.execute();

        PrpLregistDto prpLregistDto = new PrpLregistDto();
        prpLregistDto.setRegistList(pageRecord.getResult());
        
        TurnPageDto turnPageDto= new TurnPageDto();
        turnPageDto.setPageNo(pageRecord.getPageNo());
        turnPageDto.setRecordPerPage(Integer.parseInt(recordPerPage));
        turnPageDto.setTotalCount(pageRecord.getCount());
        turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
      
        prpLregistDto.setTurnPageDto(turnPageDto);
        request.setAttribute("pageview", turnPageDto);
        request.setAttribute("prpLregistDto",prpLregistDto);
    }
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	 public void queryContinue(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ParamUtils paramUtils = new ParamUtils(request);
        HttpSession session = request.getSession();
        UserDto user = (UserDto) (session.getAttribute("user"));
        String conditions = "1=1";
        if (user.getQueryCondition().getQueryKey().equals("prpLacciCheck")) {
            conditions = user.getQueryCondition().getConditions();
        }
        int pageNo = paramUtils.getIntParameter("pageNo", user.getQueryCondition().getPageNo());
        int rowsPerPage = paramUtils.getIntParameter("rowsPerPage", user.getQueryCondition().getRowsPerPage());
        //更新查询条件
        user.setQueryCondition("prpLacciCheck", conditions, pageNo, rowsPerPage);
        PrpLacciCheckFindByConditionsCommand command = new PrpLacciCheckFindByConditionsCommand(conditions, pageNo,
                rowsPerPage);
        PageRecord pageRecord = (PageRecord) command.execute();
        PrpLregistDto prpLregistDto = new PrpLregistDto();
        prpLregistDto.setRegistList(pageRecord.getResult());
        
        TurnPageDto turnPageDto= new TurnPageDto();
        turnPageDto.setPageNo(pageRecord.getPageNo());
        turnPageDto.setRecordPerPage(20);
        turnPageDto.setTotalCount(pageRecord.getCount());
        turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
      
        prpLregistDto.setTurnPageDto(turnPageDto);
        request.setAttribute("pageview", turnPageDto);
        request.setAttribute("prpLregistDto",prpLregistDto);
    }
	 
	 
	 
}