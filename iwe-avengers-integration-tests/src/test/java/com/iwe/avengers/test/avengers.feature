Feature: Perform integrated tests on the Avengers registration API

Background:
* url 'https://0ddbvgsmx7.execute-api.us-east-2.amazonaws.com/dev'


Scenario: Avenger not found

Given path 'avengers', 'invalid'
When method get
Then status 404

Scenario: Registry a new Avenger

Given path 'avengers'
And request {name: 'Captain America', secretIdentity: 'Steve Rogers'}
When method post
Then status 201

* def savedAvenger = response

#Get Avenger by id

Given path 'avengers', savedAvenger.id 
When method get
Then status 200
And match $ == savedAvenger





Scenario: Registry a new Avenger and match response

Given path 'avengers'
And request {name: 'Captain America', secretIdentity: 'Steve Rogers'}
When method post
Then status 201
And match response == { id: "#string",  name: "Captain America",  secretIdentity: "Steve Rogers" }


Scenario: Delete a Avenger

Given path 'avengers', "aaaa-aaaa-aaaa-bbbb"
When method delete
Then status 204

Scenario: Delete a Avenger id not found

Given path 'avengers', "idinvalid"
When method delete
Then status 404


Scenario: Update a Avenger

Given path 'avengers', "aaaa-aaaa-aaaa-aaaa"
And request {name: 'Hulk', secretIdentity: 'Bruce Banner'}
When method put
Then status 200
And match response == { id: "#string",  name: "Hulk",  secretIdentity: "Bruce Banner" }


Scenario: Update a Avenger Id not found

Given path 'avengers', "updateIDnotFound"
And request {name: 'Hulk', secretIdentity: 'Bruce Banner'}
When method put
Then status 404

Scenario: Invalid Payload registered will return 400

Given path 'avengers'
And request {secretIdentity: 'Steve Rogers'}
When method post
Then status 400

Scenario: Update Payload invalid 

Given path 'avengers', "asasa-dsdas-sadas-asdas"
And request {secretIdentity: 'Steve Rogers'}
When method put
Then status 400





