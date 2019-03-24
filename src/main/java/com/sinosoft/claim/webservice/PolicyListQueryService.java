package com.sinosoft.claim.webservice;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gyic.claim.bl.facade.BLHerdpolicylistFacade;
import com.gyic.claim.bl.facade.BLHousepolicylistFacade;
import com.gyic.claim.bl.facade.BLPlantingpolicylistFacade;
import com.gyic.claim.bl.facade.BLZh03PolicyListFacade;
import com.gyic.claim.dto.custom.EarLabelRegistDto;
import com.gyic.claim.dto.custom.IdcardRegistDto;
import com.sinosoft.claim.bl.facade.BLClaimFacade;
import com.sinosoft.claim.dto.custom.PolicyListInfoDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIPowerInterface;
import com.sinosoft.claim.util.CallCenterInterfaceLogger;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.nyx.blsvr.BLAreas;
import com.sinosoft.platform.bl.facade.BLUtiGradeTaskFacade;
import com.sinosoft.platform.dto.domain.UtiGradeTaskDto;
import com.sinosoft.prpall.blsvr.cb.BLPrpCaddress;
import com.sinosoft.prpall.blsvr.cb.BLPrpCitemKind;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmainCargo;
import com.sinosoft.prpall.schema.PrpCaddressSchema;
import com.sinosoft.prpall.schema.PrpCitemKindSchema;
import com.sinosoft.prpall.schema.PrpCmainCargoSchema;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.utility.SysConfig;
import com.sinosoft.utility.string.Date;

public class PolicyListQueryService {
	CallCenterInterfaceLogger logger = new CallCenterInterfaceLogger();
	/**
	 * �ǳ��ձ����б��ѯ
	 * @param policyListRequestInfo
	 * @return
	 */
	public PolicyListResponseInfo getPolicyListInfo(PolicyListRequestInfo policyListRequestInfo){
		long serial = System.currentTimeMillis();
		logger.log("�ǳ��ձ����б��ѯ", 1,serial, policyListRequestInfo);
		PolicyListResponseInfo policyListResponseInfo = new PolicyListResponseInfo();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int prpLpageNo =policyListRequestInfo.getPageNo();
		int prpLrecordPerPage = policyListRequestInfo.getRecordPerPage();
		if(prpLpageNo <= 0){
			prpLpageNo = 1;
		}
		if(prpLrecordPerPage<=0){
			prpLrecordPerPage = 20;
		}
		String pageNo = String.valueOf(prpLpageNo);
		String recordPerPage = String.valueOf(prpLrecordPerPage);
		
		// ��������
		String strPolicyNo = policyListRequestInfo.getPolicyNo();
		//�����Ų�ѯ������־
		String strPolicyNoFlag = policyListRequestInfo.getPolicyNoFlag();
		//��ϵͳ������
		String strOldPolicyNo = policyListRequestInfo.getOldPolicyNo();
		// ��������
		String strInsuredName = policyListRequestInfo.getInsuredName();
		// ������
		String strStartDate = policyListRequestInfo.getStartDate();
		// �ձ�����
		String strEndDate = policyListRequestInfo.getEndDate();
		// ����
		String strRiskType = policyListRequestInfo.getRiskType();
		// ���֤�Ų�ѯ����
		String strIdentifyNumber = policyListRequestInfo.getIdentifyNumber();
		//���֤�Ų�ѯ������־
		String strIdentifyNumberFlag = policyListRequestInfo.getIdentifyNumberFlag();
		//������ˮ��
		String strPolicyNoPrintNo = policyListRequestInfo.getPolicyNoPrintNo();
		String strEarLabel = policyListRequestInfo.getEarLabel();
		String strEarLabelFlag = policyListRequestInfo.getEarLabelFlag();
		
		String strFCardID = policyListRequestInfo.getFCardID();
		String strFCardIDFlag = policyListRequestInfo.getFCardIDFlag();
		String strFname1 = policyListRequestInfo.getFname1();
		String strFamilyNo = policyListRequestInfo.getFamilyNo();
		String strFamilyNoFlag = policyListRequestInfo.getFamilyNoFlag();
		String strFamilyFIDCard = policyListRequestInfo.getFamilyFIDCard();
		String strFamilyFIDCardFlag = policyListRequestInfo.getFamilyFIDCardFlag();
		String strFname = policyListRequestInfo.getFname();
		
		//��ԡ����������˺��ա��ĸ��Ի���������ר�õġ��������͡����֤�š��Ĳ�ѯ����
		String strInsuredName_2743=policyListRequestInfo.getInsuredName_2743();
		String strIdentifyNumber_2743=policyListRequestInfo.getIdentifyNumber_2743();
		String strIdentifyNumber_2743Flag = policyListRequestInfo.getIdentifyNumber_2743Flag();
		String cinsuredConditons="";
		String cvirturlitemConditons="";
		
		//��ԡ�0310ũ�����ĸ��Ի���������ר�õġ��������͡����֤�š��Ĳ�ѯ���� add by xiatian 
		String strAreasCode=policyListRequestInfo.getAreasCode();
		String strIdentifyNumber_0310=policyListRequestInfo.getIdentifyNumberSign_0310();
		String strIdentifyNumber_0310Flag=policyListRequestInfo.getIdentifyNumberSign_0310Flag();
		
		//��ԡ��������������˺����ա��ĸ��Ի���������ר�õġ����֤�š��Ĳ�ѯ����
		String strIdentifyNumber_2714 = policyListRequestInfo.getIdentifyNumber_2714();
		//��������㼶ͬ����������
		String strAreaFlag = policyListRequestInfo.getAreaFlag();
		String strAreaLevel = policyListRequestInfo.getAreaLevel();
		String agriSql = "";
		if(strAreaLevel!=null && "1".equals(strAreaLevel)){
			agriSql = agriSql+" businessprovince = '"+strAreasCode+"'";
		}else if(strAreaLevel!=null && "2".equals(strAreaLevel)){
			agriSql = agriSql+" businesstown = '"+strAreasCode+"'";//��ũ�ձ������ֶδ����2����������
		}else if(strAreaLevel!=null && "3".equals(strAreaLevel)){
			agriSql = agriSql+" businesscounty = '"+strAreasCode+"'";
		}else if(strAreaLevel!=null && "4".equals(strAreaLevel)){
			agriSql = agriSql+" businesscity = '"+strAreasCode+"'";//��ũ�ձ������ֶδ����4����������
		}else if(strAreaLevel!=null && "5".equals(strAreaLevel)){
			agriSql = agriSql+" businessarea = '"+strAreasCode+"'";
		}
		
		// ��ѯ������
		String conditions = " 1=1 ";
		String conditions1 = " 1=1 ";
		String conditions2 = " 1=1 ";
		String conditions3 = " 1=1 ";
		String conditions4 = " 1=1 ";
		String conditions5 = " 1=1 ";
		try{
			conditions = conditions
					+ StringConvert.convertString("a.PolicyNo", strPolicyNo,
							strPolicyNoFlag);
			// ��ϵͳ�ı����Ŵ�����ϵͳ��PrpCmain���Remark�ֶ���
			conditions = conditions
					+ StringConvert.convertString("a.Remark", strOldPolicyNo,
							"*");

			conditions = conditions
					+ StringConvert.convertString("a.InsuredName",
							strInsuredName, "*");

			conditions = conditions
					+ StringConvert.convertDate("a.StartDate", strStartDate,
							">=");
			
			conditions5 = conditions5
			        + StringConvert.convertString("a.PolicyNo", strPolicyNo,
					strPolicyNoFlag);
			conditions5 = conditions5
			        + StringConvert.convertString("a.Remark", strOldPolicyNo,
					"*");
			conditions5 = conditions5
			        + StringConvert.convertString("a.InsuredName",
					strInsuredName, "*");

			conditions5 = conditions5
			        + StringConvert.convertDate("a.StartDate", strStartDate,
					">=");
			conditions1 = conditions1
			+ StringConvert.convertDate("e.Starttime", strStartDate,
					">=");
			
			conditions2 = conditions2
			+ StringConvert.convertDate("e.Starttime", strStartDate,
					">=");
			conditions3 = conditions3
			+ StringConvert.convertDate("e.Starttime", strStartDate,
					">=");
			conditions = conditions
					+ StringConvert.convertDate("a.EndDate", strEndDate, "<=");
			conditions5 = conditions5
			        + StringConvert.convertDate("a.EndDate", strEndDate, "<=");
			conditions1 = conditions1
			+ StringConvert.convertDate("e.Endtime", strEndDate,
					"<=");
			
			conditions2 = conditions2
			+ StringConvert.convertDate("e.Endtime", strEndDate,
					"<=");
			conditions3 = conditions3
			+ StringConvert.convertDate("e.Endtime", strEndDate,
					"<=");

			conditions = conditions
					+ StringConvert.convertString("a.PrintNo",
							strPolicyNoPrintNo, "=");
			conditions5 = conditions5
			        + StringConvert.convertString("a.PrintNo",
					strPolicyNoPrintNo, "=");
			conditions4 = conditions4
			+ StringConvert.convertDate("e.Starttime", strStartDate,
					">=");
			conditions4 = conditions4
			+ StringConvert.convertDate("e.Endtime", strEndDate,
					"<=");

			if (strRiskType != null && !"".equals(strRiskType)) {
				conditions = conditions + " and a.riskcode=c.OuterCode ";
				conditions = conditions
						+ StringConvert.convertString("c.RiskType",
								strRiskType, "=");
				conditions5 = conditions5 + " and a.riskcode=c.OuterCode ";
				conditions5 = conditions5
						+ StringConvert.convertString("c.RiskType",
								strRiskType, "=");
			} else {
				conditions = conditions + " and a.riskcode=c.OuterCode ";
				conditions5 = conditions5 + " and a.riskcode=c.OuterCode ";
			}
			
			// ������ݺŲ�ѯ����
			if (strIdentifyNumber != null && !strIdentifyNumber.equals("")) {
				conditions = conditions
						+ " AND a.PolicyNo in (Select distinct PolicyNo From Prpcinsured Where 1=1 "
						+ StringConvert.convertString("IdentifyNumber",
								strIdentifyNumber, strIdentifyNumberFlag)
						+ StringConvert.convertString("a.PolicyNo", strPolicyNo,
								strPolicyNoFlag) + ")";
			}
			if((strEarLabel != null && !"".equals(strEarLabel.trim()))||(strFname != null && !"".equals(strFname.trim()))){
				conditions1 = conditions1 + StringConvert.convertString1("d.Earlabel", strEarLabel, strEarLabelFlag);//Ĭ��ģ����ѯ
				conditions1 = conditions1 + StringConvert.convertString("d.Fname", strFname,"*");
				conditions4 = conditions4 + StringConvert.convertString1("d.Earlabel", strEarLabel, strEarLabelFlag);//Ĭ��ģ����ѯ
				conditions4 = conditions4 + StringConvert.convertString("d.Fname", strFname,"*");
				if((strAreasCode != null && !"".equals(strAreasCode.trim())))
				{
					conditions1 = conditions1 + " and e.fareacode like '%'||(select centercode from region where gbbh='"+strAreasCode+"')||'%' ";//��ũ��
					conditions4 = conditions4 + " and e.INUSRELISTCODE in(SELECT i.relationlistno from prpcmainagri i WHERE "+agriSql+")";//��ũ��
				}
			}

			else if((strFname1 != null && !"".equals(strFname1.trim()))||(strFCardID != null && !"".equals(strFCardID.trim()))){
				conditions = conditions + StringConvert.convertString("d.FIDCARD", strFCardID,strFCardIDFlag);//������������ֲ��ר��
				conditions = conditions + StringConvert.convertString("d.Fname", strFname1,"*");//������������ֲ��ר��
				conditions5 = conditions5 + StringConvert.convertString("d.FIDCARD", strFCardID,strFCardIDFlag);//������������ֲ��ר��
				conditions5 = conditions5 + StringConvert.convertString("d.Fname", strFname1,"*");//������������ֲ��ר��
				if((strAreasCode != null && !"".equals(strAreasCode.trim()))){
					conditions = conditions + " and e.fareacode like '%'||(select centercode from region where gbbh='"+strAreasCode+"')||'%' ";//��ũ��
					conditions5 = conditions5 + " and e.INUSRELISTCODE in(SELECT i.relationlistno from prpcmainagri i WHERE "+agriSql+")";//��ũ��
					
				}
			}

			else if((strFamilyNo != null && !"".equals(strFamilyNo.trim()))||(strFamilyFIDCard != null && !"".equals(strFamilyFIDCard.trim()))){
				conditions3 = conditions3 + StringConvert.convertString("d.FamilyNo", strFamilyNo, strFamilyNoFlag);//ũ�Ҹ���ϱ���ר��
				conditions3 = conditions3 + StringConvert.convertString("d.FamilyFIDCard", strFamilyFIDCard, strFamilyFIDCardFlag);//ũ�Ҹ���ϱ���ר��
			}
			//���2743���ֵĸ��Ի�����
			else if((strInsuredName_2743 != null && !"".equals(strInsuredName_2743.trim())) || (strIdentifyNumber_2743 != null && !"".equals(strIdentifyNumber_2743.trim()))){
				cinsuredConditons=" and a.policyno in (select distinct policyno from prpcinsured where 1=1 and insuredflag='1'";
				cvirturlitemConditons=" union all select distinct policyno from prpcvirturlitem where 1=1";
				//ƴ�ӡ��������ˡ��Ĳ�ѯ����
				if(strInsuredName_2743 != null && !"".equals(strInsuredName_2743.trim())){
					cinsuredConditons=cinsuredConditons+StringConvert.convertString("insuredname", strInsuredName_2743, "*");
					cvirturlitemConditons=cvirturlitemConditons+StringConvert.convertString("familyname", strInsuredName_2743, "*");
				}
				//ƴ�ӡ����֤�š��Ĳ�ѯ����
				if(strIdentifyNumber_2743 != null && !"".equals(strIdentifyNumber_2743.trim())){
					cinsuredConditons=cinsuredConditons+StringConvert.convertString("identifynumber", strIdentifyNumber_2743, strIdentifyNumber_2743Flag);
					cvirturlitemConditons=cvirturlitemConditons+StringConvert.convertString("identifynumber", strIdentifyNumber_2743, strIdentifyNumber_2743Flag);
				}
				cinsuredConditons=cinsuredConditons+StringConvert.convertString("a.PolicyNo", strPolicyNo, strPolicyNoFlag);
				cvirturlitemConditons=cvirturlitemConditons+StringConvert.convertString("a.PolicyNo", strPolicyNo, strPolicyNoFlag)+")";
				
				conditions=conditions+cinsuredConditons+cvirturlitemConditons;
			}
			//���0310���ֵĸ��Ի�����
			else if((strAreasCode != null && !"".equals(strAreasCode.trim()))||(strIdentifyNumber_0310 != null && !"".equals(strIdentifyNumber_0310.trim()))){
				conditions2 = conditions2 + StringConvert.convertString("d.idcard", strIdentifyNumber_0310,strIdentifyNumber_0310Flag);//ũ����ר��
				conditions2 = conditions2 + StringConvert.convertString("e.fareacode", strAreasCode,"*");//ũ����ר��
				
			}
			//���2714���ֵĸ��Ի�����
			else if (strIdentifyNumber_2714 != null && !"".equals(strIdentifyNumber_2714.trim())){
			   conditions = conditions+"and a.policyno in (select distinct policyno from prpcvirturlitem where 1=1 and identifynumber='"+strIdentifyNumber_2714+"')";
			}
			
			//��ȡ�û���Ϣ
			UserDto userDto = new UserDto();
			userDto.setUserCode(policyListRequestInfo.getUserCode());
			userDto.setComCode(policyListRequestInfo.getComCode());
			//���ø�λȨ���б�
			BLUtiGradeTaskFacade blUtiGradeTaskFacade = new BLUtiGradeTaskFacade();
			UtiGradeTaskDto utiGradeTaskDto = null;
			Map gradeCodeMap = new HashMap();
			String gradecodes = "";
			String condition = " taskcode like 'claim%' and gradecode in " +//ֻ��ѯ����ϵͳ��Ȩ�޴���
					           "(select gradecode from utiusergradepower " +
					           "where usercode='" + policyListRequestInfo.getUserCode() + "') and gradecode<>'122'";
			ArrayList gradeList = (ArrayList)blUtiGradeTaskFacade.findByConditions(condition);
			for(int i = 0; i < gradeList.size(); i ++){
				utiGradeTaskDto = (UtiGradeTaskDto)gradeList.get(i);
				if(!gradeCodeMap.containsKey(utiGradeTaskDto.getGradeCode())){
					gradeCodeMap.put(utiGradeTaskDto.getGradeCode(), utiGradeTaskDto.getGradeCode());
					gradecodes += "," + utiGradeTaskDto.getGradeCode();
				}
			}
			if(gradecodes.length() > 1){
				gradecodes = gradecodes.substring(1,gradecodes.length());
			}					
			userDto.setLoginGradeCodes(gradecodes);
			
			//reason�����Ȩ��
			UIPowerInterface uiPowerInterface = new UIPowerInterface();
			//modify by zhaolu 20060830 start
			conditions = conditions + uiPowerInterface.addRiskPower(userDto,"a") + uiPowerInterface.addCustomerPower(userDto,"a","","ComCode");
			conditions5 = conditions5 + uiPowerInterface.addRiskPower(userDto,"a") + uiPowerInterface.addCustomerPower(userDto,"a","","ComCode");
			 String contitionTemp = uiPowerInterface.addCustomerPower(userDto,"a","","ComCode");
			 contitionTemp = contitionTemp.replaceAll("a.ComCode","(substr(e.policyno,6,6)||'0000')");
			 conditions1 = conditions1 + uiPowerInterface.addRiskPower(userDto,"e") + contitionTemp;
			 conditions2 = conditions2 + uiPowerInterface.addRiskPower(userDto,"e") + contitionTemp;
			 conditions3 = conditions3 + uiPowerInterface.addRiskPower(userDto,"e") + contitionTemp;
			 conditions4 = conditions4 + uiPowerInterface.addRiskPower(userDto,"e") + contitionTemp;
			//��ũ�����ܹ�˾���б���������֧��˾ֻ������ũ�ձ���
			if(userDto.getComCode().indexOf("0000") != 0){
//				conditions += " and a.Classcode in ('31','32','ZH','27','26','28') and a.riskCode!='3220' ";
//				conditions1 += " and e.Classcode in ('31','32','ZH','27','26','28') and e.riskCode!='3220' ";
//				conditions2 += " and e.Classcode in ('31','32','ZH','27','26','28') and e.riskCode!='3220' ";
//				conditions3 += " and e.Classcode in ('31','32','ZH','27','26','28') and e.riskCode!='3220' ";
				conditions += this.getPower("a");
				conditions1 += this.getPower("e");
				conditions2 += this.getPower("e");
				conditions3 += this.getPower("e");
				conditions4 += this.getPower("e");
				conditions5 += this.getPower("a");
			}
			 
			//��ϵͳ���ߺ󣬴����ֲ�������ϵͳ�б���
			String taskCode = SysConfig.getProperty("CLAIM_NOTALLOW_RISKKIND","claim");
			if(null != taskCode && !"".equals(taskCode)){
				conditions += " and a.riskCode not in ("+taskCode+") ";
				conditions5 += " and a.riskCode not in ("+taskCode+") ";
			}
			conditions += " and a.classcode <> '05' ";
			conditions5 += " and a.classcode <> '05' ";
			
	        // �õ����б���������Ϣ
			//������ϵͳ�������ձ���
			UIPolicyAction uiPolicyAction = new UIPolicyAction();
			PageRecord pageRecord = null;
			PageRecord pageRecord1 = null;
			PageRecord pageRecord2 = null;
			if((strEarLabel != null && !"".equals(strEarLabel.trim()))||(strFname != null && !"".equals(strFname.trim()))){
				pageRecord = (PageRecord) new BLHerdpolicylistFacade().findEarByConditions1(conditions1, Integer.parseInt(DataUtils
						.nullToZero(pageNo)), Integer.parseInt(DataUtils
						.nullToZero(recordPerPage)));
				//������ũ�ն���ź�ũ��������ѯ
					pageRecord1 = (PageRecord) new BLHerdpolicylistFacade().findNewAgriEarByConditions(conditions4, Integer.parseInt(DataUtils
							.nullToZero(pageNo)), Integer.parseInt(DataUtils
							.nullToZero(recordPerPage)));
			}
			//0310ר��
			else if(strIdentifyNumber_0310 != null && !"".equals(strIdentifyNumber_0310.trim())){
				pageRecord = (PageRecord) new BLHousepolicylistFacade().findIdcardByConditions1(conditions2, Integer.parseInt(DataUtils
						.nullToZero(pageNo)), Integer.parseInt(DataUtils
						.nullToZero(recordPerPage)));
			}
			else if((strAreasCode != null && !"".equals(strAreasCode.trim())) && (strAreaFlag !=null && "0".equals(strAreaFlag)))
			{//�Ϲ�������
				//System.err.println("conditions21:"+ conditions2);
				pageRecord = (PageRecord) new BLHousepolicylistFacade().findAreacodeByConditions1(conditions2, Integer.parseInt(DataUtils
						.nullToZero(pageNo)), Integer.parseInt(DataUtils
						.nullToZero(recordPerPage)));
			}
			//end
			else if((strFCardID != null && !"".equals(strFCardID.trim()))||(strFname1 != null && !"".equals(strFname1.trim()))){
				pageRecord = (PageRecord) new BLPlantingpolicylistFacade().findPlantingByConditions(conditions, Integer.parseInt(DataUtils
						.nullToZero(pageNo)), Integer.parseInt(DataUtils
						.nullToZero(recordPerPage)));
					pageRecord2 = (PageRecord) new BLPlantingpolicylistFacade().findNewPlantingByConditions(conditions5, Integer.parseInt(DataUtils
							.nullToZero(pageNo)), Integer.parseInt(DataUtils
									.nullToZero(recordPerPage)));
			}
			else if((strFamilyNo != null && !"".equals(strFamilyNo.trim()))||(strFamilyFIDCard != null && !"".equals(strFamilyFIDCard.trim()))){
				pageRecord = (PageRecord) new BLZh03PolicyListFacade().findFamilyNoByConditions(conditions3, Integer.parseInt(DataUtils
						.nullToZero(pageNo)), Integer.parseInt(DataUtils
						.nullToZero(recordPerPage)));
			}
			else
			{
				pageRecord = (PageRecord) uiPolicyAction.findForRegistConditions(conditions, pageNo, recordPerPage);
			}
			
			List registList = (ArrayList) pageRecord.getResult();
			//��ũ�ն���Ų�ѯ���Ľ����
			int pageNumber = 0;
			int rowsPrePage = 0;
			int pageCount = 0;
			int totalPageCount = 0;
			if(pageRecord1!=null){//�ǿ�У��
				List registList1 = (ArrayList) pageRecord1.getResult();
				registList.addAll(registList1);
				pageNumber = pageRecord1.getPageNo();
				rowsPrePage = pageRecord1.getRowsPerPage();
				pageCount = pageRecord1.getCount();
				totalPageCount = pageRecord1.getTotalPageCount();
			}
			if(pageRecord2!=null){//�ǿ�У��
				List registList2 = (ArrayList) pageRecord2.getResult();
				registList.addAll(registList2);
				pageNumber = pageRecord2.getPageNo();
				rowsPrePage = pageRecord2.getRowsPerPage();
				pageCount = pageRecord2.getCount();
				totalPageCount = pageRecord2.getTotalPageCount();
			}
			DecimalFormat decimalFormat = new DecimalFormat("0.00#");
			UICodeAction uiCodeAction = new UICodeAction();
			if (registList != null && registList.size() > 0){
				PolicyListInfoDto[] policyListInfoDtoList = new PolicyListInfoDto[registList.size()];
				for (int i = 0; i < registList.size(); i++){
					PolicyListInfoDto policyListInfoDto = new PolicyListInfoDto();
					PrpCmainDto prpCmainDto = null;
					if((strEarLabel != null && !"".equals(strEarLabel.trim()))||(strFname != null && !"".equals(strFname.trim()))){
						prpCmainDto = ((EarLabelRegistDto) (((ArrayList) registList).get(i))).getPrpCmainDto();
						BLClaimFacade bLClaimFacade = new BLClaimFacade();
						if(prpCmainDto != null)
						{
							String areacode = prpCmainDto.getComCode();
							//System.err.println("areacode:" + areacode);
							BLAreas bLAreas = new BLAreas();
							String temparea = "";
							ArrayList<String> areas = (ArrayList<String>)bLAreas.getSupperArea(areacode);
							//System.err.println("size:" + areas.size());
							if(areas != null && areas.size() >0)
							{
								for(int k = areas.size()-1;k>=0;k--)
								{
									temparea = temparea + areas.get(k) + " ";
									
								}
							}
							//System.err.println("temparea:"+ temparea);
							prpCmainDto.setInsuredAddress(temparea);
							PrpCmainDto tempcmain = bLClaimFacade.findByPolicyNoKey(prpCmainDto.getPolicyNo());
							if(tempcmain != null)
							{
								prpCmainDto.setOthFlag(tempcmain.getOthFlag());
								prpCmainDto.setUnderWriteFlag(tempcmain.getUnderWriteFlag());
								prpCmainDto.setStartDate(tempcmain.getStartDate());
								prpCmainDto.setEndDate(tempcmain.getEndDate());
								prpCmainDto.setStartHour(tempcmain.getStartHour());
								prpCmainDto.setEndHour(tempcmain.getEndHour());
								prpCmainDto.setComCode(tempcmain.getComCode());
								prpCmainDto.setInsuredName(tempcmain.getInsuredName());
								prpCmainDto.setHandler1Code(tempcmain.getHandler1Code());
							}
						}
					
					}
					else if((strFamilyNo != null && !"".equals(strFamilyNo.trim()))||(strFamilyFIDCard != null && !"".equals(strFamilyFIDCard.trim()))){
						prpCmainDto = (PrpCmainDto) (((ArrayList) registList)
								.get(i));
						BLClaimFacade bLClaimFacade = new BLClaimFacade();
						if(prpCmainDto != null)
						{
							PrpCmainDto tempcmain = bLClaimFacade.findByPolicyNoKey(prpCmainDto.getPolicyNo());
							if(tempcmain != null)
							{
								prpCmainDto.setOthFlag(tempcmain.getOthFlag());
								prpCmainDto.setUnderWriteFlag(tempcmain.getUnderWriteFlag());
								prpCmainDto.setStartDate(tempcmain.getStartDate());
								prpCmainDto.setEndDate(tempcmain.getEndDate());
								prpCmainDto.setInsuredName(tempcmain.getInsuredName()+"��"+tempcmain.getSumQuantity()+"��");
								
								prpCmainDto.setStartHour(tempcmain.getStartHour());
								prpCmainDto.setEndHour(tempcmain.getEndHour());
								prpCmainDto.setComCode(tempcmain.getComCode());
								prpCmainDto.setHandler1Code(tempcmain.getHandler1Code());
							
							}
						}
						
					}
					else if((strIdentifyNumber_0310 != null && !"".equals(strIdentifyNumber_0310.trim()))||((strAreasCode != null && !"".equals(strAreasCode.trim())&&(strAreaFlag !=null && "0".equals(strAreaFlag))))){
						prpCmainDto = ((IdcardRegistDto) (((ArrayList) registList)
								.get(i))).getPrpCmainDto();
						BLClaimFacade bLClaimFacade = new BLClaimFacade();
						if(prpCmainDto != null)
						{
							
							String areacode = prpCmainDto.getComCode();
							//System.err.println("areacode:" + areacode);
							BLAreas bLAreas = new BLAreas();
							String temparea = "";
							ArrayList<String> areas = (ArrayList<String>)bLAreas.getSupperArea(areacode);
							//System.err.println("size:" + areas.size());
							if(areas != null && areas.size() >0)
							{
								for(int k = areas.size()-1;k>=0;k--)
								{
									temparea = temparea + areas.get(k) + " ";
									
								}
							}
							//System.err.println("temparea:"+ temparea);
							prpCmainDto.setInsuredAddress(temparea);
							PrpCmainDto tempcmain = bLClaimFacade.findByPolicyNoKey(prpCmainDto.getPolicyNo());
							if(tempcmain != null)
							{
								prpCmainDto.setOthFlag(tempcmain.getOthFlag());
								prpCmainDto.setUnderWriteFlag(tempcmain.getUnderWriteFlag());
								prpCmainDto.setStartDate(tempcmain.getStartDate());
								prpCmainDto.setEndDate(tempcmain.getEndDate());
								prpCmainDto.setStartHour(tempcmain.getStartHour());
								prpCmainDto.setEndHour(tempcmain.getEndHour());
								prpCmainDto.setComCode(tempcmain.getComCode());
								prpCmainDto.setInsuredName(tempcmain.getInsuredName());
								prpCmainDto.setHandler1Code(tempcmain.getHandler1Code());
							}
						}
						
						System.err.println("test:"+prpCmainDto.getPolicyNo());
					}
					else
					{
						prpCmainDto = (PrpCmainDto) (((ArrayList) registList).get(i));
					}
					
					//��������
					String strTemp =uiCodeAction.translateRiskCode(prpCmainDto.getRiskCode() ,true);
					//���ݹ��ӱ�Ҫ�󣬲����н�ȡ
					/*if (strTemp!=null&&strTemp.length() >4){
						strTemp=strTemp.substring( 0,4);
					}*/
					
					policyListInfoDto.setPolicyNo(prpCmainDto.getPolicyNo());
					policyListInfoDto.setInsuredName(prpCmainDto.getInsuredName());
					String strStartHour = ""+prpCmainDto.getStartHour();
					String strEndHour = ""+prpCmainDto.getEndHour();
					//��ʽת�������Сʱ��1λ��ǰ�����0
					if(strStartHour!=null&&strStartHour.length()==1){
						strStartHour = "0"+strStartHour;
					}
					if(strEndHour!=null&&strEndHour.length()==1){
						strEndHour = "0"+strEndHour;
					}
					policyListInfoDto.setStartDate(sdf.format(prpCmainDto.getStartDate())+" "+strStartHour);
					policyListInfoDto.setEndDate(sdf.format(prpCmainDto.getEndDate())+" "+strEndHour);
					policyListInfoDto.setRiskCode(prpCmainDto.getRiskCode());
					policyListInfoDto.setRiskName(strTemp);
					policyListInfoDto.setComCode(prpCmainDto.getComCode());
					policyListInfoDto.setComName(uiCodeAction.translateComCode(prpCmainDto.getComCode(), true));
					policyListInfoDto.setHandler1code(prpCmainDto.getHandler1Code());
					policyListInfoDto.setHandler1Name(uiCodeAction.translateUserCode(prpCmainDto.getHandler1Code(), true));
					BLPrpCaddress blPrpCaddress = new BLPrpCaddress();
					blPrpCaddress.getData(prpCmainDto.getPolicyNo());
					if(blPrpCaddress.getSize()>0){
						PrpCaddressSchema prpCaddressSchema = blPrpCaddress.getArr(0);
						policyListInfoDto.setAddressName(prpCaddressSchema.getAddressName());
					}
					BLPrpCmainCargo blPrpCmainCargo = new BLPrpCmainCargo();
					blPrpCmainCargo.getData(prpCmainDto.getPolicyNo());
					if(blPrpCmainCargo.getSize()>0){
						PrpCmainCargoSchema prpCmainCargoSchema = blPrpCmainCargo.getArr(0);
						policyListInfoDto.setStartSiteDate(prpCmainDto.getStartDate().toString());
						policyListInfoDto.setStartSiteName(prpCmainCargoSchema.getStartSiteName());
						policyListInfoDto.setEndSiteName(prpCmainCargoSchema.getEndSiteName());
						policyListInfoDto.setConveyanceCode(prpCmainCargoSchema.getConveyance());
						policyListInfoDto.setConveyanceName(uiCodeAction.translateCodeCode("TransMode",prpCmainCargoSchema.getConveyance(),true));
						policyListInfoDto.setVoyageNo(prpCmainCargoSchema.getVoyageNo());
					}
					policyListInfoDto.setAmount(decimalFormat.format(prpCmainDto.getSumAmount()));
					PolicyListQueryInfo policyListQueryInfo = new PolicyListQueryInfo();
					policyListInfoDto.setDamageTimes(""+policyListQueryInfo.getSamePolicyRegistInfo(prpCmainDto.getPolicyNo(),""));
					policyListInfoDtoList[i] = policyListInfoDto;
				}
				policyListResponseInfo.setPolicyListInfoDtoList(policyListInfoDtoList);
			}
			
			policyListResponseInfo.setPageNo(pageRecord.getPageNo()+pageNumber);
			policyListResponseInfo.setRecordPerPage(pageRecord.getRowsPerPage()+rowsPrePage);
			policyListResponseInfo.setTotalCount(pageRecord.getCount()+pageCount);
			policyListResponseInfo.setTotalPage(pageRecord.getTotalPageCount()+totalPageCount);
			
		}catch(Exception e){
			e.printStackTrace();
			logger.log("�ǳ��ձ����б��ѯ",serial,e);
		}
		logger.log("�ǳ��ձ����б��ѯ", 0,serial, policyListResponseInfo);
		return policyListResponseInfo;
	}
	/**
	 * �����б��ձ�
	 * @param policyNo
	 * @return
	 */
	 public KindCodeDetailDtoInfo[] queryKindCodeDetail (String policyNo){
		 long serial = System.currentTimeMillis();
		 logger.log("�����б��ձ�", 1,serial, "[policyNo:"+policyNo+"]");
		 KindCodeDetailDtoInfo[] kindCodeDetailDtoInfoList = null;
		 KindCodeDetailDtoInfo kindCodeDetailDtoInfo = null;
		 BLPrpCitemKind blPrpCitemKind = new BLPrpCitemKind();
		 PrpCitemKindSchema prpCitemKindSchema = null;
		 UICodeAction uiCodeAction = new UICodeAction();
		 try {
			blPrpCitemKind.getData(policyNo);
			if(blPrpCitemKind.getSize()>0){
				kindCodeDetailDtoInfoList = new KindCodeDetailDtoInfo[blPrpCitemKind.getSize()];
				for(int i=0;i<blPrpCitemKind.getSize();i++){
					kindCodeDetailDtoInfo = new KindCodeDetailDtoInfo();
					prpCitemKindSchema = blPrpCitemKind.getArr(i);
					kindCodeDetailDtoInfo.setSerialNo(prpCitemKindSchema.getItemKindNo());
					kindCodeDetailDtoInfo.setKindCode(prpCitemKindSchema.getKindCode());
					kindCodeDetailDtoInfo.setKindName(prpCitemKindSchema.getKindName());
					kindCodeDetailDtoInfo.setItemCode(prpCitemKindSchema.getItemCode());
					kindCodeDetailDtoInfo.setItemName(prpCitemKindSchema.getItemDetailName());
					kindCodeDetailDtoInfo.setAmount(prpCitemKindSchema.getAmount());
					kindCodeDetailDtoInfo.setCurrency(prpCitemKindSchema.getCurrency());
					kindCodeDetailDtoInfo.setCurrencyName(uiCodeAction.translateCurrencyCode(prpCitemKindSchema.getCurrency(), true));
					kindCodeDetailDtoInfoList[i] = kindCodeDetailDtoInfo;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("�����б��ձ�",serial,e);
		}
		logger.log("�����б��ձ�", 0,serial, kindCodeDetailDtoInfoList);
		 return kindCodeDetailDtoInfoList;
	 }
	 
	 private String getPower(String tableName) throws Exception {
			String sql = "";
			//1.���ܹ�˾������������������Щ
			String inClassCode = SysConfig.getProperty("registqueryInclass","claim");
			//2.�����������У��в����������⡣����������Щ���֣���ʹ������Ϸ��ܹ�˾����������ȻҪ�ܹ�˾����
			String notInRiskCode = SysConfig.getProperty("registqueryNotInRisk","claim");
			if(inClassCode==null||inClassCode.trim().length()==0){
				sql = "and 1=2";
			}else{
				if(notInRiskCode==null||notInRiskCode.trim().length()==0){
					sql =  " and "+tableName+".Classcode in ("+inClassCode+")   ";
				}else{
					sql =  " and "+tableName+".Classcode in ("+inClassCode+")  and "+tableName+".riskCode not in ("+notInRiskCode+") ";
				}
			}
			return sql;
		}
	 
}
