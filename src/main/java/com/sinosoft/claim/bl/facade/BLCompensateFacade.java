package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sinosoft.claim.bl.action.custom.BLCompensateAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLcompensateAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLlossAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpersonLossAction;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.CompensateFeeDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLchargeDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLlossDto;
import com.sinosoft.claim.dto.domain.PrpLnodutyLossDto;
import com.sinosoft.claim.dto.domain.PrpLpersonLossDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.prpall.dto.domain.PrpCmainDto;
import com.sinosoft.prpall.dto.domain.PrpLclaimDto;
import com.sinosoft.prpall.dto.domain.PrpPheadDto;
import com.sinosoft.prpall.resource.dtofactory.domain.DBPrpCmain;
import com.sinosoft.prpall.resource.dtofactory.domain.DBPrpLclaim;
import com.sinosoft.prpall.resource.dtofactory.domain.DBPrpPhead;
import com.sinosoft.reins.function.insutil.bl.action.custom.BLBillAction;
import com.sinosoft.reins.out.bl.action.domain.BLPrpLdangerUnitAction;
import com.sinosoft.reins.out.dto.domain.FeoEngageDto;
import com.sinosoft.reins.out.dto.domain.FeoEnquiryDto;
import com.sinosoft.reins.out.dto.domain.FeoItemDto;
import com.sinosoft.reins.out.dto.domain.FeoReinsReceiveDto;
import com.sinosoft.reins.out.dto.domain.FeoTotDto;
import com.sinosoft.reins.out.dto.domain.PrpLdangerUnitDto;
import com.sinosoft.reins.out.resource.dtofactory.domain.DBFeoEngage;
import com.sinosoft.reins.out.resource.dtofactory.domain.DBFeoEnquiry;
import com.sinosoft.reins.out.resource.dtofactory.domain.DBFeoItem;
import com.sinosoft.reins.out.resource.dtofactory.domain.DBFeoReinsReceive;
import com.sinosoft.reins.out.resource.dtofactory.domain.DBFeoTot;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.undwrt.dto.domain.WfLogDto;
import com.sinosoft.undwrt.resource.dtofactory.domain.DBWfLog;
import com.sinosoft.utility.string.Str;
/**
 *  ʵ���߼��ַ�
 * <p>Title: ��������ʵ��</p>
 * <p>Description: ��������ʵ��facade</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLCompensateFacade
{
  /**
   * ����ʵ��
   * @param compensateDto���Զ���ʵ�����
   * @throws SQLException
   * @throws Exception
   */
  public void save(CompensateDto compensateDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLCompensateAction().save(dbManager,compensateDto);
      //�ύ����
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
      //�ع�����
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
      //�ع�����
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally
    {
      //�ر����ݿ�����
      dbManager.close();
    }
  }

  /**
   * ����ʵ���������
   * @param compensateDto���Զ���ʵ�����
   * @throws SQLException
   * @throws Exception
   */
  public void save(CompensateDto compensateDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLCompensateAction().save(dbManager,compensateDto);
      if(workFlowDto!=null){
        new BLWorkFlowAction().deal(dbManager,workFlowDto);
      }
      generateFeoData(compensateDto,dbManager);
      //�ύ����
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
      //�ع�����
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
      //�ع�����
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally
    {
      //�ر����ݿ�����
      dbManager.close();
    }
  }
  /**
   * ����ʵ���������
   * @param compensateDto���Զ���ʵ�����
   * @throws SQLException
   * @throws Exception
   */
  public void saveCombine(PrpLcompensateDto compensateDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLCompensateAction().save(dbManager,compensateDto);
      if(workFlowDto!=null){
        new BLWorkFlowAction().deal(dbManager,workFlowDto);
      }
      //�ύ����
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
      //�ع�����
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
      //�ع�����
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally
    {
      //�ر����ݿ�����
      dbManager.close();
    }
  }
  
  
  /**
   * ����ʵ���������
   * @param compensateDto���Զ���ʵ�����
   * @throws SQLException
   * @throws Exception
   */
  public void backToCerta(String claimNo,WorkFlowDto workFlowDto,PrpLverifyLossDto prpLverifyLossDto) throws SQLException,Exception
  {
    //�������ݿ�������,
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLCompensateAction().backToCerta(dbManager,claimNo,prpLverifyLossDto);
      if(workFlowDto!=null){
        new BLWorkFlowAction().deal(dbManager,workFlowDto);
      }
      //�ύ����
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
      //�ع�����
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
      //�ع�����
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally
    {
      //�ر����ݿ�����
      dbManager.close();
    }
  }
  /**
   * ɾ��ʵ��
   * @param  compensateNo
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void delete(String compensateNo) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLCompensateAction().delete(dbManager,compensateNo);
      //�ύ����
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
      //�ع�����
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
      //�ع�����
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally
    {
      //�ر����ݿ�����
      dbManager.close();
    }

  }
  /**
   * ���ʵ��
   * @param  compensateNo
   * @param dbManager  ��������
   * @return �Զ���ʵ�����
   * @throws SQLException
   * @throws Exception
   */
  public CompensateDto findByPrimaryKey(String compensateNo) throws SQLException,Exception
  {
    CompensateDto compensateDto = null;
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      compensateDto = new BLCompensateAction().findByPrimaryKey(dbManager,compensateNo);
    }
    catch(SQLException sqle)
    {
      throw sqle;
    }
    catch(Exception ex)
    {
      throw ex;
    }
    finally
    {
      //�ر����ݿ�����
      dbManager.close();
    }
    return compensateDto;
  }

  //add by lym  for InderectFee group by kindCode-------------Start
  public Collection findByCompensateNo(String compensateNo) throws SQLException,Exception
  {
	  Collection derectFeeList = null;
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
    	derectFeeList = (ArrayList)new BLCompensateAction().findByCompensateNo(dbManager,compensateNo);
    }
    catch(SQLException sqle)
    {
      throw sqle;
    }
    catch(Exception ex)
    {
      throw ex;
    }
    finally
    {
      //�ر����ݿ�����
      dbManager.close();
    }
    return derectFeeList;
  }
  //add by lym  for InderectFee group by kindCode-------------end  
  
  
  /**
   * ���ʵ��
   * @param  compensateNo
   * @param dbManager  ��������
   * @return �Զ���ʵ�����
   * @throws SQLException
   * @throws Exception
   */
  public CompensateDto findByPrimaryKey(String compensateNo,String caseType) throws SQLException,Exception
  {
    CompensateDto compensateDto = null;
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      compensateDto = new BLCompensateAction().findByPrimaryKey(dbManager,compensateNo,caseType);
    }
    catch(SQLException sqle)
    {
      throw sqle;
    }
    catch(Exception ex)
    {
      throw ex;
    }
    finally
    {
      //�ر����ݿ�����
      dbManager.close();
    }
    return compensateDto;
  }

  /**
   * �ж�ʵ��֪ͨ���Ƿ����
   * @param compensateNo
   * @param dbManager  ��������
   * @return ��/��
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(String compensateNo) throws SQLException,Exception
  {

    boolean exist = false ;
    //�������ݿ�������
     DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI"));
    try
    {
      exist = new BLCompensateAction().isExist(dbManager,compensateNo);
    }
    catch(SQLException sqle)
    {
      throw sqle;
    }
    catch(Exception ex)
    {
      throw ex;
    }
    finally
    {
      //�ر����ݿ�����
      dbManager.close();
    }
    return exist;
  }

  /**
   * ����������ѯʵ��������Ϣ
   * @param conditions String
   * @throws Exception
   * @return Collection
   */
  public Collection findByConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     PrpLcompensateDto prpLcompensateDto = null;
     Collection compensateList = new ArrayList();
     try
     {
       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
       compensateList = (Collection)blPrpLcompensateAction.findByConditions(dbManager,conditions);
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
       dbManager.close();
     }
     return compensateList;
  }
  /**
   * ����������ѯʵ������Ϣ
   * @param conditions String
   * @throws Exception
   * @return Collection
   */
  public Collection findLossByConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     PrpLcompensateDto prpLcompensateDto = null;
     Collection compensateList = new ArrayList();
     try
     {
       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLPrpLlossAction blPrpLlossAction = new BLPrpLlossAction();
       compensateList = (Collection)blPrpLlossAction.findByConditions(dbManager,conditions,0,0);
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
       dbManager.close();
     }
     return compensateList;
  }

  /**
   * ����������ѯ����������Ϣ
   * @param conditions String
   * @throws Exception
   * @return Collection
   * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
   */
  public Collection findByQueryConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     Collection compensateList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       BLCompensateAction blCompensateAction = new BLCompensateAction();
       compensateList = (Collection)blCompensateAction.findByQueryConditions(dbManager,conditions,0,0);
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
       dbManager.close();
     }
     return compensateList;
  }

  /**
   * ����������ѯ����������Ϣ
   * @param conditions String
   * @throws Exception
   * @return Collection
   * Add By sunhao 2004-09-07 Reason:ʵ�⸴�˲�ѯ����
   */
  public Collection findByApproveQueryConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     Collection compensateList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       BLCompensateAction blCompensateAction = new BLCompensateAction();
       compensateList = (Collection)blCompensateAction.findByApproveQueryConditions(dbManager,conditions,0,0);
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
       dbManager.close();
     }
     return compensateList;
  }

  /**
   * ʵ�����񸴺�
   * @param compensateNo�������������
   * @param userCode������Ա����
   * @param underWriteFlag�������־
   * @throws SQLException
   * @throws Exception
   */
  public void approve(String compensateNo,String userCode,String underWriteFlag) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLCompensateAction().approve(dbManager,compensateNo,userCode,underWriteFlag);
      //�ύ����
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
      //�ع�����
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
      //�ع�����
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally
    {
      //�ر����ݿ�����
      dbManager.close();
    }
  }

  /**
   * ��ѯ�ر�Լ��,�⳥�޶�/�������Ϣ
   * @param  compensateDto
   * @param dbManager  ��������
   * @return �Զ���ʵ�����
   * @throws SQLException
   * @throws Exception
   */
  public CompensateDto findByAppendInformation(CompensateDto compensateDto) throws SQLException,Exception
  {
    //CompensateDto compensateDto = null;
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      compensateDto = new BLCompensateAction().findByAppendInformation(dbManager,compensateDto);
    }
    catch(SQLException sqle)
    {
      throw sqle;
    }
    catch(Exception ex)
    {
      throw ex;
    }
    finally
    {
      //�ر����ݿ�����
      dbManager.close();
    }
    return compensateDto;
  }

  /**
   * ����������ѯʵ��������Ϣ
   * @param conditions String
   * @throws Exception
   * @return Collection
   */
  public PageRecord findByConditions(String conditions,String pageNo,String recordPerPage) throws Exception
  { 	
     DBManager dbManager = new DBManager();
     PrpLcompensateDto prpLcompensateDto = null;
     PageRecord pageRecord = null;
     try
     {
       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
       pageRecord = (PageRecord)blPrpLcompensateAction.findByConditions(dbManager,conditions,Integer.parseInt(pageNo) ,Integer.parseInt(recordPerPage) );
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
       dbManager.close();
     }
     return pageRecord;
  }
  
  
  //modify by wangli add start 20050420
  /**
   * ���������Ӧ�ļ�������Ϣ
   * @param conditions String
   * @throws Exception
   * @return Collection
   * Add By wangli 2005-04-20 Reason:�����ⰸ�Ų�ѯ��Ӧ�ļ�����
   */
  public Collection findByClaimNo(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     Collection compensateList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLCompensateAction blCompensateAction = new BLCompensateAction();
       compensateList = (Collection)blCompensateAction.findByClaimNo(dbManager,conditions,0,0);
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
       dbManager.close();
     }
     return compensateList;
  }
  
  
  /**
   * �����ⰸ�ŵõ��Ѿ����
   * @param claimNo �ⰸ��
   * @author wangli 
   * @return
   * @throws Exception
   */
  public CompensateFeeDto findCompensateFeeByClaimNo(String claimNo) throws Exception {
     DBManager dbManager = new DBManager();
     CompensateFeeDto compensateFeeDto = new CompensateFeeDto();
     
     try
     {
       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLCompensateAction blCompensateAction = new BLCompensateAction();
       
       compensateFeeDto = blCompensateAction.findCompensateFeeByClaimNo(dbManager,claimNo);
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
       dbManager.close();
     }
     return compensateFeeDto;
  }
  //modify by wangli add end 20050420 
  
  
  /**
   * ����������ѯʵ����Ա��Ϣ
   * @param conditions String
   * @throws Exception
   * @return Collection
   */
  public Collection findPersonLossByConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     PrpLcompensateDto prpLcompensateDto = null;
     Collection compensateList = new ArrayList();
     try
     {
       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLPrpLpersonLossAction blPrpLpersonLossAction = new BLPrpLpersonLossAction();
       compensateList = (Collection)blPrpLpersonLossAction.findByConditions(dbManager,conditions);
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
       dbManager.close();
     }
     return compensateList;
  }

  //add by zhaolu 20060803 start
   public PageRecord findByQueryConditions(String conditions, int pageNo,
			int recordPerPage) throws Exception {
		DBManager dbManager = new DBManager();
		//PrpLpolicyDto prpLpolicyDto = null;
		PageRecord pageRecord = null;
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			BLCompensateAction blCompensateAction = new BLCompensateAction();
			pageRecord = (PageRecord)blCompensateAction.findByQueryCondition(dbManager,conditions,pageNo,recordPerPage) ;
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			dbManager.close();
		}
		return pageRecord;
	}
  //add by zhaolu 20060803 end
   
   /**
    * ɾ��������
    */
   public void deleteCompensateRelation(String compensateNo)throws Exception {
	   DBManager dbManager = new DBManager();
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			BLCompensateAction blCompensateAction = new BLCompensateAction();
			//У���������Ƿ�����ɾ��
			blCompensateAction.checkCompensateNo(dbManager, compensateNo);
			//ɾ����������Ӧ�ı�
			blCompensateAction.delete(dbManager, compensateNo);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
		    throw ex;
		} finally {
			dbManager.close();
		}
   }
  
   /**
    * У��������Ƿ��ܷ�һ��
    */
   public boolean checkCompensateRelation(CompensateDto compensateDto)throws Exception {

         //��������
	       Double sumfee = compensateDto.getPrpLcompensateDto().getSumPaid(); 
	       //Double prePaid = compensateDto.getPrpLcompensateDto().getSumPrePaid();
	    /** �⸶�����Ϣ */   
	    List lossList = compensateDto.getPrpLlossDtoList();
	    if(lossList != null){
		for (int i = 0; i < lossList.size(); i++) {
			PrpLlossDto prpLlossDto = (PrpLlossDto) lossList.get(i);
			sumfee = Str.round(sumfee-prpLlossDto.getSumRealPay(),2);

		}
	    }

		/** �⸶��Ա��Ϣ */
		lossList = compensateDto.getPrpLpersonLossDtoList();
		if(lossList != null){
		for (int i = 0; i < lossList.size(); i++) {
			PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto) lossList.get(i);
			sumfee = Str.round(sumfee-prpLpersonLossDto.getSumRealPay(),2);
		}
		}

		/** ��������Ϣ */
		lossList = compensateDto.getPrpLchargeDtoList();
		if(lossList != null){
		for (int i = 0; i < lossList.size(); i++) {
			PrpLchargeDto prpLchargeDto = (PrpLchargeDto) lossList.get(i);
			sumfee = Str.round(sumfee-prpLchargeDto.getChargeAmount(),2);
		}
		}

		/** ���������Ϣ */
		lossList = compensateDto.getPrpLnodutyLossDtoList();
		if(lossList != null){
		for (int i = 0; i < lossList.size(); i++) {
			PrpLnodutyLossDto prpLnodutyLossDto = (PrpLnodutyLossDto) lossList
					.get(i);	
			sumfee = Str.round(sumfee-prpLnodutyLossDto.getRealPaid(),2);
		}
		}
		/** Ԥ����� **/
		//sumfee = Str.round(sumfee+prePaid,2);
		if(sumfee != 0){
			return true;
		}
		return false;	

   }
   
   /**
    * �жϸ��������Ӧ�ı����Ƿ����ٷ�ҵ������ǣ���Ҫ���ɸ��������Ӧ���ٷ�ѯ�۵�
    * @param compensateDto
    * @param dbManager
    * @throws Exception
    */
   public void generateFeoData(CompensateDto compensateDto,DBManager dbManager) throws Exception{
	   
	     String strUnderWriteFlag=compensateDto.getPrpLcompensateDto().getUnderWriteFlag(); 
	     String strPolicyNo=compensateDto.getPrpLcompensateDto().getPolicyNo();
	     
	     DBFeoEnquiry dbFeoEnquiry=new DBFeoEnquiry(dbManager);
	     DBFeoItem dbFeoItem = new DBFeoItem(dbManager);
	     DBFeoTot dbFeoTot = new DBFeoTot(dbManager);
	     DBFeoEngage dbFeoEngage = new DBFeoEngage(dbManager);
	     DBFeoReinsReceive dbFeoReinsReceive = new DBFeoReinsReceive(dbManager);
	     Collection feoEnquiryCollection=dbFeoEnquiry.findByConditions(" policyno='"+strPolicyNo+"'");
	     if(feoEnquiryCollection.size()>0 && "9".equals(strUnderWriteFlag)){//���������Ӧ�ı������ٷ�ҵ��,����Ϊ�ύ�������
	       String feoQueryCondition="";
	       DBPrpCmain dbPrpCmain=new DBPrpCmain(dbManager);
	       PrpCmainDto prpCmainDto=dbPrpCmain.findByPrimaryKey(strPolicyNo);
	       long endorsetimes=prpCmainDto.getEndorseTimes();
	       if(endorsetimes==0){//û�з���������
	         //ȡ������
	         feoQueryCondition=" policyno='"+strPolicyNo+"' and enquirytype='P'";
	       }else{//����������
	         String strClaimNo=compensateDto.getPrpLcompensateDto().getClaimNo();
	         DBPrpLclaim dbPrpLclaim=new DBPrpLclaim(dbManager);
	         PrpLclaimDto PrpLclaimDto=dbPrpLclaim.findByPrimaryKey(strClaimNo);
	         DateTime damageDate=PrpLclaimDto.getDamageStartDate();
	         String conditions=" policyno='"+strPolicyNo+"' and underwriteflag in ('1' , '3' ) and validdate<=to_date('"+damageDate.toString()+"','yyyy-mm-dd') order by endorsetimes desc";
	         String strEndorseNo="";
	         DBPrpPhead dbPrpPhead=new DBPrpPhead(dbManager);
	         Collection prpPheadCollection=dbPrpPhead.findByConditions(conditions);
	         if(prpPheadCollection!=null){
	           Iterator prpPheadIterator=prpPheadCollection.iterator();
	           while(prpPheadIterator.hasNext()){
	             PrpPheadDto prpPheadDto=(PrpPheadDto)prpPheadIterator.next();
	             strEndorseNo=prpPheadDto.getEndorseNo();
	             break;
	           }
	         }
	         if("".equals(strEndorseNo)){//��������֮ǰû�з���������
	           feoQueryCondition=" policyno='"+strPolicyNo+"' and enquirytype='P'";
	         }else{//��������֮ǰ����������
	           feoQueryCondition=" endorseno='"+strEndorseNo+"' and enquirytype='E'";
	         }
	       }
	       
	       String strEnquiryno="";
	       String strComCode=prpCmainDto.getComCode();
	       String strCompensateNo=compensateDto.getPrpLcompensateDto().getCompensateNo();
	       String strRiskCode=compensateDto.getPrpLcompensateDto().getRiskCode();
	       int dangerNo ;
	       BLPrpLdangerUnitAction blPrpLdangerUnitAction= new BLPrpLdangerUnitAction();
	       Collection ldangerUnitCol = blPrpLdangerUnitAction.findByConditions(dbManager,
	                                  "certino = '"+strCompensateNo+"'");
	       
	       Iterator iterator = ldangerUnitCol.iterator();
	       while (iterator.hasNext()) { //ѭ��Σ�յ�λ
	        PrpLdangerUnitDto prpLdangerUnitDto = (PrpLdangerUnitDto)iterator.next();
	        dangerNo =  prpLdangerUnitDto.getDangerNo();
	        feoEnquiryCollection=dbFeoEnquiry.findByConditions(feoQueryCondition+" and dangerNo='"+dangerNo+"'");
	        Iterator feoEnquiryIterator=feoEnquiryCollection.iterator();
	        if(feoEnquiryIterator.hasNext()){
	           FeoEnquiryDto feoEnquiryDto=(FeoEnquiryDto)feoEnquiryIterator.next();
	           strEnquiryno = feoEnquiryDto.getEnquiryNo();
	        }
	        
	        FeoEnquiryDto feoEnquiryDto=new FeoEnquiryDto();
	        Collection feoItemList=new ArrayList();
	        Collection feoTotList=new ArrayList();
	        Collection feoEngageList=new ArrayList();
	        Collection feoReinsReceiveList=new ArrayList();
	           
	           feoEnquiryDto=dbFeoEnquiry.findByPrimaryKey(strEnquiryno);
	           String feoConditions=" enquiryno='"+strEnquiryno+"'";
	           feoItemList=dbFeoItem.findByConditions(feoConditions);
	           feoTotList=dbFeoTot.findByConditions(feoConditions);
	           feoEngageList=dbFeoEngage.findByConditions(feoConditions);
	           feoReinsReceiveList=dbFeoReinsReceive.findByConditions(feoConditions);
	           
	           //�����µ�ѯ�۵���
	           BLBillAction blBillAction = new BLBillAction();
	           
	           int year=Integer.parseInt(prpCmainDto.getStartDate().toString().substring(0, 4));
	           strEnquiryno=blBillAction.getNo(dbManager, "feoenquiry", strRiskCode,strComCode, year, "");
	           
	           if(feoEnquiryDto!=null){
	             feoEnquiryDto.setEnquiryNo(strEnquiryno);
	             feoEnquiryDto.setVerifyFlag("0");
	             feoEnquiryDto.setEnquiryType("C");
	             feoEnquiryDto.setCompensateno(strCompensateNo);
	             dbFeoEnquiry.insert(feoEnquiryDto);
	           }
	           if(feoItemList!=null){
	             Iterator feoItemIterator=feoItemList.iterator();
	             while(feoItemIterator.hasNext()){
	               FeoItemDto feoItemDto=(FeoItemDto)feoItemIterator.next();
	               feoItemDto.setEnquiryNo(strEnquiryno);
	             }
	             dbFeoItem.insertAll(feoItemList);
	           }
	           if(feoTotList!=null){
	             Iterator feoTotIterator=feoTotList.iterator();
	             while(feoTotIterator.hasNext()){
	               FeoTotDto feoTotDto=(FeoTotDto)feoTotIterator.next();
	               feoTotDto.setEnquiryNo(strEnquiryno);
	             }
	             dbFeoTot.insertAll(feoTotList);
	           }
	           if(feoEngageList!=null){
	             Iterator feoEngageIterator=feoEngageList.iterator();
	             while(feoEngageIterator.hasNext()){
	               FeoEngageDto feoEngageDto=(FeoEngageDto)feoEngageIterator.next();
	               feoEngageDto.setEnquiryNo(strEnquiryno);
	             }
	             dbFeoEngage.insertAll(feoEngageList);
	           }
	           if(feoReinsReceiveList!=null){
	             Iterator feoReinsReceiveIterator=feoReinsReceiveList.iterator();
	             while(feoReinsReceiveIterator.hasNext()){
	               FeoReinsReceiveDto feoReinsReceiveDto=(FeoReinsReceiveDto)feoReinsReceiveIterator.next();
	               feoReinsReceiveDto.setEnquiryNo(strEnquiryno);
	             }
	             dbFeoReinsReceive.insertAll(feoReinsReceiveList);
	           }
	      }
		   
		    DBWfLog dbWfLog = new DBWfLog(dbManager);
			String sql = " select wflog.* from wflog where businessno = '"+strCompensateNo+"' and businesstype = 'C' and logno <> '1' and nodeno <> '1' and  nodestatus in ('1', '2', '3')  ";
			Collection collection = dbWfLog.findByStatement(sql, true);
			WfLogDto wfLogDto = null;
			if (collection != null && collection.size() > 0) {
				Iterator ite = collection.iterator();
				while (ite.hasNext()) {
					wfLogDto = (WfLogDto) ite.next();
					break;
				}
			}
			if(wfLogDto != null){
				dbWfLog.updateReinsStatusByPrimaryKey(dbManager, wfLogDto.getFlowID(), wfLogDto.getLogNo(), "0");
			}
			
	   }
   }
}
