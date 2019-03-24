package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDuser;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * ��¼�߼�
 * <p>Title: ����������������</p>
 * <p>Description: �����������������¼action</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author ����������Ŀ��
 * @version 1.0
 */

public class BLLogonAction
{
  public BLLogonAction(){}

  /**
   * ����û���Ϣ
   * @param usercode���û�����
   * @param password���û����루���ģ�
   * @return ��Ч/��Ч
   * @throws SQLException
   * @throws Exception
   */
  public PrpDuserDto checkUser(DBManager dbManager,String usercode,String password)
    throws SQLException,Exception
  {

    PrpDuserDto prpDuserDto=null;
    Collection collection = null;
    String  userCode   = usercode ;  //�û�����
    String  systemName = "" ;        //ϵͳ��
    String  loginSystem = "" ;       //��¼ϵͳ����
    boolean permitSystem = false ;   //�Ƿ������¼ϵͳ
    try
    {
      String conditions = "usercode='"+usercode+"' AND password='"+ password+"'";
      collection = new DBPrpDuser(dbManager).findByConditions(conditions,0,0);
      systemName = AppConfig.get("sysconst.SYSTEMNAME") ;
      if ((collection!=null)&&(collection.size()>=1))
      {
      	  prpDuserDto=(PrpDuserDto)collection.iterator().next();
          loginSystem  = prpDuserDto.getLoginSystem() ;
      }
      //У���Ƿ��е�¼ϵͳȨ��
      if(loginSystem!=null || loginSystem.equals(""))
      {
        permitSystem = permitLoginSys(userCode,systemName,loginSystem);
      }
      if(permitSystem==false)
      {
        throw new UserException(-98,-1000,"û�е�¼��ϵͳ��Ȩ��");
      }
    }
    catch(UserException use)
    {
      throw use;
    }
    catch(SQLException e)
    {
      throw e;
    }
    finally
    {
      //�ر����ݿ�����
      dbManager.close();
    }
    return prpDuserDto;
  }

  /**
   * �˶Բ���Ա�Ƿ��ܹ���½��Ӧϵͳ
   * @param  userCode   String Ա������
   * @param  systemName String ��½ϵͳ����("prp","account","reins","visa","underwrite")
   * @param  loginSystem String ��¼ϵͳ����
   * @throws Exception  �쳣
   * @return boolean    �Ƿ��ܹ���½��־���ܹ���½����true�����ܵ�½����false
   */
  public boolean permitLoginSys(String userCode,String systemName,String loginSystem) throws Exception
  {

    if (systemName.trim().equals("CLAIM"))  //����ҵ��ϵͳ
    {
      if (loginSystem.substring(0,1).equals("1"))
      {
        return true;
      }
      else
      {   return false;

      }
    }

    if (systemName.trim().equals("prp"))  //����ҵ��ϵͳ
    {
      if (loginSystem.substring(0,1).equals("1"))
      {
        return true;
      }
      else
      {   return false;

      }
    }

    if (systemName.trim().toLowerCase().equals("account"))  //����ϵͳ
    {
      if (loginSystem.substring(1,2).equals("1"))
      {
        return true;
      }
      else
      {   return false;

      }
    }

    if (systemName.trim().toLowerCase().equals("reins"))   //�ٱ���ϵͳ
    {
      if (loginSystem.toLowerCase().substring(2,3).equals("1"))
      {
        return true;
      }
      else
      {   return false;

      }
    }

    if (systemName.trim().equals("visa"))  //��֤����ϵͳ
    {
      if (loginSystem.toLowerCase().substring(3,4).equals("1"))
      {
        return true;
      }
      else
      {   return false;

      }
    }

    if (systemName.trim().toLowerCase().equals("underwrite"))  //�˱�����ϵͳ
    {
      if (loginSystem.substring(4,5).equals("1"))
      {
        return true;
      }
      else
      {
        return false;
      }
    }

    return false;

  }

}
