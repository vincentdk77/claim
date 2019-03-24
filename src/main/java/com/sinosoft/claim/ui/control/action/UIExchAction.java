
package com.sinosoft.claim.ui.control.action;

import java.util.Collection;

import com.sinosoft.claim.ui.model.PubRateGetExchOfMaxDateCommand;

/**
 * 取得兑换率信息
 * <p>Title: 车险理赔</p>
 * <p>Description: 车险理赔样本程序</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author 项目组
 * @version 1.0
 */  
 
public class UIExchAction {
  public UIExchAction() {

  }
  /** 
   *
   * @param currDate String 当前日期
   * @throws Exception
   * @return Collection     所有最新日期的兑换率信息
   */
  public Collection getExchOfMaxDate(String currDate) throws Exception
  {
    PubRateGetExchOfMaxDateCommand pubRateGetExchOfMaxDateCommand = new PubRateGetExchOfMaxDateCommand(currDate);
    return (Collection)pubRateGetExchOfMaxDateCommand.executeCommand() ;
  }
  
 
  
  
}
