package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Zh03InsuranceListDto;

/**
 * ����ZH03InsuranceList��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLZh03InsuranceListAction extends BLZh03InsuranceListActionBase{
    private static Logger logger = Logger.getLogger(BLZh03InsuranceListAction.class);

    /**
     * ���캯��
     */
    public BLZh03InsuranceListAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param zh03InsuranceListDto zh03InsuranceListDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,Zh03InsuranceListDto zh03InsuranceListDto,String mode)
            throws Exception{
    }
}
