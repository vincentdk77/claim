package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxendorchgdetailDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxendorchgdetail;

/**
 * ����NYXENDORCHGDETAIL��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLNyxendorchgdetailAction extends BLNyxendorchgdetailActionBase{
    private static Logger logger = Logger.getLogger(BLNyxendorchgdetailAction.class);

    /**
     * ���캯��
     */
    public BLNyxendorchgdetailAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param nyxendorchgdetailDto nyxendorchgdetailDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,NyxendorchgdetailDto nyxendorchgdetailDto,String mode)
            throws Exception{
    }
}
