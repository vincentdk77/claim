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
 * 预赔数据库管理对象
 * <p>Title: 车险理赔预赔数据管理</p>
 * <p>Description: 车险理赔预赔数据管理</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class DBPrepay
{
  private DBManager dbManager = null; //资源管理类

  /**
   * 构造函数
   * @param dbManager 资源管理类
   */
  public DBPrepay()
  {

  }

  /**
   * 预赔保存方法
   *@param prepayDto 预赔对象
   * @throws SQLException
   * @throws Exception
   *@return 无
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
    //首先删除原来的相关数据
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

    //进行状态的改变

    updateClaimStatus(dbManager,prepayDto);

  }

  /**
   * 预赔删除子表信息
   * @param fcoClaimNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  private void deleteSubInfo(DBManager dbManager,String preCompensateNo)
    throws SQLException,Exception
  {
    String condition1 = " preCompensateNo = " + "'" + preCompensateNo.trim() + "'";
    //示例未完成
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
   * 预赔删除
   * @param prepayNo
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String prepayNo)
    throws SQLException,Exception
  {
    String condition = " prepayNo = '" + StringUtils.rightTrim(prepayNo) + "'";
    //示例未完成
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
   * 预赔查询方法
   *@param prepayDto 预赔对象
   * @throws SQLException
   * @throws Exception
   *@return 无
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
   * 变更预赔的操作状态的方法
   *@param prepayDto 立案对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public void updateClaimStatus(DBManager dbManager,PrepayDto prepayDto)
    throws SQLException,Exception
 {

   //示例未完成
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
