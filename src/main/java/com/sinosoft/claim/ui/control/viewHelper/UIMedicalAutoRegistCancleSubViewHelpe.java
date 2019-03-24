package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.gyic.claim.bl.facade.BLPrplcompensateearFacade;
import com.sinosoft.claim.bl.action.custom.BLClaimAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLRegistRPolicyAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLclaimAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterCancelClaimDetailAction;
import com.sinosoft.claim.bl.action.domain.BLPrplinterAutoClaimDetailAction;
import com.sinosoft.claim.bl.action.domain.BLSwfLogAction;
import com.sinosoft.claim.bl.facade.BLDangerUnitFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterCancelClaimDetailFacade;
import com.sinosoft.claim.bl.facade.BLPrplcompensatehouseFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterAutoClaimDetailFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpCitemCarDto;
import com.sinosoft.claim.dto.domain.PrpCmainCargoDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLextDto;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimRequestDto;
import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.ICollections;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UICheckAction;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIExchAction;
import com.sinosoft.claim.ui.control.action.UIPrpLregistRPolicyAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIRiskUnitAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.facade.UIWorkFlowApprovalInterFaceFacade;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.prpall.pubfun.PubTools;
import com.sinosoft.reins.out.dto.domain.PrpLdangerUnitDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.undwrt.bl.facade.BLWfCheckAdvanceFacade;
import com.sinosoft.undwrt.bl.facade.BLWfLogFacade;
import com.sinosoft.undwrt.dto.domain.UwNotionDto;
import com.sinosoft.undwrt.dto.domain.WfLogDto;
import com.sinosoft.undwrt.ui.control.action.UICommonDealSubmitAction;
import com.sinosoft.undwrt.ui.control.action.UIWflogQueryAction;
import com.sinosoft.undwrt.ui.model.UwNotionSaveNotionCommand;
import com.sinosoft.utiall.dbsvr.DBPrpDcompany;
import com.sinosoft.utiall.dbsvr.DBPrpDuser;
import com.sinosoft.utility.SysConfig;

/**
 * ����ע����
 * */
public class UIMedicalAutoRegistCancleSubViewHelpe {
	/**
	 * ����ע���߼�
	 * @param prpLinterRequestDto
	 * @return
	 * @throws Exception
	 */
	public PrpLinterCancelClaimRequestDto autoRegistCancel(PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto) throws Exception{
		PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto = new PrpLinterCancelClaimDetailDto();
		//��װuser���󣬷������ʹ��
		UserDto user = new UserDto();
		user.setUserCode(prpLinterCancelClaimRequestDto.getOperatorCode());
		user.setUserName(prpLinterCancelClaimRequestDto.getOperatorName());
		user.setComCode(prpLinterCancelClaimRequestDto.getMakeCom());
		user.setComName(prpLinterCancelClaimRequestDto.getMakeComName());
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
	    UIRegistAction uiRegistAction = new UIRegistAction();
	    UIClaimAction uiClaimAction = new UIClaimAction();
		DBManager dbManager = new DBManager();
		dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;

	    try {
	       //��ʼ����
		   dbManager.beginTransaction();
		   String id = prpLinterCancelClaimRequestDto.getId();
		   BLPrpLinterCancelClaimDetailAction blPrpLinterCancelClaimDetailAction = new BLPrpLinterCancelClaimDetailAction();
		   prpLinterCancelClaimDetailDto.setId(id);
		   prpLinterCancelClaimDetailDto.setRegistNo(prpLinterCancelClaimRequestDto.getRegistNo());
	    	
		   String registNo = prpLinterCancelClaimRequestDto.getRelationRegistNo();
		   if(registNo==null || "".equals(registNo)){
			   registNo = prpLinterCancelClaimDetailDto.getRegistNo();
		   }
	       RegistDto registDto = this.cancelViewToDto(prpLinterCancelClaimRequestDto, user, registNo);
	       
	       //������������ע����Ϣ
	       WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
	       //����Ϊ������ʹ���е�
	       //�õ����̱��
	       String swfLogFlowID = uiWorkFlowAction.findFlowIDByRegistNo(registDto.getPrpLregistDto().getRegistNo());
	       String swfLogLogNo = "1"; //������logno�a��Ϊ1
	       SwfLogDto swfLogDtoDealNode = new SwfLogDto();
	       
	       String uploadUpolicyNo = "";
	       
	       //��Ҫ����Ƿ����Ѿ������ģ����������������������������
	       String strSql = "registNo='"+registDto.getPrpLregistDto().getRegistNo()+"' and canceldate is null ";
	       Collection claimList =uiClaimAction.findByConditions(strSql);
	       if (claimList!=null&&claimList.size() >0){
		       String msg = "�˱���Ŀǰ��"+claimList.size()+"�����Ѿ�������������˱���������ע�����ٽ��б�����ȫ��ע����";
		       throw new UserException(1,3,"����ע��",msg);
		   }
	       if (swfLogFlowID!=null && swfLogLogNo!=null&&!swfLogFlowID.equals("null")&& !swfLogLogNo.equals("null")){
	             swfLogDtoDealNode.setFlowID(swfLogFlowID);
	             swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
	       }
	       swfLogDtoDealNode.setNodeStatus("4");
	       swfLogDtoDealNode.setEndFlag("1");
	       WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
	       
	       //ȡ��ǿ�ձ�����
	       String strWhere = " registNo = '" + registDto.getPrpLregistDto().getRegistNo() + "' and policyType='3' ";
	       Collection collection = new UIPrpLregistRPolicyAction().findByConditions(strWhere);
	       for(Iterator iter = collection.iterator();iter.hasNext();){
	    	   PrpLRegistRPolicyDto  prpLRegistRPolicyDto = (PrpLRegistRPolicyDto)iter.next();
	      	   uploadUpolicyNo = prpLRegistRPolicyDto.getPolicyNo();
	       }
	       if (workFlowViewHelper.checkDealDto(workFlowDto)){
	           //���ñ��ڵ�Ϊע��״̬
	           if (workFlowDto.getUpdateSwfLogDto() !=null){
	        	   workFlowDto.getUpdateSwfLogDto().setNodeStatus( "6"); //����������
	        	   workFlowDto.getUpdateSwfLogDto().setSubmitTime(prpLinterCancelClaimRequestDto.getCancelDate().toString());
	           }
	           uiRegistAction.saveRegistCancel(registDto,workFlowDto);
	       }else{
	      	   throw new Exception("���������Ϸ�");
	       }
	       
	       prpLinterCancelClaimDetailDto.setCancelSuccFlag("1");
		   prpLinterCancelClaimDetailDto.setRemark("����ע���ɹ���"+prpLinterCancelClaimDetailDto.getRegistNo());
		   blPrpLinterCancelClaimDetailAction.insert(dbManager, prpLinterCancelClaimDetailDto);
	      //�ύ����
		  dbManager.commitTransaction();
	    } catch (Exception e) {
	      dbManager.rollbackTransaction();
	      prpLinterCancelClaimDetailDto.setCancelSuccFlag("0");
		  String messege = e.toString();
		  if(messege!=null&&messege.length()>1000){
			  messege = messege.substring(0,1000);
		  }
		  prpLinterCancelClaimDetailDto.setRemark("����ע��ʧ�ܣ�"+messege);;
		  new BLPrpLinterCancelClaimDetailFacade().insert(prpLinterCancelClaimDetailDto);
	      e.printStackTrace();
	      throw e;
	    }finally{
	    	dbManager.close();//�������ݿ����ӹر�
	    }
	     
	    return prpLinterCancelClaimRequestDto;
	  }
	
	/**
     * ����ע��ʱ��������
     * @param httpServletRequest
     * @return RegistDto �������ݴ������ݽṹ
     * @throws Exception
     */
     public RegistDto cancelViewToDto(PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto,UserDto user,String registNo) throws Exception{
       
       //��ʼ������
       int RULE_LENGTH = 70; //rule�ֶεĳ���  
       RegistDto registDto = new RegistDto ();
       String msg = "";
       UIRegistAction uiRegistAction = new UIRegistAction();
       
       //�õ�������
       String strRegistNo =  registNo;
       //  �жϱ��������Ƿ����
       if (!uiRegistAction.isExist(strRegistNo)){
       	   msg = "û�н��յ��Ϸ��ı����ţ�";
           throw new UserException(1,3,"����ע��",msg);
       }
       
       //�õ���������
       registDto = uiRegistAction.findByPrimaryKey(strRegistNo);
       
       //�ռ�����ע��ԭ��
      
       ArrayList<PrpLregistTextDto> prpLregistTextDtoList = new ArrayList<PrpLregistTextDto>();
       String context = prpLinterCancelClaimRequestDto.getCancelContext();
       if(context != null && context.length()>0){
           String[] rules = StringUtils.split(context, RULE_LENGTH);
           //�õ����Ӵ�,���潫���зֵ�����
           for (int k = 0; k < rules.length; k++) {
               PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
               prpLregistTextDto.setRegistNo(registNo);
               prpLregistTextDto.setContext(rules[k]);
               prpLregistTextDto.setLineNo(k + 1);
               prpLregistTextDto.setTextType("2");
               prpLregistTextDtoList.add(prpLregistTextDto);
           }
       }
       
       //װ��RegistDto
       registDto.setPrpLregistTextDtoList(prpLregistTextDtoList);
       
       //���ñ�����Ϣ
       PrpLregistDto prpLregistDto = registDto.getPrpLregistDto() ;

       prpLregistDto.setCancelDate(new DateTime(prpLinterCancelClaimRequestDto.getCancelDate()));
       prpLregistDto.setDealerCode(prpLinterCancelClaimRequestDto.getDealerCode());
       prpLregistDto.setCancelReason(prpLregistDto.getCancelReason());
       prpLregistDto.setCancelReasonName(prpLregistDto.getCancelReasonName());
       prpLregistDto.setReportorName(prpLregistDto.getReportorName());
       registDto.setPrpLregistDto(prpLregistDto);
       if(registDto.getPrpLRegistRPolicyList()!=null){
    	   for(int i=0;i<registDto.getPrpLRegistRPolicyList().size();i++){
    		 PrpLRegistRPolicyDto  prpLRegistRPolicyDto=(PrpLRegistRPolicyDto)registDto.getPrpLRegistRPolicyList().get(i);
	         prpLRegistRPolicyDto.setRegistValidStatus("0");
	         prpLRegistRPolicyDto.setValidStatus("0");
		     prpLRegistRPolicyDto.setCancelOperaterCode(user.getUserCode());
		     prpLRegistRPolicyDto.setCancelComCode(user.getComCode());
		     prpLRegistRPolicyDto.setCancelReason(registDto.getPrpLregistDto().getCancelReason());
		     prpLRegistRPolicyDto.setCancelReasonName(registDto.getPrpLregistDto().getCancelReasonName());
		     prpLRegistRPolicyDto.setCancelDate(registDto.getPrpLregistDto().getCancelDate().toString());
		     registDto.getPrpLRegistRPolicyList().set(i, prpLRegistRPolicyDto);
    	   }
       }
       return registDto;
   }

     
     
     /**
 	 * ����ע�������߼�
 	 * @param prpLinterRequestDto
 	 * @return
 	 * @throws Exception
 	 */
 		PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto = new PrpLinterCancelClaimDetailDto();
 		public PrpLinterCancelClaimRequestDto autoClaimCancel(PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto) throws Exception{
 		//��װuser���󣬷������ʹ��
 		UserDto user = new UserDto();
 		user.setUserCode(prpLinterCancelClaimRequestDto.getOperatorCode());
 		user.setUserName(prpLinterCancelClaimRequestDto.getOperatorName());
 		user.setComCode(prpLinterCancelClaimRequestDto.getMakeCom());
 		user.setComName(prpLinterCancelClaimRequestDto.getMakeComName());
 		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
 	    UIRegistAction uiRegistAction = new UIRegistAction();
 	    UIClaimAction uiClaimAction = new UIClaimAction();
 	    DAAClaimViewHelper daaClaimViewHelper = new DAAClaimViewHelper();
 		DBManager dbManager = new DBManager();
 		String msg = "";
 		prpLinterCancelClaimDetailDto.setId(prpLinterCancelClaimRequestDto.getId());
		prpLinterCancelClaimDetailDto.setPolicyNo(prpLinterCancelClaimRequestDto.getPolicyno());
		prpLinterCancelClaimDetailDto.setRegistNo(prpLinterCancelClaimRequestDto.getRegistNo());
 		dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
 		int RULE_LENGTH = 70;
 	    try {
 	       //��ʼ����
 		   dbManager.beginTransaction();
 		
 		  String caseType = prpLinterCancelClaimRequestDto.getCaseType();
 		  ClaimDto claimDto = new ClaimDto();
          
          String outRegistNo = prpLinterCancelClaimRequestDto.getOutRegistNo();

          String claimNo  = prpLinterCancelClaimRequestDto.getClaimNo();
          String registNo= prpLinterCancelClaimRequestDto.getRegistNo();
          String cancelReaseon =prpLinterCancelClaimRequestDto.getCancelContext();
          String prpCancel = prpLinterCancelClaimRequestDto.getCancelReson();
          String prpExclusions = prpLinterCancelClaimRequestDto.getCancelReson();
          /*---------------------��������prpLclaim------------------------------------*/
          PrpLclaimDto prpLclaimDto =null;
          if ((claimNo==null)||claimNo.equals(""))
          {
           msg = " �˰���û������������֪ͨ������Ա���б���ע��������";
           if ("1".equals(caseType)){
           	 msg = " �˰���û����������Ҫ֪ͨ������Ա�Ƚ��������������룡";
              
           }
           throw new UserException(1,3,"ע��/����",msg);
          }
          prpLclaimDto = claimDtoToView(prpLinterCancelClaimRequestDto, claimNo);
          
          

          if (prpLclaimDto==null)
          {
            msg = "û�в�ѯ�����������";
            throw new UserException(1,3,"����",msg);
          }
          prpLclaimDto.setFlag("0"); //ֻupdate�Ϳ����ˡ���
          
          //���õ�һ�ν���ʱ��Ĭ����Ϣ
          //prpLclaimDto.setCancelDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
          prpLclaimDto.setDealerCode(user.getUserCode() );
          prpLclaimDto.setDealerName(user.getUserName() );
          prpLclaimDto.setCancelReason(cancelReaseon);
          prpLclaimDto.setCaseType(caseType);
          if("1".equals(caseType)){
          	prpLclaimDto.setCancelReasonExplan(prpExclusions);
          }else{
          	prpLclaimDto.setCancelReasonExplan(prpCancel);
          }
          //�ù�������
          claimDto.setPrpLclaimDto(prpLclaimDto);

         /*---------------------����ע���ı���prpLltext------------------------------------*/
         ArrayList prpLltextDtoList = new ArrayList();
         PrpLltextDto prpLltextDto = null;
         String TextTemp = prpLinterCancelClaimRequestDto.getCancelContext();
         String[] rules = StringUtils.split(TextTemp, RULE_LENGTH);
         
         //�õ����Ӵ�,���潫���зֵ�����
         for (int k = 0; k < rules.length; k++) {
             prpLltextDto = new PrpLltextDto();
             prpLltextDto.setClaimNo(claimNo);
             prpLltextDto.setContext(rules[k]);
             prpLltextDto.setLineNo(k + 1);
             prpLltextDto.setTextType("10");
             prpLltextDtoList.add(prpLltextDto); 
         }

          //װ��ClaimDto
         claimDto.setPrpLltextDtoList(prpLltextDtoList);

         /*---------------------��������״̬����prpLclaimStatusĬ��Ϊ���------------------------------------*/
         PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
         prpLclaimStatusDto.setStatus("4");
         prpLclaimStatusDto.setBusinessNo(prpLclaimDto.getClaimNo() );
         prpLclaimStatusDto.setPolicyNo(prpLclaimDto.getPolicyNo());
         prpLclaimStatusDto.setNodeType("claim");

         //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��ʵ��claimstatus��

        prpLclaimStatusDto.setHandlerCode(user.getUserCode() );
        prpLclaimStatusDto.setInputDate(prpLclaimDto.getInputDate() );
        prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
        prpLclaimStatusDto.setRiskCode(prpLclaimDto.getRiskCode() );
        claimDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
        
        BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
        String swfLogFlowID = ""; //����������
        String swfLogLogNo = ""; //������logno
        ArrayList swflogList = (ArrayList)blSwfLogFacade.findByConditions("registno='"+registNo+"' and nodetype='certi'");
       
        SwfLogDto  swfLogDto= (SwfLogDto)swflogList.get(0);
        swfLogFlowID = swfLogDto.getFlowID();
        swfLogLogNo =String.valueOf(swfLogDto.getLogNo());
        
        String role = "";
        String appcode = "";
        String appname = "";  
        String username="";
        String comcode = "";
        String comname= "";
        int t = 0;
        DBPrpDuser dbPrpDuser = new DBPrpDuser();
        DBPrpDcompany dbprpDcompany = new DBPrpDcompany();
        t = dbPrpDuser.getInfo(user.getUserCode());
        username=dbPrpDuser.getUserName();
        t = dbprpDcompany.getInfo(dbPrpDuser.getComCode());
        comcode = dbPrpDuser.getComCode();
        comname= dbprpDcompany.getComCName();
        String result = "";
        
      //��ֹ����ˢ�����ύ�������ͬʱ�����ύͬһ������
		String condition = "flowId ='"+swfLogFlowID+"' and  logno= "+ swfLogLogNo+"  and nodeStatus = '4'";
	    Collection certifyNodeList = uiWorkFlowAction.findNodesByConditions(condition);
	    if(certifyNodeList!=null&&certifyNodeList.size()>0){
	    	   throw new UserException(1,3,"������","�ð���ע��/����ڵ��Ѵ���");
	    }
	    
	    WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
        SwfLogDto swfLogDtoDealNode = new SwfLogDto();
        SwfLogDto swfLogNextNode= new SwfLogDto();
        Collection nextNodeList = new ArrayList();
    	
        //����Ǽ�

        if (swfLogFlowID!=null && swfLogLogNo!=null&&!swfLogFlowID.equals("null")&& !swfLogLogNo.equals("null"))
        {
          swfLogDtoDealNode.setFlowID(swfLogFlowID);
          swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
        }
        
        swfLogDtoDealNode.setNodeType("certi");
        swfLogDtoDealNode.setNodeStatus("4");
        swfLogDtoDealNode.setBusinessNo("");
        swfLogDtoDealNode.setNextBusinessNo(claimDto.getPrpLclaimDto().getClaimNo() ); 
        
        //������ת��ע��/���������ڵ�ȥ
        swfLogNextNode.setNodeNo(0);
       
        swfLogNextNode.setNodeType("cance");
        swfLogNextNode.setKeyIn(claimDto.getPrpLclaimDto().getClaimNo());
        swfLogNextNode.setPolicyNo(claimDto.getPrpLclaimDto().getPolicyNo());
        swfLogNextNode.setRiskCode(claimDto.getPrpLclaimDto().getRiskCode());
        
        //�ж���ע�����Ǿ��⣬��Ҫ���ڹ������ϵ�
        swfLogNextNode.setTypeFlag( caseType);
        nextNodeList.add(swfLogNextNode);
        swfLogDtoDealNode.setNextNodeListType("1");//�����1��������Ҫָ����һ���ڵ�����У�������ǣ����Ǵ�ģ����Ѱ������Ľڵ�
        swfLogDtoDealNode.setSwfLogList(nextNodeList);
        //����ע��ԭ��
        UIPrpLregistRPolicyAction  uiPrpLregistRPolicyAction = new UIPrpLregistRPolicyAction(); 
        PrpLRegistRPolicyDto  prpLRegistRPolicyDto = uiPrpLregistRPolicyAction.findByPrimaryKey(claimDto.getPrpLclaimDto().getRegistNo(),claimDto.getPrpLclaimDto().getPolicyNo());
        if (prpLRegistRPolicyDto!=null ){
        	claimDto.setPrpLRegistRPolicyDto(prpLRegistRPolicyDto);
        }
        
        swfLogDtoDealNode.setKeyIn(claimDto.getPrpLclaimDto().getClaimNo() );
        swfLogDtoDealNode.setKeyOut(claimDto.getPrpLclaimDto().getClaimNo() );
        WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
        
        workFlowDto.setUpdate( false);
		workFlowDto.setUpdateSwfLogDto( null);
		
		new BLClaimAction().save(dbManager,claimDto);
	    if(workFlowDto!=null){
	        new BLWorkFlowAction().deal(dbManager,workFlowDto);
	    }    
		/************ ����ע�������ƽ̨start *****************/
		int vericLogNo = 0;
		if (workFlowDto.getSubmitSwfLogDtoList() != null
				&& workFlowDto.getSubmitSwfLogDtoList().size() > 0) {
			vericLogNo = ((SwfLogDto) workFlowDto
					.getSubmitSwfLogDtoList().get(0)).getLogNo();
		}
		
		UIWorkFlowApprovalInterFaceFacade uiWorkFlowApprovalInterFaceFacade = new UIWorkFlowApprovalInterFaceFacade();
		String UWflowID = uiWorkFlowApprovalInterFaceFacade
		                      .submitApprovalPlatform("ClaimCance", swfLogDtoDealNode.getFlowID(),String.valueOf(vericLogNo),
		                    		  claimNo, claimDto.getPrpLclaimDto().getRiskCode(), claimDto.getPrpLclaimDto().getClassCode(), 
		                    		  claimDto.getPrpLclaimDto().getComCode(), user.getUserCode(),
		                    		  claimDto.getPrpLclaimDto().getMakeCom(), user.getUserCode(), user.getUserCode(), "");
		
		if (UWflowID.length() < 15) {
		    msg = "����'" + claimNo
					+ "'�ύ˫��ϵͳʧ�ܣ��������ύ���������Ա��ϵ!";
			throw new UserException(1, 3, "������", msg);
		}
		/************ ����ע�������ƽ̨end ****************/
        
		
		   BLPrpLinterCancelClaimDetailAction blPrpLinterCancelClaimDetailAction = new BLPrpLinterCancelClaimDetailAction();
		   
		   prpLinterCancelClaimDetailDto.setClaimCancelFlag("1");
 		   prpLinterCancelClaimDetailDto.setRemark("����ע������ɹ���"+prpLinterCancelClaimDetailDto.getRegistNo());
 		   blPrpLinterCancelClaimDetailAction.insert(dbManager, prpLinterCancelClaimDetailDto);
 	      //�ύ����
 		  dbManager.commitTransaction();
          
 	    } catch (Exception e) {
 	      dbManager.rollbackTransaction();
 	      prpLinterCancelClaimDetailDto.setClaimCancelFlag("0");
 		  String messege = e.toString();
 		  if(messege!=null&&messege.length()>1000){
 			  messege = messege.substring(0,1000);
 		  }
 		  prpLinterCancelClaimDetailDto.setRemark("����ע������ʧ�ܣ�"+messege);;
 		  new BLPrpLinterCancelClaimDetailFacade().insert(prpLinterCancelClaimDetailDto);
 	      e.printStackTrace();
 	      throw e;
 	    }finally{
 	    	dbManager.close();//�������ݿ����ӹر�
 	    }
 	     
 	    return prpLinterCancelClaimRequestDto;
 	  }
 	
 	 /**
 	 * ����ע�������߼�
 	 * @param prpLinterRequestDto
 	 * @return
 	 * @throws Exception
 	 */
 	public PrpLinterCancelClaimRequestDto autoCancelApprov(PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto) throws Exception{
 		PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto = new PrpLinterCancelClaimDetailDto();
 		//��װuser���󣬷������ʹ��
 		UserDto user = new UserDto();
 		String userCode = prpLinterCancelClaimRequestDto.getDealerCode();
 		
 		user.setUserCode(userCode);
 		user.setUserName(prpLinterCancelClaimRequestDto.getOperatorName());
 		user.setComCode(prpLinterCancelClaimRequestDto.getMakeCom());
 		user.setComName(prpLinterCancelClaimRequestDto.getMakeComName());
 		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
 	    UIRegistAction uiRegistAction = new UIRegistAction();
 	    UIClaimAction uiClaimAction = new UIClaimAction();
 		DBManager dbManager = new DBManager();
 		dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;

 	    try {
 	       //��ʼ����
 		   dbManager.beginTransaction();
 		   String id = prpLinterCancelClaimRequestDto.getId();
 		   String registNo = prpLinterCancelClaimRequestDto.getRegistNo();
 		   String claimNo = prpLinterCancelClaimRequestDto.getClaimNo();
 		   BLWfLogFacade blWfLogFacade = new BLWfLogFacade();
 		   ArrayList wflogList = (ArrayList)blWfLogFacade.findByConditions("businessno='"+claimNo+"'");
 		   WfLogDto wfLogDto = (WfLogDto)wflogList.get(0);
 		   String operatorCode= "";
 		   BLPrpLinterCancelClaimDetailAction blPrpLinterCancelClaimDetailAction = new BLPrpLinterCancelClaimDetailAction();
 		   prpLinterCancelClaimDetailDto = blPrpLinterCancelClaimDetailAction.findByPrimaryKey(dbManager, id);
 	    	
 		   String flowId = wfLogDto.getFlowID();
		   int LogNo  =    blWfLogFacade.getCount("businessno='"+claimNo+"'");;
		   int ModelNo = wfLogDto.getModelNo();
		   int NodeNo = 6;
		   int currendNodeNo = 2;
		   String Flag = "";
		   String selectNodeName = "���ͨ��";
           UICommonDealSubmitAction uiCommonDealSubmitAction = new UICommonDealSubmitAction();
           //�������������
          
           WfLogDto wfLogCurrDto = null;
           UIWflogQueryAction uiWflogQueryAction = new UIWflogQueryAction();
		   wfLogCurrDto = uiWflogQueryAction.findByPrimaryKey(flowId, LogNo);
		   //�жϸù������Ѵ�����ת���������û���ͬһҵ�񵥽��в���ʱ�ĳ�ͻ���Ӷ�������������
		   if(wfLogCurrDto != null)
			{
				if(wfLogCurrDto.getNodeStatus() != null && !"".equals(wfLogCurrDto.getNodeStatus()))
				{
					if("4".equals(wfLogCurrDto.getNodeStatus()) || "0".equals(wfLogCurrDto.getNodeStatus()))
					{
						throw new Exception("�ù������Ѵ�����ת���벻Ҫ�ظ�������");
					}
				}
			}
			Flag = "1"; // 0��ʾ��ҵ��ϵͳ�ύ��˫�ˣ�1��ʾ˫��ϵͳ�ڲ��ύ
			
			String HandleText = StringUtils.replace(prpLinterCancelClaimRequestDto.getHandleText(), "'", "''");
			if (HandleText == null) {
				HandleText = "";
			}
			UwNotionDto uwNotionDto = new UwNotionDto();
			uwNotionDto.setFlowID(flowId);
			uwNotionDto.setLogNo(LogNo);
			uwNotionDto.setHandleText(HandleText);

			// ��HandleText��ֳɶ��� ��ɶ��uwNotionDto������������uwNotion��
			UwNotionSaveNotionCommand uwNotionSaveNotionCommand = new UwNotionSaveNotionCommand(uwNotionDto);
			uwNotionSaveNotionCommand.execute();
			//Ȩ�޿���
			BLWfCheckAdvanceFacade blWfCheckAdvanceFacade = new BLWfCheckAdvanceFacade();
			boolean hasPath = blWfCheckAdvanceFacade.checkAdvanceCondition(	ModelNo, currendNodeNo, "O", claimNo, "1",null);
			if (hasPath) {
				//����û�����
			}
			else{
				throw new UserException( -98, -1007,"���Ȩ�޲���!","���ύ�ϼ����·��޸�!"); 
			}
			
			String uwFlowID = new UIWorkFlowApprovalInterFaceFacade(). submitApprovalPlatform("MedicalAutoRecasApprov",flowId,
					"3",claimNo,"2801","28",user.getComCode(),prpLinterCancelClaimRequestDto.getHandleText(),user.getComCode(),
					user.getUserCode(), user.getUserCode(), prpLinterCancelClaimRequestDto.getHandleText());
			
			if(!"SUCCESS".equals(uwFlowID)){
				throw new Exception("�ؿ�����ʧ�ܴ���ʧ��");
			}
			
//			blWfLogFacade.submitTaskApproval(flowId, ModelNo, NodeNo, "O", claimNo, "0",
//					Flag, userCode, operatorCode);
			/***************************************************************
			 * 1.���������ڵ�
			 **************************************************************/
			BLPrpLclaimAction bLPrpLclaimAction  = new BLPrpLclaimAction();
			BLSwfLogAction blSwfLogFacade = new BLSwfLogAction();
			SwfLogDto swfLogDto = new SwfLogDto();
			ArrayList<SwfLogDto> list1 = (ArrayList<SwfLogDto>) blSwfLogFacade
			.findByConditions(dbManager, "businessNO='"
					+ claimNo + "' and nodeType='cance'");
			if (list1 != null && !list1.isEmpty()) {
				swfLogDto = list1.get(0);
			}
			BLWorkFlowAction blWorkFlowAction = new BLWorkFlowAction();
			PrpLclaimDto  prpLclaimDto  = bLPrpLclaimAction.findByPrimaryKey(dbManager, claimNo);
			ArrayList<SwfLogDto> list = (ArrayList<SwfLogDto>) blSwfLogFacade
					.findByConditions(dbManager, "businessNO='"
							+ claimNo + "' and nodeType='claim'");
			if (list != null && !list.isEmpty()) {
				SwfLogDto swfLogDto2 = list.get(0);
				swfLogDto2.setNodeStatus("6");
				blSwfLogFacade.update(dbManager, swfLogDto2);
			}
			WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
			swfLogDto.setNodeStatus("4");
			BLPrpLclaimAction blPrpLclaimAction = new BLPrpLclaimAction();
			/** ********************************* */
			UIBillAction uiBillAction = new UIBillAction();
			String tableName = "prplcaseno";
			String comCode = user.getComCode();
			String riskCode = "2801";
			int year = DateTime.current().getYear();
			 DAAEndcaseViewHelper endCaseViewHelper= new DAAEndcaseViewHelper();
			String caseNo = endCaseViewHelper.getCaseNo(claimNo, comCode);
			prpLclaimDto.setCaseNo(caseNo);
			prpLclaimDto.setEndCaseDate(new DateTime(prpLinterCancelClaimRequestDto.getCancelDate(), DateTime.YEAR_TO_SECOND));
			prpLclaimDto.setEndCaserCode(user.getUserCode());
			prpLclaimDto.setCaseNo(caseNo);
			prpLclaimDto.setCaseType("0");
			// ���ͨ����ʱ���д������ݵĵ�
			prpLclaimDto.setCancelDate(new DateTime(prpLinterCancelClaimRequestDto.getCancelDate(), DateTime.YEAR_TO_DAY));
			BLPrpLRegistRPolicyAction blPrpLRegistRPolicyAction = new BLPrpLRegistRPolicyAction();
			PrpLRegistRPolicyDto prpLRegistRPolicyDto = blPrpLRegistRPolicyAction
					.findByPrimaryKey(dbManager,
							prpLclaimDto.getRegistNo(), prpLclaimDto
									.getPolicyNo());
			//ͳһ������������ע���޸�
			prpLRegistRPolicyDto.setValidStatus("0");
			prpLRegistRPolicyDto.setClaimNo(claimNo);
			
			
			blPrpLRegistRPolicyAction.update(dbManager,
					prpLRegistRPolicyDto);
			// �Ƿ������������᰸��,������᰸�ˣ�����Ҫ��������ת��
			boolean isAllClaimEnd = false;
			isAllClaimEnd = true;
			WorkFlowDto workFlowDto = null;
			if (isAllClaimEnd) {
				swfLogDto.setEndFlag("1");// ����Ϊ1������ת��
			}
			workFlowDto = workFlowViewHelper.viewToDto(user, swfLogDto);
			SwfLogDto updateDto = workFlowDto.getUpdateSwfLogDto();
			updateDto.setBusinessNo(claimNo);
			blWorkFlowAction.deal(dbManager, workFlowDto);
			
 	       
 	       prpLinterCancelClaimDetailDto.setCancelApprovFlag("1");
 		   prpLinterCancelClaimDetailDto.setRemark("����ע�������ɹ���"+prpLinterCancelClaimDetailDto.getRegistNo());
 		   blPrpLinterCancelClaimDetailAction.update(dbManager, prpLinterCancelClaimDetailDto);
 		   
 		   String sqlCance = " Update swflogStore Set  submittime='"+prpLinterCancelClaimRequestDto.getCancelDate()
                                                     +"',flowintime='" +prpLinterCancelClaimRequestDto.getCancelDate()
                                                     +"',handletime='" +prpLinterCancelClaimRequestDto.getCancelDate()
                                                     +"' Where registno ='"+registNo+"' and nodeType ='cance'";
           new BLPrplinterAutoClaimDetailAction().updateBySQL(dbManager,sqlCance);
           
           String sqlWCance = " Update wflogStore Set  submittime='"+prpLinterCancelClaimRequestDto.getCancelDate()
                                                  +"',flowintime='" +prpLinterCancelClaimRequestDto.getCancelDate()
                                                   +"',handletime='" +prpLinterCancelClaimRequestDto.getCancelDate()
                                                    +"' Where businessno ='"+claimNo+"'";
           new BLPrplinterAutoClaimDetailAction().updateBySQL(dbManager,sqlWCance);
 		   
 		   bLPrpLclaimAction.update(dbManager, prpLclaimDto);
 	      //�ύ����
 		  dbManager.commitTransaction();
 	    } catch (Exception e) {
 	      dbManager.rollbackTransaction();
 	      prpLinterCancelClaimDetailDto.setCancelApprovFlag("0");
 		  String messege = e.toString();
 		  if(messege!=null&&messege.length()>1000){
 			  messege = messege.substring(0,1000);
 		  }
 		  prpLinterCancelClaimDetailDto.setRemark("����ע������ʧ�ܣ�"+messege);;
 		  new BLPrpLinterCancelClaimDetailFacade().update(prpLinterCancelClaimDetailDto);
 	      e.printStackTrace();
 	      throw e;
 	    }finally{
 	    	dbManager.close();//�������ݿ����ӹر�
 	    }
 	     
 	    return prpLinterCancelClaimRequestDto;
 	  }
 	
 	
 	/**
     * ��д����ҳ�漰��ѯ����request������. ��д����ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request�� ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������.
     * 
     * @param httpServletRequest ���ظ�ҳ���request
     * @param proposalIniDto ȡ���ĳ�ʼ����ϢDto
     * @throws Exception
     */

    public PrpLclaimDto claimDtoToView(PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto, String claimNo) throws Exception {
        //��ѯ������Ϣ
    	UIClaimAction uiClaimAction = new UIClaimAction();
    	UICodeAction uiCodeAction = new UICodeAction();
        ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
        PrpLclaimDto prpLclaimDto = new PrpLclaimDto(); 
        //��prpLclaimDto��ֵ
        if (claimDto.getPrpLclaimDto() == null) {
            String msg = "����'" + claimNo + "'�޷���ѯ����";
            throw new UserException(1, 3, "��ѯ", msg);
        }
        prpLclaimDto = claimDto.getPrpLclaimDto();
        String strRiskType = uiCodeAction.translateRiskCodetoRiskType(prpLclaimDto.getRiskCode());
        PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
        UICheckAction uiCheckAction = new UICheckAction();
        CheckDto checkDto = uiCheckAction.findByPrimaryKey(claimDto.getPrpLclaimDto().getRegistNo());
        String timeTemp = StringConvert.toStandardTime(prpLclaimDto.getDamageStartHour());
        prpLclaimDto.setDamageStartHour(timeTemp.substring(0, 2));
        prpLclaimDto.setDamageStartMinute(timeTemp.substring(3, 5));
        timeTemp = StringConvert.toStandardTime(prpLclaimDto.getDamageEndHour());
        prpLclaimDto.setDamageEndHour(timeTemp.substring(0, 2));
        prpLclaimDto.setDamageEndMinute(timeTemp.substring(3, 5));
        
        String riskCode = prpLclaimDto.getRiskCode();
        String registNo = prpLclaimDto.getRegistNo();
        
        

        //��������������״̬Ϊ �����޸� (����������)
        if (claimDto.getPrpLclaimStatusDto() != null) {
            if (claimDto.getPrpLclaimStatusDto().getStatus().equals("7"))
                claimDto.getPrpLclaimStatusDto().setStatus("3");
            prpLclaimDto.setStatus(claimDto.getPrpLclaimStatusDto().getStatus());
        } else {
            //���ύ���Ѿ�������ϵ�״̬
            prpLclaimDto.setStatus("4");
        }

        /*
         * �ӱ����л����Ϣ ԭ����Ϊ��Щ������Ϣ���Ѿ����浽��������Ϣ���ˣ���ע����������Ϊ��Ҫת�������ϵ� ������Ϣ����������Ҫȥȡ����������ĳ�����Ϣ��һ�����̡�
         */
        PolicyDto policyDto=null;
        if (!claimDto.getPrpLclaimDto().getPolicyNo().equals("")) {
            //��ѯ������Ϣ
        	EndorseViewHelper endorseViewHelper = new EndorseViewHelper();   
    		//���ݳ���ʱ�仹ԭ������Ϣ
        	policyDto = endorseViewHelper.findForEndorBefore(claimDto.getPrpLclaimDto().getPolicyNo()
        	  		,claimDto.getPrpLclaimDto().getDamageStartDate().toString()
					,claimDto.getPrpLclaimDto().getDamageStartHour());
        	
            prpLclaimDto.setClaimDate(new DateTime(prpLclaimDto.getClaimDate(),DateTime.YEAR_TO_DAY));
            prpLclaimDto.setClaimTime(new DateTime(prpLclaimDto.getClaimTime(), DateTime.YEAR_TO_SECOND));
        	
        	 
            //ȡ�����������ƣ������ŵ���Ҫ��ʾ����
            String strInsuredNameShow = "";
			int insureQuantity = policyDto.getPrpCmainDto().getSumQuantity();
			if (String.valueOf(insureQuantity) == null || String.valueOf(insureQuantity).equals("")
					|| insureQuantity <= 1 ) {
			    	strInsuredNameShow = policyDto.getPrpCmainDto().getInsuredName();
			}
			else {
					strInsuredNameShow = policyDto.getPrpCmainDto().getInsuredName()+"��"+insureQuantity+"��";
			}
			prpLclaimDto.setInsuredNameShow(strInsuredNameShow);
			prpLclaimDto.setSumInsured(policyDto.getPrpCmainDto().getSumInsured());
			
        }
        //������ش��������ת��
        changeCodeToName(prpLclaimDto);
        //���ô�����и�����ѡ�����б���Ϣ������
        
        //��ѯ��ͬ�����ŵĳ��մ���
        DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
       
        
        
        PubTools pubTools=new PubTools();
	    int time= pubTools.compareDate(policyDto.getPrpCmainDto().getInputDate().toString(),"2011-02-27");
	    //�þɵĻ�ȡΣ�յ�λ��Ϣ����
        
        
      

        //���ø����ӱ���Ϣ������
        claimDto.setPrpLpersonTraceDtoList(claimDto.getPrpLpersonTraceDtoList());
        //��ʾ�������ں���������֮��Ĺ���������
        UIRegistAction uiRegistAction = new UIRegistAction();
        RegistDto registDto = uiRegistAction.findByPrimaryKey(prpLclaimDto.getRegistNo());
        DateTime registDate = registDto.getPrpLregistDto().getReportDate();
        
        //������������������ϵ��¼
        Collection arrayListRegistExt = new ArrayList();
        PrpLregistExtDto prpLregistExtDto  = new PrpLregistExtDto();
        prpLregistExtDto.setRegistNo(claimDto.getPrpLclaimDto().getRegistNo());
        prpLregistExtDto.setRiskCode(claimDto.getPrpLclaimDto().getRiskCode());
        arrayListRegistExt = claimDto.getPrpLregistExtDtoList();       
        prpLregistExtDto.setRegistExtList(arrayListRegistExt) ;
        
        //�¹���ģ��   
        ArrayList prpLacciBenPersonDtoList = claimDto.getPrplacciBenPersonDtoList();
        PrpLacciPersonDto  prpLacciPersonDto = new PrpLacciPersonDto();
        prpLacciPersonDto.setPrpLacciBenPersonList(prpLacciBenPersonDtoList);
        
       	//����������
        ArrayList prpLacciPersonDtoList = claimDto.getPrpLacciPersonDtoList();
        prpLacciPersonDto.setPrpLacciPersonList(prpLacciPersonDtoList);
        //����������end-------------------------------------
        
        
        
        //ȱʡ���������ıұ� 2005-09-05
        prpLclaimDto.setEstiCurrency(registDto.getPrpLregistDto().getEstiCurrency());
        
        //��ȡ�һ�����Ϣ 2005-09-05
        Collection prpdexchDtoList = new ArrayList();
        UIExchAction uiExchAction = new UIExchAction(); 
        
        return prpLclaimDto;
    }
    
    /**
     * ����PrpClaimDto�е��Ѿ����õĴ������ݣ��Դ����������ת��
     * 
     * @param httpServletRequest ���ظ�ҳ���request
     * @param prpClaimDto ������������
     * @param ClaimDto ��ѯ����������
     * @throws Exception
     */
    private void changeCodeToName(PrpLclaimDto prpLclaimDto) throws Exception {
        UICodeAction uiCodeAction = new UICodeAction();
        //(1)�������Ƶ�ת��
        String clauseType = prpLclaimDto.getClauseType();
        String clauseName = uiCodeAction.translateCodeCode("ClauseType", clauseType, true);
        prpLclaimDto.setClauseName(clauseName);
        //(2)������ɫת��
        String licenseColorCodeCode = prpLclaimDto.getLicenseColorCode();
        String licenseColor = uiCodeAction.translateCodeCode("LicenseColor", licenseColorCodeCode, true);
        prpLclaimDto.setLicenseColor(licenseColor);
        //(3)��������ת��
        String carKindCode = prpLclaimDto.getCarKindCode();
        String carKind = uiCodeAction.translateCodeCode("CarKind", carKindCode, true);
        prpLclaimDto.setCarKind(carKind);
        
        //(4)��ҵ������ṹ����ת��
        String comCode = prpLclaimDto.getComCode();
        String comName = uiCodeAction.translateComCode(comCode, true);
        prpLclaimDto.setComName(comName);
        //(5)�Թ���ҵ��Ա����ת��
        String handler1Code = prpLclaimDto.getHandler1Code();
        String handler1Name = uiCodeAction.translateUserCode(handler1Code, true);
        prpLclaimDto.setHandler1Name(handler1Name);
        //(6)�Դ����˽���ת��
        String agentCode = prpLclaimDto.getAgentCode();
        String agentName = uiCodeAction.translateUserCode(agentCode, true);
        prpLclaimDto.setAgentName(agentName);
        //(7)�Ծ����˽���ת��
        String handlerCode = prpLclaimDto.getHandlerCode();
        String handlerName = uiCodeAction.translateUserCode(handlerCode, true);
        prpLclaimDto.setHandlerName(handlerName);
        
        //(8)�԰������ʽ���ת�� 2005-08-01
        String strClaimType = prpLclaimDto.getClaimType();
        String strClaimTypeName = uiCodeAction.translateCodeCode("CaseCode",strClaimType, true);
        prpLclaimDto.setClaimTypeName(strClaimTypeName);
        
        //(9)��ҵ�����ͽ���ת��
        String strBusinessNature = prpLclaimDto.getBusinessNature();
        String strBusinessNatureName = uiCodeAction.translateCodeCode("BusinessNature",strBusinessNature, true);
        prpLclaimDto.setBusinessNatureName(strBusinessNatureName);
        //10)������ת��
 //System.out.println("aaaaaaaaaaaa"+prpLclaimDto.getLanguage());       
        if(prpLclaimDto.getLanguage().equals("C"))
        {
            prpLclaimDto.setLanguageName("����");
        }
        if(prpLclaimDto.getLanguage().equals("E"))
        {
            prpLclaimDto.setLanguageName("Ӣ��");
        }
        //(11)��makeCom����ת�� add by liuyanmei 20051115 
        //reason :itest bug 647 ���������ѯ������Ǽǲ�����ʾ��ֻ�д��룬û�����ơ�
        String makeCom = prpLclaimDto.getMakeCom();
        String makeComName = uiCodeAction.translateComCode(makeCom, true);
        prpLclaimDto.setMakeComName(makeComName);
        
    }
 	
}
