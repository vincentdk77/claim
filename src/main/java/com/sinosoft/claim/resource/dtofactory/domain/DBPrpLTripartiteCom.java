package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLTripartiteComDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * 这是DBPrpDTripartiteCom 第三方数据基础数据的数据访问对象扩展类<br>
 * 创建于 2012/11/9
 */
public class DBPrpLTripartiteCom extends DBPrpLTripartiteComBase {
	 private static Log log = LogFactory.getLog(DBPrpLTripartiteCom.class.getName());

	    /**
	     * 构造函数
	     * @param dbManager 资源管理类
	     */
	    public DBPrpLTripartiteCom(DBManager dbManager){
	        super(dbManager);
	    }

		public Collection findSql(DBManager dbManager,String sql) throws Exception{
			Collection Collection = new ArrayList();
			ResultSet resultSet = dbManager.executeQuery(sql);;
			try {
				while(resultSet.next()) {
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				 resultSet.close();
			}
	        return Collection;
		}
}