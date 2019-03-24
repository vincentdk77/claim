
package com.sinosoft.claim.ui.control.viewHelper;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;

/**
 * <p>Title: AccidentWorkFlowViewHelper</p>
 * <p>Description:调度ViewHelper类，在该类中完成页面数据的整理 注：此类专为意健险使用</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2004</p>
 * @author 车险理赔项目组 wangli
 * @version 1.0
 * <br>
 */
public class AccidentWorkFlowViewHelper extends WorkFlowViewHelper{
	
	   public AccidentWorkFlowViewHelper() 
	   {
	   } 
	   /*========================第一部分：工作引擎正向操作========================*/
	   /**
	    * 操作工作流的数据整理,此函数就是所有工作流流转的引擎入口，
	    * 想知道工作流是如何运转的，从这个函数看起吧。
	    * @param user UserDto 用户dto
	    * @param swfLogFunctionInDto 传参数
	    * @throws Exception
	    * @return WorkFlowDto 工作流程数据传输数据结构
	    */
	    public WorkFlowDto viewToDto(UserDto user,SwfLogDto swfLogFunctionInDto) throws Exception
	    {
	      //取得当前用户信息，写操作员信息到Dto中
	    	AccidentWorkFlowEngineViewHelper accidentWorkFlowEngineViewHelper =new AccidentWorkFlowEngineViewHelper();
	      return accidentWorkFlowEngineViewHelper.viewToDto(user,swfLogFunctionInDto);
	    }

}
