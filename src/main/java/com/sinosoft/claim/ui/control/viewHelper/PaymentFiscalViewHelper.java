package com.sinosoft.claim.ui.control.viewHelper;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.sinosoft.claim.bl.action.domain.BLPrpLclaimBillManagerAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayExtAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayHisAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayNoticeAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayNoticeListAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpaymainAction;
import com.sinosoft.claim.bl.action.domain.BLPrplfiscalpaydetailAction;
import com.sinosoft.claim.bl.action.domain.BLPrplfiscalpaymainAction;
import com.sinosoft.claim.bl.action.domain.BLPrplpayAction;
import com.sinosoft.claim.bl.facade.BLPrepayFacade;
import com.sinosoft.claim.bl.facade.BLPrpCinsuredFacade;
import com.sinosoft.claim.bl.facade.BLPrpDcompanyFacade;
import com.sinosoft.claim.bl.facade.BLPrpJpaymentpackDetailFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpayExtFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpayHisFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpayNoticeFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpayNoticeListFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpayShowFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpaymainFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLPrplfiscalpaydetailFacade;
import com.sinosoft.claim.bl.facade.BLPrplfiscalpaymainFacade;
import com.sinosoft.claim.bl.facade.BLPrplpayFacade;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpCinsuredDto;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.dto.domain.PrpLclaimBillManagerDto;
import com.sinosoft.claim.dto.domain.PrpLpayExtDto;
import com.sinosoft.claim.dto.domain.PrpLpayHisDto;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeDto;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeListDto;
import com.sinosoft.claim.dto.domain.PrpLpayShowDto;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrplfiscalpaydetailDto;
import com.sinosoft.claim.dto.domain.PrplfiscalpaymainDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.log.PayQueryConditionLogger;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPowerInterface;
import com.sinosoft.claim.ui.control.facade.UIWorkFlowApprovalInterFaceFacade;
import com.sinosoft.claim.util.DateCompute;
import com.sinosoft.claim.util.TurnPageUtil;
import com.sinosoft.function.insutil.bl.action.custom.BLBillAction;
import com.sinosoft.platform.bl.facade.BLPrpDcodeFacade;
import com.sinosoft.platform.dto.domain.PrpDcodeDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.ParamUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ��������֧����Ϣ������
 * @author Administrator
 *
 */
public class PaymentFiscalViewHelper {
	
	/****************��������֧������ begin*******************/
	public void paymainFiscalRegistBefore(HttpServletRequest request)throws Exception{
		PaymentViewHelper paymentViewHelper = new PaymentViewHelper();
		String payType = request.getParameter("payType");
		String paymentType = request.getParameter("paymentType");
		String back = request.getParameter("back");
		if("undefined".equals(paymentType)){
			paymentType = "";
		}
		if("undefined".equals(payType)){
			payType = "";
		}
		if(back==null||"undefined".equals(paymentType)){
			back = "";
		}
		//ÿҳ��ʾ������
        //int rowsPerPage =Integer.parseInt(AppConfig.get("sysconst.ROWS_PERPAGE"));
        int rowsPerPage = TurnPageUtil.PERPAGE;
        //int rowsPerPage =5;
        //ҳ��
        int pageNo = Integer.parseInt(request.getParameter("pageNo")==null?"1":request.getParameter("pageNo")+"");
        UserDto user = (UserDto)request.getSession().getAttribute("user");
        String userComCode = user.getComCode();
        String conditions=paymentViewHelper.getPayNewConditions(request);
        if (request.getParameter("condition")!=null&&!"".equals(request.getParameter("condition"))&&!"null".equals(request.getParameter("condition"))) {
        	conditions=request.getParameter("condition");
		}else{
			 String registNo = request.getParameter("registNoT");
		     if(registNo!=null&&!"".equals(registNo.trim())) paymentType="";
		}
        UIPowerInterface uiPowerInterface = new UIPowerInterface();
        String sqlStr = uiPowerInterface.addPower(user, "r", "", "ComCode");
        String sqlStr2 = uiPowerInterface.addPower(user, "ent", "", "resavecom");
        
        
        if (user==null) {
			throw new Exception("sessionʧЧ");
		}else {
			if (request.getParameter("condition")!=null&&!"".equals(request.getParameter("condition"))&&!"null".equals(request.getParameter("condition"))) {
				if(conditions.indexOf("r.registNo")>-1)  paymentType="";
			}else{
				//conditions+=" and r.comcode like '" + user.getComCode().substring(0, 6) + "%'" ;
				/*String sqlStr3=" or exists (select 1 "+
		        " from prplentrust ent, prplpaytrace paytrace "+
		        " where ent.registno = r.registno "+
		        "  and ent.flag = '1' "+
		        "  and ent.entrustid = paytrace.entrustid "+
		        "  and ent.entrustway in ('1', '2') "+sqlStr2+" ) ";*/
				conditions += " AND ( (1=1 " + sqlStr + "))";//���¼���
				//conditions +=sqlStr3 + ")";
			}
		}
        //�жϰ�������
        String casesType = "";
        String mechanism = request.getParameter("mechanism");
        String agnet = request.getParameter("agnet");
        
        if((mechanism!=null&&!mechanism.trim().equals(""))&&(agnet!=null&&!agnet.trim().equals(""))){
        	casesType = "no";
        }else if(mechanism!=null&&!mechanism.trim().equals("")){
        	casesType = "mechanism";
        }else if(agnet!=null&&!agnet.trim().equals("")){
        	casesType = "agnet";
        }
        String registNo = request.getParameter("registNo");
        
        if(registNo!=null&&!"".equals(registNo.trim())) paymentType="";
        
        
        PageRecord pr=new BLPrpLpayShowFacade().getFiscalQueryShowRegistList(payType, paymentType,back,user.getUserCode(), conditions, pageNo, rowsPerPage,casesType,userComCode);
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
	}
	
	public Collection getAllclaimBill(HttpServletRequest httpServletRequest) throws Exception {
		Collection prpLclaimBillManagerDtoList= new ArrayList();
		DBManager dbManager = new DBManager();
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			String [] registNoReqs = httpServletRequest.getParameterValues("registNo");
			String [] compensateNos = httpServletRequest.getParameterValues("compensateNo");
			String condition = " 1=1 ";
			String registNoLists = "";
			String compensateNoLists = "";
			if(null!=registNoReqs && !"".equals(registNoReqs) && registNoReqs.length>0){
				for(int i=0;i<registNoReqs.length;i++){
					if(null!=registNoLists && !"".equals(registNoLists)){
						registNoLists += ",'"+registNoReqs[i]+"'";
					}else{
						registNoLists += "'"+registNoReqs[i]+"'";
					}
					if(null!=compensateNos && !"".equals(compensateNos) && compensateNos.length>0){
						if(null!=compensateNoLists && !"".equals(compensateNoLists)){
							compensateNoLists += ",'"+compensateNos[i]+"'";
						}else{
							compensateNoLists += "'"+compensateNos[i]+"'";
						}
					}
					
				}
			}
			
			if(null!=registNoLists && !"".equals(registNoLists)){
				condition += " and registno in ("+registNoLists+")  ";
			}
			if(null!=compensateNoLists && !"".equals(compensateNoLists)){
				condition += " and compensateno  in ("+compensateNoLists+") ";
			}
			String fiscalno = httpServletRequest.getParameter("fiscalNo");
			condition += " and insuredcode not in (select insuredcode from prplfiscalpaydetail dd where dd.compensateno = prplclaimbillmanager.compensateno ";
			if(null!=fiscalno && !"".equals(fiscalno)){
				condition += " and dd.fiscalno not in ('"+fiscalno+"')";
			}
			condition += ")";
			httpServletRequest.setAttribute("fiscalno", fiscalno);
			condition += " and Length(Insuredcode) = 15 ";
			BLPrpLclaimBillManagerAction blPrpLclaimBillManagerAction = new BLPrpLclaimBillManagerAction();
			
			prpLclaimBillManagerDtoList= blPrpLclaimBillManagerAction.findByPaynameIndetSum(dbManager, condition,fiscalno);
		}catch(Exception e){
			e.printStackTrace();
			
			throw e;
		}finally{
			dbManager.close();
		}
		return prpLclaimBillManagerDtoList;
	}
	
	
	public void fiscalmainEdit(HttpServletRequest httpServletRequest) throws Exception {
		PaymentViewHelper paymentViewHelper = new PaymentViewHelper();
		PrpLpaymainDto prpLpaymainDto = new PrpLpaymainDto();
		UICodeAction uiCodeAction = new UICodeAction();
		//String registNo= httpServletRequest.getParameter("registNo");
		String nodeType = httpServletRequest.getParameter("nodeType");
		String editType = httpServletRequest.getParameter("editType");
		
		//�жϱ�־������Ԥ�����㻷�ڽ���֧����Ϣҳ�棬�����жϷ����Ƿ����ͨ��
		String isBtn = httpServletRequest.getParameter("isBtn");
		boolean judgeFlag = true;
		if(isBtn!=null&&"true".equals(isBtn)) judgeFlag=false;
		String [] registNoReqs = httpServletRequest.getParameterValues("registNo");
		String [] compensateNos = httpServletRequest.getParameterValues("compensateNo");
		UserDto user = (UserDto)httpServletRequest.getSession().getAttribute("user");
		ArrayList<PrpLpayShowDto> prpLpayShowDtoList = new ArrayList<PrpLpayShowDto>();
		BLPrpLpayShowFacade blPrpLpayShowFacade = new BLPrpLpayShowFacade();
		ArrayList<String> certiNos = new ArrayList<String>();
		ArrayList<String> registNos = new ArrayList<String>();
		if(compensateNos!=null&&compensateNos.length>0){
			for(int i=0;i<compensateNos.length;i++){
				certiNos.add(compensateNos[i]);
			}
			
		}
		if(registNoReqs!=null&&registNoReqs.length>0){
			for(int i=0;i<registNoReqs.length;i++){
				registNos.add(registNoReqs[i]);
			}
		}
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		
		String Datatype="linkOne";
		Datatype = httpServletRequest.getParameter("Datatype");
		BLPrpLpayExtFacade blPrpLpayExtFacade = new BLPrpLpayExtFacade();
		BLPrplpayFacade blPrplpayFacade = new BLPrplpayFacade();
		ArrayList<PrpLpayExtDto> prpLpayExtDtoList = new ArrayList<PrpLpayExtDto>();
		String vflag="";
		PrpLpayExtDto prpLpayExtDtoNew = null;
		//��ȡũ��������Ϣbegin
		Collection<PrpLclaimBillManagerDto> fiscalFarmerslist = getAllclaimBill(httpServletRequest);
		httpServletRequest.setAttribute("fiscalFarmerslist", fiscalFarmerslist);
		//��ȡũ��������Ϣ end
		
		if("ADD".equals(editType)){
			String payType = httpServletRequest.getParameter("payType");
			String paymentType = httpServletRequest.getParameter("paymentType");
			prpLpaymainDto.setPayType(payType);
			prpLpaymainDto.setPaymentType(paymentType);
			prpLpaymainDto.setPayType("".equals(prpLpaymainDto.getPayType())?"P5":prpLpaymainDto.getPayType());
			prpLpaymainDto.setPaymentType("".equals(prpLpaymainDto.getPaymentType())?"P6":prpLpaymainDto.getPaymentType());
			//forward = "ADD";
			//System.out.println("@@@@@@@@@@@@@@@@@@======  ADD  =======@@@@@@@@@@@@@@@@@@@");
			//blPrepayFacade.findByPrimaryKey(compensateNo);
			if(null!=registNos && !"".equals(registNos) && registNos.size()>0){
				prpLpayShowDtoList = blPrpLpayShowFacade.getShowList(payType, paymentType,user.getComCode(),"",judgeFlag, registNos, certiNos,"0");
			}else{
				System.out.println("�����ˣ�"+user.getUserCode()+"--"+user.getUserName());
				PayQueryConditionLogger.payQueryConditionData("paymentViewHeler������<br>�����ˣ�"+user.getUserCode()+"--"+user.getUserName()+"--֧�����ͣ�"+payType);
				throw new Exception ("�����Ų���Ϊ�գ�");
			}
			
			Datatype = httpServletRequest.getParameter("Datatype");
			if(Datatype!=null&&!"".equals(Datatype)){
				//�ϲ�֧��ʱ�����ݼ������+�ⰸ������prplpay���в�ѯ�Ƿ���ڶ�Ӧ��¼���������֧����Ŀ��
			}
			//���һ���������
			prpLpayExtDtoNew = new PrpLpayExtDto();
			prpLpayExtDtoNew.setComCode(user.getComCode());
			prpLpayExtDtoNew.setComCName(new UICodeAction().translateComCode(user.getComCode(), true));
			prpLpayExtDtoNew.setNodeType(nodeType);
			//String nodeTypeName = "epay".equals(nodeType)?"֧��":uiCodeAction.translateCodeCode("ClaimNodeType", nodeType, true);
			String nodeName="";
			if("apay".equals(nodeType)){
				nodeName = "֧��¼��";
			}else if("vpay".equals(nodeType)){
				nodeName = "֧������";
			}else{
				nodeName = uiCodeAction.translateCodeCode("ClaimNodeType", nodeType, true);
			}
			prpLpayExtDtoNew.setNodeName(nodeName);
			prpLpayExtDtoNew.setInputDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
			//String inputHour = DateTime.current().HOUR_TO_HOUR+":"+DateTime.current().MINUTE_TO_MINUTE+":"+DateTime.current().SECOND_TO_SECOND;
//			StringBuffer bf = new StringBuffer(200);
//			if(registNos!=null&&registNos.size()>0){
//				bf.append(" and registNo in ( ");
//	    		for(int i=0;i<registNos.size();i++){
//	    			if(i!=0)bf.append(" , ");
//	    			bf.append(" '"+registNos.get(i).trim()+"' ");
//	    		}
//	    		bf.append(" ) ");
//	    	}
			String costTime ="";
			String starDate = "";
			//ȡ����ͨ��ʱ�䣬�������������ȡ���ֵ
			if(prpLpayShowDtoList!=null&&prpLpayShowDtoList.size()>0){
				if(prpLpayShowDtoList.size()==1){
					starDate=prpLpayShowDtoList.get(0).getUnderWriteEndDate();
				}else{
					for(int i=1;i<prpLpayShowDtoList.size();i++){
						String bDate = prpLpayShowDtoList.get(i).getUnderWriteEndDate();
						String eDate = prpLpayShowDtoList.get(i-1).getUnderWriteEndDate();
						int temp =DateCompute.compareDate(bDate,eDate);
						if(temp>=0){
							starDate=prpLpayShowDtoList.get(i).getUnderWriteEndDate();
						}else{
							starDate=prpLpayShowDtoList.get(i-1).getUnderWriteEndDate();
						}
					}
				}
			}
			
			//endCaseDate = ((PrpLclaimDto)col.iterator().next()).getEndCaseDate();
			DateTime now = new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND);
			costTime = DateCompute.intervalDateTime(starDate, now.toString(), DateCompute.DAY_TO_MINUTE);
			prpLpayExtDtoNew.setCostTime(costTime);
			prpLpayExtDtoNew.setOperatorCode(user.getUserCode());
			prpLpayExtDtoNew.setOperatorCodeName(user.getUserName());
			if("".equals(vflag)){
				prpLpayExtDtoNew.setNotionCode("0");
				prpLpayExtDtoNew.setNotionName("δ����");
			}
		}else if("EDIT".equals(editType)){
			String fiscalno = httpServletRequest.getParameter("fiscalNo");
			BLPrplfiscalpaydetailFacade blPrplfiscalpaydetailFacade = new BLPrplfiscalpaydetailFacade();
			Collection prplfiscalpaydetailList = blPrplfiscalpaydetailFacade.findByConditions("fiscalno = '"+fiscalno+"'");
			httpServletRequest.setAttribute("prplfiscalpaydetailList", prplfiscalpaydetailList);
			
			String payType = httpServletRequest.getParameter("payType");
			String paymentType = httpServletRequest.getParameter("paymentType");
			prpLpaymainDto.setPayType(payType);
			prpLpaymainDto.setPaymentType(paymentType);
			prpLpaymainDto.setPayType("".equals(prpLpaymainDto.getPayType())?"P5":prpLpaymainDto.getPayType());
			prpLpaymainDto.setPaymentType("".equals(prpLpaymainDto.getPaymentType())?"P6":prpLpaymainDto.getPaymentType());
			String backReason = prpLpaymainDto.getPayRemark();
			//forward = "ADD";
			//System.out.println("@@@@@@@@@@@@@@@@@@======  ADD  =======@@@@@@@@@@@@@@@@@@@");
			BLPrepayFacade blPrepayFacade = new BLPrepayFacade();
			//blPrepayFacade.findByPrimaryKey(compensateNo);
			if(null!=registNos && !"".equals(registNos) && registNos.size()>0){
				prpLpayShowDtoList = blPrpLpayShowFacade.getShowList(payType, paymentType,user.getComCode(),"",judgeFlag, registNos, certiNos,"0");
			}else{
				System.out.println("�����ˣ�"+user.getUserCode()+"--"+user.getUserName());
				PayQueryConditionLogger.payQueryConditionData("paymentViewHeler������<br>�����ˣ�"+user.getUserCode()+"--"+user.getUserName()+"--֧�����ͣ�"+payType);
				throw new Exception ("�����Ų���Ϊ�գ�");
			}
			
			Datatype = httpServletRequest.getParameter("Datatype");
			if(Datatype!=null&&!"".equals(Datatype)){
				//�ϲ�֧��ʱ�����ݼ������+�ⰸ������prplpay���в�ѯ�Ƿ���ڶ�Ӧ��¼���������֧����Ŀ��
			}
			if(null!=prplfiscalpaydetailList&&!prplfiscalpaydetailList.isEmpty()){
				String payExtSql = " paymentNo = '"+fiscalno+"' and  flag='Y' order by inputdate "	;
				prpLpayExtDtoList=(ArrayList<PrpLpayExtDto>) blPrpLpayExtFacade.findByConditions(payExtSql);
				for(int i=0;i<prpLpayExtDtoList.size();i++){
					String nodeName="";
					if("apay".equals(prpLpayExtDtoList.get(i).getNodeType())){
						nodeName = "֧��¼��";
					}else if("vpay".equals(prpLpayExtDtoList.get(i).getNodeType())){
						nodeName = "֧������";
					}else if("back".equals(prpLpayExtDtoList.get(i).getNodeType())){
						nodeName = "�����˻�";
					}else{
						nodeName = uiCodeAction.translateCodeCode("ClaimNodeType", prpLpayExtDtoList.get(i).getNodeType(), true);
					}
					String comCName = new UICodeAction().translateComCode(prpLpayExtDtoList.get(i).getComCode(), true);
					String userName = new UICodeAction().translateUserCode(prpLpayExtDtoList.get(i).getOperatorCode(), true);
					prpLpayExtDtoList.get(i).setNodeName(nodeName);
					prpLpayExtDtoList.get(i).setComCName(comCName);
					prpLpayExtDtoList.get(i).setOperatorCodeName(userName);
				}
				String starDate = "";
				//ȡ����ͨ��ʱ�䣬�������������ȡ���ֵ
				if(prpLpayShowDtoList!=null&&prpLpayShowDtoList.size()>0){
					if(prpLpayShowDtoList.size()==1){
						starDate=prpLpayShowDtoList.get(0).getUnderWriteEndDate();
					}else{
						for(int i=1;i<prpLpayShowDtoList.size();i++){
							
							int temp =DateCompute.compareDate(prpLpayShowDtoList.get(i).getUnderWriteEndDate(),prpLpayShowDtoList.get(i-1).getUnderWriteEndDate());
							if(temp>=0){
								starDate=prpLpayShowDtoList.get(i).getUnderWriteEndDate();
							}else{
								starDate=prpLpayShowDtoList.get(i-1).getUnderWriteEndDate();
							}
						}
					}
				}
				
				this.getCostTime(prpLpayExtDtoList, starDate);
			
			
		}
		//���һ���������
		String payExtSql = " paymentNo = '"+fiscalno+"' and flag= 'N' "	;
		Collection payExtList =blPrpLpayExtFacade.findByConditions(payExtSql);
		
		prpLpayExtDtoNew=payExtList.iterator().hasNext()?(PrpLpayExtDto) payExtList.iterator().next():new PrpLpayExtDto();
			//���һ���������
			prpLpayExtDtoNew.setComCode(user.getComCode());
			prpLpayExtDtoNew.setComCName(new UICodeAction().translateComCode(user.getComCode(), true));
			prpLpayExtDtoNew.setNodeType(nodeType);
			//String nodeTypeName = "epay".equals(nodeType)?"֧��":uiCodeAction.translateCodeCode("ClaimNodeType", nodeType, true);
			String nodeName="";
			if("apay".equals(nodeType)){
				nodeName = "֧��¼��";
			}else if("vpay".equals(nodeType)){
				nodeName = "֧������";
			}else{
				nodeName = uiCodeAction.translateCodeCode("ClaimNodeType", nodeType, true);
			}
			prpLpayExtDtoNew.setNodeName(nodeName);
			prpLpayExtDtoNew.setInputDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
			//String inputHour = DateTime.current().HOUR_TO_HOUR+":"+DateTime.current().MINUTE_TO_MINUTE+":"+DateTime.current().SECOND_TO_SECOND;
//			StringBuffer bf = new StringBuffer(200);
//			if(registNos!=null&&registNos.size()>0){
//				bf.append(" and registNo in ( ");
//	    		for(int i=0;i<registNos.size();i++){
//	    			if(i!=0)bf.append(" , ");
//	    			bf.append(" '"+registNos.get(i).trim()+"' ");
//	    		}
//	    		bf.append(" ) ");
//	    	}
			String costTime ="";
			if(prpLpayExtDtoList!=null&&prpLpayExtDtoList.size()>0){
				PrpLpayExtDto prpLpayExtDtolast = prpLpayExtDtoList.get(prpLpayExtDtoList.size()-1);
				String starDate = prpLpayExtDtolast.getInputDate().toString(DateTime.YEAR_TO_SECOND);
				DateTime now = new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND);
				costTime = DateCompute.intervalDateTime(starDate, now.toString(), DateCompute.DAY_TO_MINUTE);
			}else{
				//Collection col  = new BLPrpLclaimFacade().findByConditions(" 1=1 "+bf.toString()+" order by endcasedate desc ");
				String starDate = "";
				//ȡ����ͨ��ʱ�䣬�������������ȡ���ֵ
				if(prpLpayShowDtoList!=null&&prpLpayShowDtoList.size()>0){
					if(prpLpayShowDtoList.size()==1){
						starDate=prpLpayShowDtoList.get(0).getUnderWriteEndDate();
					}else{
						for(int i=1;i<prpLpayShowDtoList.size();i++){
							
							int temp =DateCompute.compareDate(prpLpayShowDtoList.get(i).getUnderWriteEndDate(),prpLpayShowDtoList.get(i-1).getUnderWriteEndDate());
							if(temp>=0){
								starDate=prpLpayShowDtoList.get(i).getUnderWriteEndDate();
							}else{
								starDate=prpLpayShowDtoList.get(i-1).getUnderWriteEndDate();
							}
						}
					}
				}
				
				DateTime now = new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND);
				costTime = DateCompute.intervalDateTime(starDate, now.toString(), DateCompute.DAY_TO_MINUTE);
			}
			
			prpLpayExtDtoNew.setCostTime(costTime);
			prpLpayExtDtoNew.setOperatorCode(user.getUserCode());
			prpLpayExtDtoNew.setOperatorCodeName(user.getUserName());
			if("".equals(vflag)){
				prpLpayExtDtoNew.setNotionCode("0");
				prpLpayExtDtoNew.setNotionName("δ����");
			}
			PrpLpayExtDto prpLpayExtDtoNew1 = new PrpLpayExtDto();
			if(!"".equals(prpLpaymainDto.getBackDate())&&!"".equals(backReason)){
				prpLpayExtDtoNew1.setComCode(prpLpaymainDto.getBackComCode());
				prpLpayExtDtoNew1.setComCName(new UICodeAction().translateComCode(prpLpaymainDto.getBackComCode(), true));
				prpLpayExtDtoNew1.setInputDate(prpLpaymainDto.getBackDate());
				DateTime now = new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND);
				costTime = DateCompute.intervalDateTime(prpLpaymainDto.getBackDate().toString(), now.toString(), DateCompute.DAY_TO_MINUTE);
				prpLpayExtDtoNew1.setCostTime(costTime);
				prpLpayExtDtoNew1.setNotionCode("9");
				prpLpayExtDtoNew1.setNotionName("�·��޸�");
				prpLpayExtDtoNew1.setNodeType("back");
				prpLpayExtDtoNew1.setNodeName("�����˻�");
				prpLpayExtDtoNew1.setContext(backReason);
				prpLpayExtDtoNew1.setSerialNo(prpLpayExtDtoList.size()+1);
				prpLpayExtDtoNew1.setOperatorCode(prpLpaymainDto.getBackOperatorCode());
				prpLpayExtDtoNew1.setFlag("Y");
				prpLpayExtDtoNew1.setOperatorCodeName(new UICodeAction().translateUserCode(prpLpaymainDto.getBackOperatorCode(), true));
				prpLpayExtDtoList.add(prpLpayExtDtoNew1);
			}
		}else if("SHOW".equals(editType)){
			String fiscalno = httpServletRequest.getParameter("fiscalNo");
			BLPrplfiscalpaydetailFacade blPrplfiscalpaydetailFacade = new BLPrplfiscalpaydetailFacade();
			Collection prplfiscalpaydetailList = blPrplfiscalpaydetailFacade.findByConditions("fiscalno = '"+fiscalno+"'");
			httpServletRequest.setAttribute("prplfiscalpaydetailList", prplfiscalpaydetailList);
			String payType = httpServletRequest.getParameter("payType");
			String paymentType = httpServletRequest.getParameter("paymentType");
			if(null!=registNos && !"".equals(registNos) && registNos.size()>0){
				prpLpayShowDtoList = blPrpLpayShowFacade.getShowList(payType, paymentType,user.getComCode(),"",judgeFlag, registNos, certiNos,"0");
			}else{
				System.out.println("�����ˣ�"+user.getUserCode()+"--"+user.getUserName());
				PayQueryConditionLogger.payQueryConditionData("paymentViewHeler������<br>�����ˣ�"+user.getUserCode()+"--"+user.getUserName()+"--֧�����ͣ�"+payType);
				throw new Exception ("�����Ų���Ϊ�գ�");
			}
			prpLpayExtDtoList = (ArrayList<PrpLpayExtDto>) blPrpLpayExtFacade.findByConditions(" paymentno = '"+fiscalno+"'");
			for(int i=0;i<prpLpayExtDtoList.size();i++){
				String nodeName="";
				if("apay".equals(prpLpayExtDtoList.get(i).getNodeType())){
					nodeName = "����֧��";
				}else if("vpay".equals(prpLpayExtDtoList.get(i).getNodeType())){
					nodeName = "֧������";
				}else{
					nodeName = uiCodeAction.translateCodeCode("ClaimNodeType", prpLpayExtDtoList.get(i).getNodeType(), true);
				}
				String comCName = new UICodeAction().translateComCode(prpLpayExtDtoList.get(i).getComCode(), true);
				String userName = new UICodeAction().translateUserCode(prpLpayExtDtoList.get(i).getOperatorCode(), true);
				prpLpayExtDtoList.get(i).setNodeName(nodeName);
				prpLpayExtDtoList.get(i).setComCName(comCName);
				prpLpayExtDtoList.get(i).setOperatorCodeName(userName);
			}
			String starDate = "";
			//ȡ����ͨ��ʱ�䣬�������������ȡ���ֵ
			if(prpLpayShowDtoList!=null&&prpLpayShowDtoList.size()>0){
				if(prpLpayShowDtoList.size()==1){
					starDate=prpLpayShowDtoList.get(0).getUnderWriteEndDate();
				}else{
					for(int i=1;i<prpLpayShowDtoList.size();i++){
						
						int temp =DateCompute.compareDate(prpLpayShowDtoList.get(i).getUnderWriteEndDate(),prpLpayShowDtoList.get(i-1).getUnderWriteEndDate());
						if(temp>=0){
							starDate=prpLpayShowDtoList.get(i).getUnderWriteEndDate();
						}
					}
				}
			}
			this.getCostTime(prpLpayExtDtoList, starDate);
			httpServletRequest.setAttribute("prpLpayExtDtoList", prpLpayExtDtoList);
			
		}
		//�ϲ�֧��ʱ�����������ѡ�����ޱ�������ѡ�
		if(!"mergeMany".equals(Datatype)&&!"SHOW".equals(editType)){
			if("ADD".equals(editType)){
				PrpLregistDto prpLregistDto= blPrpLregistFacade.findByPrimaryKey(registNoReqs[0]);
				String  bbxrInsuredType = "";
				ArrayList<PrpCinsuredDto> insuredList  = (ArrayList<PrpCinsuredDto>) new BLPrpCinsuredFacade().findByConditions(" policyNo in (select policyno from prplregistrpolicy where registno='"+registNoReqs[0]+"') and insuredflag = '1' ");
				if(insuredList!=null && !insuredList.isEmpty()){
					bbxrInsuredType=insuredList.get(0).getInsuredType();
				}
				httpServletRequest.setAttribute("bbxrInsuredType", bbxrInsuredType);
				httpServletRequest.setAttribute("insuredCode", prpLregistDto.getInsuredCode());
				httpServletRequest.setAttribute("insuredName", prpLregistDto.getInsuredName());
				httpServletRequest.setAttribute("registNo", registNoReqs[0]);
			}else{
				String paymentNo =  httpServletRequest.getParameter("paymentNo");
				ArrayList<PrplpayDto> collection = (ArrayList<PrplpayDto>)blPrplpayFacade.findByConditions(" serialno='"+paymentNo+"'");
				if(collection!=null&&!collection.isEmpty()){
					String registNo = collection.get(0).getRegistno();
					PrpLregistDto prpLregistDto= blPrpLregistFacade.findByPrimaryKey(registNo);
					String  bbxrInsuredType = "";
					ArrayList<PrpCinsuredDto> insuredList  = (ArrayList<PrpCinsuredDto>) new BLPrpCinsuredFacade().findByConditions(" policyNo in (select policyno from prplregistrpolicy where registno='"+registNo+"') and insuredflag = '1' ");
					if(insuredList!=null && !insuredList.isEmpty()){
						bbxrInsuredType=insuredList.get(0).getInsuredType();
					}
					httpServletRequest.setAttribute("bbxrInsuredType", bbxrInsuredType);//������������
					httpServletRequest.setAttribute("insuredCode", prpLregistDto.getInsuredCode());
					httpServletRequest.setAttribute("insuredName", prpLregistDto.getInsuredName());
					httpServletRequest.setAttribute("registNo", registNo);
				}
				
			}
		}else{
			if(prpLpayShowDtoList!=null&&!prpLpayShowDtoList.isEmpty()){
				String insuredName = "";
				String registNo = "";
				boolean hasbbxrSelect = false;
				insuredName = prpLpayShowDtoList.get(0).getInsuredName();
				registNo = prpLpayShowDtoList.get(0).getRegistNo();
				for(int i=0;i<prpLpayShowDtoList.size();i++){
					if(!insuredName.equals(prpLpayShowDtoList.get(i).getInsuredName())){
						hasbbxrSelect = false;
					}else{
						hasbbxrSelect = true;
						continue;
					}
				}
				if(hasbbxrSelect){
					String  bbxrInsuredType = "";
					String insuredCode = "";
					ArrayList<PrpCinsuredDto> insuredList  = (ArrayList<PrpCinsuredDto>) new BLPrpCinsuredFacade().findByConditions(" policyNo in (select policyno from prplregistrpolicy where registno='"+registNo+"') and insuredflag = '1' ");
					if(insuredList!=null && !insuredList.isEmpty()){
						bbxrInsuredType=insuredList.get(0).getInsuredType();
						insuredCode =insuredList.get(0).getInsuredCode(); 
					}
					httpServletRequest.setAttribute("bbxrInsuredType", bbxrInsuredType);//������������
					httpServletRequest.setAttribute("insuredCode", insuredCode);
					httpServletRequest.setAttribute("insuredName", insuredName);
					httpServletRequest.setAttribute("hasbbxrSelect", hasbbxrSelect);
				}
			}
		}
		//�˴��μ�ClaimProcessDto.java getPayInfo()����   ��696��
		String payCondition = "codetype='NewPayRefReason' and validstatus='1' ";
		List paymentTypes=(List) new BLPrpDcodeFacade().findByConditions(payCondition);
		httpServletRequest.setAttribute("paymentTypes",paymentTypes);
		httpServletRequest.setAttribute("prpLpaymainDto", prpLpaymainDto);
		httpServletRequest.setAttribute("prpLpayShowDtoList", prpLpayShowDtoList);
		httpServletRequest.setAttribute("prpLpayExtDtoNew", prpLpayExtDtoNew);
		httpServletRequest.setAttribute("prpLpayExtDtoList", prpLpayExtDtoList);
		httpServletRequest.setAttribute("isBtn", isBtn);
		httpServletRequest.setAttribute("editType", editType);
		httpServletRequest.setAttribute("nodeType", nodeType);
		httpServletRequest.setAttribute("Datatype", Datatype);//�Ƿ�Ϊ�ϲ�֧��
		httpServletRequest.setAttribute("paymentTypeMap",paymentViewHelper.getPaymentTypeMap());//����֧��ԭ��ӳ��
		httpServletRequest.setAttribute("compensateNos", certiNos);
		if(null!=prpLpayShowDtoList && !prpLpayShowDtoList.isEmpty()){
			httpServletRequest.setAttribute("paymentType",prpLpayShowDtoList.get(0).getPayrefreason());
			if("���".equals(prpLpayShowDtoList.get(0).getPayType())||"�⸶����".equals(prpLpayShowDtoList.get(0).getPayType())){
				httpServletRequest.setAttribute("payType","P3");
			}else{
				httpServletRequest.setAttribute("payType","P1");
			}
		}
	
	}
	
	public String fiscalSaveOrUpdate (HttpServletRequest request) throws Exception {
		String submitType = request.getParameter("submitType");
		String registNo = request.getParameter("registNo");
		String vflag  = request.getParameter("vflag");
		UserDto user = (UserDto)request.getSession().getAttribute("user");
        if (user==null) {
			throw new Exception("sessionʧЧ");
		}
		String businessNo = null;
		if(submitType!=null){
			if("2".equals(submitType)){
				return savePayMainfiscal(request,"0");
			}
			//�����ύ
			else if("4".equals(submitType)){
				businessNo = savePayMainfiscal(request,"0");
				
				PrpLregistDto prpLregistDto = new BLPrpLregistFacade().findByPrimaryKey(registNo);
				if(prpLregistDto==null){
					registNo = request.getParameterValues("registNoPay")[0];
					prpLregistDto = new BLPrpLregistFacade().findByPrimaryKey(registNo);
				}
				UIWorkFlowApprovalInterFaceFacade uiWorkFlowApprovalInterFaceFacade = new UIWorkFlowApprovalInterFaceFacade();
				String UWflowID = uiWorkFlowApprovalInterFaceFacade
						.submitApprovalPlatform("VeriPay",
								"00", "00", businessNo,
										prpLregistDto.getRiskCode(),
										prpLregistDto.getClassCode(),
										prpLregistDto.getComCode(),
										user.getUserCode(), prpLregistDto.getMakeCom(),
										user.getUserCode(), user.getUserCode(),
										businessNo);
				if (UWflowID.length() < 15) {
					String msg = "����'"
							+ businessNo
							+ "'�ύ˫��ϵͳʧ�ܣ��������ύ���������Ա��ϵ!";
					throw new UserException(1, 3, "������", msg);
				}
				/*** ����ע�������ƽ̨ end****/
				new BLPrplfiscalpaydetailFacade().updateVFlag("6", businessNo);
				new BLPrplfiscalpaymainFacade().updateByKey(businessNo, "6","1");
					

				//������־���״̬ begin
				new BLPrpLpayExtFacade().updateFlagByPaymentNo(businessNo);//������־���״̬
				return businessNo;
				
			}
			
		}
		
		return null;
	}
	
	public String savePayMainfiscal(HttpServletRequest request,String status )throws Exception {
		PaymentViewHelper paymentViewHelper = new PaymentViewHelper();
		String editType = request.getParameter("editType");
		String payType = request.getParameter("payType");//֧������
		String Datatype = request.getParameter("Datatype");//�ϲ�֧����־
		
		UserDto user = (UserDto)request.getSession().getAttribute("user");
		String registNo = request.getParameter("registNo");
		String nodeType = request.getParameter("nodeType");
		String paymentType = request.getParameter("paymentType");//�������
		String mergerFlag  = request.getParameter("mergerFlag");//�ϲ��·���־
		String sumPayAmount = request.getParameter("sumPayAmount");
		String vflagHis  = request.getParameter("vflag");
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		PrpLregistDto prpLregistDto= blPrpLregistFacade.findByPrimaryKey(registNo);
		if(prpLregistDto==null){
			registNo = request.getParameterValues("registNoPay")[0];
			prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
		}
		BLBillAction uiBillAction = new BLBillAction();
		BLPrplfiscalpaymainAction blPrplfiscalmainpayAction = new BLPrplfiscalpaymainAction();
		BLPrplfiscalpaydetailAction blPrplfiscaldetailpayAction = new BLPrplfiscalpaydetailAction();
		BLPrpLpayExtAction blPrpLpayExtAction = new BLPrpLpayExtAction();
		PrplfiscalpaymainDto prplfiscalmainpayDto = null;
		PrplfiscalpaydetailDto prplfiscaldetailpayDto = null;
		DBManager dbManager = new DBManager();
		String fiscalNo = "";
		String paymentNoHis = "";
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
			if("ADD".equals(editType)){
				prplfiscalmainpayDto = new PrplfiscalpaymainDto();
				String tableName = "prplfiscalpaymain";
				String riskCode = paymentViewHelper.getRiskCodeByRegistNo(registNo, dbManager);
				String comCode = user.getComCode();
				int year = new DateTime(DateTime.current().toString()).getYear();
				
				fiscalNo = uiBillAction.getNo(dbManager,tableName, riskCode,comCode, year,"");
				//prplpay �� prpLpayExt�����ݲ�����ɾ��巽ʽ
				blPrplfiscalmainpayAction.delete(dbManager, fiscalNo);
				prplfiscalmainpayDto.setFiscalno(fiscalNo);
				prplfiscalmainpayDto.setRegistno(registNo);
				prplfiscalmainpayDto.setSumamount(Double.parseDouble(sumPayAmount));
				prplfiscalmainpayDto.setStatus(status);
				prplfiscalmainpayDto.setOperatorcode(user.getUserCode());
				prplfiscalmainpayDto.setOperatorcomcode(user.getComCode());
				prplfiscalmainpayDto.setInputdate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
				prplfiscalmainpayDto.setVflag("1");
				prplfiscalmainpayDto.setPaymenttype(paymentType);
				
				blPrplfiscalmainpayAction.insert(dbManager, prplfiscalmainpayDto);
				
				blPrplfiscaldetailpayAction.deleteByConditions(dbManager, " fiscalno='"+fiscalNo+"' ");
				blPrpLpayExtAction.deleteByConditions(dbManager, " paymentNo='"+fiscalNo+"' ");
			}else if("EDIT".equals(editType)){
				fiscalNo = request.getParameter("fiscalno");
				prplfiscalmainpayDto = blPrplfiscalmainpayAction.findByPrimaryKey(dbManager, fiscalNo);
				prplfiscalmainpayDto.setFiscalno(fiscalNo);
				prplfiscalmainpayDto.setRegistno(registNo);
				prplfiscalmainpayDto.setSumamount(Double.parseDouble(sumPayAmount));
				prplfiscalmainpayDto.setStatus(status);
				prplfiscalmainpayDto.setOperatorcode(user.getUserCode());
				prplfiscalmainpayDto.setOperatorcomcode(user.getComCode());
				prplfiscalmainpayDto.setInputdate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
				prplfiscalmainpayDto.setVflag("1");
				prplfiscalmainpayDto.setPaymenttype(paymentType);
				blPrplfiscalmainpayAction.update(dbManager, prplfiscalmainpayDto);
				request.setAttribute("prplfiscalmainpayDto", prplfiscalmainpayDto);
				
				blPrplfiscaldetailpayAction.deleteByConditions(dbManager, " fiscalNo='"+fiscalNo+"' ");
				blPrpLpayExtAction.deleteByConditions(dbManager, " paymentNo='"+fiscalNo+"' ");
			}
			saveFiscalPays(dbManager,request, fiscalNo, status);
			paymentViewHelper.savePrplpayExt(dbManager,request,fiscalNo,status);
			dbManager.commitTransaction();
		}catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplfiscalmainpayDto.getFiscalno();
	}
	
	public void saveFiscalPays(DBManager dbManager,HttpServletRequest request,String fiscalNo,String status) throws Exception {
		UserDto user = (UserDto)request.getSession().getAttribute("user");
		String editType = request.getParameter("editType");
		String payType = StringUtils.trimToEmpty(request.getParameter("payType"));//֧������
		String Datatype = request.getParameter("Datatype");//�ϲ�֧����־
		String paymentType = request.getParameter("paymentType");//�������
		String[] arrfiscalRegistNo = request.getParameterValues("fiscalRegistNo");//������
		String[] arrcompensateNo = request.getParameterValues("compensateNo");//������
		String[] arrinsuredCode = request.getParameterValues("insuredCode");//ũ������
		String[] arrpayName = request.getParameterValues("payName");//ũ������
		String[] arridentifyNumber = request.getParameterValues("identifyNumber");//���֤��
		String[] arrbankAccount = request.getParameterValues("bankAccount");//�����˺�
		String[] arrfiscalpayAmount = request.getParameterValues("fiscalpayAmount");//֧�����
		String [] comCodes= request.getParameterValues("comCodePay");
		//String registNo = request.getParameter("registNo");
		String nodeType = request.getParameter("nodeType");
		String compensateNo = request.getParameter("compensateNo");//ҵ�񵥺�
		String vflagHis  = request.getParameter("vflag");
		String paymentNoHis = "";
		
		//String [] compensateNo = request.getParameterValues("compensateNo");
		String registNo = request.getParameter("registNo");
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		PrpLregistDto prpLregistDto= blPrpLregistFacade.findByPrimaryKey(registNo);
		ArrayList<PrplfiscalpaydetailDto> list =new ArrayList<PrplfiscalpaydetailDto>();
		PrplfiscalpaydetailDto prplfiscalpaydetailDto=null;
		ArrayList<PrplfiscalpaydetailDto> prplfiscalpaydetailDtoList=null;
		PrplfiscalpaymainDto prpLfiscalpaymainDto = null;
		BLPrplfiscalpaydetailAction blPrplfiscaldetailpayAction = new BLPrplfiscalpaydetailAction();
		String flagStr = "";
		String [] flags = request.getParameterValues("flag");//�ϲ���ѡ��
		for(int k =0;k<flags.length;k++){
			flagStr += "["+flags[k]+"]";
		}
		
		for(int i=0;i<arrfiscalRegistNo.length;i++){
			if((flagStr).indexOf("["+String.valueOf(i)+"]")<0) continue;
			prplfiscalpaydetailDto = new PrplfiscalpaydetailDto();
			prplfiscalpaydetailDto.setFiscalno(fiscalNo);
			prplfiscalpaydetailDto.setSerialno((list.size()+1)+"");
			prplfiscalpaydetailDto.setReceiverfullname(arrpayName[i]);
			prplfiscalpaydetailDto.setCompensateno(arrcompensateNo[i]);
			prplfiscalpaydetailDto.setBankaccount(arrbankAccount[i]);
			prplfiscalpaydetailDto.setInsuredcode(arrinsuredCode[i]);
			prplfiscalpaydetailDto.setPayamount(Double.parseDouble(arrfiscalpayAmount[i]));
			prplfiscalpaydetailDto.setIdentifynumber(arridentifyNumber[i]);
			prplfiscalpaydetailDto.setRegistno(arrfiscalRegistNo[i]);
			prplfiscalpaydetailDto.setPaymenttype(paymentType);
			prplfiscalpaydetailDto.setPaytype(payType);
			prplfiscalpaydetailDto.setComcode(comCodes[0]);
			list.add(prplfiscalpaydetailDto);
			
		}
		blPrplfiscaldetailpayAction.insertAll(dbManager, list);
		
	
	}
	
	public Collection findByClaimBillConditions(HttpServletRequest request,String condition) throws Exception {
		DBManager dbManager = new DBManager();
		Collection collection = new ArrayList();
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	        dbManager.beginTransaction();
	        int rowsPerPage = TurnPageUtil.PERPAGE;
	        //ҳ��
	        int pageNo = Integer.parseInt(request.getParameter("pageNo")==null?"1":request.getParameter("pageNo")+"");
	        BLPrpLclaimBillManagerAction blPrpLclaimBillManagerAction = new BLPrpLclaimBillManagerAction();
	        collection = blPrpLclaimBillManagerAction.findByConditions(dbManager, condition);
	        PageRecord pr=blPrpLclaimBillManagerAction.findByConditions(dbManager, condition, pageNo, rowsPerPage);
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
			turnPageDto.setCondition(condition);
			request.setAttribute("turnPageDto", turnPageDto);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			dbManager.close();
		}
		return collection;
	}
	
	/**
	 * ����ϵͳ֧����Ϣ������ϸҳ��༭facade��
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void paymainfiscalPostEditFromUndwrt(HttpServletRequest request) throws Exception{
		//��¼���ĸ�ҳ��ת������  from Ϊundwrt  ��˫�˷�������
        String from =request.getParameter("from");
        String paymentNo =  request.getParameter("paymentNo");
        String nodeType =  request.getParameter("nodeType");
        String editType =  request.getParameter("editType");
        String undwrtEditType =  request.getParameter("undwrtEditType");
        UICodeAction uiCodeAction = new UICodeAction();
        BLPrpLpayExtFacade blPrpLpayExtFacade = new BLPrpLpayExtFacade();
		BLPrpLpaymainFacade blPrpLpaymainFacade = new BLPrpLpaymainFacade();
		BLPrplpayFacade blPrplpayFacade = new BLPrplpayFacade();
		ArrayList<PrpLpayExtDto> prpLpayExtDtoList = new ArrayList<PrpLpayExtDto>();
        //PrpLpaymainDto prpLpaymainDto = blPrpLpaymainFacade.findByPrimaryKey(paymentNo);
        ArrayList<PrpLpayShowDto> prpLpayShowDtoList = new ArrayList<PrpLpayShowDto>();
		BLPrpLpayShowFacade blPrpLpayShowFacade = new BLPrpLpayShowFacade();
        ArrayList<String> certiNos = new ArrayList<String>();
		ArrayList<String> registNos = new ArrayList<String>();
		PrpLpayExtDto prpLpayExtDtoNew = null;
		BLPrplfiscalpaydetailFacade blPrplfiscalpaydetailFacade = new BLPrplfiscalpaydetailFacade();
		ArrayList<PrplfiscalpaydetailDto> prplfiscalpaydetailList = (ArrayList<PrplfiscalpaydetailDto>)blPrplfiscalpaydetailFacade.findByConditions("fiscalno = '"+paymentNo+"'");
		request.setAttribute("prplfiscalpaydetailList", prplfiscalpaydetailList);
		PrplfiscalpaydetailDto prplfiscalpaydetailDto = (PrplfiscalpaydetailDto)prplfiscalpaydetailList.iterator().next();
		
		if(prplfiscalpaydetailList!=null && !prplfiscalpaydetailList.isEmpty()){
			String claimNoHis = "";
			String compensateNoHis = "";
			String payTypeHis = "";
			/*String bankTypeName = uiCodeAction.translateCodeCode("BankCode", prpLpaymainDto.getBankType(), true);
			prpLpaymainDto.setBankTypeName(bankTypeName);*/
			String[] registNoReqs = new String[prplfiscalpaydetailList.size()];
			String[] compensateNos = new String[prplfiscalpaydetailList.size()];
			for(int i=0;i<prplfiscalpaydetailList.size();i++){
				certiNos.add(prplfiscalpaydetailList.get(i).getCompensateno());
				registNos.add(prplfiscalpaydetailList.get(i).getRegistno());
				claimNoHis = prplfiscalpaydetailList.get(i).getClaimno();
				compensateNoHis = prplfiscalpaydetailList.get(i).getCompensateno();
				payTypeHis = prplfiscalpaydetailList.get(i).getPaytype();
				registNoReqs[i] = prplfiscalpaydetailList.get(i).getRegistno();
				compensateNos[i] = prplfiscalpaydetailList.get(i).getCompensateno();
			}
			Collection<PrpLclaimBillManagerDto> fiscalFarmerslist = getShowPrplfiscalpaydetail(registNoReqs, compensateNos, paymentNo);
			request.setAttribute("fiscalFarmerslist", fiscalFarmerslist);
			prpLpayShowDtoList = blPrpLpayShowFacade.getShowList(prplfiscalpaydetailDto.getPaytype(), prplfiscalpaydetailDto.getPaymenttype(),"0000000000","", true,registNos, certiNos,"0");
			BLPrpLpayHisFacade blPrpLpayHisFacade = new BLPrpLpayHisFacade();
			String conditions = " claimNo = '"+claimNoHis+"' and compensateNo = '"+compensateNoHis+"' and payType ='"+payTypeHis+"' order by serialNo2 desc ";
			ArrayList<PrpLpayHisDto>  prpLpayHisDtoList = (ArrayList)blPrpLpayHisFacade.findByConditions(conditions);
			PrpLpayHisDto prpLpayHisDto = new PrpLpayHisDto() ;
			if(prpLpayHisDtoList.size()>0){
				prpLpayHisDto = prpLpayHisDtoList.get(0);
			}
			request.setAttribute("prpLpayHisDto", prpLpayHisDto);
			String inputHour = "";
			//���������ϵͳ�е�editType��֧����������˴�֧��״̬Ϊ֧��ռ��
			if("fiscaldeal".equals(undwrtEditType)){
				UserDto user  = (UserDto) request.getSession().getAttribute("user");
				if("6".equals(prplfiscalpaydetailDto.getVflag())){
					//���������ϵͳ�е�editType��֧����������˴�֧��״̬Ϊ֧��ռ��
					new BLPrplfiscalpaydetailFacade().updateVFlag("2", paymentNo);//����Ϊ�������״̬
					new BLPrplfiscalpaymainFacade().updateByKey(paymentNo, "2","1");
				} 	
				String paytExtSql = " paymentNo = '"+paymentNo+"' order by inputdate "	;
				prpLpayExtDtoList=(ArrayList<PrpLpayExtDto>) blPrpLpayExtFacade.findByConditions(paytExtSql);
				for(int i=0;i<prpLpayExtDtoList.size();i++){
					//String nodeTypeName = "epay".equals(prpLpayExtDtoList.get(i).getNodetype())?"֧��":uiCodeAction.translateCodeCode("ClaimNodeType", prpLpayExtDtoList.get(i).getNodetype(), true);
					String nodeName="";
					if("apay".equals(prpLpayExtDtoList.get(i).getNodeType())){
						nodeName = "����֧��";
					}else if("vpay".equals(prpLpayExtDtoList.get(i).getNodeType())){
						nodeName = "֧������";
					}else{
						nodeName = uiCodeAction.translateCodeCode("ClaimNodeType", prpLpayExtDtoList.get(i).getNodeType(), true);
					}
					String comCName = new UICodeAction().translateComCode(prpLpayExtDtoList.get(i).getComCode(), true);
					String userName = new UICodeAction().translateUserCode(prpLpayExtDtoList.get(i).getOperatorCode(), true);
					prpLpayExtDtoList.get(i).setNodeName(nodeName);
					prpLpayExtDtoList.get(i).setComCName(comCName);
					prpLpayExtDtoList.get(i).setOperatorCodeName(userName);
				}
				
				String starDate = "";
				//ȡ����ͨ��ʱ�䣬�������������ȡ���ֵ
				if(prpLpayShowDtoList!=null&&prpLpayShowDtoList.size()>0){
					if(prpLpayShowDtoList.size()==1){
						starDate=prpLpayShowDtoList.get(0).getUnderWriteEndDate();
					}else{
						for(int i=1;i<prpLpayShowDtoList.size();i++){
							String bDate = prpLpayShowDtoList.get(i).getUnderWriteEndDate();
							String eDate = prpLpayShowDtoList.get(i-1).getUnderWriteEndDate();
							int temp =DateCompute.compareDate(bDate,eDate);
							if(temp>=0){
								starDate=prpLpayShowDtoList.get(i).getUnderWriteEndDate();
							}
						}
					}
				}
				
				this.getCostTime(prpLpayExtDtoList, starDate);
				
			}else{
				String payExtSql = " paymentNo= '"+paymentNo+"'  "	;
				prpLpayExtDtoList=(ArrayList<PrpLpayExtDto>) blPrpLpayExtFacade.findByConditions(payExtSql);
				for(int i=0;i<prpLpayExtDtoList.size();i++){
					//String nodeTypeName = "epay".equals(prpLpayExtDtoList.get(i).getNodetype())?"֧��":uiCodeAction.translateCodeCode("ClaimNodeType", prpLpayExtDtoList.get(i).getNodetype(), true);
					String nodeName="";
					if("apay".equals(prpLpayExtDtoList.get(i).getNodeType())){
						nodeName = "����֧��";
					}else if("vpay".equals(prpLpayExtDtoList.get(i).getNodeType())){
						nodeName = "֧������";
					}else{
						nodeName = uiCodeAction.translateCodeCode("ClaimNodeType", prpLpayExtDtoList.get(i).getNodeType(), true);
					}
					String comCName = new UICodeAction().translateComCode(prpLpayExtDtoList.get(i).getComCode(), true);
					String userName = new UICodeAction().translateUserCode(prpLpayExtDtoList.get(i).getOperatorCode(), true);
					prpLpayExtDtoList.get(i).setNodeName(nodeName);
					prpLpayExtDtoList.get(i).setComCName(comCName);
					prpLpayExtDtoList.get(i).setOperatorCodeName(userName);
				}
				
				String starDate = "";
				//ȡ����ͨ��ʱ�䣬�������������ȡ���ֵ
				if(prpLpayShowDtoList!=null&&prpLpayShowDtoList.size()>0){
					if(prpLpayShowDtoList.size()==1){
						starDate=prpLpayShowDtoList.get(0).getUnderWriteEndDate();
					}else{
						for(int i=1;i<prpLpayShowDtoList.size();i++){
							String bDate = prpLpayShowDtoList.get(i).getUnderWriteEndDate();
							String eDate = prpLpayShowDtoList.get(i-1).getUnderWriteEndDate();
							int temp =DateCompute.compareDate(bDate,eDate);
							if(temp>=0){
								starDate=prpLpayShowDtoList.get(i).getUnderWriteEndDate();
							}
						}
					}
				}
				this.getCostTime(prpLpayExtDtoList, starDate);
				
			}
			
		}
		
		
		//�˴��μ�ClaimProcessDto.java getPayInfo()����   ��696��
		String payCondition = "codetype='NewPayRefReason' and validstatus='1' ";
		List paymentTypes=(List) new BLPrpDcodeFacade().findByConditions(payCondition);
		request.setAttribute("paymentTypes",paymentTypes);
		request.setAttribute("prpLpayExtDtoNew", prpLpayExtDtoNew);
		request.setAttribute("paymentTypes", paymentTypes);
		request.setAttribute("PrplfiscalpaydetailDto", prplfiscalpaydetailDto);
		request.setAttribute("prpLpayShowDtoList", prpLpayShowDtoList);
		request.setAttribute("prpLpayExtDtoList", prpLpayExtDtoList);
		request.setAttribute("from", from);
		request.setAttribute("nodeType", nodeType);
		request.setAttribute("editType", editType);
		request.setAttribute("undwrtEditType", undwrtEditType);
		request.setAttribute("paymentTypeMap", getPaymentTypeMap());
		
	}
	
	/**
	 * ������͵Ķ�Ӧ��
	 * @return
	 * @throws Exception
	 */
	public HashMap getPaymentTypeMap() throws Exception {
		HashMap<String,String> paymentTypeMap = new HashMap<String,String>();
		String payCondition = " codetype='PayRefReason'  and validstatus='1' ";
		List paymentTypes=(List) new BLPrpDcodeFacade().findByConditions(payCondition);
		for(int i=0;i<paymentTypes.size();i++){
			PrpDcodeDto codeDto = (PrpDcodeDto) paymentTypes.get(i);
			String key = codeDto.getCodeCode();
			String value= codeDto.getCodeCName();
			paymentTypeMap.put(key, value);
		}
		paymentTypeMap.put("P6", "���");
		return paymentTypeMap;
	}
	
	/**
	 * ��дDAARegistViewHelper�еĻ�ȡռ��ʱ��
	 * @param prpLpayExtDtoList
	 * @param originTime
	 * @throws Exception
	 */
	public void getCostTime(List<PrpLpayExtDto> prpLpayExtDtoList,
			String originTime) throws Exception {
		for(int i=0; i<prpLpayExtDtoList.size(); i++){
			PrpLpayExtDto dto = prpLpayExtDtoList.get(i);
			String costTime = "";
			String curDtoInputTime = "";
			if(!"".equals(dto.getInputDate())){
				curDtoInputTime = dto.getInputDate().toString(DateTime.YEAR_TO_SECOND);
			} else {
				curDtoInputTime = new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND).toString(DateTime.YEAR_TO_SECOND);
			}
			if(i==0){
				if(!"".equals(originTime)){
					costTime = DateCompute.betweenDate(originTime, curDtoInputTime);	
				    int index = costTime.indexOf("��");
					if (index != -1){
						costTime = costTime.substring(0, index);
					}
					dto.setCostTime(costTime);
				}
			} else {
				PrpLpayExtDto priorDto = prpLpayExtDtoList.get(i-1);
				String priorFlowOutTime =  priorDto.getInputDate().toString(DateTime.YEAR_TO_SECOND);
				costTime = DateCompute.betweenDate(priorFlowOutTime, curDtoInputTime);	
			    int index = costTime.indexOf("��");
				if (index != -1){
					costTime = costTime.substring(0, index);
				}
				dto.setCostTime(costTime);
			}
		}
	}
	
	public Collection getShowPrplfiscalpaydetail (String[] registNoReqs,String[] compensateNos,String fiscalno ) throws Exception {
		Collection prpLclaimBillManagerDtoList= new ArrayList();
		DBManager dbManager = new DBManager();
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			//String [] registNoReqs = httpServletRequest.getParameterValues("registNo");
			//String [] compensateNos = httpServletRequest.getParameterValues("compensateNo");
			String condition = " 1=1 ";
			String registNoLists = "";
			String compensateNoLists = "";
			if(null!=registNoReqs && !"".equals(registNoReqs) && registNoReqs.length>0){
				for(int i=0;i<registNoReqs.length;i++){
					if(null!=registNoLists && !"".equals(registNoLists)){
						registNoLists += ",'"+registNoReqs[i]+"'";
					}else{
						registNoLists += "'"+registNoReqs[i]+"'";
					}
					if(null!=compensateNos && !"".equals(compensateNos) && compensateNos.length>0){
						if(null!=compensateNoLists && !"".equals(compensateNoLists)){
							compensateNoLists += ",'"+compensateNos[i]+"'";
						}else{
							compensateNoLists += "'"+compensateNos[i]+"'";
						}
					}
					
				}
			}
			
			if(null!=registNoLists && !"".equals(registNoLists)){
				condition += " and registno in ("+registNoLists+")  ";
			}
			if(null!=compensateNoLists && !"".equals(compensateNoLists)){
				condition += " and compensateno  in ("+compensateNoLists+") ";
			}
			//String fiscalno = httpServletRequest.getParameter("fiscalNo");
			condition += " and insuredcode not in (select insuredcode from prplfiscalpaydetail dd where dd.compensateno = prplclaimbillmanager.compensateno ";
			if(null!=fiscalno && !"".equals(fiscalno)){
				condition += " and dd.fiscalno not in ('"+fiscalno+"')";
			}
			condition += ")";
			condition += " and Length(Insuredcode) = 15 ";
			BLPrpLclaimBillManagerAction blPrpLclaimBillManagerAction = new BLPrpLclaimBillManagerAction();
			
			prpLclaimBillManagerDtoList= blPrpLclaimBillManagerAction.findByPaynameIndetSum(dbManager, condition,fiscalno);
		}catch(Exception e){
			e.printStackTrace();
			
			throw e;
		}finally{
			dbManager.close();
		}
		return prpLclaimBillManagerDtoList;
	
	}
	
	/*
	 * ������˺���ͨ�����ʵ��ʵ�������� �۳����
	 */
	public void payrefrecRemovePlanfee(DBManager dbManager,String fiscalNo)throws Exception {
		BLPrplfiscalpaydetailAction blPrplfiscalpaydetailAction = new BLPrplfiscalpaydetailAction();
		BLPrplfiscalpaymainAction blPrplfiscalpaymainAction = new BLPrplfiscalpaymainAction();
		PrplfiscalpaymainDto prplfiscalpaymainDto = new PrplfiscalpaymainDto();
		try{
			prplfiscalpaymainDto = blPrplfiscalpaymainAction.findByPrimaryKey(dbManager, fiscalNo);
			Collection<PrplfiscalpaydetailDto> fiscalpaydetaillist = blPrplfiscalpaydetailAction.findByConditions(dbManager," fiscalno = '"+fiscalNo+"'");
			if(null!=fiscalpaydetaillist && !fiscalpaydetaillist.isEmpty()){
				String compensateno = fiscalpaydetaillist.iterator().next().getCompensateno();
				String paymenttype = fiscalpaydetaillist.iterator().next().getPaymenttype();
				double payamount = prplfiscalpaymainDto.getSumamount();
				String condition = " update prpjplanfee set payreffee =payreffee-"+payamount+" where certitype in ('C','Y') and certino ='"+compensateno+"' and payrefreason = '"+paymenttype+"'";
				String updatePayref = " update prpjpayrefrec set planfee = "+payamount+" where  certitype in ('C','Y') and certino ='"+compensateno+"' and payrefreason = '"+paymenttype+"'";
				dbManager.executeUpdate(condition);
				dbManager.executeUpdate(updatePayref);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/****************��������֧������ end*******************/
}
