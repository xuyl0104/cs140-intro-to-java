JAVAC = javac
FD_COMPILE = -d .
CP_COMPILE = -cp ./junit-platform-console-standalone-1.5.0.jar

JRE = java
JAR_RUN = -jar ./junit-platform-console-standalone-1.5.0.jar 
CP_RUN = -cp .
SCAN_RUN = --scan-classpath

COM_FLAGS = $(FD_COMPILE) $(CP_COMPILE)
RUN_FLAGS = $(JAR_RUN) $(CP_RUN) $(SCAN_RUN)

# List all your .java files here (source files, excluding header files)
SRC = *.java


all: class

class:
	$(JAVAC) $(COM_FLAGS) $(SRC)
	@echo "-----------DONE -------------"
 
junit:
	$(JRE) $(RUN_FLAGS)

main:
	$(JRE) exam01.Exam01Driver

