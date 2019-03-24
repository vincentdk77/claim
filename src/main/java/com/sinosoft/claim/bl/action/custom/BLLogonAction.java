package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDuser;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * 登录逻辑
 * <p>Title: 车险理赔样本程序</p>
 * <p>Description: 车险理赔样本程序登录action</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author 车险理赔项目组
 * @version 1.0
 */

public class BLLogonAction
{
  public BLLogonAction(){}

  /**
   * 检查用户信息
   * @param usercode：用户代码
   * @param password：用户密码（明文）
   * @return 有效/无效
   * @throws SQLException
   * @throws Exception
   */
  public PrpDuserDto checkUser(DBManager dbManager,String usercode,String password)
    throws SQLException,Exception
  {

    PrpDuserDto prpDuserDto=null;
    Collection collection = null;
    String  userCode   = usercode ;  //用户代码
    String  systemName = "" ;        //系统名
    String  loginSystem = "" ;       //登录系统名称
    boolean permitSystem = false ;   //是否允许登录系统
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
      //校验是否有登录系统权限
      if(loginSystem!=null || loginSystem.equals(""))
      {
        permitSystem = permitLoginSys(userCode,systemName,loginSystem);
      }
      if(permitSystem==false)
      {
        throw new UserException(-98,-1000,"没有登录此系统的权限");
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
      //关闭数据库连接
      dbManager.close();
    }
    return prpDuserDto;
  }

  /**
   * 核对操作员是否能够登陆相应系统
   * @param  userCode   String 员工代码
   * @param  systemName String 登陆系统名称("prp","account","reins","visa","underwrite")
   * @param  loginSystem String 登录系统参数
   * @throws Exception  异常
   * @return boolean    是否能够登陆标志，能够登陆返回true，不能登陆返回false
   */
  public boolean permitLoginSys(String userCode,String systemName,String loginSystem) throws Exception
  {

    if (systemName.trim().equals("CLAIM"))  //理赔业务系统
    {
      if (loginSystem.substring(0,1).equals("1"))
      {
        return true;
      }
      else
      {   return false;

      }
    }

    if (systemName.trim().equals("prp"))  //核心业务系统
    {
      if (loginSystem.substring(0,1).equals("1"))
      {
        return true;
      }
      else
      {   return false;

      }
    }

    if (systemName.trim().toLowerCase().equals("account"))  //财务系统
    {
      if (loginSystem.substring(1,2).equals("1"))
      {
        return true;
      }
      else
      {   return false;

      }
    }

    if (systemName.trim().toLowerCase().equals("reins"))   //再保险系统
    {
      if (loginSystem.toLowerCase().substring(2,3).equals("1"))
      {
        return true;
      }
      else
      {   return false;

      }
    }

    if (systemName.trim().equals("visa"))  //单证管理系统
    {
      if (loginSystem.toLowerCase().substring(3,4).equals("1"))
      {
        return true;
      }
      else
      {   return false;

      }
    }

    if (systemName.trim().toLowerCase().equals("underwrite"))  //核保核赔系统
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
