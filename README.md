# cloudstartGKK Matrikelnummer:
8448455
1813189
9305041


Team notes:
## Getting started

Ordnerstruktur/wichtige Files:
  

    - ./backup                  sql dumps
    - ./frontend                client bzw. nginx html 
    - ./dev                     nginx (webserver) Konfiguration, SSL-Zertifikat, hosts
    - ./src                     Backend
    - ./src/main                Backend Logik, REST API und Entity-Klassen
    - ./src/resources           JPA-Konfiguration persistence.xml
    - ./src/webapp              Servlet Konfiguration web.xml
    - ./pom.xml                 Backend Libaries und Abhängikeiten für Maven
    - ./docker-compose.yml      Docker Compose File welcher die Applikationsteile definiert
    - ./init.sh                 Script zum starten der Applikation

  



1. `bash init.sh`
2. tomcat starten
3. https://local.egotec.com  -> Frontend
4. https://local.egotec.com/api/hello/world -> Beispiel REST-Ressource

## Aufgaben

Baue eine TODO-Liste Applikation

1. TodoAPI.kt File erweitern um fehlende REST Schnittstellen  (siehe TODO im genannten File)
2. Frontend für CRUD Operationen bauen mit einer Technik deiner Wahl (siehe TODO in ./frontend/index.html)
