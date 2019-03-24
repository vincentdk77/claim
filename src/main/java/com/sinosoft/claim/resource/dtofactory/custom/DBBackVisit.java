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
 * �ط����ݿ�������
 * <p>Title: ��������ط����ݹ���</p>
 * <p>Description: ��������ط����ݹ���</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author ������Ŀ��
 * @version 1.0
 */
public class DBBackVisit
{
  private DBManager dbManager = null; //��Դ������

  /**
   * ���캯��
   * @param dbManager ��Դ������
   */
  public DBBackVisit()
  {

  }

  /**
   * �طñ��淽��
   * @param backVisitDto �طö���
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public void insert(DBManager dbManager,BackVisitDto backVisitDto)
    throws SQLException,Exception
  {
    if (backVisitDto.getPrpLbackVisitDto() ==null)
    {
      throw new Exception();
    }

    //�õ��طõǼǺš������š�ҵ������
    int  backVisitID= 0 ;
    String registNo="";
    String backVisitType = "";
    backVisitID= backVisitDto.getPrpLbackVisitDto().getBackVisitID();
    registNo = backVisitDto.getPrpLbackVisitDto().getRegistNo();
    backVisitType = backVisitDto.getPrpLbackVisitDto().getBackVisitType();

    //����ɾ��ԭ�����������
    deleteSubInfo(dbManager,backVisitID,registNo,backVisitType);

    //����ط�����
    new DBPrpLbackVisit(dbManager).insert(backVisitDto.getPrpLbackVisitDto());

    //����ط���ѯ��
    if(backVisitDto.getPrpLbackVisitQueDtoList()!=null)
    {
       new DBPrpLbackVisitQue(dbManager).insertAll(backVisitDto.getPrpLbackVisitQueDtoList());
    }
    //����طÿͻ������
    if(backVisitDto.getPrpLbackVisitTextDtoList()!=null)
    {
       new DBPrpLbackVisitText(dbManager).insertAll(backVisitDto.getPrpLbackVisitTextDtoList());
    }
    //����״̬�ĸı�

    updateClaimStatus(dbManager,backVisitDto);
  }



  /**
   * �طö���ɾ��
   * @param backVisitNo
   * @param registNo
   * @param backVisitType
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,int backVisitNo,String registNo,String backVisitType)
    throws SQLException,Exception
  {

    //ƴWhere�Ӿ�
    String strCondition = "BackVisitID = "+backVisitNo+" and RegistNo = '"+ StringUtils.rightTrim(registNo)+"' and "
                          +" BackVisitType = '"+StringUtils.rightTrim(backVisitType)+"'";

    //ɾ���ط��ӱ����ݿ�ʼ
    String statement = "";

    statement = " DELETE FROM PrpLbackVisit Where " + strCondition;
    dbManager.executeUpdate(statement);

    statement = " DELETE FROM PrpLbackVisitQue Where " + strCondition;
    dbManager.executeUpdate(statement);

    statement =" DELETE FROM PrpLbackVisitText Where " + strCondition;
    dbManager.executeUpdate(statement);

 }

  /*
   * �طò�ѯ����
   * @param backVisitNo
   * @param registNo
   * @param backVisitType
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public BackVisitDto findByPrimaryKey(DBManager dbManager,int backVisitNo,String registNo,String backVisitType)
    throws SQLException,Exception
  {
     //ƴWhere�Ӿ�
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
   * �ط�ɾ���ӱ���Ϣ
   * @param backVisitNo
   * @param registNo
   * @param backVisitType
   * @throws SQLException
   * @throws Exception
   */
  private void deleteSubInfo(DBManager dbManager,int backVisitNo,String registNo,String backVisitType)
    throws SQLException,Exception
  {
    //ƴWhere�Ӿ�
    String strCondition = "BackVisitID = "+backVisitNo+" and RegistNo = '"+ StringUtils.rightTrim(registNo)+"' and "
                          +" BackVisitType = '"+StringUtils.rightTrim(backVisitType)+"'";

    //ɾ���ط��ӱ����ݿ�ʼ
    String statement = "";

    statement = " DELETE FROM PrpLbackVisit Where " + strCondition;
    dbManager.executeUpdate(statement);

    statement = " DELETE FROM PrpLbackVisitQue Where " + strCondition;
    dbManager.executeUpdate(statement);

    statement =" DELETE FROM PrpLbackVisitText Where " + strCondition;
    dbManager.executeUpdate(statement);
    //ɾ���ط��ӱ����ݽ���
  }


  /**
   * ����طõĲ���״̬�ķ���
   *@param backVisitDto �طö���
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public void updateClaimStatus(DBManager dbManager,BackVisitDto backVisitDto)
    throws SQLException,Exception
{

 //ʾ��δ���
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
