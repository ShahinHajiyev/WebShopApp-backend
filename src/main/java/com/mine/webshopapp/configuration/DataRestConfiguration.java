package com.mine.webshopapp.configuration;

import com.mine.webshopapp.entity.Country;
import com.mine.webshopapp.entity.ProductCategoryEntity;
import com.mine.webshopapp.entity.ProductEntity;

import com.mine.webshopapp.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class DataRestConfiguration implements RepositoryRestConfigurer {

    //Class to make app READ-only
    //we just excluding some request types

    private EntityManager entityManager;

    @Autowired
    public DataRestConfiguration(EntityManager manager) {

        entityManager = manager;

    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        //RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        HttpMethod[] excludedRequests = {HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.POST};


        disableHttpMethods(ProductEntity.class, config, excludedRequests);
        disableHttpMethods(ProductCategoryEntity.class, config, excludedRequests);
        disableHttpMethods(Country.class, config, excludedRequests);
        disableHttpMethods(State.class, config, excludedRequests);


        config.exposeIdsFor(entityManager.getMetamodel()
                .getEntities().stream()
                .map(e -> e.getJavaType())
                .collect(Collectors.toList())
                .toArray(new Class[0]));

    }

    private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] excludedRequests) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(excludedRequests))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(excludedRequests));
    }

/*    private void exposeId(RepositoryRestConfiguration config) {

        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        List<Class> entityClasses = new ArrayList<>();

        for (EntityType tempEntiityType : entities) {
            entityClasses.add(tempEntiityType.getJavaType());
        }

        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }*/
}
