# setLED

## Einführung

setLED ist ein kleines Java Programm, um [LoDi-Light-Operator 4-C-LED](https://www.lokstoredigital.de/hardware/schalten/lodi-operator-4-c-led/), angeschlossen an [LoDi-Shift-Commander](https://www.lokstoredigital.de/hardware/schalten/lodi-shift-commander/), aus TrainController™ heraus zu steuern.

## Randbedingungen

setLED prüft die Eingabe-Parameter nicht. Eine falsche Eingabe führt zu einer Java Exception. 

## Hinweis

Um setLED unsichtbar aus TrainController™ heraus zu starten, kann das Programm  [RunHidden.exe](https://www.robvanderwoude.com/csharpexamples.php#RunHidden) benutzt werden. Andernfalls sieht man ein schwarzes Command Fenster solange setLED ausgeführt wird. 

## Schritt für Schritt Anleitung

Dieses Beispiel geht davon aus, dass das setLED.class Java Programm installiert ist im Ordner `%USERPROFILE%\Documents\setLED`. Das entspricht bei mir lokal `C:\Users\Dirk\Documents\setLED`. Dabei ist `Dirk` der Benutzer mit dem ich mich am PC anmelde.  

### 1. Dateien 

In den neuen Ordner `setLED` diese Dateien kopieren.

![](images/2.JPG)

### 2. IP-Adresse setzen

In der Datei `setLED.bat` die IP-Adresse des LoDi-Shift-Commander eintragen.

### 3. Windows Pfad anpassen

Dient dazu, damit man in TrainController™ keinen Pfad eingegeben werden muss. Dazu in Windows suchen nach "Erweiterte Systemeinstellungen anzeigen". Dann wählen "Umgebungsvariablen". Dann `Path`unter "Systemvariablen" bearbeiten und Pfad von `setLED`hinzufügen.

![](images/1.JPG)

### 4. Übersicht Beispieldatei TC

Voraussetzung TC 90 B3 Gold

![](images/3.JPG)

### 5. TC Ein/Ausschalter anlegen

Operationen beim Einschalten

![](images/6.JPG)

Operationen beim Ausschalten

![](images/7.JPG)

- `setLED.bat 0 1` schaltet die Raumlicht-Kurve 1 bei Modul 0 ein.
- `setLED.bat 08:00` setzt die LoDi-Shift-Commander Zeit auf 8:00 Uhr.
- `setLED.bat 0 0` schaltet das Raumlicht bei Modul 0 aus.

### 6. TC Macro zum Blitzen anlegen

Operationen

![](images/4.JPG)

Bedingungen

![](images/5.JPG)

Das Macro wird dann in den Fahrplan um 23:00 eingetragen.

## Links

Diskussion dazu im [Lodi-Forum](https://www.lodi-forum.de/t345f18-LoDi-Operator-C-LED-und-TC.html)


