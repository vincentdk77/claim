package com.sinosoft.NXCaseUp.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.NXCaseUp.dto.domain.CasefarmerDto;
import com.sinosoft.NXCaseUp.resource.dtofactory.domain.DBCasefarmer;

/**
 * ����CASEFARMER��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCasefarmerAction extends BLCasefarmerActionBase{
    private static Logger logger = Logger.getLogger(BLCasefarmerAction.class);

    /**
     * ���캯��
     */
    public BLCasefarmerAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param casefarmerDto casefarmerDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CasefarmerDto casefarmerDto,String mode)
            throws Exception{
    }
}
