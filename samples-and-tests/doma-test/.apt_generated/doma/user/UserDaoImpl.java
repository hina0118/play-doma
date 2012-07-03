package doma.user;

/** */
@javax.annotation.Generated(value = { "Doma", "1.21.1" }, date = "2012-04-18T22:35:39.781+0900")
public class UserDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements doma.user.UserDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("1.21.1");
    }

    /** */
    public UserDaoImpl() {
        super(new doma.AppConfig());
    }

    /**
     * @param connection the connection
     */
    public UserDaoImpl(java.sql.Connection connection) {
        super(new doma.AppConfig(), connection);
    }

    /**
     * @param dataSource the dataSource
     */
    public UserDaoImpl(javax.sql.DataSource dataSource) {
        super(new doma.AppConfig(), dataSource);
    }

    /**
     * @param config the configuration
     */
    protected UserDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    /**
     * @param config the configuration
     * @param connection the connection
     */
    protected UserDaoImpl(org.seasar.doma.jdbc.Config config, java.sql.Connection connection) {
        super(config, connection);
    }

    /**
     * @param config the configuration
     * @param dataSource the dataSource
     */
    protected UserDaoImpl(org.seasar.doma.jdbc.Config config, javax.sql.DataSource dataSource) {
        super(config, dataSource);
    }

    @Override
    public int delete(doma.user.User user) {
        entering("doma.user.UserDaoImpl", "delete", user);
        try {
            if (user == null) {
                throw new org.seasar.doma.DomaNullPointerException("user");
            }
            org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<doma.user.User> __query = new org.seasar.doma.internal.jdbc.query.AutoDeleteQuery<doma.user.User>(doma.user._User.getSingletonInternal());
            __query.setConfig(config);
            __query.setEntity(user);
            __query.setCallerClassName("doma.user.UserDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.DeleteCommand __command = new org.seasar.doma.internal.jdbc.command.DeleteCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("doma.user.UserDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("doma.user.UserDaoImpl", "delete", __e);
            throw __e;
        }
    }

    @Override
    public int insert(doma.user.User user) {
        entering("doma.user.UserDaoImpl", "insert", user);
        try {
            if (user == null) {
                throw new org.seasar.doma.DomaNullPointerException("user");
            }
            org.seasar.doma.internal.jdbc.query.AutoInsertQuery<doma.user.User> __query = new org.seasar.doma.internal.jdbc.query.AutoInsertQuery<doma.user.User>(doma.user._User.getSingletonInternal());
            __query.setConfig(config);
            __query.setEntity(user);
            __query.setCallerClassName("doma.user.UserDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.InsertCommand __command = new org.seasar.doma.internal.jdbc.command.InsertCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("doma.user.UserDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("doma.user.UserDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<doma.user.User> select() {
        entering("doma.user.UserDaoImpl", "select");
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/doma/user/UserDao/select.sql");
            __query.setCallerClassName("doma.user.UserDaoImpl");
            __query.setCallerMethodName("select");
            __query.setResultEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<doma.user.User>> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<java.util.List<doma.user.User>>(__query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<doma.user.User>(doma.user._User.getSingletonInternal()));
            java.util.List<doma.user.User> __result = __command.execute();
            __query.complete();
            exiting("doma.user.UserDaoImpl", "select", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("doma.user.UserDaoImpl", "select", __e);
            throw __e;
        }
    }

    @Override
    public doma.user.User selectById(java.lang.Integer id) {
        entering("doma.user.UserDaoImpl", "selectById", id);
        try {
            org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery __query = new org.seasar.doma.internal.jdbc.query.SqlFileSelectQuery();
            __query.setConfig(config);
            __query.setSqlFilePath("META-INF/doma/user/UserDao/selectById.sql");
            __query.addParameter("id", java.lang.Integer.class, id);
            __query.setCallerClassName("doma.user.UserDaoImpl");
            __query.setCallerMethodName("selectById");
            __query.setResultEnsured(false);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.SelectCommand<doma.user.User> __command = new org.seasar.doma.internal.jdbc.command.SelectCommand<doma.user.User>(__query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<doma.user.User>(doma.user._User.getSingletonInternal()));
            doma.user.User __result = __command.execute();
            __query.complete();
            exiting("doma.user.UserDaoImpl", "selectById", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("doma.user.UserDaoImpl", "selectById", __e);
            throw __e;
        }
    }

    @Override
    public int update(doma.user.User user) {
        entering("doma.user.UserDaoImpl", "update", user);
        try {
            if (user == null) {
                throw new org.seasar.doma.DomaNullPointerException("user");
            }
            org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<doma.user.User> __query = new org.seasar.doma.internal.jdbc.query.AutoUpdateQuery<doma.user.User>(doma.user._User.getSingletonInternal());
            __query.setConfig(config);
            __query.setEntity(user);
            __query.setCallerClassName("doma.user.UserDaoImpl");
            __query.setCallerMethodName("update");
            __query.setQueryTimeout(-1);
            __query.setNullExcluded(false);
            __query.setVersionIncluded(false);
            __query.setVersionIgnored(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.setUnchangedPropertyIncluded(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.internal.jdbc.command.UpdateCommand __command = new org.seasar.doma.internal.jdbc.command.UpdateCommand(__query);
            int __result = __command.execute();
            __query.complete();
            exiting("doma.user.UserDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("doma.user.UserDaoImpl", "update", __e);
            throw __e;
        }
    }

}
