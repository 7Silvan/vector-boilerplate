package boilerplate.vector.third;

public class ArrayVectorTest extends VectorTest
{
    @Override
    protected Vector vector(int size)
    {
        return new ArrayVector(size);
    }

    @Override
    protected Vector vector(double... elements)
    {
        return new ArrayVector(elements);
    }
}
