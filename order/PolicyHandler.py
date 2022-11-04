import util
import 주문DB
from 주문 import 주문
주문repository = 주문DB.repository

import OrderDB
from Order import Order
orderrepository = OrderDB.repository


from 배달시작됨 import 배달시작됨

def whenever배달시작됨_주문상태변경(data):
    event = 배달시작됨()
    event = util.AutoBinding(data, event)
    
    주문 = 주문()
    주문repository.save(주문)
    order = Order()
    orderrepository.save(order)
    
from DeliveryStarted import DeliveryStarted

def wheneverDeliveryStarted_OrderStatusChange(data):
    event = DeliveryStarted()
    event = util.AutoBinding(data, event)
    
    주문 = 주문()
    주문repository.save(주문)
    order = Order()
    orderrepository.save(order)
    

