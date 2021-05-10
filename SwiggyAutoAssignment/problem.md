###Swiggy Auto Assignment
We are trying to build auto assignment system for Swiggy’s delivery fleet. For simplicity we will
solve the problem within context of an area.
Given a list of orders and a list of Delivery executives(DE), System should output list of
assignments such that following attributes are cumulatively optimised:
-> First mile (Distance between restaurant and DE’s current location): Prioritise assignment
pairs with low first mile.
-> DE waiting time(Time elapsed since DE last delivered the order): Prioritise DE with already
high waiting time.
-> Order delay time (Time elapsed since Order was placed): Prioritize Order with already high
order delay.
Input:
Orders: [{“restaurant_location”:”lat1,long1”,”ordered_time”:”T1”,”id” :
123},{“restaurant_location”:”lat3,long3”,”ordered_time”:”T2”,”id”:321}]
DEs :
[{“id”:567,”current_location”:”lat5,long5”,”last_order_delivered_time”:”T3”},{“id”:765,”current_loca
tion”:”lat7,long7”,”last_order_delivered_time”:”T4”},{“id”:766,”current_location”:”lat9,long9”,”last_
order_delivered_time”:”T5”}]
Output: Assignments: [{“order_id”:123,”de_id”:765}]
Notes:
● Please state all the assumptions to the panel.
● You can use Haversine for distance.
Extensions:
● How to scale this approach to whole city ?
● How to fetch DEs to be mapped with order ?
● Some areas might want to increase efficiency i.e maximum utilization of delivery boys.
On the other hand, some might want to increase quality i.e prioritize order delay, equal
distribution of orders among delivery boys. How should the code be designed so that
these factors can be easily incorporated in future?
Expectation:
● Broadly, you will be evaluated based on low level design as well as the quality of the
code. Optimizing the assignment algorithm can be the last priority.
● Evaluator will judge the extensibility and modularity of the design. For example : how
easy (minimal code changes) it is to add one more attribute,say, prioritize premium
customer, to be considered while assignment.