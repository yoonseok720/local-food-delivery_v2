from AbstractEvent import AbstractEvent
import json
from datetime import datetime

class Ordered(AbstractEvent):
    orderId : int
    menu : str
    qty : int
    
    def __init__(self):
        super().__init__()
        self.orderId = None
        self.menu = None
        self.qty = None

