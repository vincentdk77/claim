package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorcpendorchgdetailDto;
import com.gyic.claim.resource.dtofactory.domain.DBTemblorcpendorchgdetail;

/**
 * ����TEMBLORCPENDORCHGDETAIL��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLTemblorcpendorchgdetailAction extends BLTemblorcpendorchgdetailActionBase{
    private static Logger logger = Logger.getLogger(BLTemblorcpendorchgdetailAction.class);

    /**
     * ���캯��
     */
    public BLTemblorcpendorchgdetailAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param temblorcpendorchgdetailDto temblorcpendorchgdetailDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,TemblorcpendorchgdetailDto temblorcpendorchgdetailDto,String mode)
            throws Exception{
    }
}
