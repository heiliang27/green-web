package com.green.common.config.properties;

import java.time.Duration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {

	/**
	 * Database index used by the connection factory.
	 */
	private int database = 0;

	/**
	 * Connection URL. Overrides host, port, and password. User is ignored.
	 * Example: redis://user:password@example.com:6379
	 */
	private String url;

	/**
	 * Redis server host.
	 */
	private String host = "localhost";

	/**
	 * Login password of the redis server.
	 */
	private String password;

	/**
	 * Redis server port.
	 */
	private int port = 6379;

	/**
	 * Whether to enable SSL support.
	 */
	private boolean ssl;

	/**
	 * Connection timeout.
	 */
	private Duration timeout;

	private final Jedis jedis = new Jedis();

	private final Lettuce lettuce = new Lettuce();

	public int getDatabase() {
		return this.database;
	}

	public void setDatabase(int database) {
		this.database = database;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPort() {
		return this.port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public boolean isSsl() {
		return this.ssl;
	}

	public void setSsl(boolean ssl) {
		this.ssl = ssl;
	}

	public void setTimeout(Duration timeout) {
		this.timeout = timeout;
	}

	public Duration getTimeout() {
		return this.timeout;
	}

	public Jedis getJedis() {
		return this.jedis;
	}

	public Lettuce getLettuce() {
		return this.lettuce;
	}

	/**
	 * Pool properties.
	 */
	public static class Pool {

		/**
		 * Maximum number of "idle" connections in the pool. Use a negative
		 * value to indicate an unlimited number of idle connections.
		 */
		private int maxIdle = 8;

		/**
		 * Target for the minimum number of idle connections to maintain in the
		 * pool. This setting only has an effect if it is positive.
		 */
		private int minIdle = 0;

		/**
		 * Maximum number of connections that can be allocated by the pool at a
		 * given time. Use a negative value for no limit.
		 */
		private int maxActive = 8;

		/**
		 * Maximum amount of time a connection allocation should block before
		 * throwing an exception when the pool is exhausted. Use a negative
		 * value to block indefinitely.
		 */
		private Duration maxWait = Duration.ofMillis(-1);

		public int getMaxIdle() {
			return this.maxIdle;
		}

		public void setMaxIdle(int maxIdle) {
			this.maxIdle = maxIdle;
		}

		public int getMinIdle() {
			return this.minIdle;
		}

		public void setMinIdle(int minIdle) {
			this.minIdle = minIdle;
		}

		public int getMaxActive() {
			return this.maxActive;
		}

		public void setMaxActive(int maxActive) {
			this.maxActive = maxActive;
		}

		public Duration getMaxWait() {
			return this.maxWait;
		}

		public void setMaxWait(Duration maxWait) {
			this.maxWait = maxWait;
		}

	}

	/**
	 * Jedis client properties.
	 */
	public static class Jedis {

		/**
		 * Jedis pool configuration.
		 */
		private Pool pool;

		public Pool getPool() {
			return this.pool;
		}

		public void setPool(Pool pool) {
			this.pool = pool;
		}

	}

	/**
	 * Lettuce client properties.
	 */
	public static class Lettuce {

		/**
		 * Shutdown timeout.
		 */
		private Duration shutdownTimeout = Duration.ofMillis(100);

		/**
		 * Lettuce pool configuration.
		 */
		private Pool pool;

		public Duration getShutdownTimeout() {
			return this.shutdownTimeout;
		}

		public void setShutdownTimeout(Duration shutdownTimeout) {
			this.shutdownTimeout = shutdownTimeout;
		}

		public Pool getPool() {
			return this.pool;
		}

		public void setPool(Pool pool) {
			this.pool = pool;
		}

	}

}
