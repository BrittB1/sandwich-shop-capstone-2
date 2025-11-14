
# Welcome to Billy's!
##  <em>We have the best sandwiches in town</em>

This CLI Java application allows users to create a custom order, view its details, and save their receipt to a file.


## Features

- Custom sandwich creation with sizes, toppings, sauces and extras
- Drink and chip ordering
- Order receipt generation
- Cross platform


## How to Run

Start program by naviagting to main and right-clicking either green arrow. This will start the application and display the home screen.

![App Demo](images/program_start_demo.gif)
## Class Structure

The class structure of the application is as follows:

**Main**

Entry point of program. Initializes user interface and starts the program.

**User Interface**

Handles all interactive features, displays menus and processes user's input
****
**Interfaces**

* ``Priceable`` - Defines contract for calculating prices for all product types

* ``Displayable`` - For consistent description formatting for menu items and receipts

****
**Models (Product Classes)**

* ``Sandwich`` - Represents custom sandwich with size, bread type, toppings and pricing logic based on customizations

* ``Drink`` - Represents beverage with size and flavor options

* ``Chips`` - Represents a bag of chips with flavor selection.

* ``Order`` - Holds a collection of products and calculates price of order.
****
**Enums**

* ``SandwichSize`` - Defines available sandwich sizes (4",8",12")

* ``BreadType`` - Available bread types (white,wheat,rye,wrap)

* ``Topping`` - Toppings with pricing (meats, cheeses, standard toppings, sauces)

****

**Services**

``ReceiptFileManager`` - Handles saving orders to text files and generating receipts




