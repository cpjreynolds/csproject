SOURCES := $(wildcard *.java)
ENTRYPOINT := Main

.PHONY: all
all:
	javac $(SOURCES)

.PHONY: run
run: all
	java $(ENTRYPOINT)

.PHONY: clean
clean:
	$(RM) *.class
