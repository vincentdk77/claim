
package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCodeFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


public class CustomerCNameTranslateCustomerCodeCommand extends BaseCommand  {

	  private String customerCode = "";

	  public CustomerCNameTranslateCustomerCodeCommand(String customerCode)  throws Exception
	  {
	      this.customerCode = customerCode;     
	  }
	  public Object executeCommand() throws Exception
	  {
	      String customerCName = "";
	      BLCodeFacade blCodeFacade = new BLCodeFacade();
	      customerCName = blCodeFacade.translateCustomerCName(customerCode) ;
	      
	      return customerCName;
	  }
	
}
