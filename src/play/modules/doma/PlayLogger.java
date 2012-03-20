package play.modules.doma;

import java.sql.SQLException;

import org.seasar.doma.jdbc.JdbcLogger;
import org.seasar.doma.jdbc.Sql;
import org.seasar.doma.jdbc.SqlExecutionSkipCause;
import org.seasar.doma.message.Message;

import play.Logger;

/**
 * Doma���o�͂��郍�O��Play�̃��O�ɏo�͂���JdbcLogger�̎����N���X
 */
public class PlayLogger implements JdbcLogger {
	
	/**
	 * Dao���\�b�h�̎��s�J�n���L�^���܂�
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
	 * Dao���\�b�h�̎��s�I�����L�^���܂�
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
	 * Dao���\�b�h�̎��s����O�ɂ����s�I�����L�^���܂�
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
	 * SQL�̎��s���X�L�b�v���ꂽ���Ƃ��L�^���܂�
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
	 * ���s����SQL���L�^���܂�
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
	 * ���[�J���g�����U�N�V�����̊J�n���L�^���܂�
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
	 * ���[�J���g�����U�N�V�����̏I�����L�^���܂�
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
	 * ���[�J���g�����U�N�V�����̃Z�[�u�|�C���g�̍쐬���L�^���܂�
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
	 * ���[�J���g�����U�N�V�����̃Z�[�u�|�C���g�̍폜���L�^���܂�
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
	 * ���[�J���g�����U�N�V�����̃R�~�b�g���L�^���܂�
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
	 * ���[�J���g�����U�N�V�����̃��[���o�b�N���L�^���܂�
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
	 * ���[�J���g�����U�N�V�����̃Z�[�u�|�C���g�̃��[���o�b�N���L�^���܂�
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
	 * ���[�J���g�����U�N�V�����̃��[���o�b�N�̎��s���L�^���܂�
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
	 * {@link Connection#setAutoCommit(boolean)} �̈����� {@code true} ��n�������ɔ�������
	 * {@link SQLException} ���L�^���܂��B
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
	 * {@link Connection#setTransactionIsolation(int)} ���ɔ�������
	 * {@link SQLException} ���L�^���܂��B
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
	 * {@link Connection#close()} ���ɔ������� {@link SQLException} ���L�^���܂�
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
	 * {@link Statement#close()} ���ɔ������� {@link SQLException} ���L�^���܂�
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
	 * {@link ResultSet#close()} ���ɔ������� {@link SQLException} ���L�^���܂�
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
