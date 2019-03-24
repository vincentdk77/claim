package com.sinosoft.claim.ui.control.action;

import java.util.Collection;

import com.sinosoft.claim.dto.custom.ReturnVisitDto;
import com.sinosoft.claim.ui.model.ReturnVisitSaveCommand;
import com.sinosoft.claim.ui.model.ReturnVistQueryComman;
import com.sinosoft.sysframework.common.datatype.PageRecord;

public class UIReturnVisitAction {
	/**
	 * �طò�ѯ
	 * @param conditions
	 * @param pageNo
	 * @param recordPerRecord
	 * @return
	 * @throws Exception
	 */
	public PageRecord findByQueryConditions(String conditions, int pageNo,int recordPerRecord) throws Exception {
		ReturnVistQueryComman returnVistQueryComman = new ReturnVistQueryComman(conditions, pageNo, recordPerRecord);
		return (PageRecord) returnVistQueryComman.executeCommand();
	}
	
	/**
	 * �طò�ѯ����
	 * @param conditions
	 * @param pageNo
	 * @param recordPerRecord
	 * @return
	 * @throws Exception
	 */
	public Collection findByQueryExpConditions(String conditions, int pageNo,int recordPerRecord) throws Exception {
		ReturnVistQueryComman returnVistQueryComman = new ReturnVistQueryComman(conditions, pageNo, recordPerRecord);
		return  returnVistQueryComman.executeExpCommand();
	}	
	
	/**
	 * Ͷ�߲�ѯ
	 * @param conditions
	 * @param pageNo
	 * @param recordPerRecord
	 * @return
	 * @throws Exception
	 */
	public PageRecord findByQuerycomplaintDto(String conditions, int pageNo,int recordPerRecord) throws Exception{
		ReturnVistQueryComman returnVistQueryComman = new ReturnVistQueryComman(conditions, pageNo, recordPerRecord);
		return (PageRecord) returnVistQueryComman.executeCommandComplaintDto();
	}
	
	/**
	 * �طñ���
	 * @param returnVisitDto
	 * @throws Exception
	 */
	public void save(ReturnVisitDto returnVisitDto) throws Exception{
		ReturnVisitSaveCommand returnVisitSaveCommand = new ReturnVisitSaveCommand(returnVisitDto);
		returnVisitSaveCommand.execute();
	}

	/**
	 * �᰸�طûطò�ѯ������֧����������
	 * @param conditions
	 * @param pageNo
	 * @param recordPerRecord
	 * @return
	 * @throws Exception
	 */
	public PageRecord findByQueryConditionsEndca(String conditions, int pageNo,int recordPerRecord) throws Exception {
		ReturnVistQueryComman returnVistQueryComman = new ReturnVistQueryComman(conditions, pageNo, recordPerRecord);
		return (PageRecord) returnVistQueryComman.executeCommandEndca();
	}
	
	/**
	 * �᰸�طûطò�ѯ����
	 * @param conditions
	 * @param pageNo
	 * @param recordPerRecord
	 * @return
	 * @throws Exception
	 */
	public Collection findByQueryExpConditionsEndca(String conditions, int pageNo,int recordPerRecord) throws Exception {
		ReturnVistQueryComman returnVistQueryComman = new ReturnVistQueryComman(conditions, pageNo, recordPerRecord);
		return  returnVistQueryComman.executeExpCommandEndca();
	}
}
