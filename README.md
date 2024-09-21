Trying to build the DataFrame data structure from python in Java


## Attributes - 
- **DataFrame.count():** Returns the size (int) of the DataFrame. Number of rows to be exact.
## Indexing - 
- **DataFrame.get(row, column):** Returns a single specific value (Object). Parameters can either be 'int' or 'String', but 'row' parameter can only be string if the row names are provided.
- **DataFrame.head(n):** Returns the first 'n' rows in the form of List<List<Object>>. If 'n' not specified then returns the first 5 rows.
- **DataFrame.tail(n):** Returns the last 'n' rows in the form of List<List<Object>>. If 'n' not specified then returns the last 5 rows.
