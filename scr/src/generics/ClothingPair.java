package generics;

import com.sun.glass.ui.Size;

public class ClothingPair<E extends Size> extends Pair<E> {

    public ClothingPair(E left, E right) {
        super(left, right);
    }

    public boolean matches() {
        return left.getSize()==
    }
}

