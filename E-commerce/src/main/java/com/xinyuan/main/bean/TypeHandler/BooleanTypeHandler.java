package com.xinyuan.main.bean.TypeHandler;

import com.xinyuan.main.domain.Enum.DefaultAddressEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Auther: chenxin
 * @Date: 2019/1/5 15:30
 * @Description:
 */
public class BooleanTypeHandler implements TypeHandler<Boolean>{
    @Override
    public void setParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, DefaultAddressEnum.getDefaulAddressEnum(parameter).getStatus());
    }

    @Override
    public Boolean getResult(ResultSet rs, String columnName) throws SQLException {
        int re = rs.getInt(columnName);
        return DefaultAddressEnum.getDefaulAddressEnum(re).isFlag();
    }

    @Override
    public Boolean getResult(ResultSet rs, int columnIndex) throws SQLException {
        int re = rs.getInt(columnIndex);
        return DefaultAddressEnum.getDefaulAddressEnum(re).isFlag();
    }

    @Override
    public Boolean getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int re = cs.getInt(columnIndex);

        return DefaultAddressEnum.getDefaulAddressEnum(re).isFlag();
    }
}
