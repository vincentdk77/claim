package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.domain.PrpLmessageDto;
import com.sinosoft.claim.ui.model.MessageGetNoCommand;
import com.sinosoft.claim.ui.model.MessageSaveCommand;
import com.sinosoft.claim.ui.model.PrpLmessageFindByConditionsCommand;

/**
 * ���Զ���Message
 * <p>Title: ������ת��������Action</p>
 * <p>Description: ������ת��������Action��</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft</p>
 * @author Sunhao
 * @version 1.0
 */
public class UIMessageAction {
  public UIMessageAction() {
  }
    /**
     * ��������
     * @param PrpLmessageDto����������DTO
     * @throws Exception
     */
    public void save(PrpLmessageDto prpLmessageDto) throws SQLException,Exception
    {
        MessageSaveCommand messageSaveCommand = new MessageSaveCommand(prpLmessageDto);
        messageSaveCommand.execute();

    }


    /**
     * ���Բ�ѯ������Ϣ
     * @param conditions String
     * @throws SQLException
     * @throws Exception
     * @return Collection
     */

    public Collection findByConditions(String conditions) throws SQLException,Exception
     {
        PrpLmessageFindByConditionsCommand prpLmessageFindByConCommand = new PrpLmessageFindByConditionsCommand(conditions);

        return (Collection)prpLmessageFindByConCommand.executeCommand();
     }
    /**
     * ���Բ�ѯ������Ϣ(�������Ľӿ�ʹ�ã�������������Ϊ(yyyy-mm-dd hh24:mi:ss))
     * @param conditions String
     * @throws SQLException
     * @throws Exception
     * @return Collection
     */

    public Collection findByConditions1(String conditions) throws SQLException,Exception
     {
        PrpLmessageFindByConditionsCommand prpLmessageFindByConCommand = new PrpLmessageFindByConditionsCommand(conditions);

        return (Collection)prpLmessageFindByConCommand.executeCommand1();
     }
    

     /**
     * ȡ���������
     * @param registNo String
     * @throws SQLException
     * @throws Exception
     * @return int
     */
    public int getNo(String registNo) throws SQLException,Exception
    {
        MessageGetNoCommand messageGetNoCommand = new MessageGetNoCommand(registNo);
        return ((Integer)messageGetNoCommand.executeCommand()).intValue() ;

    }



}
