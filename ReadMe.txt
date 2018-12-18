1-Need to Set Database relate info in application Property
2-In Application we have two controller class(HotelController,UserController)
3-HotelController contains 5 API 
a)-ip:port/hotel/find                          (Request json need to pass from frontend controller)   
b)-ip:port/hotel/rating/{hotelid}              (Hotleid need to pass from frontend controller)
c)-ip:port/hotel/add                           (Request json need to pass from frontend controller)
d)-ip:port/hotel/add/review                    (Request json need to pass from frontend controller)     
e)-ip:port/hotel/delete/{hotelid}              (Hotleid need to pass from frontend controller)
4-UserController contains 2 API

a)-ip:port/user/add                          (Request json need to pass from frontend controller)   
a)-ip:port/user/delete/{userId}              (Userid need to pass from frontend controller)ld 

Note-There should two for api required to get all the hotel and all the user to delete according to hotledid and userid respcectively

4-update the project 
5- maveen clean
6-maveen build