package com.Dmitry_Elkin.PracticeTaskCRUD;




import com.Dmitry_Elkin.PracticeTaskCRUD.view.MainView;
import org.flywaydb.core.Flyway;


public class AppMain {
//    private static final Logger logger = LoggerFactory.getLogger(AppMain.class);

    private static final String USER = "root";
    private static final String PASS = "dingo1975";
//    private static final String URL = "jdbc:mysql://localhost:3306/proselyte_developers_hibernate_db";
    private static final String URL = "jdbc:postgresql://localhost:5432/proselyte_developers_hibernate_db";



    public static void main(String[] args) {



        System.out.println("Start...");

        flyWayMigrations();

        MainView cli = new MainView();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nstarting...");
        cli.upLevelMenu();
    }

    public static void flyWayClean(){
        var flyWay = Flyway.configure()
                .cleanDisabled(false)
                .dataSource(URL, USER, PASS)
                .locations("classpath:/db/migration")
                .load();
        flyWay.clean();
    }

    public static void flyWayMigrations(){
//        logger.info("db migration started...");
        var flyWay = Flyway.configure()
                .dataSource(URL, USER, PASS)
                .locations("classpath:/db/migration")
                .load();
        flyWay.migrate();
    }

}
