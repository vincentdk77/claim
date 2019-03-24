package com.sinosoft.claim.ui.control.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.prpall.dto.domain.PrpCmainDto;
import com.sinosoft.undwrt.bl.facade.BLWflogStoreFacade;
import com.sinosoft.undwrt.dto.domain.UwNotionDto;
import com.sinosoft.undwrt.dto.domain.UwNotionHisDto;
import com.sinosoft.undwrt.dto.domain.WfLogDto;
import com.sinosoft.undwrt.dto.domain.WfLogHisDto;
import com.sinosoft.undwrt.dto.domain.WflogStoreDto;
import com.sinosoft.undwrt.ui.control.action.UIWflogQueryAction;
import com.sinosoft.undwrt.ui.model.UwNotionFindByConditionsCommand;
import com.sinosoft.undwrt.ui.model.UwNotionHisFindByConditionsCommand;
import com.sinosoft.undwrt.ui.model.WfLogFindByConditionsCommand;
import com.sinosoft.undwrt.ui.model.WfLogHisFindByConditionsCommand;
import com.sinosoft.undwrt.ui.model.WfLogStoreFindByConditionsCommand;
/**
 * <p>Title: uwweb</p>
 * <p>Description: 任务处理方法</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author Luyang
 * @version 1.0
 */

public class UICommonHePeiViewTraceAction
    implements java.io.Serializable
{
  /**
   * @desc  获取轨迹信息
   * @param req HttpServletRequest
   * @return Collection
   * @throws Exception
   * @author Luyang
   * @version 1.0
   */
  public Collection getTraceInfoList(HttpServletRequest req) throws Exception
  {
    UIWflogQueryAction uiWflogQueryAction = new UIWflogQueryAction();
    Collection colTraceInfoList = null;
    Collection colTraceStoreInfoList = null;
    Collection colTraceHisList = null;
    Collection colNotionList = new ArrayList();
    WfLogDto wfLogDto = null;
    WfLogHisDto wfLogHisDto = null;
    PrpCmainDto prpCmainDto = null;
    UwNotionDto uwNotionDto = null;
    UwNotionHisDto uwNotionHisDto = null;
    String businessNo = req.getParameter("BusinessNo");
    String strNotionSQL = "";
    String handleText = "";

    if(businessNo!=null && businessNo.length()>0 && businessNo.charAt(0)=='1' && businessNo.indexOf("_")<0)
    {
      prpCmainDto=uiWflogQueryAction.getPrpCmain(businessNo);
      if(prpCmainDto!=null && prpCmainDto.getProposalNo()!=null && prpCmainDto.getProposalNo().trim().length()>0)
      {
      	businessNo=prpCmainDto.getProposalNo();
      }
    }

    String strSQL = " BusinessNo ='" + businessNo + "'"
        + " ORDER BY FlowId,LogNo";

    //获取正常轨迹信息
    WfLogFindByConditionsCommand wfLogFindByConditionsCommand = new WfLogFindByConditionsCommand(strSQL);
    colTraceInfoList = (ArrayList)wfLogFindByConditionsCommand.execute();

	//核保核赔性能优化
    if(colTraceInfoList.size()==0){
    	BLWflogStoreFacade blWflogStoreFacade = new BLWflogStoreFacade();
    	WfLogStoreFindByConditionsCommand wfLogStoreFindByConditionsCommand = new WfLogStoreFindByConditionsCommand(strSQL);
    	colTraceStoreInfoList = (ArrayList)wfLogStoreFindByConditionsCommand.execute();
    	Iterator wflogStoreDtoIterator=colTraceStoreInfoList.iterator();
    	while(wflogStoreDtoIterator.hasNext()){
    		WflogStoreDto wflogStoreDto=(WflogStoreDto)wflogStoreDtoIterator.next();
    		WfLogDto wfLogDtoNew=blWflogStoreFacade.convertWflogStoreToWflog(wflogStoreDto);
    		colTraceInfoList.add(wfLogDtoNew);
    	}
    }

    if (colTraceInfoList.size() > 0)
    {
      for(Iterator iWfLog=colTraceInfoList.iterator();iWfLog.hasNext();)
      {
        wfLogDto = (WfLogDto)iWfLog.next();
        handleText = "";
        strNotionSQL = " FlowId ='"+ wfLogDto.getFlowID() +"'"
            +" AND LogNo ="+ wfLogDto.getLogNo() 
            +" ORDER BY LineNo";
        UwNotionFindByConditionsCommand uwNotionFindByConditionsCommand = new UwNotionFindByConditionsCommand(strNotionSQL);
        colNotionList = (ArrayList)uwNotionFindByConditionsCommand.execute();
        for(Iterator iNotion=colNotionList.iterator();iNotion.hasNext();)
        {
          uwNotionDto = (UwNotionDto)iNotion.next();
          handleText += uwNotionDto.getHandleText();
          handleText+="\r\n";
        }
        wfLogDto.setHandleText(handleText);
      }
      return colTraceInfoList;
    }
    else
    {
      //获取转储表中的轨迹信息
      WfLogHisFindByConditionsCommand wfLogHisFindByConditionsCommand = new WfLogHisFindByConditionsCommand(strSQL);
      colTraceHisList = (ArrayList)wfLogHisFindByConditionsCommand.execute();
      for(Iterator iWfLogHis=colTraceHisList.iterator();iWfLogHis.hasNext();)
      {
        wfLogHisDto = (WfLogHisDto)iWfLogHis.next();
        handleText = "";
        strNotionSQL = " FlowId ='"+ wfLogHisDto.getFlowID() +"'"
            +" AND LogNo ='"+ wfLogHisDto.getLogNo() +"'"
            +" ORDER BY LineNo";
        UwNotionHisFindByConditionsCommand uwNotionHisFindByConditionsCommand = new UwNotionHisFindByConditionsCommand(strNotionSQL);
        colNotionList = (ArrayList)uwNotionHisFindByConditionsCommand.execute();
        for(Iterator iNotionHis=colNotionList.iterator();iNotionHis.hasNext();)
        {
          uwNotionHisDto = (UwNotionHisDto)iNotionHis.next();
          handleText += uwNotionHisDto.getHandleText();
          handleText+="\r\n";
        }
        wfLogDto.setHandleText(handleText);
      }
      return colTraceHisList;
    }
  }


}
