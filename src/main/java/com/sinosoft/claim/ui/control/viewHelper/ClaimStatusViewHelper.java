package com.sinosoft.claim.ui.control.viewHelper;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.dto.custom.ClaimStatusDto;
/**
 * <p>Title: ClaimStatusViewHelper</p>
 * <p>Description:理赔节点状态ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2004</p>
 * @author 车险理赔项目组 liubvo
 * @version 1.0
 * <br>
 */

 public abstract class ClaimStatusViewHelper
 {
   /**
    * 默认构造方法
    */
    public ClaimStatusViewHelper()
    {
    }

   /**
    * 保存理赔节点状态时报案页面数据整理.
    * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
    * @param httpServletRequest
    * @return claimStatusDto 理赔节点状态数据传输数据
    * @throws Exception
    */
    public ClaimStatusDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
    {
      ClaimStatusDto claimStatusDto = new ClaimStatusDto();
      return claimStatusDto;
    }


 }
