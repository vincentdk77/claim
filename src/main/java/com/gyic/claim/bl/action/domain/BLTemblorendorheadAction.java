package com.gyic.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorendorheadDto;
import com.gyic.claim.resource.dtofactory.domain.DBTemblorendorhead;

/**
 * ����TEMBLORENDORHEAD��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLTemblorendorheadAction extends BLTemblorendorheadActionBase{
    private static Logger logger = Logger.getLogger(BLTemblorendorheadAction.class);

    /**
     * ���캯��
     */
    public BLTemblorendorheadAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param temblorendorheadDto temblorendorheadDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,TemblorendorheadDto temblorendorheadDto,String mode)
            throws Exception{
    }
}
