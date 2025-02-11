.PHONY: run

run:
	@echo "Running ./gradlew dockerBuildImage"
	@./gradlew dockerBuildImage --info --stacktrace
	@echo "Running docker-compose up -d"
	@docker-compose up -d