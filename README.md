# The Shoe Store

This project will consist of five screens. You don't have to create a shoe store, you can use any other item as long as you create the following screens. You will be creating:

1. Login screen: Email and password fields and labels plus create and login buttons
2. Welcome onboarding screen
3. Instructions onboarding screen
4. Shoe Listing screen
5. Shoe Detail screen for adding a new shoe

## Getting Started

Open the starter project in the latest stable version of Android Studio.

Open the starter project in Android Studio

##Steps

1. Open the starter project in Android Studio - DONE

2. Add the navigation libraries to the app build.gradle file - DONE

3. Add the safe-arg plugin to the main and app build.gradle file - DONE

4. Create a new navigation xml file - DONE

5. Create a new Login destination.

   * Include email and password labels - DONE

   - Include email and password fields - DONE
   - Create buttons for creating a new login and logging in with an existing account - DONE
   - Clicking either button should navigate to the Welcome Screen. - DONE

6. Create a new Welcome screen destination that includes:

   * A new layout - DONE
   * At least 2 textviews - DONE
   * A navigation button with actions to navigate to the instructions screen - DONE

7. Create a new Instruction destination that includes:

   * A new layout - DONE
   * At least 2 textviews - DONE
   * A navigation button with actions to navigate to the shoe list screen - DONE

8. Create a class that extends ViewModel ---------------- TODO

   *  Use a LiveData field that returns the list of shoes

9. Create a new Shoe List destination that includes:

   * A new layout - DONE
   * A ScrollView - DONE
   * A LinearLayout for Shoe Items - DONE
   * A FloatingActionButton with an action to navigate to the shoe detail screen

10. In MainActivity, setup the nav controller with the toolbar and an AppBarConfiguration.

11. Create a new Shoe Detail destination that includes:

    * A new layout - DONE
    * A TextView label and EditView for the
      * Shoe Name - DONE
      * Company - DONE
      * Shoe Size - DONE
      * Description - DONE
    * A Cancel button with an action to navigate back to the shoe list screen - DONE
    * A Save button with an action to navigate back to the shoe list screen and add a new Shoe to the Shoe View Model - PENDING

12. Make sure you can’t go back to onboarding screens - DONE

13. In the Shoe List screen: ---------------- TODO

    * Use an Activity level ViewModel to hold a list of Shoes (use by activityViewModels)
    * Observe the shoes variable from the ViewModel
    * Use DataBindingUtil to inflate the shoe_list layout
    * Add a new layout item into the scrollview for each shoe - DONE