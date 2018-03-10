include env_make

all: build start test stop

mvn-build:
	mvn clean install -DskipTests

build: mvn-build
	cp ./target/$(FINAL_NAME) ./docker

start: build
	docker-compose up -d
	rm ./docker/$(FINAL_NAME)

test:
	mvn clean test

stop:
	docker-compose down



