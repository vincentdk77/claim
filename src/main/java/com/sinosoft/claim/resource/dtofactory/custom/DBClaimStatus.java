package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.ClaimStatusDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatus;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����ڵ�״̬���ݿ�������
 * <p>Title: ������������ڵ�״̬���ݹ���</p>
 * <p>Description: ������������ڵ�״̬���ݹ���</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class DBClaimStatus
{
  private DBManager dbManager = null; //��Դ������

  /**
   * ���캯��
   * @param dbManager ��Դ������
   */
  public DBClaimStatus()
  {
  }

  /**
   * ����ڵ�״̬���淽��
   *@param claimStatusDto ����ڵ�״̬����
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public void insert(DBManager dbManager,ClaimStatusDto claimStatusDto)
    throws SQLException,Exception
  {
    if (claimStatusDto.getPrpLclaimStatusDto() ==null)
    {
             throw new Exception();
    }

    //����ɾ��ԭ�����������
   deleteSubInfo(dbManager,claimStatusDto);
    new DBPrpLclaimStatus(dbManager).insert(claimStatusDto.getPrpLclaimStatusDto());
  }

  /**
   * ����ڵ�״̬ɾ���ӱ���Ϣ
   * @param fcoClaimNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  private void deleteSubInfo(DBManager dbManager,ClaimStatusDto claimStatusDto)
    throws SQLException,Exception
  {
	 //ʾ��δ���
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
   * ״̬ɾ��
   * @param fcoClaimStatusNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String claimStatusNo,String nodeType,int serialNo)
    throws SQLException,Exception
{
       //ʾ��δ���
    String statement = "";
    String condition = " BusinessNo = '" + StringUtils.rightTrim(claimStatusNo) + "'"
                     + " AND nodetype='"+ nodeType+"'";

    if (serialNo!=0)
    {
    	condition = condition +" And serialNo=" + serialNo;
    }

    //ʾ��δ���
    statement =  " DELETE FROM prpLclaimStatus Where " + condition;
    dbManager.executeUpdate(statement);
  }


  /*
   * ����ڵ�״̬��ѯ����
   *@param claimStatusDto ����ڵ�״̬����
   * @throws SQLException
   * @throws Exception
   *@return ��
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
