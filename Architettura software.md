# Software-engineering-2021-22-gruppo-8

Il linguaggio di sviluppo scelto è Java JDK 8, mentre come IDE verrà utilizzato NetBeans; le librerie esterne necessarie sono javafx. e java.util. Verrà utilizzato lo stile CamelCase per la denominazione delle variabili, verrà utilizzata l'indentazione per favorire la leggibilità del codice, ogni metodo dovrà essere commentato (definendo i vari parametri, cosa ritorna e la funzionalità). 

L'architettura software scelta per lo sviluppo è la Model-View-Controller tramite JavaFX che utilizza il linguaggio di markup FXML in combinazione con Java. Il "Modello" consiste nella specifica applicazione dell'oggetto di dominio, conterrà quindi l'implementazione dello stack per la memorizzazione degli operandi e dei risultati e l'implementazoine della struttura dati per memorizzare le variabili. La "View" consiste nel file FXML, creato tramite JavaFXSceneBuilder e definirà la GUI della calcolatrice. Il "Controller" è il codice Java che definisce il comportamento dell'interfaccia che interagisce con l'utente, conterrà le varie funzioni per le operazioni tra gli operandi, inserimento di questi nello stack, modifica dei valori dello stack.


Definition of Done:
Una storia è finita se:
1) Tutti i task sono stati ultimati, secondo la definition of done per task
2) Sono verificati gli acceptance criteria
Un task è ultimato se:
1) La sua funzionalità è stata implementata completamente
2) Supera gli n test case previsti, dove n è calcolata tramite la formula della complessità ciclomatica
