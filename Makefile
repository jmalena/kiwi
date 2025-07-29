JAVAC=javac
JAVA=java
JAR=jar

SRC_DIR=src
TEST_SRC_DIR=test
BUILD_DIR=build
TEST_BUILD_DIR=build/test-classes
LIB_DIR=lib
MANIFEST=manifest.mf
MAIN_JAR=$(BUILD_DIR)/kiwi.jar

CLASSPATH=$(LIB_DIR)/*:$(BUILD_DIR):$(TEST_BUILD_DIR)

.PHONY: all build test clean

all: build

build:
	@echo "Compiling source files..."
	mkdir -p $(BUILD_DIR)
	$(JAVAC) -d $(BUILD_DIR) $(shell find $(SRC_DIR) -name "*.java")
	@echo "Building JAR..."
	$(JAR) cfm $(MAIN_JAR) $(MANIFEST) -C $(BUILD_DIR) .

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
	rm -rf $(BUILD_DIR) $(TEST_BUILD_DIR)
