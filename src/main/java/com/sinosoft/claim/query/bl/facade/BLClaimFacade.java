package com.sinosoft.claim.query.bl.facade;

import java.sql.SQLException;
import java.util.*;

import com.sinosoft.reins.out.bl.facade.BLPrpLdangerUnitFacade;
import com.sinosoft.reins.out.bl.facade.BLPrpLreinsTrialFacade;
import com.sinosoft.reins.out.bl.facade.BLRepayFacade;
import com.sinosoft.reins.out.dto.domain.PrpLdangerUnitDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.*;
import com.sinosoft.claim.bl.action.custom.BLClaimAction;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpLclaimLossDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.bl.action.domain.BLPrpCmainAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLclaimAction;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.query.util.Constant;
import com.sinosoft.claim.ui.control.action.UIReinsTrialAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;

/**
 *  �����߼��ַ�
 * <p>Title: ������������</p>
 * <p>Description: ������������facade</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lijiyuan
 * @version 1.0
 */
public class BLClaimFacade
{
  /**
   * ��������
   * @param claimDto���Զ�����������
   * @throws SQLException
   * @throws Exception
   */
  public void save(ClaimDto claimDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLClaimAction().save(dbManager,claimDto);
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
   * ����������������
   * @param claimDto���Զ�����������
   * @throws SQLException
   * @throws Exception
   */
  public void save(ClaimDto claimDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLClaimAction().save(dbManager,claimDto);
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
   * ����������������
   * @param claimDto���Զ�����������
   * @throws SQLException
   * @throws Exception
   */
  public void save(ArrayList claimDtoList,ArrayList workFlowDtoList,String comCode,String userCode) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {for(int i=0;i<claimDtoList.size();i++){
    	ClaimDto claimDto = (ClaimDto)claimDtoList.get(i);
      new BLClaimAction().save(dbManager,claimDto);
      Collection dangerTrial = new BLPrpLreinsTrialFacade().findByConditions("certiNo = '" + claimDto.getPrpLclaimDto().getClaimNo() + "'");
  	//���û�з�̯���㣬���Ƚ��з�̯����
  	if (dangerTrial == null || dangerTrial.size() == 0) {
  		new UIReinsTrialAction().simulateRepayByDangerNo(claimDto.getPrpLclaimDto().getClaimNo(),claimDto.getPrpLclaimDto().getClaimNo());
  	}
  	Collection dangerUnit = new BLPrpLdangerUnitFacade().findByConditions("certiNo = '" + claimDto.getPrpLclaimDto().getClaimNo() + "'");
  	if (dangerUnit != null) {
  		Iterator iter = dangerUnit.iterator();
  		while (iter.hasNext()) {
  			PrpLdangerUnitDto prpLdangerUnitDto = (PrpLdangerUnitDto) iter.next();
  			 String newRepayNo = new BLRepayFacade().genRepay(
  					claimDto.getPrpLclaimDto().getClaimNo(), 
  					prpLdangerUnitDto.getDangerNo(),
  					comCode, 
  					userCode,
  					0
  					);
  			if (!newRepayNo.equals("")) {
  				new BLRepayFacade().checkRepay(newRepayNo, userCode);
  			}
  		}
      }
    }
    for(int i=0;i<workFlowDtoList.size();i++){
      if(workFlowDtoList.get(i)!=null){
        new BLWorkFlowAction().deal(dbManager,(WorkFlowDto)workFlowDtoList.get(i));}
      }

	 //add by dongyanqi end 20050827���ɷ��ⰸ
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
   * ɾ������
   * @param  claimNo
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void delete(String claimNo) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLClaimAction().delete(dbManager,claimNo);
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
   * ɾ������(��ɾ���������ڵ�)
   * @param  claimNo
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void delete(String claimNo, WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLClaimAction().delete(dbManager,claimNo);
      //���ɾ���Ļ���������������
      new BLWorkFlowAction().deal(dbManager,workFlowDto);
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
   * �������
   * @param  claimNo
   * @param dbManager  ��������
   * @return �Զ�����������
   * @throws SQLException
   * @throws Exception
   */
  public ClaimDto findByPrimaryKey(String claimNo) throws SQLException,Exception
  {
    ClaimDto claimDto = null;
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    //dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    dbManager.open(Constant.QUERY_DATA_SOURCE) ;
    try
    {
      claimDto = new BLClaimAction().findByPrimaryKey(dbManager,claimNo);
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
    return claimDto;
  }

  /**
   * �ж�����֪ͨ���Ƿ����
   * @param claimNo
   * @param dbManager  ��������
   * @return ��/��
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(String claimNo) throws SQLException,Exception
  {

    boolean exist = false ;
    //�������ݿ�������
     DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      exist = new BLClaimAction().isExist(dbManager,claimNo);
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
  //public Collection findByConditions(String conditions) throws Exception
  //{
     //return new BLClaimAction().findByConditions(conditions);
  //}
  /**
     * ����������ѯ����������Ϣ
     * @param conditions String
     * @throws Exception
     * @return Collection
     */
    public Collection findByConditions(String conditions) throws Exception
    {
       DBManager dbManager = new DBManager();
       Collection claimList = new ArrayList();
       try
       {
         //dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    	   dbManager.open(Constant.QUERY_DATA_SOURCE) ;
         BLPrpLclaimAction blPrpLclaimAction = new BLPrpLclaimAction();
         claimList = (Collection)blPrpLclaimAction.findByConditions(dbManager,conditions);
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
       return claimList;
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
     Collection claimList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       BLClaimAction blClaimAction = new BLClaimAction();
       claimList = (Collection)blClaimAction.findByQueryConditions(dbManager,conditions,0,0);
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
     return claimList;
  }

  /**
   * ȡ�ù�����
   * @param  claimNo
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public PrpLclaimLossDto getClaimLoss(String claimNo) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    PrpLclaimLossDto prpLclaimLossDto = new PrpLclaimLossDto();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      prpLclaimLossDto = new BLClaimAction().getClaimLoss(dbManager,claimNo);
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
    return prpLclaimLossDto;
  }

  /**
   * ��������ȡ��δ����ѯ�б�
   *@param iWherePart ��ѯ����(�����������־�)
   *@param iOtherWherePart ���Ӳ�ѯ����
   *@throws UserException
   *@throws Exception
  */
  public Collection getNoEndCaseClaim(String iWherePart,String iOtherWherePart) throws Exception
  {
     DBManager dbManager = new DBManager();
     Collection noEndCaseClaimList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLClaimAction blClaimAction = new BLClaimAction();
       noEndCaseClaimList = (Collection)blClaimAction.getNoEndCaseClaim(dbManager,iWherePart,iOtherWherePart);
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
     return noEndCaseClaimList;
  }

 /**
   * ��������ȡ���Ѿ���ѯ�б�
   *@param iWherePart ��ѯ����(�����������־�)
   *@throws UserException
   *@throws Exception
  */
  public Collection querySumEndCase(String iWherePart) throws Exception
  {
     DBManager dbManager = new DBManager();
     Collection EndCaseClaimList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLClaimAction blClaimAction = new BLClaimAction();
       EndCaseClaimList = (Collection)blClaimAction.querySumEndCase(dbManager,iWherePart);
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
     return EndCaseClaimList;
  }


  /**
   * ��������ȡ���Ѿ���ѯ�б���ϸ�嵥
   *@param iWherePart ��ѯ����(�����������־�)
   *@throws UserException
   *@throws Exception
  */
  public Collection querySumEndCaseDetail(String iWherePart) throws Exception
  {
     DBManager dbManager = new DBManager();
     Collection EndCaseClaimList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLClaimAction blClaimAction = new BLClaimAction();
       EndCaseClaimList = (Collection)blClaimAction.querySumEndCaseDetail(dbManager,iWherePart);
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
     return EndCaseClaimList;
  }


    /**
     * @param claimNo
   * @param dbManager  ��������
   * @return ��/��
   * @throws SQLException
   * @throws Exception
   */
  public void UpdCaseType(String claimNo) throws SQLException,Exception
  {

    //�������ݿ�������
     DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      new BLClaimAction().UpdCaseType(dbManager,claimNo);
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
}


  public void UpdSumClaim(ClaimDto claimDto,String claimNo,double sumClaim) throws SQLException,Exception
  {

    //�������ݿ�������
     DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      new BLClaimAction().UpdSumClaim(dbManager,claimDto, claimNo,sumClaim);
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
   }
  
  public Object findByPolicyNo(String policyNo) throws SQLException, Exception {
  	 Object prpClaimDtoList = null;
     //�������ݿ�������
     DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
     try
     {
     	prpClaimDtoList = new BLClaimAction().findByPolicyNo(dbManager,policyNo);
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
     return prpClaimDtoList;
  }
  
  public Object findByPolicyNo(String policyNo,String idcard) throws SQLException, Exception {
	  	 Object prpClaimDtoList = null;
	     //�������ݿ�������
	     DBManager dbManager = new DBManager();
	     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
	     try
	     {
	     	prpClaimDtoList = new BLClaimAction().findByPolicyNo(dbManager,policyNo,idcard);
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
	     return prpClaimDtoList;
	  }
	
  
  public PrpCmainDto findByPolicyNoKey(String policyNo) throws SQLException, Exception {
  	 PrpCmainDto prpCmainDto = null;
  	 DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
     try
     {
     	prpCmainDto = new BLPrpCmainAction().findByPrimaryKey(dbManager,policyNo);
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
     return prpCmainDto;
  }
  
 //modify by liuyanmei add 20051102 start 
  public void updateEndCaseDate(String claimNo,Date endCaseDate) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLClaimAction().updateEndCaseDate(dbManager,claimNo,endCaseDate);
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
  
  //modify by liuyanmei add 20051102 end 
  
  
  //add by zhaolu 20060802 start
  
  public PageRecord findByQueryConditions(String conditions,int pageNo,int recordPerPage) throws Exception
  {
     DBManager dbManager = new DBManager();
     PageRecord pageRecord = null;
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       BLClaimAction blClaimAction = new BLClaimAction();
       pageRecord = (PageRecord)blClaimAction.findByConditions(dbManager,conditions,pageNo,recordPerPage);
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
  //add by zhaolu 20060802 end
  
  //add by zhaolu 20060803 start
  //�᰸��ҳ��ѯ
  public PageRecord findByConditions(String conditions,int pageNo,int recordPerPage) throws Exception
  {
     DBManager dbManager = new DBManager();
     PageRecord pageRecord = null;
     try
     {

       //dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    	 dbManager.open(Constant.QUERY_DATA_SOURCE) ;
      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       BLPrpLclaimAction blPrpLclaimAction = new BLPrpLclaimAction();
       pageRecord = (PageRecord)blPrpLclaimAction.findByConditions(dbManager,conditions,pageNo,recordPerPage);
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
  //add by zhaolu 20060803 end
  
  /**
   * ��������������ύ��ʱ��Բ鿱�Ͷ��𻷽ڵĴ���״̬�����жϽ�������ֳ�ս��д���
   * @param swfLogFlowID ���̱��
   * add ��Ԫ��Ŀ�� ���� 2008-06-04 
   */
  public void checkNodeStatus(String swfLogFlowID) throws Exception {
		String nodeStatus = "";
		BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
		String conditions = "flowid='" + swfLogFlowID
				+ "' and nodetype in ('check','certa')";
		ArrayList blSwfLogList = new ArrayList();
		blSwfLogList = (ArrayList) blSwfLogFacade.findByConditions(conditions);
		Iterator it = blSwfLogList.iterator();
		while (it.hasNext()) {
			SwfLogDto swfLogDto = (SwfLogDto) it.next();
			nodeStatus = swfLogDto.getNodeStatus();
			if (!"4".equals(nodeStatus)) {
				//������Ϣ����
				throw new UserException(1, 3, "1000", "�鿱����ڵ�δ�ύ,������������!");
			}
		}
	}
}
