package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcertifyImg;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 单证图片数据库管理对象
 * <p>Title: 车险理赔单证图片数据管理</p>
 * <p>Description: 车险理赔单证图片数据管理</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author 理赔项目组
 * @version 1.0
 */
public class DBCertifyImg
{
  private DBManager dbManager = null; //资源管理类

  /**
   * 构造函数
   * @param dbManager 资源管理类
   */
  public DBCertifyImg()
  {
 
  }

  /**
   * 单证图片保存方法
   * @param certifyImgDto 单证图片对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public void insert(DBManager dbManager,PrpLcertifyImgDto prpLcertifyImgDto) 
    throws SQLException,Exception
  { 
    //取得数据库中的已存记录
    String condition = " businessNo='" + prpLcertifyImgDto.getBusinessNo() + "'";
    int maxSerialNo = new DBPrpLcertifyImg(dbManager).getMaxSerialNo(condition);
    
    ArrayList listTemp = new ArrayList();;
    List certifyImgListList = (ArrayList)prpLcertifyImgDto.getCertifyImgList();
    if (certifyImgListList != null && certifyImgListList.size() > 0){
      for (int i = 0; i < certifyImgListList.size(); i++) {
        PrpLcertifyImgDto prpLcertifyImgDtoTemp1 = (PrpLcertifyImgDto) certifyImgListList.get(i);
        prpLcertifyImgDtoTemp1.setSerialNo(maxSerialNo + 1); 
        listTemp.add(prpLcertifyImgDtoTemp1); 
        maxSerialNo++; 
      }    
    }  
    prpLcertifyImgDto.setCertifyImgList(listTemp);
    
    //保存单证图片问询表
    if(prpLcertifyImgDto.getCertifyImgList()!=null) {
       new DBPrpLcertifyImg(dbManager).insertAll(prpLcertifyImgDto.getCertifyImgList());
    }
  }

  /**
   * 单证图片对象删除
   * @throws SQLException
   * @throws Exception 
   */
  public void deleteImg(DBManager dbManager,String imgFileName)
    throws SQLException,Exception
  {
    //拼Where子句
    String condition = " imgFileName = '"+imgFileName+"'";

    //删除单证图片子表数据开始
    String statement = "";

    statement =" DELETE FROM PrpLcertifyImg Where " + condition;
    dbManager.executeUpdate(statement);
 }

  /**
   * 单证图片对象删除
   * @throws SQLException   
   * @throws Exception
   */
  public void delete(DBManager dbManager,PrpLcertifyImgDto prpLcertifyImgDto)
    throws SQLException,Exception
  {
    //拼Where子句
    String condition = " imgFileName = '"+prpLcertifyImgDto.getImgFileName()+"'";
    
    //删除单证图片子表数据开始
    String statement = "";
    prpLcertifyImgDto.setSerialNo(100);
    statement =" DELETE FROM PrpLcertifyImg Where " + condition;
    //System.out.println("----删除删除---2----"+statement); 
    dbManager.executeUpdate(statement);
}  
 
  /**
   * 单证图片对象删除
   * @throws SQLException   
   * @throws Exception
   */
  public void update(DBManager dbManager,PrpLcertifyImgDto prpLcertifyImgDto)
    throws SQLException,Exception
  {
  	PrpLcertifyImgDto prpLcertifyImgDto1= findByPrimaryKey(dbManager,prpLcertifyImgDto);
  	
    //拼Where子句,严格按主键删数据。
    String condition = " imgFileName = '" + prpLcertifyImgDto.getImgFileName() 
            + "' and SerialNo =" + prpLcertifyImgDto1.getSerialNo()
            + "  and BusinessNo = '" + prpLcertifyImgDto1.getBusinessNo() 
            + "' and LossItemCode = '" + prpLcertifyImgDto1.getLossItemCode() + "'";

    //删除单证图片子表数据开始
    String statement = "";

    statement =" DELETE FROM PrpLcertifyImg Where " + condition;

    dbManager.executeUpdate(statement);
    prpLcertifyImgDto.setBusinessNo(prpLcertifyImgDto1.getBusinessNo());
    prpLcertifyImgDto.setSerialNo(prpLcertifyImgDto1.getSerialNo());
    prpLcertifyImgDto.setUploadNodeFlag(prpLcertifyImgDto1.getUploadNodeFlag());
    prpLcertifyImgDto.setValidStatus("1");
    new DBPrpLcertifyImg(dbManager).insert(prpLcertifyImgDto);
} 
  
  /*
   * 单证图片查询方法
   * @param certifyImgNo
   * @param registNo
   * @param certifyImgType
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public PrpLcertifyImgDto findByPrimaryKey(DBManager dbManager,PrpLcertifyImgDto prpLcertifyImgDto)
    throws SQLException,Exception
  { 
    //拼Where子句    //add by liyanjie 20051104 add :" and ValidStatus='1'  "
    String conditions = "imgFileName = '" + prpLcertifyImgDto.getImgFileName() + "'  and ValidStatus='1' ";
    
     PrpLcertifyImgDto prpLcertifyImgDtoTemp = null;
     List listTmep = (ArrayList)new DBPrpLcertifyImg(dbManager).findByConditions(conditions);
     if(listTmep!=null&&listTmep.size()>0){
     	prpLcertifyImgDtoTemp = (PrpLcertifyImgDto)listTmep.get(0);
     } 
     return prpLcertifyImgDtoTemp;
  }

  /*
   * @param certifyImgNo
   * @param registNo
   * @param certifyImgType
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public PrpLcertifyImgDto findByBusinessno(DBManager dbManager,String businessno)
    throws SQLException,Exception
  { 
     //拼Where子句 
     String conditions = "businessno = '"+businessno+"'";
     PrpLcertifyImgDto prpLcertifyImgDtoTemp = null;
     List listTmep = (ArrayList)new DBPrpLcertifyImg(dbManager).findByConditions(conditions);
     if(listTmep!=null&&listTmep.size()>0){
     	prpLcertifyImgDtoTemp = (PrpLcertifyImgDto)listTmep.get(0);
     } 
     return prpLcertifyImgDtoTemp;
  }
  
  /**
   * 单证对象逻辑删除
   * @throws SQLException   
   * @throws Exception
   * add by liyanjie 2005-11-03
   */
  public void updateByCondition(DBManager dbManager,String condition)
    throws SQLException,Exception
  {
    String statement = "Update PrpLcertifyImg Set " + condition;
    dbManager.executeUpdate(statement);
  }   
}
