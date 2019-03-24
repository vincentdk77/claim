package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sinosoft.claim.dto.custom.VerifyLossDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcarLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatus;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcomponent;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLperson;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpersonWound;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLprop;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregistExt;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLrepairFee;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLverifyLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLverifyLossExt;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplcompensatehouse;

/**
 * 定损数据库管理对象
 * <p>Title: 车险理赔定损数据管理</p>
 * <p>Description: 车险理赔定损数据管理</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class DBVerifyLoss
{
  private DBManager dbManager = null; //资源管理类

  /**
   * 构造函数
   * @param dbManager 资源管理类
   */ 
  public DBVerifyLoss()
  {

  }

  /**
   * 定损保存方法
   *@param verifyLossDto 定损对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public void insert(DBManager dbManager,VerifyLossDto verifyLossDto)
    throws SQLException,Exception
  {

    if (verifyLossDto.getPrpLverifyLossDto() ==null)
    {
             throw new Exception();
    }
    PrpLclaimStatusDto prpLclaimStatusDto=verifyLossDto.getPrpLclaimStatusDto();

    PrpLverifyLossDto prpLverifyLossDto = verifyLossDto.getPrpLverifyLossDto();

    //报案号码 关键字
    String registNo = prpLverifyLossDto.getRegistNo();
    String lossItemCode = prpLverifyLossDto.getLossItemCode();
    //首先删除原来的相关数据 
    deleteSubInfo(dbManager,registNo,lossItemCode);

    new DBPrpLverifyLoss(dbManager).insert(verifyLossDto.getPrpLverifyLossDto());
    //定损车辆表
    if(verifyLossDto.getPrpLcarLossDtoList()!=null)
    {
       new DBPrpLcarLoss(dbManager).insertAll(verifyLossDto.getPrpLcarLossDtoList());
    }
    //修理费用清单
    if(verifyLossDto.getPrpLrepairFeeDtoList()!=null)
    {
       new DBPrpLrepairFee(dbManager).insertAll(verifyLossDto.getPrpLrepairFeeDtoList());
    }
    //换件项目清单
    if(verifyLossDto.getPrpLcomponentDtoList()!=null)
    {
       new DBPrpLcomponent(dbManager).insertAll(verifyLossDto.getPrpLcomponentDtoList());
    }
    //人员伤亡明细信息表
    if(verifyLossDto.getPrpLpersonDtoList()!=null)
    {
       new DBPrpLperson(dbManager).insertAll(verifyLossDto.getPrpLpersonDtoList());
    }
    //财产核定损明细清单表
    if(verifyLossDto.getPrpLpropDtoList()!=null)
    {
       new DBPrpLprop(dbManager).insertAll(verifyLossDto.getPrpLpropDtoList());
    }
    //定核损处理标的表
    /*
    if(verifyLossDto.getPrpLverifyLossItemDtoList()!=null&&verifyLossDto.getPrpLverifyLossItemDtoList().size()>0){
      new DBPrpLverifyLossItem(dbManager).insertAll(verifyLossDto.getPrpLverifyLossItemDtoList());
    }*/
    //伤情信息表
    if(verifyLossDto.getPrpLpersonWoundDtoList()!=null&&verifyLossDto.getPrpLpersonWoundDtoList().size()>0){
      new DBPrpLpersonWound(dbManager).insertAll(verifyLossDto.getPrpLpersonWoundDtoList());
    }
    //System.err.println("size3:"+ verifyLossDto.getPrplCompensateHouseDtoList().size());
    if(verifyLossDto.getPrplCompensateHouseDtoList()!=null && verifyLossDto.getPrplCompensateHouseDtoList().size() > 0)
    {
        PrplcompensatehouseDto PrplcompensatehouseDto = (PrplcompensatehouseDto)verifyLossDto.getPrplCompensateHouseDtoList().get(0);
		String registno = PrplcompensatehouseDto.getRegistno();
		String nodetype = PrplcompensatehouseDto.getNodetype();
		String condition = " registno='" + registno + "' and nodetype='" + nodetype + "'";
		new DBPrplcompensatehouse(dbManager).deleteByConditions(condition);
        new DBPrplcompensatehouse(dbManager).insertAll(verifyLossDto.getPrplCompensateHouseDtoList());
    }
    //定核损扩展信息 
    if(verifyLossDto.getPrpLverifyLossExtDtoList()!=null)
    {
       new DBPrpLverifyLossExt(dbManager).insertAll(verifyLossDto.getPrpLverifyLossExtDtoList());
    }
    //扩展信息 
    if(verifyLossDto.getPrpLregistExtDtoList()!=null)
    {
       new DBPrpLregistExt(dbManager).insertAll(verifyLossDto.getPrpLregistExtDtoList());
    }
    //进行状态的改变
    updateClaimStatus(dbManager,verifyLossDto);
  }

  /**
   * 定损删除子表信息
   * @param registNo //报案号
   * @throws SQLException
   * @throws Exception
   */
  private void deleteSubInfo(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
    String condition = " registNo = " + "'" + registNo.trim() + "'";
    //示例未完成
    String statement = "";
    //修理费用清单
    statement = " DELETE FROM prpLrepairFee Where " + condition;
    dbManager.executeUpdate(statement);
    //换件项目清单
    statement = " DELETE FROM prpLcomponent Where " + condition;
    dbManager.executeUpdate(statement);
    //人员伤亡明细信息
    statement = " DELETE FROM prpLperson Where " + condition;
    dbManager.executeUpdate(statement);
    //财产核定损明细
    statement = " DELETE FROM prpLprop Where " + condition;
    dbManager.executeUpdate(statement);
    //定损车辆表
    statement = " DELETE FROM prpLcarLoss Where " + condition;
    dbManager.executeUpdate(statement);

    //伤情信息表
    statement = " DELETE FROM PrpLpersonWound Where " + condition;
    dbManager.executeUpdate(statement);

    statement = " DELETE FROM PrpLverifyLoss Where " + condition;
    dbManager.executeUpdate(statement);
  }

  /**
   * 定损删除子表信息
   * @param registNo //报案号
   * @throws SQLException
   * @throws Exception
   */
  private void deleteSubInfo(DBManager dbManager,String registNo,String lossItemCode)
    throws SQLException,Exception
  {
    String condition = " registNo = " + "'" + registNo.trim() + "'  ";
    String condition1 = " registNo = " + "'" + registNo.trim() + "' and  lossItemCode ='" + lossItemCode + "'";
    //示例未完成
    String statement = ""; 
    //删除定核损扩展信息
    statement =  " DELETE FROM PrpLverifyLossExt Where " + condition1;
    dbManager.executeUpdate(statement);
    //删除扩展信息
    statement =  " DELETE FROM PrpLregistExt Where " + condition;
    dbManager.executeUpdate(statement);

    int i = Integer.parseInt(DataUtils.nullToZero(lossItemCode));
    if(i > 0){
      //condition = condition + " and LossItemCode='"+lossItemCode+"'";
      //修理费用清单
      statement = " DELETE FROM prpLrepairFee Where " + condition + " and LossItemCode='"+lossItemCode+"'";
      dbManager.executeUpdate(statement);
      //换件项目清单
      statement = " DELETE FROM prpLcomponent Where " + condition + " and LossItemCode='"+lossItemCode+"'";
      dbManager.executeUpdate(statement);
      //定损车辆表
      statement = " DELETE FROM prpLcarLoss Where " + condition + " and LossItemCode='"+lossItemCode+"'";
      dbManager.executeUpdate(statement);
    }else if(i == 0){
      //人员伤亡明细信息
      statement = " DELETE FROM prpLperson Where " + condition;
      dbManager.executeUpdate(statement);
      //伤情信息表
      statement = " DELETE FROM PrpLpersonWound Where " + condition;
      dbManager.executeUpdate(statement);

    }else if(i == -1){
      //财产核定损明细
      statement = " DELETE FROM prpLprop Where " + condition;
      dbManager.executeUpdate(statement);
    }else if(i == -2){
      // 财产核定损明细
        statement = " DELETE FROM prpLprop Where " + condition;
        dbManager.executeUpdate(statement);
    }
      //modify by liujianbo modify 20050315 start
      //reason:增加物损定损 
      /*
      if(i==1){
        statement = " DELETE FROM prpLprop Where " + condition;
        dbManager.executeUpdate(statement);
      }
    */
      //modify by liujianbo modify 20050315 end
    //statement = " DELETE FROM PrpLverifyLossitem Where " + condition +" and serialNo="+lossItemCode;
    //statement = " DELETE FROM PrpLverifyLossitem Where " + condition;
    //dbManager.executeUpdate(statement);

   
    condition = condition + " and LossItemCode='"+lossItemCode+"'";
    statement = " DELETE FROM PrpLverifyLoss Where " + condition;
    dbManager.executeUpdate(statement);
  }

  /**
   * 定损删除
   * @param verifyLossNo
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String registNo,String nodeType)
    throws SQLException,Exception
{
  String condition = " registNo = " + "'" + registNo.trim() + "'";
  String condition1 = " businessNo = " + "'" + registNo.trim() + "' AND NodeType ='" + nodeType.trim() + "'";
  //示例未完成
  String statement = "";
  //修理费用清单
  statement = " DELETE FROM prpLrepairFee Where " + condition;
  dbManager.executeUpdate(statement);
  //换件项目清单
  statement = " DELETE FROM prpLcomponent Where " + condition;
  dbManager.executeUpdate(statement);
  //人员伤亡明细信息
  statement = " DELETE FROM prpLperson Where " + condition;
  dbManager.executeUpdate(statement);
  //财产核定损明细
  statement = " DELETE FROM prpLprop Where " + condition;
  dbManager.executeUpdate(statement);
  //定损车辆表
  statement = " DELETE FROM prpLcarLoss Where " + condition;
  dbManager.executeUpdate(statement);
  //状态
  statement = " DELETE FROM prplclaimstatus Where " + condition1;
  dbManager.executeUpdate(statement);
  //定损主表
  statement = " DELETE FROM PrpLverifyLoss Where " + condition;
  dbManager.executeUpdate(statement);

}

  /**
	 * 变更定损的操作状态的方法
	 * 
	 * @param verifyLossDto
	 *            立案对象
	 * @throws SQLException
	 * @throws Exception
	 * @return 无
	 */
	public void updateClaimStatus(DBManager dbManager,
			VerifyLossDto verifyLossDto) throws SQLException, Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		// 示例未完成
		String statement = "";
		String riskCode = verifyLossDto.getPrpLverifyLossDto().getRiskCode();
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
		if (!strRiskType.equals("H")) {
			if (verifyLossDto.getPrpLclaimStatusDto() != null) {
				// 考虑反正是要回写的，都删除了吧
				String condition3 = " BusinessNo='"
						+ verifyLossDto.getPrpLclaimStatusDto().getBusinessNo()
								.trim()
						+ "' "
						+ " and nodeType='"
						+ verifyLossDto.getPrpLclaimStatusDto().getNodeType()
								.trim() + "' " + " AND serialNo="
						+ verifyLossDto.getPrpLclaimStatusDto().getSerialNo();

				statement = " DELETE FROM prpLclaimStatus Where " + condition3;
				dbManager.executeUpdate(statement);
				new DBPrpLclaimStatus(dbManager).insert(verifyLossDto
						.getPrpLclaimStatusDto());
			}
		}
	}

  /*
   * 定损查询方法
   *@param verifyLossDto 定损对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */

  public VerifyLossDto findByPrimaryKey(DBManager dbManager,String registNo,String lossItemCode,String nodeType)
    throws SQLException,Exception
  {

     String conditions = " registNo = '"+registNo+"'"; 
     String conditions1 = " registNo = '"+registNo+"' AND LossItemCode='"+lossItemCode+"'";
     String conditions2 = "registNo = '"+ registNo +"' order by personNo";
     VerifyLossDto verifyLossDto = new VerifyLossDto();
     
     verifyLossDto.setPrpLverifyLossExtDtoList((ArrayList)new DBPrpLverifyLossExt(dbManager).findByConditions(conditions1,0,0));
     verifyLossDto.setPrpLregistExtDtoList((ArrayList)new DBPrpLregistExt(dbManager).findByConditions(conditions,0,0));
     verifyLossDto.setPrpLverifyLossDto(new DBPrpLverifyLoss(dbManager).findByPrimaryKey(registNo,lossItemCode));
     //verifyLossDto.setPrpLverifyLossItemDtoList((ArrayList)new DBPrpLverifyLossItem(dbManager).findByConditions(conditions,0,0));
     verifyLossDto.setPrpLclaimStatusDto(new DBPrpLclaimStatus(dbManager).findByPrimaryKey(registNo,nodeType,Integer.parseInt(DataUtils.nullToZero(lossItemCode))));
     verifyLossDto.setPrpLpersonDtoList((ArrayList)new DBPrpLperson(dbManager).findByConditions(conditions2,0,0));
     verifyLossDto.setPrpLpropDtoList((ArrayList)new DBPrpLprop(dbManager).findByConditions(conditions,0,0));
     verifyLossDto.setPrpLpersonWoundDtoList((ArrayList)new DBPrpLpersonWound(dbManager).findByConditions(conditions,0,0));
     conditions = " registNo = '"+registNo+"' AND LossItemCode='"+lossItemCode+"'";
     verifyLossDto.setPrpLrepairFeeDtoList((ArrayList)new DBPrpLrepairFee(dbManager).findByConditions(conditions,0,0));
     verifyLossDto.setPrpLcarLossDtoList((ArrayList)new DBPrpLcarLoss(dbManager).findByConditions(conditions,0,0));
     verifyLossDto.setPrpLcomponentDtoList((ArrayList)new DBPrpLcomponent(dbManager).findByConditions(conditions,0,0));
     return verifyLossDto;
  }

}
 