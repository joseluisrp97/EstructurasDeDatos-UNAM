PATH_TO_FX=/home/joseluisrp97/Escritorio/openjfx-19_linux-aarch64_bin-sdk/javafx-sdk-19/lib
	
BUILD_TEST=build.test

compile:
	javac --module-path $(PATH_TO_FX) --add-modules=javafx.controls,javafx.fxml -d ./build --source-path ./src src/ed/visualización/*.java
	javac --module-path $(PATH_TO_FX) --add-modules=javafx.controls,javafx.fxml -d ./build --source-path ./src src/ed/estructuras/**/*.java
	javac -d ./build.test -cp libs/hamcrest-core-1.3.jar:libs/junit-4.12.jar:build --source-path ./test test/ed/estructuras/*.java
	javac -d ./build.test -cp libs/hamcrest-core-1.3.jar:libs/junit-4.12.jar:build --source-path ./test test/ed/estructuras/**/*.java
	cp ./src/ed/visualización/arbolesscene.fxml ./build/ed/visualización/
	cp ./src/ed/visualización/styles.css ./build/ed/visualización/

run:
	java --module-path $(PATH_TO_FX) --add-modules=javafx.controls,javafx.fxml -classpath build ed.visualización.ApÁrboles
	
jtest:
	java -cp libs/hamcrest-core-1.3.jar:libs/junit-4.12.jar:build:build.test org.junit.runner.JUnitCore ed.estructuras.nolineales.NodoBOLigadoTest

.PHONY: clean
clean:
	rm -rf build
	rm -rf build.test
