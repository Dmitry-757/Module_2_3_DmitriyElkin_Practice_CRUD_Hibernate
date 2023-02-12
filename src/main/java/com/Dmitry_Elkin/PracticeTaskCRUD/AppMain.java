package com.Dmitry_Elkin.PracticeTaskCRUD;



import com.Dmitry_Elkin.PracticeTaskCRUD.repository.Hibernate.HibernateUtil;
import com.Dmitry_Elkin.PracticeTaskCRUD.view.MainView;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.Metamodel;
import org.flywaydb.core.Flyway;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class AppMain {
    private static final Logger logger = LoggerFactory.getLogger(AppMain.class);

    private static final String USER = "root";
    private static final String PASS = "dingo1975";
    private static final String URL = "jdbc:mysql://localhost:3306/proselyte_developers_hibernate_db";



    public static void main(String[] args) {



        System.out.println("Start...");

        flyWayMigrations(URL, USER, PASS);

        MainView cli = new MainView();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }



        System.out.println("\nstarting...");
//        cli.upLevelMenu();

        Session session = HibernateUtil.getSession();

    }
    public static void flyWayMigrations(String url, String user, String pass){
        logger.info("db migration started...");
        var flyWay = Flyway.configure()
                .dataSource(url, user, pass)
                .locations("classpath:/db/migration")
                .load();
        flyWay.migrate();
        logger.info("db migration ended...");
        logger.info(".....................");
    }
}
