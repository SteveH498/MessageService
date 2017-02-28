# MessageService
Little Spring Boot message board service

**Get access token**
```
curl message-service:message-service-secret@localhost:8080/oauth/token -d grant_type=password -d username=Steve -d password=test_password

{"access_token":"fcaa034e-1fad-454e-8356-9d49dd79a6de","token_type":"bearer","expires_in":43187,"scope":"all"}
```

**Do authenticated requests**

```
curl -H "Authorization: Bearer fcaa034e-1fad-454e-8356-9d49dd79a6de" localhost:8080

{
  "_links" : {
    "boards" : {
      "href" : "http://localhost:8080/boards"
    },
    "boardMessages" : {
      "href" : "http://localhost:8080/boardMessages"
    },
    "boardUsers" : {
      "href" : "http://localhost:8080/boardUsers"
    },
    "profile" : {
      "href" : "http://localhost:8080/profile"
    }
  }
}
```
