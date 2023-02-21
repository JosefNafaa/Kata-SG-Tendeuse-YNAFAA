Comment Lancer l'application:
``` sh
mvn clean install 
=====
Il y un dossier qui contient les fichiers de tests , ce fichier est dans le projet , il s'appelle "files", le dossier contient 5 fichiers de tests selon les cas de test

Pour lancer l'application de manière autonome avec un fichier de test :

``` sh
mvn exec:java -Dexec.args="files/fichierValide.txt"
```

Pour lancer l'ensemble des tests :

``` sh
mvn test
```


