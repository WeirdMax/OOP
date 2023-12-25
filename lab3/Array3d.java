
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Array3d<T> {
    private int dim0;
    private int dim1;
    private int dim2;
    private List<T> data;
    public Array3d(int dim0, int dim1, int dim2) {
        this.dim0 = dim0;
        this.dim1 = dim1;
        this.dim2 = dim2;
        this.data = new ArrayList<>(Collections.nCopies(dim0 * dim1 * dim2, null));
    }

    public int getDim0() {
        return dim0;
    }

    public void setDim0(int dim0) {
        this.dim0 = dim0;
    }

    public int getDim1() {
        return dim1;
    }

    public void setDim1(int dim1) {
        this.dim1 = dim1;
    }

    public int getDim2() {
        return dim2;
    }

    public void setDim2(int dim2) {
        this.dim2 = dim2;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public T get(int i, int j, int k) {
        return this.data.get(i * this.dim1 * this.dim2 + j * this.dim2 + k);
    }

    public void set(int i, int j, int k, T value) {
        this.data.set(i * dim1 * dim2 + j * dim2 + k, value);
    }

    public List<T> getValues0(int i) {
        List<T> result = new ArrayList<>();
        for (int j = 0; j < this.dim1; ++j) {
            for (int k = 0; k < this.dim2; ++k) {
                result.add(get(i, j, k));
            }
        }
        return result;
    }

    public List<T> getValues1(int j) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < this.dim0; ++i) {
            for (int k = 0; k < this.dim2; ++k) {
                result.add(get(i, j, k));
            }
        }
        return result;
    }

    public List<T> getValues2(int k) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < this.dim0; ++i) {
            for (int j = 0; k < this.dim1; ++k) {
                result.add(get(i, j, k));
            }
        }
        return result;
    }

    public List<T> getValues01(int i, int j) {
        List<T> result = new ArrayList<>();
        for (int k = 0; k < this.dim2; ++k) {
            result.add(get(i, j, k));
        }
        return result;
    }

    public List<T> getValues02(int i, int k) {
        List<T> result = new ArrayList<>();
        for (int j = 0; j < this.dim1; ++j) {
            result.add(get(i, j, k));
        }
        return result;
    }

    public List<T> getValues12(int j, int k) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < this.dim0; ++i) {
            result.add(get(i, j, k));
        }
        return result;
    }

    public void setValues0(int i, List<T> values) {
        int index = 0;
        for (int j = 0; j < this.dim1; ++j) {
            for (int k = 0; k < this.dim2; ++k) {
                this.set(i, j, k, values.get(index++));
            }
        }
    }

    public void setValues1(int j, List<T> values) {
        int index = 0;
        for (int i = 0; i < this.dim0; ++i) {
            for (int k = 0; k < this.dim2; ++k) {
                this.set(i, j, k, values.get(index++));
            }
        }
    }

    public void setValues2(int k, List<T> values) {
        int index = 0;
        for (int i = 0; i < this.dim0; ++i) {
            for (int j = 0; j < this.dim1; ++j) {
                this.set(i, j, k, values.get(index++));
            }
        }
    }

    public void setValues01(int i, int j, List<T> values) {
        int index = 0;
        for (int k = 0; k < this.dim2; ++k) {
            this.set(i, j, k, values.get(index++));
        }
    }
    public void setValues02(int i, int k, List<T> values) {
        int index = 0;
        for (int j = 0; j < this.dim1; ++j) {
            this.set(i, j, k, values.get(index++));
        }
    }
    public void setValues12(int j, int k, List<T> values) {
        int index = 0;
        for (int i = 0; i < this.dim0; ++i) {
            this.set(i, j, k, values.get(index++));
        }
    }

    public Array3d<T> fill(int dim0, int dim1, int dim2, T value) {
        Array3d<T> array = new Array3d<>(dim0, dim1, dim2);
        for (int i = 0; i < dim0; ++i) {
            for (int j = 0; j < dim1; ++j) {
                for (int k = 0; k < dim2; ++k) {
                    array.set(i, j, k, value);
                }
            }
        }
        return array;
    }

    @Override
    public String toString() {
        return "Array3d{" +
                "dim0=" + dim0 +
                ", dim1=" + dim1 +
                ", dim2=" + dim2 +
                ", data=" + data +
                '}';
    }
}