package play.modules.doma;

import java.sql.SQLException;

import org.seasar.doma.jdbc.JdbcLogger;
import org.seasar.doma.jdbc.Sql;
import org.seasar.doma.jdbc.SqlExecutionSkipCause;

import play.Logger;

public class PlayLogger implements JdbcLogger {

	@Override
	public void logAutoCommitEnablingFailure(String arg0, String arg1,
			SQLException arg2) {
		// TODO Auto-generated method stub
	}

	@Override
	public void logConnectionClosingFailure(String arg0, String arg1,
			SQLException arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logDaoMethodEntering(String callerClassName, String callerMethodName, Object... arg2) {
        Logger.info("START %s#%s", callerClassName, callerMethodName);
	}

	@Override
	public void logDaoMethodExiting(String callerClassName, String callerMethodName, Object arg2) {
		Logger.info("END   %s#%s", callerClassName, callerMethodName);
	}

	@Override
	public void logDaoMethodThrowing(String callerClassName, String callerMethodName,
			RuntimeException e) {
		Logger.info("END   %s#%s RuntimeException: %s" + e, callerClassName, callerMethodName, e);
	}

	@Override
	public void logLocalTransactionBegun(String callerClassName, String callerMethodName,
			String transactionId) {
		// TODO Auto-generated method stub
		Logger.info("BIGIN   %s#%s", callerClassName, callerMethodName);
	}

	@Override
	public void logLocalTransactionCommitted(String callerClassName, String callerMethodName,
			String transactionId) {
		// TODO Auto-generated method stub
		Logger.info("COMMIT  %s#%s", callerClassName, callerMethodName);
	}

	@Override
	public void logLocalTransactionEnded(String callerClassName, String callerMethodName,
			String transactionId) {
		// TODO Auto-generated method stub
		Logger.info("END     %s#%s", callerClassName, callerMethodName);
	}

	@Override
	public void logLocalTransactionRollbackFailure(String arg0, String arg1,
			String arg2, SQLException arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logLocalTransactionRolledback(String arg0, String arg1,
			String arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logLocalTransactionSavepointCreated(String arg0, String arg1,
			String arg2, String arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logLocalTransactionSavepointReleased(String arg0, String arg1,
			String arg2, String arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logLocalTransactionSavepointRolledback(String arg0,
			String arg1, String arg2, String arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logResultSetClosingFailure(String arg0, String arg1,
			SQLException arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logSql(String arg0, String arg1, Sql<?> sql) {
        Logger.info("SQL log. sqlFilePath=[%s],%n%s", sql.getSqlFilePath(), sql.getFormattedSql());
	}

	@Override
	public void logSqlExecutionSkipping(String callerClassName, String callerMethodName,
			SqlExecutionSkipCause cause) {
		Logger.info("SKIPPED(%s) %s#%s", cause.name(), callerClassName, callerMethodName);
	}

	@Override
	public void logStatementClosingFailure(String arg0, String arg1,
			SQLException arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logTransactionIsolationSettingFailuer(String arg0, String arg1,
			int arg2, SQLException arg3) {
		// TODO Auto-generated method stub

	}

}
