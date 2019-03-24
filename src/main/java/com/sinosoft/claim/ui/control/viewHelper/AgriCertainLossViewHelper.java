package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;

import com.gyic.claim.bl.facade.BLPrplcompensateearFacade;
import com.gyic.claim.dto.domain.PrplcompensateearDto;
import com.sinosoft.claim.bl.facade.BLPrpDriskFacade;
import com.sinosoft.claim.bl.facade.BLPrplcompensatehouseFacade;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.dto.custom.CaseRelateNodeDto;
import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpDriskDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLpersonDto;
import com.sinosoft.claim.dto.domain.PrpLpropDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossExtDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossItemDto;
import com.sinosoft.claim.dto.domain.SwfPathDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLverifyLossExt;
import com.sinosoft.claim.ui.control.action.ICollections;
import com.sinosoft.claim.ui.control.action.UICertainLossAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIConfigAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIPrpLcheckAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utility.SysConfig;

/**
 * <p>Title: CertainLossViewHelper</p>
 * <p>Description:����ViewHelper�࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004</p>
 * @author ����������Ŀ�� liubvo
 * @version 1.0
 * <br>
 */

public class AgriCertainLossViewHelper extends CertainLossViewHelper{
	
	/**
	 * ���涨��ʱ����ҳ����������.
	 * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
	 * @param httpServletRequest
	 * @return certainLossDto �������ݴ������ݽṹ
	 * @throws Exception
	 */
	public CertainLossDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
	{
		//�̳ж�certainLoss,certainLossText��ĸ�ֵ
		CertainLossDto certainLossDto = super.viewToDto(httpServletRequest);
		
		//add by lixiang start 20051228
		//reason: ��Ϊ���ǵ�¼���ʱ�򣬿���û���������������ύ��ʱ����������������������ûд�롣
		//��ȡ�������룬����Ҫ����Ҫ��ҳ����ȡ�á�����
		String claimNo=httpServletRequest.getParameter("prpLverifyLossClaimNo");
		String registNo  = httpServletRequest.getParameter("prpLverifyLossRegistNo");
		if (claimNo==null||claimNo.length()<2){
			UICodeAction uiCodeAction = new UICodeAction();
			claimNo=uiCodeAction.translateBusinessCode(registNo,true);
		}
		//add by lixiang end 20051228
		
		/*---------------------�Ʋ��˶�����ϸ�嵥�� prpLprop ------------------------------------*/
		ArrayList prpLpropDtoList = new ArrayList();
		PrpLpropDto prpLpropDto = null;
		
		//���������ı�
		PrpLverifyLossItemDto LossItemPropDto = new PrpLverifyLossItemDto();
		ArrayList lossItemListTemp = new ArrayList();
		//�ӽ���õ���������
		String   prpLpropPolicyNo  = httpServletRequest.getParameter("prpLverifyLossPolicyNo");
		String   prpLpropRiskCode  = httpServletRequest.getParameter("prpLverifyLossRiskCode");
		String   prpLpropClaimNo  = httpServletRequest.getParameter("prpLverifyLossClaimNo");
		String   prpLpropRegistNo  = httpServletRequest.getParameter("prpLverifyLossRegistNo");
		
		String[]   prpLpropSerialNo                  =httpServletRequest.getParameterValues("prpLpropSerialNo");
		String[]   prpLpropItemKindNo                =httpServletRequest.getParameterValues("prpLpropItemKindNo");
		String[]   prpLpropFamilyNo                  =httpServletRequest.getParameterValues("prpLpropFamilyNo");
		String[]   prpLpropFamilyName                =httpServletRequest.getParameterValues("prpLpropFamilyName");
		String[]   prpLpropKindCode                  =httpServletRequest.getParameterValues("prpLpropKindCode");
		String[]   prpLpropItemCode                  =httpServletRequest.getParameterValues("prpLpropItemCode");
		String[]   prpLpropLossItemCode              =httpServletRequest.getParameterValues("prpLpropLossItemCode");
		String[]   prpLpropLossItemName              =httpServletRequest.getParameterValues("prpLpropLossItemName");
		String[]   prpLpropFeeTypeCode               =httpServletRequest.getParameterValues("prpLpropFeeTypeCode");
		String[]   feeTypeCode                       =httpServletRequest.getParameterValues("feeTypeCode");
		String[]   prpLpropFeeTypeName               =httpServletRequest.getParameterValues("prpLpropFeeTypeName");
		String[]   prpLpropCurrency                  =httpServletRequest.getParameterValues("prpLpropCurrency");
		String[]   prpLpropUnitPrice                 =httpServletRequest.getParameterValues("prpLpropUnitPrice");
		String[]   prpLpropLossQuantity              =httpServletRequest.getParameterValues("prpLpropLossQuantity");
		String[]   prpLpropUnit                      =httpServletRequest.getParameterValues("prpLpropUnit");
		String[]   prpLpropBuyDate                   =httpServletRequest.getParameterValues("prpLpropBuyDate");
		String[]   prpLpropDepreRate                 =httpServletRequest.getParameterValues("prpLpropDepreRate");
		String[]   prpLpropSumLoss                   =httpServletRequest.getParameterValues("prpLpropSumLoss");
		String[]   prpLpropSumReject                 =httpServletRequest.getParameterValues("prpLpropSumReject");
		String[]   prpLpropRejectReason              =httpServletRequest.getParameterValues("prpLpropRejectReason");
		String[]   prpLpropLossRate                  =httpServletRequest.getParameterValues("prpLpropLossRate");
		String[]   prpLpropSumDefLoss                =httpServletRequest.getParameterValues("prpLpropSumDefLoss");
		String[]   prpLpropRemark                    =httpServletRequest.getParameterValues("prpLpropRemark");
		String[]   prpLpropVeriUnitPrice             =httpServletRequest.getParameterValues("prpLpropVeriUnitPrice");
		String[]   prpLpropVeriLossQuantity          =httpServletRequest.getParameterValues("prpLpropVeriLossQuantity");
		String[]   prpLpropVeriUnit                  =httpServletRequest.getParameterValues("prpLpropVeriUnit");
		String[]   prpLpropVeriDepreRate             =httpServletRequest.getParameterValues("prpLpropVeriDepreRate");
		String[]   prpLpropVeriSumLoss               =httpServletRequest.getParameterValues("prpLpropVeriSumLoss");
		String[]   prpLpropVeriSumReject             =httpServletRequest.getParameterValues("prpLpropVeriSumReject");
		String[]   prpLpropVeriRejectReason          =httpServletRequest.getParameterValues("prpLpropVeriRejectReason");
		String[]   prpLpropVeriLossRate              =httpServletRequest.getParameterValues("prpLpropVeriLossRate");
		String[]   prpLpropVeriSumDefLoss            =httpServletRequest.getParameterValues("prpLpropVeriSumDefLoss");
		String[]   prpLpropVeriRemark                =httpServletRequest.getParameterValues("prpLpropVeriRemark");
		String[]   prpLpropFlag                      =httpServletRequest.getParameterValues("prpLpropFlag");
		String[]   prpLprop1528FamilyNo                      =httpServletRequest.getParameterValues("prpLprop1528FamilyNo");
		String[]   prpLpropBrandCode                      =httpServletRequest.getParameterValues("prpLpropBrandCode");
		String[]   prpLpropCarNumber                      =httpServletRequest.getParameterValues("prpLpropCarNumber");
		//0313���������imei�� add by wangxinyang 2018/6/15
		String[]   prpLpropImei						 =httpServletRequest.getParameterValues("prpLpropImei");
		
//		add by lixiang start at 2006-04-21
	    //reason: ���ӱ��������˻صĶ���ı�־�ı���,�������ݲ��ᱻ������
	  String[]   prpLpropCompensateBackFlag  = httpServletRequest.getParameterValues("prpLpropCompensateBackFlag");
	  UICodeAction uiCodeAction = new UICodeAction();
	  String strRiskType = uiCodeAction.translateRiskCodetoRiskType(prpLpropRiskCode);
		//add by lixiang end at 2006-04-21
//����ֵ
		if (prpLpropSerialNo==null){
		}else{
			
			for(int index=1;index<prpLpropSerialNo.length;index++)
			{
				prpLpropDto = new PrpLpropDto();
				prpLpropDto.setPolicyNo(prpLpropPolicyNo);
				prpLpropDto.setRiskCode(prpLpropRiskCode);
				prpLpropDto.setClaimNo(claimNo);
				prpLpropDto.setRegistNo(prpLpropRegistNo);
				
				prpLpropDto.setSerialNo                 ( index);
				//prpLpropDto.setSerialNo                 ( Integer.parseInt(DataUtils.nullToZero(prpLpropSerialNo     [index])));
				prpLpropDto.setFamilyNo                 ( Integer.parseInt(DataUtils.nullToZero(prpLpropFamilyNo     [index])));
				if(prpLpropFamilyName!=null){
					prpLpropDto.setFamilyName               ( prpLpropFamilyName   [index]);
				}
				prpLpropDto.setKindCode                 ( prpLpropKindCode     [index]);
				prpLpropDto.setItemKindNo               ( Integer.parseInt(DataUtils.nullToZero(prpLpropItemKindNo   [index])));
				prpLpropDto.setItemCode                 ( prpLpropItemCode     [index]);
				if("I".equals(strRiskType)||"H".equals(strRiskType)){
  				    prpLpropDto.setLossItemCode             ("-2");
				}else{
			        prpLpropDto.setLossItemCode             ( prpLpropLossItemCode [index]);
				}
				prpLpropDto.setLossItemName             ( prpLpropLossItemName [index]);
				if("I".equals(strRiskType)||"H".equals(strRiskType)){
					prpLpropDto.setFeeTypeCode              ("");
					prpLpropDto.setFeeTypeName              ("");
				}else{
				    prpLpropDto.setFeeTypeCode              ( feeTypeCode [index]);
				    prpLpropDto.setFeeTypeName              (prpLpropFeeTypeName [index]);
				}
			    prpLpropDto.setCurrency                 ( prpLpropCurrency     [index]);
				prpLpropDto.setUnitPrice                ( Double.parseDouble(DataUtils.nullToZero(prpLpropUnitPrice    [index])));
				prpLpropDto.setLossQuantity             ( Double.parseDouble(DataUtils.nullToZero(prpLpropLossQuantity [index])));
				prpLpropDto.setUnit                     ( prpLpropUnit         [index]);
				prpLpropDto.setBuyDate                  ( new DateTime(new Date(),DateTime.YEAR_TO_DAY));
				//prpLpropDto.setBuyDate                  ( new DateTime(prpLpropBuyDate      [index]));
				prpLpropDto.setDepreRate                ( Double.parseDouble(DataUtils.nullToZero(prpLpropDepreRate    [index])));
				prpLpropDto.setSumLoss                  ( Double.parseDouble(DataUtils.nullToZero(prpLpropSumLoss      [index])));
				prpLpropDto.setSumReject                ( Double.parseDouble(DataUtils.nullToZero(prpLpropSumReject    [index])));
				prpLpropDto.setRejectReason             ( prpLpropRejectReason [index]);
				prpLpropDto.setLossRate                 ( Double.parseDouble(DataUtils.nullToZero(prpLpropLossRate     [index])));
				prpLpropDto.setSumDefLoss               ( Double.parseDouble(DataUtils.nullToZero(prpLpropSumDefLoss   [index])));
				prpLpropDto.setRemark                   ( prpLpropRemark       [index]);
				prpLpropDto.setVeriUnitPrice            ( Double.parseDouble(DataUtils.nullToZero(prpLpropVeriUnitPrice[index])));
				prpLpropDto.setVeriLossQuantity         ( Double.parseDouble(DataUtils.nullToZero(prpLpropVeriLossQuantity[index])));
				prpLpropDto.setVeriUnit                 ( prpLpropVeriUnit        [index]);
				prpLpropDto.setVeriDepreRate            ( Double.parseDouble(DataUtils.nullToZero(prpLpropVeriDepreRate   [index])));
				prpLpropDto.setVeriSumLoss              ( Double.parseDouble(DataUtils.nullToZero(prpLpropVeriSumLoss     [index])));
				prpLpropDto.setVeriSumReject            ( Double.parseDouble(DataUtils.nullToZero(prpLpropVeriSumReject   [index])));
				prpLpropDto.setVeriRejectReason         ( prpLpropVeriRejectReason[index]);
				prpLpropDto.setVeriLossRate             ( Double.parseDouble(DataUtils.nullToZero(prpLpropVeriLossRate    [index])));
				prpLpropDto.setVeriSumDefLoss           ( Double.parseDouble(DataUtils.nullToZero(prpLpropVeriSumDefLoss  [index])));
				prpLpropDto.setVeriRemark               ( prpLpropVeriRemark      [index]);
				prpLpropDto.setFlag                     ( prpLpropFlag            [index]);
		        if(prpLpropCompensateBackFlag!=null){
		        	prpLpropDto.setCompensateBackFlag       ( prpLpropCompensateBackFlag [index]);
		        }
		        
		        if ("1528".equals(prpLpropRiskCode)) {
					if (prpLprop1528FamilyNo!=null) {
						prpLpropDto.setFamilyNo   ( Integer.parseInt(DataUtils.nullToZero(prpLprop1528FamilyNo     [index])));
					}
					if (prpLpropBrandCode!=null) {
						prpLpropDto.setModelNo(prpLpropBrandCode[index]);
					}
					if (prpLpropCarNumber!=null) {
						prpLpropDto.setLicenseNo(prpLpropCarNumber[index]);
					}
				}
		        
		        
		        if("0313".equals(prpLpropRiskCode)){
		        	if(prpLpropImei!=null && prpLpropImei[index]!=null && !"".equals(prpLpropImei[index])){
		        		prpLpropDto.setImei(prpLpropImei[index]);
		        	}
		        }

		        httpServletRequest.setAttribute("prpLpropDto",prpLpropDto);
		        //���뼯��
				prpLpropDtoList.add(prpLpropDto);
			}
			PropertyUtils.copyProperties(LossItemPropDto,certainLossDto.getPrpLverifyLossDto());
			LossItemPropDto.setSerialNo(3);
			LossItemPropDto.setLossType("3");
			LossItemPropDto.setNodeType("certa");
			lossItemListTemp.add(LossItemPropDto);
		}
		//��89��ģ������� start==
		BLPrpDriskFacade blPrpDriskFacade = new BLPrpDriskFacade();
        ArrayList<PrpDriskDto> prpDriskDtos = new ArrayList<PrpDriskDto>();
        String classCodeStr = AppConfig.get("sysconst.PROP_VERIFY_CLASS").trim();//ȡ��89��ģ�������
        String riskcodeStr = "";//��89��ģ������ֵ��ַ���
        String[] classCodeArr = classCodeStr.split(",");
        String conditions = "";
        if(classCodeArr != null){
        	conditions += " classcode in('";
        	for(int i=0;i<classCodeArr.length;i++){
        		conditions += classCodeArr[i]+"',";
        	}
        	conditions = conditions.substring(0,conditions.length()-1);//ɾ������","��
        	conditions += ")";
        	
        	prpDriskDtos = (ArrayList<PrpDriskDto>)blPrpDriskFacade.findByConditions(conditions);
        }
        if(prpDriskDtos != null && prpDriskDtos.size()>0){
        	for(int i=0;i<prpDriskDtos.size();i++){
        		PrpDriskDto prpDriskDto = prpDriskDtos.get(i); 
        		riskcodeStr += prpDriskDto.getRiskCode()+";";
        	}
        }
        //��89��ģ�������  end===
        
	    if(prpLpropRiskCode != null){
	    	if("0310".equals(prpLpropRiskCode)||"0312".equals(prpLpropRiskCode)||riskcodeStr.indexOf(prpLpropRiskCode)>0)
	    	{
	    		String nodeStatus = httpServletRequest.getParameter("status");
	    		String nodeType = httpServletRequest.getParameter("nodeType");
	    		String buttonSaveType = httpServletRequest.getParameter("buttonSaveType");
	    		UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
	    		String comCode = user.getComCode();
	    		String [] prpLverifyLossExtSerialNo = httpServletRequest.getParameterValues("prpLverifyLossExtSerialNo");
	    		String [] prpLverifyLossExtInputDate = httpServletRequest.getParameterValues("prpLverifyLossExtInputDate");
	    		String [] prpLverifyLossExtInputHour = httpServletRequest.getParameterValues("prpLverifyLossExtInputHour");
	    		String [] prpLverifyLossExtOperatorCode = httpServletRequest.getParameterValues("prpLverifyLossExtOperatorCode");
	    		String [] prpLverifyLossExtTitle = httpServletRequest.getParameterValues("prpLverifyLossExtTitle");
	    		String [] prpLverifyLossExtContext = httpServletRequest.getParameterValues("prpLverifyLossExtContext");
	    		
	    		ArrayList list = new ArrayList();
	    		DBManager dbManager = new DBManager();
	    		try{
	    			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	    			DBPrpLverifyLossExt dBPrpLverifyLossExt = new DBPrpLverifyLossExt(dbManager);
	    			ArrayList<PrpLverifyLossExtDto> arrayListVerifyLossExt = (ArrayList)dBPrpLverifyLossExt.findByConditions(" registno='" + registNo + "' and LOSSITEMCODE='-1' order by serialno");
	    			
	    			if(arrayListVerifyLossExt != null && arrayListVerifyLossExt.size()>0)
	    			{
	    				if ("2".equals(nodeStatus) && riskcodeStr.indexOf(prpLpropRiskCode)>0){//ɾ�����һ��Ԫ�� ���serialno
	    					arrayListVerifyLossExt.remove(arrayListVerifyLossExt.get(arrayListVerifyLossExt.size()-1));
	    				}
	    				list = (ArrayList)arrayListVerifyLossExt;
	    			}
	    		}
	    		catch(Exception exception)
	    		{
	    			dbManager.rollbackTransaction();
	    			throw exception;
	    			
	    		}finally{
	    			dbManager.close();
	    		}
	    		if(riskcodeStr.indexOf(prpLpropRiskCode)>0){
	    			int maxIndex = prpLverifyLossExtSerialNo.length-1;
	    			PrpLverifyLossExtDto prpLverifyLossExtDto  = new PrpLverifyLossExtDto();
	    			prpLverifyLossExtDto.setContext(prpLverifyLossExtContext[maxIndex]);
	    			prpLverifyLossExtDto.setTitle(prpLverifyLossExtTitle[maxIndex]);
	    			DateTime time = new DateTime(prpLverifyLossExtInputDate[maxIndex]);
	    			
	    			prpLverifyLossExtDto.setInputDate(time);
	    			prpLverifyLossExtDto.setInputHour(prpLverifyLossExtInputHour[maxIndex]);
	    			prpLverifyLossExtDto.setLossItemCode("-1");
	    			prpLverifyLossExtDto.setOperatorCode(prpLverifyLossExtOperatorCode[maxIndex]);
	    			prpLverifyLossExtDto.setRegistNo(registNo);
	    			prpLverifyLossExtDto.setRiskCode(prpLpropRiskCode);
	    			prpLverifyLossExtDto.setNodeType(nodeType);
	    			prpLverifyLossExtDto.setComCode(comCode);
	    			prpLverifyLossExtDto.setStatus(buttonSaveType);
	    			prpLverifyLossExtDto.setSerialNo(Integer.parseInt(prpLverifyLossExtSerialNo[maxIndex]));
	    			list.add(prpLverifyLossExtDto);	
	    		}
	    		certainLossDto.setPrpLverifyLossExtDtoList(list);
	    	}
	    }
		//�Ʋ��˶�����ϸ�嵥��
		certainLossDto.setPrpLpropDtoList(prpLpropDtoList);
		/*---------------------������Ϣ����˵�� PrpLregistExt ------------------------------------*/
		ArrayList prpLregistExtDtoList = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = null ;
		//�ӽ���õ���������
		
		String prpLregistExtRegistNo = (String)httpServletRequest.getParameter("prpLregistExtRegistNo"); 
		String prpLregistExtRiskCode = httpServletRequest.getParameter      ("prpLregistExtRiskCode");
		String[] prpLregistExtSerialNo = httpServletRequest.getParameterValues("prpLregistExtSerialNo");
		String[] prpLregistExtInputDate = httpServletRequest.getParameterValues("prpLregistExtInputDate");
		String[] prpLregistExtInputHour = httpServletRequest.getParameterValues("prpLregistExtInputHour");
		String[] prpLregistExtOperatorCode = httpServletRequest.getParameterValues("prpLregistExtOperatorCode");
		String[] prpLregistExtContext = httpServletRequest.getParameterValues("prpLregistExtContext");
		
		//����ֵ
		//��Ա�������� ���ֿ�ʼ
		if (prpLregistExtSerialNo==null)
		{}
		else
		{
			for(int index=1;index<prpLregistExtSerialNo.length;index++)
			{
				prpLregistExtDto = new PrpLregistExtDto();
				prpLregistExtDto.setRegistNo(prpLregistExtRegistNo);
				prpLregistExtDto.setRiskCode(prpLregistExtRiskCode);
				prpLregistExtDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLregistExtSerialNo[index])));
				prpLregistExtDto.setInputDate(new DateTime(prpLregistExtInputDate[index],DateTime.YEAR_TO_DAY ));
				prpLregistExtDto.setInputHour(prpLregistExtInputHour[index]);
				prpLregistExtDto.setOperatorCode(prpLregistExtOperatorCode[index]);
				prpLregistExtDto.setContext(prpLregistExtContext[index]);
				//���뼯��
				prpLregistExtDtoList.add(prpLregistExtDto);
			}
			//���������м�����ʧ��λ
			certainLossDto.setPrpLregistExtDtoList(prpLregistExtDtoList);
		}  
		/*---------------------ũ�������嵥�� prplCompensateHouse ------------------------------------*/
		
		String temp1 = httpServletRequest.getParameter("nodeType");
		String temp2 = "";
		if("check".equals(temp1))
		{
			temp2 = httpServletRequest.getParameter("prpLcheckRiskCode");
		}
		else
		{
			temp2 = httpServletRequest.getParameter("prpLverifyLossRiskCode");
		}
		
		//System.err.println("prpLpropRiskCode:" + prpLpropRiskCode);
		
		if("0310".equals(temp2)||"0312".equals(temp2))
		{
			ArrayList prplCompensateHouseDtoList = new ArrayList();
			PrplcompensatehouseDto prplCompensateHouseDto = null;
			//String   prplCheckPolicyNoShow  = httpServletRequest.getParameter("prplCheckPolicyNoShow");
			//String   prplCheckRegistNoShow  = httpServletRequest.getParameter("prplCheckRegistNoShow");
			String[] prplCompensateHouseCaseNo=httpServletRequest.getParameterValues("prplCompensateHouseCaseNo");
			String[] prplCompensateHouseClaimNo=httpServletRequest.getParameterValues("prplCompensateHouseClaimNo");
			String[] prplCompensateHouseNodeNo=httpServletRequest.getParameterValues("prplCompensateHouseNodeNo");
			String[] prplCompensateHouseNodeType=httpServletRequest.getParameterValues("prplCompensateHouseNodeType");
			String[] prplCompensateHousePolicyNo=httpServletRequest.getParameterValues("prplCompensateHousePolicyNo");
			String[] prplCompensateHouseRegistNo=httpServletRequest.getParameterValues("prplCompensateHouseRegistNo");
			String[] prplCompensateHouseDamageCode=httpServletRequest.getParameterValues("prplCompensateHouseDamageCode");
			String[] prplCompensateHouseDamageStartDate=httpServletRequest.getParameterValues("prplCompensateHouseDamageStartDate");
			String[] prplCompensateHouseCompensateNo=httpServletRequest.getParameterValues("prplCompensateHouseCompensateNo");
			String[] prplCompensateHouseDamageName=httpServletRequest.getParameterValues("prplCompensateHouseDamageName");
			String[] prplCompensateHouseKindCode=httpServletRequest.getParameterValues("prplCompensateHouseKindCode");
			
			
			String[] prplCompensateHouseName=httpServletRequest.getParameterValues("prplCompensateHouseName");
			String[] prplCompensateHouseIDcard=httpServletRequest.getParameterValues("prplCompensateHouseIDcard");
			String[] prplCompensateHousehukoubu=httpServletRequest.getParameterValues("prplCompensateHousehukoubu");
			String[] prplCompensateHouseAddress=httpServletRequest.getParameterValues("prplCompensateHouseAddress");
			String[] prplCompensateHousePhone=httpServletRequest.getParameterValues("prplCompensateHousePhone");
			String[] prplCompensateHouseRemark=httpServletRequest.getParameterValues("prplCompensateHouseRemark");
			
  			String prplCompensateHouseBuildingnumber=httpServletRequest.getParameter("prplCompensateHouseBuildingnumber");
			String prplCompensateHouseZhuannumber=httpServletRequest.getParameter("prplCompensateHouseZhuannumber");
			String prplCompensateHouseWanumber=httpServletRequest.getParameter("prplCompensateHouseWanumber");
			String prplCompensateHouseKitchennumber=httpServletRequest.getParameter("prplCompensateHouseKitchennumber");
			String prplCompensateHouseOthernumber=httpServletRequest.getParameter("prplCompensateHouseOthernumber");
			String prplCompensateHouseFloor=httpServletRequest.getParameter("prplCompensateHouseFloor");
			
			String[] prplCompensateHouseEstimateLoss=httpServletRequest.getParameterValues("prplCompensateHouseEstimateLoss");
			//System.err.println("length1:" + prplCompensateHouseIDcard.length);
			//System.err.println("length2:" + prplCompensateHouseCaseNo.length);
			if (prplCompensateHouseIDcard == null){
		     }else{
		    	 for(int index = 1;index < prplCompensateHouseIDcard.length;index++)
		    	 {
		    		 prplCompensateHouseDto = new PrplcompensatehouseDto();
		    		 prplCompensateHouseDto.setAddress(prplCompensateHouseAddress[index]);
		    		 prplCompensateHouseDto.setBusinessno(prpLpropRegistNo);
		    		 prplCompensateHouseDto.setCaseno(prplCompensateHouseCaseNo[index]);
		    		 prplCompensateHouseDto.setClaimno(prplCompensateHouseClaimNo[index]);
		    		 prplCompensateHouseDto.setCompensateno(prplCompensateHouseCompensateNo[index]);
		    		 prplCompensateHouseDto.setDamagecode(prplCompensateHouseDamageCode[index]);
		    		 prplCompensateHouseDto.setDamagename(prplCompensateHouseDamageName[index]);
		    		 prplCompensateHouseDto.setDamagestartdate(new DateTime(httpServletRequest.getParameter("damageStartDate"),DateTime.YEAR_TO_DAY));
		    		 prplCompensateHouseDto.setEstimateloss(Double.parseDouble(DataUtils.nullToZero(prplCompensateHouseEstimateLoss[index])));
		    		 prplCompensateHouseDto.setHukoubu(prplCompensateHousehukoubu[index]);
		    		 prplCompensateHouseDto.setIdcard(prplCompensateHouseIDcard[index]);
		    		 prplCompensateHouseDto.setKindcode("001");
		    		 prplCompensateHouseDto.setName(prplCompensateHouseName[index]);
		    		 prplCompensateHouseDto.setPhone(prplCompensateHousePhone[index]);
		    		 prplCompensateHouseDto.setRegistno(prpLpropRegistNo);
		    		 prplCompensateHouseDto.setPolicyno(prpLpropPolicyNo);
		    		 prplCompensateHouseDto.setRemark(prplCompensateHouseRemark[index]);
		    		 prplCompensateHouseDto.setFloor(prplCompensateHouseFloor);
		    		 prplCompensateHouseDto.setBuildingnumber(prplCompensateHouseBuildingnumber);
		    		 prplCompensateHouseDto.setZhuannumber(prplCompensateHouseZhuannumber);
		    		 prplCompensateHouseDto.setWanumber(prplCompensateHouseWanumber);
		    		 prplCompensateHouseDto.setKitchennumber(prplCompensateHouseKitchennumber);
		    		 prplCompensateHouseDto.setOthernumber(prplCompensateHouseOthernumber);
		    				
		    		 //if("check".equals(httpServletRequest.getParameter("nodeType")))
					 //{
		    			//prplCompensateHouseDto.setNodeno(2);
		    			//prplCompensateHouseDto.setNodetype("check");
					 //}
					 if("propc".equals(httpServletRequest.getParameter("nodeType")))
					 {
						prplCompensateHouseDto.setNodeno(3);
						prplCompensateHouseDto.setNodetype("propc");
					 }
					 prplCompensateHouseDtoList.add(prplCompensateHouseDto);

		    	 }
		    	 //System.err.println("����:" + prplCompensateHouseDtoList.size());
		    	 certainLossDto.setPrplCompensateHouseDtoList(prplCompensateHouseDtoList); 	 
		     }
		}
		
			
		/*---------------------������嵥�� prplCompensateEar ------------------------------------*/
		
			ArrayList prplCompensateEarDtoList = new ArrayList();
			PrplcompensateearDto prplCompensateEarDto = null;
			
	  
			//�ӽ���õ���������
			String   prplCheckPolicyNoShow  = httpServletRequest.getParameter("prplCheckPolicyNoShow");
			String   prplCheckRegistNoShow  = httpServletRequest.getParameter("prplCheckRegistNoShow");

			//start��ֳ���嵥�б��ֶζ���add by �ž���
			String[] prplCompensateEarAccount=httpServletRequest.getParameterValues("prplCompensateEarAccount");
			String[] prplCompensateEarBank=httpServletRequest.getParameterValues("prplCompensateEarBank");
			String[] prplCompensateEarBreedingAreaCode=httpServletRequest.getParameterValues("prplCompensateEarBreedingAreaCode");
			String[] prplCompensateEarBreedingAreaName=httpServletRequest.getParameterValues("prplCompensateEarBreedingAreaName");
			String[] prplCompensateEarCaseNo=httpServletRequest.getParameterValues("prplCompensateEarCaseNo");
			String[] prplCompensateEarClaimNo=httpServletRequest.getParameterValues("prplCompensateEarClaimNo");
			String[] prplCompensateEarClaimRate=httpServletRequest.getParameterValues("prplCompensateEarClaimRate");
			String[] prplCompensateEarCombineNo=httpServletRequest.getParameterValues("prplCompensateEarCombineNo");
			String[] prplCompensateEarCompensateNo=httpServletRequest.getParameterValues("prplCompensateEarCompensateNo");
			String[] prplCompensateEarCullNumber=httpServletRequest.getParameterValues("prplCompensateEarCullNumber");
			String[] prplCompensateEarDamageCode=httpServletRequest.getParameterValues("prplCompensateEarDamageCode");
			String[] prplCompensateEarDamageEndDate=httpServletRequest.getParameterValues("prplCompensateEarDamageEndDate");
			String[] prplCompensateEarDamageName=httpServletRequest.getParameterValues("prplCompensateEarDamageName");
			String[] prplCompensateEarDamageStartDate=httpServletRequest.getParameterValues("prplCompensateEarDamageStartDate");
			String[] prplCompensateEarDamageStartHour=httpServletRequest.getParameterValues("prplCompensateEarDamageStartHour");
			String[] prplCompensateEarDeadNumber=httpServletRequest.getParameterValues("prplCompensateEarDeadNumber");
			String[] prplCompensateEarDeadReason=httpServletRequest.getParameterValues("prplCompensateEarDeadReason");
			String[] prplCompensateEarDeductible=httpServletRequest.getParameterValues("prplCompensateEarDeductible");
			String[] prplCompensateEarDeductibleRate=httpServletRequest.getParameterValues("prplCompensateEarDeductibleRate");
			String[] prplCompensateEarEarNo=httpServletRequest.getParameterValues("prplCompensateEarEarNo");
			String[] prplCompensateEarEstimateLoss=httpServletRequest.getParameterValues("prplCompensateEarEstimateLoss");
			String[] prplCompensateEarFCode=httpServletRequest.getParameterValues("prplCompensateEarFCode");
			String[] prplCompensateEarId_Card=httpServletRequest.getParameterValues("prplCompensateEarId_Card");
			String[] prplCompensateEarInusreListCode=httpServletRequest.getParameterValues("prplCompensateEarInusreListCode");
			String[] prplCompensateEarKindCode=httpServletRequest.getParameterValues("prplCompensateEarKindCode");
			String[] prplCompensateEarName=httpServletRequest.getParameterValues("prplCompensateEarName");
			String[] prplCompensateEarNodeNo=httpServletRequest.getParameterValues("prplCompensateEarNodeNo");
			String[] prplCompensateEarNodeType=httpServletRequest.getParameterValues("prplCompensateEarNodeType");
			String[] prplCompensateEarPolicyNo=httpServletRequest.getParameterValues("prplCompensateEarPolicyNo");
			String[] prplCompensateEarRegistNo=httpServletRequest.getParameterValues("prplCompensateEarRegistNo");
			String[] prplCompensateEarReportTime=httpServletRequest.getParameterValues("prplCompensateEarReportTime");
			String[] prplCompensateEarRestFee=httpServletRequest.getParameterValues("prplCompensateEarRestFee");
			String[] prplCompensateEarSumRealpay=httpServletRequest.getParameterValues("prplCompensateEarSumRealpay");
			String[] prplCompensateEarUnitAmount=httpServletRequest.getParameterValues("prplCompensateEarUnitAmount");
			
			//end��ֳ�ն����嵥�б��ֶζ���
			if(prplCheckRegistNoShow==null){
				
			}else{
			   if (prplCompensateEarEarNo == null){
			     }else{
				for(int index = 1;index < prplCompensateEarEarNo.length;index++)
				{
					prplCompensateEarDto = new PrplcompensateearDto();
							
					prplCompensateEarDto.setAccount(prplCompensateEarAccount[index]);
					prplCompensateEarDto.setBank(prplCompensateEarBank[index]);
					prplCompensateEarDto.setBreedingareacode(prplCompensateEarBreedingAreaCode[index]);
					prplCompensateEarDto.setBreedingareaname(prplCompensateEarBreedingAreaName[index]);
					prplCompensateEarDto.setCaseno(prplCompensateEarCaseNo[index]);
					prplCompensateEarDto.setClaimno(prplCompensateEarClaimNo[index]);
					prplCompensateEarDto.setClaimrate(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarClaimRate[index])));
					prplCompensateEarDto.setCombineno(httpServletRequest.getParameter("CombineNo"));
					prplCompensateEarDto.setCompensateno(prplCompensateEarCompensateNo[index]);
					prplCompensateEarDto.setCullnumber(Integer.valueOf(DataUtils.nullToZero(prplCompensateEarCullNumber[index])));
					prplCompensateEarDto.setDamagecode(prplCompensateEarDamageCode[index]);
					prplCompensateEarDto.setDamageenddate(new DateTime(prplCompensateEarDamageEndDate[index],DateTime.YEAR_TO_DAY));
					prplCompensateEarDto.setDamagename(prplCompensateEarDamageName[index]);
					prplCompensateEarDto.setDamagestartdate(new DateTime(httpServletRequest.getParameter("prpLregistDamageStartDate1"),DateTime.YEAR_TO_DAY));
					prplCompensateEarDto.setDamagestarthour(prplCompensateEarDamageStartHour[index]);
					prplCompensateEarDto.setDeadnumber(Integer.valueOf(DataUtils.nullToZero(prplCompensateEarDeadNumber[index])));
					prplCompensateEarDto.setDeadreason(prplCompensateEarDeadReason[index]);
					prplCompensateEarDto.setDeductible(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarDeductible[index])));
					prplCompensateEarDto.setDeductiblerate(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarDeductibleRate[index])));
					prplCompensateEarDto.setEarno(prplCompensateEarEarNo[index]);
					prplCompensateEarDto.setEstimateloss(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarEstimateLoss[index])));
					prplCompensateEarDto.setFcode(prplCompensateEarFCode[index]);
					prplCompensateEarDto.setId_card(prplCompensateEarId_Card[index]);
					prplCompensateEarDto.setInusrelistcode(prplCompensateEarInusreListCode[index]);
					prplCompensateEarDto.setKindcode(prplCompensateEarKindCode[index]);
					prplCompensateEarDto.setName(prplCompensateEarName[index]);
					if("check".equals(httpServletRequest.getParameter("nodeType")))
					{
						prplCompensateEarDto.setNodeno(2);
						prplCompensateEarDto.setNodetype("check");
					}
					if("certa".equals(httpServletRequest.getParameter("nodeType")))
					{
						prplCompensateEarDto.setNodeno(3);
						prplCompensateEarDto.setNodetype("certa");
					}
					
					prplCompensateEarDto.setPolicyno(prplCheckPolicyNoShow);
					prplCompensateEarDto.setRegistno(prplCheckRegistNoShow);
					prplCompensateEarDto.setBusinessno(prplCheckRegistNoShow);
					prplCompensateEarDto.setReporttime(prplCompensateEarReportTime[index]);
					prplCompensateEarDto.setRestfee(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarRestFee[index])));
					prplCompensateEarDto.setSumrealpay(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarSumRealpay[index])));
					prplCompensateEarDto.setUnitamount(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarUnitAmount[index])));
		
	    			prplCompensateEarDtoList.add(prplCompensateEarDto);
				}
			}
			}
			certainLossDto.setPrplCompensateEarDtoList(prplCompensateEarDtoList);
		
		return certainLossDto;
	}
	/**
	 * ���涨��ʱ��ֳ�ն����嵥����.
	 * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
	 * @param httpServletRequest
	 * @return ArrayList �������ݴ������ݽṹ
	 * @throws Exception
	 */
	public ArrayList earViewToDto(HttpServletRequest httpServletRequest) throws Exception
	{
			
		/*---------------------�Ʋ��˶�����ϸ�嵥�� prplCompensateEar ------------------------------------*/
		ArrayList prplCompensateEarDtoList = new ArrayList();
		PrplcompensateearDto prplCompensateEarDto = null;
		
  
		//�ӽ���õ���������
		String   prpLpropPolicyNo  = httpServletRequest.getParameter("prpLverifyLossPolicyNo");
		String   prpLpropRegistNo  = httpServletRequest.getParameter("prpLverifyLossRegistNo");

		//start��ֳ���嵥�б��ֶζ���add by �ž���
		String[] prplCompensateEarAccount=httpServletRequest.getParameterValues("prplCompensateEarAccount");
		String[] prplCompensateEarBank=httpServletRequest.getParameterValues("prplCompensateEarBank");
		String[] prplCompensateEarBreedingAreaCode=httpServletRequest.getParameterValues("prplCompensateEarBreedingAreaCode");
		String[] prplCompensateEarBreedingAreaName=httpServletRequest.getParameterValues("prplCompensateEarBreedingAreaName");
		String[] prplCompensateEarCaseNo=httpServletRequest.getParameterValues("prplCompensateEarCaseNo");
		String[] prplCompensateEarClaimNo=httpServletRequest.getParameterValues("prplCompensateEarClaimNo");
		String[] prplCompensateEarClaimRate=httpServletRequest.getParameterValues("prplCompensateEarClaimRate");
		String[] prplCompensateEarCombineNo=httpServletRequest.getParameterValues("prplCompensateEarCombineNo");
		String[] prplCompensateEarCompensateNo=httpServletRequest.getParameterValues("prplCompensateEarCompensateNo");
		String[] prplCompensateEarCullNumber=httpServletRequest.getParameterValues("prplCompensateEarCullNumber");
		String[] prplCompensateEarDamageCode=httpServletRequest.getParameterValues("prplCompensateEarDamageCode");
		String[] prplCompensateEarDamageEndDate=httpServletRequest.getParameterValues("prplCompensateEarDamageEndDate");
		String[] prplCompensateEarDamageName=httpServletRequest.getParameterValues("prplCompensateEarDamageName");
		String[] prplCompensateEarDamageStartDate=httpServletRequest.getParameterValues("prplCompensateEarDamageStartDate");
		String[] prplCompensateEarDamageStartHour=httpServletRequest.getParameterValues("prplCompensateEarDamageStartHour");
		String[] prplCompensateEarDeadNumber=httpServletRequest.getParameterValues("prplCompensateEarDeadNumber");
		String[] prplCompensateEarDeadReason=httpServletRequest.getParameterValues("prplCompensateEarDeadReason");
		String[] prplCompensateEarDeductible=httpServletRequest.getParameterValues("prplCompensateEarDeductible");
		String[] prplCompensateEarDeductibleRate=httpServletRequest.getParameterValues("prplCompensateEarDeductibleRate");
		String[] prplCompensateEarEarNo=httpServletRequest.getParameterValues("prplCompensateEarEarNo");
		String[] prplCompensateEarEstimateLoss=httpServletRequest.getParameterValues("prplCompensateEarEstimateLoss");
		String[] prplCompensateEarFCode=httpServletRequest.getParameterValues("prplCompensateEarFCode");
		String[] prplCompensateEarId_Card=httpServletRequest.getParameterValues("prplCompensateEarId_Card");
		String[] prplCompensateEarInusreListCode=httpServletRequest.getParameterValues("prplCompensateEarInusreListCode");
		String[] prplCompensateEarKindCode=httpServletRequest.getParameterValues("prplCompensateEarKindCode");
		String[] prplCompensateEarName=httpServletRequest.getParameterValues("prplCompensateEarName");
		String[] prplCompensateEarNodeNo=httpServletRequest.getParameterValues("prplCompensateEarNodeNo");
		String[] prplCompensateEarNodeType=httpServletRequest.getParameterValues("prplCompensateEarNodeType");
		String[] prplCompensateEarPolicyNo=httpServletRequest.getParameterValues("prplCompensateEarPolicyNo");
		String[] prplCompensateEarRegistNo=httpServletRequest.getParameterValues("prplCompensateEarRegistNo");
		String[] prplCompensateEarReportTime=httpServletRequest.getParameterValues("prplCompensateEarReportTime");
		String[] prplCompensateEarRestFee=httpServletRequest.getParameterValues("prplCompensateEarRestFee");
		String[] prplCompensateEarSumRealpay=httpServletRequest.getParameterValues("prplCompensateEarSumRealpay");
		String[] prplCompensateEarUnitAmount=httpServletRequest.getParameterValues("prplCompensateEarUnitAmount");

		//end��ֳ�ն����嵥�б��ֶζ���
		if (prplCompensateEarId_Card == null){
		}else{
			for(int index = 1;index < prplCompensateEarEarNo.length;index++)
			{
				prplCompensateEarDto = new PrplcompensateearDto();
						
				prplCompensateEarDto.setAccount(prplCompensateEarAccount[index]);
				prplCompensateEarDto.setBank(prplCompensateEarBank[index]);
				prplCompensateEarDto.setBreedingareacode(prplCompensateEarBreedingAreaCode[index]);
				prplCompensateEarDto.setBreedingareaname(prplCompensateEarBreedingAreaName[index]);
				prplCompensateEarDto.setCaseno(prplCompensateEarCaseNo[index]);
				prplCompensateEarDto.setClaimno(prplCompensateEarClaimNo[index]);
				prplCompensateEarDto.setClaimrate(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarClaimRate[index])));
				prplCompensateEarDto.setCombineno(httpServletRequest.getParameter("Combine"));
				prplCompensateEarDto.setCompensateno(prplCompensateEarCompensateNo[index]);
				prplCompensateEarDto.setCullnumber(Integer.valueOf(DataUtils.nullToZero(prplCompensateEarCullNumber[index])));
				prplCompensateEarDto.setDamagecode(prplCompensateEarDamageCode[index]);
				prplCompensateEarDto.setDamageenddate(new DateTime(prplCompensateEarDamageEndDate[index],DateTime.YEAR_TO_DAY));
				prplCompensateEarDto.setDamagename(prplCompensateEarDamageName[index]);
				prplCompensateEarDto.setDamagestartdate(new DateTime(prplCompensateEarDamageStartDate[index],DateTime.YEAR_TO_DAY));
				prplCompensateEarDto.setDamagestarthour(prplCompensateEarDamageStartHour[index]);
				prplCompensateEarDto.setDeadnumber(Integer.valueOf(DataUtils.nullToZero(prplCompensateEarDeadNumber[index])));
				prplCompensateEarDto.setDeadreason(prplCompensateEarDeadReason[index]);
				prplCompensateEarDto.setDeductible(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarDeductible[index])));
				prplCompensateEarDto.setDeductiblerate(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarDeductibleRate[index])));
				prplCompensateEarDto.setEarno(prplCompensateEarEarNo[index]);
				prplCompensateEarDto.setEstimateloss(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarEstimateLoss[index])));
				prplCompensateEarDto.setFcode(prplCompensateEarFCode[index]);
				prplCompensateEarDto.setId_card(prplCompensateEarId_Card[index]);
				prplCompensateEarDto.setInusrelistcode(prplCompensateEarInusreListCode[index]);
				prplCompensateEarDto.setKindcode(prplCompensateEarKindCode[index]);
				prplCompensateEarDto.setName(prplCompensateEarName[index]);
				prplCompensateEarDto.setNodeno(3);
				prplCompensateEarDto.setNodetype("certa");
				prplCompensateEarDto.setPolicyno(prpLpropPolicyNo);
				prplCompensateEarDto.setRegistno(prpLpropRegistNo);
				prplCompensateEarDto.setBusinessno(prpLpropRegistNo);
				prplCompensateEarDto.setReporttime(prplCompensateEarReportTime[index]);
				prplCompensateEarDto.setRestfee(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarRestFee[index])));
				prplCompensateEarDto.setSumrealpay(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarSumRealpay[index])));
				prplCompensateEarDto.setUnitamount(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarUnitAmount[index])));

				
    			prplCompensateEarDtoList.add(prplCompensateEarDto);
			}
	
		}
		return prplCompensateEarDtoList;
	}

	/**
	 * ���ɶ�����Ϣ��ϸ����
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param businessNo     ҵ�����
	 * @param editType   �༭����
	 * @throws Exception
	 */
	public void certainLossDtoView(HttpServletRequest httpServletRequest,String registNo,String editType) throws Exception
	{
		String riskCode=httpServletRequest.getParameter("riskCode");
		String lossItemCode = httpServletRequest.getParameter("lossItemCode");
		//�ǳ��գ�lossItemCodeĬ��Ϊ1,�����Ϳ����������вƲ�����ϸ��ɾ��������
		UICodeAction uiCodeAction1 = new UICodeAction();
		String strRiskType = uiCodeAction1.translateRiskCodetoRiskType(riskCode);
		if (("H").equals(strRiskType)&&("I").equals(strRiskType)){
		//�����ţ����������Ϊ0������Ϊ1��2��3��4��5�ȳ������
		     lossItemCode = "-2";
		}
		UICertainLossAction uiCertainLossAction = new UICertainLossAction();
		CertainLossDto certainLossDto = uiCertainLossAction.findByPrimaryKey(registNo.trim(),lossItemCode);
		PrpLverifyLossDto prpLverifyLossDto =  certainLossDto.getPrpLverifyLossDto();
		//���ö��������״̬Ϊ �����޸� (����������)
		if(prpLverifyLossDto==null){
			String msg="";
			msg ="δ���ֱ�����Ϊ��"+registNo.trim()+",���"+lossItemCode+"�Ķ�������,�����ǽ�����ע���������룡";
			throw new UserException(1,3,"�����ѯ",msg);
		}
		if (certainLossDto.getPrpLclaimStatusDto()!=null)
		{
			if (certainLossDto.getPrpLclaimStatusDto().getStatus().equals("7")) certainLossDto.getPrpLclaimStatusDto().setStatus("3");
			prpLverifyLossDto.setStatus(certainLossDto.getPrpLclaimStatusDto().getStatus());
		}
		else
		{
			//���ύ���Ѿ�������ϵ�״̬
			prpLverifyLossDto.setStatus("4");
		}
		String nodeStatus = httpServletRequest.getParameter("status");
		if(nodeStatus!=null){
			prpLverifyLossDto.setStatus(nodeStatus);
		}
		
		//��ѯ��ͬ�����ŵĳ��մ���
		DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
		dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
				prpLverifyLossDto.getPolicyNo(),prpLverifyLossDto.getRegistNo());
		//������ش��������ת��
		changeCodeToName(httpServletRequest,certainLossDto);
		
		if (prpLverifyLossDto.getClaimNo()==null||prpLverifyLossDto.getClaimNo().equals("")){
			DAAClaimViewHelper daaClaimViewHelper =new DAAClaimViewHelper ();
			prpLverifyLossDto.setClaimNo(daaClaimViewHelper.getLossClaimNo(registNo));
		}
		httpServletRequest.setAttribute("prpLverifyLossDto", prpLverifyLossDto);
		httpServletRequest.setAttribute("certainLossDto", certainLossDto);
		httpServletRequest.setAttribute("verifyPriceOpinionList", ICollections.getVerifyPriceOpinionList());
		httpServletRequest.setAttribute("verifyOpinionList", ICollections.getVerifyOpinionList()); // ���Ӻ������
		//start���ö�����嵥�б� add by �ž���
		String taskCode = SysConfig.getProperty("FamilySplittingFlag","claim");
		if (prpLverifyLossDto.getRiskCode() != null && taskCode.indexOf(prpLverifyLossDto.getRiskCode()) > -1) {
			ArrayList prplCompensateEarDtoList = new ArrayList();//�����嵥�б�
			if (registNo != null)
			{		
				BLPrplcompensateearFacade bLPrplcompensateearFacade = new BLPrplcompensateearFacade();

				prplCompensateEarDtoList = (ArrayList)bLPrplcompensateearFacade.getPrpLCompensateEarDtos(registNo, "certa",registNo);
			
			}
			httpServletRequest.setAttribute("prplCompensateEarDtoList", prplCompensateEarDtoList);//���ö�����嵥�б�
			httpServletRequest.setAttribute("familySplittingFlag", "true");//���ö�����嵥�б�
		}
		
		if(prpLverifyLossDto.getRiskCode() != null && ("0310".equals(prpLverifyLossDto.getRiskCode())||"0312".equals(prpLverifyLossDto.getRiskCode())))
		{
			ArrayList prplCompensateHouseDtoList = new ArrayList();
			if (registNo != null)
			{
				String nodetype = "propc";
				BLPrplcompensatehouseFacade bLPrplcompensatehouseFacade = new BLPrplcompensatehouseFacade();
				String condition = " registno='" + registNo + "' and nodetype='" + nodetype + "'";
				prplCompensateHouseDtoList = (ArrayList)bLPrplcompensatehouseFacade.findByConditions(condition);
			}
			httpServletRequest.setAttribute("prplCompensateHouseDtoList",prplCompensateHouseDtoList);
		}
		
		
		
		//end���ö�����嵥�б� add by �ž���
		//ȡ������������Ϣ
		getRegistCheckInfo(httpServletRequest, registNo);
		
		//���ø����ӱ���Ϣ������
		setSubInfo(httpServletRequest,certainLossDto);
		
		//���ù�������һ���ڵ��ύ��������Ϣ
		getSubmitNodes(httpServletRequest);
	}
	
	/**
	 * ��ȡ��������Ӧ�ı������鿱��Ϣ
	 * @param httpServletRequest
	 * @param registNo ������
	 * @throws Exception
	 */
	private void getRegistCheckInfo(HttpServletRequest httpServletRequest, String registNo)
			throws Exception {
		// ������Ϣ
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		PrpLregistDto prpLregistDtoTemp = blPrpLregistFacade.findByPrimaryKey(registNo);
		if(prpLregistDtoTemp == null) {
			throw new Exception("û�в�ѯ����ǰ��������Ӧ�ı�����Ϣ��");
		}
		String timeTemp = StringConvert.toStandardTime(prpLregistDtoTemp
				.getDamageStartHour());
		prpLregistDtoTemp.setDamageStartMinute(timeTemp.substring(3, 5));
		prpLregistDtoTemp.setDamageStartHour(timeTemp.substring(0, 2));
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDtoTemp);
		
		// �鿱��Ϣ
		UIPrpLcheckAction uiPrpLcheckAction = new UIPrpLcheckAction();
		PrpLcheckDto prpLcheckDtoTemp = uiPrpLcheckAction.findByPrimaryKey(registNo);
		if (prpLcheckDtoTemp == null) {
			prpLcheckDtoTemp = new PrpLcheckDto();
		}
		httpServletRequest.setAttribute("prpLcheckDtoTemp", prpLcheckDtoTemp);
	}
	
	/**
	 * ��д����ҳ�漰��ѯ����request������.
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param businessNo ҵ�����
	 * @param editType �༭����
	 * @throws Exception
	 */
	public void registDtoToView(HttpServletRequest httpServletRequest, String businessNo,
			String editType) throws Exception {
		PrpLregistDto prplregistDto = new PrpLregistDto();
		//�����ţ����������Ϊ0������Ϊ1��2��3��4��5�ȳ������ 
		String lossItemCode = DataUtils.nullToZero(httpServletRequest.getParameter("lossItemCode"));
		UICodeAction uiCodeAction = new UICodeAction();
		//ת��,������û�У���ȡһ��
		String claimNo = uiCodeAction.translateBusinessCode(businessNo, true);
		
		//�ж�ԭ���Ķ����Ƿ����
		UICertainLossAction uiCertainLossAction = new UICertainLossAction();
		CertainLossDto certainLossDto = uiCertainLossAction.findByPrimaryKey(businessNo,lossItemCode);

				
		PrpLverifyLossDto prpLverifyLossDto = new PrpLverifyLossDto();
	
		//������Ѿ����ڵĶ���
		if(certainLossDto.getPrpLverifyLossDto()!=null){
			prpLverifyLossDto = certainLossDto.getPrpLverifyLossDto();
			//���ö��������״̬Ϊ �����޸� (����������)
			prpLverifyLossDto.setClaimNo(claimNo);
			if (certainLossDto.getPrpLclaimStatusDto() != null) {
				if (certainLossDto.getPrpLclaimStatusDto().getStatus().equals("7"))
					certainLossDto.getPrpLclaimStatusDto().setStatus("3");
				prpLverifyLossDto.setStatus(certainLossDto.getPrpLclaimStatusDto().getStatus());
			} else {
				// ���ύ���Ѿ�������ϵ�״̬
				prpLverifyLossDto.setStatus("1");
			}
			String nodeStatus = httpServletRequest.getParameter("status");
			if(nodeStatus!=null){
				prpLverifyLossDto.setStatus(nodeStatus);
			}
			if(certainLossDto.getPrpLcarLossDtoList()==null||certainLossDto.getPrpLcarLossDtoList().size()<1){} else {}
		}else{
			UIRegistAction uiRegistAction = new UIRegistAction();
			RegistDto registDto = uiRegistAction.findByPrimaryKey(businessNo.trim());
			prplregistDto = registDto.getPrpLregistDto();
			// �����
			certainLossDto = new CertainLossDto();
			prpLverifyLossDto.setRegistNo(registDto.getPrpLregistDto().getRegistNo());
			prpLverifyLossDto.setClaimNo(claimNo);
			prpLverifyLossDto.setRiskCode(prplregistDto.getRiskCode());
			prpLverifyLossDto.setPolicyNo(prplregistDto.getPolicyNo());
			prpLverifyLossDto.setInsuredName(prplregistDto.getInsuredName());
			prpLverifyLossDto.setLicenseNo(prplregistDto.getLicenseNo());
			prpLverifyLossDto.setClauseType(prplregistDto.getClauseType());
			prpLverifyLossDto.setLossItemCode(httpServletRequest.getParameter("lossItemCode"));
			prpLverifyLossDto.setLossItemName(httpServletRequest.getParameter("lossItemName"));
			prpLverifyLossDto.setInsureCarFlag(httpServletRequest.getParameter("insureCarFlag"));
			prpLverifyLossDto.setCurrency("CNY");
			prpLverifyLossDto.setMakeCom(prplregistDto.getMakeCom());
			prpLverifyLossDto.setComCode(prplregistDto.getComCode());
			if("ZH03".equals(prplregistDto.getRiskCode())){
				prpLverifyLossDto.setRemark(prplregistDto.getRemark());
			}
			// ����ũ��ͳ�Ʋ���
			prpLverifyLossDto.setLossesNumber(prplregistDto.getLossesNumber());
			prpLverifyLossDto.setLossesUnitCode(prplregistDto.getLossesUnitCode());
			
			
			HttpSession session = httpServletRequest.getSession();
			UserDto user = (UserDto) session.getAttribute("user");
			prpLverifyLossDto.setHandlerCode            (user.getUserCode());
			prpLverifyLossDto.setHandlerName            (user.getUserName());
			prpLverifyLossDto.setDefLossDate (new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));

			prpLverifyLossDto.setFlag(prplregistDto.getFlag());
			certainLossDto.setPrpLregistExtDtoList(registDto.getPrpLregistExtDtoList());
			//����ʵ�������״̬Ϊ �°����Ǽ� (δ��������)
			prpLverifyLossDto.setStatus("1");
			
			//��prplacciperson���еõ������ߵ���Ϣ
			if(registDto.getPrplacciBenPersonDtoList()!=null){
            	ArrayList prpLpropDtoList = new ArrayList();
            	PrpLpropDto prpLpropDto  = null;
            	Iterator iterator = registDto.getPrplacciBenPersonDtoList().iterator();
            	while(iterator.hasNext()){
            		PrpLacciPersonDto prplacciBenPersonDto = (PrpLacciPersonDto)iterator.next();
            		prpLpropDto = new PrpLpropDto();
            		prpLpropDto.setFamilyName(prplacciBenPersonDto.getAcciName());
            		prpLpropDto.setFamilyNo(prplacciBenPersonDto.getFamilyNo());
            		prplacciBenPersonDto.setSerialNo(prplacciBenPersonDto.getSerialNo());
            		prpLpropDto.setCurrency("CNY");
            		prpLpropDtoList.add(prpLpropDto);
            	}
            	certainLossDto.setPrpLpropDtoList(prpLpropDtoList);
            }
		}
		//��ѯ��ͬ�����ŵĳ��մ���
		DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
		dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
				prpLverifyLossDto.getPolicyNo(),prpLverifyLossDto.getRegistNo());
		
		//������ش��������ת��
		changeCodeToName(httpServletRequest,certainLossDto);
		
		//���ô�����и�����ѡ�����б���Ϣ������
		//setSelectionList(httpServletRequest,businessNo);
		
		if (claimNo==null||claimNo.equals("")){
			DAAClaimViewHelper daaClaimViewHelper =new DAAClaimViewHelper ();
			prpLverifyLossDto.setClaimNo(daaClaimViewHelper.getLossClaimNo(businessNo));
		}
		//start���ö�����嵥�б� add by �ž���
		String taskCode = SysConfig.getProperty("FamilySplittingFlag","claim");
		if (prpLverifyLossDto.getRiskCode() != null && taskCode.indexOf(prpLverifyLossDto.getRiskCode()) > -1) {
			ArrayList prplCompensateEarDtoList = new ArrayList();//�����嵥�б�
			if (businessNo != null)
			{
				BLPrplcompensateearFacade bLPrplcompensateearFacade = new BLPrplcompensateearFacade();
				if (editType.equals("ADD")) {
					if ("check".equals(httpServletRequest
							.getParameter("nodeType"))) {
						prplCompensateEarDtoList = (ArrayList) bLPrplcompensateearFacade
								.getPrpLCompensateEarDtos(businessNo, "regis",businessNo);
					}
					if ("certa".equals(httpServletRequest
							.getParameter("nodeType"))) {

						prplCompensateEarDtoList = (ArrayList) bLPrplcompensateearFacade
								.getPrpLCompensateEarDtos(businessNo, "check",businessNo);

					}
				}
				if (editType.equals("EDIT") || editType.equals("SHOW")
						|| editType.equals("DELETE")) {
					prplCompensateEarDtoList = (ArrayList) bLPrplcompensateearFacade
							.getPrpLCompensateEarDtos(businessNo, "check",businessNo);
				}

			}
			httpServletRequest.setAttribute("prplCompensateEarDtoList", prplCompensateEarDtoList);//���ö�����嵥�б�
			httpServletRequest.setAttribute("familySplittingFlag", "true" );//���ö�����嵥�б�
		}
			
		//0310��ѯ�����嵥��Ϣ
		if (prpLverifyLossDto.getRiskCode() != null && ("0310".equals(prpLverifyLossDto.getRiskCode())||"0312".equals(prpLverifyLossDto.getRiskCode())))
		{
			ArrayList prplCompensateHouseDtoList = new ArrayList();//�嵥�б�
			if (businessNo != null)
			{
				BLPrplcompensatehouseFacade bLPrplcompensatehouseFacade = new BLPrplcompensatehouseFacade();
				if (editType.equals("ADD"))
				{
					if ("check".equals(httpServletRequest
							.getParameter("nodeType"))) {
						String condition2 = " registno='" + businessNo + "' and nodetype='regis' ";
						prplCompensateHouseDtoList = (ArrayList) bLPrplcompensatehouseFacade.findByConditions(condition2);
					}
					if ("propc".equals(httpServletRequest
							.getParameter("nodeType")))
					{
						String condition1 = " registno='" + businessNo + "' and nodetype='check' ";
						prplCompensateHouseDtoList = (ArrayList) bLPrplcompensatehouseFacade.findByConditions(condition1);
					
					}
					
				}
				if (editType.equals("EDIT") || editType.equals("SHOW") || editType.equals("DELETE"))
				{
					String nodetype = httpServletRequest.getParameter("nodeType");
					String condition = " registno='" + businessNo + "' and nodetype='" + nodetype + "' ";
					prplCompensateHouseDtoList = (ArrayList) bLPrplcompensatehouseFacade.findByConditions(condition);
				}
				httpServletRequest.setAttribute("prplCompensateHouseDtoList",prplCompensateHouseDtoList);
					
			}
		}
		
		//end���ö�����嵥�б� add by �ž���
		//���ö�����Ϣ���ݵ������
		httpServletRequest.setAttribute("prpLverifyLossDto", prpLverifyLossDto);
		httpServletRequest.setAttribute("prpLregistDto", prplregistDto); 
		httpServletRequest.setAttribute("certainLossDto", certainLossDto);
		
		// ��ȡ�������鿱��Ϣ
		this.getRegistCheckInfo(httpServletRequest, businessNo);
                                   
		//���ø����ӱ���Ϣ������  
		certainLossDto.setPrpLverifyLossDto(prpLverifyLossDto);
		setSubInfo(httpServletRequest,certainLossDto);
		
		//���Ӻ������       
		httpServletRequest.setAttribute("verifyOpinionList", ICollections.getVerifyOpinionList());
		
		//���ù�������һ���ڵ��ύ��������Ϣ
		getSubmitNodes(httpServletRequest);
	}
	
	/**
	 * ���ó���ʱ�����ĳб�������ũ��ʹ�ã���ֲ��û�ж��𣩣����������⸶�������ܳ���������������
	 * @param httpServletRequest
	 * @param riskType ���ִ���
	 * @param prpLregistDto ������Ϣ
	 * @throws Exception
	 */
	public void setStatQuantity(HttpServletRequest httpServletRequest, String riskType,
			String registNo) throws Exception {
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo); 
		if (riskType.equals("I")||riskType.equals("H")) {
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(prpLregistDto.getPolicyNo(),
					prpLregistDto.getDamageStartDate().toString(), prpLregistDto
							.getDamageStartHour());
			httpServletRequest.setAttribute("statQuantity", policyDto.getPrpCmainDto()
					.getStatQuantity());
		}
	}
	
	/**
	 * ����PrpPrepayDto�е��Ѿ����õĴ������ݣ��Դ����������ת��
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param prpLcaseNoDto    �����������
	 * @throws Exception
	 */
	private void changeCodeToName(HttpServletRequest httpServletRequest,
			CertainLossDto certainLossDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		if (certainLossDto.getPrpLpropDtoList() != null) {
			for (int i = 0; i < certainLossDto.getPrpLpropDtoList().size(); i++) {
				PrpLpropDto prpLpropDto = (PrpLpropDto) certainLossDto.getPrpLpropDtoList().get(i);
				String riskCode = prpLpropDto.getRiskCode();
				prpLpropDto.setFeeTypeName(uiCodeAction.translateCodeCode("PropertyFeeType",
						prpLpropDto.getFeeTypeCode(), true));
				prpLpropDto.setKindName(uiCodeAction.translateKindCode(riskCode, prpLpropDto
						.getKindCode(), true));
				prpLpropDto.setCurrencyName(uiCodeAction.translateCurrencyCode(prpLpropDto
						.getCurrency(), true));
			}
		}

		if (certainLossDto.getPrpLpersonDtoList() != null) {
			PrpLpersonDto prpLpersonDto = null;
			// �ձ�����ת��
			Iterator iterator2 = certainLossDto.getPrpLpersonDtoList().iterator();
			while (iterator2.hasNext()) {
				prpLpersonDto = (PrpLpersonDto) iterator2.next();
				String riskCode = prpLpersonDto.getRiskCode();
				prpLpersonDto.setKindName(uiCodeAction.translateKindCode(riskCode, prpLpersonDto
						.getKindCode(), true));
				prpLpersonDto.setItemName("test");
				prpLpersonDto.setCurrencyName(uiCodeAction.translateCurrencyCode(prpLpersonDto
						.getCurrency(), true));
				prpLpersonDto.setAreaName(uiCodeAction.translateCodeCode("DamageDistrict",
						prpLpersonDto.getAreaCode(), true));
			}
		}
	}
	
	/**
	 * ȡ��ʼ����Ϣ��Ҫ�����ݵ�����.
	 * ��д����ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȡ�ȡ��Щ��Ϣ��ҪһЩ��Σ�
	 * ���ǵ��ӿڵ�һ���ԣ�����Щ�����ΪDto��ʽ���룬Dto���þۺ϶��Ǽ̳еķ�ʽ��
	 * ������ü̳еķ�ʽ�ֲ㴦��������߼�����������������������.
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public CertainLossDto iniViewToDto(HttpServletRequest httpServletRequest) throws Exception
	{
		CertainLossDto certainLossDto = new CertainLossDto();
		return certainLossDto;
	}
	
	/**
	 * ��д����ҳ�漰��ѯ����request������.
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param certainLossDto ȡ���ĳ�ʼ����ϢDto
	 * @throws Exception
	 */
	public void dtoToView(HttpServletRequest httpServletRequest, CertainLossDto certainLossDto) throws Exception
	{
	}
	
	/**
	 * ����certainLossDto�еĸ��ӱ��ڵ���Ϣ������
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param certainLossDto    �����������
	 * @throws Exception
	 */
	private void setSubInfo(HttpServletRequest httpServletRequest,
			CertainLossDto certainLossDto) throws Exception
			{
		//Modify by chenrenda add begin 20050413
		httpServletRequest.setAttribute("partCodeList", ICollections.getPartCodeList());
		
		//Modify by chenrenda add end 20050413
		
		//����������Ϣ����˵�������б�׼������
		String riskCode = httpServletRequest.getParameter("riskCode");
		ArrayList<PrpLverifyLossExtDto> arrayListVerifyLossExt = new ArrayList();
		PrpLverifyLossExtDto prpLverifyLossExtDto  = new PrpLverifyLossExtDto();
		PrpLverifyLossExtDto prpLverifyLossExtDtoAdd  = new PrpLverifyLossExtDto();
		
		//��89��ģ������� start==
		BLPrpDriskFacade blPrpDriskFacade = new BLPrpDriskFacade();
        ArrayList<PrpDriskDto> prpDriskDtos = new ArrayList<PrpDriskDto>();
        String classCodeStr = AppConfig.get("sysconst.PROP_VERIFY_CLASS").trim();//ȡ��89��ģ�������
        String riskcodeStr = "";//��89��ģ������ֵ��ַ���
        String[] classCodeArr = classCodeStr.split(",");
        String conditions = "";
        if(classCodeArr != null){
        	conditions += " classcode in('";
        	for(int i=0;i<classCodeArr.length;i++){
        		conditions += classCodeArr[i]+"',";
        	}
        	conditions = conditions.substring(0,conditions.length()-1);//ɾ������","��
        	conditions += ")";
        	
        	prpDriskDtos = (ArrayList<PrpDriskDto>)blPrpDriskFacade.findByConditions(conditions);
        }
        if(prpDriskDtos != null && prpDriskDtos.size()>0){
        	for(int i=0;i<prpDriskDtos.size();i++){
        		PrpDriskDto prpDriskDto = prpDriskDtos.get(i); 
        		riskcodeStr += prpDriskDto.getRiskCode()+";";
        	}
        }
        //��89��ģ�������  end===
        
		if("0310".equals(riskCode)||"0312".equals(riskCode) || riskcodeStr.indexOf(riskCode)>0){
			prpLverifyLossExtDtoAdd.setTitle("�������");
			prpLverifyLossExtDtoAdd.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
			prpLverifyLossExtDtoAdd.setRiskCode(certainLossDto.getPrpLverifyLossDto().getRiskCode());
			prpLverifyLossExtDtoAdd.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
			prpLverifyLossExtDtoAdd.setInputHour(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND).getHour()+"ʱ"+new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND).getMinute()+"��");
			prpLverifyLossExtDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
			prpLverifyLossExtDto.setRiskCode(certainLossDto.getPrpLverifyLossDto().getRiskCode());
			arrayListVerifyLossExt = certainLossDto.getPrpLverifyLossExtDtoList();
					PrpLverifyLossExtDto prpLverifyLossExtDtoMax = new PrpLverifyLossExtDto();//���serialno��Ӧ������ڵ�
					int maxSerialNo = 0;
					if(arrayListVerifyLossExt != null){
						for(int i=0;i<arrayListVerifyLossExt.size();i++){
							PrpLverifyLossExtDto prpLverifyLossExtDto1 = arrayListVerifyLossExt.get(i);
							if(prpLverifyLossExtDto1.getSerialNo() > maxSerialNo){
								maxSerialNo = prpLverifyLossExtDto1.getSerialNo();
								prpLverifyLossExtDtoMax = prpLverifyLossExtDto1;
							}
						}
					}
			if(arrayListVerifyLossExt==null){
				arrayListVerifyLossExt = new ArrayList();
			}
			
			prpLverifyLossExtDtoAdd.setSerialNo(maxSerialNo+1);		
			String status = httpServletRequest.getParameter("status");
			//add by dongkun 
			//���0102���֣��ҵ���ǰ���е����serialno��Ӧ�Ľڵ㣬��� swflog�ڵ�״̬Ϊ0,�������ŵ�����ڵ�� nodetype=propc/certa && nodestatus=4 ������һ����
	//		if("0102".equals(riskCode)){
	//			if( 
	//					("0".equals(status) && arrayListVerifyLossExt.size()==0 )  
	//					|| ("3".equals(status) &&  "propv".equals(prpLverifyLossExtDtoMax.getNodeType()) &&  "5".equals(prpLverifyLossExtDtoMax.getStatus())  )
	//			  ){
	//				arrayListVerifyLossExt.add(prpLverifyLossExtDtoAdd);
	//			   }
	//		}else{
				if("0".equals(status) || "3".equals(status)){
					arrayListVerifyLossExt.add(prpLverifyLossExtDtoAdd);
				}
	//		}
			prpLverifyLossExtDto.setVerifyLossExtList(arrayListVerifyLossExt) ;
		}       
		httpServletRequest.setAttribute("prpLverifyLossExtDto", prpLverifyLossExtDto);
				
		//�Ʋ��˶�����ϸ�嵥�����б�׼������
		ArrayList arrayList4 = new ArrayList();
		PrpLpropDto prpLpropDto  = new PrpLpropDto();
		arrayList4 = certainLossDto.getPrpLpropDtoList();
		UIPolicyAction uiPolicyAction = new UIPolicyAction();
		PolicyDto policyDto = new PolicyDto();
		PrpCitemKindDto prpCitemKindDto =new PrpCitemKindDto(); 
		if (arrayList4 != null) {
	        for (int i = 0; i < arrayList4.size(); i++) {
	          PrpLpropDto prpLpropDto1 = (PrpLpropDto) arrayList4.get(i);
	          prpCitemKindDto = uiPolicyAction.findPrpCitemKindDtoByConditions(prpLpropDto1.getPolicyNo(), prpLpropDto1.getKindCode());
	          prpLpropDto1.setKindName(prpCitemKindDto.getKindName());
	        }
	    }
		prpLpropDto.setPropList(arrayList4);
		httpServletRequest.setAttribute("prpLpropDto", prpLpropDto);
		
		
//		�����˻����
		Collection compensateBackOptionsList =ICollections.getCompensateBackList();
		httpServletRequest.setAttribute("compensateBackOptionsList",compensateBackOptionsList);
	
			}
	/**
	 * ����Ƿ��ѳ��ⰸ������
	 * ����ֵ   true �ѳ�        false δ��
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param claimNo �ⰸ��
	 * @throws Exception
	 */
	public boolean checkCompensate(HttpServletRequest httpServletRequest, String registNo) throws Exception
	{
		//���ݱ�������ȡ�ö�Ӧ���ⰸ����
		UICodeAction uiCodeAction = new UICodeAction();
		String claimNo = uiCodeAction.translateBusinessCode(registNo,true);
		//ȡ������������Ϣ
		UICompensateAction uICompensateAction = new UICompensateAction();
		String conditions =  "claimNo ='"+claimNo.trim()+"'" ;
		ArrayList arraylist = (ArrayList)uICompensateAction.findByConditions(conditions);
		if(arraylist==null || arraylist.size()<1){
			return false;
		} else {
			return true;
		}
	}
	
	
	/**
	 * ��ѯ��������������ѡ��Ľڵ�����
	 * @param modelNo String
	 * @param nodeNo String
	 * @throws Exception
	 */
	private void getSubmitNodes(HttpServletRequest httpServletRequest) throws Exception
	{
		String modelNo= httpServletRequest.getParameter("modelNo"); //ģ���
		String nodeNo= httpServletRequest.getParameter("nodeNo");   //�ڵ��
		int nextNodeNo=0;
		Collection pathList = new ArrayList();
		SwfPathDto swfPathDto  = new SwfPathDto() ;
		WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
		//System.out.println("$$$$$$$$$$$$$$$$44"+modelNo+"++"+nodeNo);
		if (modelNo!=null&& nodeNo!=null)
		{
			pathList = workFlowViewHelper.getNextSumbitNodes(modelNo,nodeNo);
			if (pathList.iterator() .hasNext() )
			{
				SwfPathDto swfPathDtoTemp = new SwfPathDto();
				swfPathDtoTemp=(SwfPathDto)pathList.iterator().next();
				nextNodeNo = swfPathDtoTemp.getEndNodeNo();
				swfPathDto.setNextNodeNo(nextNodeNo);
			}
		}
		swfPathDto.setPathList(pathList);
		httpServletRequest.setAttribute("pathList",pathList);
		httpServletRequest.setAttribute("swfPathDto",swfPathDto);
	}
	
}
