package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

public class DBPrpCmainOriginTg extends DBPrpCmainOriginTgBase
{
  private static Log logger = LogFactory.getLog(DBPrpCmainOriginTg.class);

  public DBPrpCmainOriginTg(DBManager dbManager)
  {
    super(dbManager);
  }
}