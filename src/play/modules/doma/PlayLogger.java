package play.modules.doma;

import java.sql.SQLException;

import org.seasar.doma.jdbc.JdbcLogger;
import org.seasar.doma.jdbc.Sql;
import org.seasar.doma.jdbc.SqlExecutionSkipCause;
import org.seasar.doma.message.Message;

import play.Logger;

public class PlayLogger implements JdbcLogger {
    @Override
    public void logDaoMethodEntering(String callerClassName,
            String callerMethodName, Object... args) {
    	Logger.debug("ENTRY");
    }

    @Override
    public void logDaoMethodExiting(String callerClassName,
            String callerMethodName, Object result) {
        Logger.debug("RETURN {0}", result);
    }

    @Override
    public void logDaoMethodThrowing(String callerClassName,
            String callerMethodName, RuntimeException e) {
        Logger.error(e, "THROW {0}", e.toString());
    }

    @Override
    public void logSqlExecutionSkipping(String callerClassName,
            String callerMethodName, SqlExecutionSkipCause cause) {
        Logger.debug(cause.name());
    }

    @Override
    public void logSql(String callerClassName, String callerMethodName,
            Sql<?> sql) {
        Logger.debug(Message.DOMA2076.getMessage(sql.getSqlFilePath(),
                        sql.getFormattedSql()));
    }

    @Override
    public void logLocalTransactionBegun(String callerClassName,
            String callerMethodName, String transactionId) {
        Logger.debug(Message.DOMA2063.getMessage(transactionId));
    }

    @Override
    public void logLocalTransactionEnded(String callerClassName,
            String callerMethodName, String transactionId) {
        Logger.debug(Message.DOMA2064.getMessage(transactionId));
    }

    @Override
    public void logLocalTransactionSavepointCreated(String callerClassName,
            String callerMethodName, String transactionId, String savepointName) {
        Logger.debug(Message.DOMA2065.getMessage(transactionId, savepointName));
    }

    @Override
    public void logLocalTransactionSavepointReleased(String callerClassName,
            String callerMethodName, String transactionId, String savepointName) {
        Logger.debug(Message.DOMA2066.getMessage(transactionId, savepointName));
    }

    @Override
    public void logLocalTransactionCommitted(String callerClassName,
            String callerMethodName, String transactionId) {
        Logger.debug(Message.DOMA2067.getMessage(transactionId));
    }

    @Override
    public void logLocalTransactionRolledback(String callerClassName,
            String callerMethodName, String transactionId) {
        Logger.debug(Message.DOMA2068.getMessage(transactionId));
    }

    @Override
    public void logLocalTransactionSavepointRolledback(String callerClassName,
            String callerMethodName, String transactionId, String savepointName) {
        Logger.debug(Message.DOMA2069.getMessage(transactionId, savepointName));

    }

    @Override
    public void logLocalTransactionRollbackFailure(String callerClassName,
            String callerMethodName, String transactionId, SQLException e) {
        Logger.error(Message.DOMA2070.getMessage(transactionId));
    }

    @Override
    public void logAutoCommitEnablingFailure(String callerClassName,
            String callerMethodName, SQLException e) {
        Logger.debug(e, Message.DOMA2071.getMessage());
    }

    @Override
    public void logTransactionIsolationSettingFailuer(String callerClassName,
            String callerMethodName, int transactionIsolationLevel,
            SQLException e) {
        Logger.error(e, Message.DOMA2072.getMessage(transactionIsolationLevel));
    }

    @Override
    public void logConnectionClosingFailure(String callerClassName,
            String callerMethodName, SQLException e) {
        Logger.error(e, Message.DOMA2073.getMessage());
    }

    @Override
    public void logStatementClosingFailure(String callerClassName,
            String callerMethodName, SQLException e) {
        Logger.error(e, Message.DOMA2074.getMessage());
    }

    @Override
    public void logResultSetClosingFailure(String callerClassName,
            String callerMethodName, SQLException e) {
        Logger.error(e, Message.DOMA2075.getMessage());
    }

}
