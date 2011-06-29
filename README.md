Mule Freshbooks Connector (Beta)
================================

FreshBooks is an online invoicing software as a service for freelancers, small businesses, agencies, and professionals. It is produced by the software company 2ndSite Inc. which is located in Toronto, Ontario, Canada. The product includes a myriad of other related features, such as time tracking, expense tracking, recurring billing, online payment collection, the ability to mail invoices through the U.S. Post, and support tickets.

Installation
------------

The connector can either be installed for all applications running within the Mule instance or can be setup to be used
for a single application.

*All Applications*

Download the connector from the link above and place the resulting jar file in
/lib/user directory of the Mule installation folder.

*Single Application*

To make the connector available only to single application then place it in the
lib directory of the application otherwise if using Maven to compile and deploy
your application the following can be done:

Add the connector's maven repo to your pom.xml:

    <repositories>
        <repository>
            <id>muleforge-releases</id>
            <name>MuleForge Snapshot Repository</name>
            <url>http://repository.mulesoft.org/releases/</url>
            <layout>default</layout>
        </repsitory>
    </repositories>

Add the connector as a dependency to your project. This can be done by adding
the following under the dependencies element in the pom.xml file of the
application:

    <dependency>
        <groupId>org.mule.modules</groupId>
        <artifactId>mule-module-freshbooks</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>

Configuration
-------------

You can configure the connector as follows:

    <freshbooks:config authenticationToken="value" apiUrl="value"/>

Here is detailed list of all the configuration attributes:

| attribute | description | optional | default value |
|:-----------|:-----------|:---------|:--------------|
|name|Give a name to this configuration so it can be later referenced by config-ref.|yes||
|authenticationToken|Authentication Token|no|
|apiUrl|Api URL|no|










Create Category
---------------

Create a new category. If successful, returns the category id of the newly created item.



    
    <freshbooks:create-category name="newcat"/>
    

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|name|The name of the category|no||

Returns category id



Update Category
---------------

Update an existing expense category with the given category_id. Any category fields left out of the request will remain unchanged.



    
    <freshbooks:update-category categoryId="12" name="newcat"/>
    

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|categoryId|ID of the category to update|no||
|name|New name|no||



Get Category
------------

Return the complete category details associated with the given category_id.



    
    <freshbooks:get-category categoryId="12"/>
    

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|categoryId|The Id of the category to retrieve|no||

Returns {@link Category} object



Delete Category
---------------

Delete an existing expense category.



    
    <freshbooks:delete-category categoryId="12"/>
    

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|categoryId|The Id of the category to delete|no||



List Categories
---------------

Returns a list of expense categories.



    
    <freshbooks:list-categories/>
    

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||

Returns list of categories



Create Client
-------------

Create a new client and return the corresponding client_id. If a password is not supplied, one will be created at random.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|firstName|First name|no||
|lastName|Last name|no||
|organization|Organization|no||
|email|Email|no||
|username|Username|yes||
|password|Password. Defaults to random password.|yes||
|workPhone|Work phone|yes||
|homePhone|Home phone|yes||
|mobile|Mobile|yes||
|fax|Fax|yes||
|langauge|Language|yes|en|
|currencyCode|Currency code|yes||
|notes|Notes|yes||
|primaryStreet1|Primary street address|yes||
|primaryStreet2|Primary street address 2|yes||
|primaryCity|Primary city|yes||
|primaryState|Primary state|yes||
|primaryCountry|Primary country|yes||
|primaryZipCode|Primary zip code|yes||
|secondaryStreet1|Secondary street address|yes||
|secondaryStreet2|Secondary street address 2|yes||
|secondaryCity|Secondary city|yes||
|secondaryState|Secondary state|yes||
|secondaryCountry|Secondary country|yes||
|secondaryZipCode|Secondary zip code|yes||
|vatName|VAT name|yes||
|vatNumber|VAT number|yes||

Returns id of the new client



Update Client
-------------

Update the details of the client with the given client_id. Any fields not referenced in the request will remain unchanged.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|clientId|Client Id to update|no||
|firstName|First name|no||
|lastName|Last name|no||
|organization|Organization|no||
|email|Email|no||
|username|Username|yes||
|password|Password. Defaults to random password.|yes||
|workPhone|Work phone|yes||
|homePhone|Home phone|yes||
|mobile|Mobile|yes||
|fax|Fax|yes||
|langauge|Language|yes||
|currencyCode|Currency code|yes||
|notes|Notes|yes||
|primaryStreet1|Primary street address|yes||
|primaryStreet2|Primary street address 2|yes||
|primaryCity|Primary city|yes||
|primaryState|Primary state|yes||
|primaryCountry|Primary country|yes||
|primaryZipCode|Primary zip code|yes||
|secondaryStreet1|Secondary street address|yes||
|secondaryStreet2|Secondary street address 2|yes||
|secondaryCity|Secondary city|yes||
|secondaryState|Secondary state|yes||
|secondaryCountry|Secondary country|yes||
|secondaryZipCode|Secondary zip code|yes||
|vatName|VAT name|yes||
|vatNumber|VAT number|yes||

Returns id of the new client



Get Client
----------

Return the client details associated with the given client_id.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|clientId|the id of the client to retrieve|no||

Returns {@link Client}



Delete Client
-------------

Delete the client with the given client_id.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|clientId|the id of the client to retrieve|no||



List Clients
------------

Returns a list of client summaries in order of descending client_id.



    
    <freshbooks:list-clients/>
    

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||

Returns list of clients



























