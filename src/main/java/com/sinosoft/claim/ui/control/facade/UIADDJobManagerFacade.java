package com.sinosoft.claim.ui.control.facade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpLJobLinkerFacade;
import com.sinosoft.claim.bl.facade.BLPrpljobmanagerFacade;
import com.sinosoft.claim.bl.facade.BLPrpljobmanagertimeFacade;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.domain.PrpLJobLinkerDto;
import com.sinosoft.claim.dto.domain.PrpljobmanagerDto;
import com.sinosoft.claim.dto.domain.PrpljobmanagertimeDto;
import com.sinosoft.claim.ui.control.viewHelper.JobManagerViewHelper;

public class UIADDJobManagerFacade extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
		
		String editType = request.getParameter("editType");
		String month = request.getParameter("month");				//�·�
		String handledept = request.getParameter("handledept");		//����code
		String deptname = request.getParameter("deptname");			//��������
		String handlercode = request.getParameter("handlercode");
		String classCode   = request.getParameter("classCode");    //����
		String systemCode  = request.getParameter("systemCode");
		String forward= "success";
		if("choiceComCode".equals(editType)){
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			Calendar cday=Calendar.getInstance();
			cday.setTime(date);
			ArrayList dateTimeList = new ArrayList();
			for(int i=1;i<=6;i++){
				dateTimeList.add(sdf.format(cday.getTime()));
				cday.add(Calendar.MONTH, 1);
			}
			request.setAttribute("dateTimeList", dateTimeList);
			//����
			/*JobManagerViewHelper viewHelper = new JobManagerViewHelper();
			viewHelper.findClassCode(request);*/
			
		}
		if("choicePage".equals(editType)){
			request.setAttribute("month", month);
			request.setAttribute("handledept", handledept);
			request.setAttribute("deptname", deptname);
			request.setAttribute("classCode", classCode);
			request.setAttribute("systemCode", systemCode);
			
			BLPrpljobmanagerFacade blPrpljobmanagerFacade = new BLPrpljobmanagerFacade();
			String conditions = " systemcode='"+ systemCode +"' "+" and classcode = '"+ classCode +"' and month='"+month+"' and handledept='"+handledept+"'" ;
			ArrayList<PrpljobmanagerDto> prpljobmanagerDtoList = (ArrayList<PrpljobmanagerDto>) blPrpljobmanagerFacade.findByConditions(conditions);
			if(prpljobmanagerDtoList.size()>0){
				
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
				Calendar cday=Calendar.getInstance();
				cday.setTime(date);
				ArrayList dateTimeList = new ArrayList();
				for(int i=1;i<=6;i++){
					dateTimeList.add(sdf.format(cday.getTime()));
					cday.add(Calendar.MONTH, 1);
				}
				request.setAttribute("dateTimeList", dateTimeList);
				request.setAttribute("status", "no");
				//����
				/*JobManagerViewHelper viewHelper = new JobManagerViewHelper();
				viewHelper.findClassCode(request);*/
				//��ʾ
				String tempMonth = month.replace("-", "��")+"��";
				request.setAttribute("notice", "������ "+deptname+" "+classCode+"���� "+tempMonth+" ����������������");
				forward = "agency";
			}else{
				//��ϵ��ֻ��������ϵͳ�д��ڣ���ϵͳ��û��ĳ����ĳ�°��ʱ��ɾ���û����µ���ϵ����Ϣ
				if("claim".equals(systemCode)){
					conditions = " classcode = '"+ classCode +"' and month='"+month+"' and handledept='"+handledept+"'" ;
					BLPrpLJobLinkerFacade blPrpLJobLinkerFacade = new BLPrpLJobLinkerFacade();
					blPrpLJobLinkerFacade.deleteByConditions(conditions);
				}
				forward = "choicePage";
			}
		}
		if("ADD".equals(editType)){//��Ӱ��ҳ�� ��ʼ��
			String inputButtonType = request.getParameter("inputButton");	//�Ƿ������°�� yes�� No ����
			if("yes".equals(inputButtonType)){//�������°��
				
				//��ȡ�ϸ�����·� begin
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
				Calendar cday=Calendar.getInstance();
				cday.setTime(sdf.parse(month));
				cday.set(cday.MONTH, cday.get(cday.MONTH)-1);
				String oldMonth = sdf.format(cday.getTime());
				BLPrpljobmanagerFacade blPrpljobmanagerFacade = new BLPrpljobmanagerFacade();
				String conditions = "systemcode = '"+ systemCode+"'"+" and classcode='"+ classCode +"' and handledept='"+handledept+"' And  month='"+oldMonth+"'";
				ArrayList<PrpljobmanagerDto> prpljobmanagerDtoList = new ArrayList<PrpljobmanagerDto>();
				//��ȡ�ϸ�����·� end
				ArrayList<PrpljobmanagerDto> prpljobmanagerDtoListOld = (ArrayList<PrpljobmanagerDto>) blPrpljobmanagerFacade.findByConditions(conditions);
				
				if(prpljobmanagerDtoListOld.size() == 0){
					request.setAttribute("status", "no");
					request.setAttribute("month", month);
					request.setAttribute("handledept", handledept);
					request.setAttribute("deptname", deptname);
					request.setAttribute("classCode", classCode);
					request.setAttribute("systemCode", systemCode);
					forward = "choicePage";
					return mapping.findForward(forward);
				}
				
				//��ǰ������ �鿱��Ա
				//ArrayList<PrpDuserDto> prpDuserDtoList = (ArrayList<PrpDuserDto>) request.getAttribute("prpDuserDtoList");
				JobManagerViewHelper daaJobManagerViewHelper = new JobManagerViewHelper();
				ArrayList<PrpDuserDto> prpDuserDtoList = daaJobManagerViewHelper.findUser(request, handledept);
				
				//��ǰ��չʾ��������
				ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoList = new ArrayList<PrpljobmanagertimeDto>();
				//��ǰ��չʾ��������
				prpljobmanagertimeDtoList = daaJobManagerViewHelper.findMonthDay(request, month);
				ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoListNewAm = null;
				ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoListNewPm = null;
				
				//��ǰ�����鿱Ա��
				for(PrpDuserDto prpDuserDto : prpDuserDtoList){
					for(PrpljobmanagerDto prpljobmanagerDto : prpljobmanagerDtoListOld){
						if(prpDuserDto.getGradecode().indexOf(prpljobmanagerDto.getJobrole()) >= 0 || prpljobmanagerDto.getJobrole().indexOf(prpDuserDto.getGradecode()) >= 0){//�������°��ʱ �ж��Ƿ��뱾�˽�ɫ ��ƥ�䣬ƥ��ĸ��ơ�
							if(prpljobmanagerDto.getHandlercode().equals(prpDuserDto.getUserCode())){
								prpljobmanagertimeDtoListNewAm = daaJobManagerViewHelper.findMonthDay(request, month);
								prpljobmanagertimeDtoListNewPm = daaJobManagerViewHelper.findMonthDay(request, month);
								ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoListOldAm = (ArrayList<PrpljobmanagertimeDto>) new BLPrpljobmanagertimeFacade().findByConditions(" fid='"+prpljobmanagerDto.getId()+"' and datetype='AM'");
								for(PrpljobmanagertimeDto prpljobmanagertimeDtoNew : prpljobmanagertimeDtoListNewAm){
									prpljobmanagertimeDtoNew.setDatetype("AM");
									prpljobmanagertimeDtoNew.setFid(prpljobmanagerDto.getId());
									for(PrpljobmanagertimeDto prpljobmanagertimeDtoOld :prpljobmanagertimeDtoListOldAm){
										if("AM".equals(prpljobmanagertimeDtoOld.getDatetype())){
											if(prpljobmanagertimeDtoNew.getTime().substring(8).equals(prpljobmanagertimeDtoOld.getTime().substring(8))){
												prpljobmanagertimeDtoNew.setFid(prpljobmanagertimeDtoOld.getFid());
												prpljobmanagertimeDtoNew.setDatetype(prpljobmanagertimeDtoOld.getDatetype());
												prpljobmanagertimeDtoNew.setStates("1");
											}else{
												prpljobmanagertimeDtoNew.setFid(prpljobmanagertimeDtoOld.getFid());
												prpljobmanagertimeDtoNew.setDatetype("AM");
											}
										}else{
											prpljobmanagertimeDtoNew.setFid(prpljobmanagertimeDtoOld.getFid());
											prpljobmanagertimeDtoNew.setDatetype("AM");
										}
									}
								}
								prpljobmanagerDto.setPrpljobmanagertimeDtoListAm(prpljobmanagertimeDtoListNewAm);
								
								
								ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoListOldPm = (ArrayList<PrpljobmanagertimeDto>) new BLPrpljobmanagertimeFacade().findByConditions(" fid='"+prpljobmanagerDto.getId()+"' and datetype='PM'");
								for(PrpljobmanagertimeDto prpljobmanagertimeDtoNew : prpljobmanagertimeDtoListNewPm){
									prpljobmanagertimeDtoNew.setDatetype("PM");
									prpljobmanagertimeDtoNew.setFid(prpljobmanagerDto.getId());
									for(PrpljobmanagertimeDto prpljobmanagertimeDtoOld :prpljobmanagertimeDtoListOldPm){
										if("PM".equals(prpljobmanagertimeDtoOld.getDatetype())){
											if(prpljobmanagertimeDtoNew.getTime().substring(8).equals(prpljobmanagertimeDtoOld.getTime().substring(8))){
												prpljobmanagertimeDtoNew.setFid(prpljobmanagertimeDtoOld.getFid());
												prpljobmanagertimeDtoNew.setDatetype(prpljobmanagertimeDtoOld.getDatetype());
												prpljobmanagertimeDtoNew.setStates("1");
											}else{
												prpljobmanagertimeDtoNew.setFid(prpljobmanagertimeDtoOld.getFid());
												prpljobmanagertimeDtoNew.setDatetype("PM");
											}
										}else{
											prpljobmanagertimeDtoNew.setFid(prpljobmanagertimeDtoOld.getFid());
											prpljobmanagertimeDtoNew.setDatetype("PM");
										}
									}
								}
								prpljobmanagerDto.setPrpljobmanagertimeDtoListPm(prpljobmanagertimeDtoListNewPm);
								String jobrole = prpDuserDto.getGradecode();
								prpljobmanagerDto.setJobrole(jobrole);
								prpljobmanagerDtoList.add(prpljobmanagerDto);
							}
						}
						}
				}
				//�ж�ҳ����ʾ ����ɫ �Ƿ������޸�
				for(PrpljobmanagerDto prpljobmanagerDto : prpljobmanagerDtoList){
					for(PrpDuserDto prpDuserDto : prpDuserDtoList){
						if(prpljobmanagerDto.getHandlercode().equals(prpDuserDto.getUserCode())){
							if(prpDuserDto.getGradecode().indexOf(prpljobmanagerDto.getJobrole()) >= 0 || prpljobmanagerDto.getJobrole().indexOf(prpDuserDto.getGradecode()) >= 0){
								prpljobmanagerDto.setState("yes");
								break;
							}else{
								prpljobmanagerDto.setState("no");
							}
						}else{
							prpljobmanagerDto.setState("no");
						}
					}
				}
				
				request.setAttribute("month", month);
				request.setAttribute("handledept", handledept);
				request.setAttribute("classCode", classCode);
				request.setAttribute("systemCode", systemCode);
				request.setAttribute("prpljobmanagertimeDtoList", prpljobmanagertimeDtoList);
				request.setAttribute("prpljobmanagerDtoList", prpljobmanagerDtoList);
				//������ϵͳ �����ʱ �����ϵ����Ϣ
				if("claim".equals(systemCode)){
					conditions = " classcode='"+ classCode +"' and handledept='"+handledept+"' And  month='"+oldMonth+"'";
					BLPrpLJobLinkerFacade blPrpLJobLinkerFacade = new BLPrpLJobLinkerFacade();
					ArrayList<PrpLJobLinkerDto> prpLJobLinkerDtoList = (ArrayList<PrpLJobLinkerDto>)blPrpLJobLinkerFacade.findByConditions(conditions);
					request.setAttribute("prpLJobLinkerDtoList", prpLJobLinkerDtoList);
				}
				
			}else{//���������°��
				//��ǰ������ �鿱��Աclaim.check
				JobManagerViewHelper daaJobManagerViewHelper = new JobManagerViewHelper();
				daaJobManagerViewHelper.findUser(request, handledept);
				//��ǰ��չʾ��������
				ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoList = daaJobManagerViewHelper.findMonthDay(request, month);
				
				request.setAttribute("systemCode", systemCode);
				request.setAttribute("classCode", classCode);
				request.setAttribute("month", month);
				request.setAttribute("handledept", handledept);
				request.setAttribute("prpljobmanagertimeDtoList", prpljobmanagertimeDtoList);
			}
			request.setAttribute("editType", editType);
			request.setAttribute("inputButtonType", inputButtonType);
			forward = "DAAPage";
		}
		
		if("EDIT".equals(editType) || "SHOW".equals(editType)){
			String updateType = request.getParameter("updateType");
			String jobId = request.getParameter("id");
			BLPrpljobmanagerFacade blPrpljobmanagerFacade = new BLPrpljobmanagerFacade();
			String conditions = "";
			if(handlercode != null && !"".equals(handlercode)){
				conditions = " systemcode = '"+ systemCode +"'" + " and classcode = '"+ classCode +"' and handledept='"+handledept+"' and month='"+month+"' and handlercode='"+handlercode+"'";
			}else{
				conditions = " systemcode = '"+ systemCode +"'"+" and classcode = '"+ classCode +"' and handledept='"+handledept+"' and month='"+month+"'";
			}
			PrpljobmanagerDto prpljobmanagerDtoSql = new PrpljobmanagerDto();
			prpljobmanagerDtoSql.setHandledept(handledept);
			prpljobmanagerDtoSql.setMonth(month);
			prpljobmanagerDtoSql.setHandlercode(handlercode);
			prpljobmanagerDtoSql.setClasscode(classCode);
			prpljobmanagerDtoSql.setSystemCode(systemCode);
			
			ArrayList<PrpljobmanagerDto> prpljobmanagerDtoList = new ArrayList<PrpljobmanagerDto>();
			ArrayList<PrpljobmanagerDto> prpljobmanagerDtoListOld = (ArrayList<PrpljobmanagerDto>) blPrpljobmanagerFacade.findByConditions(conditions);
			
			
			//��ǰ������ �鿱��Ա���������ˣ�
			//��ǰ�����鿱Ա��
			//ArrayList<PrpDuserDto> prpDuserDtoList = (ArrayList<PrpDuserDto>) request.getAttribute("prpDuserDtoList");
			JobManagerViewHelper daaJobManagerViewHelper = new JobManagerViewHelper();
			ArrayList<PrpDuserDto> prpDuserDtoList = daaJobManagerViewHelper.findUser(request, handledept);
			
			//��ǰ��չʾ��������
			ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoList = new ArrayList<PrpljobmanagertimeDto>();
			//��ǰ��չʾ��������
			month = prpljobmanagerDtoListOld.get(0).getMonth();
			prpljobmanagertimeDtoList = daaJobManagerViewHelper.findMonthDay(request, month);
			
			ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoListNewAm = null;
			ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoListNewPm = null;
			
			
			for(PrpljobmanagerDto prpljobmanagerDto : prpljobmanagerDtoListOld){
				prpljobmanagertimeDtoListNewAm = daaJobManagerViewHelper.findMonthDay(request, month);
				prpljobmanagertimeDtoListNewPm = daaJobManagerViewHelper.findMonthDay(request, month);
				ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoListOldAm = (ArrayList<PrpljobmanagertimeDto>) new BLPrpljobmanagertimeFacade().findByConditions(" fid='"+prpljobmanagerDto.getId()+"' and datetype='AM'");
				for(PrpljobmanagertimeDto prpljobmanagertimeDtoNew : prpljobmanagertimeDtoListNewAm){
					prpljobmanagertimeDtoNew.setDatetype("AM");
					prpljobmanagertimeDtoNew.setFid(prpljobmanagerDto.getId());
					for(PrpljobmanagertimeDto prpljobmanagertimeDtoOld :prpljobmanagertimeDtoListOldAm){
						if("AM".equals(prpljobmanagertimeDtoOld.getDatetype())){
							if(prpljobmanagertimeDtoNew.getTime().substring(8).equals(prpljobmanagertimeDtoOld.getTime().substring(8))){
								prpljobmanagertimeDtoNew.setFid(prpljobmanagertimeDtoOld.getFid());
								prpljobmanagertimeDtoNew.setDatetype(prpljobmanagertimeDtoOld.getDatetype());
								prpljobmanagertimeDtoNew.setStates("1");
							}else{
								prpljobmanagertimeDtoNew.setFid(prpljobmanagertimeDtoOld.getFid());
								prpljobmanagertimeDtoNew.setDatetype("AM");
							}
						}else{
							prpljobmanagertimeDtoNew.setFid(prpljobmanagertimeDtoOld.getFid());
							prpljobmanagertimeDtoNew.setDatetype("AM");
						}
					}
				}
				prpljobmanagerDto.setPrpljobmanagertimeDtoListAm(prpljobmanagertimeDtoListNewAm);
				
				
				ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoListOldPm = (ArrayList<PrpljobmanagertimeDto>) new BLPrpljobmanagertimeFacade().findByConditions(" fid='"+prpljobmanagerDto.getId()+"' and datetype='PM'");
				for(PrpljobmanagertimeDto prpljobmanagertimeDtoNew : prpljobmanagertimeDtoListNewPm){
					prpljobmanagertimeDtoNew.setDatetype("PM");
					prpljobmanagertimeDtoNew.setFid(prpljobmanagerDto.getId());
					for(PrpljobmanagertimeDto prpljobmanagertimeDtoOld :prpljobmanagertimeDtoListOldPm){
						if("PM".equals(prpljobmanagertimeDtoOld.getDatetype())){
							if(prpljobmanagertimeDtoNew.getTime().substring(8).equals(prpljobmanagertimeDtoOld.getTime().substring(8))){
								prpljobmanagertimeDtoNew.setFid(prpljobmanagertimeDtoOld.getFid());
								prpljobmanagertimeDtoNew.setDatetype(prpljobmanagertimeDtoOld.getDatetype());
								prpljobmanagertimeDtoNew.setStates("1");
							}else{
								prpljobmanagertimeDtoNew.setFid(prpljobmanagertimeDtoOld.getFid());
								prpljobmanagertimeDtoNew.setDatetype("PM");
							}
						}else{
							prpljobmanagertimeDtoNew.setFid(prpljobmanagertimeDtoOld.getFid());
							prpljobmanagertimeDtoNew.setDatetype("PM");
						}
					}
				}
				//�ж�ҳ����ʾ ����ɫ �Ƿ������޸� yes���� no ������
				for(PrpDuserDto prpDuserDto : prpDuserDtoList){
					if(prpljobmanagerDto.getHandlercode().equals(prpDuserDto.getUserCode())){
						System.err.println("gradecode==>"+prpDuserDto.getGradecode()+"   jobrole==>"+prpljobmanagerDto.getJobrole());
						if(prpDuserDto.getGradecode().indexOf(prpljobmanagerDto.getJobrole()) >= 0 || prpljobmanagerDto.getJobrole().indexOf(prpDuserDto.getGradecode()) >= 0){
							prpljobmanagerDto.setState("yes");
							break;
						}else{
							prpljobmanagerDto.setState("no");
						}
					}else{
						prpljobmanagerDto.setState("no");
					}
				}
				prpljobmanagerDto.setPrpljobmanagertimeDtoListPm(prpljobmanagertimeDtoListNewPm);
				prpljobmanagerDtoList.add(prpljobmanagerDto);
			}
			//������ϵ����Ϣ
			if("claim".equals(systemCode)){
				conditions = " classcode = '"+ classCode +"' and handledept='"+handledept+"' and month='"+month+"'";
				BLPrpLJobLinkerFacade blPrpLJobLinkerFacade = new BLPrpLJobLinkerFacade();
				Collection<PrpLJobLinkerDto> prpLJobLinkerDtoList = blPrpLJobLinkerFacade.findByConditions(conditions);
				request.setAttribute("prpLJobLinkerDtoList", prpLJobLinkerDtoList);
			}
			
			request.setAttribute("systemCode", systemCode);
			request.setAttribute("classCode", classCode);
			request.setAttribute("updateType", updateType);
			request.setAttribute("month", month);
			request.setAttribute("editType", editType);
			request.setAttribute("handledept", handledept);
			request.setAttribute("prpljobmanagertimeDtoList", prpljobmanagertimeDtoList);
			request.setAttribute("prpljobmanagerDtoList", prpljobmanagerDtoList);
			request.setAttribute("prpljobmanagerDtoSql", prpljobmanagerDtoSql);
			forward = "DAAPage";
		}
		return mapping.findForward(forward);
	}

}
