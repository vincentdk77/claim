package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Zh03PolicyListOriginDto;
import com.gyic.claim.resource.dtofactory.domain.DBZh03PolicyListOrigin;

/**
 * ����ZH03PolicyListOrigin��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLZh03PolicyListOriginAction extends BLZh03PolicyListOriginActionBase{
    private static Logger logger = Logger.getLogger(BLZh03PolicyListOriginAction.class);

    /**
     * ���캯��
     */
    public BLZh03PolicyListOriginAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param zh03PolicyListOriginDto zh03PolicyListOriginDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,Zh03PolicyListOriginDto zh03PolicyListOriginDto,String mode)
            throws Exception{
    }
}
