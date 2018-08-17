# Fetch Result from Amazon

This Project is about automating Amazon Website .In deep,it will show the results of the given input which we need to search in Amazon site.Its been developed using Java-Maven-Selenium in testNG Framework.

# Browser 

It will run by default in Firefox.

## How to give test input. 

* Find TestSheet.xls in repository , it is the heart for this automation.
* In that excel 'Credentials' sheet is the place where we need to give our inputs

### Category to search (Search category from LOV)
*   In this column select the category under which you need to search the item.

### Item to search 
*   Type the item name here which you need to search in Amazon.
                  
### nth Result to Pick

*   After search Amazon will show a set of results. In that we are going to read details
    for a particular item only.In this column give which result you need to read.
    
            Example : You need 1st result , give 1 or you want to read 3rd result simply give 3.
 
 # Test Result and fetched data
 
 * Test results for the suite will be displayed as default TestNG report.
 * Here comes the most important part of this project .. Where to see the fetched data .?
 
 #### In the Library path you can find a text file with your searched category and item as name 
     
 * For Example if you have searched Shirt item in Men category , the text file 
   would be in the name of 'Men_Shirt'
    
 * If you select Book as category , you will get the result's Title , edition , Author , 
   Price Details and Average Customer reviews
