package com.sinosoft.claim.webservice;

import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.gyic.claim.bl.facade.BLHerdpolicylistFacade;
import com.gyic.claim.bl.facade.BLHousepolicylistFacade;
import com.gyic.claim.bl.facade.BLInsuremainlistFacade;
import com.gyic.claim.bl.facade.BLPrplcompensateearFacade;
import com.gyic.claim.dto.domain.HerdpolicylistDto;
import com.gyic.claim.dto.domain.HousepolicylistDto;
import com.gyic.claim.dto.domain.InsuremainlistDto;
import com.sinosoft.claim.bl.action.domain.BLPrpCinsuredAction;
import com.sinosoft.claim.bl.action.domain.BLPrpDcurrencyAction;
import com.sinosoft.claim.bl.facade.BLPrpCinsuredFacade;
import com.sinosoft.claim.bl.facade.BLPrpCinsuredNatureFacade;
import com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade;
import com.sinosoft.claim.bl.facade.BLPrplcompensatehouseFacade;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.PrpDcodeDtoInfo;
import com.sinosoft.claim.dto.custom.PrpDcurrencyDtoInfo;
import com.sinosoft.claim.dto.domain.PrpCinsuredDto;
import com.sinosoft.claim.dto.domain.PrpCinsuredNatureDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpDcodeDto;
import com.sinosoft.claim.dto.domain.PrpDcurrencyDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.viewHelper.EndorseViewHelper;
import com.sinosoft.claim.util.CallCenterInterfaceLogger;
import com.sinosoft.nyx.blsvr.BLAreas;
import com.sinosoft.prpall.bl.facade.BLPrpCmainFacade;
import com.sinosoft.prpall.dto.domain.PrpCmainDto;
import com.sinosoft.prpall.pubfun.GroupProposalService;
import com.sinosoft.prpall.schema.PrpCvirturlItemSchema;
import com.sinosoft.reins.utility.ui.control.facade.UIPrpDCodeFacade;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class NewMoleSurvey {
	CallCenterInterfaceLogger logger = new CallCenterInterfaceLogger();
	/**
	 * ��ȡ����ԭ����Ϣ
	 * @param riskCode
	 * @return
	 */
	public PrpDcodeDtoInfo[] getDamageCode(String riskCode){
		long serial = System.currentTimeMillis();
		logger.log("��ȡ����ԭ����Ϣ", 1,serial, "riskCode:"+riskCode);
		UICodeAction uicodeAction = new UICodeAction();
		PrpDcodeDtoInfo[] prpDcodeDtoList = null;
		try {
			if (isEmpty(riskCode)) {// ��Ч��У��
				throw new Exception("������Ϣ����Ϊ�գ����顣");
			}
			
			String conditions = "select a.CodeType,a.CodeCode,a.CodeCName,a.CodeEName,a.NewCodeCode,a.ValidStatus,a.Flag " +
		   			  "from prpdcode a, prpdcoderisk b where a.codecode = b.codecode and a.codetype = b.codetype " +
		   			  "and b.codetype = 'DamageCode' and b.riskcode='"+riskCode +"' order by b.flag";
			Collection<PrpDcodeDto> prpDcodeDtos  = uicodeAction.findByConditions(UICodeAction.DAMAGECODE,conditions,0,0);
			if(!isEmpty(prpDcodeDtos)) {
				prpDcodeDtoList = new PrpDcodeDtoInfo[prpDcodeDtos.size()];
				int i = 0;
				for(PrpDcodeDto element:prpDcodeDtos) {
					prpDcodeDtoList[i++] = new PrpDcodeDtoInfo(element.getCodeCode(),element.getCodeCName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��ѯ����");
			logger.log("��ȡ����ԭ����Ϣ",serial,e);
		}
		logger.log("��ȡ����ԭ����Ϣ", 0,serial,prpDcodeDtoList);
		return prpDcodeDtoList;
	}
	
	/**
	 * ��ȡ��ϸ����ԭ����Ϣ
	 * @param riskCode
	 * @return
	 */
	public PrpDcodeDtoInfo[] getDamageDetailCode(String riskCode){
		long serial = System.currentTimeMillis();
		logger.log("��ȡ��ϸ����ԭ����Ϣ", 1,serial, "riskCode:"+riskCode);
		UICodeAction uicodeAction = new UICodeAction();
		PrpDcodeDtoInfo[] prpDcodeDtoList = null;
		try {
			if (isEmpty(riskCode)) {// ��Ч��У��
				throw new Exception("������Ϣ����Ϊ�գ����顣");
			}
			
			String conditions = "select * from prpdcode where codecode in (select ss.codecode from prpdcoderisk ss "+
		                        "where ss.riskcode = '"+riskCode+"' and ss.codetype = 'DamageCode' ) "+
					            "and codetype = 'DamageCode' and validstatus = '1'";
			Collection<PrpDcodeDto> prpDcodeDtos  = uicodeAction.findByConditions(UICodeAction.DAMAGECODE,conditions,0,0);
			int size = 1;
			if(!isEmpty(prpDcodeDtos)) {
				size = size + prpDcodeDtos.size();
				prpDcodeDtoList = new PrpDcodeDtoInfo[size];
				int i = 0;
				for(PrpDcodeDto element:prpDcodeDtos) {
					prpDcodeDtoList[i++] = new PrpDcodeDtoInfo(element.getCodeCode(),element.getCodeCName());
				}
				prpDcodeDtoList[size-1] = new PrpDcodeDtoInfo("z999","����ԭ�����ֺ�");
			}else{
				prpDcodeDtoList = new PrpDcodeDtoInfo[size];
				prpDcodeDtoList[0] = new PrpDcodeDtoInfo("z999","����ԭ�����ֺ�");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��ѯ����");
			logger.log("��ȡ��ϸ����ԭ����Ϣ",serial,e);
		}
		logger.log("��ȡ��ϸ����ԭ����Ϣ", 0,serial,prpDcodeDtoList);
		return prpDcodeDtoList;
	}
	
	/**
	 * �ұ���Ϣ��ѯ
	 * @return
	 * @throws Exception 
	 */
	public PrpDcurrencyDtoInfo[] getComanyCode() throws Exception{
		long serial = System.currentTimeMillis();
		PrpDcurrencyDtoInfo[] dcurrencyDtoList = null;
		DBManager dbManager = new DBManager();
		try {
			String conditions = "";
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			BLPrpDcurrencyAction prpDcurrencyAction = new BLPrpDcurrencyAction();
			Collection<PrpDcurrencyDto> prpDcurrencyDtos = prpDcurrencyAction.findByConditions(dbManager, conditions, 0, 0);
			if(!isEmpty(prpDcurrencyDtos)) {
				dcurrencyDtoList = new PrpDcurrencyDtoInfo[prpDcurrencyDtos.size()];
				int i = 0;
				for(PrpDcurrencyDto element:prpDcurrencyDtos) {
					dcurrencyDtoList[i++] = new PrpDcurrencyDtoInfo(element.getCurrencyCode(),element.getCurrencyCName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��ѯ����");
			logger.log("�ұ���Ϣ��ѯ",serial,e);
		}finally{
			dbManager.close();
		}
		logger.log("�ұ���Ϣ��ѯ", 0,serial, dcurrencyDtoList);
		return dcurrencyDtoList;
	}
	
	/**
     * �������Ϣ��ѯ
     * @param strPolicyNo
     * @param earlabel
     * @param kindCode
     * @param strDamageDate
     * @param strDamageHour
     * @return
     */
	public HerdpolicylistDtoInfo[] getHerdpolicylistDto(String strPolicyNo,
			String earlabel, String kindCode, String strDamageDate,
			String strDamageHour) {
		long serial = System.currentTimeMillis();
		logger.log("�������Ϣ��ѯ",1,serial,"[strPolicyNo:"+strPolicyNo+"][earlabel:"+earlabel+
				"][kindCode:"+kindCode+"][strDamageDate:"+strDamageDate+"][strDamageHour:"+strDamageHour+"]");
		HerdpolicylistDtoInfo[] herdpolicylistDtoInfoList = null;
		int recordSize;
		ArrayList insureMainListDtoList = new ArrayList();
		InsuremainlistDto insuremainlistDto = new InsuremainlistDto();
		DBManager dManager = new DBManager();
		ResultSet result = null;
		String systemFlag = null;
		DateTime startDate = null;
		DateTime endDate = null;
		try {
			String statement = "select distinct systemflag,startdate,enddate from prpcmain where policyno ='"+strPolicyNo+"'";
			dManager.open(AppConfig.get("sysconst.DBJNDI"));
			//��ʼ����
			dManager.beginTransaction();
			result = dManager.executeQuery(statement);	//��ȡ�����
			result.next();
			systemFlag = dManager.getString(result, 1);
			startDate = dManager.getDateTime(result,DateTime.YEAR_TO_DAY,2);
			endDate = dManager.getDateTime(result,DateTime.YEAR_TO_DAY,3);
			dManager.commitTransaction();
			dManager.close();
			result.close();
			if("agri".equals(systemFlag)){//��ũ��
				BLInsuremainlistFacade bLInsuremainlistFacade = new BLInsuremainlistFacade();
				String insuremainlistConditions = "policyno = '" + strPolicyNo
						+ "' and VALIDITY in ('2','3') "
						+ "and (to_date('"+startDate+"','yyyy-mm-dd') <= to_date('" + strDamageDate
						+ "','yyyy-mm-dd') " + "and to_date('"+endDate+"','yyyy-mm-dd') >= to_date('"
						+ strDamageDate + "','yyyy-mm-dd'))";
				insureMainListDtoList = (ArrayList) bLInsuremainlistFacade
						.findNewAgriByConditions(insuremainlistConditions);
				if(insureMainListDtoList != null && insureMainListDtoList.size() == 1){

					BLHerdpolicylistFacade bLHerdpolicylistFacade = new BLHerdpolicylistFacade();
					insuremainlistDto = (InsuremainlistDto) insureMainListDtoList.get(0);
					//��ȡ����Ŷ�Ӧ�����Ĺ������� start
					String areacode = insuremainlistDto.getFareacode();
					BLAreas bLAreas = new BLAreas();
					String temparea = "";
					ArrayList<String> areas = (ArrayList<String>)bLAreas.getSupperArea(areacode);
					if(areas != null && areas.size() >0)
					{
						for(int k = areas.size()-1;k>=0;k--)
						{
							temparea = temparea + areas.get(k) + " ";
							
						}
					}
					//��ȡ����Ŷ�Ӧ�����Ĺ������� end
					String herdpolicylistDtoConditions = "Earlabel like'%"
							+ earlabel
							//+ "%' and kindcode = '" + kindCode //��������Ĳ�ѯ�����kindcode�������ִ�Ĭ��ֵ���˴�����kindcode����
							+ "' and INUSRELISTCODE = '"
							+ insuremainlistDto.getInusrelistcode()
							+ "' and VALIDITY = '1'";
//							+ "' and (STARTDATE <= to_date('" + strDamageDate
//							+ "','yyyy-mm-dd')  and ENDDATE >= to_date('"
//							+ strDamageDate + "','yyyy-mm-dd'))";
					System.out.println(herdpolicylistDtoConditions);
					Collection collection = (ArrayList) bLHerdpolicylistFacade.findNewAgriByConditions(herdpolicylistDtoConditions);
					recordSize = collection.size();
					int i = 0;
					herdpolicylistDtoInfoList = new HerdpolicylistDtoInfo[recordSize];
					BLPrplcompensateearFacade bLPrplcompensateearFacade = new BLPrplcompensateearFacade();
					for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
						HerdpolicylistDto herdpolicylist = (HerdpolicylistDto) iterator.next();
						EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
						HerdpolicylistDto endorHerdpolicylistDto = endorseViewHelper
								.findForEndorHerdpolicylistBefore(herdpolicylist,
										kindCode, strPolicyNo, strDamageDate,
										strDamageHour);
						if (endorHerdpolicylistDto != null) {
							String processing = "";
			   	   			if(bLPrplcompensateearFacade.getInprocessCount(strPolicyNo,endorHerdpolicylistDto.getEarlabel())>0){
			   	   				processing = "Y";
							}else{
			   	   				processing = "N";
							}
							herdpolicylistDtoInfoList[i++] = new HerdpolicylistDtoInfo(
									endorHerdpolicylistDto.getInusrelistcode(),
									endorHerdpolicylistDto.getEarlabel(),
									endorHerdpolicylistDto.getKindcode(),
									endorHerdpolicylistDto.getFidcard(),
									endorHerdpolicylistDto.getBankcard(),
									endorHerdpolicylistDto.getFcode(),
									endorHerdpolicylistDto.getFname(),
									endorHerdpolicylistDto.getBreedingareacode(),
									endorHerdpolicylistDto.getBank(),
									""+endorHerdpolicylistDto.getAmount(),
									""+endorHerdpolicylistDto.getSumamount(),
									endorHerdpolicylistDto.getBreedingareaname(),
									temparea,processing);
						}
					}
				}
			}else{//��ũ��
			BLInsuremainlistFacade bLInsuremainlistFacade = new BLInsuremainlistFacade();
			String insuremainlistConditions = "policyno = '" + strPolicyNo
					+ "' and VALIDITY in ('2','3') "
					+ "and (STARTTIME <= to_date('" + strDamageDate
					+ "','yyyy-mm-dd') " + "and ENDTIME >= to_date('"
					+ strDamageDate + "','yyyy-mm-dd'))";
			insureMainListDtoList = (ArrayList) bLInsuremainlistFacade
					.findByConditions(insuremainlistConditions);

			if (insureMainListDtoList != null && insureMainListDtoList.size() == 1) {
				BLHerdpolicylistFacade bLHerdpolicylistFacade = new BLHerdpolicylistFacade();
				insuremainlistDto = (InsuremainlistDto) insureMainListDtoList.get(0);
				//��ȡ����Ŷ�Ӧ�����Ĺ������� start
				String areacode = insuremainlistDto.getFareacode();
				BLAreas bLAreas = new BLAreas();
				String temparea = "";
				ArrayList<String> areas = (ArrayList<String>)bLAreas.getSupperArea(areacode);
				if(areas != null && areas.size() >0)
				{
					for(int k = areas.size()-1;k>=0;k--)
					{
						temparea = temparea + areas.get(k) + " ";
						
					}
				}
				//��ȡ����Ŷ�Ӧ�����Ĺ������� end
				String herdpolicylistDtoConditions = "Earlabel like'%"
						+ earlabel + "%' and kindcode = '" + kindCode
						+ "' and INUSRELISTCODE = '"
						+ insuremainlistDto.getInusrelistcode()
						+ "' and VALIDITY = '1'";
//						+ "' and (STARTDATE <= to_date('" + strDamageDate
//						+ "','yyyy-mm-dd')  and ENDDATE >= to_date('"
//						+ strDamageDate + "','yyyy-mm-dd'))";
				System.out.println(herdpolicylistDtoConditions);
				Collection collection = (ArrayList) bLHerdpolicylistFacade.findByConditions(herdpolicylistDtoConditions);
				recordSize = collection.size();
				int i = 0;
				herdpolicylistDtoInfoList = new HerdpolicylistDtoInfo[recordSize];
				BLPrplcompensateearFacade bLPrplcompensateearFacade = new BLPrplcompensateearFacade();
				for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
					HerdpolicylistDto herdpolicylist = (HerdpolicylistDto) iterator.next();
					EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
					HerdpolicylistDto endorHerdpolicylistDto = endorseViewHelper
							.findForEndorHerdpolicylistBefore(herdpolicylist,
									kindCode, strPolicyNo, strDamageDate,
									strDamageHour);
					if (endorHerdpolicylistDto != null) {
						String processing = "";
		   	   			if(bLPrplcompensateearFacade.getInprocessCount(strPolicyNo,endorHerdpolicylistDto.getEarlabel())>0){
		   	   				processing = "Y";
						}else{
		   	   				processing = "N";
						}
						herdpolicylistDtoInfoList[i++] = new HerdpolicylistDtoInfo(
								endorHerdpolicylistDto.getInusrelistcode(),
								endorHerdpolicylistDto.getEarlabel(),
								endorHerdpolicylistDto.getKindcode(),
								endorHerdpolicylistDto.getFidcard(),
								endorHerdpolicylistDto.getBankcard(),
								endorHerdpolicylistDto.getFcode(),
								endorHerdpolicylistDto.getFname(),
								endorHerdpolicylistDto.getBreedingareacode(),
								endorHerdpolicylistDto.getBank(),
								""+endorHerdpolicylistDto.getAmount(),
								""+endorHerdpolicylistDto.getSumamount(),
								endorHerdpolicylistDto.getBreedingareaname(),
								temparea,processing);
					}
				}
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��ѯ����");
			logger.log("�������Ϣ��ѯ",serial,e);
		}
		logger.log("�������Ϣ��ѯ", 0,serial, herdpolicylistDtoInfoList);
		return herdpolicylistDtoInfoList;
	}
	
	/**
	 * �¹�����Ϣ��ѯ
	 * @param strPolicyNo
	 * @param strRiskCode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public PrpCinsuredDtoInfo[] getPrpCinsuredVirturlItem(String strPolicyNo,String strRiskCode,String fname,String fidCard){
		long serial = System.currentTimeMillis();
		logger.log("�¹�����Ϣ��ѯ", 1,serial, "[strPolicyNo:"+strPolicyNo+"][strRiskCode:"+strRiskCode+"][fname:"+fname+"][fidCard:"+fidCard+"]");
		PrpCinsuredDtoInfo[] prpCinsuredDtoInfoList = null;
		int size =0;
		try {
        	UIPolicyAction uiPolicyAction = new UIPolicyAction();
            GroupProposalService groupProposalService = new GroupProposalService();
            //�Ƿ����ŵ��ı�־
			boolean isVirturlItemRisk = groupProposalService.isGroupProposal(strRiskCode);
			String conditions = " policyno='"+strPolicyNo+"'";
			//����ũ�����������֤��Ϊ���жϣ�����չʾ��ֲ���嵥��Ϣ���¹�����Ϣ�ӿ�ҳ��
			if((!"".equals(fname) && fname!=null) || (!"".equals(fidCard) && fidCard!=null)){
				com.sinosoft.claim.dto.domain.PrpCmainDto prpCmainDto = uiPolicyAction.findPrpCmainDtoByPrimaryKey(strPolicyNo);
				BLPrpCinsuredFacade blPrpCinsuredFacade = new BLPrpCinsuredFacade();
				String systemFlag = "";
				String condition = " 1=1 ";
				if((!"".equals(fname) && fname!=null) && ("".equals(fidCard) || fidCard==null)){//ũ��������Ϊ��,���֤��Ϊ��
					condition = condition + " AND I.INUSRELISTCODE = T.INUSRELISTCODE AND I.POLICYNO = '"+strPolicyNo+"'" +
					" AND T.FNAME = '"+fname+"' And i.validity='2' And t.validity='1' ";
				}else if((!"".equals(fidCard) && fidCard!=null) && ("".equals(fname) || fname==null)){//ũ�����֤�Ų�Ϊ��,ũ������Ϊ��
					condition = condition + " AND I.INUSRELISTCODE = T.INUSRELISTCODE AND I.POLICYNO = '"+strPolicyNo+"'" +
					" AND T.FIDCARD = '"+fidCard+"' And i.validity='2' And t.validity='1' ";
				}else if((!"".equals(fname) && fname!=null) && (!"".equals(fidCard) && fidCard!=null)){//ũ�����������֤����Ϊ��
					condition = condition + " AND I.INUSRELISTCODE = T.INUSRELISTCODE AND I.POLICYNO = '"+strPolicyNo+"'" +
					" AND T.FIDCARD = '"+fidCard+"' AND T.FNAME = '"+fname+"' And i.validity='2' And t.validity='1' ";
				}
				if(prpCmainDto!=null){
					systemFlag = prpCmainDto.getSystemFlag();
					if("agri".equals(systemFlag)){//��ũ��
						Collection cinsuredDtoList = (ArrayList)blPrpCinsuredFacade.findByNewPlantingConditions(condition);
						size = cinsuredDtoList.size();
						prpCinsuredDtoInfoList = new PrpCinsuredDtoInfo[size];
						int i = 0;
						for(Iterator iterator = cinsuredDtoList.iterator();iterator.hasNext();){
							PrpCinsuredDto prpCinsuredDto = (PrpCinsuredDto) iterator.next();
							PrpCinsuredDtoInfo prpCinsuredDtoInfo = new PrpCinsuredDtoInfo();
							prpCinsuredDtoInfo.setAge("");
							prpCinsuredDtoInfo.setFamilyno(String.valueOf(prpCinsuredDto.getSerialNo()));
							prpCinsuredDtoInfo.setIdentifyNumber(prpCinsuredDto.getIdentifyNumber());
							prpCinsuredDtoInfo.setInsuredCode(prpCinsuredDto.getInsuredCode());
							prpCinsuredDtoInfo.setInsuredName(prpCinsuredDto.getInsuredName());
							prpCinsuredDtoInfo.setSex("");
							prpCinsuredDtoInfoList[i++] = prpCinsuredDtoInfo;
						}
					}else{//��ũ��
						Collection cinsuredDtoList = (ArrayList)blPrpCinsuredFacade.findByOldPlantingConditions(condition);
						size = cinsuredDtoList.size();
						prpCinsuredDtoInfoList = new PrpCinsuredDtoInfo[size];
						int i = 0;
						for(Iterator iterator = cinsuredDtoList.iterator();iterator.hasNext();){
							PrpCinsuredDto prpCinsuredDto = (PrpCinsuredDto) iterator.next();
							PrpCinsuredDtoInfo prpCinsuredDtoInfo = new PrpCinsuredDtoInfo();
							prpCinsuredDtoInfo.setAge("");
							prpCinsuredDtoInfo.setFamilyno(String.valueOf(prpCinsuredDto.getSerialNo()));
							prpCinsuredDtoInfo.setIdentifyNumber(prpCinsuredDto.getIdentifyNumber());
							prpCinsuredDtoInfo.setInsuredCode(prpCinsuredDto.getInsuredCode());
							prpCinsuredDtoInfo.setInsuredName(prpCinsuredDto.getInsuredName());
							prpCinsuredDtoInfo.setSex("");
							prpCinsuredDtoInfoList[i++] = prpCinsuredDtoInfo;
						}
					}
				}
				
			}else{
				//���2743���ֵĸ��Ի�����
			       if("2743".equals(strRiskCode)){
					    String policyType="";
			        	BLPrpCmainFacade blPrpCmainFacade=new BLPrpCmainFacade();
			        	Collection prpCmainCollection=blPrpCmainFacade.findByConditions(conditions); 
			        	Iterator prpCmainIterator=prpCmainCollection.iterator();
			        	while(prpCmainIterator.hasNext()){
			        	    PrpCmainDto prpCmainDto=(PrpCmainDto)prpCmainIterator.next();
			        	    policyType=prpCmainDto.getPolicyType();
			        	    break;
			        	}
			        	if("01".equals(policyType)){//����
			        	    isVirturlItemRisk=false;
			        	}else if("02".equals(policyType)){//�ŵ�
			        	    isVirturlItemRisk=true;
			        	}
			        }
			       
			       if(isVirturlItemRisk){
			    	   Collection collection = uiPolicyAction.findPrpCinsuredViturlItemDtoByConditions(conditions);
			    	   size = collection.size();
			    	   prpCinsuredDtoInfoList = new PrpCinsuredDtoInfo[size];
			    	   int i=0;
			    	   for(Iterator iterator = collection.iterator();iterator.hasNext();){
			    		   PrpCvirturlItemSchema prpCvirturlItemSchema = (PrpCvirturlItemSchema) iterator.next();
			    		   PrpCinsuredDtoInfo prpCinsuredDtoInfo = new PrpCinsuredDtoInfo();
			    		   prpCinsuredDtoInfo.setFamilyno(prpCvirturlItemSchema.getFamilyNo());
			    		   prpCinsuredDtoInfo.setInsuredName(prpCvirturlItemSchema.getFamilyName());
			    		   prpCinsuredDtoInfo.setAge(prpCvirturlItemSchema.getFamilyAge());
		             	   prpCinsuredDtoInfo.setSex(prpCvirturlItemSchema.getFamilySex());
			               prpCinsuredDtoInfo.setIdentifyNumber(prpCvirturlItemSchema.getIdentifyNumber());
			               prpCinsuredDtoInfo.setInsuredCode("0000");
			               prpCinsuredDtoInfoList[i++] = prpCinsuredDtoInfo;
			    	   }
			       }else{
			    	   Collection collection = uiPolicyAction.findPrpCinsuredDtoByConditions(conditions);
			    	   
			    	   ArrayList<PrpCinsuredDtoInfo> list = new ArrayList<PrpCinsuredDtoInfo>();
		               for(Iterator iterator = collection.iterator();iterator.hasNext();){
		            	   PrpCinsuredDto prpCinsuredDto = (PrpCinsuredDto) iterator.next();
			               if(prpCinsuredDto.getInsuredFlag().equals("1") ||prpCinsuredDto.getInsuredFlag().equals("1")){
			            	   String policyNo = prpCinsuredDto.getPolicyNo();
				               int serialNo = prpCinsuredDto.getSerialNo();
				               BLPrpCinsuredNatureFacade blPrpCinsuredNatureFacade = new BLPrpCinsuredNatureFacade();
				               PrpCinsuredNatureDto prpCinsuredNatureDto = blPrpCinsuredNatureFacade.findByPrimaryKey(policyNo,serialNo);
				               
				               PrpCinsuredDtoInfo prpCinsuredDtoInfo = new PrpCinsuredDtoInfo();
				               int familyno = 1;
				               if(prpCinsuredNatureDto==null){
				            	   familyno = 1;
				               }else{
				            	   familyno=prpCinsuredNatureDto.getSerialNo();
				               }
				    		   prpCinsuredDtoInfo.setFamilyno(String.valueOf(familyno));
				    		   prpCinsuredDtoInfo.setInsuredName(prpCinsuredDto.getInsuredName());
				    		   if(prpCinsuredNatureDto != null){
				    			   prpCinsuredDtoInfo.setAge(String.valueOf(prpCinsuredNatureDto.getAge()));
				             	   prpCinsuredDtoInfo.setSex(prpCinsuredNatureDto.getSex());
				    		   }else{
				    			   prpCinsuredDtoInfo.setAge("0");
				             	   prpCinsuredDtoInfo.setSex("0");
				    		   }
				               prpCinsuredDtoInfo.setIdentifyNumber(prpCinsuredDto.getIdentifyNumber());
				               prpCinsuredDtoInfo.setInsuredCode(prpCinsuredDto.getInsuredCode());
				               list.add(prpCinsuredDtoInfo);
			               }
		               }
		               if(null != list && list.size()>0){
		            	   prpCinsuredDtoInfoList = new PrpCinsuredDtoInfo[list.size()];
		            	   for(int i=0;i<list.size();i++){
		            		   prpCinsuredDtoInfoList[i] = list.get(i);
		            	   }
		               }
			       }
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("�¹�����Ϣ��ѯ",serial,e);
		}
		logger.log("�¹�����Ϣ��ѯ", 0,serial, prpCinsuredDtoInfoList);
        return prpCinsuredDtoInfoList;
	}
	
	
	
	/**
	 * �¹�����Ϣ��ѯ����������������������֤�������ѯ����ʹ�ã�
	 * @param strPolicyNo
	 * @param strRiskCode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public PrpCinsuredDtoInfo[] getPrpCinsuredVirturlItemNew(String strPolicyNo,String strRiskCode,String strName,String strIdcardno){
		long serial = System.currentTimeMillis();
		logger.log("�¹�����Ϣ��ѯ", 1,serial, "[strPolicyNo:"+strPolicyNo+"][strRiskCode:"+strRiskCode+"]");
		PrpCinsuredDtoInfo[] prpCinsuredDtoInfoList = null;
		int size =0;
		try {
        	UIPolicyAction uiPolicyAction = new UIPolicyAction();
            GroupProposalService groupProposalService = new GroupProposalService();
            //�Ƿ����ŵ��ı�־
			boolean isVirturlItemRisk = groupProposalService.isGroupProposal(strRiskCode);
			String conditions = " policyno='"+strPolicyNo+"'";
			
			//���2743���ֵĸ��Ի�����
	       if("2743".equals(strRiskCode)){
			    String policyType="";
	        	BLPrpCmainFacade blPrpCmainFacade=new BLPrpCmainFacade();
	        	Collection prpCmainCollection=blPrpCmainFacade.findByConditions(conditions); 
	        	Iterator prpCmainIterator=prpCmainCollection.iterator();
	        	while(prpCmainIterator.hasNext()){
	        	    PrpCmainDto prpCmainDto=(PrpCmainDto)prpCmainIterator.next();
	        	    policyType=prpCmainDto.getPolicyType();
	        	    break;
	        	}
	        	if("01".equals(policyType)){//����
	        	    isVirturlItemRisk=false;
	        	}else if("02".equals(policyType)){//�ŵ�
	        	    isVirturlItemRisk=true;
	        	}
	        }
	       
	       if(isVirturlItemRisk){
	    	   if(!"".equals(strName)){//�����жϣ���ηǿգ�����ƴ�Ӳ�ѯ
	    		   conditions = conditions+" and familyname='"+strName+"'";
	    	   }
	    	   if(!"".equals(strIdcardno)){
	    		   conditions = conditions+" and identifynumber='"+strIdcardno+"'";
	    	   }
	    	   Collection collection = uiPolicyAction.findPrpCinsuredViturlItemDtoByConditions(conditions);
	    	   size = collection.size();
	    	   prpCinsuredDtoInfoList = new PrpCinsuredDtoInfo[size];
	    	   int i=0;
	    	   for(Iterator iterator = collection.iterator();iterator.hasNext();){
	    		   PrpCvirturlItemSchema prpCvirturlItemSchema = (PrpCvirturlItemSchema) iterator.next();
	    		   PrpCinsuredDtoInfo prpCinsuredDtoInfo = new PrpCinsuredDtoInfo();
	    		   prpCinsuredDtoInfo.setFamilyno(prpCvirturlItemSchema.getFamilyNo());
	    		   prpCinsuredDtoInfo.setInsuredName(prpCvirturlItemSchema.getFamilyName());
	    		   prpCinsuredDtoInfo.setAge(prpCvirturlItemSchema.getFamilyAge());
             	   prpCinsuredDtoInfo.setSex(prpCvirturlItemSchema.getFamilySex());
	               prpCinsuredDtoInfo.setIdentifyNumber(prpCvirturlItemSchema.getIdentifyNumber());
	               prpCinsuredDtoInfo.setInsuredCode("0000");
	               prpCinsuredDtoInfoList[i++] = prpCinsuredDtoInfo;
	    	   }
	       }else{
	    	   if(!"".equals(strName)){
	    		   conditions = conditions+" and insuredname='"+strName+"'";
	    	   }
	    	   if(!"".equals(strIdcardno)){
	    		   conditions = conditions+" and identifynumber='"+strIdcardno+"'";
	    	   }
	    	   Collection collection = uiPolicyAction.findPrpCinsuredDtoByConditions(conditions);
	    	   
	    	   ArrayList<PrpCinsuredDtoInfo> list = new ArrayList<PrpCinsuredDtoInfo>();
               for(Iterator iterator = collection.iterator();iterator.hasNext();){
            	   PrpCinsuredDto prpCinsuredDto = (PrpCinsuredDto) iterator.next();
	               if(prpCinsuredDto.getInsuredFlag().equals("1") ||prpCinsuredDto.getInsuredFlag().equals("1")){
	            	   String policyNo = prpCinsuredDto.getPolicyNo();
		               int serialNo = prpCinsuredDto.getSerialNo();
		               BLPrpCinsuredNatureFacade blPrpCinsuredNatureFacade = new BLPrpCinsuredNatureFacade();
		               PrpCinsuredNatureDto prpCinsuredNatureDto = blPrpCinsuredNatureFacade.findByPrimaryKey(policyNo,serialNo);
		               
		               PrpCinsuredDtoInfo prpCinsuredDtoInfo = new PrpCinsuredDtoInfo();
		               int familyno = 1;
		               if(prpCinsuredNatureDto==null){
		            	   familyno = 1;
		               }else{
		            	   familyno=prpCinsuredNatureDto.getSerialNo();
		               }
		    		   prpCinsuredDtoInfo.setFamilyno(String.valueOf(familyno));
		    		   prpCinsuredDtoInfo.setInsuredName(prpCinsuredDto.getInsuredName());
		    		   if(prpCinsuredNatureDto != null){
		    			   prpCinsuredDtoInfo.setAge(String.valueOf(prpCinsuredNatureDto.getAge()));
		             	   prpCinsuredDtoInfo.setSex(prpCinsuredNatureDto.getSex());
		    		   }else{
		    			   prpCinsuredDtoInfo.setAge("0");
		             	   prpCinsuredDtoInfo.setSex("0");
		    		   }
		               prpCinsuredDtoInfo.setIdentifyNumber(prpCinsuredDto.getIdentifyNumber());
		               prpCinsuredDtoInfo.setInsuredCode(prpCinsuredDto.getInsuredCode());
		               list.add(prpCinsuredDtoInfo);
	               }
               }
               if(null != list && list.size()>0){
            	   prpCinsuredDtoInfoList = new PrpCinsuredDtoInfo[list.size()];
            	   for(int i=0;i<list.size();i++){
            		   prpCinsuredDtoInfoList[i] = list.get(i);
            	   }
               }
	       }
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("�¹�����Ϣ��ѯ",serial,e);
		}
		logger.log("�¹�����Ϣ��ѯ", 0,serial, prpCinsuredDtoInfoList);
        return prpCinsuredDtoInfoList;
	}
	/**
	 * �������Ϣ��֤
	 * @param policyNo
	 * @param indexCode
	 * @return
	 */
	public HouseIndecCodeDtoInfo[] getHouseByIndexCode(String policyNo,String indexCode){
		long serial = System.currentTimeMillis();
		logger.log("�������Ϣ��֤", 1,serial, "[policyNo:"+policyNo+"][indexCode:"+indexCode+"]");
		HouseIndecCodeDtoInfo[] houseIndecCodeDtoInfoList = null;
		ArrayList insureMainListDtoList = new ArrayList();
		Collection collection = new ArrayList();
		BLInsuremainlistFacade bLInsuremainlistFacade = new BLInsuremainlistFacade();
		InsuremainlistDto insuremainlistDto = new InsuremainlistDto();
		int recordSize = 0;
		try {
			if(isEmpty(policyNo)){
				throw new Exception("�����Ų���Ϊ��");
			}
			if(isEmpty(indexCode)){
				throw new Exception("����Ų���Ϊ��");
			}
			String insuremainlistConditions = "policyno = '" + policyNo + "' and VALIDITY in ('2','3') " ;
			insureMainListDtoList = (ArrayList)bLInsuremainlistFacade.findByConditions(insuremainlistConditions);

			if(insureMainListDtoList != null && insureMainListDtoList.size() == 1){
				BLHousepolicylistFacade bLHousepolicylistFacade = new BLHousepolicylistFacade();
				insuremainlistDto = (InsuremainlistDto)insureMainListDtoList.get(0);
				String housepolicylistDtoConditions = " Indexcode = '"+ indexCode +
				"' and INUSRELISTCODE = '" + insuremainlistDto.getInusrelistcode() +
				"' and VALIDITY = '1' " ;
				collection  = bLHousepolicylistFacade.findByConditions(housepolicylistDtoConditions); 
				recordSize = collection.size();
				int i=0;
				houseIndecCodeDtoInfoList = new HouseIndecCodeDtoInfo[recordSize];
				for(Iterator iterator = collection.iterator();iterator.hasNext();){
			    	HousepolicylistDto housepolicylist = (HousepolicylistDto)iterator.next();
			    	HouseIndecCodeDtoInfo houseIndecCodeDtoInfo = new HouseIndecCodeDtoInfo();
			    	houseIndecCodeDtoInfo.setFidCard(housepolicylist.getIdcard());
			    	houseIndecCodeDtoInfo.setIndexCode(housepolicylist.getIndexcode());
			    	houseIndecCodeDtoInfo.setName(housepolicylist.getName());
			    	houseIndecCodeDtoInfoList[i++] = houseIndecCodeDtoInfo;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("ũ����ѯ����");
			logger.log("�������Ϣ��֤",serial,e);
		}
		logger.log("�������Ϣ��֤", 0,serial, houseIndecCodeDtoInfoList);
		return houseIndecCodeDtoInfoList;
	}
	/**
	 * ũ�����֤��Ϣ��֤
	 * @param policyNo
	 * @param damageDate
	 * @param damageHour
	 * @param name
	 * @param idCard
	 * @return
	 */
	public HousepolicyDtoInfo getHouseByNameOrId(String policyNo,String damageDate,String damageHour,String name, String idCard){
		long serial = System.currentTimeMillis();
		logger.log("ũ�����֤��Ϣ��֤", 1,serial, "[policyNo:"+policyNo+"][damageDate:"+damageDate+"][damageHour:"+
				damageHour+"][name:"+name+"][idCard:"+idCard+"]");
		HousepolicyDtoInfo housepolicyDtoInfo = new HousepolicyDtoInfo();
		HousepolicyDetailDtoInfo[] housepolicyDetailDtoInfoList = null;
		ArrayList insureMainListDtoList = new ArrayList();
		Collection collection = new ArrayList();
		BLInsuremainlistFacade bLInsuremainlistFacade = new BLInsuremainlistFacade();
		InsuremainlistDto insuremainlistDto = new InsuremainlistDto();
		int recordSize = 0;
		try {
			if(isEmpty(policyNo)){
				throw new Exception("�����Ų���Ϊ��");
			}
			if(isEmpty(damageDate)||isEmpty(damageHour)){
				throw new Exception("����ʱ�䲻��Ϊ��");
			}
			if(isEmpty(idCard)){
				throw new Exception("ũ�����֤�Ų���Ϊ��");
			}
				
			String insuremainlistConditions = "policyno = '" + policyNo + "' and VALIDITY in ('2','3') " +
					"and (STARTTIME <= to_date('"+damageDate+"','yyyy-mm-dd') " +
					"and ENDTIME >= to_date('"+damageDate+"','yyyy-mm-dd'))"; 
			insureMainListDtoList = (ArrayList)bLInsuremainlistFacade.findByConditions(insuremainlistConditions);

			if(insureMainListDtoList != null && insureMainListDtoList.size() == 1){
				BLHousepolicylistFacade bLHousepolicylistFacade = new BLHousepolicylistFacade();
				insuremainlistDto = (InsuremainlistDto)insureMainListDtoList.get(0);
				String housepolicylistDtoConditions = 
				" INUSRELISTCODE = '" + insuremainlistDto.getInusrelistcode() +
				"' and VALIDITY = '1" +
				"' and idCard = '" + idCard +
				"' and (STARTDATE <= to_date('"+damageDate+"','yyyy-mm-dd')  and ENDDATE >= to_date('"+damageDate+"','yyyy-mm-dd')) ";
				if(name !=null&&!"".equals(name.trim())){
					housepolicylistDtoConditions += " and name = '" + name +"'";
				}
				
				collection  = bLHousepolicylistFacade.findByConditions(housepolicylistDtoConditions); 
				recordSize = collection.size();
				int i=0;
				housepolicyDetailDtoInfoList = new HousepolicyDetailDtoInfo[recordSize];
			    for(Iterator iterator = collection.iterator();iterator.hasNext();){
			    	HousepolicylistDto housepolicylist = (HousepolicylistDto)iterator.next();
			    	HousepolicyDetailDtoInfo housepolicyDetailDtoInfo = new HousepolicyDetailDtoInfo();
			    	housepolicyDetailDtoInfo.setName(housepolicylist.getName());
			    	housepolicyDetailDtoInfo.setFidCard(housepolicylist.getIdcard());
			    	housepolicyDetailDtoInfo.setHuKouBu(housepolicylist.getHukoubu());
			    	housepolicyDetailDtoInfo.setAddress(housepolicylist.getAddress());
			    	housepolicyDetailDtoInfo.setPhone(housepolicylist.getPhone());
			    	housepolicyDetailDtoInfo.setClaimLoss("0.0");
			    	BLPrplcompensatehouseFacade bLPrplcompensatehouseFacade = new BLPrplcompensatehouseFacade();
	   	   			if(bLPrplcompensatehouseFacade.getInprocessCount(policyNo,housepolicylist.getIdcard())>0){
	   	   			housepolicyDetailDtoInfo.setHandleType("Y");
	   	   			}else{
	   	   			housepolicyDetailDtoInfo.setHandleType("N");
	   	   			}
	   	   			housepolicyDetailDtoInfo.setFloor(housepolicylist.getFloor());
	   	   			housepolicyDetailDtoInfo.setBuildIngNumber(housepolicylist.getBuildingnumber());
	   	   			housepolicyDetailDtoInfo.setZhuanNumber(housepolicylist.getZhuannumber());
	   	   			housepolicyDetailDtoInfo.setWaNumber(housepolicylist.getWanumber());
	   	   			housepolicyDetailDtoInfo.setOtherNumber(housepolicylist.getOthernumber());
	   	   			housepolicyDetailDtoInfo.setKitchenNumber(housepolicylist.getKitchennumber());
	   	   			housepolicyDetailDtoInfo.setRemark(housepolicylist.getRemark());
	   	   		housepolicyDetailDtoInfoList[i++] = housepolicyDetailDtoInfo;
				}
			}
			housepolicyDtoInfo.setHousepolicyDetailDtoInfoList(housepolicyDetailDtoInfoList);
			// ��ѯ������Ϣ
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			// PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo);
			// ���ݳ���ʱ���ҵ�����
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo,
					damageDate, damageHour);
			DecimalFormat decimalFormat = new DecimalFormat("0.00#");
			if(policyDto.getPrpCitemKindDtoList()!=null&&policyDto.getPrpCitemKindDtoList().size()>0){
				HouseKindCodeDtoInfo[] houseKindCodeDtoInfoList = new HouseKindCodeDtoInfo[policyDto.getPrpCitemKindDtoList().size()];
				for(int i=0;i<policyDto.getPrpCitemKindDtoList().size();i++){
					HouseKindCodeDtoInfo houseKindCodeDtoInfo = new HouseKindCodeDtoInfo();
					PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(i);
					houseKindCodeDtoInfo.setSerialNo(""+(i+1));
					houseKindCodeDtoInfo.setKindCode(prpCitemKindDto.getKindCode());
					houseKindCodeDtoInfo.setKindName(prpCitemKindDto.getKindName());
					houseKindCodeDtoInfo.setItemCode(prpCitemKindDto.getItemCode());
					houseKindCodeDtoInfo.setItemName(prpCitemKindDto.getItemDetailName());
					houseKindCodeDtoInfo.setAmount(decimalFormat.format(prpCitemKindDto.getAmount()));
					houseKindCodeDtoInfo.setCurrency(prpCitemKindDto.getCurrency());
					houseKindCodeDtoInfoList[i] = houseKindCodeDtoInfo;
				}
				housepolicyDtoInfo.setHouseKindCodeDtoInfoList(houseKindCodeDtoInfoList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("ũ����ѯ����");
			logger.log("ũ�����֤��Ϣ��֤",serial,e);
		}
		logger.log("ũ�����֤��Ϣ��֤", 0,serial, housepolicyDtoInfo);
		return housepolicyDtoInfo;
	}
	/**
	 * �¹�����������Ϣ
	 * @param policyNo
	 * @param riskCode
	 * @param familyNo
	 * @return
	 */
	public CvirturlItemDtoInfo getCvirturlItem (String policyNo,String riskCode,String familyNo){
		long serial = System.currentTimeMillis();
		logger.log("�¹�����������Ϣ", 1,serial, " [policyNo:"+policyNo+"][riskCode:"+riskCode+"][familyNo:"+familyNo+"]");
		CvirturlItemDtoInfo cvirturlItemDtoInfo= null;
		try {
			if(isEmpty(policyNo)){
				throw new Exception("�����Ų���Ϊ�գ����顣");
			}
			if(isEmpty(riskCode)){
				throw new Exception("���ִ��벻��Ϊ�գ����顣");
			}
			if(isEmpty(familyNo)){
				throw new Exception("���кŲ���Ϊ�գ����顣");
			}
			//�����ŵ��͸����Ŀ���ȡֵ���ŵ���prpcvirturlitemȡ��������prpcinsured��prpcitemkind��ȡ
			GroupProposalService groupProposalService = new GroupProposalService();
	        boolean VIRTUALITEM_RISK = groupProposalService.isGroupProposal(riskCode);
	        if(VIRTUALITEM_RISK){
		        ArrayList beneInsuredList = new ArrayList();
		        BLPrpCinsuredFacade blPrpCinsuredFacade = new BLPrpCinsuredFacade();
		        int intFamilyNo = Integer.parseInt(familyNo);
		        String conditions = "policyno = '" + policyNo+ "' and familyno= '" + intFamilyNo+"'";
		        beneInsuredList = (ArrayList)blPrpCinsuredFacade.findVirturlItemBeneInsuredConditions(conditions);
		        if (beneInsuredList != null && beneInsuredList.size() > 0){
		        	PrpCvirturlItemSchema prpCvirturlItemSchema  = (PrpCvirturlItemSchema) beneInsuredList.get(0);
		        	cvirturlItemDtoInfo = new CvirturlItemDtoInfo();
		        	if(prpCvirturlItemSchema.getBenName()==null||prpCvirturlItemSchema.getBenName()=="")
		            {
		        		cvirturlItemDtoInfo.setBenType("����������");
		            } else {
		                cvirturlItemDtoInfo.setBenName(prpCvirturlItemSchema.getBenName());
		                cvirturlItemDtoInfo.setRemark(prpCvirturlItemSchema.getRemark());
		                cvirturlItemDtoInfo.setBenIdentifyNumber(prpCvirturlItemSchema.getBenIdentifyNumber());
		            }
		        }else{
		        	cvirturlItemDtoInfo = new CvirturlItemDtoInfo();
		        	cvirturlItemDtoInfo.setBenType("����������");
		        }
	        }else{
	        	int intFamilyNo = Integer.parseInt(familyNo);
	        	ArrayList prpCinsuredDtoList = new ArrayList();
	        	ArrayList beneInsuredList = new ArrayList();
	        	BLPrpCinsuredFacade blPrpCinsuredFacade = new BLPrpCinsuredFacade();
	        	String conditions = "policyno = '" + policyNo+ "'";
	        	prpCinsuredDtoList = (ArrayList) blPrpCinsuredFacade.findByConditions(conditions);
	        	cvirturlItemDtoInfo = new CvirturlItemDtoInfo();
	        	
				if (prpCinsuredDtoList != null) {
					for (int i = 0; i < prpCinsuredDtoList.size(); i++) {
						PrpCinsuredDto prpCinsuredDto = (PrpCinsuredDto) prpCinsuredDtoList.get(i);
						if (prpCinsuredDto.getRelateserialno() == Integer.parseInt(familyNo)
								&& prpCinsuredDto.getInsuredFlag().equals("9")) {
							//beneInsuredList.add(prpCinsuredDto);
						}
					}
				}
	        	
	        	if(beneInsuredList != null && beneInsuredList.size()>0){
	        		PrpCinsuredDto  prpCinsuredDto = (PrpCinsuredDto) beneInsuredList.get(0);
	        		if(prpCinsuredDto.getInsuredName()==null&&"".equals(prpCinsuredDto.getInsuredName())){
	        			cvirturlItemDtoInfo.setBenType("����������");
	        		}else{
	        			cvirturlItemDtoInfo.setBenName(prpCinsuredDto.getInsuredName());
	        			cvirturlItemDtoInfo.setRemark("");
	        			cvirturlItemDtoInfo.setBenIdentifyNumber(prpCinsuredDto.getIdentifyNumber());
	        		}
	        		
	        	}else{
	        		cvirturlItemDtoInfo = new CvirturlItemDtoInfo();
		        	cvirturlItemDtoInfo.setBenType("����������");
	        	}
	        	
	      }
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�¹�����������Ϣ��ѯ����");
			logger.log("�¹�����������Ϣ",serial,e);
		}
		logger.log("�¹�����������Ϣ", 0,serial, cvirturlItemDtoInfo); 
		return cvirturlItemDtoInfo;
		
	}
	/**
	 * �¹��߱�����Ϣ
	 * @param policyNo
	 * @param riskCode
	 * @param familyNo
	 * @return
	 */
	public CvirturlItemKindDtoInfo[] getCvirturlItemKind (String policyNo,String riskCode,String familyNo){
		long serial = System.currentTimeMillis();
		logger.log("�¹��߱�����Ϣ", 1,serial, " [policyNo:"+policyNo+"][riskCode:"+riskCode+"][familyNo:"+familyNo+"]");
		CvirturlItemKindDtoInfo[] cvirturlItemKindDtoInfoList= null;
		try {
			if(isEmpty(policyNo)){
				throw new Exception("�����Ų���Ϊ�գ����顣");
			}
			if(isEmpty(riskCode)){
				throw new Exception("���ִ��벻��Ϊ�գ����顣");
			}
			if(isEmpty(familyNo)){
				throw new Exception("���кŲ���Ϊ�գ����顣");
			}
	        /**��ȡ�ұ��Ӧ�������ڷ���*/
	        String conditions = " codetype = 'CURRENCY_CI' and validstatus = '1'";
	        UICodeAction uiCodeAction = new UICodeAction();
	        Collection<PrpDcodeDto> prpDcodeDtos  = uiCodeAction.findByConditions(conditions);
	        Map<String, String> prpDcodeDtoMap = new HashMap<String, String>();
	        for(PrpDcodeDto prpDcodeDto:prpDcodeDtos){
	        	prpDcodeDtoMap.put(prpDcodeDto.getCodeCode(), prpDcodeDto.getCodeCName());
	        }
	        
	        GroupProposalService groupProposalService = new GroupProposalService();
	        boolean VIRTUALITEM_RISK = groupProposalService.isGroupProposal(riskCode);
	        if(VIRTUALITEM_RISK){
		        
		        ArrayList beneKindList = new ArrayList();
				BLPrpCitemKindFacade blPrpCitemKindFacade = new BLPrpCitemKindFacade();
				int intFamilyNo = Integer.parseInt(familyNo);
				String strConditions = "policyno = '" + policyNo
						+ "' and familyno=" + intFamilyNo;
				beneKindList = (ArrayList) blPrpCitemKindFacade.findVirturlItemByConditions(strConditions);
				cvirturlItemKindDtoInfoList = new CvirturlItemKindDtoInfo[beneKindList.size()];
				for(int i=0;i<beneKindList.size();i++){
					CvirturlItemKindDtoInfo cvirturlItemKindDtoInfo = new CvirturlItemKindDtoInfo();
					PrpCvirturlItemSchema prpCvirturlItemSchema = (PrpCvirturlItemSchema) beneKindList.get(i);
					cvirturlItemKindDtoInfo.setKindCode(prpCvirturlItemSchema.getKindCode());
					cvirturlItemKindDtoInfo.setKindName(prpCvirturlItemSchema.getKindName());
					cvirturlItemKindDtoInfo.setRationType(prpCvirturlItemSchema.getRationType());
					cvirturlItemKindDtoInfo.setItemDetailName(prpCvirturlItemSchema.getItemDetailName());
					cvirturlItemKindDtoInfo.setCurrency(prpCvirturlItemSchema.getCurrency());
					String currencyName = prpDcodeDtoMap.get(prpCvirturlItemSchema.getCurrency());
					if(currencyName==null||"".equals(currencyName)){
						currencyName="����";
					}
					cvirturlItemKindDtoInfo.setCurrencyName(currencyName);
					cvirturlItemKindDtoInfo.setAmount(prpCvirturlItemSchema.getAmount());
					cvirturlItemKindDtoInfo.setPremium(prpCvirturlItemSchema.getPremium());
					cvirturlItemKindDtoInfoList[i] = cvirturlItemKindDtoInfo;
		        }
	        }else{
	        	ArrayList beneKindList = new ArrayList();
				BLPrpCitemKindFacade blPrpCitemKindFacade = new BLPrpCitemKindFacade();
				int intFamilyNo = Integer.parseInt(familyNo);
				String strConditions = "policyno = '" + policyNo
						+ "' and familyno=" + intFamilyNo;
				beneKindList = (ArrayList) blPrpCitemKindFacade.findByConditions(strConditions);
				cvirturlItemKindDtoInfoList = new CvirturlItemKindDtoInfo[beneKindList.size()];
				for(int i =0;i<beneKindList.size();i++){
					PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) beneKindList.get(i);
					CvirturlItemKindDtoInfo cvirturlItemKindDtoInfo = new CvirturlItemKindDtoInfo();
					cvirturlItemKindDtoInfo.setKindCode(prpCitemKindDto.getKindCode());
					cvirturlItemKindDtoInfo.setKindName(prpCitemKindDto.getKindName());
					cvirturlItemKindDtoInfo.setRationType("");
					cvirturlItemKindDtoInfo.setItemDetailName(prpCitemKindDto.getItemDetailName());
					cvirturlItemKindDtoInfo.setCurrency(prpCitemKindDto.getCurrency());
					String currencyName = prpDcodeDtoMap.get(prpCitemKindDto.getCurrency());
					if(currencyName==null||"".equals(currencyName)){
						currencyName="����";
					}
					cvirturlItemKindDtoInfo.setCurrencyName(currencyName);
					cvirturlItemKindDtoInfo.setAmount(""+prpCitemKindDto.getAmount());
					cvirturlItemKindDtoInfo.setPremium(""+prpCitemKindDto.getPremium());
					cvirturlItemKindDtoInfoList[i] = cvirturlItemKindDtoInfo;
				}
	        }
			
				
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�¹��߱�����Ϣ��ѯ����");
			logger.log("�¹��߱�����Ϣ",serial,e);
		}
		logger.log("�¹��߱�����Ϣ", 0,serial, cvirturlItemKindDtoInfoList);
		return cvirturlItemKindDtoInfoList;
		
	}
	
	private boolean isEmpty(Collection<?> collection) {
		if (collection != null && collection.size() > 0) {
			return false;
		}
		return true;
	}
	
	private boolean isEmpty(String str) {
		return (str == null || str.trim().length() == 0);
	}
}
