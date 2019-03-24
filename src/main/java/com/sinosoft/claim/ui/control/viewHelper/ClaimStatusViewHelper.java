package com.sinosoft.claim.ui.control.viewHelper;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.dto.custom.ClaimStatusDto;
/**
 * <p>Title: ClaimStatusViewHelper</p>
 * <p>Description:����ڵ�״̬ViewHelper�࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004</p>
 * @author ����������Ŀ�� liubvo
 * @version 1.0
 * <br>
 */

 public abstract class ClaimStatusViewHelper
 {
   /**
    * Ĭ�Ϲ��췽��
    */
    public ClaimStatusViewHelper()
    {
    }

   /**
    * ��������ڵ�״̬ʱ����ҳ����������.
    * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
    * @param httpServletRequest
    * @return claimStatusDto ����ڵ�״̬���ݴ�������
    * @throws Exception
    */
    public ClaimStatusDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
    {
      ClaimStatusDto claimStatusDto = new ClaimStatusDto();
      return claimStatusDto;
    }


 }
