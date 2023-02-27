In deze directory vind je een voorbeeld project met Spring Data
Import het project via File -> New project from existing sources
Selecteer Maven als het extern model

Maak daarna een nieuwe run configuratie aan voor tomcat of jetty en start het project vanuit IntelliJ

Je moet nog een paar dingen aanpassen
 * source\main\resources\database.properties moet je het volgende aanpassen
 	* driver: Zet hier de naam van je database driver (zoals je afgelopen maandag ook hebt gebruikt)
 	* url: Plaats hier de url voor je database (ook hier weer zoals afgelopen maandag gedaan is)
 	* user: je database user
 	
 	* insert into people values
(1, 'Vlad', 'Boyarskiy'),
(2,'Oksi', ' Bahatskaya'),
(3,'Vadim', ' Vadimich');* password: password voor de database user
 	* hibernate.dialect: dialect voor je database. Voor mySql is dit org.hibernate.dialect.MySQLDialect

 * In pom.xml moet je, indien je geen Postgresql gebruikt deze sectie aanpassen
```
 <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>${postgres.version}</version>
        </dependency>
```
De sectie voor MySQL ziet er als volgt uit
```
<dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>5.1.31</version>
    </dependency>
```

* Je moet in de database een tabel aanmaken via het volgende script
```
create table students (
id serial not null primary key,
first_name varchar(20) not null,
family_name varchar(50) not null,
);
```


* Je moet het onderstaande script uitvoeren om voorbeeld data in de tabel te laden
```
insert into people values
(1, 'Wim', 'De Vries'),
(2, 'Arjen', 'Oksema'),
(3, 'Klaas', 'Jonker');
```

* Je kunt de gegevens opvragen door een GET request te sturen naar <jouw_root_url>\rest\students (bijvoorbeeld http://localhost:8080/rest/students)

* Je kunt gegevens toevoegen door een POST request met een JSON body content te sturen.


Nog een paar laatste opmerkingen
* Dit project vereist Java7. JavaAssist (een bytecode modifier) die in het project zit gaan niet goed om met Java8. Je kunt een nieuwe versie van deze bibliotheek installeren door de pom entry bij te werken indien je met Java8 wilt werken
* Het database werk gebeurd in StudentRepositry die overerft van CrudRepository. Indien je wilt experimenteren dan kun besluiten om de JpaRepository te gebruiken die overerft van CrudRepository en PagingAndSortingRepository
* De configuratie van de database instellingen gebeurd in de DataConfig class. Let op zaken als @EnableJpaRepositories en @PropertySource


