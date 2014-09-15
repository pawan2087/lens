package com.inmobi.grill.client.jdbc;

/*
 * #%L
 * Grill client
 * %%
 * Copyright (C) 2014 Inmobi
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.inmobi.grill.client.GrillConnection;
import com.inmobi.grill.client.GrillConnectionParams;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * JDBC connection class which handles connection level operations to grill server.
 */
public class GrillJdbcConnection implements Connection {


  private final GrillConnection connection;

  public GrillJdbcConnection(String uri, Properties info) {
    GrillConnectionParams params = JDBCUtils.parseUrl(uri);
    connection = new GrillConnection(params);
    connection.open("", "");
  }

  @Override
  public Statement createStatement() throws SQLException {

    return createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_FORWARD_ONLY);
  }

  @Override
  public PreparedStatement prepareStatement(String s) throws SQLException {
    throw new SQLException("Operation not supported!!!");
  }

  @Override
  public Statement createStatement(int resultSetType, int resultSetConcurrency)
      throws SQLException {
    if(resultSetConcurrency != ResultSet.CONCUR_READ_ONLY) {
      throw new SQLException("Statements with resultset concurrency :"
          + resultSetType + " is not supported");
    }
    if(resultSetType == ResultSet.TYPE_SCROLL_SENSITIVE) {
      throw new SQLException("Statements with resultset type: "
          + resultSetType + " is not supported");
    }
    return new GrillJdbcStatement(this);
  }

  @Override
  public PreparedStatement prepareStatement(String sql, int rsType, int rsConcurrency) throws SQLException {
    throw new SQLException("Operation not supported!!!");
  }



  @Override
  public boolean getAutoCommit() throws SQLException {
    return true;
  }

  @Override
  public void close() throws SQLException {

  }

  @Override
  public boolean isClosed() throws SQLException {
    return false;
  }

  @Override
  public DatabaseMetaData getMetaData() throws SQLException {
    return null;
  }


  @Override
  public boolean isReadOnly() throws SQLException {
    return false;
  }

  @Override
  public int getTransactionIsolation() throws SQLException {
    return Connection.TRANSACTION_NONE;
  }

  @Override
  public SQLWarning getWarnings() throws SQLException {
    return null;
  }

  @Override
  public void clearWarnings() throws SQLException {

  }

  @Override
  public String getCatalog() throws SQLException {
    return "";
  }

  public GrillConnection getConnection() {
    return this.connection;
  }

  /*
  Start of not supported operations by JDBC driver.
   */

  @Override
  public Statement createStatement(int rsConcurrency, int rsType, int rsHoldability) throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }

  @Override
  public CallableStatement prepareCall(String s) throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }

  @Override
  public CallableStatement prepareCall(String s, int i, int i2) throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }

  @Override
  public CallableStatement prepareCall(String s, int i, int i2, int i3) throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }


  @Override
  public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
    throw new SQLException("Operation not supported!!!");
  }

  @Override
  public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
    throw new SQLException("Operation not supported!!!");
  }

  @Override
  public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
    throw new SQLException("Operation not supported!!!");
  }

  @Override
  public PreparedStatement prepareStatement(String s, int rsType, int rsConcurrency, int rsHoldability) throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }


  @Override
  public String nativeSQL(String s) throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }

  @Override
  public void setAutoCommit(boolean b) throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }


  @Override
  public void commit() throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }

  @Override
  public void rollback() throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }


  @Override
  public void setReadOnly(boolean b) throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }


  @Override
  public void setCatalog(String s) throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }


  @Override
  public void setTransactionIsolation(int i) throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }


  @Override
  public Map<String, Class<?>> getTypeMap() throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }

  @Override
  public void setTypeMap(Map<String, Class<?>> stringClassMap) throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }

  @Override
  public void setHoldability(int i) throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }

  @Override
  public int getHoldability() throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }

  @Override
  public Savepoint setSavepoint() throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }

  @Override
  public Savepoint setSavepoint(String s) throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }

  @Override
  public void rollback(Savepoint savepoint) throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }

  @Override
  public void releaseSavepoint(Savepoint savepoint) throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }

  @Override
  public Clob createClob() throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }

  @Override
  public Blob createBlob() throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }

  @Override
  public NClob createNClob() throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }

  @Override
  public SQLXML createSQLXML() throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }

  @Override
  public boolean isValid(int i) throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }

  @Override
  public void setClientInfo(String s, String s2) throws SQLClientInfoException {
    throw new SQLClientInfoException("Operation not supported!!!!", null);
  }

  @Override
  public void setClientInfo(Properties properties) throws SQLClientInfoException {
    throw new SQLClientInfoException("Operation not supported!!!!", null);
  }

  @Override
  public String getClientInfo(String s) throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }

  @Override
  public Properties getClientInfo() throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }

  @Override
  public Array createArrayOf(String s, Object[] objects) throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }

  @Override
  public Struct createStruct(String s, Object[] objects) throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }

  public void setSchema(String schema) throws SQLException {
    throw new SQLException("Operation not supported!!!");
  }

  public String getSchema() throws SQLException {
    throw new SQLException("Operation not supported!!!");
  }

  public void abort(Executor executor) throws SQLException {
    throw new SQLException("Operation not supported!!!");
  }

  public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
    throw new SQLException("Operation not supported!!!");
  }

  public int getNetworkTimeout() throws SQLException {
    throw new SQLException("Operation not supported!!!");
  }

  @Override
  public <T> T unwrap(Class<T> tClass) throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }

  @Override
  public boolean isWrapperFor(Class<?> aClass) throws SQLException {
    throw new SQLException("Operation not supported!!!!");
  }
}
