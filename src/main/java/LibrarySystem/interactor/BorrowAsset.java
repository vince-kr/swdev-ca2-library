package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.LibraryUser;
import LibrarySystem.library.catalogue.*;
import LibrarySystem.util.io.StandardInput;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.util.ArrayList;

public class BorrowAsset extends Interaction{

    String header = "Borrow AN ASSET\n";
    @Override
    public void requestAndResponse(Library library) {
         /*
        Steps to borrow an asset:
        1. Get the user who is going to borrow
        2.  Get the asset to borrow and check status of asset to be available
        3. Once all information has been gathered, add asset to the list of borrowed assets
            of the user.
        4. Change status,quantity of asset and set a date issued and date due
        */
        ArrayList<Asset> assets = new ArrayList<>();
        System.out.println(header);
        int userKey = askUserKey();
        //get user
        LibraryUser user = library.findUserByKey(userKey);

        int assetKey = askAssetKey();
        //get asset
        Asset asset = library.borrowAsset(assetKey);
        if (user == null || asset == null){
            System.out.println(" User or asset with the specified Id not in the system.");
        }else{
            asset.setStatus("Not available");
            asset.setDateIssued(LocalDateTime.now());
            asset.setDateDue(LocalDateTime.now().plusHours(24));
            assets.add(asset);
            //add asset to borrowed asset list
            user.setBorrowedBooks(assets);
            System.out.println(" Asset: "+asset.getTitle()+" borrowed by user: "+user.getName()+", successfully.");
        }

    }



   private int askAssetKey(){
        String prompt = "Enter AssetId: ";
        return StandardInput.getPositiveInt(prompt,1000);
   }


    private int askUserKey(){
        String prompt = "Enter UserId: ";
        return StandardInput.getPositiveInt(prompt,1000);
    }
}
