package com.sinosoft.claim.ui.model;

import java.util.Collection;

import com.sinosoft.claim.bl.facade.BLReturnVisitFacade;


public class ReturnVistQueryComman {
	private String conditions;

	private int pageNo;

	private int recordPerPage;
	
	public ReturnVistQueryComman(String conditions, int pageNo, int recordPerPage) {
		this.conditions = conditions;
		this.pageNo = pageNo;
		this.recordPerPage = recordPerPage;
	}
	
	public Object executeCommand() throws Exception{
		if( pageNo != 0 && recordPerPage != 0)
		  {
			  return new BLReturnVisitFacade().findByQueryConditions(conditions,pageNo,recordPerPage);
		  }
		  //add by zhaolu 20060802 end
		BLReturnVisitFacade blReturnVisitFacade = new BLReturnVisitFacade();
	      return blReturnVisitFacade.findByQueryConditions(conditions);
	}
	//����ִ��
	public Collection executeExpCommand() throws Exception{
		BLReturnVisitFacade blReturnVisitFacade = new BLReturnVisitFacade();
	      return blReturnVisitFacade.findByQueryExpConditions(conditions);
	}

	/**
	 * �᰸�طûطò�ѯ������֧����������
	 * @return
	 * @throws Exception
	 */
	public Object executeCommandEndca() throws Exception{
		if( pageNo != 0 && recordPerPage != 0)
		  {
			  return new BLReturnVisitFacade().findByQueryConditionsEndca(conditions,pageNo,recordPerPage);
		  }
		  //add by zhaolu 20060802 end
		BLReturnVisitFacade blReturnVisitFacade = new BLReturnVisitFacade();
	      return blReturnVisitFacade.findByQueryConditionsEndca(conditions);
	}	
	
	//����ִ��
	public Collection executeExpCommandEndca() throws Exception{
		BLReturnVisitFacade blReturnVisitFacade = new BLReturnVisitFacade();
	      return blReturnVisitFacade.findByQueryExpConditionsEndca(conditions);
	}
	
	
	public Object executeCommandComplaintDto() throws Exception{
		if( pageNo != 0 && recordPerPage != 0)
		  {
			  return new BLReturnVisitFacade().findByQueryComplaint(conditions,pageNo,recordPerPage);
		  }
		  //add by zhaolu 20060802 end
		BLReturnVisitFacade blReturnVisitFacade = new BLReturnVisitFacade();
	      return blReturnVisitFacade.findByQueryComplaint(conditions);
	}

}
