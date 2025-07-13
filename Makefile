JAVAC = javac
JAVA = java

SRC_DIR = src
BIN_DIR = bin
LIB_DIR = lib

# Find all .java files recursively
SOURCES := $(shell find $(SRC_DIR) -name "*.java")
CLASSES := $(SOURCES:$(SRC_DIR)/%.java=$(BIN_DIR)/%.class)

# Detect main class (first one with a main method)
MAIN_CLASS = main.Main

.PHONY: all run clean rebuild

all: $(CLASSES)

# Compile all .java files if any .class is out of date
$(BIN_DIR)/%.class: $(SOURCES)
	mkdir -p $(dir $@)
	$(JAVAC) -cp "$(LIB_DIR)/*" -d $(BIN_DIR) $(SOURCES)

run: all
	$(JAVA) -cp "$(BIN_DIR):$(LIB_DIR)/*" $(MAIN_CLASS)

clean:
	rm -rf $(BIN_DIR)

rebuild: clean all
