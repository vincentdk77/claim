package com.sinosoft.ciplatform.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.ciplatform.dto.domain.CIClaimUploadRegistDto;
import com.sinosoft.ciplatform.resource.dtofactory.domain.DBCIClaimUploadRegist;

/**
 * ����������Ϣƽ̨�ϴ�ע����ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIClaimUploadRegistAction extends BLCIClaimUploadRegistActionBase{
    private static Logger logger = Logger.getLogger(BLCIClaimUploadRegistAction.class);

    /**
     * ���캯��
     */
    public BLCIClaimUploadRegistAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param cIClaimUploadRegistDto cIClaimUploadRegistDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CIClaimUploadRegistDto cIClaimUploadRegistDto,String mode)
            throws Exception{
    }
}
