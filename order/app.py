from flask import Flask
import KafkaProcessor
from config import config_reader
import 주문Controller
import OrderController

config = config_reader.reader()

app = Flask(__name__)

sh = KafkaProcessor.streamhandler

app.register_blueprint(주문Controller.bp)
app.register_blueprint(OrderController.bp)
if __name__ == "__main__":
	sh.consumer.run()
	app.run(debug=True, port=int(config['port']))

