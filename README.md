Endpoints URL https://providersgr6.herokuapp.com/

- POST /providers (name, tip_document, num_document, city, address, phone_num, mobile_num, social_security, value, password, tip_user)
- GET /providers -- returns all providers
- GET /provider/id -- return provider with the specified id
- PUT /providers/id -- update specified fields in the body (JSON) for a specified provider 
- DELETE /providers/id -- delete provider with the specified id