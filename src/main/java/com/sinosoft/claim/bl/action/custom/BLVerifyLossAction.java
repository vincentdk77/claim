package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.VerifyLossDto;
import com.sinosoft.claim.dto.domain.PrpLpropDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBVerifyLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLverifyLoss;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����action
 * <p>Title: �������� ����acton</p>
 * <p>Description: �������� ����acton</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLVerifyLossAction
{
  public BLVerifyLossAction()
  {
  }

  /**
   * �������
   * @param verifyLossDto���Զ���������
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,VerifyLossDto verifyLossDto)
    throws SQLException,Exception
  {
      DBVerifyLoss dbVerifyLoss = null;
      //ҵ�����
      dbVerifyLoss = new DBVerifyLoss();
      dbVerifyLoss.insert(dbManager,verifyLossDto);
  }

  /**
   * ɾ������
   * @param  registNo
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String registNo,String nodeType)
    throws SQLException,Exception
  {
      //ҵ�����
      new DBVerifyLoss().delete(dbManager,registNo,nodeType);
  }

  /**
	 * ��ú���
	 * 
	 * @param registNo
	 * @param dbManager ��������
	 * @return �Զ���������
	 * @throws SQLException
	 * @throws Exception
	 */
	public VerifyLossDto findByPrimaryKey(DBManager dbManager, String registNo,
			String lossItemCode, String nodeType) throws SQLException, Exception {
		VerifyLossDto verifyLossDto = null;
		verifyLossDto = new DBVerifyLoss().findByPrimaryKey(dbManager, registNo, lossItemCode,
				nodeType);
		// �Ե����kindname���д���ת��
		UICodeAction uiCodeAction = new UICodeAction();
		PrpLpropDto prpLpropDto = null;
		ArrayList prpLpropDtoList = (ArrayList) verifyLossDto.getPrpLpropDtoList();
		for (int i = 0; i < prpLpropDtoList.size(); i++) {
			prpLpropDto = (PrpLpropDto) prpLpropDtoList.get(i);
			prpLpropDto.setKindName(uiCodeAction.translateKindCode(prpLpropDto.getRiskCode(),
					prpLpropDto.getKindCode(), true));
		}
		return verifyLossDto;
	}

  /**
	 * �жϱ������Ƿ����
	 * 
	 * @param registNo
	 * @param dbManager
	 *            ��������
	 * @return ��/��
	 * @throws SQLException
	 * @throws Exception
	 */
  public boolean isExist(DBManager dbManager,String registNo,String lossItemCode,String nodeType)throws SQLException,Exception
  {
           if (new DBVerifyLoss().findByPrimaryKey(dbManager,registNo,lossItemCode,nodeType) == null)
      {
        return false;
      }else
      {
        return true;
      }
  }

  /**
   * ��������ѯ��������
   * @param dbManager DBManager
   * @param conditions String
   * @param nodeType String
   * @param pageNo int
   * @param rowsPerPage int
   * @throws Exception
   * @return Collection
   * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
   */
  public Collection findByQueryConditions(DBManager dbManager,String conditions,String nodeType,int pageNo,int rowsPerPage) throws Exception{
    DBPrpLverifyLoss dbPrpLverifyLoss = new DBPrpLverifyLoss(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLverifyLoss.findByQueryConditions(conditions,nodeType,pageNo,rowsPerPage);
    return collection;
  }

  /**
   * ��ú���
   * @param  registNo
   * @param dbManager  ��������
   * @return �Զ���������
   * @throws SQLException
   * @throws Exception
   */
  /*
  public VerifyLossDto findByPrimaryKey(DBManager dbManager,String registNo,String serialNo)
    throws SQLException,Exception
  {
    VerifyLossDto verifyLossDto = null;
    verifyLossDto = new DBVerifyLoss().findByPrimaryKey(dbManager,registNo,serialNo);
    return verifyLossDto;
  }

     */
  
  //add by zhaolu 20060803 start
  public PageRecord findByCondition(DBManager dbManager,String conditions,String nodeType,int pageNo,int rowsPerPage) throws Exception{
	    DBPrpLverifyLoss dbPrpLverifyLoss = new DBPrpLverifyLoss(dbManager);
	    Collection collection = new ArrayList();
	 
	    if(conditions.trim().length()==0){
	        conditions = "1=1";
	    }
	    
      collection = dbPrpLverifyLoss.findByQueryConditions(conditions,nodeType,pageNo,rowsPerPage);
      int count = dbPrpLverifyLoss.getCount1(SqlUtils.getWherePartForGetCount(conditions),nodeType);
      int maxQueryCount=Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
      if(maxQueryCount!=0&&count>maxQueryCount){   
        throw new UserException(1,3,"0000","��ѯ�����������ϵͳ����"); 
      }
	  PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
	  return pageRecord;
	  }
  //add by zhaolu 20060803 end
  
  }
