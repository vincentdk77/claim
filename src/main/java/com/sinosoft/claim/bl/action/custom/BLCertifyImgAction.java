package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBCertifyImg;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ��֤ͼƬaction
 * <p>Title: �������� ��֤ͼƬacton</p>
 * <p>Description: �������� ��֤ͼƬacton</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author ������Ŀ��
 * @version 1.0
 */ 
public class BLCertifyImgAction
{
  public BLCertifyImgAction()
  { 
  } 
     
  /**
   * ���浥֤ͼƬ
   * @param PrpLcertifyImgDto���Զ��嵥֤ͼƬ����
   * @param dbManager  ��������
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
   * ɾ����֤ͼƬ����
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,PrpLcertifyImgDto prpLcertifyImgDto)
    throws SQLException,Exception
  {
      new DBCertifyImg().delete(dbManager,prpLcertifyImgDto);
  }

  /**
   * ɾ����֤ͼƬ����
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void update(DBManager dbManager,PrpLcertifyImgDto prpLcertifyImgDto)
    throws SQLException,Exception
  {
      new DBCertifyImg().update(dbManager,prpLcertifyImgDto);
  }
  /**
   * ��õ�֤ͼƬ����
   * @param  dbManager  ��������
   * @return �Զ��嵥֤ͼƬ����
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
   * �����������µ�֤Ӱ�����Ϣ
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   * add by liyanjie 2005-11-04 reason:��֤ɾ������
   */
  public void updateByCondition(DBManager dbManager,String condition)
    throws SQLException,Exception
  {
      new DBCertifyImg().updateByCondition(dbManager,condition);
  }

}
