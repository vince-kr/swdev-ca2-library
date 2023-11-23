package LibrarySystem.util.format;

import LibrarySystem.library.catalogue.Asset;

import java.util.ArrayList;

public class SortData {

    /*
     This method implements the merge sort algorithm
     for arraylist of assets(e.g. the array list of borrowed assets)
     returns a sorted list of assets given
     */
    public static ArrayList<Asset> mergeSort(ArrayList<Asset> objects) {
        if (objects.size() <= 1) return objects;
        ArrayList<Asset> left, right;
        left = new ArrayList<Asset>();
        right = new ArrayList<Asset>();

        for (int i = 0; i < objects.size(); i++)
        {
            if (i % 2 != 0) left.add(objects.get(i));
            else right.add(objects.get(i));
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }


    public static ArrayList<Asset> merge(ArrayList<Asset> left, ArrayList<Asset> right) {
        ArrayList<Asset> ret = new ArrayList<>();

        while (!left.isEmpty() && !right.isEmpty())
        {
            //compares their date due hours to return asset
            if (left.get(0).getDateDue().getHour() <= right.get(0).getDateDue().getHour())
            {
                ret.add(left.get(0));
                left.remove(0);
            }
            else
            {
                ret.add(right.get(0));
                right.remove(0);
            }
        }

        while (!left.isEmpty())
        {
            ret.add(left.get(0));
            left.remove(0);
        }

        while (!right.isEmpty())
        {
            ret.add(right.get(0));
            right.remove(0);
        }

        return ret;
    }
}
