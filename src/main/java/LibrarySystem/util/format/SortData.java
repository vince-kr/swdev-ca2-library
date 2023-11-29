package LibrarySystem.util.format;

import LibrarySystem.library.Loan;
import LibrarySystem.library.catalogue.Asset;

import java.util.ArrayList;

public class SortData {

    /*
     This method implements the merge sort algorithm
     for arraylist of Loans (borrowed assets)
     returns a sorted list of assets
     */

    public static ArrayList<Loan> mergeSort(ArrayList<Loan> borrowedAssets) {
        // Base case
        if (borrowedAssets.size() <= 1) return borrowedAssets;

        // Recursive case
        ArrayList<Loan> left, right;
        left = new ArrayList<Loan>();
        right = new ArrayList<Loan>();

        for (int i = 0; i < borrowedAssets.size(); i++)
        {
            if (i % 2 != 0) left.add(borrowedAssets.get(i));
            else right.add(borrowedAssets.get(i));
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }


    public static ArrayList<Loan> merge(ArrayList<Loan> left, ArrayList<Loan> right) {
        ArrayList<Loan> ret = new ArrayList<>();

        while (!left.isEmpty() && !right.isEmpty())
        {
            Loan firstLeft = left.get(0);
            Loan firstRight = right.get(0);

            // Compares dates due to return asset
            if (firstLeft.getDateDue().isBefore(firstRight.getDateDue()))
            {
                ret.add(firstLeft);
                left.remove(0);
            }
            else
            {
                ret.add(firstRight);
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
