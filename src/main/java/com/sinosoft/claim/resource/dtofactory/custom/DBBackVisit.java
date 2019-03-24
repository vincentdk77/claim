package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sinosoft.claim.dto.custom.BackVisitDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLbackVisit;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLbackVisitQue;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLbackVisitText;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatus;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 回访数据库管理对象
 * <p>Title: 车险理赔回访数据管理</p>
 * <p>Description: 车险理赔回访数据管理</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author 理赔项目组
 * @version 1.0
 */
public class DBBackVisit
{
  private DBManager dbManager = null; //资源管理类

  /**
   * 构造函数
   * @param dbManager 资源管理类
   */
  public DBBackVisit()
  {

  }

  /**
   * 回访保存方法
   * @param backVisitDto 回访对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public void insert(DBManager dbManager,BackVisitDto backVisitDto)
    throws SQLException,Exception
  {
    if (backVisitDto.getPrpLbackVisitDto() ==null)
    {
      throw new Exception();
    }

    //得到回访登记号、报案号、业务类型
    int  backVisitID= 0 ;
    String registNo="";
    String backVisitType = "";
    backVisitID= backVisitDto.getPrpLbackVisitDto().getBackVisitID();
    registNo = backVisitDto.getPrpLbackVisitDto().getRegistNo();
    backVisitType = backVisitDto.getPrpLbackVisitDto().getBackVisitType();

    //首先删除原来的相关数据
    deleteSubInfo(dbManager,backVisitID,registNo,backVisitType);

    //保存回访主表
    new DBPrpLbackVisit(dbManager).insert(backVisitDto.getPrpLbackVisitDto());

    //保存回访问询表
    if(backVisitDto.getPrpLbackVisitQueDtoList()!=null)
    {
       new DBPrpLbackVisitQue(dbManager).insertAll(backVisitDto.getPrpLbackVisitQueDtoList());
    }
    //保存回访客户意见表
    if(backVisitDto.getPrpLbackVisitTextDtoList()!=null)
    {
       new DBPrpLbackVisitText(dbManager).insertAll(backVisitDto.getPrpLbackVisitTextDtoList());
    }
    //进行状态的改变

    updateClaimStatus(dbManager,backVisitDto);
  }



  /**
   * 回访对象删除
   * @param backVisitNo
   * @param registNo
   * @param backVisitType
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,int backVisitNo,String registNo,String backVisitType)
    throws SQLException,Exception
  {

    //拼Where子句
    String strCondition = "BackVisitID = "+backVisitNo+" and RegistNo = '"+ StringUtils.rightTrim(registNo)+"' and "
                          +" BackVisitType = '"+StringUtils.rightTrim(backVisitType)+"'";

    //删除回访子表数据开始
    String statement = "";

    statement = " DELETE FROM PrpLbackVisit Where " + strCondition;
    dbManager.executeUpdate(statement);

    statement = " DELETE FROM PrpLbackVisitQue Where " + strCondition;
    dbManager.executeUpdate(statement);

    statement =" DELETE FROM PrpLbackVisitText Where " + strCondition;
    dbManager.executeUpdate(statement);

 }

  /*
   * 回访查询方法
   * @param backVisitNo
   * @param registNo
   * @param backVisitType
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public BackVisitDto findByPrimaryKey(DBManager dbManager,int backVisitNo,String registNo,String backVisitType)
    throws SQLException,Exception
  {
     //拼Where子句
     String conditions = "BackVisitID = "+backVisitNo+" and RegistNo = '"+ StringUtils.rightTrim(registNo)+"' and "
                          +" BackVisitType = '"+StringUtils.rightTrim(backVisitType)+"'";


     BackVisitDto backVisitDto = new BackVisitDto();
     backVisitDto.setPrpLbackVisitDto(new DBPrpLbackVisit(dbManager).findByPrimaryKey(backVisitNo,registNo,backVisitType));
     backVisitDto.setPrpLbackVisitQueDtoList((ArrayList)new DBPrpLbackVisitQue(dbManager).findByConditions(conditions,0,0));
     backVisitDto.setPrpLbackVisitTextDtoList((ArrayList)new DBPrpLbackVisitText(dbManager).findByConditions(conditions,0,0));

     backVisitDto.setPrpLclaimStatusDto(new DBPrpLclaimStatus(dbManager).findByPrimaryKey(registNo,"backv",0));
     return backVisitDto;
  }

  /**
   * 回访删除子表信息
   * @param backVisitNo
   * @param registNo
   * @param backVisitType
   * @throws SQLException
   * @throws Exception
   */
  private void deleteSubInfo(DBManager dbManager,int backVisitNo,String registNo,String backVisitType)
    throws SQLException,Exception
  {
    //拼Where子句
    String strCondition = "BackVisitID = "+backVisitNo+" and RegistNo = '"+ StringUtils.rightTrim(registNo)+"' and "
                          +" BackVisitType = '"+StringUtils.rightTrim(backVisitType)+"'";

    //删除回访子表数据开始
    String statement = "";

    statement = " DELETE FROM PrpLbackVisit Where " + strCondition;
    dbManager.executeUpdate(statement);

    statement = " DELETE FROM PrpLbackVisitQue Where " + strCondition;
    dbManager.executeUpdate(statement);

    statement =" DELETE FROM PrpLbackVisitText Where " + strCondition;
    dbManager.executeUpdate(statement);
    //删除回访子表数据结束
  }


  /**
   * 变更回访的操作状态的方法
   *@param backVisitDto 回访对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public void updateClaimStatus(DBManager dbManager,BackVisitDto backVisitDto)
    throws SQLException,Exception
{

 //示例未完成
   String statement = "";


  if(backVisitDto.getPrpLclaimStatusDto() !=null)
   {
     String condition3 = " BusinessNo='" + StringUtils.rightTrim(backVisitDto.getPrpLclaimStatusDto().getBusinessNo()) + "' "
                       + " AND NodeType ='backv' AND SerialNo="+backVisitDto.getPrpLbackVisitDto().getBackVisitType();
    statement = " DELETE FROM prpLclaimStatus Where " + condition3;

    dbManager.executeUpdate(statement);

      new DBPrpLclaimStatus(dbManager).insert(backVisitDto.getPrpLclaimStatusDto() );
   }
}
}
