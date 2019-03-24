package com.sinosoft.claim.ui.control.viewHelper;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.dto.domain.PrpLclaimGradeDto;

/**
 * <p>Title: ClaimGradeViewHelper</p>
 * <p>Description:业务权限表ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2005</p>
 * @author 车险理赔项目组
 * @version 1.0
 * <br>
 */

 public abstract class ClaimGradeViewHelper
 {
    /**
    * 默认构造方法
    */
    public ClaimGradeViewHelper()
    {
    }

    /**
     * 保存业务权限数据表整理
     * @param httpServletRequest
     * @return PrpLclaimGradeDto
     * @throws Exception
     */
     public PrpLclaimGradeDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
     {

       //定义ClaimGradeDto对象
       PrpLclaimGradeDto prpLclaimGradeDto = new PrpLclaimGradeDto();
       return prpLclaimGradeDto;
    }
 }
