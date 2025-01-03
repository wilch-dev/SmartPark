# SmartPark - Technical Assessment

### Hello Interviewer, 

All the functional and non-functional requirements are supposedly done, except for the testing. I really wanted to do TDD but for some reason the testing dependencies were probably fighting with each other and I probably wasn't doing some things right. I might try to push the testing part on another branch before the deadline. My approach would've been to do integration testing to cover the service and repository layer since I lack time. This was very tedious to do hahaha. For a small requirement, this takes more time with Java.  

For the design, it's just a monolith. I didn't feel like overengineering. There are other design considerations that in real life should be implemented. But for the sake of this assessment, I think I did more than the minimum effort. Just went for the KISS approach instead of thinking about everything. 

There's a notes part somewhere in the project. I just wrote down the things that went wrong at times. Admittedly, I don't have much experience with spring authentication. I put a video link on where I based (copied) the code of from. There are also some comments within the code on what my thoughts were. 

There are other things I wanted to show, but I had time constraints. Before this assessment I was practicing some things with reactor core. Not the usual approach at work and at times not implemented well. Here's the repo for it. https://github.com/wilch-dev/pds-sample Opted not to go for this because this might take more time to develop. 

Good luck with testing this out. Let me know how things go. 

---

## Some Technical Guides
### Build and Run

Within the `smartpark` folder you can run maven to build and run. The app uses Java 17.

`mvn clean install` 

`mvn package` 

To run: `java -jar target/smartpark-0.0.1-SNAPSHOT.jar`

Ctrl+C to exit

### Request And Response Collections
I used bruno instead of postman. But there's a postman collection within the
`bundled-collection` folder - `smartpark-postman.json`

### How to get started
One of the requirements is to use JWT in almost all the API calls. Please use `login` call to get the `access_token`. You will use this in the `Authorization` tab of postman. Use `Bearer Token` and paste that token there. You'll have to do this on each call. You may edit the expiry time in `application-dev.yaml` and then rebuild.

### Other things
- Preloaded username and password is `admin` and `admin`.
- `http://localhost:8080/h2-console` to view the database. Username - `sa`. No Password.

#### Good luck! If you need assistance, contact me.