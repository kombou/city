package org.study.city.configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.study.city.configuration.db.HibernateConfiguration;
import org.study.city.configuration.db.HibernateMysqlConfiguration;
import org.study.city.entity.*;

@Configuration
@ComponentScan("org.study.city.repository")
public class DbConfiguration {
    @Bean
    public SessionFactory sessionFactory() {
        HibernateConfiguration configuration = new HibernateMysqlConfiguration();

        configuration.configure();

        //ajout des tables
        configuration.addClass(User.class);
        configuration.addClass(Compte.class);
        configuration.addClass(Bailleur.class);
        configuration.addClass(Locataire.class);
        configuration.addClass(Categorie.class);
        configuration.addClass(MiniCite.class);
        configuration.addClass(Contrat.class);
        configuration.addClass(Maison.class);
        configuration.addClass(Piece.class);
        configuration.addClass(Notification.class);

        configuration.buildSessionFactory();

        SessionFactory sessionFactory = configuration.sessionFactory();

        return sessionFactory;
    }

}
