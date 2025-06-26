package day1;

public class MargeArray
{
    public static void main(String[] args)
    {
        int arr1[] ={1, 2, 5};
        int arr2[] ={4, 5, 6};

        //int a[] = new int[4];

        int merge[] = new int[arr1.length + arr2.length];

        // copy array elements from arr1

        for(int i=0; i<arr1.length; i++)
        {
            merge[i] = arr1[i];
        }

        // copy array elements from arr2
        for(int i=0; i<arr2.length; i++)
        {
            merge[arr1.length +i] = arr2[i];
        }

        //print the merge array
        System.out.println("merged Array");
        for(int a : merge)
        {
            System.out.print(a +" ");
        }

    }
}
