package com.sinosoft.ciplatform.bl.action.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.ciplatform.dto.domain.UtiConfigMapDto;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ������ҵ��ƽ̨���ñ��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLUtiConfigMapAction extends BLUtiConfigMapActionBase{
    private static Logger logger = Logger.getLogger(BLUtiConfigMapAction.class);

    /**
     * ���캯��
     */
    public BLUtiConfigMapAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param utiConfigMapDto utiConfigMapDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiConfigMapDto utiConfigMapDto,String mode)
            throws Exception{
    }
}
