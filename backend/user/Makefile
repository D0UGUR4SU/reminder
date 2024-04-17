make install:
	mvn -U clean install -DskipTest

make package:
	mvn clean package

make build-image:
	docker build -t user .

make run:
	docker run -d user
