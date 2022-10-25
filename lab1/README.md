# Exercise 1
Napisz program, który:

- (3 pkt.) generuje klucz publiczny (e,n) i prywatny (d,n) RSA, wychodząc od dwóch liczb pierwszych: p=397,q=103;
- (3 pkt.) koduje wyraz podany jako parametr wywołania programu przy pomocy algorytmu RSA;
- (3 pkt.) odszyfrowuje zakodowany wcześniej wyraz (dla testu).
Wskazówki:

I. Generowanie kluczy. Obliczamy kolejno:
- n=p⋅q
- ϕ(n)=(p−1)(q−1)
- e – niewielka liczba nieparzysta względnie pierwsza z ϕ(n); proszę ją obliczyć jako najmniejszą nieparzystą liczbę spełniającą NWD(e,ϕ(n)) = 1. Przypominam algorytm Euklidesa (lub: odpowiednia metoda klasy BigInteger):
```
Euclid(a, b)
1. while b ≠ 0
2.       do temp ← a mod b
3.          a ← b
4.          b ← temp
5. return a
```
- d – multiplikatywna odwrotność   emodϕ(n), tj. liczba naturalna spełniająca równanie:   (d⋅e)modϕ(n)=1. Znajdujemy ją np. dzięki rozszerzonemu algorytmowi Euklidesa (wywołanemu dla argumentów e oraz ϕ(n)):
```
extendedEuclid(a, b)
1.  x0 ← 1
2.  x ← 0
3.  b0 ← b
4.  while b ≠ 0
5.        do q ← ⌊a/b⌋
6.           temp ← x
7.           x ← x0 - q · x
8.           x0 ← temp
9.           temp ← a mod b
10.          a ← b
11.          b ← temp
12. if x0 < 0
13.    then x0 ← x0 + b0
14. return x0
```
II. Kodowanie
- Przed szyfrowaniem: każdą z wejściowych liter konwertujemy na liczbę (np.: zgodnie z kodowaniem UTF-16 – wystarczy zwykłe rzutowanie kolejnych znaków łańcucha na typ całkowity albo metoda getBytes z klasy String).
- Szyfrowanie przy pomocy klucza publicznego: dla każdej liczby t (≡ litery) wykonujemy: c=temodn.
- Uwaga na wyjście poza zakres! Przydatny algorytm szybkiego potęgowania z dzieleniem modulo – gotowy w klasie BigInteger lub według pseudokodu:
```
powMod(t, e, n)
1. y ← 1
2. for k ← m-1 downto 0 // m = liczba bitów liczby e
3.     do y ← y · y mod n
4.        if e_k == 1 // e_k = k-ty bit liczby e (na pozycji k)
5.           then y ← y · t mod n
6. return y
```
III. Dekodowanie
- Deszyfrowanie przy pomocy klucza prywatnego: dla każdej zakodowanej liczby c wykonujemy: cdmodn. Wynik powinien zgadzać się z wejściową liczbą (literą) t
