package com.sinosoft.function.insutil.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiRouteDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utiroute��ҵ�������չ��<br>
 * ������ 2004-4-5 15:16:34<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiRouteAction extends BLUtiRouteActionBase{
    private static Log log = LogFactory.getLog(BLUtiRouteAction.class.getName());

    /**
     * ���캯��
     */
    public BLUtiRouteAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param utiRouteDto utiRouteDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiRouteDto utiRouteDto,String mode) throws Exception{
    }
}
