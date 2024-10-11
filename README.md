# Java DataFrame
Inspired by the concept of DataFrame in python's pandas library, this is a custom implementation in Java. It provides methods to manipulate and manage data in tabular form. Each row represents an entry and the columns are designed to hold a specific type of data. Reading and writing of data in csv files can also be done.


## 1. Class Members - 
### a. `columns` (`List<String>`): 
Stores the names of columns.
### b. `rows` (`List<String>`): 
Stores the names of rows.
### c. `data` (`List<List<Object>>`):
Stores and represents the data in tabular form. Each sublist represents a row.
### d. `colType` (`List<Object>`):
Stores the data type for each column.

## 2. Constructors - 
### a. `DataFrame()`:
Initializes an empty DataFrame.
### b. `DataFrame(List<List<Object>> data)`:
Initializes DataFrame using a list of data rows and assigns numbers a columns.
### c. `DataFrame(List<List<Object>> data, List<String> columns)`:
Initializes DataFrame using a list of data rows and predefined column names.
### d. `DataFrame(List<List<Object>> data, List<String> rows, List<String> columns)`:
Initializes the DataFrame using a list of data rows, predefined row names, and predefined column names.

## 3. Attributes - 
### **DataFrame.count():**
Returns the size (int) of the DataFrame. Number of rows to be exact.
## 4. Indexing - 
- **DataFrame.get(row, column):** Returns a single specific value (Object). Parameters can either be 'int' or 'String', but 'row' parameter can only be string if the row names are provided.
- **DataFrame.head(n):** Returns the first 'n' rows in the form of List<List<Object>>. If 'n' not specified then returns the first 5 rows.
- **DataFrame.tail(n):** Returns the last 'n' rows in the form of List<List<Object>>. If 'n' not specified then returns the last 5 rows.
