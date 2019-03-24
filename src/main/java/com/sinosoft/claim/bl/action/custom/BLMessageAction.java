package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.domain.PrpLmessageDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBMessage;
import com.sinosoft.sysframework.reference.DBManager;



/**
 * ������ת��������BL��
 * <p>Title:������ת��������BL��Action�� </p>
 * <p>Description:������ת��������BL��Action�� </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft</p>
 * @author Sunhao
 * @version 1.0
 */
public class BLMessageAction {
  public BLMessageAction() {
    /**
     * Ĭ�Ϲ��캯��
     */
    }

   /**
   * ��������
   * @param prplmessageDto���Զ������Զ���
   * @param dbManager  ��������
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
	* ȡ���
	* @param registNo
	* @param dbManager  ��������
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
