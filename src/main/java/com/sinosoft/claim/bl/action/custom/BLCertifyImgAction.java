package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBCertifyImg;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 单证图片action
 * <p>Title: 车险理赔 单证图片acton</p>
 * <p>Description: 车险理赔 单证图片acton</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author 理赔项目组
 * @version 1.0
 */ 
public class BLCertifyImgAction
{
  public BLCertifyImgAction()
  { 
  } 
     
  /**
   * 保存单证图片
   * @param PrpLcertifyImgDto：自定义单证图片对象
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,PrpLcertifyImgDto prpLcertifyImgDto)
    throws SQLException,Exception
  { 
      DBCertifyImg dbCertifyImg = new DBCertifyImg(); 
      dbCertifyImg.insert(dbManager,prpLcertifyImgDto); 
  }

  /**
   * 删除单证图片对象
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,PrpLcertifyImgDto prpLcertifyImgDto)
    throws SQLException,Exception
  {
      new DBCertifyImg().delete(dbManager,prpLcertifyImgDto);
  }

  /**
   * 删除单证图片对象
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void update(DBManager dbManager,PrpLcertifyImgDto prpLcertifyImgDto)
    throws SQLException,Exception
  {
      new DBCertifyImg().update(dbManager,prpLcertifyImgDto);
  }
  /**
   * 获得单证图片对象
   * @param  dbManager  数据连接
   * @return 自定义单证图片对象
   * @throws SQLException
   * @throws Exception
   */
  public PrpLcertifyImgDto findByPrimaryKey(DBManager dbManager,PrpLcertifyImgDto prpLcertifyImgDto)
    throws SQLException,Exception
  {
    PrpLcertifyImgDto prpLcertifyImgDtoTemp = null;
    prpLcertifyImgDtoTemp = new DBCertifyImg().findByPrimaryKey(dbManager,prpLcertifyImgDto); 
    return prpLcertifyImgDtoTemp;  
  }
    /**
   * 根据条件更新单证影像表信息
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   * add by liyanjie 2005-11-04 reason:单证删除功能
   */
  public void updateByCondition(DBManager dbManager,String condition)
    throws SQLException,Exception
  {
      new DBCertifyImg().updateByCondition(dbManager,condition);
  }

}
