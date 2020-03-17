start:
	\
	docker pull selenoid/android:10.0 && \
	docker-compose up -d --force-recreate
stop:
	docker-compose down --rmi all