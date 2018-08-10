Feature: Perform integrated tests on the Avengers registration API

Background:
* url 'https://0ddbvgsmx7.execute-api.us-east-2.amazonaws.com/dev'

Scenario: Get Avenger by Id

Given path 'avengers', 'sdsa-sasa-asas-sasa'
When method get
Then status 200
And match response == {id: '#string', name: 'Iron Man', secretIdentity: 'Tony Stark'}

Scenario: Registry a new Avenger

Given path 'avengers'
And request {name: 'Captain America', secretIdentity: 'Steve Rogers'}
When method post
Then status 201

Scenario: Registry a new Avenger and match response

Given path 'avengers'
And request {name: 'Captain America', secretIdentity: 'Steve Rogers'}
When method post
Then status 201
And match response == {id: '#string', secretIdentity: 'Steve Rogers'}


Scenario: Delete a Avenger

Given path 'avengers', "asasa-dsdas-sadas-asdas"
And request {name: 'Captain America', secretIdentity: 'Steve Rogers'}
When method delete
Then status 204


Scenario: Update a Avenger

Given path 'avengers', "asasa-dsdas-sadas-asdas"
And request {name: 'Hulk', secretIdentity: 'Bruce Banner'}
When method put
Then status 200
And match response == { id: "#string",  name: "Hulk",  secretIdentity: "Bruce Banner" }

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




