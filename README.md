Installatie handleiding

Backend:
Over MakersMarkt:
Welkom, dit is de GitHub repository voor makersmarkt en is ontwikkeld tijden de bootcamp die ik volgde bij NOVI Hogeschool.
Hiervoor heb ik ook een frontend applicatie gebouwd. Deze is hier te vinden: git@github.com:Jessyva/eindopdracht-frontend-makersmarkt.git

Installation
Download and install IntelliJ or any other appropriate IDE.
Install PGAdmin 4
Open de backend in IntelliJ IDEA: Start IntelliJ IDEA en selecteer ‘Open’ om het uitgepakte zip-bestand map te openen als een bestaand project.
Configureer de PostgreSQL Database: Zorg ervoor dat PostgreSQL is geïnstalleerd en draait op je systeem. Maak een nieuwe database aan (bijvoorbeeld MakersMarkt) en onthoud de verbindingsgegevens (URL, gebruikersnaam, wachtwoord).
Pas de database-instellingen aan: Ga naar src/main/resources/application.properties in IntelliJ IDEA. Configureer de database-instellingen: spring.datasource.url=jdbc:postgresql://localhost:5432/mydatabase
 spring.datasource.username=your_username spring.datasource.password=your_password
Build de backend: Open de terminal in IntelliJ. Voer het volgende commando uit om de backend te builden en dependencies te downloaden:
MVN CLEAN INSTALL
Start de backend server:
Klik op de ‘Run’ knop in IntelliJ IDEA om de Spring Boot applicatie te starten.
De backend server zou nu moeten draaien op http://localhost:5432.
