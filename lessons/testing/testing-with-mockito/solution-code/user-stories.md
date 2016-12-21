# Trending Products Demo

This app will display a list of products that are currently trending on [walmart.com](https://www.walmart.com/) and show more detail when a product is selected.
The data will come from Walmart's [Trending API](https://developer.walmartlabs.com/io-docs).

## Features
---

#### Display a list of products that Walmart has designated as "trending"
- Conditions:
  - List displays on "home" screen of app
  - List shows name, brand, price, and thumbnail image for each product
  - List indicates whether each product has already been marked as a favorite
- User stories:
  - As a user, I can open the app and immediately see a list of trending products.
  - As a user, I can see the name, brand, price, image, and favorite status for each product in the list.

#### Allow user to mark products as favorites
- Conditions:
  - List entries include an icon that will change to indicate favorite or non-favorite status
  - Clicking the icon will toggle the favorite status of the item
  - The change will be persisted to permanent storage
  - User will receive a message with the option to undo the change
- User stories:
  - As a user, I can click a "non-favorite" icon to mark the product as a favorite, and vice-versa.
  - As a user, I can make changes to my favorites and they will be saved permanently.
  - As a user, I will recieve a confirmation of changes in favorite status, and can undo those changes.

#### Display a list of favorite products
- Conditions:
  - A menu icon will provide navigation to a separate favorites screen
- User stories:
  - As a user, I can click the favorites icon in the menu bar and view a list of my favorite products.

#### Allow user to remove products from favorites list
- Conditions:
  - Favorites list entries include an "X" icon; clicking it will remove the product from the user's favorites
  - The change will be persisted to permanent storage (i.e. that product will be removed from storage)
  - User will receive a message with the option to undo the change
- User stories:
  - As a user I can click an "X" icon to un-favorite a product.
  - As a user, I can make changes to my favorites and they will be saved permanently.
  - As a user, I will recieve a confirmation of changes in favorite status, and can undo those changes.
