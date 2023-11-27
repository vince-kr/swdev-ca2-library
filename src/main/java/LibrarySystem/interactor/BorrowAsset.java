package LibrarySystem.interactor;

import LibrarySystem.library.Library;
import LibrarySystem.library.LibraryUser;
import LibrarySystem.library.catalogue.*;
import LibrarySystem.util.io.StandardInput;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.util.ArrayList;

public class BorrowAsset extends Interaction {

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
        System.out.println(header);
        //list all users of the system
        library.summariseAllUsers();
        //get user from list
        LibraryUser user = library.findUserByKey(askUserKey());

        if (!(user == null)){
            //get borrowed assets of user
            ArrayList<Asset> assets = user.getBorrowedBooks();
            //list all assets of the system
            library.summariseAllAssets();
            //get asset from list
            Asset asset = library.borrowAsset(askAssetKey());

            if (!(asset == null)){
                // do borrowing here
                asset.setAvailability(false);
                asset.setQuantity(0);
                asset.setDateIssued(LocalDateTime.now());
                asset.setDateDue(LocalDateTime.now().plusHours(24));
                //add asset to borrowed user assets
                assets.add(asset);
                System.out.println(" Asset: "+asset.getTitle()+" borrowed by user: "+user.getName()+", successfully.");
            }
            askAssetKey();
        }
        askUserKey();

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
