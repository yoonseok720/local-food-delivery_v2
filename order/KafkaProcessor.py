from kafka import KafkaProducer
from flask_kafka import FlaskKafka
from threading import Event
import json
from config import config_reader
from PolicyHandler import whenever배달시작됨_주문상태변경
from PolicyHandler import wheneverDeliveryStarted_OrderStatusChange

class StreamHandler():
	
	def __init__(self):
		INTERRUPT_EVENT = Event()
		config = config_reader.reader()
		self.destination = config['destination']
		self.group_id = config['group_id']
		self.bootstrap_server = config['bootstrap_servers']
		self.producer = KafkaProducer(acks=0, compression_type='gzip', bootstrap_servers=[self.bootsrap_server], value_serializer=lambda x: json.dumps(x).encode('utf-8'))
		self.consumer = FlaskKafka(INTERRUPT_EVENT,
		         bootstrap_servers=[self.bootstrap_server],
		         group_id= self.group_id
		         )


	def produce(self, msg):
		self.producer.send(self.destination, value=msg)

streamhandler = StreamHandler()

@streamhandler.consumer.handle(streamhandler.destination)
def consume(msg):
    my_json = msg.value.decode('utf8').replace("'", '"')
    data = json.loads(my_json)
    if data['eventType'] == "배달시작됨":
        whenever배달시작됨_주문상태변경(data)
    if data['eventType'] == "DeliveryStarted":
        wheneverDeliveryStarted_OrderStatusChange(data)
