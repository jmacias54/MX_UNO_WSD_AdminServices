/**
 * 
 */
package mx.com.amx.unotv.adminservice.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class TotalRowMapper implements RowMapper<Integer> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public Integer mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Integer result = 0;
		result = rs.getInt("total");
		
		
		return result;
	}

}
