public class ConjuntoArreglo<E> implements Conjunto<E> {
    private E conjunto[];

    public ConjuntoArreglo(int i) {
        this.conjunto = (E[]) new Object[i];
    }

    public int size() {
        int cant = 0;
        for (int i = 0; i < this.capacity(); i++) {
            if (this.get(i) != null) {
                cant++;
            }
        }
        return cant;
    }

    public int capacity() {
        return conjunto.length;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public E get(int i) {
        return this.conjunto[i];
    }

    public void put(E elem) {
        boolean agregado = false;
        for (int i = 0; i < this.capacity() && !agregado; i++) {
            if (this.get(i) == null) {
                this.conjunto[i] = elem;
                agregado = true;
            }
        }
    }

    public boolean pertenece(E elem) {
        boolean esta = false;
        for (int i = 0; i < this.capacity() && !esta; i++) {
            if (this.get(i) == elem) {
                esta = true;
            }
        }
        return esta;
    }

    public Conjunto<E> interseccion(Conjunto<E> c) {
        Conjunto<E> res = new ConjuntoArreglo<E>(this.capacity());
        for (int i = 0; i < this.capacity(); i++) {
            if (c.pertenece(this.get(i))) {
                res.put(this.get(i));
            }
        }

        return res;
    }
}
