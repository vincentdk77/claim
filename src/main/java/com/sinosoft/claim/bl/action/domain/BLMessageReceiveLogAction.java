package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.MessageReceiveLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBMessageReceiveLog;

/**
 * ����MessageReceiveLog��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLMessageReceiveLogAction extends BLMessageReceiveLogActionBase{
    private static Logger logger = Logger.getLogger(BLMessageReceiveLogAction.class);

    /**
     * ���캯��
     */
    public BLMessageReceiveLogAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param messageReceiveLogDto messageReceiveLogDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,MessageReceiveLogDto messageReceiveLogDto,String mode)
            throws Exception{
    }
}
