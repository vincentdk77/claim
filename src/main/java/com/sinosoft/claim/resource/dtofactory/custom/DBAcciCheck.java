package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sinosoft.claim.dto.custom.AcciCheckDto;
import com.sinosoft.claim.dto.custom.CaseRelateNodeDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.domain.PrpLacciCheckDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCmain;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLAcciCheckCharge;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLacciCheck;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLacciCheckText;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLacciPerson;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcheck;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaim;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatus;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLdriver;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpersonTrace;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregist;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregistExt;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregistText;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLrelatePerson;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleItem;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleMainWF;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdCarLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdParty;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdProp;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLverifyLoss;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 报案数据库管理对象
 * <p>Title: 车险理赔报案数据管理</p>
 * <p>Description: 车险理赔报案数据管理</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class DBAcciCheck
{
  private DBManager dbManager = null; //资源管理类

  /**
   * 构造函数
   * @param dbManager 资源管理类
   */
  public DBAcciCheck()
  {

  }

  /**
   * 报案保存方法
   *@param registDto 报案对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public void insert(DBManager dbManager,RegistDto registDto)
    throws SQLException,Exception
  {
    if (registDto.getPrpLregistDto() ==null)
    {
    	 throw new Exception();
    }

    String registNo="";
    registNo = registDto.getPrpLregistDto().getRegistNo();

    //首先删除原来的相关数据
    deleteSubInfo(dbManager,registNo);

    new DBPrpLregist(dbManager).insert(registDto.getPrpLregistDto());
    if(registDto.getPrpLthirdPartyDtoList()!=null)
    {
       new DBPrpLthirdParty(dbManager).insertAll(registDto.getPrpLthirdPartyDtoList());
    }
    if(registDto.getPrpLdriverDtoList()!=null)
    {
       new DBPrpLdriver(dbManager).insertAll(registDto.getPrpLdriverDtoList());
    }
    if(registDto.getPrpLregistTextDtoList()!=null)
    {
       new DBPrpLregistText(dbManager).insertAll(registDto.getPrpLregistTextDtoList());
    }
    
    //modify by wangwei add start 2005-06-16
    //原因：添加呈报信息
    if(registDto.getPrpLregistTextDtoList2()!=null)
    {
       new DBPrpLregistText(dbManager).insertAll(registDto.getPrpLregistTextDtoList2());
    }
    
    //原因：添加出险人员信息
    if(registDto.getPrpLacciPersonDto() != null)
    {
       new DBPrpLacciPerson(dbManager).insert(registDto.getPrpLacciPersonDto());
    }
    //modify by wangwei add end 2005-06-16
    
     if(registDto.getPrpLthirdCarLossDtoList()!=null)
     {
        new DBPrpLthirdCarLoss(dbManager).insertAll(registDto.getPrpLthirdCarLossDtoList());
     }
     if(registDto.getPrpLthirdPropDtoList()!=null)
     {
        new DBPrpLthirdProp(dbManager).insertAll(registDto.getPrpLthirdPropDtoList());
     }

     if(registDto.getPrpLpersonTraceDtoList()!=null)
     {
        new DBPrpLpersonTrace(dbManager).insertAll(registDto.getPrpLpersonTraceDtoList());
     }

     if(registDto.getPrpLregistExtDtoList()!=null)
     {
        new DBPrpLregistExt(dbManager).insertAll(registDto.getPrpLregistExtDtoList());
     }

/*     if(registDto.getPrpLscheduleNewDto()!=null)
   {
      new DBPrpLscheduleNew(dbManager).insert(registDto.getPrpLscheduleNewDto());
    }
*/
if(registDto.getPrpLscheduleMainWFDto() !=null) {
    new DBPrpLscheduleMainWF(dbManager).insert(registDto.getPrpLscheduleMainWFDto() );
  }

  if(registDto.getPrpLscheduleItemDtoList() !=null)   {
     new DBPrpLscheduleItem(dbManager).insertAll(registDto.getPrpLscheduleItemDtoList()  );
  }
  
  //modify by wangwei add start 20050601
  if (registDto.getPrpLrelatePersonDtoList() != null) {
     new DBPrpLrelatePerson(dbManager).insertAll(registDto.getPrpLrelatePersonDtoList());
  }
  //modify by wangwei add end 20050601

     //进行状态的改变

     updateClaimStatus(dbManager,registDto);

  }


  /**
   * 变更立案的操作状态的方法
   *@param claimDto 立案对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public void updateClaimStatus(DBManager dbManager,RegistDto registDto)
    throws SQLException,Exception
{

 //示例未完成
   String statement = "";


  if(registDto.getPrpLclaimStatusDto() !=null)
   {
     String condition3 = " BusinessNo='" + StringUtils.rightTrim(registDto.getPrpLclaimStatusDto().getBusinessNo()) + "' "
                       + " AND NodeType ='regis' ";
    statement = " DELETE FROM prpLclaimStatus Where " + condition3;

    dbManager.executeUpdate(statement);

      new DBPrpLclaimStatus(dbManager).insert(registDto.getPrpLclaimStatusDto() );
   }


}


  /**
   * 报案删除
   * @param fcoRegistNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
    String condition = " registNo = '" + StringUtils.rightTrim(registNo) + "'";
    //示例未完成
    String statement = " DELETE FROM prpLregistText Where " + condition ;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM prpLdriver Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM prpLthirdParty Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM PrpLthirdCarLoss Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM PrpLthirdProp Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM prpLregist Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM prpLrelatePerson Where " + condition;
    dbManager.executeUpdate(statement);
    String condition3 = " businessno = '" + StringUtils.rightTrim(registNo) + "'";
    statement = " DELETE FROM prpLclaimStatus Where " + condition3;
    dbManager.executeUpdate(statement);

    statement= " DELETE FROM prplscheduleNew Where " + condition;
    dbManager.executeUpdate(statement);


  }

  /**
     * 报案撤消
     * @param fcoRegistNoticeNo
     * @throws SQLException
     * @throws Exception
     */
    public void cancel(DBManager dbManager,String registNo)
      throws SQLException,Exception
    {
      //表示案件被撤消


    }
  /*
   * 报案查询方法
   *@param registDto 报案对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public AcciCheckDto findByPrimaryKey(DBManager dbManager,String checkNo)
    throws SQLException,Exception
  {
     AcciCheckDto acciCheckDto = new AcciCheckDto();
     //int time = new DBPrpLacciCheck(dbManager).findByRegistNoMaxTimes(registNo);
     //String conditions = " RegistNo = '"+registNo+"' and Times = " + time; 
     //ArrayList acciCheckDtoList = (ArrayList) new DBPrpLacciCheck(dbManager).findByConditions(conditions);
     //if (acciCheckDtoList != null && acciCheckDtoList.size() > 0) {
     
     //根据调查号查询调查信息 2005-08-16
     acciCheckDto.setPrpLacciCheckDto((PrpLacciCheckDto) new DBPrpLacciCheck(dbManager).findByPrimaryKey(checkNo));
     String conditions = "CheckNo = '" + checkNo +"' and TextType='3'";
     acciCheckDto.setPrpLacciCheckTextDtoList((ArrayList) new DBPrpLacciCheckText(dbManager).findByConditions(conditions));
     conditions = "CheckNo = '" + checkNo + "' ";
     acciCheckDto.setPrpLAcciCheckChargeDtoList(new DBPrpLAcciCheckCharge(dbManager).findByConditions(conditions));
     
     //modify by zhulei 20050920 需要判断acciCheckDto.getPrpLacciCheckDto()不为空
     if(acciCheckDto.getPrpLacciCheckDto()!=null){
         acciCheckDto.setPrpLregistDto(new DBPrpLregist(dbManager).findByPrimaryKey(acciCheckDto.getPrpLacciCheckDto().getRegistNo()));
     }
    // acciCheckDto.setPrpLchargeDtoList((ArrayList) new DBPrpLcharge(dbManager).findByConditions(conditions));
     //} else {
     //	throw new Exception("数据库表PrpLacciCheck中没有数据！");
    // }
     return acciCheckDto;
  }

  /**
   * 立案删除子表信息
   * @param fcoClaimNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  private void deleteSubInfo(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
    String condition = " registNo = '" + StringUtils.rightTrim(registNo) + "'";
    //示例未完成

    String statement = " DELETE FROM prpLregistText Where " + condition ;
    dbManager.executeUpdate(statement);
    statement = " DELETE FROM prpLscheduleMainWF Where " + condition ;
    dbManager.executeUpdate(statement);
    statement = " DELETE FROM prpLscheduleItem Where " + condition ;
    dbManager.executeUpdate(statement);
    statement = " DELETE FROM prpLrelatePerson Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM prpLpersonTrace Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM PrpLregistExt Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM prpLdriver Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM PrpLthirdCarLoss Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM PrpLthirdProp Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM prpLthirdParty Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM prpLregist Where " + condition;
    dbManager.executeUpdate(statement);
  }

  /*
   * 报案查询方法
   *@param registDto 报案对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public CaseRelateNodeDto relateNode(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
     UICodeAction uiCodeAction = new UICodeAction();
     String claimNo = uiCodeAction.translateBusinessCode(registNo,true);
     CaseRelateNodeDto caseRelateNodeDto = new CaseRelateNodeDto();
     caseRelateNodeDto.setPrpLregistDto(new DBPrpLregist(dbManager).findByPrimaryKey(registNo));
     caseRelateNodeDto.setPrpCmainDto(new DBPrpCmain(dbManager).findByPrimaryKey(caseRelateNodeDto.getPrpLregistDto().getPolicyNo()));
     //caseRelateNodeDto.setPrpLscheduleMainWFDto(new DBPrpCmain(dbManager).findByPrimaryKey());
     caseRelateNodeDto.setPrpLcheckDto(new DBPrpLcheck(dbManager).findByPrimaryKey(registNo,1));
     caseRelateNodeDto.setPrpLverifyLossDto(new DBPrpLverifyLoss(dbManager).findByPrimaryKey(registNo,"1"));
     caseRelateNodeDto.setPrpLclaimDto(new DBPrpLclaim(dbManager).findByPrimaryKey(claimNo));

     return caseRelateNodeDto;
  }
}
