package com.sinosoft.ciplatform.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.ciplatform.dto.domain.CIClaimUploadLogDto;
import com.sinosoft.ciplatform.resource.dtofactory.domain.DBCIClaimUploadLog;

/**
 * ����������Ϣ�ϴ�ƽ̨��־���ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIClaimUploadLogAction extends BLCIClaimUploadLogActionBase{
    private static Logger logger = Logger.getLogger(BLCIClaimUploadLogAction.class);

    /**
     * ���캯��
     */
    public BLCIClaimUploadLogAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param cIClaimUploadLogDto cIClaimUploadLogDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CIClaimUploadLogDto cIClaimUploadLogDto,String mode)
            throws Exception{
    }
}
