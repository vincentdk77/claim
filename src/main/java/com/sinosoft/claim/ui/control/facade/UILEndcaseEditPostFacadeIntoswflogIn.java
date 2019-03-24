package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.dto.custom.EndcaseDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisitswflog;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.viewHelper.DAAReturnVisitViewHelper;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class UILEndcaseEditPostFacadeIntoswflogIn {
	
	public static void insertNew(HttpServletRequest httpServletRequest){
		
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		PrplreturnvisitswflogDto prplreturnvisitswflogDto = null;
		DBManager dbManager = new DBManager();
		
		try {
			UserDto userDto = (UserDto) httpServletRequest.getSession().getAttribute("user"); 
			dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
			
			//�᰸��endca
			//���ȣ�sched
			
			String nodeType = "endca";
			String state = "0";
			int pageNo =1;
			int rowsPerPage =20000;
			int count = blPrpLregistFacade.getCountNew("");
			System.err.println(count);
			System.err.println(count/20000+2);
			for (; pageNo <count/20000+2; pageNo++) {
			System.err.println(pageNo);
			List<PrpLregistDto> prpLregistDtos = (ArrayList<PrpLregistDto>)blPrpLregistFacade.findByConditionsNew(dbManager,"",pageNo, rowsPerPage);
			System.err.println(prpLregistDtos.size());
			for (int i = 0; i < prpLregistDtos.size(); i++) {
				PrpLregistDto prpLregistDto = prpLregistDtos.get(i);
			prplreturnvisitswflogDto = new PrplreturnvisitswflogDto();
			prplreturnvisitswflogDto.setBusinessno(prpLregistDto.getRegistNo());								//ҵ���
			prplreturnvisitswflogDto.setNodetype(nodeType);														//�ڵ��
			prplreturnvisitswflogDto.setRegistno(prpLregistDto.getRegistNo());									//������
			prplreturnvisitswflogDto.setComcode(prpLregistDto.getComCode());									//�б�����
			
			System.err.println(prpLregistDto.getPolicyNo());
			
			prplreturnvisitswflogDto.setPolicyno(prpLregistDto.getPolicyNo());
			UICodeAction uiCodeAction = new UICodeAction();
			String comName = uiCodeAction.translateComCode(prpLregistDto.getComCode(), true);
			prplreturnvisitswflogDto.setComcodename(comName);										//��������
			prplreturnvisitswflogDto.setInsuredname(prpLregistDto.getInsuredName());							//��������
			String reportd = prpLregistDto.getReportDate().toString();
			reportd = reportd+" "+prpLregistDto.getReportHour();
			DateTime d =new DateTime(reportd,DateTime.YEAR_TO_MONTH);
			prplreturnvisitswflogDto.setReportdate(d);			//����ʱ��
			if("sched".equals(nodeType)){
			}else{
				prplreturnvisitswflogDto.setCeasedate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));													//�᰸ʱ��
			}
			prplreturnvisitswflogDto.setLicenseno(prpLregistDto.getLicenseNo());								//���ƺ�
			prplreturnvisitswflogDto.setHandlercode(userDto.getUserCode());										//�����˴���
			prplreturnvisitswflogDto.setHandlername(userDto.getUserName());										//����������
			prplreturnvisitswflogDto.setHandlercomcode(userDto.getComCode());									//�����˲���
			prplreturnvisitswflogDto.setFlowintotime(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));//����ʱ��
			prplreturnvisitswflogDto.setClasscode(prpLregistDto.getClassCode());								//����
			prplreturnvisitswflogDto.setState(state);															//״̬
			prplreturnvisitswflogDto.setRiskCode(prpLregistDto.getRiskCode());
			//�������ݿ�
		//	new DBPrplreturnvisitswflog(dbManager).insert(prplreturnvisitswflogDto);
			}
			dbManager.commitTransaction();
			}
		} catch (Exception e) {
			try {
				dbManager.rollbackTransaction();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally{
			try {
				dbManager.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	}
}
