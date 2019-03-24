package com.sinosoft.claim.ui.control.facade;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpDuserFacade;
import com.sinosoft.claim.bl.facade.BLPrpljobmanagerFacade;
import com.sinosoft.claim.bl.facade.BLPrpljobmanagertimeFacade;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.domain.PrpljobmanagerDto;
import com.sinosoft.claim.dto.domain.PrpljobmanagertimeDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;

public class UIScheduleJobManagerQueryFacade extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String forward = "success";
		//��ȡҳ�����
		String handledept = request.getParameter("handledept");//��������
		String deptname = request.getParameter("deptname");//��������
		String jobdateBegin = request.getParameter("jobdateBegin");//��ʼ����
		String jobdateEnd = request.getParameter("jobdateEnd");//��������
		
		String classCode = request.getParameter("classCode");//��������
		try {
			//ƴ��ѯ����conditions  start
			String conditions = " 1 = 1 ";
			if(handledept!=null&&handledept.length()>0){
				conditions = conditions+" and fid in (select id from prpljobmanager where 1 = 1 and classcode = '"+classCode+"' and handledept = '"+handledept+"') ";
			}
			if(jobdateBegin!=null&&jobdateBegin.length()>0){
				conditions = conditions+" and  to_date(time,'YYYY-mm-dd') >= to_date('"+jobdateBegin+"' ,'YYYY-mm-dd') ";
			}
			if(jobdateEnd!=null&&jobdateEnd.length()>0){
				conditions = conditions+" and  to_date(time,'YYYY-mm-dd') <= to_date('"+jobdateEnd+"' ,'YYYY-mm-dd') ";
			}
			conditions = conditions+ "   order by to_date(time,'YYYY-mm-dd'), datetype ";
			String condition = request.getParameter("condition");
			if(condition!=null){
				conditions = condition;
			}
			//ƴ��ѯ����conditions  end
			//��ҳ��ѯ   start
			String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
			String pageNo = request.getParameter("pageNo");
			if(pageNo == null || "".equals(pageNo)){
				pageNo = "1";
			}
			int intpageNo = Integer.parseInt(pageNo);
			int intrecordPerPage = Integer.parseInt(recordPerPage);
			ArrayList<PrpljobmanagerDto> prpljobmanagerDtoList = new ArrayList<PrpljobmanagerDto>();
			ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoList = new ArrayList<PrpljobmanagertimeDto>();
			BLPrpljobmanagertimeFacade prpljobmanagertimeFacade = new BLPrpljobmanagertimeFacade();
			PageRecord pageRecord =  prpljobmanagertimeFacade.findByConditions(conditions, intpageNo, intrecordPerPage);
			prpljobmanagertimeDtoList = (ArrayList<PrpljobmanagertimeDto>) pageRecord.getResult();
			TurnPageDto turnPageDto = new TurnPageDto();
			// ��ѯ������һҳ�Ľṹ��
			turnPageDto.setResultList(prpljobmanagertimeDtoList);
			// ��ǰҳ��
			turnPageDto.setPageNo(pageRecord.getPageNo());
			// һҳ������
			turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
			// ��ѯ�����Ľ��������
			turnPageDto.setTotalCount(pageRecord.getCount());
			// �����ܵ�ҳ��
			turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
			// ��������
			turnPageDto.setCondition(conditions);
			
			PrpljobmanagertimeDto prpljobmanagertimeDto = new PrpljobmanagertimeDto();
			prpljobmanagertimeDto.setTurnPageDto(turnPageDto);
			request.setAttribute("prpljobmanagertimeDto", prpljobmanagertimeDto);
			//��ҳ��ѯ  end
			//����ѯ�����װ��ҳ����ʾ����
			BLPrpljobmanagerFacade prpljobmanagerFacade = new BLPrpljobmanagerFacade();
			BLPrpDuserFacade prpDuserFacade = new BLPrpDuserFacade();
			DateFormat format = new SimpleDateFormat("yyyy��MM��dd��");
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(prpljobmanagertimeDtoList!=null&&prpljobmanagertimeDtoList.size()>0){
				for (PrpljobmanagertimeDto prpljobmanagertimeDto1 : prpljobmanagertimeDtoList) {
					PrpljobmanagerDto prpljobmanagerDto = prpljobmanagerFacade.findByPrimaryKey(prpljobmanagertimeDto1.getFid());
					if(prpljobmanagerDto!=null){
						prpljobmanagerDto.setTime(format.format(sdf.parse(prpljobmanagertimeDto1.getTime().trim())));
						prpljobmanagerDto.setDatetype(prpljobmanagertimeDto1.getDatetype());
						PrpDuserDto prpDuserDto = prpDuserFacade.findByPrimaryKey(prpljobmanagerDto.getHandlercode());
						if(prpDuserDto!=null){
							prpljobmanagerDto.setTel(prpDuserDto.getMobile());
						}
						
						prpljobmanagerDtoList.add(prpljobmanagerDto);
					}
				}
			}
			request.setAttribute("prpljobmanagerDtoList", prpljobmanagerDtoList);
		} catch (Exception e) {
			//e.printStackTrace();
			forward = "error";
		}
		return mapping.findForward(forward);
	}

}
