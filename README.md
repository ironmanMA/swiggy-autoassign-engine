
# swiggy-autoassign-engine
swiggy.com is a online food delivery service. 
it delivers > 10k orders per day through <400 delivery execs

to do achieve this optimization, it assigns a delivery to most optimal
delivery exec.

my algorithm here demonstrates such decision making at scale.

this algorithm brings down decision making to cost level and then pickup agent 
with least deliver effort.

also keeping in mind 
* reducing overall Exec time spent waiting for assignment
* also delivering items those "prime customers" on priority

but with enough data we could learn from historical patterns and reclassify zones. 


Limitations:
* Once order has been picked up, Exec wont take new orders.
* An Order is placed with items all at one restaurant