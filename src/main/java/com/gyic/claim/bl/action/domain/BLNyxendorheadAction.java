package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxendorheadDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxendorhead;

/**
 * ����NYXENDORHEAD��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLNyxendorheadAction extends BLNyxendorheadActionBase{
    private static Logger logger = Logger.getLogger(BLNyxendorheadAction.class);

    /**
     * ���캯��
     */
    public BLNyxendorheadAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param nyxendorheadDto nyxendorheadDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,NyxendorheadDto nyxendorheadDto,String mode)
            throws Exception{
    }
}
