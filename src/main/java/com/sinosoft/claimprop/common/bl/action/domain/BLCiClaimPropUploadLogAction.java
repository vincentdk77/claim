package com.sinosoft.claimprop.common.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claimprop.common.dto.domain.CiClaimPropUploadLogDto;
import com.sinosoft.claimprop.common.resource.dtofactory.domain.DBCiClaimPropUploadLog;

/**
 * ����CiClaimPropUploadLog��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCiClaimPropUploadLogAction extends BLCiClaimPropUploadLogActionBase{
    private static Logger logger = Logger.getLogger(BLCiClaimPropUploadLogAction.class);

    /**
     * ���캯��
     */
    public BLCiClaimPropUploadLogAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param ciClaimPropUploadLogDto ciClaimPropUploadLogDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CiClaimPropUploadLogDto ciClaimPropUploadLogDto,String mode)
            throws Exception{
    }
}
