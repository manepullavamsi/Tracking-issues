package com.experiment.experience.springbootfeatures.utility;

/*public class Mutiple_DataSource_Config_ref {
}*/
import java.util.Objects;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/** Configuration class for Postgres db */
@Configuration
@EnableTransactionManagement
@EnableAutoConfiguration
@EnableJpaRepositories(
        entityManagerFactoryRef = "managerFactory",
        transactionManagerRef = "transactionManager",
        basePackages = {"com.company.workplace.shared.platform.plan.repository"})
@RequiredArgsConstructor
public class PostgresDataSourceConfig_Ref {
    private final Environment environment;

    @Bean(name = "batchDataSource")
    public DataSource batchDataSource() {
        DriverManagerDataSource dataSource =
                new DriverManagerDataSource(
                        Objects.requireNonNull(
                                environment.getProperty("spring.datasource.jdbc-url")),
                        Objects.requireNonNull(
                                environment.getProperty("spring.datasource.username")),
                        Objects.requireNonNull(
                                environment.getProperty("spring.datasource.password")));
        dataSource.setDriverClassName(
                Objects.requireNonNull(
                        environment.getProperty("spring.datasource.driver-class-name")));
        dataSource.setSchema("batch_load");
        return dataSource;
    }

    @Bean(name = "batchEntityManager")
    @Qualifier("batchEntityManager")
    public EntityManager batchEntityManager() {
        return Objects.requireNonNull(managerFactory().getObject()).createEntityManager();
    }

    @Bean(name = "managerFactory")
    public LocalContainerEntityManagerFactoryBean managerFactory() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
        var emf = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        emf.setDataSource(batchDataSource());
        emf.setJpaVendorAdapter(vendorAdapter);
        emf.setPackagesToScan("com.company.workplace.shared.platform.plan.entity");
        emf.setPersistenceUnitName("batchLoad");
        emf.setJpaProperties(properties);
        emf.afterPropertiesSet();
        return emf;
    }

    @Bean(name = "transactionManager")
    @Qualifier("transactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("managerFactory")
                    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(entityManagerFactoryBean.getObject());
        return new JpaTransactionManager(Objects.requireNonNull(tm.getEntityManagerFactory()));
    }
}
