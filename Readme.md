### Sztuczna baza danych

Projekt symulujący bazę danych i jej zachowanie. Celem projektu jest użycie go jako zależności w innym projekcie.

Popatrz na klasy, przeczytaj dokumentację interfejsów

Aby użyć projektu jako zależności w innym projekcie to należy:
1) zbudować lokalnie plik JAR. Komenda w konsoli: `mvn clean package` . Wówczas w katalogu target pojawi się plik `dependency-1.0-SNAPSHOT.jar`
2) zaimportować zbudowanego JARa do lokalnego repozytorium mavena w folderze .m2 . Komnenda w konsoli: `mvn install:install-file -Dfile=target/dependency-1.0-SNAPSHOT.jar -DgroupId=myowndependencies -DartifactId=myowndependency -Dversion=1.0 -Dpackaging=jar -DgeneratePom=true` . Wówczas w katalogu .m2 pojawi się nowa zależność.
3) w docelowym projekcie w pom-ie dodać dependency jak w punkcie 4 poniżej i można używać tego projektu tak jak każdej innej zależności.
4)      <dependency>
            <groupId>myowndependencies</groupId>
            <artifactId>myowndependency</artifactId>
            <version>1.0</version>
        </dependency>
