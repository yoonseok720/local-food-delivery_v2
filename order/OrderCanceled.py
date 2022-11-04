from AbstractEvent import AbstractEvent
import json
from datetime import datetime

class OrderCanceled(AbstractEvent):
    orderId : int
    
    def __init__(self):
        super().__init__()
        self.orderId = None

