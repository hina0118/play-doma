package play.modules.doma;

import java.sql.SQLException;

import org.seasar.doma.jdbc.JdbcLogger;
import org.seasar.doma.jdbc.Sql;
import org.seasar.doma.jdbc.SqlExecutionSkipCause;
import org.seasar.doma.message.Message;

import play.Logger;

/**
 * Domaが出力するログをPlayのログに出力するJdbcLoggerの実装クラス
 */
public class PlayLogger implements JdbcLogger {
	
	/**
	 * Daoメソッドの実行開始を記録します
	 * 
	 * @param callerClassName
	 * @param callerMethodName
	 * @param args
	 */
	@Override
	public void logDaoMethodEntering(String callerClassName,
			String callerMethodName, Object... args) {
		Logger.debug("ENTRY");
	}

	/**
	 * Daoメソッドの実行終了を記録します
	 * 
	 * @param callerClassName
	 * @param callerMethodName
	 * @param result
	 */
	@Override
	public void logDaoMethodExiting(String callerClassName,
			String callerMethodName, Object result) {
		Logger.debug("RETURN {0}", result);
	}

	/**
	 * Daoメソッドの実行時例外による実行終了を記録します
	 * 
	 * @param callerClassName
	 * @param callerMethodName
	 * @param e
	 */
	@Override
	public void logDaoMethodThrowing(String callerClassName,
			String callerMethodName, RuntimeException e) {
		Logger.error(e, "THROW {0}", e.toString());
	}

	/**
	 * SQLの実行がスキップされたことを記録します
	 * 
	 * @param callerClassName
	 * @param callerMethodName
	 * @param cause
	 */
	@Override
	public void logSqlExecutionSkipping(String callerClassName,
			String callerMethodName, SqlExecutionSkipCause cause) {
		Logger.debug(cause.name());
	}

	/**
	 * 実行するSQLを記録します
	 * 
	 * @param callerClassName
	 * @param callerMethodName
	 * @param sql
	 */
	@Override
	public void logSql(String callerClassName, String callerMethodName,
			Sql<?> sql) {
		Logger.debug(Message.DOMA2076.getMessage(sql.getSqlFilePath(),
						sql.getFormattedSql()));
	}

	/**
	 * ローカルトランザクションの開始を記録します
	 * 
	 * @param callerClassName
	 * @param callerMethodName
	 * @param transactionId
	 */
	@Override
	public void logLocalTransactionBegun(String callerClassName,
			String callerMethodName, String transactionId) {
		Logger.debug(Message.DOMA2063.getMessage(transactionId));
	}

	/**
	 * ローカルトランザクションの終了を記録します
	 * 
	 * @param callerClassName
	 * @param callerMethodName
	 * @param transactionId
	 */
	@Override
	public void logLocalTransactionEnded(String callerClassName,
			String callerMethodName, String transactionId) {
		Logger.debug(Message.DOMA2064.getMessage(transactionId));
	}

	/**
	 * ローカルトランザクションのセーブポイントの作成を記録します
	 * 
	 * @param callerClassName
	 * @param callerMethodName
	 * @param transactionId
	 * @param savepointName
	 */
	@Override
	public void logLocalTransactionSavepointCreated(String callerClassName,
			String callerMethodName, String transactionId, String savepointName) {
		Logger.debug(Message.DOMA2065.getMessage(transactionId, savepointName));
	}

	/**
	 * ローカルトランザクションのセーブポイントの削除を記録します
	 * 
	 * @param callerClassName
	 * @param callerMethodName
	 * @param transactionId
	 * @param savepointName
	 */
	@Override
	public void logLocalTransactionSavepointReleased(String callerClassName,
			String callerMethodName, String transactionId, String savepointName) {
		Logger.debug(Message.DOMA2066.getMessage(transactionId, savepointName));
	}

	/**
	 * ローカルトランザクションのコミットを記録します
	 * 
	 * @param callerClassName
	 * @param callerMethodName
	 * @param transactionId
	 */
	@Override
	public void logLocalTransactionCommitted(String callerClassName,
			String callerMethodName, String transactionId) {
		Logger.debug(Message.DOMA2067.getMessage(transactionId));
	}

	/**
	 * ローカルトランザクションのロールバックを記録します
	 * 
	 * @param callerClassName
	 * @param callerMethodName
	 * @param transactionId
	 */
	@Override
	public void logLocalTransactionRolledback(String callerClassName,
			String callerMethodName, String transactionId) {
		Logger.debug(Message.DOMA2068.getMessage(transactionId));
	}

	/**
	 * ローカルトランザクションのセーブポイントのロールバックを記録します
	 * 
	 * @param callerClassName
	 * @param callerMethodName
	 * @param transactionId
	 * @param savepointName
	 */
	@Override
	public void logLocalTransactionSavepointRolledback(String callerClassName,
			String callerMethodName, String transactionId, String savepointName) {
		Logger.debug(Message.DOMA2069.getMessage(transactionId, savepointName));

	}

	/**
	 * ローカルトランザクションのロールバックの失敗を記録します
	 * 
	 * @param callerClassName
	 * @param callerMethodName
	 * @param transactionId
	 * @param e
	 */
	@Override
	public void logLocalTransactionRollbackFailure(String callerClassName,
			String callerMethodName, String transactionId, SQLException e) {
		Logger.error(Message.DOMA2070.getMessage(transactionId));
	}

	/**
	 * {@link Connection#setAutoCommit(boolean)} の引数に {@code true} を渡した時に発生した
	 * {@link SQLException} を記録します。
	 * 
	 * @param callerClassName
	 * @param callerMethodName
	 * @param e
	 */
	@Override
	public void logAutoCommitEnablingFailure(String callerClassName,
			String callerMethodName, SQLException e) {
		Logger.debug(e, Message.DOMA2071.getMessage());
	}

	/**
	 * {@link Connection#setTransactionIsolation(int)} 時に発生した
	 * {@link SQLException} を記録します。
	 * 
	 * @param callerClassName
	 * @param callerMethodName
	 * @param transactionIsolationLevel
	 * @param e
	 */
	@Override
	public void logTransactionIsolationSettingFailuer(String callerClassName,
			String callerMethodName, int transactionIsolationLevel,
			SQLException e) {
		Logger.error(e, Message.DOMA2072.getMessage(transactionIsolationLevel));
	}

	/**
	 * {@link Connection#close()} 時に発生した {@link SQLException} を記録します
	 * 
	 * @param callerClassName
	 * @param callerMethodName
	 * @param e
	 */
	@Override
	public void logConnectionClosingFailure(String callerClassName,
			String callerMethodName, SQLException e) {
		Logger.error(e, Message.DOMA2073.getMessage());
	}

	/**
	 * {@link Statement#close()} 時に発生した {@link SQLException} を記録します
	 * 
	 * @param callerClassName
	 * @param callerMethodName
	 * @param e
	 */
	@Override
	public void logStatementClosingFailure(String callerClassName,
			String callerMethodName, SQLException e) {
		Logger.error(e, Message.DOMA2074.getMessage());
	}

	/**
	 * {@link ResultSet#close()} 時に発生した {@link SQLException} を記録します
	 * 
	 * @param callerClassName
	 * @param callerMethodName
	 * @param e
	 */
	@Override
	public void logResultSetClosingFailure(String callerClassName,
			String callerMethodName, SQLException e) {
		Logger.error(e, Message.DOMA2075.getMessage());
	}

}
