package Model;

import Orm.Query;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class ModelAbstract
{
    protected Integer id;
    public ArrayList<String> fields;
    public String tableName;

    abstract public ArrayList getValues();

    public Integer getId() { return this.id; }

    public ModelAbstract find()
        throws SQLException, ClassNotFoundException, NamingException
    {
        // TODO : develop this
        //ArrayList modelData = new Query().selectWhere(this.tableName, this.fields);
        return null;
    }

    public ArrayList findAll()
        throws SQLException, ClassNotFoundException, NamingException
    {
        return new Query().select(this.tableName, this.fields);
    }

    public void persist()
        throws SQLException, ClassNotFoundException, NamingException
    {
        new Query().insert(this.tableName, this.fields, this.getValues());
    }

    public void delete()
        throws SQLException, ClassNotFoundException, NamingException
    {
        new Query().delete(this.tableName, this.getId());
    }
}
