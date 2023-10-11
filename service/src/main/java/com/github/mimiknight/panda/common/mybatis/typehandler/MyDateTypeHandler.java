package com.github.mimiknight.panda.common.mybatis.typehandler;

import org.apache.ibatis.type.DateTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * 自定义{@link Date}时间类型转换器
 * <p>
 * 支持自定义入数据库时间格式及时区
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-10-11 07:55:06
 */
@Component
@MappedTypes(value = Date.class)
@MappedJdbcTypes(value = JdbcType.VARCHAR, includeNullJdbcType = true)
public class MyDateTypeHandler extends DateTypeHandler {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {
        if (null == parameter) {
            ps.setObject(i, null);
            return;
        }
        Instant instant = parameter.toInstant();
        ZonedDateTime dateTime = ZonedDateTime.ofInstant(instant, ZoneId.of("UTC"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSSSS", Locale.ENGLISH);
        String strDateTime = dateTime.format(formatter);
        ps.setObject(i, strDateTime);
    }

    @Override
    public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
        LocalDateTime result = rs.getObject(columnName, LocalDateTime.class);
        return convertTimeZone(result);
    }

    @Override
    public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        LocalDateTime result = rs.getObject(columnIndex, LocalDateTime.class);
        return convertTimeZone(result);
    }

    @Override
    public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        LocalDateTime result = cs.getObject(columnIndex, LocalDateTime.class);
        return convertTimeZone(result);
    }

    private Date convertTimeZone(LocalDateTime result) {
        if (null == result) {
            return null;
        }
        ZonedDateTime zonedDateTime = ZonedDateTime.of(result, ZoneId.of("UTC"));
        Instant instant = zonedDateTime.toInstant();
        return Date.from(instant);
    }
}