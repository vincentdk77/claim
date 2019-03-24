package com.sinosoft.claim.webservice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.sinosoft.claim.bl.facade.BLPrpDuserFacade;
import com.sinosoft.claim.bl.facade.BLPrpLJobLinkerFacade;
import com.sinosoft.claim.bl.facade.BLPrplareasettingFacade;
import com.sinosoft.claim.bl.facade.BLPrpljobmanagerFacade;
import com.sinosoft.claim.bl.facade.BLPrpljobmanagertimeFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.dto.domain.ClaimJobLinkDto;
import com.sinosoft.claim.dto.domain.ClaimJobManagerDetailDto;
import com.sinosoft.claim.dto.domain.ClaimJobManagerDetailMainDto;
import com.sinosoft.claim.dto.domain.ClaimJobManagerLinkDto;
import com.sinosoft.claim.dto.domain.ClaimJobManagerQueryDto;
import com.sinosoft.claim.dto.domain.ClaimJobManagerQueryMainDto;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.domain.PrpLJobLinkerDto;
import com.sinosoft.claim.dto.domain.PrplareasettingDto;
import com.sinosoft.claim.dto.domain.PrpljobmanagerDto;
import com.sinosoft.claim.dto.domain.PrpljobmanagertimeDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIJobManagerAction;
import com.sinosoft.claim.util.CallCenterInterfaceLogger;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.platform.ui.control.action.UIPowerAction;
import com.sinosoft.sysframework.common.Constants;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.utiall.blsvr.BLPrpDcompany;

public class JobManagerQueryService {
	CallCenterInterfaceLogger logger = new CallCenterInterfaceLogger();
	/**
	 * 调度班表查询接口
	 * @param handledept
	 * @param classCode
	 * @return
	 */
	public ClaimJobManagerLinkDto[] linkJobManagerQuery(String handledept,String classCode){
		long serial = System.currentTimeMillis();
		logger.log("理赔调度班表查询查询", 1,serial, "[handledept:"+handledept+"][classCode:"+classCode+"]");
		ClaimJobManagerLinkDto[] claimJobManagerLinkList = null;
		try{
			claimJobManagerLinkList = this.linkJobManager(handledept, classCode);
		}catch(Exception e){
			e.printStackTrace();
			logger.log("理赔调度班表查询查询",serial,e);
		}
		logger.log("理赔调度班表查询查询", 0,serial, claimJobManagerLinkList);
		return claimJobManagerLinkList;
	}
	
	/**
	 * 调度系统班表查询
	 * @param monthBegin
	 * @param handledept
	 * @param handlercode
	 * @param classCode
	 * @param pageNo
	 * @param recordPerPage
	 * @return
	 */
	public ClaimJobManagerQueryMainDto showJobManagerQuery(String monthBegin,String handledept,String handlercode,String classCode,String pageNo,String recordPerPage){
		long serial = System.currentTimeMillis();
		logger.log("理赔系统班表查询", 1,serial, "[monthBegin:"+monthBegin+"][handledept:"+handledept+"][handlercode:"+handlercode
				+"][classCode:"+classCode+"][pageNo:"+pageNo+"][recordPerPage:"+recordPerPage+"]");
		ClaimJobManagerQueryMainDto claimJobManagerQueryMainDto = null;
		try{
			claimJobManagerQueryMainDto = this.setPrpljobManagerDtoToView(monthBegin, handledept, handlercode, classCode, pageNo, recordPerPage);
		}catch(Exception e){
			e.printStackTrace();
			logger.log("理赔系统班表查询",serial,e);
		}
		logger.log("理赔系统班表查询", 0,serial, claimJobManagerQueryMainDto);
		return claimJobManagerQueryMainDto;
	}
	
	/**
	 * 班表详细信息查询
	 * @param handledept
	 * @param month
	 * @param classCode
	 * @return
	 */
	public ClaimJobManagerDetailMainDto queryJobManagerDetail(String handledept,String month,String classCode){
		long serial = System.currentTimeMillis();
		logger.log("理赔系统班表查询详细信息", 1,serial, "[handledept:"+handledept+"][month:"+month+"][classCode:"+classCode+"]");
		ClaimJobManagerDetailMainDto claimJobManagerDetailMainDto = null;
		try{
			claimJobManagerDetailMainDto = this.jobManagerDetail(handledept, month, classCode);
		}catch(Exception e){
			e.printStackTrace();
			logger.log("理赔系统班表查询详细信息",serial,e);
		}
		logger.log("理赔系统班表查询详细信息", 0,serial, claimJobManagerDetailMainDto);
		return claimJobManagerDetailMainDto;
	}
	
	/**
	 * 调度班表查询接口
	 * @param handledept
	 * @param classCode
	 * @return
	 */
	private ClaimJobManagerLinkDto[] linkJobManager(String handledept,String classCode) throws Exception{
		if(isEmpty(handledept)){throw new Exception("机构代码不能为空，请检查。");}
		if(isEmpty(classCode)){throw new Exception("险种大类不能为空，请检查。");}
		
		ClaimJobManagerLinkDto[] claimJobManagerLinkList = null;
		String areaClassCode = "99";
		String jobrole = "3";
		String nodeType = "check";
		
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
		
		ArrayList<PrpDuserDto> prpDuserDtoList = this.findUser(handledept, classCode);
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
		
		if(null != prpljobmanagerDtoList && prpljobmanagerDtoList.size()>0){
			claimJobManagerLinkList = new ClaimJobManagerLinkDto[prpljobmanagerDtoList.size()];
			for(int i=0;i<prpljobmanagerDtoList.size();i++){
				PrpljobmanagerDto prpljobmanagerDto = prpljobmanagerDtoList.get(i);
				ClaimJobManagerLinkDto claimJobManagerLinkDto = new ClaimJobManagerLinkDto();
				
				claimJobManagerLinkDto.setJobDate(time);
				claimJobManagerLinkDto.setDateType(prpljobmanagerDto.getDatetype());
				claimJobManagerLinkDto.setHandlerCode(prpljobmanagerDto.getHandlercode());
				claimJobManagerLinkDto.setHandlerName(prpljobmanagerDto.getHandlername());
				claimJobManagerLinkDto.setAreaName(prpljobmanagerDto.getAreaName());
				claimJobManagerLinkDto.setPhone(prpljobmanagerDto.getTel());
				claimJobManagerLinkDto.setJobrole(prpljobmanagerDto.getJobrole());
				claimJobManagerLinkDto.setCheckCount(prpljobmanagerDto.getCheckCount());
				
				claimJobManagerLinkList[i] = claimJobManagerLinkDto;
			}
		}
		
		return claimJobManagerLinkList;
	}
	
	/**
	 * 	当前机构下 查勘人员（车务，人伤）
	 * @param httpServletRequest
	 * @param handledept
	 * @throws 当前机构下 查勘人员（车务，人伤）
	 */
	@SuppressWarnings("unchecked")
	private ArrayList<PrpDuserDto> findUser(String handledept,String classCode) throws Exception{
		UICodeAction uiCodeAction = new UICodeAction();
		ArrayList<PrpDuserDto> prpDuserDtoList = new ArrayList<PrpDuserDto>();
		Collection collection = new ArrayList();
		BLPrpDuserFacade blPrpDuserFacade = new BLPrpDuserFacade();
		Map prpDuserMap = new HashMap();
		String systemCode ="claim";
		if("claim".equals(systemCode)){
			String conditions = " validstatus='1' And comcode In (Select Comcode From prpdcompany Start With comcode='"+handledept+"' Connect By Prior comcode = uppercomcode And Prior comcode != comcode And validstatus = '1')";
			collection = (ArrayList<PrpDuserDto>) blPrpDuserFacade.findByConditions(conditions);
			boolean checkPower = false;
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
		//查询 机构下 查勘人员 end
		return prpDuserDtoList;
	}

	/**
	 * 班表查询分页
	 * @param httpServletRequest
	 * @throws Exception 
	 */
	private ClaimJobManagerQueryMainDto setPrpljobManagerDtoToView(String monthBegin,String handledept,String handlercode,String classCode,String pageNo,String recordPerPage) throws Exception{
		ClaimJobManagerQueryMainDto claimJobManagerQueryMainDto = new ClaimJobManagerQueryMainDto();
		String systemCode = "claim";
		
		String conditions	= " 1=1";
		if(monthBegin != null && !monthBegin.equals("")){
			conditions = conditions + " and month = '"+monthBegin+"'";
		}
		
		if(!"".equals(systemCode) && systemCode != null){
			conditions = conditions + StringConvert.convertString("systemCode", systemCode, "=");
		}
		
		conditions = conditions + StringConvert.convertString("handledept", handledept, "=");
		conditions = conditions + StringConvert.convertString("classcode", classCode, "=");
		
		conditions = conditions + StringConvert.convertString("handlercode", handlercode, "=");
		if(pageNo == null || "".equals(pageNo)){
			pageNo = "1";
		}
		if(recordPerPage == null || "".equals(recordPerPage)){
			recordPerPage = "10";
		}
		
		int intpageNo = Integer.parseInt(pageNo);
		int intrecordPerPage = Integer.parseInt(recordPerPage);
		UIJobManagerAction uiJobManagerAction = new UIJobManagerAction();
		// 得到多行班表主表信息
		ArrayList<PrpljobmanagerDto> prpljobmanagerDtoList = new ArrayList<PrpljobmanagerDto>();
		PageRecord pageRecord = (PageRecord) uiJobManagerAction.findByQueryConditions(conditions, intpageNo, intrecordPerPage);
		prpljobmanagerDtoList = (ArrayList) pageRecord.getResult();
		
		if(null != prpljobmanagerDtoList && prpljobmanagerDtoList.size()>0){
			ClaimJobManagerQueryDto[] claimJobManagerQueryList = new ClaimJobManagerQueryDto[prpljobmanagerDtoList.size()];
			for(int i=0;i<prpljobmanagerDtoList.size();i++){
				PrpljobmanagerDto prpljobmanagerDto = prpljobmanagerDtoList.get(i);
				ClaimJobManagerQueryDto claimJobManagerQueryDto = new ClaimJobManagerQueryDto();
				claimJobManagerQueryDto.setClasscode(prpljobmanagerDto.getClasscode());
				claimJobManagerQueryDto.setDeptCode(prpljobmanagerDto.getHandledept());
				claimJobManagerQueryDto.setDeptName(prpljobmanagerDto.getDeptname());
				claimJobManagerQueryDto.setHandlerCode(prpljobmanagerDto.getHandlercode());
				claimJobManagerQueryDto.setHandlerName(prpljobmanagerDto.getHandlername());
				claimJobManagerQueryDto.setMonth(prpljobmanagerDto.getMonth());
				claimJobManagerQueryDto.setOperator(prpljobmanagerDto.getOperator());
				claimJobManagerQueryDto.setModifytime(prpljobmanagerDto.getFlowintime());
				
				claimJobManagerQueryList[i] = claimJobManagerQueryDto;
			}
			claimJobManagerQueryMainDto.setClaimJobManagerQueryList(claimJobManagerQueryList);
		}
		
		claimJobManagerQueryMainDto.setPageNo(pageRecord.getPageNo());
		claimJobManagerQueryMainDto.setRecordPerPage(pageRecord.getRowsPerPage());
		claimJobManagerQueryMainDto.setTotalCount(pageRecord.getCount());
		claimJobManagerQueryMainDto.setTotalPage(pageRecord.getTotalPageCount());
		
		return claimJobManagerQueryMainDto;
	}
	
	/**
	 * 班表详细信息
	 * @param handledept
	 * @param month
	 * @param classCode
	 * @return
	 * @throws Exception
	 */
	private ClaimJobManagerDetailMainDto jobManagerDetail(String handledept,String month,String classCode) throws Exception{
		if(isEmpty(handledept)){throw new Exception("机构代码不能为空，请检查。");}
		if(isEmpty(month)){throw new Exception("月份不能为空，请检查。");}
		if(isEmpty(classCode)){throw new Exception("险种不能为空，请检查。");}
		
		ClaimJobManagerDetailMainDto claimJobManagerDetailMainDto = new ClaimJobManagerDetailMainDto();
		
		String systemCode = "claim";
		String handlercode = "";
		
		BLPrpljobmanagerFacade blPrpljobmanagerFacade = new BLPrpljobmanagerFacade();
		String conditions = "";
		if(handlercode != null && !"".equals(handlercode)){
			conditions = " systemcode = '"+ systemCode +"'" + " and classcode = '"+ classCode +"' and handledept='"+handledept+"' and month='"+month+"' and handlercode='"+handlercode+"'";
		}else{
			conditions = " systemcode = '"+ systemCode +"'"+" and classcode = '"+ classCode +"' and handledept='"+handledept+"' and month='"+month+"'";
		}
		PrpljobmanagerDto prpljobmanagerDtoSql = new PrpljobmanagerDto();
		prpljobmanagerDtoSql.setHandledept(handledept);
		prpljobmanagerDtoSql.setMonth(month);
		prpljobmanagerDtoSql.setHandlercode(handlercode);
		prpljobmanagerDtoSql.setClasscode(classCode);
		prpljobmanagerDtoSql.setSystemCode(systemCode);
		
		ArrayList<PrpljobmanagerDto> prpljobmanagerDtoList = new ArrayList<PrpljobmanagerDto>();
		ArrayList<PrpljobmanagerDto> prpljobmanagerDtoListOld = (ArrayList<PrpljobmanagerDto>) blPrpljobmanagerFacade.findByConditions(conditions);
		
		
		//当前机构下 查勘人员（车务，人伤）
		//当前机构查勘员工
		ArrayList<PrpDuserDto> prpDuserDtoList = this.findUser(handledept, classCode);
		
		//当前月展示天数集合
		ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoList = new ArrayList<PrpljobmanagertimeDto>();
		//当前月展示天数集合
		if(null !=prpljobmanagerDtoListOld && prpljobmanagerDtoListOld.size()>0){
			month = prpljobmanagerDtoListOld.get(0).getMonth();
		}
		prpljobmanagertimeDtoList = this.findMonthDay(month);
		
		ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoListNewAm = null;
		ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoListNewPm = null;
		
		
		for(PrpljobmanagerDto prpljobmanagerDto : prpljobmanagerDtoListOld){
			prpljobmanagertimeDtoListNewAm = this.findMonthDay(month);
			prpljobmanagertimeDtoListNewPm = this.findMonthDay(month);
			ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoListOldAm = (ArrayList<PrpljobmanagertimeDto>) new BLPrpljobmanagertimeFacade().findByConditions(" fid='"+prpljobmanagerDto.getId()+"' and datetype='AM'");
			for(PrpljobmanagertimeDto prpljobmanagertimeDtoNew : prpljobmanagertimeDtoListNewAm){
				prpljobmanagertimeDtoNew.setDatetype("AM");
				prpljobmanagertimeDtoNew.setFid(prpljobmanagerDto.getId());
				for(PrpljobmanagertimeDto prpljobmanagertimeDtoOld :prpljobmanagertimeDtoListOldAm){
					if("AM".equals(prpljobmanagertimeDtoOld.getDatetype())){
						if(prpljobmanagertimeDtoNew.getTime().substring(8).equals(prpljobmanagertimeDtoOld.getTime().substring(8))){
							prpljobmanagertimeDtoNew.setFid(prpljobmanagertimeDtoOld.getFid());
							prpljobmanagertimeDtoNew.setDatetype(prpljobmanagertimeDtoOld.getDatetype());
							prpljobmanagertimeDtoNew.setStates("1");
						}else{
							prpljobmanagertimeDtoNew.setFid(prpljobmanagertimeDtoOld.getFid());
							prpljobmanagertimeDtoNew.setDatetype("AM");
						}
					}else{
						prpljobmanagertimeDtoNew.setFid(prpljobmanagertimeDtoOld.getFid());
						prpljobmanagertimeDtoNew.setDatetype("AM");
					}
				}
			}
			prpljobmanagerDto.setPrpljobmanagertimeDtoListAm(prpljobmanagertimeDtoListNewAm);
			
			
			ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoListOldPm = (ArrayList<PrpljobmanagertimeDto>) new BLPrpljobmanagertimeFacade().findByConditions(" fid='"+prpljobmanagerDto.getId()+"' and datetype='PM'");
			for(PrpljobmanagertimeDto prpljobmanagertimeDtoNew : prpljobmanagertimeDtoListNewPm){
				prpljobmanagertimeDtoNew.setDatetype("PM");
				prpljobmanagertimeDtoNew.setFid(prpljobmanagerDto.getId());
				for(PrpljobmanagertimeDto prpljobmanagertimeDtoOld :prpljobmanagertimeDtoListOldPm){
					if("PM".equals(prpljobmanagertimeDtoOld.getDatetype())){
						if(prpljobmanagertimeDtoNew.getTime().substring(8).equals(prpljobmanagertimeDtoOld.getTime().substring(8))){
							prpljobmanagertimeDtoNew.setFid(prpljobmanagertimeDtoOld.getFid());
							prpljobmanagertimeDtoNew.setDatetype(prpljobmanagertimeDtoOld.getDatetype());
							prpljobmanagertimeDtoNew.setStates("1");
						}else{
							prpljobmanagertimeDtoNew.setFid(prpljobmanagertimeDtoOld.getFid());
							prpljobmanagertimeDtoNew.setDatetype("PM");
						}
					}else{
						prpljobmanagertimeDtoNew.setFid(prpljobmanagertimeDtoOld.getFid());
						prpljobmanagertimeDtoNew.setDatetype("PM");
					}
				}
			}
			//判断页面显示 班表角色 是否允许修改 yes可以 no 不可以
			for(PrpDuserDto prpDuserDto : prpDuserDtoList){
				if(prpljobmanagerDto.getHandlercode().equals(prpDuserDto.getUserCode())){
					System.err.println("gradecode==>"+prpDuserDto.getGradecode()+"   jobrole==>"+prpljobmanagerDto.getJobrole());
					if(prpDuserDto.getGradecode().indexOf(prpljobmanagerDto.getJobrole()) >= 0 || prpljobmanagerDto.getJobrole().indexOf(prpDuserDto.getGradecode()) >= 0){
						prpljobmanagerDto.setState("yes");
						break;
					}else{
						prpljobmanagerDto.setState("no");
					}
				}else{
					prpljobmanagerDto.setState("no");
				}
			}
			prpljobmanagerDto.setPrpljobmanagertimeDtoListPm(prpljobmanagertimeDtoListNewPm);
			prpljobmanagerDtoList.add(prpljobmanagerDto);
		}
		//处理联系人信息
		conditions = " classcode = '"+ classCode +"' and handledept='"+handledept+"' and month='"+month+"'";
		BLPrpLJobLinkerFacade blPrpLJobLinkerFacade = new BLPrpLJobLinkerFacade();
		ArrayList<PrpLJobLinkerDto> prpLJobLinkerDtoList = (ArrayList<PrpLJobLinkerDto>)blPrpLJobLinkerFacade.findByConditions(conditions);
		
		if(null != prpLJobLinkerDtoList && prpLJobLinkerDtoList.size()>0){
			ClaimJobLinkDto[] claimJobLinkDtoList = new ClaimJobLinkDto[prpLJobLinkerDtoList.size()];
			for(int i=0;i<prpLJobLinkerDtoList.size();i++){
				PrpLJobLinkerDto prpLJobLinkerDto = prpLJobLinkerDtoList.get(i);
				ClaimJobLinkDto claimJobLinkDto = new ClaimJobLinkDto();
				String staffPosition = prpLJobLinkerDto.getStaffPosition();
				String staffPositionName = "";
				if("0".equals(staffPosition)){
					staffPositionName = "转接报案人";
				}else if("1".equals(staffPosition)){
					staffPositionName = "对接人";
				}
				claimJobLinkDto.setStaffPosition(staffPositionName);
				claimJobLinkDto.setStaffName(prpLJobLinkerDto.getStaffName());
				claimJobLinkDto.setStaffPhone(prpLJobLinkerDto.getStaffPhone());
				
				String staffType = prpLJobLinkerDto.getStaffType();
				if("0".equals(staffType)){
					claimJobLinkDto.setStaffType("本机构人员");
				}else if("1".equals(staffType)){
					claimJobLinkDto.setStaffType("非本机构人员");
				}
				claimJobLinkDtoList[i] = claimJobLinkDto;
			}
			claimJobManagerDetailMainDto.setClaimJobLinkDto(claimJobLinkDtoList);
		}
		
		if(null != prpljobmanagerDtoList && prpljobmanagerDtoList.size()>0){
			ClaimJobManagerDetailDto[] claimJobManagerDetailList = new ClaimJobManagerDetailDto[prpljobmanagerDtoList.size()];
			for(int i=0;i<prpljobmanagerDtoList.size();i++){
				PrpljobmanagerDto prpljobmanagerDto = prpljobmanagerDtoList.get(i);
				ClaimJobManagerDetailDto claimJobManagerDetailDto = new ClaimJobManagerDetailDto();
				claimJobManagerDetailDto.setHandlerCode(prpljobmanagerDto.getHandlercode());
				claimJobManagerDetailDto.setHandlerName(prpljobmanagerDto.getHandlername());
				claimJobManagerDetailDto.setComCode(prpljobmanagerDto.getHandledept());
				claimJobManagerDetailDto.setComName(prpljobmanagerDto.getDeptname());
				claimJobManagerDetailDto.setJobRole(prpljobmanagerDto.getJobrole());
				
				ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoListAm = new ArrayList<PrpljobmanagertimeDto>();
				ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoList1 = prpljobmanagerDto.getPrpljobmanagertimeDtoListAm();
				if(null != prpljobmanagertimeDtoList1 && prpljobmanagertimeDtoList1.size()>0){
					for(int j=0;j<prpljobmanagertimeDtoList1.size();j++){
						if("1".equals(prpljobmanagertimeDtoList1.get(j).getStates())){
							prpljobmanagertimeDtoListAm.add(prpljobmanagertimeDtoList1.get(j));
						}
					}
				}
				if(null != prpljobmanagertimeDtoListAm && prpljobmanagertimeDtoListAm.size()>0){
					String[] workTimeAm = new String[prpljobmanagertimeDtoListAm.size()];
					for(int m=0;m<prpljobmanagertimeDtoListAm.size();m++){
						workTimeAm[m] = prpljobmanagertimeDtoListAm.get(m).getTime();
					}
					claimJobManagerDetailDto.setWorkTimeAm(workTimeAm);
				}
				
				ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoListPm = new ArrayList<PrpljobmanagertimeDto>();
				ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoList2 = prpljobmanagerDto.getPrpljobmanagertimeDtoListPm();
				if(null != prpljobmanagertimeDtoList2 && prpljobmanagertimeDtoList2.size()>0){
					for(int j=0;j<prpljobmanagertimeDtoList2.size();j++){
						if("1".equals(prpljobmanagertimeDtoList2.get(j).getStates())){
							prpljobmanagertimeDtoListPm.add(prpljobmanagertimeDtoList2.get(j));
						}
					}
				}
				if(null != prpljobmanagertimeDtoListPm && prpljobmanagertimeDtoListPm.size()>0){
					String[] workTimePm = new String[prpljobmanagertimeDtoListPm.size()];
					for(int n=0;n<prpljobmanagertimeDtoListPm.size();n++){
						workTimePm[n] = prpljobmanagertimeDtoListPm.get(n).getTime();
					}
					claimJobManagerDetailDto.setWorkTimePm(workTimePm);
				}
				
				claimJobManagerDetailList[i] = claimJobManagerDetailDto;
			}
			claimJobManagerDetailMainDto.setClaimJobManagerDetailList(claimJobManagerDetailList);
		}
		
		
		return claimJobManagerDetailMainDto;
	}
	
	/**
	 * 当前月展示天数集合
	 * @param httpServletRequest
	 * @param month
	 * @return 返回当前月展示天数集合
	 */
	private ArrayList<PrpljobmanagertimeDto> findMonthDay(String month){
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
		return prpljobmanagertimeDtoList;
	}
	
	private boolean isEmpty(String str) {
		return (str == null || str.trim().length() == 0);
	}
}
