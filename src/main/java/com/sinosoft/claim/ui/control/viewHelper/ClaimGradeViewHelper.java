package com.sinosoft.claim.ui.control.viewHelper;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.dto.domain.PrpLclaimGradeDto;

/**
 * <p>Title: ClaimGradeViewHelper</p>
 * <p>Description:ҵ��Ȩ�ޱ�ViewHelper�࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2005</p>
 * @author ����������Ŀ��
 * @version 1.0
 * <br>
 */

 public abstract class ClaimGradeViewHelper
 {
    /**
    * Ĭ�Ϲ��췽��
    */
    public ClaimGradeViewHelper()
    {
    }

    /**
     * ����ҵ��Ȩ�����ݱ�����
     * @param httpServletRequest
     * @return PrpLclaimGradeDto
     * @throws Exception
     */
     public PrpLclaimGradeDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
     {

       //����ClaimGradeDto����
       PrpLclaimGradeDto prpLclaimGradeDto = new PrpLclaimGradeDto();
       return prpLclaimGradeDto;
    }
 }
