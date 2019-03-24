package com.sinosoft.claim.ui.control.facade;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;

import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLprepayFacade;
import com.sinosoft.claim.bl.facade.BLPrplreturnvisitswflogFacade;
import com.sinosoft.claim.bl.facade.BLSwfFlowMainFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogStoreFacade;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.EndcaseDto;
import com.sinosoft.claim.dto.custom.ReCaseDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLcaseNoDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.dto.domain.PrplpendtrackDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfLogStoreDto;
import com.sinosoft.claim.dto.domain.SwfNotionDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIEndcaseAction;
import com.sinosoft.claim.ui.control.action.UIRecaseAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.DAAReturnVisitViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.common_claim.bl.action.custom.BLCIClaimAcciSdPlatFormInterfaceFacade;
import com.sinosoft.common_claim.bl.action.custom.BLCIClaimPropPlatFormInterfaceFacade;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmain;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utiall.blsvr.BLPrpDcompany;

/**
 * �����������߼�
 * <p>
 * Title: ��������
 * </p>
 * <p>
 * Description: �������⹤�����ӿڳ���
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * 
 * @author ��Ŀ��
 * @version 1.0
 */
public class UIWorkFlowUWInterFaceFacade {

    /**
     * ��˫��������ת�в���������
     * 
     * @param LflowID String ���⹤��������
     * @param LlogNo String ���⹤�����ڵ����
     * @param modelType String ģ������ 11:�˱�ģ��/22:����ģ��
     * @param certiType String ҵ������ T/P/E/C/Y
     * @param businessNo String ҵ���
     * @param riskCode String ���ִ���
     * @param classCode String �������
     * @param comCode String ҵ�����
     * @param handlerCode String �����˴���
     * @param makecom String ��������
     * @param userCode String ϵͳ������Ա
     * @param handler1Code String ҵ������˴���
     * @param contractNo String ��ͬ�ţ�һ����Գ��ա���ֻ�Գ��պ˱�������
     * @throws Exception
     * @return String
     */
    public String submitVericTask(String LflowID, String LlogNo, String modelType, String certiType, String businessNo,
            String riskCode, String classCode, String comCode, String handlerCode, String makecom, String userCode,
            String handler1Code, String contractNo) throws Exception {

        String uwFlowID = "";

        //�ж��ǲ���˫��û�д򿪣���
        //UW_URLOPEN
        UIWFUWClientFacade uiWFUWClientAction = new UIWFUWClientFacade();

        String SERVER_OPEN = AppConfig.get("sysconst.UW_URLOPEN");
        if (SERVER_OPEN.equals("1")) {
            uwFlowID = uiWFUWClientAction.sendXMLData(LflowID, LlogNo, modelType, certiType, businessNo, riskCode,
                    classCode, comCode, handlerCode, makecom, userCode, handler1Code, contractNo);
        } else {
            uwFlowID = "1111111111111111111111111";
        }
        System.out.println("���uwFlowID������������������������������������������"+uwFlowID);
        return uwFlowID;

    }

    /**
     * ˫��������ת�ж������еĺ���ڵ�����ݱ��
     * 
     * @param LflowID String ���⹤��������
     * @param LlogNo int ���⹤�����ڵ����
     * @param businessNo String ҵ�����
     * @param notionInfo String ������� ��Ա�� ʱ��ʱ��
     * @param handlerCode String ����Ա
     * @throws Exception
     * @return boolean
     */

    public int addInformationOnVeric(String LflowID, int LlogNo, String businessNo, String notionInfo,
            String handlerCode) throws Exception {
        //ȡ���������
        String swfLogFlowID = LflowID; //����������
        int swfLogLogNo = LlogNo; //������logno

        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        SwfLogDto swfLogDto = new SwfLogDto();
        swfLogDto = checkFlowNode(swfLogFlowID, swfLogLogNo, businessNo);

        int checkFlag = swfLogDto.getLogNo();
        if (checkFlag < 0)
            return checkFlag;
        if (checkFlag == 0)
            return checkFlag;

        //����ɹ��Ļ������ڹ���������ô����Ҫ�ύ�����������û�о�����
        WorkFlowDto workFlowDto = new WorkFlowDto();
        swfLogDto.setNodeStatus("2");
        swfLogDto.setHandleTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY).toString());
        workFlowDto.setUpdate(true);
        workFlowDto.setUpdateSwfLogDto(swfLogDto);
        System.out.println("addInformationOnVeric");

        AddNotionToWorkFlowDto(workFlowDto, swfLogFlowID, swfLogLogNo, notionInfo);
        uiWorkFlowAction.deal(workFlowDto);
        System.out.println("addInformationOnVeric");
        return checkFlag;
    }
    /**
     * ����ڵ���˻�
     * 
     * @param LflowID String ���⹤��������
     * @param LlogNo int ���⹤�����ڵ����
     * @param businessNo String ҵ�����
     * @param notionInfo String ������� ��Ա�� ʱ��ʱ��
     * @param handlerCode String ����Ա
     * @throws Exception
     * @return boolean
     */

    public int backVericToCompp(String LflowID, int LlogNo, String businessNo, String notionInfo, String handlerCode)
            throws Exception {

        //ȡ���������
        String compensateNo = businessNo;
        String underWriteFlag = "1";
        String swfLogFlowID = LflowID; //����������
        int swfLogLogNo = LlogNo; //������logno
        String keyString = ""; //������keyIn
        UserDto user = new UserDto(); //��Ϊ�����û��Լ������ģ�����Ŀǰ��ʱ��Ϊ���Ǽ��������
        user.setUserCode(handlerCode);
        user.setUserName("˫�˻���");
        SwfLogDto swfLogDto = new SwfLogDto();
        //��������������Ϣ,���˫�˿���ֱ��д��ߵ�ҵ�����ݿ⣬�Ͳ���Ҫ��һ���ˡ�
        UICompensateAction uiCompensateAction = new UICompensateAction();
        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        swfLogDto = checkFlowNode(swfLogFlowID, swfLogLogNo, businessNo);

        int checkFlag = swfLogDto.getLogNo();
        if (checkFlag < 0)
            return checkFlag;
        if (checkFlag == 0)
            return checkFlag;
        keyString = swfLogDto.getKeyIn();//�����������
        user.setComCode(swfLogDto.getHandleDept());
        user.setComName(swfLogDto.getDeptName());

        //Ŀǰ�ڽӿ��У����˫��û��д���ǵ�ҵ��⣬��ô����������棬����Ѿ�д�����ǵ�ҵ��⣬��ôֻҪ���湤�������ݾͿ�����
        //uiCompensateAction.approve(compensateNo,user.getUserCode(),underWriteFlag);
        //����ɹ��Ļ������ڹ���������ô����Ҫ�ύ�����������û�о�����
        WorkFlowDto workFlowDto = getWorkFlowDto(user, swfLogFlowID, swfLogLogNo, "5", compensateNo, keyString,
                keyString, compensateNo, false);

        if (workFlowDto == null)
            return -5;
        //׷�����
        AddNotionToWorkFlowDto(workFlowDto, swfLogFlowID, swfLogLogNo, notionInfo);
        
        
        if("1".equals(swfLogDto.getDataFlag())){
        	if(workFlowDto.getSubmitSwfLogDtoList()!=null){
            	ArrayList<SwfLogDto>  list = (ArrayList<SwfLogDto>)workFlowDto.getSubmitSwfLogDtoList();
            	for (SwfLogDto swfLogDto2 : list) {
            		swfLogDto2.setDataFlag("1");
    			}
            }
        }
        
        uiWorkFlowAction.deal(workFlowDto);

        System.out.println("backVericToCompp");
        return checkFlag;
    }

    /**
     * ����ڵ��ͨ�����ֹ��᰸��
     * 
     * @param LflowID String ���⹤��������
     * @param LlogNo int ���⹤�����ڵ����
     * @param businessNo String ҵ�����
     * @param notionInfo String ������� ��Ա�� ʱ��ʱ��
     * @param handlerCode String ����Ա
     * @throws Exception
     * @return boolean
     */

    public int passVeric(HttpServletRequest httpServletRequest, String LflowID, int LlogNo, String businessNo,
            String notionInfo, String handlerCode) throws Exception {
        boolean flag = true;

           String policyNo="";
           String riskCode="";
           //String compensateNo = businessNo;	
           CompensateDto compensateDto = new  CompensateDto(); 
           PrpLprepayDto  prpLprepayDto= new PrpLprepayDto();
        
        //ȡ���������
        
        String underWriteFlag = "1";
        String swfLogFlowID = LflowID; //����������
        int swfLogLogNo = LlogNo; //������logno
        String keyString = ""; //������keyIn
        UserDto user = new UserDto(); //��Ϊ�����û��Լ������ģ�����Ŀǰ��ʱ��Ϊ���Ǽ��������
        user.setUserCode(handlerCode);
        user.setUserName("˫��ͨ��");
        //��������������Ϣ,���˫�˿���ֱ��д��ߵ�ҵ�����ݿ⣬�Ͳ���Ҫ��һ���ˡ�
        UICompensateAction uiCompensateAction = new UICompensateAction();
        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();

        //???�ж��ǲ����Զ��᰸(�� appconfig+����������ձ�־)���������passVericAndCloseFlow();

        String autoEndCaseFlag = AppConfig.get("sysconst.AutoEndCase");
        boolean  isNewCar=false;
        SwfLogDto swfLogDto = new SwfLogDto();
        swfLogDto = checkFlowNode(swfLogFlowID, swfLogLogNo, businessNo);
        if (swfLogDto.getDataFlag()!=null&&"1".equals(swfLogDto.getDataFlag())) {
        	isNewCar=true;
		}
        //�Ƿ���Ҫ�Զ��᰸���Ƿ��ǰ����⸶
        String  caseType="";
        if (businessNo.substring(0,1).equals("6") ){
            compensateDto = uiCompensateAction.findByPrimaryKey(businessNo);
            policyNo =compensateDto.getPrpLcompensateDto().getPolicyNo();
            riskCode =compensateDto.getPrpLcompensateDto().getRiskCode();
        }else  if (businessNo.substring(0,1).equals("Y") 
        	||(isNewCar&&businessNo.substring(0,1).equals("8"))	){
        	BLPrpLprepayFacade  blPrpLprepayFacade  =new BLPrpLprepayFacade();
        	prpLprepayDto= blPrpLprepayFacade.findByPrimaryKey(businessNo);
        	policyNo= prpLprepayDto.getPolicyNo();
        	riskCode =prpLprepayDto.getRiskCode();
        	caseType = prpLprepayDto.getCaseType();
        }
        //System.out.println("-------�Զ��᰸----"+autoEndCaseFlag+"|"+compensateDto.getPrpLcompensateDto().getFinallyFlag());
        //if ("1".equals(autoEndCaseFlag) && "1".equals(compensateDto.getPrpLcompensateDto().getFinallyFlag())) {
        if (businessNo.substring(0,1).equals("6")&&"1".equals(autoEndCaseFlag) && "1".equals(compensateDto.getPrpLcompensateDto().getFinallyFlag()) ) {
        	/*�����ע�ͽ�����ͨ���Զ��᰸�Ŀ��عرտ�ʼ*/
         //return passVericAndCloseFlow(httpServletRequest, LflowID, LlogNo, businessNo, notionInfo, handlerCode);
        	/*�����ע�ͽ�����ͨ���Զ��᰸�Ŀ��عرս���*/
        }

        

        int checkFlag = swfLogDto.getLogNo();

        if (checkFlag < 0)
            return checkFlag;
        if (checkFlag == 0)
            return checkFlag;
        System.out.println("swfLogDto.getflowid:" + swfLogDto.getFlowID());
        keyString = swfLogDto.getKeyIn();
        user.setComCode(swfLogDto.getHandleDept());
        user.setComName(swfLogDto.getDeptName());
        //Ŀǰ�ڽӿ��У����˫��û��д���ǵ�ҵ��⣬��ô����������棬����Ѿ�д�����ǵ�ҵ��⣬��ôֻҪ���湤�������ݾͿ�����
        //uiCompensateAction.approve(compensateNo,user.getUserCode(),underWriteFlag);
        //����ɹ��Ļ������ڹ���������ô����Ҫ�ύ�����������û�о�����

        System.out.println("swfLogDto.getflowid:" + swfLogDto.getFlowID());
        System.out.println("keyString:" + keyString);
        WorkFlowDto workFlowDto = getWorkFlowDto(user, swfLogFlowID, swfLogLogNo, "4", keyString, keyString, keyString,
                businessNo, false);

        if (workFlowDto == null)
            return -5;
        //׷�����

        AddNotionToWorkFlowDto(workFlowDto, swfLogFlowID, swfLogLogNo, notionInfo);
        
        if(caseType!=null && !caseType.equals("") && (caseType.equals("7")||isNewCar)){//֧���������᰸
        	swfLogDto.setNodeStatus("4"); //
        	swfLogDto.setHandlerCode(handlerCode);
        	swfLogDto.setHandlerName(user.getUserName());
        	swfLogDto.setSubmitTime(new DateTime(DateTime.current(),
                    DateTime.YEAR_TO_SECOND).toString());
        	uiWorkFlowAction.updateFlow(swfLogDto);
        	
        }else {
        	if("1".equals(swfLogDto.getDataFlag())){
            	if(workFlowDto.getSubmitSwfLogDtoList()!=null){
                	ArrayList<SwfLogDto>  list = (ArrayList<SwfLogDto>)workFlowDto.getSubmitSwfLogDtoList();
                	for (SwfLogDto swfLogDto2 : list) {
                		swfLogDto2.setDataFlag("1");
        			}
                }
            }
        	uiWorkFlowAction.deal(workFlowDto);
        }
        System.out.println("passVeric");
        return checkFlag;
    }
    /**
     * ����ڵ��ͨ�����Զ��᰸��
     * 
     * @param LflowID String ���⹤��������
     * @param LlogNo int ���⹤�����ڵ����
     * @param businessNo String ҵ�����
     * @param notionInfo String ������� ��Ա�� ʱ��ʱ��
     * @param handlerCode String ����Ա
     * @throws Exception
     * @return boolean
     */

    public int passVericAndCloseFlow(HttpServletRequest httpServletRequest, String LflowID, int LlogNo,
            String businessNo, String notionInfo, String handlerCode) throws Exception {
    	UICompensateAction uiCompensateAction = new UICompensateAction();
    	CompensateDto compensateDto = uiCompensateAction.findByPrimaryKey(businessNo);
    	UIRecaseAction  uiRecaseAction  =new  UIRecaseAction ();
    	Collection cases =uiRecaseAction.findByConditions(" claimNo = '" +compensateDto.getPrpLcompensateDto().getClaimNo()+"'");
    	if(cases.size() > 0){
    		return repassVericAndCloseFlow(httpServletRequest,LflowID,LlogNo,
    				compensateDto.getPrpLcompensateDto().getCompensateNo(), compensateDto.getPrpLcompensateDto().getClaimNo(),
    				notionInfo,handlerCode);
    	}
        System.out.println("----passVericAndCloseFlow---�Զ��᰸--");
        //ȡ���������
        String compensateNo = businessNo;
        String underWriteFlag = "1";
        String swfLogFlowID = LflowID; //����������
        int swfLogLogNo = LlogNo; //������logno
        String keyString = ""; //������keyIn
        UserDto user = new UserDto(); //��Ϊ�����û��Լ������ģ�����Ŀǰ��ʱ��Ϊ���Ǽ��������
        user.setUserCode(handlerCode);
        user.setUserName("˫��ͨ��");

        //��������������Ϣ,���˫�˿���ֱ��д��ߵ�ҵ�����ݿ⣬�Ͳ���Ҫ��һ���ˡ�
        
        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();

        SwfLogDto swfLogDto = new SwfLogDto();
        swfLogDto = checkFlowNode(swfLogFlowID, swfLogLogNo, businessNo);
        int checkFlag = swfLogDto.getLogNo();
        System.out.println("****checkFlag="+checkFlag);
        if (checkFlag < 0)
            return checkFlag;
        if (checkFlag == 0)
            return checkFlag;
        keyString = swfLogDto.getKeyIn();
        user.setComCode(swfLogDto.getHandleDept());
        user.setComName(swfLogDto.getDeptName());
        //Ŀǰ�ڽӿ��У����˫��û��д���ǵ�ҵ��⣬��ô����������棬����Ѿ�д�����ǵ�ҵ��⣬��ôֻҪ���湤�������ݾͿ�����
        //uiCompensateAction.approve(compensateNo,user.getUserCode(),underWriteFlag);
        //����ɹ��Ļ������ڹ���������ô����Ҫ�ύ�����������û�о�����

        WorkFlowDto workFlowDto = getWorkFlowDto(user, swfLogFlowID, swfLogLogNo, "4", keyString, keyString, keyString,
                compensateNo, true);
        if (workFlowDto == null){
            return -5;
        }
        //׷�����
        AddNotionToWorkFlowDto(workFlowDto, swfLogFlowID, swfLogLogNo, notionInfo);
                             /**********************�Զ��᰸��ʼ**********************/
        //�����㰸��
        UIBillAction uiBillAction = new UIBillAction();
        String tableName = "prplcaseno";
        String comCode = user.getComCode();
        String strRiskCode = swfLogDto.getRiskCode();
        String riskCode = BusinessRuleUtil.getRiskCode(swfLogDto.getRegistNo(),"RegistNo");
        if(!strRiskCode.equals(riskCode)){
        	riskCode=strRiskCode;
        	
        }
        int year = DateTime.current().getYear();
        String caseNo = uiBillAction.getNo(tableName, riskCode, comCode, year);
        httpServletRequest.getSession().setAttribute("caseNo", caseNo);
        httpServletRequest.getSession().setAttribute(caseNo, "caseNo");
        //�᰸����
        EndcaseDto endcaseDto = new EndcaseDto();
        
        String claimNo = compensateDto.getPrpLcompensateDto().getClaimNo();
        String conditions = "claimNo ='" + claimNo.trim() + "'";
        //�ⰸ����
        ArrayList prpLperpayDtoList = new ArrayList();
        ArrayList arraylist = (ArrayList) uiCompensateAction.findByConditions(conditions);
        if (arraylist != null) {
            for (int i = 0; i < arraylist.size(); i++) {
                PrpLcaseNoDto prpLcaseNoDto = new PrpLcaseNoDto();
                PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
                prpLcompensateDto = (PrpLcompensateDto) arraylist.get(i);
                prpLcompensateDto.setCaseNo(caseNo);
                prpLcaseNoDto.setCertiNo(prpLcompensateDto.getCompensateNo());
                prpLcaseNoDto.setCertiType("C");
                prpLcaseNoDto.setCaseNo(caseNo);
                prpLcaseNoDto.setFlag("");
                prpLcaseNoDto.setClaimNo(claimNo.trim());
                prpLperpayDtoList.add(prpLcaseNoDto);
            }
        }
        endcaseDto.setPrpLcaseNoDtoList(prpLperpayDtoList);
        endcaseDto.setPrpLcompensateDtoList(arraylist);
      //��ȡδ������Ϣbegin
        //���ɻط���Ϣ
      		BLPrplreturnvisitswflogFacade blPrplreturnvisitswflogFacade = new BLPrplreturnvisitswflogFacade();
      		DAAReturnVisitViewHelper daaReturnVisitViewHelper = new DAAReturnVisitViewHelper();
      		String registNo =  swfLogDto.getRegistNo();   		      		
      		PrplreturnvisitswflogDto prplreturnvisitswflog = blPrplreturnvisitswflogFacade.findByPrimaryKey(registNo, "endca");
      		if(prplreturnvisitswflog == null){
      			PrplreturnvisitswflogDto prplreturnvisitswflogDto = daaReturnVisitViewHelper.setReturnVisitSwflogDto(httpServletRequest, registNo, "endca", "0",user);
      			endcaseDto.setPrplreturnvisitswflogDto(prplreturnvisitswflogDto);
      		}
        //ȡ��������Ϣ
      		
        UIClaimAction uIClaimAction = new UIClaimAction();
        ClaimDto claimDto = uIClaimAction.findByPrimaryKey(claimNo);
        //ȡ�ý᰸���� 2005-08-05
        ArrayList prpLltextList = claimDto.getPrpLltextDtoList();
        ArrayList prpLltextListNew = new ArrayList();
        for (int i = 0; i < prpLltextList.size(); i++) {
        	PrpLltextDto prpLltextDto = (PrpLltextDto) prpLltextList.get(i);
        	if (prpLltextDto.getTextType().equals("08")) {   //ֻ������08��Ϊ�᰸����
        		prpLltextListNew.add(prpLltextDto);
        	}
        }
        endcaseDto.setPrpLltextDtoList(prpLltextListNew);
        
        PrpLclaimDto prpLclaimDto = claimDto.getPrpLclaimDto();
        prpLclaimDto.setCaseNo(caseNo);
        //�ؿ��ⰸ������ԭ�еĽ᰸ʱ��
        if(prpLclaimDto.getEndCaseDate() == null || prpLclaimDto.getEndCaseDate().isEmpty()){
            prpLclaimDto.setEndCaseDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));
        }
        prpLclaimDto.setEndCaserCode(user.getUserCode());
        endcaseDto.setPrpLclaimDto(prpLclaimDto);
        

        if(caseNo != null){
            /*---------------------״̬����prpLclaimStatus------------------------------------*/
        	System.out.println("------����prpLclaimStatus��Ϣ");
        	
            PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
            prpLclaimStatusDto.setStatus("4");            
            prpLclaimStatusDto.setBusinessNo(caseNo.trim());
            prpLclaimStatusDto.setPolicyNo(prpLclaimDto.getPolicyNo());
            prpLclaimStatusDto.setRiskCode(riskCode);
            prpLclaimStatusDto.setNodeType("endca");
            prpLclaimStatusDto.setSerialNo(0);
            //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���᰸��                        
            prpLclaimStatusDto.setHandlerCode(user.getUserCode());
            prpLclaimStatusDto.setInputDate(new DateTime(new Date(),DateTime.YEAR_TO_DAY));
            prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
            endcaseDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
        }
        
        //����᰸��Ϣ
        //modify by zhaolu 200608010 start
        UIEndcaseAction uiEndcaseAction = new UIEndcaseAction(); 
        try{
        uiEndcaseAction.save(endcaseDto);
        }catch(Exception ex)
        {
        	return -10;
        }
        //modify by zhaolu 200608010 start
        
        /** *******************�Զ��᰸����******************** */
        System.out.println("/** *******************�Զ��᰸����******************** */");

        //lixiang
       //���˹������̣��������Զ��᰸��Ҫ����endcaseFacade( workflowDto).
        System.out.println("****ֻ���˹������̣��������Զ��᰸��Ҫ����endcaseFacade( workflowDto).");
        uiWorkFlowAction.deal(workFlowDto);
        //ҵ�����������Ϳ����ˡ����Ǵ�ҵ���У�д�᰸���ݣ����ҿ����Զ������᰸�����Ĺ��̣�д�����
         //modify by zhaolu 200608010 end
        System.out.println("passVericAndCloseFlow");
        //add by kangzhen start 061125
        //reason �Զ��᰸��û����swflog���е�keyout�ֶθ�ֵ�������������̲�ѯ����ʾ����Ϣ��ȫ���������Ӹ�keyout�ֶεĸ�ֵ
        UIWorkFlowAction lastuiWorkFlowAction = new UIWorkFlowAction();
        
        //by dongkun �޸��Զ��᰸ʱ�Ľ᰸�ڵ��keyout�洢��begin==========
        //�޸�ǰ��logno���ֵ��Ӧ�Ľڵ��keyout�ֶ�Ϊ��ʱ�Ŵ档
        //�޸ĺ����ҵ��᰸�ڵ㣬���޸ĸýڵ��keyout�ֶ�
        
//        int logMaxNo = lastuiWorkFlowAction.getSwfLogMaxLogNo(swfLogFlowID)-1;//��ʱswflog���Ѿ�û������logMaxNo=0
//        SwfLogDto lastSwfLogDto = lastuiWorkFlowAction.findNodeByPrimaryKey(swfLogFlowID,logMaxNo);
//        if(lastSwfLogDto != null ){
//        	if(lastSwfLogDto.getKeyOut()==null||lastSwfLogDto.getKeyOut().trim().length()<=0){//lastSwfLogDto.getKeyOut()=609083700002018000007-001
//            	lastSwfLogDto.setKeyOut(caseNo);
//            	BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
//            	blSwfLogFacade.updateStatus(lastSwfLogDto);
//        	}
//        }else{
//        	BLSwfLogStoreFacade blSwfLogStoreFacade = new BLSwfLogStoreFacade();
//        	logMaxNo = blSwfLogStoreFacade.getMaxLogNo(swfLogFlowID) -1;
//        	SwfLogStoreDto lastSwfLogStoreDto =  blSwfLogStoreFacade.findByPrimaryKey(swfLogFlowID,logMaxNo);
//        	if(lastSwfLogStoreDto != null && (lastSwfLogStoreDto.getKeyOut()==null||lastSwfLogStoreDto.getKeyOut().trim().length()<=0)){
//        		lastSwfLogStoreDto.setKeyOut(caseNo);
//            	blSwfLogStoreFacade.update(lastSwfLogStoreDto);
//            }
//        }
        String conditions2 = " flowid= '"+swfLogFlowID+"' and nodeType = 'endca' ";
        ArrayList<SwfLogDto> endcaSwfLogDtoList = (ArrayList)lastuiWorkFlowAction.findNodesByConditions(conditions2);
        	if(endcaSwfLogDtoList != null && endcaSwfLogDtoList.size() != 0 ){
        		for(int i=0;i<endcaSwfLogDtoList.size();i++){
        			SwfLogDto endcaSwfLogDto = endcaSwfLogDtoList.get(i);
        			if(endcaSwfLogDto.getKeyOut()==null||endcaSwfLogDto.getKeyOut().trim().length()<=0){//lastSwfLogDto.getKeyOut()=609083700002018000007-001
        				endcaSwfLogDto.setKeyOut(caseNo);
        				BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
        				blSwfLogFacade.updateStatus(endcaSwfLogDto);
        			}
        		}
            }else{
            	BLSwfLogStoreFacade blSwfLogStoreFacade = new BLSwfLogStoreFacade();
            	ArrayList<SwfLogStoreDto> endcaSwfLogStoreDtoList = (ArrayList)blSwfLogStoreFacade.findByConditions(conditions2);
            	for(int j=0;j<endcaSwfLogStoreDtoList.size();j++){
            		SwfLogStoreDto endcaSwfLogStoreDto = endcaSwfLogStoreDtoList.get(j);
            		if(endcaSwfLogStoreDto != null && (endcaSwfLogStoreDto.getKeyOut()==null||endcaSwfLogStoreDto.getKeyOut().trim().length()<=0)){
            			endcaSwfLogStoreDto.setKeyOut(caseNo);
            			blSwfLogStoreFacade.update(endcaSwfLogStoreDto);
            		}
            	}
            }
      //by dongkun �޸��Զ��᰸ʱ�Ľ᰸�ڵ��keyout�洢��end==========
        
        BLSwfFlowMainFacade blSwfFlowMainFacade = new BLSwfFlowMainFacade();
        SwfFlowMainDto  swfFlowMainDto = blSwfFlowMainFacade.findByPrimaryKey(swfLogFlowID);
        ArrayList endSwfLogDtoList = new ArrayList();
        String condition = "flowId = '" + swfLogFlowID + "' and businessno = '"+ claimNo +"' and nodeType = 'endca' and nodeStatus!='4'"; 
        SwfLogDto swfLogDtoTemp = null;
        SwfLogStoreDto swfLogStoreDtoTemp = null;
        if(!"1".equals(swfFlowMainDto.getStoreFlag())){
            endSwfLogDtoList = (ArrayList)lastuiWorkFlowAction.findNodesByConditions(condition);
            for(Iterator it = endSwfLogDtoList.iterator();it.hasNext();){
            	swfLogDtoTemp =  new SwfLogDto();
            	swfLogDtoTemp = (SwfLogDto) it.next();
            	swfLogDtoTemp.setNodeStatus("4");
            	swfLogDtoTemp.setHandlerName("�Զ��᰸");
            	lastuiWorkFlowAction.updateFlow(swfLogDtoTemp);
            }      
        }else{
        	endSwfLogDtoList = (ArrayList)lastuiWorkFlowAction.findStoreNodesByConditions(condition);
            for(Iterator it = endSwfLogDtoList.iterator();it.hasNext();){
            	swfLogDtoTemp =  (SwfLogDto) it.next();
            	swfLogStoreDtoTemp =  new SwfLogStoreDto();
            	PropertyUtils.copyProperties(swfLogStoreDtoTemp, swfLogDtoTemp);
            	swfLogStoreDtoTemp.setNodeStatus("4");
            	swfLogStoreDtoTemp.setHandlerName("�Զ��᰸");
            	lastuiWorkFlowAction.updateStoreFlow(swfLogStoreDtoTemp);
            }      
        }
    
        //add by kangzhen end 061125
        //reason:�����Ԥ��,�����ͨ��ʱ�Ѿ������˽᰸�ڵ�,�����ｫ�ڵ���Ϊ�Ѵ���
        
         //ɽ�������շ���Ԥ���᰸�Ǽǽӿڽ���begin
		 String groupFlag = "";
		 String strPolicyNo = prpLclaimDto.getPolicyNo();//��ȡ������
		 boolean isSuccess = false;
		 String upComCode = new BLPrpDcompany().getDaaPlatformComCode(prpLclaimDto.getComCode());
		 if(AppConfig.get("sysconst.SDACCI_RISKCODE").indexOf(prpLclaimDto.getRiskCode())>-1 && "370000".equals(upComCode)){
			 DBManager dbManager = new DBManager();
			 System.out.println("----ɽ�������շ���Ԥ���᰸�Ǽǽӿڵ���,claimNo= " + prpLclaimDto.getClaimNo() +" ----");
			 //���ݱ���������ѯ������Ϣ,�жϸñ����Ƿ�Ϊ�ŵ�
			 BLPrpCmain blPrpCmain = new BLPrpCmain();
			 blPrpCmain.getData(strPolicyNo);	
			 try {	
			 	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			 	if("01".equals(blPrpCmain.getArr(0).getPolicyType())){
					groupFlag = "0";//����
				}else if("02".equals(blPrpCmain.getArr(0).getPolicyType())){
					groupFlag = "1";//����
				}
			 	isSuccess = BLCIClaimAcciSdPlatFormInterfaceFacade.getInstance().upload(dbManager, "L02", claimNo, groupFlag);
			 	if(isSuccess){
				    user.setUserMessage(user.getUserMessage() + "<br>ɽ�������շ���Ԥ���᰸�Ǽǽӿ��ϴ��ɹ�!");
				}else{
					user.setUserMessage(user.getUserMessage() + "<br>ɽ�������շ���Ԥ���᰸�Ǽǽӿ��ϴ�ʧ��!");
				}
			} catch (Exception e) {
				e.printStackTrace();								
				throw new Exception(e.getMessage() + "ɽ�������շ���Ԥ���᰸�Ǽǽӿ��ϴ�ʧ��!");
			}finally{
				dbManager.close();
			}
		}
		//ɽ�������շ���Ԥ���᰸�Ǽǽӿڽ���end
        return checkFlag;
    }
    /**
     * ����ڵ��ͨ�����ؿ��ⰸ�Զ��᰸��
     * @param LflowID String ���⹤��������
     * @param LlogNo int ���⹤�����ڵ����
     * @param businessNo String ҵ�����
     * @param notionInfo String ������� ��Ա�� ʱ��ʱ��
     * @param handlerCode String ����Ա
     * @throws Exception
     * @return boolean
     */

    public int repassVericAndCloseFlow(HttpServletRequest httpServletRequest, String LflowID, int LlogNo,
            String compensateNo, String claimNo, String notionInfo, String handlerCode) throws Exception {

        System.out.println("----repassVericAndCloseFlow---�ؿ��ⰸ�Զ��᰸--");
        String underWriteFlag = "1";
        String swfLogFlowID = LflowID; //����������
        int swfLogLogNo = LlogNo; //������logno
        String keyString = ""; //������keyIn
        UserDto user = new UserDto(); //��Ϊ�����û��Լ������ģ�����Ŀǰ��ʱ��Ϊ���Ǽ��������
        user.setUserCode(handlerCode);
        user.setUserName("˫��ͨ��");

        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();

        SwfLogDto swfLogDto = new SwfLogDto();
        ReCaseDto recaseDto = new ReCaseDto();
        swfLogDto = checkFlowNode(swfLogFlowID, swfLogLogNo, compensateNo);
        System.out.println("%%%%%%%%%%%%%%%%%%swfLogDto%%%%%%%%%%%%%%%%%%%%%%"+swfLogDto.getLogNo());
        int checkFlag = swfLogDto.getLogNo();
        System.out.println("****checkFlag="+checkFlag);
        if (checkFlag < 0)
            return checkFlag;
        if (checkFlag == 0)
            return checkFlag;
        keyString = swfLogDto.getKeyIn();
        user.setComCode(swfLogDto.getHandleDept());
        user.setComName(swfLogDto.getDeptName());
        
        System.out.println("****getWorkFlowDto");
        WorkFlowDto workFlowDto = getWorkFlowDto(user, swfLogFlowID, swfLogLogNo, "4", keyString, keyString, keyString,
                compensateNo, true);
        if (workFlowDto == null){
            return -5;
        }
        //׷�����
        AddNotionToWorkFlowDto(workFlowDto, swfLogFlowID, swfLogLogNo, notionInfo);
        System.out.println("********�ؿ��ⰸ�Զ��᰸��ʼ********");
        uiWorkFlowAction.deal(workFlowDto);
        //��swfflowmain�����нڵ��flowStatus��Ϊ"0" 
         SwfFlowMainDto swfFlowMainDto=uiWorkFlowAction.findFlowMainByPrimaryKey(swfLogFlowID);//��flowstatus��Ϊ1
         SwfFlowMainDto updswfFlowMainDto = new  SwfFlowMainDto();
         
         //��д�ؿ��ⰸ��(Ŀǰ�᰸ʱ���жϵڼ����ؿ��ⰸ�������û����ؿ��ⰸ��ʼʱʵ��)
         int maxSerialNo=0;
         UIRecaseAction  uiRecaseAction  =new  UIRecaseAction ();
         String conditions="claimNo ='"+claimNo+"'";
         if(uiRecaseAction.findByConditions(conditions)!=null){
             maxSerialNo =  uiRecaseAction.getMaxSerialNo(claimNo);
         }else{maxSerialNo =1;}
         recaseDto = uiRecaseAction.findByPrimaryKey(claimNo,maxSerialNo);
         PrpLrecaseDto prpLrecaseDto = recaseDto.getPrpLrecaseDto();
         
         prpLrecaseDto.setCloseCaseDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));
         prpLrecaseDto.setCloseCaseUserCode(user.getUserCode());
         recaseDto.setPrpLrecaseDto(prpLrecaseDto);
         uiRecaseAction.savePrpLrecase(recaseDto);
       //�ؿ��ⰸ�����½᰸ʱ��
//         UIClaimAction uiClaimmAction =  new  UIClaimAction();
//		 uiClaimmAction.updateEndCaseDate(claimNo, prpLrecaseDto.getCloseCaseDate());
        /** *******************�Զ��᰸����******************** */
        System.out.println("*****�ؿ��ⰸ�Զ��᰸����");
       // UIPrpLchargeDealAction uiPrpLchargeDealAction = new UIPrpLchargeDealAction();
        //if(uiPrpLchargeDealAction.chargedeal(claimNo)){System.out.println("���÷�̯��ɡ�");}
        //System.out.println("repassVericAndCloseFlow");
      //�Ϻ��⽡��ƽ̨�᰸�ӿڽ���begin
    	 PrpLclaimDto prpLclaimDto = recaseDto.getPrpLclaimDto();
		 boolean isYJXFlag = false;
		 String groupFlag = "";
		 String strPolicyNo = prpLclaimDto.getPolicyNo();//��ȡ������
		 boolean isSuccess = false;
		 if("26,27,28".indexOf(prpLclaimDto.getRiskCode().substring(0,2)) > -1){
		  	isYJXFlag = true;
		 }
		 String upComCode = new BLPrpDcompany().getDaaPlatformComCode(prpLclaimDto.getComCode());
		 if(isYJXFlag && "310000".equals(upComCode)){
			 DBManager dbManager = new DBManager();
			 System.out.println("------------------�Ϻ�ƽ̨�⽡�ս᰸�ӿڵ���,claimNo= " + prpLclaimDto.getClaimNo() +" --------------------------");
			 //���ݱ���������ѯ������Ϣ,�жϸñ����Ƿ�Ϊ�ŵ�
			 BLPrpCmain blPrpCmain = new BLPrpCmain();
			 blPrpCmain.getData(strPolicyNo);	
			 try {	
			 	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			 	//����prpcmain.groupNo�Ƿ�Ϊ���ж��Ƿ�Ϊ�ŵ�
			 	if("01".equals(blPrpCmain.getArr(0).getPolicyType())){
					groupFlag = "0";//����
					isSuccess = BLCIClaimPropPlatFormInterfaceFacade.getInstance().upload(dbManager, "C01", "03", prpLclaimDto.getClaimNo(),strPolicyNo,groupFlag,upComCode);
				}else if("02".equals(blPrpCmain.getArr(0).getPolicyType())){
					groupFlag = "1";//����
					isSuccess = BLCIClaimPropPlatFormInterfaceFacade.getInstance().upload(dbManager, "C04", "03", prpLclaimDto.getClaimNo(),strPolicyNo,groupFlag,upComCode);
				}
			} catch (Exception e) {
				e.printStackTrace();								
				throw new Exception(e.getMessage() + "�⽡���ϴ�ƽ̨ʧ��,�᰸�Ǽ�ʧ��!");
			}finally{
				dbManager.close();
			}
		}
		//�Ϻ��⽡��ƽ̨�᰸�ӿڽ���end
		//ɽ�������շ���Ԥ���᰸�Ǽǽӿڽ���begin
		 if(AppConfig.get("sysconst.SDACCI_RISKCODE").indexOf(prpLclaimDto.getRiskCode())>-1 && "370000".equals(upComCode)){
			 DBManager dbManager = new DBManager();
			 System.out.println("----ɽ�������շ���Ԥ���᰸�Ǽǽӿڵ���,claimNo= " + prpLclaimDto.getClaimNo() +" ----");
			 //���ݱ���������ѯ������Ϣ,�жϸñ����Ƿ�Ϊ�ŵ�
			 BLPrpCmain blPrpCmain = new BLPrpCmain();
			 blPrpCmain.getData(strPolicyNo);	
			 try {	
			 	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			 	if("01".equals(blPrpCmain.getArr(0).getPolicyType())){
					groupFlag = "0";//����
				}else if("02".equals(blPrpCmain.getArr(0).getPolicyType())){
					groupFlag = "1";//����
				}
			 	isSuccess = BLCIClaimAcciSdPlatFormInterfaceFacade.getInstance().upload(dbManager, "L02", claimNo, groupFlag);
			 	if(isSuccess){
				    user.setUserMessage(user.getUserMessage() + "<br>ɽ�������շ���Ԥ���᰸�Ǽǽӿ��ϴ��ɹ�!");
				}else{
					user.setUserMessage(user.getUserMessage() + "<br>ɽ�������շ���Ԥ���᰸�Ǽǽӿ��ϴ�ʧ��!");
				}
			} catch (Exception e) {
				e.printStackTrace();								
				throw new Exception(e.getMessage() + "ɽ�������շ���Ԥ���᰸�Ǽǽӿ��ϴ�ʧ��!");
			}finally{
				dbManager.close();
			}
		}
		//ɽ�������շ���Ԥ���᰸�Ǽǽӿڽ���end
        return checkFlag;
    }

    /**
     * ������������ǲ��ǺϷ�
     * 
     * @param flowID String
     * @param logNo int
     * @param businessNo String
     * @param swfLogDto SwfLogDto
     * @throws Exception
     * @return int
     */
    private SwfLogDto checkFlowNode(String flowID, int logNo, String businessNo) throws Exception {
        //��鹤�����Ƿ�Ϸ�����
        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        System.out.println("flowID="+flowID);
        System.out.println("logNo="+logNo);
        System.out.println("businessNo="+businessNo);
        SwfLogDto swfLogTemp = uiWorkFlowAction.findNodeByPrimaryKey(flowID, logNo);
        SwfLogDto swfLogDto = new SwfLogDto();
        //û��ѯ�����������д���
        if (swfLogTemp == null) {
            swfLogDto.setLogNo(-1);
            System.out.println("û��ѯ�����������д���");
            return swfLogDto;
        }
        //ҵ��Ų�������������ϵ�ҵ����룬ֱ�ӷ���false
        if (!swfLogTemp.getBusinessNo().equals(businessNo)) {
            swfLogDto.setLogNo(-2);
            System.out.println("ҵ��Ų�������������ϵ�ҵ�����");
            return swfLogDto;
        }
        //�Ѿ����˹���
        if (swfLogTemp.getNodeStatus().equals("5")) {
            swfLogDto.setLogNo(-3);
            System.out.println("�Ѿ����˹��˵İ���");
            return swfLogDto;
        }

        //�Ѿ��ύ���ˣ�ֱ�ӷ���ture
        if (swfLogTemp.getNodeStatus().equals("4")) {
            swfLogDto.setLogNo(0);
            System.out.println("�Ѿ��ύ���˵İ���");
            return swfLogDto;
        }

        swfLogDto = swfLogTemp;

        //û�������
        return swfLogDto;
    }
    /**
     * ����dto
     * 
     * @param user UserDto
     * @param flowID String
     * @param logNo int
     * @param nodeStatus String
     * @param nextBusinessNo String
     * @param keyIn String
     * @param keyOut String
     * @param wclose boolean
     * @throws Exception
     * @return WorkFlowDto
     */
    private WorkFlowDto getWorkFlowDto(UserDto user, String flowID, int logNo, String nodeStatus, String businessNo,
            String nextBusinessNo, String keyIn, String keyOut, boolean wclose) throws Exception {
        WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        SwfLogDto swfLogDtoDealNode = new SwfLogDto();
        swfLogDtoDealNode.setFlowID(flowID);
        swfLogDtoDealNode.setLogNo(logNo);
        swfLogDtoDealNode.setNodeStatus(nodeStatus);
        swfLogDtoDealNode.setBusinessNo(businessNo);//���������/�⸶�����
        swfLogDtoDealNode.setNextBusinessNo(nextBusinessNo);
        swfLogDtoDealNode.setKeyIn(keyIn);
        swfLogDtoDealNode.setKeyOut(keyOut);
        WorkFlowDto workFlowDto = new WorkFlowDto();
        if (nodeStatus.equals("5")) { //����
            //��ѯ������״̬��Ϣ,�������룬���ڳ�ʼ������ʾ
            workFlowDto = workFlowViewHelper.getBackFlowInfo(user, flowID, logNo);
        } else {
            workFlowDto = workFlowViewHelper.viewToDto(user, swfLogDtoDealNode);
        }
        if (wclose) {
            //�رղ���
            SwfFlowMainDto swfFlowMainDto = new SwfFlowMainDto();
            swfFlowMainDto = uiWorkFlowAction.findFlowMainByPrimaryKey(flowID);
            if (swfFlowMainDto != null) {
                swfFlowMainDto.setCloseDate(new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY));
                swfFlowMainDto.setFlowStatus("0");
            }
            workFlowDto.setCloseSwfFlowMainDto(swfFlowMainDto);
            workFlowDto.setClose(true);
            //����submit�е�swflogΪ���ύ
            if (workFlowDto.getSubmit()) {
                if (workFlowDto.getSubmitSwfLogDtoList() != null) {
                    ArrayList nodeList = workFlowDto.getSubmitSwfLogDtoList();
                    ArrayList nodeLastList = new ArrayList();
                    //���õ��ύ�ڵ㶼�Զ�������
                    for (int i = 0; i < nodeList.size(); i++) {
                        SwfLogDto swfLogDto = (SwfLogDto) nodeList.get(i);
                        swfLogDto.setHandlerName("�Զ��᰸");
                        swfLogDto.setNodeStatus("4");
                        nodeLastList.add(swfLogDto);
                    }
                    workFlowDto.setSubmitSwfLogDtoList(nodeLastList);
                }
            }
            //���ڽ᰸�ǿ����ж���᰸�ģ����Ե��жϻ�����û�йرյĽ᰸�������̲�������
            //�ȴ����еĽ᰸�����ʱ�����̲Ž�����
            String conditonss   = "flowId='"+flowID +"' and nodeType='claim' and nodestatus <> '6'";
     		String conditions1  = "flowId='"+flowID +"' and endflag='1' and nodestatus='4'";
     		String conditions2  = "flowId='"+flowID +"' and nodeType='compe' and nodestatus <> '5'";
     		String conditions3  = "flowId='"+flowID +"' and endflag='1' ";
     		//���Ҹð�������ڵ���
     		ArrayList claimList = (ArrayList)uiWorkFlowAction.findNodesByConditions(conditonss);
     		//���Ҹð����ѽ����Ľڵ���
     		ArrayList endList   = (ArrayList)uiWorkFlowAction.findNodesByConditions(conditions1);
     		//��������ڵ���
     		ArrayList compeList   = (ArrayList)uiWorkFlowAction.findNodesByConditions(conditions2);
     		//���Ҹð��Ľ᰸�ڵ���
     		ArrayList endList1 = (ArrayList)uiWorkFlowAction.findNodesByConditions(conditions3);
     		
     		// add by dongkun �����ⰸ�ĺ����������ͨ������������workflowdto���ܹرյ�bug   begin=================
     		String conditions4  = "flowId='"+flowID +"' and nodeType='speci' ";
     		//���Ҹð����Ƿ��������ⰸ����
     		ArrayList speciList = (ArrayList)uiWorkFlowAction.findNodesByConditions(conditions4);
     		//���跢�ֻ�û�н��갸�ӵ����̣��򲻽����̽�����
     		//ֻ�ǹرյ�Ŀǰ��������ص��Ǹ����㣬ֱ�ӷ������е�workFlowDto.         		
     		if ( (claimList !=null && endList != null && claimList.size() - endList.size() >1) ||
        			 (compeList !=null && endList != null && compeList.size() - endList.size() >1 ) ||
        			 (endList1 != null && endList != null && endList1.size() - endList.size() >0 && speciList.size()==0)
          			){
     			workFlowDto.setClose(false);
     		}
     		

        }
        if (!workFlowViewHelper.checkDealDto(workFlowDto))
            return null;
        return workFlowDto;
    }
    /**
     * ׷��������Ϣ
     * 
     * @param workFlowDto WorkFlowDto
     * @param flowID String
     * @param logNo int
     * @param notion String
     * @throws Exception
     * @return WorkFlowDto
     */
    private WorkFlowDto AddNotionToWorkFlowDto(WorkFlowDto workFlowDto, String flowID, int logNo, String notion)
            throws Exception {
        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        int maxLineNo = uiWorkFlowAction.getSwfNotionMaxLineNo(flowID, logNo);
        SwfNotionDto swfNotionDto = new SwfNotionDto();
        swfNotionDto.setFlowID(flowID);
        swfNotionDto.setLogNo(logNo);
        swfNotionDto.setLineNo(maxLineNo);
        if (notion.length() > 70)
            notion = notion.substring(0, 65) + "...";
        swfNotionDto.setHandleText(notion);
        ArrayList notionList = new ArrayList();
        notionList.add(swfNotionDto);
        workFlowDto.setSwfNotionDtoList(notionList);
        return workFlowDto;
    }

}

