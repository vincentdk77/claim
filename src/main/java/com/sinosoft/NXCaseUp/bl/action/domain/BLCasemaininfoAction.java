package com.sinosoft.NXCaseUp.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.NXCaseUp.dto.domain.CasemaininfoDto;
import com.sinosoft.NXCaseUp.resource.dtofactory.domain.DBCasemaininfo;

/**
 * ����CASEMAININFO��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCasemaininfoAction extends BLCasemaininfoActionBase{
    private static Logger logger = Logger.getLogger(BLCasemaininfoAction.class);

    /**
     * ���캯��
     */
    public BLCasemaininfoAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param casemaininfoDto casemaininfoDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,CasemaininfoDto casemaininfoDto,String mode)
            throws Exception{
    }
}
