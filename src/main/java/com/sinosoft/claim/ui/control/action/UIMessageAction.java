package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.domain.PrpLmessageDto;
import com.sinosoft.claim.ui.model.MessageGetNoCommand;
import com.sinosoft.claim.ui.model.MessageSaveCommand;
import com.sinosoft.claim.ui.model.PrpLmessageFindByConditionsCommand;

/**
 * 留言对象Message
 * <p>Title: 理赔流转讨论留言Action</p>
 * <p>Description: 理赔流转讨论留言Action类</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft</p>
 * @author Sunhao
 * @version 1.0
 */
public class UIMessageAction {
  public UIMessageAction() {
  }
    /**
     * 保存留言
     * @param PrpLmessageDto：报案对象DTO
     * @throws Exception
     */
    public void save(PrpLmessageDto prpLmessageDto) throws SQLException,Exception
    {
        MessageSaveCommand messageSaveCommand = new MessageSaveCommand(prpLmessageDto);
        messageSaveCommand.execute();

    }


    /**
     * 留言查询条件信息
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
     * 留言查询条件信息(呼叫中心接口使用，输入日期类型为(yyyy-mm-dd hh24:mi:ss))
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
     * 取得留言序号
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
