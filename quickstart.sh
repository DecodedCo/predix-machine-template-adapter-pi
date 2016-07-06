
scriptRootDir=$(dirname $0)
machineHome="$1"
pathToPredixEdgeStarter="../../"

echo "Running adapter script automatically - GE XLP"

echo "#################### Build and setup the adatper for Raspberry PI start ####################"

cp $scriptRootDir/config/com.ge.predix.solsvc.workshop.adapter.config $machineHome/configuration/machine
cp $scriptRootDir/config/com.ge.predix.workshop.nodeconfig.json $machineHome/configuration/machine
cp $scriptRootDir/config/com.ge.dspmicro.hoover.spillway-0.config $machineHome/configuration/machine
cp $scriptRootDir/config/com.ge.dspmicro.httpriver.send-0.config $machineHome/configuration/machine
#Download dependencies code and build
git clone https://github.com/emoranchel/IoTDevices.git

mvn -q install:install-file -Dfile=IoTDevices/lib/dio.jar -DgroupId=jdk.dio -DartifactId=dio -Dversion=1.0 -Dpackaging=jar

mvn -q clean install -f IoTDevices/GrovePi-spec/pom.xml
mvn -q clean install -f IoTDevices/Pi-spec/pom.xml
mvn -q clean install -f IoTDevices/GrovePi-pi4j/pom.xml
mvn -q clean install -f IoTDevices/GrovePi-dio/pom.xml
mvn -q clean install -f IoTDevices/Pi-dio/pom.xml
mvn -q clean install -f IoTDevices/Pi-pi4j/pom.xml

mvn -q clean install -Dmaven.compiler.source=1.8 -Dmaven.compiler.target=1.8 -f $scriptRootDir/pom.xml

cp $scriptRootDir/config/solution.ini $machineHome/machine/bin/vms
echo "Copying cp $scriptRootDir/target/predix-machine-template-adapter-pi-1.0.jar $machineHome/machine/bundles"
cp $scriptRootDir/target/predix-machine-template-adapter-pi-1.0.jar $machineHome/machine/bundles
rm -rf IoTDevices

echo "#################### Build and setup the adatper for Raspberry PI end ####################"
