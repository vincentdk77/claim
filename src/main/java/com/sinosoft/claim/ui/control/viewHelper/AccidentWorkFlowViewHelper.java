
package com.sinosoft.claim.ui.control.viewHelper;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;

/**
 * <p>Title: AccidentWorkFlowViewHelper</p>
 * <p>Description:����ViewHelper�࣬�ڸ��������ҳ�����ݵ����� ע������רΪ�⽡��ʹ��</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004</p>
 * @author ����������Ŀ�� wangli
 * @version 1.0
 * <br>
 */
public class AccidentWorkFlowViewHelper extends WorkFlowViewHelper{
	
	   public AccidentWorkFlowViewHelper() 
	   {
	   } 
	   /*========================��һ���֣����������������========================*/
	   /**
	    * ��������������������,�˺����������й�������ת��������ڣ�
	    * ��֪���������������ת�ģ��������������ɡ�
	    * @param user UserDto �û�dto
	    * @param swfLogFunctionInDto ������
	    * @throws Exception
	    * @return WorkFlowDto �����������ݴ������ݽṹ
	    */
	    public WorkFlowDto viewToDto(UserDto user,SwfLogDto swfLogFunctionInDto) throws Exception
	    {
	      //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��Dto��
	    	AccidentWorkFlowEngineViewHelper accidentWorkFlowEngineViewHelper =new AccidentWorkFlowEngineViewHelper();
	      return accidentWorkFlowEngineViewHelper.viewToDto(user,swfLogFunctionInDto);
	    }

}
