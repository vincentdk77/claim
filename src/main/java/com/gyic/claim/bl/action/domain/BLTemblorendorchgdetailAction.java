package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorendorchgdetailDto;
import com.gyic.claim.resource.dtofactory.domain.DBTemblorendorchgdetail;

/**
 * ����TEMBLORENDORCHGDETAIL��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLTemblorendorchgdetailAction extends BLTemblorendorchgdetailActionBase{
    private static Logger logger = Logger.getLogger(BLTemblorendorchgdetailAction.class);

    /**
     * ���캯��
     */
    public BLTemblorendorchgdetailAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param temblorendorchgdetailDto temblorendorchgdetailDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,TemblorendorchgdetailDto temblorendorchgdetailDto,String mode)
            throws Exception{
    }
}
