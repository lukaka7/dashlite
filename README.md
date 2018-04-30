# dashlite
A lite version of DoorDash app on Android using MVVM pattern

## Libraries used on this project
* AppCompat, CardView, RecyclerView, ConstraintLayout, ViewModel
* Gson
* Picasso
* Data binding
* Retrofit 2
* RxJava & RxAndroid
* junit, mockito

Completed:
* [X] Add a MainActivity to show a list of Restaurant in CardView, with some metadata such as thumbnail, name, description and status. Using RecyclerView to display a list of restaurants.
* [X] Add a RestaurantDetailActivity to show in the detailed information for each Restaurant. The RestaurantDetailActivity is started when user click on the card view of each restaurant from the MainActivity. Using RecyclerView to display a list of popular items from the selected restaurant.
* [X] Add data and model layer to handle data retrieving from API requests.
* [X] Add unit tests for the ViewModel classes.
