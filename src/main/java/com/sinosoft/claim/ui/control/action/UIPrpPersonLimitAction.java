package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.bl.facade.BLPersonLimitFacade;
import com.sinosoft.claim.dto.custom.PrpLPersonLimitDto;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * �����ձ��ѯ����Ȩ��
 * <p>Title: �����ձ��ѯ����Ȩ��action  </p>
 * <p>Description: �����ձ��ѯ����Ȩ��action</p>
 * <p>Copyright: Copyright (c) 2005/11/15</p>
 * <p>Company: Sinosoft</p>
 * @author qinyongli
 * @version 1.0
 */

public class UIPrpPersonLimitAction {
    
    
      /**
      * �������Ȩ��
      * @param  conditions����ѯ��������Ȩ��
      * @return ����Ȩ��
      * @throws Exception
      */
      public Collection findByConditions(String conditions) throws SQLException,Exception
      {
        BLPersonLimitFacade blPersonLimitFacade = new BLPersonLimitFacade();
         
         return (Collection)blPersonLimitFacade.findByConditions(conditions);
      }
      /**
       * 
       * @param UserCode
       * @return
       * @throws Exception
       */
      public String findByUsercode(String UserCode) throws Exception{
         
        String conditions = "1=1 and usercode = '" + UserCode + "'";
        String condition = " and (";//�õ���sql����
        ArrayList riskcodeList = new ArrayList();
        riskcodeList = (ArrayList)this.findByConditions(conditions);
        Iterator iterator = riskcodeList.iterator();
        PrpLPersonLimitDto prpLPersonLimitDto = new PrpLPersonLimitDto();
        int i=0;
        while(iterator.hasNext()){
            i++;
            prpLPersonLimitDto = (PrpLPersonLimitDto)iterator.next();
            String riskCode = prpLPersonLimitDto.getRiskCode();
            condition = condition + " riskCode = '" + riskCode +"' or ";
        }
        if(i==0){
            throw new UserException(1,3,"���⹤����","��û���κ����ֲ���Ȩ�ޣ�����ϵ����Ա��");
        }
        condition = condition + " riskCode = '9999' )";
        return condition;
      }
      
}