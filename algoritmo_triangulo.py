######  Programa Triangulo  ########

# Se ha tratado de respetar lo mejor posible los nombres
# de los metodos y variables utilizados en el programa en C
# Los comentarios se han hecho sin acentos/tildes por problemas
# del interprete de codificacion...

# Limpia un array de espacios en blanco y elementos repetidos
def limpiar_lista(lista):
    listaLimpia = []

    # Recorre el array
    for elemento in lista:
        # si el elemento NO esta en el "array limpio" ni es 'vacio' lo inserta
        if(elemento not in listaLimpia) and elemento != ' ' and elemento != '':
            listaLimpia.append(int(elemento))

    # Devuelve el nuevo y limpio array
    return listaLimpia

# Asigna a la fila y columna un valor calculado
def calcula_fila_y_columna(punto, filas, columnas, i):
    cabeza = inc = 1

    # Incrementa cabeza e inc mientras que el valor 'punto' sea mayor que
    # cabeza + inc
    while punto >= cabeza + inc:
        cabeza += inc
        inc += 1

    # asigna inc a la fila y el valor 'punto' menos cabeza a la columna
    filas[i] = inc
    columnas[i] = punto - cabeza


# Verifica si cumple las condiciones para que los puntos ingresados
# partiendo de la matriz armada anteriormente en "calcula_fila_y_columna"
# sean realmente los de un triangulo
def triangulo(fila, columna):
    if fila[0] == fila[1]:
        diferencia = columna[1] - columna[0]

        return (
                diferencia > 0 and
                columna[2] == columna[1] and
                fila[2] == fila[0] + diferencia
                )
    else:
        diferencia = fila[1] - fila[0]

        return (
                diferencia > 0 and
                columna[0] == columna[1] and
                fila[2] == fila[1] and
                columna[2] == columna[1] + diferencia
                )


# Verifica si cumple las condiciones para que los puntos ingresados
# partiendo de la matriz armada anteriormente en "calcula_fila_y_columna"
# sean realmente los de un paralelogramo
def paralelogramo(fila, columna):
    if fila[0] == fila[1]:
        diferencia = columna[1] - columna[0]

        return (
                diferencia > 0 and
                fila[2] == fila[3] and
                columna[3] - columna[2] == diferencia and
                fila[2] - fila[0] == diferencia and
                (columna[2] == columna[0] or columna[2] == columna[1])
                )
    else:
        diferencia = fila[1] - fila[0]

        return (
                diferencia > 0 and
                columna[0] == columna[1] and
                columna[2] == columna[3] and
                fila[1] == fila[2] and
                fila[3] - fila[2] == diferencia and
                columna[2] - columna[1] == diferencia
                )


# Verifica si cumple las condiciones para que los puntos ingresados
# partiendo de la matriz armada anteriormente en "calcula_fila_y_columna"
# sean realmente los de un hexagonoo
def hexagono(fila, columna):
    diferencia = columna[1] - columna[0]

    return (
        diferencia > 0 and
        fila[0] == fila[1] and
        columna[2] == columna[0] and
        fila[2] == fila[0] + diferencia and
        columna[3] == columna[1] + diferencia and
        fila[3] == fila[2] and
        columna[4] == columna[1] and
        fila[4] == fila[2] + diferencia and
        columna[5] == columna[3] and
        fila[5] == fila[4]
        )

def principal():
    # Iniciamos los vectores, no se puede hacer fila = columna = []
    # porque referencian a lo mismo bloque de memoria
    fila = []
    columna = []

    # Pide ingresar por teclado la lista de numeros
    puntosIngresados = raw_input(
            'Ingrese 3, 4 o 6 numeros separados por coma para comenzar: '
            )

    # Separa y deja un array limpio con los numeros ingresados
    puntos = limpiar_lista(puntosIngresados.split(' '))

    # Asigna a n la cantidad de elementos tipeados
    n = len(puntos)

    # Asignamos -1 en cada posicion para no obtener index out of range"
    for i in range(n):
        fila.append(-1)
        columna.append(-1)

    # Muestra los numeros ingresados para posterior mensaje de analisis
    print "\n" , 'La combinacion de numeros: ', ', '.join(map(str, puntos))

    # Ordena los elementos
    puntos.sort()

    # Asigna en cada posicion de la fila y de la columna el valor correspondiente
    # se pasa la i ya que las listas se pasan por REFERENCIA encambio los valores no
    for i in range(n):
        calcula_fila_y_columna(puntos[i], fila, columna, i)

    # Llama al metodo correcto dependiendo el numero de puntos que ingreso
    esValido = (
            triangulo(fila, columna) if n == 3 else
            paralelogramo(fila, columna) if n == 4 else
            hexagono(fila, columna) if (n == 6) else False
            )

    # muestra un mensaje dependiendo la verasidad de cada metodo con los puntos
    # ingresados por el usuario
    mensajeFinal = ''

    if not esValido:
        mensajeFinal += 'no '

    mensajeFinal += 'son vertices de '

    if esValido:
        mensajeFinal += (
            'un triangulo.' if n == 3 else
            'un paralelogramo.' if n == 4 else
            'un hexagono.' if n == 6 else ''
            )
    else:
        mensajeFinal += 'una figura aceptable'


    print mensajeFinal, "\n\nGracias por jugar ^^ \n"


# Damos bienvenida y explicacion
print "\n ###   Bienvenido al algoritmo del triangulo   ### \n"
print "Este juego se basa en ingresar 3, 4 o 6 puntos para saber si los mismos"
print "son parte de una figura geometrica (triangulo, paralelogramo, hexagono"
print "respectivamente).\n"

print "Los puntos van del 1 en adelante conformando un triangulo numerico:"
print "         1"
print "        / \ "
print "       2---3"
print "      / \ / \ "
print "     4---5---6 "
print "    / \ / \ / \ "
print "   7---8---9---10 "
print "  / \ / \ / \ /  \ "
print " 11--12--13--14--15 "
print " .................. \n"

print "Por ej:"
print "- 1 2 3 => Es un Triangulo"
print "- 4 6 11 13 => Es un Paralelogramo"
print "- 4 5 7 9 12 13 => Es un Hexagono\n"

# Llama a la funcion y la repite infinitamente para seguir jugando
while True:
    principal()
