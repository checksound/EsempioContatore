# Esempio Contatore

La classe di tipo `Thread` per eseguire gli incrementi è:
[contatore.v1.Incrementer](./src/contatore/v1/Incrementer.java) che esegue l'incremento di oggetti di tipo [contatore.v1.Counter](./src/contatore/v1/Counter.java)

L'esecuzione di [contatore.v1.TestUnsafeCounter](./src/contatore/v1/TestUnsafeCounter.java).

Il programma attiva due thread ognuno dei quali accede alla variabile di tipo `contatore.v1.Counter`, incrementandone il valore. L'accesso alla variabile è condiviso dai due thread.

Come si vede dall'esecuzione del programma, successive esecuzioni porta a risultati ogni volta diversi, anche di molto: il valore di `counter` dovrebbe essere la somma degli incrementi dei due thread, ma come si vede il valore non corrisponde alla somma, alcune volte ci sono notevoli differenze.

Vedi sotto successive esecuzioni di [contatore.v1.TestUnsafeCounter](./src/contatore/v1/TestUnsafeCounter.java).

L'output di più esecuzioni:

```
SUM VALUE: 299.889.741 - SHOULD BE: 300.000.000
DEFFERENCE: 110.259 - DIFF: 0,036753 %
FINISHED Counter UNSAFE, elapsed time: 15 ms
```

```
SUM VALUE: 299.754.709 - SHOULD BE: 300.000.000
DEFFERENCE: 245.291 - DIFF: 0,081764 %
FINISHED Counter UNSAFE, elapsed time: 54 ms
```

```
SUM VALUE: 299.859.355 - SHOULD BE: 300.000.000
DEFFERENCE: 140.645 - DIFF: 0,046882 %
FINISHED Counter UNSAFE, elapsed time: 32 ms
```
## Utilizzo di synchronized 

L'esempio [contatore.v2.TestSafeCounter](./src/contatore/v2/TestSafeCounter.java) invece utilizza un'implementazione,[contatore.v2.Counter](./src/contatore/v2/Counter.java) con i metodi sincronizzati tramite __syncronized__.

In questo caso, l'esecuzione della classe [contatore.v2.TestSafeCounter](./src/contatore/v2/TestSafeCounter.java) dà i risultati corretti. L'output di una esecuzione:


```
SUM VALUE: 300.000.000 - SHOULD BE: 300.000.000
DEFFERENCE: 0 - DIFF: 0,000000 %FINISHED Counter SAFE, elapsed time: 8.453 ms
```

Notate come la seconda versione che utilizza [contatore.v2.Counter](./src/contatore/v2/Counter.java) sia molto più lenta perché i metodi sono __synchronized__ e i thread che accedono devono acquisire il lock dell'oggetto prima di eseguire il metodo. 

## Operazioni Atomiche

Infine classe di esempio con l'utilizzo delle operazioni atomiche:
[contatore.v3.CounterAtomic](./src/contatore/v3/Counter.java) chiamata dalla classe [contatore.v3.TestAtomicCounter](./src/contatore/v3/TestAtomicCounter.java).

```
SUM VALUE: 300.000.000 - SHOULD BE: 300.000.000
DEFFERENCE: 0 - DIFF: 0,000000 %FINISHED Counter ATOMIC, elapsed time: 3.732 ms
```