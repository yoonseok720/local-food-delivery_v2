
from AbstractEvent import AbstractEvent
import json

class DeliveryStarted(AbstractEvent):
    id : int
    menu : str
    address : str
    orderId : str
    status : str
    
    def __init__(self):
        super().__init__()
        self.id = None
        self.menu = None
        self.address = None
        self.orderId = None
        self.status = None

