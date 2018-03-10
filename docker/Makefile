include env_make

NS = ehms
REPO = mongomvc
VERSION = latest
NAME = mongomvc

all: build run

mvn-build:
	cd ..; \
	mvn clean install -DskipTests

build: mvn-build
	cp .././target/$(FINAL_NAME) .
	docker build -t $(NS)/$(REPO):$(VERSION) .
	rm ./$(FINAL_NAME)

run:
	docker run -d $(PORTS) --name $(NAME) $(NS)/$(REPO):$(VERSION)

start:
	docker start $(NAME)

stop:
	docker stop $(NAME)

rm: stop
	docker rm $(NAME)

rebuild: stop rm build run

push:
	docker login
	docker push $(NS)/$(REPO)
