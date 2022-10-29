# Exercise 1
**[7 pkt] (Układ równań):** Państwa zadaniem jest napisanie programu, który będzie
umożliwiał rozwiązanie układu równań z dwiema niewiadomymi. Przyjmujemy, że równania mają
postać następującą:
- ax + by = c
- dx + ey = f

Do rozwiązania układu równań proszę skorzystać z metody wyznaczników (informacje o tej metodzie,
można odnaleźć pod adresem [https://www.matemaks.pl/metoda-wyznacznikow.html](https://www.matemaks.pl/metoda-wyznacznikow.html). Opracowana
przez Państwa klasa powinna posiadać następujące elementy:
- Konstruktor, który przyjmie parametry a,b,c,d,e,f – zakładamy, że są to dowolne wartości
rzeczywiste.
- Metodę, która wypisze na konsolę układ równań tak jak zostało to zaprezentowane powyżej.
- Metodę obliczającą (i zwracającą) wyznacznik główny W.
- Metodę obliczającą (i zwracającą) wyznacznik Wx.
- Metodę obliczającą (i zwracającą) wyznacznik Wy.
- Metodę, która wyznaczy wartości x,y i zwróci je w formie tablicy dwuelementowej. Jeżeli układ
nie posiada żadnych rozwiązań, metoda powinna zwrócić wartość null (układ sprzeczny lub
brak jednoznacznego rozwiązania).

# Exercise 2
**[3 pkt] (Wizualizacja)**: Na podstawie przykładu Example.java (plik znajduje się w katalogu resources) oraz dokumentacji znajdującej się na oficjalnych stronach języka Java (klas: Graphics,
Graphics2D) oraz tutorialu dla Graphics2D [https://docs.oracle.com/javase/tutorial/2d/index.html](https://docs.oracle.com/javase/tutorial/2d/index.html),
należy dodać do klasy metodę, która utworzy plik PNG ilustrujący proste składające się na układ równań
z zaznaczonym rozwiązaniem (o ile istnieje). Nazwa i wymiary obrazka mają być parametrami metody.