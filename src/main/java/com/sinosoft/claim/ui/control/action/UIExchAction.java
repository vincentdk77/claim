
package com.sinosoft.claim.ui.control.action;

import java.util.Collection;

import com.sinosoft.claim.ui.model.PubRateGetExchOfMaxDateCommand;

/**
 * ȡ�öһ�����Ϣ
 * <p>Title: ��������</p>
 * <p>Description: ����������������</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author ��Ŀ��
 * @version 1.0
 */  
 
public class UIExchAction {
  public UIExchAction() {

  }
  /** 
   *
   * @param currDate String ��ǰ����
   * @throws Exception
   * @return Collection     �����������ڵĶһ�����Ϣ
   */
  public Collection getExchOfMaxDate(String currDate) throws Exception
  {
    PubRateGetExchOfMaxDateCommand pubRateGetExchOfMaxDateCommand = new PubRateGetExchOfMaxDateCommand(currDate);
    return (Collection)pubRateGetExchOfMaxDateCommand.executeCommand() ;
  }
  
 
  
  
}
