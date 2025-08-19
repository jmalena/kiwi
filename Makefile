JAVAC=javac
JAVA=java
JAR=jar

SRC_DIR=src
TEST_SRC_DIR=test
DIST_DIR=dist
TEST_BUILD_DIR=$(DIST_DIR)/test-classes
LIB_DIR=lib

MANIFEST=manifest.mf
VERSION=0.1.0
MAIN_JAR=$(DIST_DIR)/kiwi-$(VERSION).jar

CLASSPATH=$(LIB_DIR)/*:$(DIST_DIR):$(TEST_BUILD_DIR)

.PHONY: all build test clean

all: build

build:
	@echo "Compiling source files..."
	mkdir -p $(DIST_DIR)
	$(JAVAC) -d $(DIST_DIR) $(shell find $(SRC_DIR) -name "*.java")
	@echo "Building JAR..."
	$(JAR) cfm $(MAIN_JAR) $(MANIFEST) -C $(DIST_DIR) .

test: build
	@echo "Compiling test files..."
	mkdir -p $(TEST_BUILD_DIR)
	$(JAVAC) -cp "$(CLASSPATH)" -d $(TEST_BUILD_DIR) $(shell find $(TEST_SRC_DIR) -name "*.java")
	@echo "Running tests..."
	@for classfile in $(shell find $(TEST_BUILD_DIR)/test/kiwi -name '*Test.class'); do \
		class=$$(echo $$classfile | sed 's|$(TEST_BUILD_DIR)/||; s|/|.|g; s|.class$$||'); \
		echo "Running $$class"; \
		$(JAVA) -cp "$(CLASSPATH)" org.junit.runner.JUnitCore $$class; \
	done

clean:
	@echo "Cleaning build artifacts..."
	rm -rf $(DIST_DIR) $(TEST_BUILD_DIR)
