package com.sinosoft.claim.ui.control.viewHelper;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.dto.custom.ScheduleNewDto;

/**
 * <p>Title: ClaimStatusViewHelper</p>
 * <p>Description:�µ���ViewHelper�࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004</p>
 * @author ����������Ŀ�� liubvo
 * @version 1.0
 * <br>
 */

 public abstract class ScheduleNewViewHelper
 {
   /**
    * Ĭ�Ϲ��췽��
    */
    public ScheduleNewViewHelper()
    {
    }

   /**
    * ���� �µ���ҳ����������.
    * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
    * @param httpServletRequest
    * @return claimStatusDto ����ڵ�״̬���ݴ�������
    * @throws Exception
    */
    public ScheduleNewDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
    {
      ScheduleNewDto scheduleNewDto = new ScheduleNewDto();
       /*----------�µ���������Ϣ------------------*/
      return scheduleNewDto;
    }
 }
