package boilerplate.vector.four;


public class ArrayVectorTest extends VectorTest
{
    @Override
    protected AbstractVector vector(int size)
    {
        return new ArrayVector(size);
    }

    @Override
    protected AbstractVector vector(double... elements)
    {
        return new ArrayVector(elements);
    }
}
