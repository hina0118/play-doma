package doma;

import javax.sql.DataSource;

import org.seasar.doma.jdbc.DomaAbstractConfig;
import org.seasar.doma.jdbc.JdbcLogger;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.H2Dialect;
import org.seasar.doma.jdbc.tx.LocalTransaction;
import org.seasar.doma.jdbc.tx.LocalTransactionalDataSource;

import play.db.DB;

import play.modules.doma.PlayLogger;

public class AppConfig extends DomaAbstractConfig {

	protected static final LocalTransactionalDataSource dataSource = createDataSource();

	protected static final Dialect dialect = new H2Dialect();

	protected static final JdbcLogger jdbcLogger = new PlayLogger();

	@Override
	public DataSource getDataSource() {
		return dataSource;
	}

	@Override
	public Dialect getDialect() {
		return dialect;
	}

	@Override
	public JdbcLogger getJdbcLogger() {
		return jdbcLogger;
	}

	protected static LocalTransactionalDataSource createDataSource() {
		return new LocalTransactionalDataSource(DB.datasource);
	}

	public static LocalTransaction getLocalTransaction() {
		return dataSource.getLocalTransaction(jdbcLogger);
	}
}