**Buliga Theodor Ioan**
**323 CA**

## POO TV - Etapa 2

### Descriere:

* Etapa a doua din cadrul proiectului reprezinta adaugarea unor
  functionalitati noi la structura platformei de streaming video creata
  la etapa anterioara. Eu am ales, totusi, sa pornesc de la zero in
  aceasta implementare, intrucat nu am fost multumit cu structura vechiului
  proiect. Am refolosit anumite bucati de cod din prima parte, insa
  structura este mult mai diferita si m-am axat mai mult pe design poo.
  
* Clasele in care se va face citirea din Json consider ca nu necesita 
  explicatii suplimentare, fiindca au ramas in mare parte la fel, de
  data asta, insa, au fost de tipul final. Clasele de Login, respectiv
  Register sunt si ele la fel ca in prima etapa, doar ca de data asta
  se regasesc in pachetul functionalities.

  Pachetul functionalities
   Aici apar primele diferente, intrucat am ales sa implementez clasa
  Filter, folosind design patternul strategy, deoarece consider
  ca filtrarea se poate face folosind doi algoritmi diferiti(aproape chiar
  trei, insa in implementarea am ales pentru optiunea care mi-a fost cel
  mai rapid de rezolvat, fiind in criza de timp). Filtrarea se face fie
  in functie de actor sau de gen, fie de ambele, iar asa am ales sa
  sa implementez si cele doua strategii. Tot in jurul claselor de
  functionalities, am folosit un alt design pattern, factory,
  pentru a crea una din cele strategii (respectiv Filter1 sau Filter2)
  in functie de datele de intrare.
   Algoritmii au ramas la fel ca in prima etapa, implementarea a fost
  cea diferita.

  In directorul src:
* Clasa de Output: 

   Am ales sa schimb putin clasa Output, folosind design patternul
  singleton, fiindca folosesc o singura instanta a clasei Output, care
  apeleaza una din cele trei metode (eroare, standard sau final). Fata
  de etapa trecuta, aici am adaugat cea de-a treia metoda, finalOutput,
  care afiseaza mesajele pentru utilizatorii premium.

* In clasa Main se realizeaza citirea din fisierele Json si
  generarea datelor de iesire. Aici sunt declarate obiectele
  pe care le-am folosit aproape peste tot in implementare si
  tot aici se apeleaza si principalele comenzi.

* In mare parte acestea au fost diferentele fata de etapa trecuta,
  unele functionalitati lipsesc, fiinda dupa cum spuneam, am reluat
  tot proiectul de la zero si nu am mai vazut cum sa le implementez
  eficient. 
  
### Comentarii asupra temei:

* Sunt sigur ca putea exista o implementare mult mai buna si 
  sunt constient de punctele slabe ale temei. Puteam sa adaug toate
  functionalitatile, sa ma axez mai mult pe repartizarea in clase,
  sa modularizez mai bine codul, sa eficientizez utilizarea memoriei
  si viteza de executie si as fi putut sa am un desgin poo mult mai bun.
  As fi vrut sa am si mai multe design patternuri, insa timpul nu a fost
  de partea mea,
* Am invatat, insa, sa imi organizez codul mult mai bine, sa abstractizez
  mult mai bine cerintele si cel mai important, am invatat destul de bine,
  consider eu, sa folosesc desgin patternuri. In acelasi timp, am aprofundat
  materia si m-a ajutat sa ma simt mai sigur pe mine si mai pregatit pentru
  examen.
* Mi-a placut tema si mi s-a parut foarte bine gandita. Mi-a placut
  mult ca a existat si un "rewind" al primei etape si o structura
  a site-ului. A fost una dintre cele mai interesante teme din semestrul
  acesta si chiar pot sa zic ca am lucrat cu mare placere. Indicatiile
  au fost foarte precise, la obiect si au ajutat mult. Mi s-a parut
  o tema bine gandita si planificata, iar faptul ca termenul de predare
  a fost apropiat de sesiune este un mare plus(ajuta mult la pregatirea
  pentru examen).

### Resurse / Bibliografie:

1. (www.digitalocean.com/community/tutorials/factory-design-pattern-in-java)
2. (https://ocw.cs.pub.ro/courses/poo-ca-cd/laboratoare/design-patterns)
3. (https://ocw.cs.pub.ro/courses/poo-ca-cd/laboratoare/visitor)


