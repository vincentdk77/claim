package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.custom.AbstractDto;
import com.sinosoft.claim.dto.custom.AnaRepCommonDto;
import com.sinosoft.claim.dto.custom.AnaResultDto;
import com.sinosoft.claim.ui.control.action.UIManageReportAction;
import com.sinosoft.claim.ui.control.viewHelper.ManageReportViewHelper;

public class UIManageReportFacade extends Action
{
  /**
   * 1�����AnaRepCommonDto���Ի��������ѯ������Ϣ����������Ϣ��
   * 2�������ҳ���ϵ�ֵ�Ĳ�ѯ�Ľ���������AnaResultDto�ļ���
   * 3������AbstractDto��PageCount��RowsCount����
   * 4������õĽ������session�У�Ϊ���Ժ�Ĳ������ܹ�ֱ�ӻ�����ֵ�����
   * 5��intQueryStyle��Ϊ0ʱ�����ù����ķ�������Excel
   */
  public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
         throws Exception
  {
System.out.println("UIManageReportFacade:1==========");
    UICommonFacade uiCommonFacade = new UICommonFacade();
    UIManageReportAction uiManageReportAction = new UIManageReportAction();
    ManageReportViewHelper manageReportViewHelper = new ManageReportViewHelper();
    AnaRepCommonDto anaRepCommonDto = new AnaRepCommonDto();
    AnaResultDto anaResultDto = null;

    String strQueryStyle = "";
    String strCondition = "";

    int intQueryStyle = 0;
System.out.println("UIManageReportFacade:2==========");

    try
    {
      strQueryStyle = httpServletRequest.getParameter("QueryStyle");

      if(strQueryStyle==null||strQueryStyle.equals("6"))
        intQueryStyle = 0;
      else
        intQueryStyle = 1;
    }
    catch(NullPointerException npe) //���QueryStyleΪ�յĻ�,˵���ǴӲ�ѯ����ҳ�����ӵ������ʾҳ��,�����Ǵӽ����ʾҳ�������ύ������
    {
    }

System.out.println("UIManageReportFacade:3==========");
System.out.println("QueryStyle:"+strQueryStyle);
    //1����á���ѯ��������Ϣ
    //2����á���ʾѡ���Ϣ
    anaRepCommonDto = manageReportViewHelper.requestToDto(httpServletRequest);
    //����anaRepCommonDto��ѯ���ݿ⣬����AnaResultDto(rowsCount,collection(HashMap�ļ���))
    anaResultDto = uiManageReportAction.findByDto(anaRepCommonDto);

    if(intQueryStyle==0)
    {
System.out.println("UIManageReportFacade:4==========");
      //����AbstractDto��PageCount��RowsCount����
      AbstractDto abstractDto = null;
      abstractDto = uiCommonFacade.genPage(anaRepCommonDto,anaResultDto.getRowsCount());
      anaRepCommonDto.setAbstractDto(abstractDto);
      //1����anaResultDto.collection����httpServletRequest�У�Results
      //2������õ���ʾѡ������ϵ���Ϣ����session�У�CollectionSum��CollectionDetail
      //3����anaRepCommonDto����httpServletRequest�У�AnaRepCommonDto
      //4����abstractDto����httpServletRequest�У�AbstractDto
      manageReportViewHelper.dtoToRequest(httpServletRequest,anaResultDto.getCollection(),anaRepCommonDto);

System.out.println("UIManageReportFacade:5==========");
      return actionMapping.findForward("success");
    }
    else //����EXCEL
    {
System.out.println("UIManageReportFacade:6==========");
      ArrayList arrConfigsSum = null;
      Vector vecConfigs = new Vector();

      vecConfigs = (Vector)anaRepCommonDto.getConfigs();
      arrConfigsSum = (ArrayList)vecConfigs.get(1);
      uiCommonFacade.exportExcel((ArrayList)anaResultDto.getCollection(),arrConfigsSum,intQueryStyle,httpServletResponse);

System.out.println("UIManageReportFacade:7==========");
      return null;
    }
  }
}

