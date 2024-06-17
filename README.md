Clone This Repository 
Then Click On import In Eclipse from Existing Maven Project
Then Right Click On the project Click Maven > Update Project Then Right Click > Run As Java Application
I Have used Hibernate as a Database as it easy to store and use 

1.To Check the Post request Endpoint in Talend Api 
a) Click on Post Request
b)In The Request Section make a new request http://localhost:8080/api/user/register
c)In the body Section give Json Type input   
{
  "username": "aditya",
  "email": "adityapatwari19@gmail.com",
  "password": "aditya"
}
d)U will get response User Created Successfully

2.To Check the Get api endpoint 
a)Click on Get Request
b)In The Request Section make a new request http://localhost:8080/api/user/fetch?username=aditya
c)U get response as json format or an Error acordingly.

I have implemented security such as cannot submit null values and cannot retrieve if there are null values etc.. and I have responded with correct Stataments along with the corresponding error numbers.

To access the hibernate database go to http://localhost:8080/h2-console   username :sh password:(do not give anything)
All the details of the db are mentoned in application.properties 
Project is Running on the Server PORT:8080
