package hello;

import hello.entity.User;
import hello.utils.HibernateUtil;
import org.apache.catalina.session.FileStore;
import org.apache.catalina.session.PersistentManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.Arrays;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application implements CommandLineRunner {
    private Log log = LogFactory.getLog(Application.class);
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return factory -> {
            TomcatEmbeddedServletContainerFactory containerFactory = (TomcatEmbeddedServletContainerFactory) factory;
            containerFactory.setTomcatContextCustomizers(Arrays.asList(context -> {
                final PersistentManager persistentManager = new PersistentManager();
                final FileStore store = new FileStore();

                final String sessionDirectory = makeSessionDirectory();
                log.info("Writing sessions to " + sessionDirectory);
                store.setDirectory(sessionDirectory);

                persistentManager.setStore(store);
                context.setManager(persistentManager);
            }));
        };
    }

    private String makeSessionDirectory() {
        final String cwd = System.getProperty("user.dir");
        return cwd + File.separator + "sessions";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            User newUser = new User("User", "One", "User1",
                    "User1@mail.com", "pass", "1234567800");
            session.saveOrUpdate("User", newUser);
            transaction.commit();

        } catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.closeSessionFactory();
        }

    }
}
