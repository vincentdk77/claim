package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Zh03PolicyListDto;
import com.gyic.claim.resource.dtofactory.domain.DBZh03PolicyList;

/**
 * ����ZH03PolicyList��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLZh03PolicyListAction extends BLZh03PolicyListActionBase{
    private static Logger logger = Logger.getLogger(BLZh03PolicyListAction.class);

    /**
     * ���캯��
     */
    public BLZh03PolicyListAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param zh03PolicyListDto zh03PolicyListDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,Zh03PolicyListDto zh03PolicyListDto,String mode)
            throws Exception{
    }
}
