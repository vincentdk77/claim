package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.domain.PrpLmessageDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBMessage;
import com.sinosoft.sysframework.reference.DBManager;



/**
 * 理赔流转讨论留言BL层
 * <p>Title:理赔流转讨论留言BL层Action类 </p>
 * <p>Description:理赔流转讨论留言BL层Action类 </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft</p>
 * @author Sunhao
 * @version 1.0
 */
public class BLMessageAction {
  public BLMessageAction() {
    /**
     * 默认构造函数
     */
    }

   /**
   * 保存留言
   * @param prplmessageDto：自定义留言对象
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
   public void save(DBManager dbManager,PrpLmessageDto prpLmessageDto)
    throws SQLException,Exception
   {
      DBMessage dbMessage = null;

      dbMessage = new DBMessage();

      dbMessage.insert(dbManager,prpLmessageDto);

   }
	 
	/**
	* 取序号
	* @param registNo
	* @param dbManager  数据连接
	* @return messageID
	* @throws SQLException
	* @throws Exception
	*/
	public int getNo(DBManager dbManager,String registNo)throws SQLException,Exception
	{
	  DBMessage dbMessage= new DBMessage();
	  int messageID=-1;
	  messageID= dbMessage.getNo(dbManager,registNo) ;
	  return messageID;
	}


}
