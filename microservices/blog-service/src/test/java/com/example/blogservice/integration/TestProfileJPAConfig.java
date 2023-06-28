//@Configuration
//@EnableJpaRepositories(basePackages = {
//        "org.baeldung.repository",
//        "org.baeldung.boot.repository"
//})
//@EnableTransactionManagement
//public class H2TestProfileJPAConfig {
//
//    @Bean
//    @Profile("test")
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("sa");
//
//        return dataSource;
//    }
//
//    // configure entityManagerFactory
//    // configure transactionManager
//    // configure additional Hibernate properties
//}

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {
//        Application.class,
//        H2TestProfileJPAConfig.class})
//@ActiveProfiles("test")
//public class SpringBootProfileIntegrationTest {
//    // ...
//}