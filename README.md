Endpoints URL https://providersgr6.herokuapp.com/

- POST /providers (name, tip_document, num_document, city, address, phone_num, mobile_num, social_security, value, password, tip_user)
Ejemplo:
  {
  "name":"El paraiso del Aseo",
  "tip_document":"cedula",
  "num_document":"1638792",
  "city":"Cali",
  "address":"Calle 156 Av 34",
  "phone_num":"789332",
  "mobile_num":"30234879",
  "social_security":"4321",
  "value": "200000.0",
  "password":"example",
  "tip_user":"plomeria"
  }
- GET /providers -- returns all providers
- GET /providers/id -- return provider with the specified id
- PUT /providers/id -- update specified fields in the body (JSON) for a specified provider 
- DELETE /providers/id -- delete provider with the specified id