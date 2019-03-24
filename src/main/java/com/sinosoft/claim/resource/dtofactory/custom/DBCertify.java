package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sinosoft.claim.dto.custom.CertifyDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcertifyCollect;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcertifyDirect;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcertifyImg;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatus;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLqualityCheck;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregistExt;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisitswflog;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ��֤���ݿ�������
 * <p>Title: �������ⵥ֤���ݹ���</p>
 * <p>Description: �������ⵥ֤���ݹ���</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */ 
public class DBCertify
{
  private DBManager dbManager = null; //��Դ������
  /**
   * ���캯��
   * @param dbManager ��Դ������
   */
  public DBCertify()
  {
  }

  /**
   * ��֤���淽��
   *@param certifyDto ��֤����
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public void insert(DBManager dbManager,CertifyDto certifyDto)
    throws SQLException,Exception
  {
    if(certifyDto.getNodeType().equals("CertifDirect")){
      //���������嵥
      String condition = " registNo = " + "'" + certifyDto.getPrpLcertifyCollectDto().getBusinessNo().trim() + "'";
      //ʾ��δ���
      String statement = "";
      statement = " DELETE FROM PrpLcertifyDirect Where " + condition;
      dbManager.executeUpdate(statement);
      if (certifyDto.getPrpLcertifyDirectDtoList() != null) {
        new DBPrpLcertifyDirect(dbManager).insertAll(certifyDto.getPrpLcertifyDirectDtoList());
      }
    } else {String nodeType = certifyDto.getNodeType();
    String businessNo="";

    //����ɾ��ԭ�����������
    deleteSubInfo(dbManager,certifyDto);
    new DBPrpLcertifyCollect(dbManager).insert(certifyDto.getPrpLcertifyCollectDto());
    if(certifyDto.getPrpLcertifyImgDtoList()!=null)
    {
       new DBPrpLcertifyImg(dbManager).insertAll(certifyDto.getPrpLcertifyImgDtoList());
    }    
    if(certifyDto.getPrpLqualityCheckList()!=null) 
    {
        new DBPrpLqualityCheck(dbManager).insertAll(certifyDto.getPrpLqualityCheckList());
     }

    if(certifyDto.getPrpLregistExtDtoList()!=null)
    {
       new DBPrpLregistExt(dbManager).insertAll(certifyDto.getPrpLregistExtDtoList());
    }
    
    //�ط���Ϣ
    if(certifyDto.getPrplreturnvisitswflogDto() != null){
   	 new DBPrplreturnvisitswflog(dbManager).insert(certifyDto.getPrplreturnvisitswflogDto());
    }
    
    //����״̬�ĸı� 
    updateClaimStatus(dbManager,certifyDto);
    }
  }

  /**
   * ��֤ɾ���ӱ���Ϣ
   * @param fcoClaimNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  private void deleteSubInfo(DBManager dbManager,String businessNo)
    throws SQLException,Exception
  {

    String condition1 = " businessNo = " + "'" + businessNo.trim() + "'";
    //ʾ��δ���
    String statement = "";

    statement = " DELETE FROM prplclaimstatus Where " + condition1 +" and nodetype='certi'";
    dbManager.executeUpdate(statement);

    statement = " DELETE FROM prpLcertifyImg Where " + condition1;
    dbManager.executeUpdate(statement);
    statement = " DELETE FROM PrpLcertifyCollect Where " + condition1;
    dbManager.executeUpdate(statement);
  }

  /**
   * ��֤ɾ���ӱ���Ϣ
   * @param fcoClaimNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  private void deleteSubInfo(DBManager dbManager,CertifyDto certifyDto)
    throws SQLException,Exception
  {
    String condition = "";
    String statement = "";
    if (certifyDto.getPrpLcertifyCollectDto() != null) {
      condition = " businessNo = " + "'" + certifyDto.getPrpLcertifyCollectDto().getBusinessNo().trim() + "'";
      statement = " DELETE FROM PrpLcertifyCollect Where " + condition;
      dbManager.executeUpdate(statement);
    }
    if (certifyDto.getPrpLcertifyImgDtoList() != null && certifyDto.getPrpLcertifyImgDtoList().size() > 0) {
      condition = " businessNo = " + "'" + certifyDto.getPrpLcertifyCollectDto().getBusinessNo().trim() + "'";
      statement = " DELETE FROM prpLcertifyImg Where " + condition;
    }
    if (certifyDto.getPrpLqualityCheckList() != null && certifyDto.getPrpLqualityCheckList().size() > 0) {

        condition = " registNo = '" + certifyDto.getPrpLcertifyCollectDto().getBusinessNo().trim()+ "' and QualityCheckType='certi'";
        statement = " DELETE FROM PrpLqualityCheck Where " + condition;
        dbManager.executeUpdate(statement);
      }  

    condition = " registNo = '" + StringUtils.rightTrim(certifyDto.getPrpLcertifyCollectDto().getBusinessNo().trim()) + "'";
    statement =  " DELETE FROM PrpLregistExt Where " + condition;
    dbManager.executeUpdate(statement);
  } 
  /**
   * ��֤ɾ��
   * @param  businessNo
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String businessNo)
    throws SQLException,Exception
  {
    String condition = " businessNo = '" + StringUtils.rightTrim(businessNo) + "'";
    String statement = "";
    //ʾ��δ���
    statement = " DELETE FROM prplclaimstatus Where " + condition +"and nodetype='certi'";
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM prpLcertifyImg Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM PrpLcertifyCollect Where " + condition;
    dbManager.executeUpdate(statement);
  }

  /* 
   * ��֤��ѯ����
   *@param certifyDto ��֤����
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public CertifyDto findByPrimaryKey(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
     String conditions = " businessNo = '"+registNo+"' order by typecode";
     CertifyDto certifyDto = new CertifyDto();
     certifyDto.setPrpLcertifyCollectDto(new DBPrpLcertifyCollect(dbManager).findByPrimaryKey(registNo,"1")); //lossItemCodeĬ����Ϊ1
     String conditionsli=" businessNo = '"+registNo+"'  and ValidStatus ='1'  order by typecode";

     certifyDto.setPrpLcertifyImgDtoList((ArrayList)new DBPrpLcertifyImg(dbManager).findByConditions(conditionsli,0,0));
     conditions = " registNo = '"+registNo+"'";
     certifyDto.setPrpLregistExtDtoList((ArrayList)new DBPrpLregistExt(dbManager).findByConditions(conditions,0,0));
     
     /**
      * �Զ���ĵ�֤���ͺͷ��Զ���ĵ�֤���������ֶβ�ͬ,���Զ���ĵ�֤���Ͱ�typecode����;
      */
     conditions = " registNo = '"+registNo+"' and substr(typeCode,1,2)!='99' order by typecode";
     List list1 = (ArrayList)new DBPrpLcertifyDirect(dbManager).findByConditions(conditions,0,0); 
     
     /**
      * �Զ���ĵ�֤���ͺͷ��Զ���ĵ�֤���������ֶβ�ͬ,�Զ���ĵ�֤���Ͱ�serialno����;
      */
     conditions = " registNo = '"+registNo+"' and substr(typeCode,1,2)='99' order by serialno";
     List list2 = (ArrayList)new DBPrpLcertifyDirect(dbManager).findByConditions(conditions,0,0);
     list1.addAll(list2);
     
     certifyDto.setPrpLcertifyDirectDtoList((ArrayList)list1);
     
     
     conditions = " registNo = '"+registNo+"' and QualityCheckType='certi'";
     certifyDto.setPrpLqualityCheckList((ArrayList)new DBPrpLqualityCheck(dbManager).findByConditions(conditions,0,0));
          
     certifyDto.setPrpLclaimStatusDto(new DBPrpLclaimStatus(dbManager).findByPrimaryKey(registNo,"certi",0));

     return certifyDto;
  }

  /**
   * �����֤�Ĳ���״̬�ķ���
   *@param certifyDto ��������
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public void updateClaimStatus(DBManager dbManager,CertifyDto certifyDto)
    throws SQLException,Exception
 {
    //ʾ��δ���
    String statement = "";
    String nodeType = certifyDto.getNodeType();
    if(nodeType.equals("certi")){
      if(certifyDto.getPrpLclaimStatusDto() !=null)
        {
        String condition3 = " BusinessNo='" + certifyDto.getPrpLclaimStatusDto().getBusinessNo().trim() + "' "
                         + " AND NodeType ='certi'";
        statement = " DELETE FROM prpLclaimStatus Where " + condition3;
        dbManager.executeUpdate(statement);
        new DBPrpLclaimStatus(dbManager).insert(certifyDto.getPrpLclaimStatusDto());
      }
    }
  }
}
