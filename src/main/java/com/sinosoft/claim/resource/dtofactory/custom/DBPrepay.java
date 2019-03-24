package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sinosoft.claim.dto.custom.PrepayDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaim;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatus;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpreCharge;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLprepay;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLptext;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * Ԥ�����ݿ�������
 * <p>Title: ��������Ԥ�����ݹ���</p>
 * <p>Description: ��������Ԥ�����ݹ���</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class DBPrepay
{
  private DBManager dbManager = null; //��Դ������

  /**
   * ���캯��
   * @param dbManager ��Դ������
   */
  public DBPrepay()
  {

  }

  /**
   * Ԥ�Ᵽ�淽��
   *@param prepayDto Ԥ�����
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public void insert(DBManager dbManager,PrepayDto prepayDto)
    throws SQLException,Exception
  {
    if (prepayDto.getPrpLprepayDto() ==null)
    {
             throw new Exception();
    }

    String preCompensateNo="";
    preCompensateNo= prepayDto.getPrpLprepayDto().getPreCompensateNo();
    //����ɾ��ԭ�����������
    deleteSubInfo(dbManager,preCompensateNo);
    new DBPrpLprepay(dbManager).insert(prepayDto.getPrpLprepayDto());

    if(prepayDto.getPrpLpreChargeDtoList() != null){
    	new DBPrpLpreCharge(dbManager).insertAll(prepayDto.getPrpLpreChargeDtoList());
    }
    if(prepayDto.getPrpLptextDtoList()!=null)
    {
       new DBPrpLptext(dbManager).insertAll(prepayDto.getPrpLptextDtoList());
    }
    if(prepayDto.getPrpLclaimDto()!=null)
    {
       new DBPrpLclaim(dbManager).updatePrepayPaid(prepayDto.getPrpLclaimDto());
    }

    //����״̬�ĸı�

    updateClaimStatus(dbManager,prepayDto);

  }

  /**
   * Ԥ��ɾ���ӱ���Ϣ
   * @param fcoClaimNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  private void deleteSubInfo(DBManager dbManager,String preCompensateNo)
    throws SQLException,Exception
  {
    String condition1 = " preCompensateNo = " + "'" + preCompensateNo.trim() + "'";
    //ʾ��δ���
    String statement = "";

    statement = " DELETE FROM prplptext Where " + condition1;
    int i = 0;
    i = dbManager.executeUpdate(statement);
    statement = " DELETE FROM prplprepay Where " + condition1;
    i = dbManager.executeUpdate(statement);
    statement = " DELETE FROM prplprecharge Where " + condition1;
    i = dbManager.executeUpdate(statement);
  }
  
  /**
   * Ԥ��ɾ��
   * @param prepayNo
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String prepayNo)
    throws SQLException,Exception
  {
    String condition = " prepayNo = '" + StringUtils.rightTrim(prepayNo) + "'";
    //ʾ��δ���
    String statement = " DELETE FROM prpLprepayText Where " + condition ;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM prpLdriver Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM prpLthirdParty Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM prpLprepay Where " + condition;
    dbManager.executeUpdate(statement);
  }

  /*
   * Ԥ���ѯ����
   *@param prepayDto Ԥ�����
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public PrepayDto findByPrimaryKey(DBManager dbManager,String prepayNo)
    throws SQLException,Exception
  {
     String conditions = " PreCompensateNo = '"+prepayNo+"'";
     PrepayDto prepayDto = new PrepayDto();
     prepayDto.setPrpLprepayDto(new DBPrpLprepay(dbManager).findByPrimaryKey(prepayNo));
    // prepayDto.setPrpLthirdPartyDtoList((ArrayList)new DBPrpLthirdParty(dbManager).findByConditions(conditions,0,0));
    //prepayDto.setPrpLdriverDtoList((ArrayList)new DBPrpLdriver(dbManager).findByConditions(conditions,0,0));
     prepayDto.setPrpLptextDtoList((ArrayList)new DBPrpLptext(dbManager).findByConditions(conditions,0,0));
     prepayDto.setPrpLclaimStatusDto(new DBPrpLclaimStatus(dbManager).findByPrimaryKey(prepayNo,"speci",5)); 
     prepayDto.setPrpLpreChargeDtoList((ArrayList)new DBPrpLpreCharge(dbManager).findByConditions(conditions));
     return prepayDto;
  }

  /**
   * ���Ԥ��Ĳ���״̬�ķ���
   *@param prepayDto ��������
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public void updateClaimStatus(DBManager dbManager,PrepayDto prepayDto)
    throws SQLException,Exception
 {

   //ʾ��δ���
   String statement = "";  

  if(prepayDto.getPrpLclaimStatusDto() !=null)
   {
     String condition3 = " BusinessNo='" + prepayDto.getPrpLclaimStatusDto().getBusinessNo().trim() + "' "
                       + " AND NodeType ='speci' and TypeFlag='5'";                     
    statement = " DELETE FROM prpLclaimStatus Where " + condition3;
    dbManager.executeUpdate(statement);
    new DBPrpLclaimStatus(dbManager).insert(prepayDto.getPrpLclaimStatusDto() );
   }
 }

}  
