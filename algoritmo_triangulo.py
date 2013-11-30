# Limpia un array de espacios en blanco y elementos repetidos
def clean_array(array):
    clear_array = []

    for element in array:
        if(element not in clear_array) and element != ' ' and element != '':
            clear_array.append(int(element))

    return clear_array

def row_col(p, rows, cols, i):
    head = inc = 1

    while p >= head + inc:
        head += inc
        inc += 1

    rows[i] = inc
    cols[i] = p - head


def triangle(row, col):
    if row[0] == row[1]:
        len_diff = col[1] - col[0]

        return (
                len_diff > 0 and
                col[2] == col[1] and
                row[2] == row[0] + len_diff
                )
    else:
        len_diff = row[1] - row[0]

        return (
                len_diff > 0 and
                col[0] == col[1] and
                row[2] == row[1] and
                col[2] == col[1] + len_diff
                )

def parallelogram(row, col):
    if row[0] == row[1]:
        len_diff = col[1] - col[0]

        return (
                len_diff > 0 and
                row[2] == row[3] and
                col[3] - col[2] == len_diff and
                row[2] - row[0] == len_diff and
                (col[2] == col[0] or col[2] == col[1])
                )
    else:
        len_diff = row[1] - row[0]

        return (
                len_diff > 0 and
                col[0] == col[1] and
                col[2] == col[3] and
                row[1] == row[2] and
                row[3] - row[2] == len_diff and
                col[2] - col[1] == len_diff
                )


def hexagon(row, col):
    len_diff = col[1] - col[0]

    return (
        len_diff > 0 and
        row[0] == row[1] and
        col[2] == col[0] and
        row[2] == row[0] + len_diff and
        col[3] == col[1] + len_diff and
        row[3] == row[2] and
        col[4] == col[1] and
        row[4] == row[2] + len_diff and
        col[5] == col[3] and
        row[5] == row[4]
        )

def main():
    # Iniciamos los vectores
    # no se puede hacer row = col = [] porque referencian a lo mismo
    row = []
    col = []

    # Da bienvenida
    print "Welcome to the triangle algorithm \n "

    # Pide ingresar por teclado la lista de numeros
    prompt = raw_input('Type 3, 4 or 6 numbers space-separated: ')

    # Separa y deja un array limpio con los numeros ingresados
    points = clean_array(prompt.split(' '))

    # Asigna a n la cantidad de elementos tipeados
    n = len(points)

    # Asignamos -1 en cada posicion para no obtener "index out of range"
    for i in range(n):
        row.append(-1)
        col.append(-1)

    # Ordena los elementos
    points.sort()

    # Muestra los numeros ingresados  /// Como en el codigo C
    line = ' '.join(map(str, points))
    print "The list sorted is: ", line, "\n"

    # Asigna en cada posicion de la fila y de la columna el valor correspondiente
    # se pasa la i ya que las listas se pasan por REFERENCIA encambio los valores no
    for i in range(n):
        row_col(points[i], row, col, i)


    is_valid = (
            triangle(row, col) if (n == 3) else
            parallelogram(row, col) if (n == 4) else
            hexagon(row, col) if (n == 6) else False
            )


    print 'Are', '' if is_valid else 'not ', 'the vertices of ', "\n", (
                'an acceptable figure' if (not is_valid) else
                'a triangle' if(n == 3) else
                'a parallelogram' if (n == 4) else 'a hexagon'
                )


main()
