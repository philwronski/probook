package fr.philwronski.probook.configuration.database;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by p.wronski on 05/10/2017.
 */
public class StringListDataType implements UserType {

    @Override
    public int[] sqlTypes() {
        return new int[]{Types.ARRAY};
    }

    @Override
    public Class returnedClass() {
        return List.class;
    }

    @Override
    public boolean equals(Object o, Object o1) throws HibernateException {
        return o != null && o1 != null && o.equals(o1);
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        return o == null ? 0 : o.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SessionImplementor sessionImplementor, Object o) throws HibernateException, SQLException {
        if (strings != null && strings.length > 0 && resultSet != null && resultSet.getArray(strings[0]) != null) {
            Object array = resultSet.getArray(strings[0]).getArray();
            if (array instanceof String[]) {
                return Arrays.asList((String[]) array);
            }
        }

        return null;
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i, SessionImplementor sessionImplementor) throws HibernateException, SQLException {
        if (o != null && preparedStatement != null) {
            List<String> list = (List<String>) o;
            String[] castObject = list.toArray(new String[list.size()]);
            Array array = sessionImplementor.connection().createArrayOf("smallint", castObject);
            preparedStatement.setArray(i, array);
        } else {
            preparedStatement.setNull(i, sqlTypes()[0]);
        }
    }

    @Override
    public Object deepCopy(Object o) throws HibernateException {
        if (o == null)
            return null;

        List<String> list = (List<String>) o;
        ArrayList<String> clone = new ArrayList<String>();
        for (Object s : list)
            clone.add((String) s);

        return clone;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException {
        return (Serializable) o;
    }

    @Override
    public Object assemble(Serializable serializable, Object o) throws HibernateException {
        return serializable;
    }

    @Override
    public Object replace(Object o, Object o1, Object o2) throws HibernateException {
        return o;
    }
}
