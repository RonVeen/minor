package nl.quintor.jpa.model;

import nl.quintor.jpa.AppConfigCore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ron on 05/12/2016.
 */
public class TemplateRunner {

    public static void main(String... args) {
        new TemplateRunner().run2();
        System.exit(0);
    }

    private void run2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigCore.class);
        list(context);
    }


    private  void run() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        list(context);
    }


    private void list(ApplicationContext context) {
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        JdbcTemplate template = new JdbcTemplate(dataSource);
        List<String> names = template.query("select first_name, last_name from employees", new ResultSetExtractor<List<String>>() {
            @Override
            public List<String> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<String> results = new ArrayList();
                while (resultSet.next()) {
                    results.add(resultSet.getString(1) +
                                " " +
                                resultSet.getString(2));
                }
                return results;
            }
        });
        names.forEach( s -> System.out.println(s));

    }
}
