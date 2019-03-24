package com.sinosoft.claim.ui.control.viewHelper;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.bl.facade.BLPrpDcompanyFacade;
import com.sinosoft.claim.bl.facade.BLPrplareasettingFacade;
import com.sinosoft.claim.dto.custom.AreaSettingDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.dto.domain.PrplareasettingDto;
import com.sinosoft.claim.ui.control.action.UIAreaSettingAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.sysframework.common.datatype.PageRecord;

public class AreaSettingViewHelper {
	
	public void findPrplAreaSettingEdit(HttpServletRequest httpServletRequest,String handledept) throws Exception{
		ArrayList<PrpDcompanyDto> prpDcompanyDtoList = new ArrayList<PrpDcompanyDto>();
		BLPrpDcompanyFacade blPrpDcompanyFacade = new BLPrpDcompanyFacade();
		String sql = " 1=1 And companyflag='1' Connect By uppercomcode = Prior comcode Start With comcode='"+handledept+"'";
		prpDcompanyDtoList = (ArrayList<PrpDcompanyDto>) blPrpDcompanyFacade.findByConditions(sql);
		
		httpServletRequest.setAttribute("handledept", handledept);
		httpServletRequest.setAttribute("prpDcompanyDtoList", prpDcompanyDtoList);
	}
	
	public AreaSettingDto viewToDto(HttpServletRequest httpServletRequest,UserDto user){
		String editType = httpServletRequest.getParameter("editType");
		AreaSettingDto areaSettingDto = new AreaSettingDto();
		ArrayList<PrplareasettingDto> prplareasettingDtoList = new ArrayList<PrplareasettingDto>();
		String handledept 		= httpServletRequest.getParameter("handledept");		//班表机构
		String[] indexId		= httpServletRequest.getParameterValues("indexId");		//序号
		String[] id				= httpServletRequest.getParameterValues("id");			//序号
		String[] handlercode	= httpServletRequest.getParameterValues("handlercode");	//查勘员工号
		String[] handlername	= httpServletRequest.getParameterValues("handlername");	//查勘员
		String[] area			= httpServletRequest.getParameterValues("area");		//作业区域
		String[] tel			= httpServletRequest.getParameterValues("tel");			//电话
		String[] flowintimePage			= httpServletRequest.getParameterValues("flowintime");			//录入时间
		//录入时间
		Date date = new Date();
		DateFormat df = DateFormat.getDateTimeInstance();
		String flowinTime = df.format(date);											//录入时间
		PrplareasettingDto prplareasettingDto = null;
		if(indexId != null && !"".equals(indexId)){
			for(int i=0;i<indexId.length;i++){
				prplareasettingDto = new PrplareasettingDto();
				prplareasettingDto.setId(id[i]);
				prplareasettingDto.setHandlercode(handlercode[i]);
				prplareasettingDto.setHandledept(handledept);
				prplareasettingDto.setHandlername(handlername[i]);
				prplareasettingDto.setArea(area[i]);
				prplareasettingDto.setTel(tel[i]);
				prplareasettingDto.setOperator(user.getUserName());
				prplareasettingDto.setOperatorid(user.getUserCode());
				if("ADD".equals(editType)){
					prplareasettingDto.setFlowintime(flowinTime);
				}
				if("EDIT".equals(editType)){
					if(flowintimePage[i] == null || "".equals(flowintimePage[i])){
						prplareasettingDto.setFlowintime(flowinTime);
					}else{
						prplareasettingDto.setFlowintime(flowintimePage[i]);
						prplareasettingDto.setModifytime(flowinTime);
					}
				}
				prplareasettingDto.setClasscode("99");//非车险查勘区域险类都设置‘99’，车险查勘区域设置险类设置‘05’
				prplareasettingDtoList.add(prplareasettingDto);
			}
		}
		areaSettingDto.setPrplareasettingDtoList(prplareasettingDtoList);
		
		return areaSettingDto;
		
	}
	
	public void setAreaSettingToDtoView(HttpServletRequest httpServletRequest,String handledept,String handlercode) throws Exception{
		String conditions	= " 1=1";
		UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
		if(handledept != null &&"".equals(handledept.trim())){
			handledept = user.getComCode();
		}
		//conditions = conditions + StringConvert.convertString("handledept", handledept, "=");
		if(handledept != null && !"".equals(handledept)){
			conditions = conditions + "and handledept In (Select comcode From Prpdcompany t Where 1=1  Connect By t.uppercomcode = Prior t.comcode Start With t.comcode='"+handledept+"')";
		}
		conditions = conditions + StringConvert.convertString("handlercode", handlercode, "=");
		//String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
		String recordPerPage = "2";
		String pageNo     	 = httpServletRequest.getParameter("pageNo");
		if(pageNo == null || "".equals(pageNo)){
			pageNo = "1";
		}
		selectPrplAreaSettingDtoToView(httpServletRequest,conditions,pageNo,recordPerPage);
	}
	
	public void selectPrplAreaSettingDtoToView(HttpServletRequest httpServletRequest,String conditions,String pageNo,String recordPerPage) throws Exception{
		String condition = httpServletRequest.getParameter("condition");
		if(condition != null && !"".equals(condition)){
			conditions = condition;
		}
		int intpageNo = Integer.parseInt(pageNo);
		int intrecordPerPage = Integer.parseInt(recordPerPage);
		UICodeAction uiCodeAction = new UICodeAction();
		UIAreaSettingAction uiAreaSettingAction = new UIAreaSettingAction();
		ArrayList<PrplareasettingDto> prplareasettingDtoList = new ArrayList<PrplareasettingDto>();
		PageRecord pageRecord = uiAreaSettingAction.findByQueryConditions(conditions, intpageNo, intrecordPerPage);
		prplareasettingDtoList = (ArrayList<PrplareasettingDto>) pageRecord.getResult();
		
		for(PrplareasettingDto prplareasettingDto : prplareasettingDtoList){
			prplareasettingDto.setHandledeptName(uiCodeAction.translateComCode(prplareasettingDto.getHandledept(), true));
		}
		httpServletRequest.setAttribute("prplareasettingDtoList", prplareasettingDtoList);
		
		TurnPageDto turnPageDto = new TurnPageDto();
		// 查询出来的一页的结构集
		turnPageDto.setResultList(prplareasettingDtoList);
		// 当前页号
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// 一页的条数
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// 查询出来的结果的总数
		turnPageDto.setTotalCount(pageRecord.getCount());
		// 返回总的页数
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// 搜索条件
		turnPageDto.setCondition(conditions);
		
		PrplareasettingDto prplareasettingDto = new PrplareasettingDto();
		prplareasettingDto.setTurnPageDto(turnPageDto);
		httpServletRequest.setAttribute("prplareasettingDto", prplareasettingDto);
	}
	
	public void findPrplAreaSettingUpdate(HttpServletRequest httpServletRequest,String handledept,String handlercode) throws Exception{
		String areaClassCode = httpServletRequest.getParameter("classCode");
		ArrayList<PrplareasettingDto> prplareasettingDtoList = new ArrayList<PrplareasettingDto>();
		BLPrplareasettingFacade blPrplareasettingFacade = new BLPrplareasettingFacade();
		UICodeAction uiCodeAction = new UICodeAction();
		String conditions = " classcode ='"+areaClassCode+"' and handledept = '"+handledept+"'";
		if(handlercode != null && !"".equals(handlercode)){
			conditions = conditions + " and handlercode='"+handlercode+"'";
		}
		prplareasettingDtoList = (ArrayList<PrplareasettingDto>) blPrplareasettingFacade.findByConditions(conditions);
		for(PrplareasettingDto prplareasettingDto : prplareasettingDtoList){
			String[] str = prplareasettingDto.getArea().split(";");
			String areaName = "";
			for(int i=0;i<str.length;i++){
				if(i == 0){
					areaName = uiCodeAction.translateComCode(str[i], true);
				}else{
					areaName = areaName+"<br/>"+uiCodeAction.translateComCode(str[i], true);
				}
			}
			prplareasettingDto.setAreaName(areaName);
		}
		
		httpServletRequest.setAttribute("prplareasettingDtoHandledept", handledept);
		httpServletRequest.setAttribute("prplareasettingDtoHandlercode", handlercode);
		httpServletRequest.setAttribute("prplareasettingDtoClassCode", areaClassCode);
		httpServletRequest.setAttribute("prplareasettingDtoList", prplareasettingDtoList);
	}
	
	public HashMap findAreaSettingUser(HttpServletRequest httpServletRequest,String handledept) throws Exception{
		ArrayList<PrplareasettingDto> prplareasettingDtoList = new ArrayList<PrplareasettingDto>();
		BLPrplareasettingFacade blPrplareasettingFacade = new BLPrplareasettingFacade();
		String areaClassCode = httpServletRequest.getParameter("classCode");
		String conditions = " classcode='"+areaClassCode+"' and handledept='"+handledept+"'";
		prplareasettingDtoList = (ArrayList<PrplareasettingDto>) blPrplareasettingFacade.findByConditions(conditions);
		Map userMap = new HashMap();
		for(PrplareasettingDto prplareasettingDto : prplareasettingDtoList){
			userMap.put(prplareasettingDto.getHandlercode(), prplareasettingDto.getHandlername());
		}
		return (HashMap) userMap;
	}

}
