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
 * <p>Description:定损ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2004</p>
 * @author 车险理赔项目组 liubvo
 * @version 1.0
 * <br>
 */

public class AgriCertainLossViewHelper extends CertainLossViewHelper{
	
	/**
	 * 保存定损时定损页面数据整理.
	 * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
	 * @param httpServletRequest
	 * @return certainLossDto 定损数据传输数据结构
	 * @throws Exception
	 */
	public CertainLossDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
	{
		//继承对certainLoss,certainLossText表的赋值
		CertainLossDto certainLossDto = super.viewToDto(httpServletRequest);
		
		//add by lixiang start 20051228
		//reason: 因为考虑到录入的时候，可能没有立案，但是在提交的时候，做了立案，导致立案号没写入。
		//先取立案号码，很重要，不要从页面上取得。。。
		String claimNo=httpServletRequest.getParameter("prpLverifyLossClaimNo");
		String registNo  = httpServletRequest.getParameter("prpLverifyLossRegistNo");
		if (claimNo==null||claimNo.length()<2){
			UICodeAction uiCodeAction = new UICodeAction();
			claimNo=uiCodeAction.translateBusinessCode(registNo,true);
		}
		//add by lixiang end 20051228
		
		/*---------------------财产核定损明细清单表 prpLprop ------------------------------------*/
		ArrayList prpLpropDtoList = new ArrayList();
		PrpLpropDto prpLpropDto = null;
		
		//定核损处理标的表
		PrpLverifyLossItemDto LossItemPropDto = new PrpLverifyLossItemDto();
		ArrayList lossItemListTemp = new ArrayList();
		//从界面得到输入数组
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
		//0313碎屏险添加imei码 add by wangxinyang 2018/6/15
		String[]   prpLpropImei						 =httpServletRequest.getParameterValues("prpLpropImei");
		
//		add by lixiang start at 2006-04-21
	    //reason: 增加保存理算退回的定损的标志的保存,若有数据不会被保存冲掉
	  String[]   prpLpropCompensateBackFlag  = httpServletRequest.getParameterValues("prpLpropCompensateBackFlag");
	  UICodeAction uiCodeAction = new UICodeAction();
	  String strRiskType = uiCodeAction.translateRiskCodetoRiskType(prpLpropRiskCode);
		//add by lixiang end at 2006-04-21
//对象赋值
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
		        //加入集合
				prpLpropDtoList.add(prpLpropDto);
			}
			PropertyUtils.copyProperties(LossItemPropDto,certainLossDto.getPrpLverifyLossDto());
			LossItemPropDto.setSerialNo(3);
			LossItemPropDto.setLossType("3");
			LossItemPropDto.setNodeType("certa");
			lossItemListTemp.add(LossItemPropDto);
		}
		//走89号模板的险种 start==
		BLPrpDriskFacade blPrpDriskFacade = new BLPrpDriskFacade();
        ArrayList<PrpDriskDto> prpDriskDtos = new ArrayList<PrpDriskDto>();
        String classCodeStr = AppConfig.get("sysconst.PROP_VERIFY_CLASS").trim();//取走89号模板的险类
        String riskcodeStr = "";//走89号模板的险种的字符串
        String[] classCodeArr = classCodeStr.split(",");
        String conditions = "";
        if(classCodeArr != null){
        	conditions += " classcode in('";
        	for(int i=0;i<classCodeArr.length;i++){
        		conditions += classCodeArr[i]+"',";
        	}
        	conditions = conditions.substring(0,conditions.length()-1);//删除最后的","号
        	conditions += ")";
        	
        	prpDriskDtos = (ArrayList<PrpDriskDto>)blPrpDriskFacade.findByConditions(conditions);
        }
        if(prpDriskDtos != null && prpDriskDtos.size()>0){
        	for(int i=0;i<prpDriskDtos.size();i++){
        		PrpDriskDto prpDriskDto = prpDriskDtos.get(i); 
        		riskcodeStr += prpDriskDto.getRiskCode()+";";
        	}
        }
        //走89号模板的险种  end===
        
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
	    				if ("2".equals(nodeStatus) && riskcodeStr.indexOf(prpLpropRiskCode)>0){//删除最后一个元素 最大serialno
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
		//财产核定损明细清单表
		certainLossDto.setPrpLpropDtoList(prpLpropDtoList);
		/*---------------------报案信息补充说明 PrpLregistExt ------------------------------------*/
		ArrayList prpLregistExtDtoList = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = null ;
		//从界面得到输入数组
		
		String prpLregistExtRegistNo = (String)httpServletRequest.getParameter("prpLregistExtRegistNo"); 
		String prpLregistExtRiskCode = httpServletRequest.getParameter      ("prpLregistExtRiskCode");
		String[] prpLregistExtSerialNo = httpServletRequest.getParameterValues("prpLregistExtSerialNo");
		String[] prpLregistExtInputDate = httpServletRequest.getParameterValues("prpLregistExtInputDate");
		String[] prpLregistExtInputHour = httpServletRequest.getParameterValues("prpLregistExtInputHour");
		String[] prpLregistExtOperatorCode = httpServletRequest.getParameterValues("prpLregistExtOperatorCode");
		String[] prpLregistExtContext = httpServletRequest.getParameterValues("prpLregistExtContext");
		
		//对象赋值
		//人员伤亡跟踪 部分开始
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
				//加入集合
				prpLregistExtDtoList.add(prpLregistExtDto);
			}
			//报案集合中加入损失部位
			certainLossDto.setPrpLregistExtDtoList(prpLregistExtDtoList);
		}  
		/*---------------------农房理赔清单表 prplCompensateHouse ------------------------------------*/
		
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
		    	 //System.err.println("长度:" + prplCompensateHouseDtoList.size());
		    	 certainLossDto.setPrplCompensateHouseDtoList(prplCompensateHouseDtoList); 	 
		     }
		}
		
			
		/*---------------------耳标号清单表 prplCompensateEar ------------------------------------*/
		
			ArrayList prplCompensateEarDtoList = new ArrayList();
			PrplcompensateearDto prplCompensateEarDto = null;
			
	  
			//从界面得到输入数组
			String   prplCheckPolicyNoShow  = httpServletRequest.getParameter("prplCheckPolicyNoShow");
			String   prplCheckRegistNoShow  = httpServletRequest.getParameter("prplCheckRegistNoShow");

			//start养殖险清单列表字段定义add by 张菊卿
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
			
			//end养殖险耳标清单列表字段定义
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
	 * 保存定损时养殖险定损清单数据.
	 * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
	 * @param httpServletRequest
	 * @return ArrayList 定损数据传输数据结构
	 * @throws Exception
	 */
	public ArrayList earViewToDto(HttpServletRequest httpServletRequest) throws Exception
	{
			
		/*---------------------财产核定损明细清单表 prplCompensateEar ------------------------------------*/
		ArrayList prplCompensateEarDtoList = new ArrayList();
		PrplcompensateearDto prplCompensateEarDto = null;
		
  
		//从界面得到输入数组
		String   prpLpropPolicyNo  = httpServletRequest.getParameter("prpLverifyLossPolicyNo");
		String   prpLpropRegistNo  = httpServletRequest.getParameter("prpLverifyLossRegistNo");

		//start养殖险清单列表字段定义add by 张菊卿
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

		//end养殖险耳标清单列表字段定义
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
	 * 生成定损信息详细画面
	 * @param httpServletRequest 返回给页面的request
	 * @param businessNo     业务号码
	 * @param editType   编辑类型
	 * @throws Exception
	 */
	public void certainLossDtoView(HttpServletRequest httpServletRequest,String registNo,String editType) throws Exception
	{
		String riskCode=httpServletRequest.getParameter("riskCode");
		String lossItemCode = httpServletRequest.getParameter("lossItemCode");
		//非车险，lossItemCode默认为1,这样就可以正常进行财产险详细的删除操作了
		UICodeAction uiCodeAction1 = new UICodeAction();
		String strRiskType = uiCodeAction1.translateRiskCodetoRiskType(riskCode);
		if (("H").equals(strRiskType)&&("I").equals(strRiskType)){
		//标的序号，如果是人伤为0，否则为1，2，3，4，5等车辆序号
		     lossItemCode = "-2";
		}
		UICertainLossAction uiCertainLossAction = new UICertainLossAction();
		CertainLossDto certainLossDto = uiCertainLossAction.findByPrimaryKey(registNo.trim(),lossItemCode);
		PrpLverifyLossDto prpLverifyLossDto =  certainLossDto.getPrpLverifyLossDto();
		//设置定损操作的状态为 案件修改 (正处理任务)
		if(prpLverifyLossDto==null){
			String msg="";
			msg ="未发现报案号为："+registNo.trim()+",序号"+lossItemCode+"的定损数据,可能是进行了注销拒赔申请！";
			throw new UserException(1,3,"定损查询",msg);
		}
		if (certainLossDto.getPrpLclaimStatusDto()!=null)
		{
			if (certainLossDto.getPrpLclaimStatusDto().getStatus().equals("7")) certainLossDto.getPrpLclaimStatusDto().setStatus("3");
			prpLverifyLossDto.setStatus(certainLossDto.getPrpLclaimStatusDto().getStatus());
		}
		else
		{
			//已提交，已经处理完毕的状态
			prpLverifyLossDto.setStatus("4");
		}
		String nodeStatus = httpServletRequest.getParameter("status");
		if(nodeStatus!=null){
			prpLverifyLossDto.setStatus(nodeStatus);
		}
		
		//查询相同保单号的出险次数
		DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
		dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
				prpLverifyLossDto.getPolicyNo(),prpLverifyLossDto.getRegistNo());
		//设置相关代码的中文转换
		changeCodeToName(httpServletRequest,certainLossDto);
		
		if (prpLverifyLossDto.getClaimNo()==null||prpLverifyLossDto.getClaimNo().equals("")){
			DAAClaimViewHelper daaClaimViewHelper =new DAAClaimViewHelper ();
			prpLverifyLossDto.setClaimNo(daaClaimViewHelper.getLossClaimNo(registNo));
		}
		httpServletRequest.setAttribute("prpLverifyLossDto", prpLverifyLossDto);
		httpServletRequest.setAttribute("certainLossDto", certainLossDto);
		httpServletRequest.setAttribute("verifyPriceOpinionList", ICollections.getVerifyPriceOpinionList());
		httpServletRequest.setAttribute("verifyOpinionList", ICollections.getVerifyOpinionList()); // 增加核损意见
		//start设置耳标号清单列表 add by 张菊卿
		String taskCode = SysConfig.getProperty("FamilySplittingFlag","claim");
		if (prpLverifyLossDto.getRiskCode() != null && taskCode.indexOf(prpLverifyLossDto.getRiskCode()) > -1) {
			ArrayList prplCompensateEarDtoList = new ArrayList();//耳标清单列表
			if (registNo != null)
			{		
				BLPrplcompensateearFacade bLPrplcompensateearFacade = new BLPrplcompensateearFacade();

				prplCompensateEarDtoList = (ArrayList)bLPrplcompensateearFacade.getPrpLCompensateEarDtos(registNo, "certa",registNo);
			
			}
			httpServletRequest.setAttribute("prplCompensateEarDtoList", prplCompensateEarDtoList);//设置耳标号清单列表
			httpServletRequest.setAttribute("familySplittingFlag", "true");//设置耳标号清单列表
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
		
		
		
		//end设置耳标号清单列表 add by 张菊卿
		//取得相关主表的信息
		getRegistCheckInfo(httpServletRequest, registNo);
		
		//设置各个子表信息项到窗体表单
		setSubInfo(httpServletRequest,certainLossDto);
		
		//设置工作流下一个节点提交的配置信息
		getSubmitNodes(httpServletRequest);
	}
	
	/**
	 * 获取报案号相应的报案及查勘信息
	 * @param httpServletRequest
	 * @param registNo 报案号
	 * @throws Exception
	 */
	private void getRegistCheckInfo(HttpServletRequest httpServletRequest, String registNo)
			throws Exception {
		// 报案信息
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		PrpLregistDto prpLregistDtoTemp = blPrpLregistFacade.findByPrimaryKey(registNo);
		if(prpLregistDtoTemp == null) {
			throw new Exception("没有查询到当前报案号相应的报案信息！");
		}
		String timeTemp = StringConvert.toStandardTime(prpLregistDtoTemp
				.getDamageStartHour());
		prpLregistDtoTemp.setDamageStartMinute(timeTemp.substring(3, 5));
		prpLregistDtoTemp.setDamageStartHour(timeTemp.substring(0, 2));
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDtoTemp);
		
		// 查勘信息
		UIPrpLcheckAction uiPrpLcheckAction = new UIPrpLcheckAction();
		PrpLcheckDto prpLcheckDtoTemp = uiPrpLcheckAction.findByPrimaryKey(registNo);
		if (prpLcheckDtoTemp == null) {
			prpLcheckDtoTemp = new PrpLcheckDto();
		}
		httpServletRequest.setAttribute("prpLcheckDtoTemp", prpLcheckDtoTemp);
	}
	
	/**
	 * 填写定损页面及查询定损request的生成.
	 * @param httpServletRequest 返回给页面的request
	 * @param businessNo 业务号码
	 * @param editType 编辑类型
	 * @throws Exception
	 */
	public void registDtoToView(HttpServletRequest httpServletRequest, String businessNo,
			String editType) throws Exception {
		PrpLregistDto prplregistDto = new PrpLregistDto();
		//标的序号，如果是人伤为0，否则为1，2，3，4，5等车辆序号 
		String lossItemCode = DataUtils.nullToZero(httpServletRequest.getParameter("lossItemCode"));
		UICodeAction uiCodeAction = new UICodeAction();
		//转换,无论有没有，都取一次
		String claimNo = uiCodeAction.translateBusinessCode(businessNo, true);
		
		//判断原来的定损是否存在
		UICertainLossAction uiCertainLossAction = new UICertainLossAction();
		CertainLossDto certainLossDto = uiCertainLossAction.findByPrimaryKey(businessNo,lossItemCode);

				
		PrpLverifyLossDto prpLverifyLossDto = new PrpLverifyLossDto();
	
		//如果是已经存在的定损
		if(certainLossDto.getPrpLverifyLossDto()!=null){
			prpLverifyLossDto = certainLossDto.getPrpLverifyLossDto();
			//设置定损操作的状态为 案件修改 (正处理任务)
			prpLverifyLossDto.setClaimNo(claimNo);
			if (certainLossDto.getPrpLclaimStatusDto() != null) {
				if (certainLossDto.getPrpLclaimStatusDto().getStatus().equals("7"))
					certainLossDto.getPrpLclaimStatusDto().setStatus("3");
				prpLverifyLossDto.setStatus(certainLossDto.getPrpLclaimStatusDto().getStatus());
			} else {
				// 已提交，已经处理完毕的状态
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
			// 定损表
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
			// 设置农险统计参数
			prpLverifyLossDto.setLossesNumber(prplregistDto.getLossesNumber());
			prpLverifyLossDto.setLossesUnitCode(prplregistDto.getLossesUnitCode());
			
			
			HttpSession session = httpServletRequest.getSession();
			UserDto user = (UserDto) session.getAttribute("user");
			prpLverifyLossDto.setHandlerCode            (user.getUserCode());
			prpLverifyLossDto.setHandlerName            (user.getUserName());
			prpLverifyLossDto.setDefLossDate (new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));

			prpLverifyLossDto.setFlag(prplregistDto.getFlag());
			certainLossDto.setPrpLregistExtDtoList(registDto.getPrpLregistExtDtoList());
			//设置实赔操作的状态为 新案件登记 (未处理任务)
			prpLverifyLossDto.setStatus("1");
			
			//从prplacciperson表中得到出险者的信息
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
		//查询相同保单号的出险次数
		DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
		dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
				prpLverifyLossDto.getPolicyNo(),prpLverifyLossDto.getRegistNo());
		
		//设置相关代码的中文转换
		changeCodeToName(httpServletRequest,certainLossDto);
		
		//设置窗体表单中各个多选框中列表信息的内容
		//setSelectionList(httpServletRequest,businessNo);
		
		if (claimNo==null||claimNo.equals("")){
			DAAClaimViewHelper daaClaimViewHelper =new DAAClaimViewHelper ();
			prpLverifyLossDto.setClaimNo(daaClaimViewHelper.getLossClaimNo(businessNo));
		}
		//start设置耳标号清单列表 add by 张菊卿
		String taskCode = SysConfig.getProperty("FamilySplittingFlag","claim");
		if (prpLverifyLossDto.getRiskCode() != null && taskCode.indexOf(prpLverifyLossDto.getRiskCode()) > -1) {
			ArrayList prplCompensateEarDtoList = new ArrayList();//耳标清单列表
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
			httpServletRequest.setAttribute("prplCompensateEarDtoList", prplCompensateEarDtoList);//设置耳标号清单列表
			httpServletRequest.setAttribute("familySplittingFlag", "true" );//设置耳标号清单列表
		}
			
		//0310查询理赔清单信息
		if (prpLverifyLossDto.getRiskCode() != null && ("0310".equals(prpLverifyLossDto.getRiskCode())||"0312".equals(prpLverifyLossDto.getRiskCode())))
		{
			ArrayList prplCompensateHouseDtoList = new ArrayList();//清单列表
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
		
		//end设置耳标号清单列表 add by 张菊卿
		//设置定损信息内容到窗体表单
		httpServletRequest.setAttribute("prpLverifyLossDto", prpLverifyLossDto);
		httpServletRequest.setAttribute("prpLregistDto", prplregistDto); 
		httpServletRequest.setAttribute("certainLossDto", certainLossDto);
		
		// 获取报案及查勘信息
		this.getRegistCheckInfo(httpServletRequest, businessNo);
                                   
		//设置各个子表信息项到窗体表单  
		certainLossDto.setPrpLverifyLossDto(prpLverifyLossDto);
		setSubInfo(httpServletRequest,certainLossDto);
		
		//增加核损意见       
		httpServletRequest.setAttribute("verifyOpinionList", ICollections.getVerifyOpinionList());
		
		//设置工作流下一个节点提交的配置信息
		getSubmitNodes(httpServletRequest);
	}
	
	/**
	 * 设置出险时保单的承保数量，农险使用（种植险没有定损），用来控制赔付数量不能超过保单的总数量
	 * @param httpServletRequest
	 * @param riskType 险种大类
	 * @param prpLregistDto 报案信息
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
	 * 根据PrpPrepayDto中的已经设置的代码内容，对代码进行名称转换
	 * @param httpServletRequest 返回给页面的request
	 * @param prpLcaseNoDto    定损的数据类
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
			// 险别名称转换
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
	 * 取初始化信息需要的数据的整理.
	 * 填写定损单时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等。取这些信息需要一些入参，
	 * 考虑到接口的一致性，将这些入参作为Dto方式传入，Dto利用聚合而非继承的方式。
	 * 整理采用继承的方式分层处理，具体的逻辑放在险种险类子类中整理.
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public CertainLossDto iniViewToDto(HttpServletRequest httpServletRequest) throws Exception
	{
		CertainLossDto certainLossDto = new CertainLossDto();
		return certainLossDto;
	}
	
	/**
	 * 填写定损页面及查询定损request的生成.
	 * @param httpServletRequest 返回给页面的request
	 * @param certainLossDto 取出的初始化信息Dto
	 * @throws Exception
	 */
	public void dtoToView(HttpServletRequest httpServletRequest, CertainLossDto certainLossDto) throws Exception
	{
	}
	
	/**
	 * 根据certainLossDto中的各子表内的信息填充界面
	 * @param httpServletRequest 返回给页面的request
	 * @param certainLossDto    定损的数据类
	 * @throws Exception
	 */
	private void setSubInfo(HttpServletRequest httpServletRequest,
			CertainLossDto certainLossDto) throws Exception
			{
		//Modify by chenrenda add begin 20050413
		httpServletRequest.setAttribute("partCodeList", ICollections.getPartCodeList());
		
		//Modify by chenrenda add end 20050413
		
		//给定核损信息补充说明多行列表准备数据
		String riskCode = httpServletRequest.getParameter("riskCode");
		ArrayList<PrpLverifyLossExtDto> arrayListVerifyLossExt = new ArrayList();
		PrpLverifyLossExtDto prpLverifyLossExtDto  = new PrpLverifyLossExtDto();
		PrpLverifyLossExtDto prpLverifyLossExtDtoAdd  = new PrpLverifyLossExtDto();
		
		//走89号模板的险种 start==
		BLPrpDriskFacade blPrpDriskFacade = new BLPrpDriskFacade();
        ArrayList<PrpDriskDto> prpDriskDtos = new ArrayList<PrpDriskDto>();
        String classCodeStr = AppConfig.get("sysconst.PROP_VERIFY_CLASS").trim();//取走89号模板的险类
        String riskcodeStr = "";//走89号模板的险种的字符串
        String[] classCodeArr = classCodeStr.split(",");
        String conditions = "";
        if(classCodeArr != null){
        	conditions += " classcode in('";
        	for(int i=0;i<classCodeArr.length;i++){
        		conditions += classCodeArr[i]+"',";
        	}
        	conditions = conditions.substring(0,conditions.length()-1);//删除最后的","号
        	conditions += ")";
        	
        	prpDriskDtos = (ArrayList<PrpDriskDto>)blPrpDriskFacade.findByConditions(conditions);
        }
        if(prpDriskDtos != null && prpDriskDtos.size()>0){
        	for(int i=0;i<prpDriskDtos.size();i++){
        		PrpDriskDto prpDriskDto = prpDriskDtos.get(i); 
        		riskcodeStr += prpDriskDto.getRiskCode()+";";
        	}
        }
        //走89号模板的险种  end===
        
		if("0310".equals(riskCode)||"0312".equals(riskCode) || riskcodeStr.indexOf(riskCode)>0){
			prpLverifyLossExtDtoAdd.setTitle("定损完成");
			prpLverifyLossExtDtoAdd.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
			prpLverifyLossExtDtoAdd.setRiskCode(certainLossDto.getPrpLverifyLossDto().getRiskCode());
			prpLverifyLossExtDtoAdd.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
			prpLverifyLossExtDtoAdd.setInputHour(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND).getHour()+"时"+new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND).getMinute()+"分");
			prpLverifyLossExtDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
			prpLverifyLossExtDto.setRiskCode(certainLossDto.getPrpLverifyLossDto().getRiskCode());
			arrayListVerifyLossExt = certainLossDto.getPrpLverifyLossExtDtoList();
					PrpLverifyLossExtDto prpLverifyLossExtDtoMax = new PrpLverifyLossExtDto();//最大serialno对应的意见节点
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
			//针对0102险种，找到当前库中的最大serialno对应的节点，如果 swflog节点状态为0,且最大序号的意见节点的 nodetype=propc/certa && nodestatus=4 则新增一条。
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
				
		//财产核定损明细清单多行列表准备数据
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
		
		
//		理算退回意见
		Collection compensateBackOptionsList =ICollections.getCompensateBackList();
		httpServletRequest.setAttribute("compensateBackOptionsList",compensateBackOptionsList);
	
			}
	/**
	 * 检查是否已出赔案计算书
	 * 返回值   true 已出        false 未出
	 * @param httpServletRequest 返回给页面的request
	 * @param claimNo 赔案号
	 * @throws Exception
	 */
	public boolean checkCompensate(HttpServletRequest httpServletRequest, String registNo) throws Exception
	{
		//根据报案号码取得对应的赔案号码
		UICodeAction uiCodeAction = new UICodeAction();
		String claimNo = uiCodeAction.translateBusinessCode(registNo,true);
		//取得赔款计算书信息
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
	 * 查询工作流可以用来选择的节点内容
	 * @param modelNo String
	 * @param nodeNo String
	 * @throws Exception
	 */
	private void getSubmitNodes(HttpServletRequest httpServletRequest) throws Exception
	{
		String modelNo= httpServletRequest.getParameter("modelNo"); //模板号
		String nodeNo= httpServletRequest.getParameter("nodeNo");   //节点号
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
