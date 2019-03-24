package com.sinosoft.claim.ui.control.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.bl.action.domain.BLSwfFlowMainAction;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.CompensateFeeDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.claim.ui.model.CompensateAppendInfoCommand;
import com.sinosoft.claim.ui.model.CompensateApproveCommand;
import com.sinosoft.claim.ui.model.CompensateApproveQueryCommand;
import com.sinosoft.claim.ui.model.CompensateBackToCertaCommand;
import com.sinosoft.claim.ui.model.CompensateByClaimNoCommand;
import com.sinosoft.claim.ui.model.CompensateDeleteCommand;
import com.sinosoft.claim.ui.model.CompensateFeeByClaimNoCommand;
import com.sinosoft.claim.ui.model.CompensateFindByConCommand;
import com.sinosoft.claim.ui.model.CompensateIsExistCommand;
import com.sinosoft.claim.ui.model.CompensateQueryCommand;
import com.sinosoft.claim.ui.model.CompensateSaveCommand;
import com.sinosoft.claim.ui.model.PrpLPersonLossFindbyConditionsCommand;
import com.sinosoft.claim.ui.model.PrpLcompensateFindByConCommand;
import com.sinosoft.claim.ui.model.PrpLlossFindbyConditionsCommand;
import com.sinosoft.prpall.ui.control.action.UIPrpCmainAction;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * ʵ�����Compensate
 * <p>Title: ������������ʵ��action  </p>
 * <p>Description: ������������ʵ��action</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p> 
 * @author liubvo
 * @version 1.0 
 */
public class UICompensateAction
{
  /**
   * ����ʵ��
   * @param CompensateDto��ʵ�����DTO
   * @throws Exception
   */
  public void save(CompensateDto compensateDto) throws SQLException,Exception
  {
  	CompensateSaveCommand compensateSaveCommand = new CompensateSaveCommand(compensateDto);
  	compensateSaveCommand.execute();
  }
  
  /**
   * ����ʵ���������
   * @param CompensateDto��ʵ�����DTO
   * @throws Exception
   */
  public void save(CompensateDto compensateDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
  	CompensateSaveCommand compensateSaveCommand = new CompensateSaveCommand(compensateDto,workFlowDto);
  	compensateSaveCommand.execute();
  }
  /**
   * ɾ��ʵ��
   * @param compensateNo��ʵ���
   * @throws Exception
   */
  public void delete(String compensateNo) throws SQLException,Exception
  {
    CompensateDeleteCommand compensateDeleteCommand = new CompensateDeleteCommand(compensateNo);
  	compensateDeleteCommand.execute();
  }

  /**
   * ���ʵ����Ϣ
   * @param  compensateNo��ʵ���
   * @return ʵ�����
   * @throws Exception
   */
  public CompensateDto findByPrimaryKey(String compensateNo) throws SQLException,UserException,Exception
  {
  	CompensateFindByConCommand compensateFindByConCommand = new CompensateFindByConCommand(compensateNo);
  	CompensateDto compensateDto = (CompensateDto)compensateFindByConCommand.execute();

    if (compensateDto == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+compensateNo+")");
    }
    return compensateDto;
  }

  /**
   * ���ʵ����Ϣ
   * @param  compensateNo��ʵ���
   * @return ʵ�����
   * @throws Exception 
   */
  public CompensateDto findByPrimaryKey(String compensateNo,String caseType) throws SQLException,UserException,Exception
  {
  	CompensateFindByConCommand compensateFindByConCommand = new CompensateFindByConCommand(compensateNo,caseType);
  	CompensateDto compensateDto = (CompensateDto)compensateFindByConCommand.execute(); 

    if (compensateDto == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+compensateNo+")");
    }
    return compensateDto;
  }
  /**
   * �ж�ʵ����Ƿ����
   * @param compensateNo:ʵ���
   * @return ��/��
   * @throws Exception
   */
  public boolean isExist(String compensateNo) throws SQLException,Exception
  {
  	CompensateIsExistCommand compensateIsExistCommand = new CompensateIsExistCommand(compensateNo);
  	return ((Boolean)compensateIsExistCommand.execute()).booleanValue();
  }
  /**
  * ���ʵ����Ϣ
  * @param  conditions����ѯ����
  * @return ʵ�����
  * @throws Exception
  */

  public Collection findByConditions(String conditions) throws SQLException,Exception
  {
     PrpLcompensateFindByConCommand prpLcompensateFindByConCommand = new PrpLcompensateFindByConCommand(conditions);

     return (Collection)prpLcompensateFindByConCommand.execute();  
  }
  /** 
   * ���ʵ����Ϣ
   * @param  conditions����ѯ����
   * @return ʵ�����
   * @throws Exception
   */ 

   public PageRecord findByConditions(String conditions,String pageNo,String recordPerPage) throws SQLException,Exception
   {
      PrpLcompensateFindByConCommand prpLcompensateFindByConCommand = new PrpLcompensateFindByConCommand(conditions,pageNo,recordPerPage);
      return (PageRecord)prpLcompensateFindByConCommand.execute();
   }  
  /**
  * ���ʵ������Ϣ
  * @param  conditions����ѯ����
  * @return �б�
  * @throws Exception
  */

  public Collection findLossByConditions(String conditions) throws SQLException,Exception
  {
     PrpLlossFindbyConditionsCommand prpLlossFindbyConditionsCommand = new PrpLlossFindbyConditionsCommand(conditions);

     return (Collection)prpLlossFindbyConditionsCommand.execute();
  }

  /**
  * ���ʵ����Ա��Ϣ
  * @param  conditions����ѯ����
  * @return �б�
  * @throws Exception
  */

  public Collection findPersonLossByConditions(String conditions) throws SQLException,Exception
  {
     PrpLPersonLossFindbyConditionsCommand prpLPersonLossFindbyConditionsCommand = new PrpLPersonLossFindbyConditionsCommand(conditions);

     return (Collection)prpLPersonLossFindbyConditionsCommand.execute();
  }


  /**
  * ��ò鿱��ѯ��Ϣ
  * @param  conditions����ѯ����
  * @return ��������
  * @throws Exception
  * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
  */

  public Collection findByQueryConditions(String conditions) throws SQLException,Exception
  {
     CompensateQueryCommand compensateQueryCommand = new CompensateQueryCommand(conditions);

     return (Collection)compensateQueryCommand.executeCommand();
  }
  
  /**
  * ���ʵ���ѯ��Ϣ
  * @param  conditions����ѯ����
  * @return ʵ���б�
  * @throws Exception
  * Add By liubvo 2004-09-07 Reason:ʵ�⸴�˲�ѯ����
  */

  public Collection findByApproveConditions(String conditions) throws SQLException,Exception
  {
     CompensateApproveQueryCommand compensateApproveQueryCommand = new CompensateApproveQueryCommand(conditions);

     return (Collection)compensateApproveQueryCommand.executeCommand();
  }
  /**
   * ����ʵ��
   * @param CompensateDto��ʵ�����DTO
   * @throws Exception
  * Add By liubvo 2004-09-08 Reason:ʵ�⸴��update
   */
  public void approve(String compensateNo,String userCode,String underWriteFlag) throws SQLException,Exception
  {
  	CompensateApproveCommand compensateApproveCommand = new CompensateApproveCommand(compensateNo,userCode,underWriteFlag);
  	compensateApproveCommand.execute();
  }
   /**
   * ��ѯ�ر�Լ��,�⳥�޶�/�������Ϣ
   * @param CompensateDto��ʵ�����DTO
   * @throws Exception 
  * Add By liubvo 2004-10-18 Reason:��ѯ�ر�Լ��,�⳥�޶�/�������Ϣ
   */
  public CompensateDto findByAppendInformation(CompensateDto compensateDto) throws SQLException,Exception
  {
  	CompensateAppendInfoCommand compensateAppendInfoCommand = new CompensateAppendInfoCommand(compensateDto);
  	return (CompensateDto)compensateAppendInfoCommand.execute();
  }
  
  //modify by wangli add start 20050420
  /**
   * ���������Ӧ�ļ�������Ϣ
   * @param  conditions����ѯ����
   * @return ��������
   * @throws Exception
   * Add By wangli 2005-04-20 Reason:�����ⰸ�Ų�ѯ��Ӧ�ļ�����
   */

   public Collection findByClaimNo(String conditions) throws SQLException,Exception
   {
   	CompensateByClaimNoCommand compensateByClaimNoCommand = new CompensateByClaimNoCommand(conditions);

      return (Collection)compensateByClaimNoCommand.executeCommand();
   }
   
   
   /**
    * �����ⰸ�ŵõ��Ѿ����
    * @param claimNo �ⰸ��
    * @author wangli 
    * @return 
    * @throws Exception
    */
   public CompensateFeeDto findCompensateFeeByClaimNo(String claimNo) throws SQLException,Exception
   {
   	CompensateFeeByClaimNoCommand compensateFeeByClaimNoCommand = new CompensateFeeByClaimNoCommand(claimNo);

      return (CompensateFeeDto)compensateFeeByClaimNoCommand.executeCommand();
   }
   
   /**
    * �������˻ض���
    * @param CompensateDto��ʵ�����DTO
    * @throws Exception
    */
   public void backToCerta(String claimNo,WorkFlowDto workFlowDto,PrpLverifyLossDto prpLverifyLossDto) throws SQLException,Exception
   {
   	CompensateBackToCertaCommand compensateBackToCertaCommand = new CompensateBackToCertaCommand(claimNo,workFlowDto,prpLverifyLossDto);
   	compensateBackToCertaCommand.execute();
   }
   // modify by wangli add end 20050529 
   
   
   //add by zhaolu 20060803 start
   public PageRecord findByQueryConditions(String conditions,int pageNo,int recordPerPage) throws Exception
   {
	   CompensateQueryCommand compensateQueryCommand = new CompensateQueryCommand(conditions,pageNo,recordPerPage);
	   return (PageRecord)compensateQueryCommand.executeCommand();
   }
   //add by zhaolu 20060803 end
   
   /**
    * ͨ���������ڵ��,�õ�ĳ�������������������
    */
   public ArrayList getCompensateList(String flowId) throws Exception{
	   ArrayList compensateList = new ArrayList();
	   DBManager dbManager = new DBManager();
	   dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
	   ResultSet resultSet = null;
	   //�ѽ᰸��������ת����swflogStore���У�Ӧ��ת������ȡ����
	   BLSwfFlowMainAction blSwfFlowMainAction = new BLSwfFlowMainAction();
	   SwfFlowMainDto swfFlowMainDto = new SwfFlowMainDto();
	   swfFlowMainDto = blSwfFlowMainAction.findByPrimaryKey(dbManager, flowId);
	   String tableName = "swflog ";
	   if("1".equals(swfFlowMainDto.getStoreFlag())){
		   tableName = "swflogStore ";
	   }
	   String sqlNo = 
   	    "select distinct businessno from "+ tableName +
     		"where nodetype='compp' " +
     		"and flowstatus='0' and nodestatus='4' " + 
     		"and flowid='" + flowId +"'" ;
      try{
    	  resultSet  = dbManager.executeQuery(sqlNo);
			   while(resultSet.next()){				   
			         String temp = dbManager.getString(resultSet,1); 			       
			         if(temp!=null&&temp.length()>0){
			            compensateList.add(temp);	
			         }
				}
      }catch(SQLException sqle)
		{
		  throw sqle;
		}
		catch (Exception ex) {
		  throw ex;
		}
		finally
		{
		 if(resultSet!=null){
		    resultSet.close();
		 }
		 if(dbManager!=null){
		    dbManager.close();
		 }
		}
	   return compensateList;
	   
   }
/**
 * �õ�ĳ�����������֧�������ܶ� added by zhangli 20070427
 */
   public String fetchPayFee(String compensateNo) throws Exception{
	   String payFee = "0.00";
	   DBManager dbManager = new DBManager();
	   dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
	   ResultSet resultSet = null;
	   String sqlFee = 
		   "select sum(payreffee) from prpjpayrefrec " +
		   "where certitype='C' and payrefreason!='P6B'"+
		   "  and certino='"+compensateNo+"'";	
	   try{
		   resultSet  = dbManager.executeQuery(sqlFee);	
		   while(resultSet.next()){	
		        String  Payreffee = Double.toString(dbManager.getDouble(resultSet, 1));			  	
				if(Payreffee!=null&&Payreffee.length()>0){							  
					payFee = Payreffee;
				}
		   }
	   }catch(SQLException sqle)
		{
			  throw sqle;
			}
			catch (Exception ex) {
			  throw ex;
			}
			finally
			{
			 if(resultSet!=null){
			    resultSet.close();
			 }
			 if(dbManager!=null){
			    dbManager.close();
			 }
			}
		
	   return payFee;
   }
    /**
     * ���Ӵ�ӡ�Ŀ��Ƶ� added by zhangli 20070427
     * @param httpServletRequest
     * @param registNo
     * @param policyNo
     * @return
     * @throws Exception
     */
   public double compensatePaymentResult(HttpServletRequest httpServletRequest,String compensateNo) throws Exception{
	  /* String sql = "select sum(realpayreffee) from prpjplanfee " +
		"where certitype='C' and payrefreason!='P6B' " +
		"and policyNO= " + policyNo;*/
	   String sqlFee = 
		   "select sum(payreffee) from prpjpayrefrec " +
		   "where certitype='C' and payrefreason!='P6B'"+
		   "  and certino='"+compensateNo+"'";	
		DBManager dbManager = new DBManager(); 
		double realPayreffee = 0.00; 
		ResultSet resultSet = null;
		try
		{
		   dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;	     
		   resultSet  = dbManager.executeQuery(sqlFee);
			while(resultSet.next()){
				String temp = dbManager.getString(resultSet,1); 	    	
			   	if(temp!=null&&temp.length()>0){
			   		realPayreffee =Double.parseDouble(temp);
			   	} 
			}
		  if(realPayreffee<0||realPayreffee==0){
			  String riskCode = "";
			  riskCode = findByPrimaryKey(compensateNo).getPrpLclaimDto().getRiskCode();
			        if((!"".equals(riskCode))&&(riskCode!=null)&&"05".equals(riskCode.substring(0, 2))){				  
			  }else{
			        httpServletRequest.setAttribute("isCompensate", "false");
			  }
		  } 		       
		}
		catch(SQLException sqle)
		{
		  throw sqle;
		}
		catch (Exception ex) {
		  throw ex;
		}
		finally
		{
		  resultSet.close();
		  dbManager.close();
		}
		return realPayreffee;
   }
   /**added by zhangli 20070520
    * ����������ĺ���ͨ��Ϊ���ӡ���Ƶ�;
    * �����ڳ������ࣨ�������Ϊ05����ũ�����ۺϱ��գ����ִ���Ϊ3119��֮����������֡�
    * �������־Ϊ1ʱ����������Դ�ӡ��
    */
   public void compensateUndwrtFlag(HttpServletRequest httpServletRequest,String compensateNo) throws Exception{
	   String undwrtFlag = "";
	   String riskCode = "";
	   String dAAClassCode = "";
	   undwrtFlag = findByPrimaryKey(compensateNo).getPrpLcompensateDto().getUnderWriteFlag();	   
	   riskCode = findByPrimaryKey(compensateNo).getPrpLclaimDto().getRiskCode();
	   dAAClassCode = riskCode .substring(0, 2);
	  
	   if("1".equals(undwrtFlag)){		   
	   }else if("05".equals(dAAClassCode)){		   
	   }else if("3119".equals(riskCode)){		   
	   }else {	   
		   httpServletRequest.setAttribute("isCompensate", "false");
	   }
   }
   /**
    * ȡ���Ѿ��򱻱�����֧���������֧������ added by zhangli 20070423
    */
    public String fetchPaycompensateFinalDate(String compensateNo) throws Exception{
    	String payFinalDate = "";
    	DBManager dbManager = new DBManager();
  	    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
  	    ResultSet resultSet = null;
  	    String sqlDate = 
		   "select max(payrefdate) from prpjpayrefrec " +
		   "where certitype='C' and payrefreason!='P6B'"+
		   "and certino='"+compensateNo+"'";
    	try{
    		resultSet  = dbManager.executeQuery(sqlDate);			
    		while(resultSet.next()){
    			String temp = dbManager.getString(resultSet,1); 	    	
			   	if(temp!=null&&temp.length()>0){
				  payFinalDate = temp;
			  }
    		}
				String month = "";
				String year = "";
				String day = "";
				if(!"".equals(payFinalDate)&&payFinalDate!=null){
					if("/".equals(payFinalDate.substring(1, 2))){
						month = payFinalDate.substring(0, 1);
						if("/".equals(payFinalDate.substring(3, 4))){
							day = payFinalDate.substring(2, 3);
							year = payFinalDate.substring(4, 8);
						}else {
							day = payFinalDate.substring(2, 4);
							year = payFinalDate.substring(5, 9);
						}
						}else {
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							String payFinalDate_new = sdf.format(sdf.parse(payFinalDate));
							if("-".equals(payFinalDate_new.substring(4, 5))){
								month = payFinalDate_new.substring(5, 7);
								if("-".equals(payFinalDate_new.substring(7, 8))){
									day = payFinalDate_new.substring(8, 10);
									year = payFinalDate_new.substring(0, 4);
								}else {
									day = payFinalDate_new.substring(2, 4);
									year = payFinalDate_new.substring(5, 9);
								}
							}else{
						month = payFinalDate.substring(0, 2);
						if("/".equals(payFinalDate.substring(4, 5))){
							day = payFinalDate.substring(3, 4);
							year = payFinalDate.substring(5, 9);
						}else {
							day = payFinalDate.substring(3, 5);
							year = payFinalDate.substring(6, 10);
						}
								}
					}
					payFinalDate = year+"��"+month+"��"+day+"��";
				}
    	}	catch(SQLException sqle)
		{
  		  throw sqle;
  		}
  		catch (Exception ex) {
  		  throw ex;
  		}
  		finally
  		{
  		  resultSet.close();
  		  dbManager.close();
  		}
    	return payFinalDate;
    }
/*   public String fetchPayCompensateFinalDate(String registNo,String policyNo) throws Exception{		  
	   DBManager dbManager = new DBManager();		
	   ResultSet resultSet = null;
	   String compensatePayDate = "";
	  
	   try {		   
		   dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;           
	      //ȡ��֧����������			
			String sql_date = 
				   "select distinct(r.payrefdate) from prpjpayrefrec r,prpjplanfee e,prplregist re "+
			       "where r.certitype=e.certitype and r.certitype='C' and " +
			       " r.policyno=e.policyno and  e.policyno="+policyNo +" and re.registno="+ registNo+ 
			       " and r.payrefreason=e.payrefreason and r.payrefreason='P60'"+
			       " order by r.payrefdate desc";
			ArrayList dateList = new ArrayList();
			resultSet  = dbManager.executeQuery(sql_date);
			while(resultSet.next()){
				String temp = dbManager.getString(resultSet,1); 	    	
				   	if(temp!=null&&temp.length()>0){
				   		dateList.add(temp);
				   	} 
			    } 
			if(dateList.size()>0){				
				compensatePayDate = (String)dateList.get(0);
				String month = "";
				String year = "";
				String day = "";				
				if("/".equals(compensatePayDate.substring(1, 2))){
					month = compensatePayDate.substring(0, 1);
					if("/".equals(compensatePayDate.substring(3, 4))){
						day = compensatePayDate.substring(2, 3);
						year = compensatePayDate.substring(4, 8);
					}else {
						day = compensatePayDate.substring(2, 4);
						year = compensatePayDate.substring(5, 9);
					}
				}else {
					month = compensatePayDate.substring(0, 2);
					if("/".equals(compensatePayDate.substring(4, 5))){
						day = compensatePayDate.substring(3, 4);
						year = compensatePayDate.substring(5, 9);
					}else {
						day = compensatePayDate.substring(3, 5);
						year = compensatePayDate.substring(6, 10);
					}
				}
				compensatePayDate = year+"��"+month+"��"+day+"��";
				
			    }			
	   }
	   catch(SQLException sqlex)
		{
		  throw sqlex;
		}
	   catch (Exception ex) {
			  throw ex;
			}
			finally
			{
			  resultSet.close();
			  dbManager.close();
			}
	   
	   return compensatePayDate;
   }*/
   /**
    * ����policyNo�õ��������˵�����
    */
   public String fetchInsuredName(String policyNo) throws Exception{
	   String insuredName = "";
	   UIPrpCmainAction uIPrpCmainAction = new UIPrpCmainAction();
	   com.sinosoft.prpall.dto.domain.PrpCmainDto  prpCMainDto = 
		   new com.sinosoft.prpall.dto.domain.PrpCmainDto();
	   prpCMainDto = uIPrpCmainAction.findByPrimaryKey(policyNo);
	   insuredName = prpCMainDto.getInsuredName();	   
	   return insuredName;
   }
  
} 
