package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxcpendorchgdetailDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxcpendorchgdetail;

/**
 * ����NYXCPENDORCHGDETAIL��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLNyxcpendorchgdetailAction extends BLNyxcpendorchgdetailActionBase{
    private static Logger logger = Logger.getLogger(BLNyxcpendorchgdetailAction.class);

    /**
     * ���캯��
     */
    public BLNyxcpendorchgdetailAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param nyxcpendorchgdetailDto nyxcpendorchgdetailDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,NyxcpendorchgdetailDto nyxcpendorchgdetailDto,String mode)
            throws Exception{
    }
}
