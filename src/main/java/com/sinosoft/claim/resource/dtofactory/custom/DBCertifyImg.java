package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcertifyImg;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ��֤ͼƬ���ݿ�������
 * <p>Title: �������ⵥ֤ͼƬ���ݹ���</p>
 * <p>Description: �������ⵥ֤ͼƬ���ݹ���</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author ������Ŀ��
 * @version 1.0
 */
public class DBCertifyImg
{
  private DBManager dbManager = null; //��Դ������

  /**
   * ���캯��
   * @param dbManager ��Դ������
   */
  public DBCertifyImg()
  {
 
  }

  /**
   * ��֤ͼƬ���淽��
   * @param certifyImgDto ��֤ͼƬ����
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public void insert(DBManager dbManager,PrpLcertifyImgDto prpLcertifyImgDto) 
    throws SQLException,Exception
  { 
    //ȡ�����ݿ��е��Ѵ��¼
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
    
    //���浥֤ͼƬ��ѯ��
    if(prpLcertifyImgDto.getCertifyImgList()!=null) {
       new DBPrpLcertifyImg(dbManager).insertAll(prpLcertifyImgDto.getCertifyImgList());
    }
  }

  /**
   * ��֤ͼƬ����ɾ��
   * @throws SQLException
   * @throws Exception 
   */
  public void deleteImg(DBManager dbManager,String imgFileName)
    throws SQLException,Exception
  {
    //ƴWhere�Ӿ�
    String condition = " imgFileName = '"+imgFileName+"'";

    //ɾ����֤ͼƬ�ӱ����ݿ�ʼ
    String statement = "";

    statement =" DELETE FROM PrpLcertifyImg Where " + condition;
    dbManager.executeUpdate(statement);
 }

  /**
   * ��֤ͼƬ����ɾ��
   * @throws SQLException   
   * @throws Exception
   */
  public void delete(DBManager dbManager,PrpLcertifyImgDto prpLcertifyImgDto)
    throws SQLException,Exception
  {
    //ƴWhere�Ӿ�
    String condition = " imgFileName = '"+prpLcertifyImgDto.getImgFileName()+"'";
    
    //ɾ����֤ͼƬ�ӱ����ݿ�ʼ
    String statement = "";
    prpLcertifyImgDto.setSerialNo(100);
    statement =" DELETE FROM PrpLcertifyImg Where " + condition;
    //System.out.println("----ɾ��ɾ��---2----"+statement); 
    dbManager.executeUpdate(statement);
}  
 
  /**
   * ��֤ͼƬ����ɾ��
   * @throws SQLException   
   * @throws Exception
   */
  public void update(DBManager dbManager,PrpLcertifyImgDto prpLcertifyImgDto)
    throws SQLException,Exception
  {
  	PrpLcertifyImgDto prpLcertifyImgDto1= findByPrimaryKey(dbManager,prpLcertifyImgDto);
  	
    //ƴWhere�Ӿ�,�ϸ�����ɾ���ݡ�
    String condition = " imgFileName = '" + prpLcertifyImgDto.getImgFileName() 
            + "' and SerialNo =" + prpLcertifyImgDto1.getSerialNo()
            + "  and BusinessNo = '" + prpLcertifyImgDto1.getBusinessNo() 
            + "' and LossItemCode = '" + prpLcertifyImgDto1.getLossItemCode() + "'";

    //ɾ����֤ͼƬ�ӱ����ݿ�ʼ
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
   * ��֤ͼƬ��ѯ����
   * @param certifyImgNo
   * @param registNo
   * @param certifyImgType
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public PrpLcertifyImgDto findByPrimaryKey(DBManager dbManager,PrpLcertifyImgDto prpLcertifyImgDto)
    throws SQLException,Exception
  { 
    //ƴWhere�Ӿ�    //add by liyanjie 20051104 add :" and ValidStatus='1'  "
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
   *@return ��
   */
  public PrpLcertifyImgDto findByBusinessno(DBManager dbManager,String businessno)
    throws SQLException,Exception
  { 
     //ƴWhere�Ӿ� 
     String conditions = "businessno = '"+businessno+"'";
     PrpLcertifyImgDto prpLcertifyImgDtoTemp = null;
     List listTmep = (ArrayList)new DBPrpLcertifyImg(dbManager).findByConditions(conditions);
     if(listTmep!=null&&listTmep.size()>0){
     	prpLcertifyImgDtoTemp = (PrpLcertifyImgDto)listTmep.get(0);
     } 
     return prpLcertifyImgDtoTemp;
  }
  
  /**
   * ��֤�����߼�ɾ��
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
