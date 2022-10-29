# Exercise 1
**[3 pkt] (Reprezentacja pojedynczej książki):** Państwa zadaniem jest opracowanie klasy,
która będzie reprezentować pojedynczą książkę. Każda książka powinna być opisana przez dwa pola
(przekazywane podczas konstrukcji obiektu) – Numer ID oraz tytuł. Proszę przechować te informacje
w polach typu prywatnego. Ponadto, w ramach klasy powinny znaleźć się metody umożliwiające
pobranie ID i tytułu oraz ich nadpisanie (metody typu get/set dla każdej informacji). Jeżeli widzą
Państwo konieczność dodania innych pól – proszę je również przygotować jako pola prywatne.

Dodatkowo, proszę utworzyć metodę statyczną, która zwróci liczbę utworzonych (od początku działania
programu) obiektów typu Book. Proszę pokazać poprawność działania metody.
# Exercise 2
**[4 pkt] (Reprezentacja systemu bibliotecznego):** Proszę zaimplementować system
biblioteczny działający przy wykorzystaniu drzewa binarnego (proszę popatrzeć na linki znajdujące się
na początku instrukcji). Głównym elementem systemu ma być klasa Library, która będzie
przechowywała obiekty klasy Book w strukturze podanej powyżej. W klasie Library wszystkie pola
powinny być prywatne. Klasa Library powinna zawierać następujące elementy:
- Konstruktor klasy (bezparametrowy) – napisany samodzielnie lub z wykorzystaniem
konstruktora domyślnego.
- Metodę add(Book book) – metoda ta powinna dodawać książkę do biblioteki. Jeżeli w
bibliotece znajduje się już taka książka (rozpoznajemy to po identyfikatorze numerycznym ID),
wtedy powinniśmy otrzymać ostrzeżenie (np. „This book was previously added to the library”)
– poza wypisaniem ostrzeżenia program nie powinien wprowadzić kopii do struktury drzewa.
- Metodę wypisującą zawartość biblioteki w następującej formie:
```
-- ID_1 Polowanie na Czerwony Październik
  -- ID_2 Czas Patriotów
     -- ID_3 Cardiovascular Biomechanics
  -- ID_4 Hands on Julia Programming
     -- ID_5 Math for programmers
        -- ID_6 Deep Learning for Biometrics
```
Gdzie ID_1, ID_2, ID_3, ID_4… etc. stanowią identyfikatory numeryczne poszczególnych
książek.
# Exercise 3
**[3 pkt] (Pomiar czasu wykonania poszczególnych operacji):** Dopisz metodę
findBookById(int id), która będzie miała za zadanie odnaleźć książkę po numerze
identyfikacyjnym. Jeżeli nie zostanie znaleziona żadna książka, niech metoda zwraca null. Ponadto,
zmierz czas wykonania metody. Pomocą mogą być informacje znajdujące się pod adresem
[https://www.baeldung.com/java-measure-elapsed-time](https://www.baeldung.com/java-measure-elapsed-time).