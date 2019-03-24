package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCodeFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CodeFindByCondCommand extends BaseCommand
{
	private String codetype;
	private String conditions;
	private int pageNo;
	private int rowsPerPage;

	public CodeFindByCondCommand(String codetype,String conditions,int pageNo,int rowsPerPage) throws Exception
	{
		this.codetype = codetype;
		this.conditions = conditions;
		this.pageNo = pageNo;
		this.rowsPerPage = rowsPerPage;
	}
	public Object executeCommand() throws Exception
	{
    BLCodeFacade bLCodeFacade = new BLCodeFacade();
    return bLCodeFacade.findByConditions(codetype,conditions,pageNo,rowsPerPage);
	}
}
