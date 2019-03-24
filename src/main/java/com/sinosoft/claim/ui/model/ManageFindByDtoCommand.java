package com.sinosoft.claim.ui.model;

import java.lang.reflect.Method;

import com.sinosoft.claim.dto.custom.AbstractDto;
import com.sinosoft.claim.dto.custom.AnaRepCommonDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class ManageFindByDtoCommand extends BaseCommand
{
  private AnaRepCommonDto anaRepCommonDto;
  private AbstractDto abstractDto;
  private int pageNo;
  private int rowsPerPage;

  /**
   * 按查询command方法
   * @param AnaReportDto 查询条件
   * @return object
   * @throws Exception
   */
  public ManageFindByDtoCommand(AnaRepCommonDto anaRepCommonDto) throws Exception
  {
    this.anaRepCommonDto = anaRepCommonDto;
    this.abstractDto = anaRepCommonDto.getAbstractDto();
    this.pageNo = abstractDto.getPageNo();
    this.rowsPerPage = abstractDto.getRowsPerPage();
  }

  public Object executeCommand() throws Exception
  {
    Class loaderClass = Class.forName("com.sinosoft.claim.bl.facade.BLManageFacade");
    Object obj = loaderClass.newInstance();
    Class[] paraTypes = {AnaRepCommonDto.class,int.class,int.class};
    Method methodFindByConditions = loaderClass.getMethod("findByDto",paraTypes);
    Object[] params = {anaRepCommonDto,new Integer(pageNo),new Integer(rowsPerPage)};
    return methodFindByConditions.invoke(obj,params);
  }
}

