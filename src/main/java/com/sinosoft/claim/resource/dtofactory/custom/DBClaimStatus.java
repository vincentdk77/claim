package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.ClaimStatusDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatus;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 理赔节点状态数据库管理对象
 * <p>Title: 车险理赔理赔节点状态数据管理</p>
 * <p>Description: 车险理赔理赔节点状态数据管理</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class DBClaimStatus
{
  private DBManager dbManager = null; //资源管理类

  /**
   * 构造函数
   * @param dbManager 资源管理类
   */
  public DBClaimStatus()
  {
  }

  /**
   * 理赔节点状态保存方法
   *@param claimStatusDto 理赔节点状态对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public void insert(DBManager dbManager,ClaimStatusDto claimStatusDto)
    throws SQLException,Exception
  {
    if (claimStatusDto.getPrpLclaimStatusDto() ==null)
    {
             throw new Exception();
    }

    //首先删除原来的相关数据
   deleteSubInfo(dbManager,claimStatusDto);
    new DBPrpLclaimStatus(dbManager).insert(claimStatusDto.getPrpLclaimStatusDto());
  }

  /**
   * 理赔节点状态删除子表信息
   * @param fcoClaimNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  private void deleteSubInfo(DBManager dbManager,ClaimStatusDto claimStatusDto)
    throws SQLException,Exception
  {
	 //示例未完成
	   String statement = "";
	   String condition3 = "";
    if(claimStatusDto.getPrpLclaimStatusDto() !=null)
   {
     if (claimStatusDto.getPrpLclaimStatusDto().getNodeType().equals("certa")||
         claimStatusDto.getPrpLclaimStatusDto().getNodeType().equals("verif"))
         {
         	 condition3 = " BusinessNo='" + StringUtils.rightTrim(claimStatusDto.getPrpLclaimStatusDto().getBusinessNo()) + "' "
                       + " AND (NodeType ='certa' or NodeType='verif') and typeflag='"
                       + StringUtils.rightTrim(claimStatusDto.getPrpLclaimStatusDto().getTypeFlag()+"'");
        }else
        {
     condition3 = " BusinessNo='" + StringUtils.rightTrim(claimStatusDto.getPrpLclaimStatusDto().getBusinessNo()) + "' "
                       + " AND NodeType ='"+StringUtils.rightTrim(claimStatusDto.getPrpLclaimStatusDto().getNodeType())+"' ";
        }

    statement = " DELETE FROM prpLclaimStatus Where " + condition3;

    dbManager.executeUpdate(statement);
    }
  }

  /**
   * 状态删除
   * @param fcoClaimStatusNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String claimStatusNo,String nodeType,int serialNo)
    throws SQLException,Exception
{
       //示例未完成
    String statement = "";
    String condition = " BusinessNo = '" + StringUtils.rightTrim(claimStatusNo) + "'"
                     + " AND nodetype='"+ nodeType+"'";

    if (serialNo!=0)
    {
    	condition = condition +" And serialNo=" + serialNo;
    }

    //示例未完成
    statement =  " DELETE FROM prpLclaimStatus Where " + condition;
    dbManager.executeUpdate(statement);
  }


  /*
   * 理赔节点状态查询方法
   *@param claimStatusDto 理赔节点状态对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public ClaimStatusDto findByPrimaryKey(DBManager dbManager,String claimStatusNo,String nodeType,int serialNo)
    throws SQLException,Exception
  {
     String conditions = " BusinessNo = '"+claimStatusNo+"'";
     ClaimStatusDto claimStatusDto = new ClaimStatusDto();
     claimStatusDto.setPrpLclaimStatusDto(new DBPrpLclaimStatus(dbManager).findByPrimaryKey(claimStatusNo,nodeType,serialNo));

     return claimStatusDto;
  }
}
