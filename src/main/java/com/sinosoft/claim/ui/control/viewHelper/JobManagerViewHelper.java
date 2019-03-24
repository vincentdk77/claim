package com.sinosoft.claim.ui.control.viewHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.bl.facade.BLPrpDuserFacade;
import com.sinosoft.claim.bl.facade.BLPrplareasettingFacade;
import com.sinosoft.claim.bl.facade.BLPrpljobmanagerFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.dto.custom.JobManagerDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.domain.PrpLJobLinkerDto;
import com.sinosoft.claim.dto.domain.PrplareasettingDto;
import com.sinosoft.claim.dto.domain.PrpljobmanagerDto;
import com.sinosoft.claim.dto.domain.PrpljobmanagertimeDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIJobManagerAction;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.platform.ui.control.action.UIPowerAction;
import com.sinosoft.sysframework.common.Constants;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.utiall.blsvr.BLPrpDcompany;

public class JobManagerViewHelper{
	
	
	/**
	 * 班表查询分页
	 * @param httpServletRequest
	 * @throws Exception 
	 */
	public void setPrpljobManagerDtoToView(HttpServletRequest httpServletRequest,String pageNo,String recordPerPage) throws Exception{
		UserDto user = null;
		com.sinosoft.platform.dto.domain.PrpDuserDto prpDuserDto = null;
		String logonComCode = "";
		String editType     = httpServletRequest.getParameter("editType");
		String monthBegin	= httpServletRequest.getParameter("monthBegin");			//录入时间 开始
		String monthEnd		= httpServletRequest.getParameter("monthEnd");				//录入时间 结束
		String handledept	= httpServletRequest.getParameter("handledept");			//班表机构ID
		String deptname		= httpServletRequest.getParameter("deptname");				//班表机构名称
		String handlercode	= httpServletRequest.getParameter("handlercode");			//班表人员ID
		String handlername	= httpServletRequest.getParameter("handlername");			//班表人员名称
		String month		= httpServletRequest.getParameter("month");					//班表月份
		String classCode    = httpServletRequest.getParameter("classCode");             //险类
		String systemCode    = httpServletRequest.getParameter("systemCode");             //险类
		if("undwrt".equals(systemCode)){
			prpDuserDto = (com.sinosoft.platform.dto.domain.PrpDuserDto)httpServletRequest.getSession().getAttribute("user");
			logonComCode = prpDuserDto.getComCode();
		}else{
			user = (UserDto) httpServletRequest.getSession().getAttribute("user");
			logonComCode = user.getComCode();
		}
		
		String conditions	= " 1=1";
//		if(monthBegin != null && !monthBegin.equals("") && monthEnd != null && !monthEnd.equals("")){
//			conditions = conditions + " and ( ";
//		}else if(monthBegin != null && !monthBegin.equals("")){
//			conditions = conditions + " and ";
//		}
		if(monthBegin != null && !monthBegin.equals("")){
			conditions = conditions + " and month = '"+monthBegin+"'";
		}
//		
//		if(monthBegin != null && !monthBegin.equals("") && monthEnd != null && !monthEnd.equals("")){
//			conditions = conditions + " and ";
//		}else if(monthEnd != null && !monthEnd.equals("")){
//			conditions = conditions + " and ";
//		}
//		
//		if(monthEnd != null && !monthEnd.equals("")){
//			conditions = conditions + " month <= '"+monthEnd+"'";
//		}
//		
//		if(monthBegin != null && !monthBegin.equals("") && monthEnd != null && !monthEnd.equals("")){
//			conditions = conditions + " ) ";
//		}
		if(month != null && !month.equals("")){
			month = month.substring(0,7);
		}
		if(!"".equals(month) && month != null){
			conditions = conditions + StringConvert.convertString("month", month, "=");
		}
		if(!"".equals(systemCode) && systemCode != null){
			conditions = conditions + StringConvert.convertString("systemCode", systemCode, "=");
		}
		if("EDIT".equals(editType)){
			if("".equals(handledept) || handledept == null){
				conditions = conditions + StringConvert.convertString("handledept", logonComCode, "=");
			}else{
				conditions = conditions + StringConvert.convertString("handledept", handledept, "=");
			}
			if(null == classCode || "".equals(classCode) || "05".equals(classCode)){
				conditions = conditions + StringConvert.convertString("classcode", "05", "!=");
			}else{
				conditions = conditions + StringConvert.convertString("classcode", classCode, "=");
			}
		}
		if("SHOW".equals(editType)){
			conditions = conditions + StringConvert.convertString("handledept", handledept, "=");
			conditions = conditions + StringConvert.convertString("classcode", classCode, "=");
		}
		conditions = conditions + StringConvert.convertString("handlercode", handlercode, "=");
		if(pageNo == null || "".equals(pageNo)){
			pageNo = "1";
		}
		selectPrpljobManagerDtoToView(httpServletRequest,conditions,pageNo,recordPerPage);
	}
	public void selectPrpljobManagerDtoToView(HttpServletRequest httpServletRequest, String conditions, String pageNo, String recordPerPage) throws Exception {
		// 查询班表信息
		String condition = httpServletRequest.getParameter("condition");
		if(condition != null && !"".equals(condition)){
			conditions = condition;
		}
		int intpageNo = Integer.parseInt(pageNo);
		int intrecordPerPage = Integer.parseInt(recordPerPage);
		UIJobManagerAction uiJobManagerAction = new UIJobManagerAction();
		// 得到多行班表主表信息
		ArrayList<PrpljobmanagerDto> prpljobmanagerDtoList = new ArrayList<PrpljobmanagerDto>();
		PageRecord pageRecord = (PageRecord) uiJobManagerAction.findByQueryConditions(conditions, intpageNo, intrecordPerPage);
		prpljobmanagerDtoList = (ArrayList) pageRecord.getResult();
		httpServletRequest.setAttribute("prpljobmanagerDtoList", prpljobmanagerDtoList);
		
		TurnPageDto turnPageDto = new TurnPageDto();
		// 查询出来的一页的结构集
		turnPageDto.setResultList(prpljobmanagerDtoList);
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
		
		PrpljobmanagerDto prpljobmanagerDto = new PrpljobmanagerDto();
		prpljobmanagerDto.setTurnPageDto(turnPageDto);
		httpServletRequest.setAttribute("prpljobmanagerDto", prpljobmanagerDto);
	}
	
	
	/**
	 * 添加班表收集页面数据
	 * @param httpServletRequest
	 * @return
	 * @throws Exception
	 */
	public JobManagerDto viewToDto(HttpServletRequest httpServletRequest) throws Exception{
		String editType = httpServletRequest.getParameter("editType");
		UserDto user = null;
		com.sinosoft.platform.dto.domain.PrpDuserDto prpDuserDto = null;
		String systemCode = httpServletRequest.getParameter("systemCode");
		String logonUserName = "";
		String logonUserCode = "";
		if("undwrt".equals(systemCode)){
			prpDuserDto = (com.sinosoft.platform.dto.domain.PrpDuserDto)httpServletRequest.getSession().getAttribute("user");
			logonUserName = prpDuserDto.getUserName();
			logonUserCode = prpDuserDto.getUserCode();
		}else{
			user = (UserDto) httpServletRequest.getSession().getAttribute("user");
			logonUserName = user.getUserName();
			logonUserCode = user.getUserCode();
		}
		
		JobManagerDto jobManagerDto = new JobManagerDto();
		//收集班表组表信息
		String[] id = httpServletRequest.getParameterValues("id");							//id
		String[] userCode = httpServletRequest.getParameterValues("handlercode");				//查勘人员ID 值班人ID
		String[] jobRole = httpServletRequest.getParameterValues("jobRole");				//工作角色
		String[] comCName = httpServletRequest.getParameterValues("comCName");				//所在机构
		String[] handlername = httpServletRequest.getParameterValues("handlername");		//班表值班人名字
		String[] flowinTimeDate = httpServletRequest.getParameterValues("flowinTimeDate");
		String[] countNo = httpServletRequest.getParameterValues("countNo");				//获取对应班表日期
		String handledept =  httpServletRequest.getParameter("handledept");					//班表机构ID
		Date date = new Date();
		DateFormat df = DateFormat.getDateTimeInstance();
		String flowinTime = df.format(date);												//录入时间
		String month = httpServletRequest.getParameter("month");							//month 月份
		String operator = "";																//录入人名字
		String operatorid = "";																//录入人ID
		String classCode = httpServletRequest.getParameter("classCode");	        		//险类
		ArrayList<PrpljobmanagerDto> prpljobmanagerDtoList = new ArrayList<PrpljobmanagerDto>();
		PrpljobmanagerDto prpljobmanagerDto = null;
		
		//收集时间表信息
		ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoList = new ArrayList<PrpljobmanagertimeDto>();
		if(userCode != null && !"".equals(userCode)){
			for(int i=1;i<=userCode.length;i++){
				prpljobmanagerDto = new PrpljobmanagerDto();
				if("".equals(id[i-1]) || id[i-1] == null || "ADD".equals(editType)){
					id[i-1] = month.replaceAll("-","").toString()+handledept+ classCode +userCode[i-1]+jobRole[i-1].replaceAll(";", "");
				}
				prpljobmanagerDto.setId(id[i-1]);
				prpljobmanagerDto.setJobrole(jobRole[i-1]);
				prpljobmanagerDto.setHandlercode(userCode[i-1]);
				prpljobmanagerDto.setHandlername(handlername[i-1]);
				prpljobmanagerDto.setHandledept(handledept);
				prpljobmanagerDto.setDeptname(comCName[i-1]);
				if("ADD".equals(editType)){
					prpljobmanagerDto.setFlowintime(flowinTime);
				}else{
					if("".equals(flowinTimeDate[i-1]) || flowinTimeDate[i-1] == null){
						prpljobmanagerDto.setFlowintime(flowinTime);
					}else{
						prpljobmanagerDto.setFlowintime(flowinTimeDate[i-1]);
					}
				}
				if(!"ADD".equals(editType)){
					prpljobmanagerDto.setModifytime(flowinTime);
				}
				prpljobmanagerDto.setMonth(month);
				prpljobmanagerDto.setClasscode(classCode);
				prpljobmanagerDto.setOperator(logonUserName);
				prpljobmanagerDto.setOperatorid(logonUserCode);
				prpljobmanagerDto.setSystemCode(systemCode);
				prpljobmanagerDtoList.add(prpljobmanagerDto);
				
				String[] checkboxDayAm = httpServletRequest.getParameterValues("checkboxDayAm"+countNo[i-1]+"");
				String[] checkboxDayPm = httpServletRequest.getParameterValues("checkboxDayPm"+countNo[i-1]+"");
				PrpljobmanagertimeDto prpljobmanagertimeDto = null;
				if(checkboxDayAm != null && !"".equals(checkboxDayAm)){
					for(int x=0;x<checkboxDayAm.length;x++){
						prpljobmanagertimeDto = new PrpljobmanagertimeDto();
						prpljobmanagertimeDto.setFid(id[i-1]);
						prpljobmanagertimeDto.setTime(checkboxDayAm[x]);
						prpljobmanagertimeDto.setDatetype("AM");
						prpljobmanagertimeDtoList.add(prpljobmanagertimeDto);
					}
				}
				if(checkboxDayPm != null && !"".equals(checkboxDayPm)){
					for(int x=0;x<checkboxDayPm.length;x++){
						prpljobmanagertimeDto = new PrpljobmanagertimeDto();
						prpljobmanagertimeDto.setFid(id[i-1]);
						prpljobmanagertimeDto.setTime(checkboxDayPm[x]);
						prpljobmanagertimeDto.setDatetype("PM");
						prpljobmanagertimeDtoList.add(prpljobmanagertimeDto);
					}
				}
			}
		}
		jobManagerDto.setPrpljobmanagerDtoList(prpljobmanagerDtoList);
		jobManagerDto.setPrpljobmanagertimeDtoList(prpljobmanagertimeDtoList);
		
		String[] staffId        = httpServletRequest.getParameterValues("staffId");//联系代码
		String[] staffPosition  = httpServletRequest.getParameterValues("staffPosition");//联系人岗位
		String[] staffName      = httpServletRequest.getParameterValues("staffName");//人员姓名
		String[] staffPhone     = httpServletRequest.getParameterValues("staffPhone");//电话号码
		String[] staffType      = httpServletRequest.getParameterValues("staffType");//人员类型
		String[] staffUserCode  = httpServletRequest.getParameterValues("staffUserCode");//用户代码
		
		if(staffPosition!=null){
			PrpLJobLinkerDto prpLJobLinkerDto = null;
			List<PrpLJobLinkerDto> prpLJobLinkerDtoList=new ArrayList<PrpLJobLinkerDto>();
			for(int i=0;i<staffPosition.length;i++){
				if("".equals(staffPosition[i])){
					continue;
				}
				prpLJobLinkerDto = new PrpLJobLinkerDto();
				
				if("".equals(staffId[i]) || staffId[i] == null || "ADD".equals(editType)){
					staffId[i] = month.replaceAll("-","").toString()+handledept+ classCode +staffUserCode[i]+staffPosition[i];
				}
				prpLJobLinkerDto.setStaffId(staffId[i]);
				prpLJobLinkerDto.setStaffPosition(staffPosition[i]);
				prpLJobLinkerDto.setStaffUserCode(staffUserCode[i]);
				prpLJobLinkerDto.setStaffName(staffName[i]);
				prpLJobLinkerDto.setStaffPhone(staffPhone[i]);
				prpLJobLinkerDto.setStaffType(staffType[i]);
				prpLJobLinkerDto.setHandledept(handledept);
				prpLJobLinkerDto.setMonth(month);
				if("ADD".equals(editType)){
					prpLJobLinkerDto.setFlowinTime(flowinTime);
				}
				if(!"ADD".equals(editType)){
					prpLJobLinkerDto.setModifyTime(flowinTime);
				}
				prpLJobLinkerDto.setFlowinTime(flowinTime);
				prpLJobLinkerDto.setClassCode(classCode);
				prpLJobLinkerDtoList.add(prpLJobLinkerDto);
			}
			jobManagerDto.setPrpLJobLinkerDtoList(prpLJobLinkerDtoList);
		}
		
		return jobManagerDto;
	}
	
	/**
	 * 	当前机构下 查勘人员（车务，人伤）
	 * @param httpServletRequest
	 * @param handledept
	 * @throws 当前机构下 查勘人员（车务，人伤）
	 */
	public ArrayList<PrpDuserDto> findUser(HttpServletRequest httpServletRequest,String handledept) throws Exception{
		UICodeAction uiCodeAction = new UICodeAction();
		ArrayList<PrpDuserDto> prpDuserDtoList = new ArrayList<PrpDuserDto>();
		Collection collection = new ArrayList();
		BLPrpDuserFacade blPrpDuserFacade = new BLPrpDuserFacade();
		Map prpDuserMap = new HashMap();
		String systemCode =httpServletRequest.getParameter("systemCode");
		if("claim".equals(systemCode)){
			String conditions = " validstatus='1' And comcode In (Select Comcode From prpdcompany Start With comcode='"+handledept+"' Connect By Prior comcode = uppercomcode And Prior comcode != comcode And validstatus = '1')";
			collection = (ArrayList<PrpDuserDto>) blPrpDuserFacade.findByConditions(conditions);
			boolean checkPower = false;
			String classCode = httpServletRequest.getParameter("classCode");
			if("05".equals(classCode)){
				String[] taskCode = {AppConfig.get("sysconst.CHECKCODE_CHECK1"),AppConfig.get("sysconst.CHECKCODE_CHECKPERSON")};//得到任务代码
				for(int i=0;i<taskCode.length;i++){
					for(Iterator iterator = collection.iterator();iterator.hasNext();){
						PrpDuserDto prpDuserDto = (PrpDuserDto)iterator.next();
						com.sinosoft.platform.dto.domain.PrpDuserDto platformPrpDuserDto = new com.sinosoft.platform.dto.domain.PrpDuserDto();
						BLPrpDcompany prpDcompany = new BLPrpDcompany();   
						String upperComCode = prpDcompany.getCenterCode(prpDuserDto.getComCode());
						platformPrpDuserDto.setLoginComCode(upperComCode);
						platformPrpDuserDto.setUserCode(prpDuserDto.getUserCode());
						checkPower=UIPowerAction.checkPowerReturn(platformPrpDuserDto,taskCode[i]);
						if(checkPower){
							if(prpDuserMap.containsKey(prpDuserDto.getUserCode())){
								prpDuserDto=(PrpDuserDto) prpDuserMap.get(prpDuserDto.getUserCode());
								prpDuserDto.setGradecode(prpDuserDto.getGradecode()+""+(i+1));
							}else{
								prpDuserDto.setGradecode(""+(i+1));
							}
							prpDuserDto.setComCName(uiCodeAction.translateComCode(handledept, true));
							prpDuserMap.put(prpDuserDto.getUserCode(), prpDuserDto);
						}
					}
				}
			}else{
				for(Iterator iterator = collection.iterator();iterator.hasNext();){
					PrpDuserDto prpDuserDto = (PrpDuserDto)iterator.next();
					com.sinosoft.platform.dto.domain.PrpDuserDto platformPrpDuserDto = new com.sinosoft.platform.dto.domain.PrpDuserDto();
					BLPrpDcompany prpDcompany = new BLPrpDcompany();   
					String upperComCode = prpDcompany.getCenterCode(prpDuserDto.getComCode());
					platformPrpDuserDto.setLoginComCode(upperComCode);
					platformPrpDuserDto.setUserCode(prpDuserDto.getUserCode());
					checkPower=UIPowerAction.checkPowerReturn(platformPrpDuserDto,Constants.TASK_CLAIM_CHECK);
					if(checkPower){
						if(prpDuserMap.containsKey(prpDuserDto.getUserCode())){
							prpDuserDto=(PrpDuserDto) prpDuserMap.get(prpDuserDto.getUserCode());
							prpDuserDto.setGradecode(prpDuserDto.getGradecode()+"3");
						}else{
							prpDuserDto.setGradecode("3");
						}
						prpDuserDto.setComCName(uiCodeAction.translateComCode(handledept, true));
						prpDuserMap.put(prpDuserDto.getUserCode(), prpDuserDto);
					}
				}
			}
		}else if("undwrt".equals(systemCode)){
			String conditions = " validstatus = '1' "
					+ "And usercode in (select usercode from utiusergrade where gradecode = '121') "
					+ "And comcode In (Select Comcode From prpdcompany Start With comcode = '"+ handledept +"' Connect By Prior comcode = uppercomcode And Prior comcode != comcode And validstatus = '1')";
			collection = (ArrayList<PrpDuserDto>) blPrpDuserFacade.findByConditions(conditions);
			for(Iterator iterator = collection.iterator();iterator.hasNext();){
				PrpDuserDto prpDuserDto = (PrpDuserDto)iterator.next();
				prpDuserDto.setGradecode("HB");
				prpDuserDto.setComCName(uiCodeAction.translateComCode(handledept, true));
				prpDuserMap.put(prpDuserDto.getUserCode(), prpDuserDto);
			}
		}
		
		System.err.println("prpduser  size=="+prpDuserMap.values().size());
		Collection prpDuserList = prpDuserMap.values();
		for(Iterator itr = prpDuserList.iterator();itr.hasNext();){
			PrpDuserDto prpDuserDto = (PrpDuserDto)itr.next();
			System.err.println("userCode："+prpDuserDto.getUserCode()+" userName: "+ prpDuserDto.getUserName()+" comCode: "+prpDuserDto.getComCode()+" comName: "+ prpDuserDto.getComCName());
		}
		
		prpDuserDtoList.addAll(prpDuserMap.values());
		httpServletRequest.setAttribute("prpDuserDtoList", prpDuserMap.values());
		//查询 机构下 查勘人员 end
		return prpDuserDtoList;
	}
	
	/**
	 * 当前月展示天数集合
	 * @param httpServletRequest
	 * @param month
	 * @return 返回当前月展示天数集合
	 */
	public ArrayList<PrpljobmanagertimeDto> findMonthDay(HttpServletRequest httpServletRequest , String month){
		//日期显示
		int year = Integer.parseInt(month.substring(0,4));
		String monthNo = month.substring(5);
		int day = 0;
		if ("01".equals(monthNo)||"03".equals(monthNo)||"05".equals(monthNo)||"07".equals(monthNo)||"08".equals(monthNo)||"10".equals(monthNo)||"12".equals(monthNo)){
			day=31;
		}else if ("04".equals(monthNo)||"06".equals(monthNo)||"09".equals(monthNo)||"11".equals(monthNo)) {
			day=30;
		}else{
			if(year%4 == 0){
				day=29;
			}else{
				day=28;
			}
		}
		PrpljobmanagertimeDto prpljobmanagertimeDto = null;
		ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoList = new ArrayList<PrpljobmanagertimeDto>();
		for(int i=1 ; i<=day ; i++){
			prpljobmanagertimeDto = new PrpljobmanagertimeDto();
			prpljobmanagertimeDto.setTime(month+"-"+String.valueOf(i));
			prpljobmanagertimeDtoList.add(prpljobmanagertimeDto);
		}
		httpServletRequest.setAttribute("day", day);
		return prpljobmanagertimeDtoList;
	}
	
	/**@desc 调度班表入口：老理赔系统还有历史单子，即还有车险的单子，故使用班表时，既有可能用车险班表，又有可能使用非车险班表。
	 * 根据条件[机构、月份、险种、角色、时间]查询班表prpljobmanager
	 * 非车险根据险种‘99’或车险‘05’和机构查询查勘区域和电话号码prpljobareasetting*/
	public void linkJobManager(HttpServletRequest httpServletRequest,String handledept) throws Exception{
		String classCode = httpServletRequest.getParameter("classCode");
		String areaClassCode = "99";
		String jobrole = "3";
		String nodeType = "check";
		String scheduleType = "";
		
		Date date = new Date();
		DateFormat df = DateFormat.getDateTimeInstance();
		String flowinTime = df.format(date);
		
		Calendar ca = Calendar.getInstance();
		String [] str = flowinTime.split("-");
		if (str.length>1&&str[1].length()==1) {
			str[1]="0"+str[1];
		}
		String month = str[0]+"-"+str[1];								//当前月份
		int hours = ca.get(Calendar.HOUR_OF_DAY);								//当前小时
		String datetype = "";											//上午，下午
		String time = flowinTime.substring(0,flowinTime.indexOf(" "));						//当前日期
		String [] timeStr = time.split("-");
		if (timeStr.length>1&&timeStr[1].length()==1) {
			timeStr[1]="0"+timeStr[1];
		}
		time=timeStr[0]+"-"+timeStr[1]+"-"+timeStr[2];	
		if(hours >= 8 && hours < 18){
			datetype = "AM";
		}else{
			datetype = "PM";
		}
		if("05".equals(classCode)){
				//车务查勘
				jobrole = "12";
				areaClassCode = "05";
		}
		if("31,32,05".indexOf(classCode)<0){
			classCode = "99";
		}
		ArrayList<PrpljobmanagerDto> prpljobmanagerDtoList = new ArrayList<PrpljobmanagerDto>();
		BLPrpljobmanagerFacade blPrpljobmanagerFacade = new BLPrpljobmanagerFacade();
		String conditions = " systemcode='claim' and classcode='"+classCode+"' and month='"+month+"' and handledept='"+handledept+"' and jobrole ='"+jobrole+"' and id in (select fid from prpljobmanagertime where time='"+time+"' and datetype='"+datetype+"')";
		System.err.println("conditons==="+conditions);
		prpljobmanagerDtoList = (ArrayList<PrpljobmanagerDto>) blPrpljobmanagerFacade.findByConditions(conditions);
		if(prpljobmanagerDtoList != null){
			for(PrpljobmanagerDto prpljobmanagerDto : prpljobmanagerDtoList){
				prpljobmanagerDto.setDatetype(datetype);
				//设置作业区域
				BLPrplareasettingFacade blPrplareasettingFacade = new BLPrplareasettingFacade();
				/**对于非车险prplareasetting.classcode为‘99’，车险prplareasetting.classcode为‘05’*/
				ArrayList<PrplareasettingDto> prplareasettingDtoList = (ArrayList<PrplareasettingDto>) blPrplareasettingFacade.findByConditions(" classcode='"+areaClassCode+"' and handlercode='"+prpljobmanagerDto.getHandlercode()+"'");
				String[] area = null;
				String areaName = "";
				for(PrplareasettingDto prplareasettingDto  : prplareasettingDtoList){
					if(!"".equals(prplareasettingDto.getArea()) && prplareasettingDto.getArea() != null){
						area = prplareasettingDto.getArea().split(";");
						for(int i=0;i<area.length;i++){
							UICodeAction uiCodeAction = new UICodeAction();
							if("".equals(areaName)){
								areaName = uiCodeAction.translateComCode(area[i], true);
							}else{
								areaName += "<br/>"+uiCodeAction.translateComCode(area[i], true);
							}
						}
					}
					prpljobmanagerDto.setAreaName(areaName);
					prpljobmanagerDto.setTel(prplareasettingDto.getTel());
					
				}
				prpljobmanagerDto.setJobrole(jobrole);
				BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
				String countSql = "";
				if("AM".equals(datetype)){
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date timeBegin = format.parse(time);
					Date timeEnd   = format.parse(time);
					String dateBegin = format.format(timeBegin)+" 08:00:00";
					String dateEnd   = format.format(timeEnd)+" 18:00:00";
					countSql = " handlercode='"+prpljobmanagerDto.getHandlercode()+"' and flag Is Null and flowintime>='"+dateBegin+"' and flowintime<'"+dateEnd+"' and nodeType='"+nodeType+"'";
				}else{
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd");      
					Date timeBegin = format.parse(time);
					Date timeEnd   = format.parse(time);
					if(hours>18){
						Calendar cday=Calendar.getInstance();
						cday.setTime(timeEnd);
						cday.set(cday.DAY_OF_YEAR, cday.get(cday.DAY_OF_YEAR)+1);
						timeEnd=cday.getTime();
					}else if(hours<=8){
						Calendar cday=Calendar.getInstance();
						cday.setTime(timeBegin);
						cday.set(cday.DAY_OF_YEAR, cday.get(cday.DAY_OF_YEAR)-1);
						timeBegin=cday.getTime();
					}
					String dateBegin = format.format(timeBegin)+" 18:00:00";
					String dateEnd   = format.format(timeEnd)+" 08:00:00";
					countSql = " handlercode='"+prpljobmanagerDto.getHandlercode()+"' and flag Is Null and flowintime>='"+dateBegin+"' and flowintime<'"+dateEnd+"' and nodeType='"+nodeType+"'";
				}
				int checkCount = blSwfLogFacade.getCount(countSql);
				prpljobmanagerDto.setCheckCount(String.valueOf(checkCount));
			}
		}
		
		ArrayList<PrpDuserDto> prpDuserDtoList = findUser(httpServletRequest, handledept);
		ArrayList<PrpljobmanagerDto> prpljobmanagerDtoUser = new ArrayList<PrpljobmanagerDto>();
		for(PrpDuserDto prpDuserDto : prpDuserDtoList){
			if(prpDuserDto.getGradecode().indexOf(jobrole) >= 0){
				for(PrpljobmanagerDto prpljobmanagerDto : prpljobmanagerDtoList){
					if(prpDuserDto.getUserCode().equals(prpljobmanagerDto.getHandlercode())){
						prpljobmanagerDtoUser.add(prpljobmanagerDto);
					}
				}
			}
			
		}
		prpljobmanagerDtoList = new ArrayList<PrpljobmanagerDto>();
		prpljobmanagerDtoList.addAll(prpljobmanagerDtoUser);
		httpServletRequest.setAttribute("prpljobmanagerDtoList", prpljobmanagerDtoList);
		httpServletRequest.setAttribute("countList", prpljobmanagerDtoList.size());
		httpServletRequest.setAttribute("time", time);
		//httpServletRequest.setAttribute("scheduleType", scheduleType);
	}
	/*public void findClassCode(HttpServletRequest request) throws Exception {
		String conditions = " validstatus='1' and classcode<>'05' ";
		UIJobManagerAction action = new UIJobManagerAction();
		Collection classCodeList = action.findClassCodeByConditions(conditions);
		request.setAttribute("classCodeList", classCodeList);
	}*/

}
