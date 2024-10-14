package config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Override
    protected String getKeyspaceName() {
        return "historialmedico";
    }

    @Bean
    public CqlSession cqlSession() {
        return CqlSession.builder()
                .withLocalDatacenter("datacenter1") // Cambia "datacenter1" por el nombre correcto de tu datacenter
                .build();
    }
}
