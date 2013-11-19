%% Hechos y Reglas
par(1):- !, fail. 
par(2).
par(N):- N > 2, X is N-2, par(X).

suma(1,2).
suma(X,Y):- X > 1, Z is X+1, Y is Z*X.

potencia(X,0,1).
potencia(1,1,1).
potencia(X,1,X).
potencia(X,Y,Z):- Y > 1, A is Y-1, potencia(X,A,B), Z is B*X.

fibonacci(0,0).
fibonacci(1,1).
fibonacci(N,R):- N > 1, A is N-1, B is N-2, fibonacci(A,Y), fibonacci(B,X), R is Y+X.

zand(X,X,X).
zand(X,Y,0).
zand(1,1,1).

zor(X,X,X).
zor(X,1,1).
zor(X,Y,Z):-zor(Y,X,Z).
znot(1,0).
znot(0,1).
circuito(Q1,Q2,S):- znot(Q1,NQ1), znot(Q2,NQ2), zand(NQ1, Q2,ZAND1), zand(NQ2, Q1,ZAND2), zor(ZAND1,ZAND2, S).

sintoma(juan, mocos).
sintoma(pedro, mocos).
sintoma(pedro, cansancio).
sintoma(raul, mocos).
sintoma(raul, cansancio).
sintoma(raul, fiebre).

enfermedad(alergia, mocos).
enfermedad(resfrio, mocos).
enfermedad(resfrio, cansancio).
enfermedad(gripe, mocos).
enfermedad(gripe, cansancio).
enfermedad(gripe, fiebre).

diagnostico(P, S, E):- sintoma(P, S), enfermedad(E, S). 


%% Tratamiento de listas

suma(0, []).
suma(X, [X | []]).
suma(Y, [C | Q]):- suma(R,Q), Y is C+R.

cantidad([],0).
cantidad([C | []],1).
cantidad([C | Q],N):- cantidad(Q, R), N is R+1.

ultimo([],_):- !, fail.
ultimo([Q],Q).
ultimo([C | Q],U):- ultimo(Q,U).

inversa([Q],Q).
inversa([H|T], [R|H]):- inversa(T, R).

sacar(0,[C|T],T).
sacar(P,[H|T],R):- P > 0, X is P-1, sacar(X,T,S), R = [H|S].

eliminar([E|T],E,T).
eliminar([C|Q],E,R):- eliminar(Q,E,W), R = [C|W]. 

eliminar2([E],E,[]).
eliminar2([C],E,[C]).
eliminar2([E|Q],E,W):- eliminar2(Q,E,W). 
eliminar2([C|Q],E,R):- eliminar2(Q,E,W), R = [C|W]. 

intersec(C,C,C).
intersec([],B,[]).
intersec(A,[],[]).
intersec([C|Q],L2,L3):- intersec(Q,L2,L3).
intersec([C|Q],L2,L3):- intersec(Q,L2,W), R = [C|W].

%% Auxiliar
concatena([],[],[]).
concatena([],N,N).
concatena([H|T],N,[H|R]):- concatena(T,N,R).

rotarIzq(X, 0, X).
rotarIzq([H|T], 1, [T|H]).
rotarIzq([H|T], N, R):- N > 1, M is N-1, concatena(T,[H],K),rotarIzq(K,M,R).

insertarEn(E, [], _, [E]).
insertarEn(E, X, 0, [E|X]).
insertarEn(E, [H|T], P, R):- P > 0, N is P-1, insertarEn(E,T,N,S), R=[H|S].

insOrden(E, [], [E]).
insOrden(E, [H|T], R):- E =< H, R=[E|[H|T]].
insOrden(E, [H|T], R):- E > H, insOrden(E, T, S), R=[H|S].

ordenada([],[]).
ordenada([E],[E]).
ordenada([H|T], R):- ordenada(T,S), insOrden(H,S,R).

% Estructuras de datos
parejas([],[],[]).
parejas([H1|T1], [H2|T2], L3):- cantidad(T1,C1), cantidad(T2,C2), C1 == C2, parejas(T1,T2, LALA), L3 = [[H1,H2]|LALA].


persona(r,1, 2).
persona(a,2, 3).
persona(b,3, 4).
persona(c,4, 5).
persona(d,5, 6).
persona(e,6, 7).
persona(f,7, 8).
persona(g,8, 9).
persona(h,9, 10).
persona(i,10, 11).
persona(j,11, 12).
persona(k,12, 13).
padre(r,a).
padre(r,b).
padre(r,c).
padre(a,d).
padre(a,e).
padre(b,f).
padre(b,g).
padre(e,h).
padre(f,i).
padre(f,j).
padre(g,k).
hijo(X,Y):-padre(Y,X).

descendientes(X,Y):-padre(X,Y).
descendientes(X,Y):-padre(X,Z), descendientes(Z,Y).

ascendientes(X,Y):-padre(Y,X).
ascendientes(X,Y):-padre(Y,Z), ascendientes(X,Z).

persona2(a, 123, male, 38).
persona2(b, 123, female, 23).
persona2(c, 345, male, 33).
persona2(d, 355, female, 34).
persona2(e, 395, male, 16).
buscarPers(X):- persona2(X, _, _,_).
mostrarMujeres(X):- persona2(X,_,female,_).
mostrarMayores(Y):- persona2(Y,_,male,R), R > 21.
casado(a,b).
casado(c,d).
casadosTel(X,Y):- casado(X,Y), persona2(X,T1,_,_), persona2(Y,T2,_,_), T1 == T2.
visita(a,e).
visita(b,d).
visita(X,Y):- visita(Y,X).

% es la relacion de "trampa" de una persona con quien visita.
% c(X):- if casado(X, Y), visita(Y, Z), persona2(Z, _, m, _).

ruta(mendoza, sanluis, 280).
ruta(sanjuan, cordoba, 480).
ruta(cordoba, sanjuan, 350).
ruta(sanluis, bsas, 710).
ruta(cordoba, bsas, 540).
ruta(cordoba, misiones, 950).
ruta(cordoba, santafe, 280).
ruta(santafe, misiones, 570).
ruta(mendoza, sanjuan,160).
camino(X, Y, Z):- ruta(X, Y, Z).
camino(X, Y, Z):- ruta(X, C2, R1), camino(C2, Y, R2), Z is R1 + R2.   

camino2(X, Y):- ruta(X, Y, _).
camino2(X, Y):- ruta(X, C2, _), camino2(C2, Y), !.  


camino3(X, Y, Z):- ruta(X, Y, Z).
camino3(X, Y, Z):- ruta(X, C2, R1), camino3(C2, Y, R2), write(C2), write(' '), !.   
